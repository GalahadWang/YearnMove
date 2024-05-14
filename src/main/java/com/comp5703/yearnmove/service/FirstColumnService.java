package com.comp5703.yearnmove.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5703.yearnmove.DTO.articleMainFilter;
import com.comp5703.yearnmove.pojo.FirstColumn;
import com.comp5703.yearnmove.pojo.MainData;

import java.util.List;

public interface FirstColumnService extends IService<FirstColumn> {
    List<FirstColumn> returnFirstColumn(articleMainFilter articleMainFilter);
}
