package com.comp5703.yearnmove.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5703.yearnmove.DTO.articleMainFilter;
import com.comp5703.yearnmove.pojo.Filter;

import java.util.List;

public interface FilterService extends IService<Filter> {
    List<Integer> returnRecordID(articleMainFilter articleMainFilter);
}
