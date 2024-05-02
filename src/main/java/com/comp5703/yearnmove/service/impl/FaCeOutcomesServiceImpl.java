package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.mapper.FaCeOutcomesMapper;
import com.comp5703.yearnmove.pojo.FaCeOutcomes;
import com.comp5703.yearnmove.service.FaCeOutcomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class FaCeOutcomesServiceImpl extends ServiceImpl<FaCeOutcomesMapper, FaCeOutcomes> implements FaCeOutcomesService {

    @Autowired
    private FaCeOutcomesMapper faCeOutcomesMapper;

    @Override
    public Map<String, String> calculateOutcomeRatios(List<Integer> recordIds){

        int totalRecords = 0;
        int totalCognitiveRecords = 0;
        int totalEmotionalRecords = 0;

        int cognitivePositiveTotal = 0;
        int emotionalPositiveTotal = 0;

        if (!recordIds.isEmpty()) {

            totalRecords = recordIds.size();

            List<FaCeOutcomes> outcomes = faCeOutcomesMapper.selectBatchIds(recordIds);

            for(FaCeOutcomes outcome : outcomes){

                totalCognitiveRecords+= outcome.getCognitiveOutcomes();
                totalEmotionalRecords+= outcome.getEmotionalOutcomes();

            }

            for (FaCeOutcomes outcome : outcomes) {

                cognitivePositiveTotal += outcome.getCognitivePositiveOutcomes() + outcome.getCognitivePositiveNonOutcomes();
                emotionalPositiveTotal += outcome.getEmotionalPositiveOutcomes() + outcome.getEmotionalPositiveNonOutcomes();

            }
        }
        Map<String, String> ratios = new HashMap<>();
        double cognitiveRatio = 0;
        double emotionalRatio = 0;


        if (totalRecords > 0) {
            if(totalCognitiveRecords != 0){
                cognitiveRatio = (double) cognitivePositiveTotal / totalCognitiveRecords;
            }

            if(totalEmotionalRecords != 0){
                emotionalRatio = (double) emotionalPositiveTotal / totalEmotionalRecords;
            }
            ratios.put("Cognitive", String.format("%.2f%%", cognitiveRatio * 100));
            ratios.put("Emotional", String.format("%.2f%%", emotionalRatio * 100));



            double overallRatio = (cognitiveRatio + emotionalRatio) / 2;
            ratios.put("Overall FA CE Outcome", String.format("%.2f%%", overallRatio * 100));
        }

        return ratios;
    }
}