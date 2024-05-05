package com.comp5703.yearnmove.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.comp5703.yearnmove.DTO.FigFiveFilter;
import com.comp5703.yearnmove.pojo.FigFive;

import java.util.List;

public interface FigFiveService extends IService<FigFive> {
    List<FigFive> returnArticleAll(FigFiveFilter figFive);
    List<FigFive> returnFirstColumn(FigFiveFilter figFive);
}
