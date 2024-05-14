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
        int totalMvpaRecords = 0;
        int totalUptimeRecords = 0;
        int totalTotalPaRecords = 0;
        int totalDomainPaRecords = 0;
        int mvpaPositiveTotal = 0;
        int upTimePositiveTotal = 0;
        int totalPAPositiveTotal = 0;
        int domainPAPositiveTotal = 0;

        if (!recordIds.isEmpty()) {
            System.out.println(recordIds);
//            System.out.println(paOutcomesMapper.selectBatchIds(recordIds));
            totalRecords = recordIds.size();

            // Call the selectBatchIds method of the paOutcomesMapper to get a list of PaOutcomes objects with the given recordIds
            List<PaOutcomes> outcomes = paOutcomesMapper.selectBatchIds(recordIds);
            // Loop through each PaOutcomes object in the list
            for(PaOutcomes outcome : outcomes){
                // Add the number of mVPA positive outcomes, Uptime positive outcomes, total PA positive outcomes, and domain positive outcomes to the corresponding variables
                totalMvpaRecords+= outcome.getMvpaOutcomes();
                totalUptimeRecords+= outcome.getUptimeOutcomes();
                totalTotalPaRecords+= outcome.getTotalPaOutcomes();
                totalDomainPaRecords+= outcome.getDomainOutcomes();
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
        double mvpaRatio = 0;
        double upTimeRatio = 0;
        double totalPARatio = 0;
        double domainPARatio = 0;
        if (totalRecords > 0) {
            if(totalMvpaRecords != 0){
                mvpaRatio = (double) mvpaPositiveTotal / totalMvpaRecords;
            }
            if(totalUptimeRecords != 0){
                upTimeRatio = (double) upTimePositiveTotal / totalUptimeRecords;
            }
            if(totalTotalPaRecords != 0){
                totalPARatio = (double) totalPAPositiveTotal / totalTotalPaRecords;
            }
            if(totalDomainPaRecords != 0){
                domainPARatio = (double) domainPAPositiveTotal / totalDomainPaRecords;
            }
            ratios.put("MVPA-Multicomponent Physical Activity", String.format("%.2f%%", mvpaRatio * 100));
            ratios.put("Up Time", String.format("%.2f%%", upTimeRatio * 100));
            ratios.put("Total PA-Total Physical Activity", String.format("%.2f%%", totalPARatio * 100));
            ratios.put("Domains of PA-Domains of Physical Activity", String.format("%.2f%%", domainPARatio * 100));


            double overallRatio = (mvpaRatio + upTimeRatio + totalPARatio + domainPARatio) / 4;
            ratios.put("Overall Outcome", String.format("%.2f%%", overallRatio * 100));
        }

        return ratios;
    }
}
