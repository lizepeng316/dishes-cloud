package com.etoak.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.etoak.entity.Dict;

import java.util.List;

public interface DictService extends IService<Dict> {

    List<Dict> getList(String type);
}
