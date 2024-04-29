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
        int totalRecords = recordIds.size();
        int mvpaPositiveTotal = 0;
        int upTimePositiveTotal = 0;
        int totalPAPositiveTotal = 0;
        int domainPAPositiveTotal = 0;

        if (!recordIds.isEmpty()) {
            System.out.println(recordIds);
            System.out.println(paOutcomesMapper.selectBatchIds(recordIds));
            System.out.println(paOutcomesMapper.selectBatchIds(recordIds));
            List<PaOutcomes> outcomes = paOutcomesMapper.selectBatchIds(recordIds);
            for (PaOutcomes outcome : outcomes) {
                mvpaPositiveTotal += outcome.getMvpaPostiveOutcomes() + outcome.getMvpaPostiveNonOutcomes();
                upTimePositiveTotal += outcome.getUptimePostiveOutcomes() + outcome.getUptimePostiveNonOutcomes();
                totalPAPositiveTotal += outcome.getTotalPaPostiveOutcomes() + outcome.getTotalPaPostiveNonOutcomes();
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
