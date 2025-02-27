package com.comp5703.yearnmove.controller;

import com.comp5703.yearnmove.DTO.articleMainFilter;
import com.comp5703.yearnmove.common.Result;
import com.comp5703.yearnmove.pojo.FallsOutcomes;
import com.comp5703.yearnmove.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @Autowired
    private FallsOutcomesService fallsOutcomesService;

    @Autowired
    private IntrinsicCapacityOutcomesService intrinsicCapacityOutcomesService;

    @Autowired
    private FaPhysicalOutcomesService faPhysicalOutcomesService;

    @Autowired
    private FaSocialOutcomesService faSocialOutcomesService;

    @Autowired
    private FaCeOutcomesService faCeOutcomesService;

    @Autowired
    private WellbeingOutcomesService wellbeingOutcomesService;

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
        System.out.println(articleMainFilter);
        List<Integer> recordIds = filterService.returnRecordID(articleMainFilter);

        if (recordIds == null || recordIds.isEmpty()) {
            Map<String, String> ratios = new HashMap<>();
            double overallRatio =0;
            ratios.put("Overall Outcome", String.format("%.2f%%", overallRatio * 100));
            return Result.error(ratios,"No records found");
        }
//        Map<String, String> outcomes = 0;
        if(articleMainFilter.getPaOutcomesReported()!= null){
            Map<String, String> outcomes = paOutcomesService.calculateOutcomeRatios(recordIds);
            return Result.success(outcomes, "success");
        }
        if(articleMainFilter.getFallsOutcomesReported()!=null){
            Map<String, String> outcomes = fallsOutcomesService.calculateOutcomeRatios(recordIds);
            return Result.success(outcomes, "success");
        }
        if(articleMainFilter.getIntrinsicCapacityPhysicalDomainOutcomesReported()!=null){
            Map<String, String> outcomes = intrinsicCapacityOutcomesService.calculateOutcomeRatios(recordIds);
            return Result.success(outcomes, "success");
        }
        if(articleMainFilter.getFaPhysicalDomainOutcomesReported()!=null){
            Map<String, String> outcomes = faPhysicalOutcomesService.calculateOutcomeRatios(recordIds);
            return Result.success(outcomes, "success");
        }
        if(articleMainFilter.getFaSocialDomainOutcomesReported()!=null){
            Map<String, String> outcomes = faSocialOutcomesService.calculateOutcomeRatios(recordIds);
            return Result.success(outcomes, "success");
        }
        if(articleMainFilter.getFaCognitiveEmotionalDomainOutcomesReported()!=null){
            Map<String, String> outcomes = faCeOutcomesService.calculateOutcomeRatios(recordIds);
            return Result.success(outcomes, "success");
        }
        if(articleMainFilter.getWellbeingAndQualityOfLifeOutcomesReported()!=null){
            Map<String, String> outcomes = wellbeingOutcomesService.calculateOutcomeRatios(recordIds);
            return Result.success(outcomes, "success");
        }
        return Result.error("You can only select one opinion");
    }

}
