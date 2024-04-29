package com.comp5703.yearnmove.controller;

import com.comp5703.yearnmove.DTO.articleMainFilter;
import com.comp5703.yearnmove.common.Result;
import com.comp5703.yearnmove.service.FilterService;
import com.comp5703.yearnmove.service.PaOutcomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "*", maxAge = 3600)
public class Article {
    @Autowired
    private FilterService filterService;

    @Autowired
    private PaOutcomesService paOutcomesService;

    @PostMapping("/find")
    public Result<List<Integer>> ArticleRocordId(@RequestBody articleMainFilter articleMainFilter){
        List<Integer> result = filterService.returnRecordID(articleMainFilter);
        if(result != null){
            return Result.success(result,"success");
        }
        return Result.error("No");
    }
    @PostMapping("/calculateOutcomes")
    public Result<Map<String, String>> calculateOutcomes(@RequestBody articleMainFilter articleMainFilter) {
        List<Integer> recordIds = filterService.returnRecordID(articleMainFilter);
        if (recordIds == null || recordIds.isEmpty()) {
            return Result.error("No records found.");
        }
        Map<String, String> outcomes = paOutcomesService.calculateOutcomeRatios(recordIds);
        return Result.success(outcomes, "success");
    }

}
