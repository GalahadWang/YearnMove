package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.mapper.FallsOutcomesMapper;
import com.comp5703.yearnmove.pojo.FallsOutcomes;
import com.comp5703.yearnmove.service.FallsOutcomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class FallsOutcomesServiceImpl extends ServiceImpl<FallsOutcomesMapper, FallsOutcomes> implements FallsOutcomesService {
    @Autowired
    private FallsOutcomesMapper fallsOutcomesMapper;

    @Override
    public Map<String, String> calculateOutcomeRatios(List<Integer> recordIds){
        int totalRecords = 0;
        int totalRofRecords = 0;
        int totalFriRecords = 0;
        int rofPositiveTotal = 0;
        int friPositiveTotal = 0;

        if (!recordIds.isEmpty()) {
            totalRecords = recordIds.size();

            List<FallsOutcomes> outcomes = fallsOutcomesMapper.selectBatchIds(recordIds);
            // Loop through each PaOutcomes object in the list
            for(FallsOutcomes outcome : outcomes){

                totalRofRecords+= outcome.getRofOutcomes();
                totalFriRecords+= outcome.getFriOutcomes();
            }


            for (FallsOutcomes outcome : outcomes) {

                rofPositiveTotal += outcome.getRofPostiveOutcomes() + outcome.getRofPostiveNonOutcomes();

                friPositiveTotal += outcome.getFriPostiveOutcomes() + outcome.getFriPostiveNonOutcomes();
            }
        }

        Map<String, String> ratios = new HashMap<>();
        double rofRatio = 0;
        double friRatio = 0;
        if (totalRecords > 0) {
            if(totalRofRecords != 0){
                rofRatio = (double) rofPositiveTotal / totalRofRecords;
            }
            if(totalFriRecords != 0){
                friRatio = (double) friPositiveTotal / totalFriRecords;
            }

            ratios.put("Rate of Falls", String.format("%.2f%%", rofRatio * 100));
            ratios.put("Fall-related injuries", String.format("%.2f%%", friRatio * 100));



            double overallRatio = (rofRatio + friRatio ) / 2;
            ratios.put("Overall Outcome", String.format("%.2f%%", overallRatio * 100));
        }

        return ratios;
    }
}