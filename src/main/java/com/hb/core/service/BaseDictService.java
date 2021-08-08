package com.hb.core.service;

import com.hb.core.po.BaseDict;

import java.util.List;

public interface BaseDictService {
    /**
     * 数据字典service接口
     */

    public List<BaseDict> findBaseDictByTypeCode(String typecode);
}
