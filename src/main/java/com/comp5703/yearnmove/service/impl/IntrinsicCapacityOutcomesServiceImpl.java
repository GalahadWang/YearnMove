package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.mapper.IntrinsicCapacityOutcomesMapper;
import com.comp5703.yearnmove.pojo.IntrinsicCapacityOutcomes;
import com.comp5703.yearnmove.service.IntrinsicCapacityOutcomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service

public class IntrinsicCapacityOutcomesServiceImpl extends ServiceImpl<IntrinsicCapacityOutcomesMapper, IntrinsicCapacityOutcomes> implements IntrinsicCapacityOutcomesService {
    @Autowired
    private IntrinsicCapacityOutcomesMapper intrinsicCapacityOutcomesMapper;

    @Override
    public Map<String, String> calculateOutcomeRatios(List<Integer> recordIds) {

        int totalRecords = 0;
        int totalBmdRecords = 0;
        int totalBcRecords = 0;
        int totalCiRecords = 0;
        int totalStrengthRecords = 0;
        int totalFitnessRecords = 0;
        int totalPainRecords = 0;
        int totalOtherRecords = 0;

        int bmdPositiveTotal = 0;
        int bcPositiveTotal = 0;
        int ciPositiveTotal = 0;
        int strengthPositiveTotal = 0;
        int fitnessPositiveTotal = 0;
        int painPositiveTotal = 0;
        int otherPositiveTotal = 0;


        if (!recordIds.isEmpty()) {
            totalRecords = recordIds.size();

            List<IntrinsicCapacityOutcomes> outcomes = intrinsicCapacityOutcomesMapper.selectBatchIds(recordIds);

            for (IntrinsicCapacityOutcomes outcome : outcomes) {

                totalBmdRecords += outcome.getBmdOutcomes();
                totalBcRecords += outcome.getBcOutcomes();
                totalCiRecords += outcome.getCiOutcomes();
                totalStrengthRecords += outcome.getStrengthOutcomes();
                totalFitnessRecords += outcome.getFitnessOutcomes();
                totalPainRecords += outcome.getPainOutcomes();
                totalOtherRecords += outcome.getOtherOutcomes();
            }

            for (IntrinsicCapacityOutcomes outcome : outcomes) {

                bmdPositiveTotal += outcome.getBmdPositiveOutcomes() + outcome.getBmdPositiveNonOutcomes();

                bcPositiveTotal += outcome.getBcPositiveOutcomes() + outcome.getBcPositiveNonOutcomes();

                ciPositiveTotal += outcome.getCiPositiveOutcomes() + outcome.getCiPositiveNonOutcomes();

                strengthPositiveTotal += outcome.getStrengthPositiveOutcomes() + outcome.getStrengthPositiveNonOutcomes();

                fitnessPositiveTotal += outcome.getFitnessPositiveOutcomes() + outcome.getFitnessPositiveNonOutcomes();

                painPositiveTotal += outcome.getPainPositiveOutcomes() + outcome.getPainPositiveNonOutcomes();

                otherPositiveTotal += outcome.getOtherPositiveOutcomes() + outcome.getOtherPositiveNonOutcomes();

            }
        }
        Map<String, String> ratios = new HashMap<>();
        double bmdRatio = 0;
        double bcRatio = 0;
        double ciRatio = 0;
        double strengthRatio = 0;
        double fitnessRatio = 0;
        double painRatio = 0;
        double otherRatio = 0;
        if (totalRecords > 0) {


            if (totalBmdRecords != 0) {
                bmdRatio = (double) bmdPositiveTotal / totalBmdRecords;
            }
            if (totalBcRecords != 0) {
                bcRatio = (double) bcPositiveTotal / totalBcRecords;
            }
            if (totalCiRecords != 0) {
                ciRatio = (double) ciPositiveTotal / totalCiRecords;
            }
            if (totalStrengthRecords != 0) {
                strengthRatio = (double) strengthPositiveTotal / totalStrengthRecords;
            }
            if (totalFitnessRecords != 0) {
                fitnessRatio = (double) fitnessPositiveTotal / totalFitnessRecords;
            }
            if (totalPainRecords != 0) {
                painRatio = (double) painPositiveTotal / totalPainRecords;
            }
            if (totalOtherRecords != 0) {
                otherRatio = (double) otherPositiveTotal / totalOtherRecords;
            }
            ratios.put("Bone Mineral Density", String.format("%.2f%%", bmdRatio * 100));
            ratios.put("Body composition", String.format("%.2f%%", bcRatio * 100));
            ratios.put("Cardiometabolic indicator", String.format("%.2f%%", ciRatio * 100));
            ratios.put("Strength", String.format("%.2f%%", strengthRatio * 100));
            ratios.put("Fitness", String.format("%.2f%%", fitnessRatio * 100));
            ratios.put("Pain", String.format("%.2f%%", painRatio * 100));
            ratios.put("Other", String.format("%.2f%%", otherRatio * 100));


            double overallRatio = (bmdRatio + bcRatio + ciRatio + strengthRatio + fitnessRatio + painRatio + otherRatio) / 7;
            ratios.put("Overall Intrinsic Capacity Outcome", String.format("%.2f%%", overallRatio * 100));
        }

        return ratios;
    }


}




