package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.mapper.WellbeingOutcomesMapper;
import com.comp5703.yearnmove.pojo.WellbeingOutcomes;
import com.comp5703.yearnmove.service.WellbeingOutcomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class WellbeingOutcomesServiceImpl extends ServiceImpl<WellbeingOutcomesMapper, WellbeingOutcomes> implements WellbeingOutcomesService {

    @Autowired
    private WellbeingOutcomesMapper wellbeingOutcomesMapper;

    @Override
    public Map<String, String> calculateOutcomeRatios(List<Integer> recordIds){

        int totalRecords = 0;
        int totalWellbeingAndQoLRecords = 0;

        int wellbeingAndQoLPositiveTotal = 0;

        if (!recordIds.isEmpty()) {

            totalRecords = recordIds.size();

            List<WellbeingOutcomes> outcomes = wellbeingOutcomesMapper.selectBatchIds(recordIds);

            for(WellbeingOutcomes outcome : outcomes){

                totalWellbeingAndQoLRecords+= outcome.getWellbeingAndQoLOutcomes();

            }

            for (WellbeingOutcomes outcome : outcomes) {

                wellbeingAndQoLPositiveTotal += outcome.getWellbeingAndQoLPositiveOutcomes() + outcome.getWellbeingAndQoLPositiveNonOutcomes();
            }
        }
        Map<String, String> ratios = new HashMap<>();
        double wellbeingAndQoLRatio = 0;

        if (totalRecords > 0) {
            if(totalWellbeingAndQoLRecords != 0){
                wellbeingAndQoLRatio = (double) wellbeingAndQoLPositiveTotal / totalWellbeingAndQoLRecords;
            }

            ratios.put("MVPA", String.format("%.2f%%", wellbeingAndQoLRatio * 100));

            double overallRatio = wellbeingAndQoLRatio ;
            ratios.put("Overall Wellbeing Outcome", String.format("%.2f%%", overallRatio * 100));
        }

        return ratios;
    }


}
