package com.comp5703.yearnmove.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5703.yearnmove.DTO.articleMainFilter;
import com.comp5703.yearnmove.pojo.FirstColumn;
import com.comp5703.yearnmove.pojo.SpecialValue;

import java.util.List;

public interface SpecialValueService extends IService<SpecialValue> {
    List<SpecialValue> returnSpecialValue(Integer number);
}
