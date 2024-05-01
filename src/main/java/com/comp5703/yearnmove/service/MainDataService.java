package com.comp5703.yearnmove.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5703.yearnmove.DTO.articleMainFilter;
import com.comp5703.yearnmove.common.Result;
import com.comp5703.yearnmove.pojo.MainData;

import java.awt.*;
import java.util.List;

public interface MainDataService extends IService<MainData> {
    List<MainData> returnArticleAll(articleMainFilter articleMainFilter);
    List<MainData> returnFirstColumn(articleMainFilter articleMainFilter);
}
