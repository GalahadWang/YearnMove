package com.comp5703.yearnmove.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.comp5703.yearnmove.DTO.CircleNum;
import com.comp5703.yearnmove.DTO.FigFiveFilter;
import com.comp5703.yearnmove.DTO.articleMainFilter;
import com.comp5703.yearnmove.common.Result;
import com.comp5703.yearnmove.pojo.FigFive;
import com.comp5703.yearnmove.pojo.FirstColumn;
import com.comp5703.yearnmove.pojo.MainData;
import com.comp5703.yearnmove.pojo.SpecialValue;
import com.comp5703.yearnmove.service.FigFiveService;
import com.comp5703.yearnmove.service.FirstColumnService;
import com.comp5703.yearnmove.service.MainDataService;
import com.comp5703.yearnmove.service.SpecialValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maindata")
@CrossOrigin(origins = "*", maxAge = 3600)

public class MainDataController {
    @Autowired
    private MainDataService mainDataService;

    @Autowired
    private FirstColumnService firstColumnService;

    @Autowired
    private FigFiveService figFiveService;

    @Autowired
    private SpecialValueService specialValueService;

    @PostMapping("/test")
    public Result<MainData> FindById(@RequestBody MainData mainData){
        System.out.println(mainData);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("record_id",mainData.getRecordId());
        MainData result = mainDataService.getOne(wrapper);
        if(result != null)
            return Result.success(result,"Return the answer");
        return Result.error("Don't find the result");
    }

    @PostMapping("/mainSearch")
    public Result<List<MainData>> searchArticles(@RequestBody articleMainFilter articleMainFilter){
        List<MainData> ArticleList= mainDataService.returnArticleAll(articleMainFilter);
        if(ArticleList != null){
            System.out.println(ArticleList);
            return Result.success(ArticleList,"success");
        }
        return Result.error("No");
    }

//    @PostMapping("/mainSearchFirstColumn")
//    public Result<List<MainData>> searchFisrtColumnArticles(@RequestBody articleMainFilter articleMainFilter){
//        List<MainData> ArticleList= mainDataService.returnFirstColumn(articleMainFilter);
//        if(ArticleList != null){
//            System.out.println(ArticleList);
//            return Result.success(ArticleList,"success");
//        }
//        return Result.error("No");
//    }
    @PostMapping("/mainSearchFirstColumn")
    public Result<List<FirstColumn>> searchFisrtColumnArticles(@RequestBody articleMainFilter articleMainFilter){
        List<FirstColumn> ArticleList= firstColumnService.returnFirstColumn(articleMainFilter);
        if(ArticleList != null){
//            System.out.println(ArticleList);
            return Result.success(ArticleList,"success");
        }
        return Result.error("No");
    }

    @PostMapping("/specialValue")
    public Result<List<SpecialValue>> searchFisrtColumnArticles(@RequestBody CircleNum circlenumber){
        List<SpecialValue> ArticleList=specialValueService.returnSpecialValue(circlenumber);
        if(ArticleList != null){
//            System.out.println(ArticleList);
            return Result.success(ArticleList,"success");
        }
        return Result.error("No");
    }

    @PostMapping("/figFive")
    public Result<List<FigFive>> searchFigFiveArticles(@RequestBody FigFiveFilter figFive){
        System.out.println(figFive);
        List<FigFive> ArticleList = figFiveService.returnArticleAll(figFive);
        if(ArticleList != null){
            System.out.println(ArticleList);
            return Result.success(ArticleList,"success");
        }
        return Result.error("No");
    }

    @PostMapping("/figFiveFirstColumn")
    public Result<List<FigFive>> searchFigFiveFirstColumnArticles(@RequestBody FigFiveFilter figFive){
        System.out.println(figFive);
        List<FigFive> ArticleList = figFiveService.returnFirstColumn(figFive);
        if(ArticleList != null){
            System.out.println(ArticleList);
            return Result.success(ArticleList,"success");
        }
        return Result.error("No");
    }
}
