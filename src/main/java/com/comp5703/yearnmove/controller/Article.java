package com.comp5703.yearnmove.controller;

import com.comp5703.yearnmove.DTO.articleMainFilter;
import com.comp5703.yearnmove.common.Result;
import com.comp5703.yearnmove.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "*", maxAge = 3600)
public class Article {
    @Autowired
    private FilterService filterService;
    @PostMapping("/find")
    public Result<List<Integer>> ArticleRocordId(@RequestBody articleMainFilter articleMainFilter){
        List<Integer> result = filterService.returnRecordID(articleMainFilter);
        if(result != null){
            return Result.success(result,"success");
        }
        return Result.error("No");
    }
}
