package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.mapper.FaPhysicalOutcomesMapper;
import com.comp5703.yearnmove.pojo.FaPhysicalOutcomes;
import com.comp5703.yearnmove.service.FaPhysicalOutcomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service

public class FaPhysicalOutcomesServiceImpl extends ServiceImpl<FaPhysicalOutcomesMapper, FaPhysicalOutcomes> implements FaPhysicalOutcomesService {
    @Autowired
    private FaPhysicalOutcomesMapper faPhysicalOutcomesMapper;

    @Override
    public Map<String, String> calculateOutcomeRatios(List<Integer> recordIds) {

        int totalRecords = 0;
        int totalMobilityBalanceRecords = 0;
        int totalSelfCareRecords = 0;
        int totalOverallFunctionRecords = 0;
        int totalOtherRecords = 0;


        int mobilityBalancePositiveTotal = 0;
        int selfCarePositiveTotal = 0;
        int overallFunctionPositiveTotal = 0;
        int otherPositiveTotal = 0;



        if (!recordIds.isEmpty()) {
            totalRecords = recordIds.size();

            List<FaPhysicalOutcomes> outcomes = faPhysicalOutcomesMapper.selectBatchIds(recordIds);

            for (FaPhysicalOutcomes outcome : outcomes) {

                totalMobilityBalanceRecords += outcome.getMobilityBalanceOutcomes();
                totalSelfCareRecords += outcome.getSelfCareOutcomes();
                totalOverallFunctionRecords += outcome.getOverallFunctionOutcomes();
                totalOtherRecords += outcome.getOtherOutcomes();

            }

            for (FaPhysicalOutcomes outcome : outcomes) {

                mobilityBalancePositiveTotal += outcome.getMobilityBalancePostiveOutcomes() + outcome.getMobilityBalancePostiveNonOutcomes();

                selfCarePositiveTotal += outcome.getSelfCarePostiveOutcomes() + outcome.getSelfCarePostiveNonOutcomes();

                overallFunctionPositiveTotal += outcome.getOverallFunctionPostiveOutcomes() + outcome.getOverallFunctionPostiveNonOutcomes();

                otherPositiveTotal += outcome.getOtherPostiveOutcomes() + outcome.getOtherPostiveNonOutcomes();


            }
        }
        Map<String, String> ratios = new HashMap<>();
        double mobilityBalanceRatio = 0;
        double selfCareRatio = 0;
        double overallFunctionRatio = 0;
        double otherRatio = 0;

        if (totalRecords > 0) {


            if (totalMobilityBalanceRecords != 0) {
                mobilityBalanceRatio = (double) mobilityBalancePositiveTotal / totalMobilityBalanceRecords;
            }
            if (totalSelfCareRecords != 0) {
                selfCareRatio = (double) selfCarePositiveTotal / totalSelfCareRecords;
            }
            if (totalOverallFunctionRecords != 0) {
                overallFunctionRatio = (double) overallFunctionPositiveTotal / totalOverallFunctionRecords;
            }
            if (totalOtherRecords != 0) {
                otherRatio = (double) otherPositiveTotal / totalOtherRecords;
            }
            ratios.put("Mobility & Balance", String.format("%.2f%%", mobilityBalanceRatio * 100));
            ratios.put("Self Care", String.format("%.2f%%", selfCareRatio * 100));
            ratios.put("Overall Function", String.format("%.2f%%", overallFunctionRatio * 100));
            ratios.put("Other", String.format("%.2f%%", otherRatio * 100));


            double overallRatio = (mobilityBalanceRatio + selfCareRatio + overallFunctionRatio + otherRatio ) / 4;
            ratios.put("Overall Outcome", String.format("%.2f%%", overallRatio * 100));
        }

        return ratios;
    }


}

