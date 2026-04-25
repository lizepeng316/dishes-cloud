package com.etoak.controller;

import com.etoak.common.core.vo.ResultVO;
import com.etoak.entity.Dict;
import com.etoak.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dicts")
public class DictController {
    DictService dictService;

    public DictController(DictService dictService) {
        this.dictService = dictService;
    }

    @GetMapping
    public ResultVO<List<Dict>> list(@RequestParam String type){
        List<Dict> list = dictService.getList(type);
        return ResultVO.success(list);
    }
}
