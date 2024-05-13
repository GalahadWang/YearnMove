package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.mapper.FaSocialOutcomesMapper;
import com.comp5703.yearnmove.pojo.FaSocialOutcomes;
import com.comp5703.yearnmove.service.FaSocialOutcomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class FaSocialOutcomesServiceImpl extends ServiceImpl<FaSocialOutcomesMapper, FaSocialOutcomes> implements FaSocialOutcomesService {

    @Autowired
    private FaSocialOutcomesMapper faSocialOutcomesMapper;

    @Override
    public Map<String, String> calculateOutcomeRatios(List<Integer> recordIds){

        int totalRecords = 0;
        int totalSocialDomainRecords = 0;

        int socialDomainPositiveTotal = 0;

        if (!recordIds.isEmpty()) {

            totalRecords = recordIds.size();

            List<FaSocialOutcomes> outcomes = faSocialOutcomesMapper.selectBatchIds(recordIds);

            for(FaSocialOutcomes outcome : outcomes){

                totalSocialDomainRecords+= outcome.getSocialDomainOutcomes();

            }

            for (FaSocialOutcomes outcome : outcomes) {

                socialDomainPositiveTotal += outcome.getSocialDomainPositiveOutcomes() + outcome.getSocialDomainPositiveNonOutcomes();
            }
        }
        Map<String, String> ratios = new HashMap<>();
        double socialDomainRatio = 0;

        if (totalRecords > 0) {
            if(totalSocialDomainRecords != 0){
                socialDomainRatio = (double) socialDomainPositiveTotal / totalSocialDomainRecords;
            }

//            ratios.put("MVPA", String.format("%.2f%%", socialDomainRatio * 100));

            double overallRatio = socialDomainRatio ;
            ratios.put("Overall Outcome", String.format("%.2f%%", overallRatio * 100));
        }

        return ratios;
    }


}
