package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.mapper.PaOutcomesMapper;
import com.comp5703.yearnmove.pojo.PaOutcomes;
import com.comp5703.yearnmove.service.PaOutcomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class PaOutcomesServiceImpl extends ServiceImpl<PaOutcomesMapper, PaOutcomes> implements PaOutcomesService {
    @Autowired
    private PaOutcomesMapper paOutcomesMapper;

    @Override
    public Map<String, String> calculateOutcomeRatios(List<Integer> recordIds){
        // Initialize variables to store the total number of records, mVPA positive outcomes, Uptime positive outcomes, total PA positive outcomes, and domain positive outcomes
        int totalRecords = 0;
        int mvpaPositiveTotal = 0;
        int upTimePositiveTotal = 0;
        int totalPAPositiveTotal = 0;
        int domainPAPositiveTotal = 0;

        if (!recordIds.isEmpty()) {
            System.out.println(recordIds);
            System.out.println(paOutcomesMapper.selectBatchIds(recordIds));

            // Call the selectBatchIds method of the paOutcomesMapper to get a list of PaOutcomes objects with the given recordIds
            List<PaOutcomes> outcomes = paOutcomesMapper.selectBatchIds(recordIds);
            // Loop through each PaOutcomes object in the list
            for(PaOutcomes outcome : outcomes){
                // Add the number of mVPA positive outcomes, Uptime positive outcomes, total PA positive outcomes, and domain positive outcomes to the corresponding variables
                totalRecords+= outcome.getMvpaOutcomes() + outcome.getUptimeOutcomes()
                                + outcome.getTotalPaOutcomes() + outcome.getDomainOutcomes();
            }
            // Loop through each PaOutcomes object in the list
            for (PaOutcomes outcome : outcomes) {
                // Add the number of mVPA positive outcomes and mVPA positive non-outcomes to the mvpaPositiveTotal variable
                mvpaPositiveTotal += outcome.getMvpaPostiveOutcomes() + outcome.getMvpaPostiveNonOutcomes();
                // Add the number of Uptime positive outcomes and Uptime positive non-outcomes to the upTimePositiveTotal variable
                upTimePositiveTotal += outcome.getUptimePostiveOutcomes() + outcome.getUptimePostiveNonOutcomes();
                // Add the number of total PA positive outcomes and total PA positive non-outcomes to the totalPAPositiveTotal variable
                totalPAPositiveTotal += outcome.getTotalPaPostiveOutcomes() + outcome.getTotalPaPostiveNonOutcomes();
                // Add the number of domain positive outcomes and domain positive non-outcomes to the domainPAPositiveTotal variable
                domainPAPositiveTotal += outcome.getDomainPositiveOutcomes() + outcome.getDomainPositiveNonOutcomes();
            }
        }

        Map<String, String> ratios = new HashMap<>();
        if (totalRecords > 0) {
            double mvpaRatio = (double) mvpaPositiveTotal / totalRecords;
            double upTimeRatio = (double) upTimePositiveTotal / totalRecords;
            double totalPARatio = (double) totalPAPositiveTotal / totalRecords;
            double domainPARatio = (double) domainPAPositiveTotal / totalRecords;

            ratios.put("MVPA", String.format("%.2f%%", mvpaRatio * 100));
            ratios.put("Up Time", String.format("%.2f%%", upTimeRatio * 100));
            ratios.put("Total PA", String.format("%.2f%%", totalPARatio * 100));
            ratios.put("Domains of PA", String.format("%.2f%%", domainPARatio * 100));

            // 计算总体比例
            double overallRatio = (mvpaRatio + upTimeRatio + totalPARatio + domainPARatio) / 4;
            ratios.put("Overall PA Outcome", String.format("%.2f%%", overallRatio * 100));
        }

        return ratios;
    }
}
