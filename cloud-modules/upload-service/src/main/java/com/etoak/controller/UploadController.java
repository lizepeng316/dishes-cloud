package com.etoak.controller;

import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.etoak.common.core.properties.UploadProperties;
import com.etoak.common.core.vo.ResultVO;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/upload")
public class UploadController {

    UploadProperties uploadProperties;

    public UploadController(UploadProperties uploadProperties) {
        this.uploadProperties = uploadProperties;
    }

    @PostMapping("/image")
    public ResultVO<String> upload(MultipartFile pic) throws IOException {
        if (ObjectUtils.isEmpty(pic) || pic.isEmpty()) {
            return ResultVO.failed("文件不能为空");
        }

        if (!uploadProperties.getTypes().contains(pic.getContentType())) {
            String types = uploadProperties.getTypes().stream()
                    .map(type -> type.substring(type.lastIndexOf(StrUtil.SLASH) + 1))
                    .collect(Collectors.joining("、"));
            return ResultVO.failed("仅支持" + types + "格式的图片");
        }

        String suffix = FileNameUtil.getSuffix(pic.getOriginalFilename());
        String fileName = IdUtil.simpleUUID() + StrUtil.DOT + suffix;

        File uploadDir = new File(uploadProperties.getLocation());
        uploadDir.mkdirs();

        File dest = new File(uploadDir, fileName);

        pic.transferTo(dest);

        String path = uploadProperties.getMapping().endsWith(StrUtil.SLASH) ?
                uploadProperties.getMapping() + fileName :
                uploadProperties.getMapping() + StrUtil.SLASH + fileName;

        return ResultVO.success(path);
    }
}
