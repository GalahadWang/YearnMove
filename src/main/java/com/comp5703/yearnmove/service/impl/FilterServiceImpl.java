package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.DTO.articleMainFilter;
import com.comp5703.yearnmove.mapper.FilterMapper;
import com.comp5703.yearnmove.pojo.Filter;
import com.comp5703.yearnmove.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilterServiceImpl extends ServiceImpl<FilterMapper, Filter> implements FilterService {
    private FilterMapper filterMapper;
    @Autowired
    public FilterServiceImpl(FilterMapper filterMapper){
        this.filterMapper = filterMapper;
    }
    @Override
    public List<Integer> returnRecordID(articleMainFilter articleMainFilter){
        QueryWrapper<Filter> queryWrapper = new QueryWrapper<>();
        if(articleMainFilter.getPhysImpAsInclusionCriterion() != null && !articleMainFilter.getPhysImpAsInclusionCriterion().isEmpty()){
            queryWrapper.in("physImp_as_inclusion_criterion",articleMainFilter.getPhysImpAsInclusionCriterion());
        }
        // CogImpLowMood_as_inclusion_criterion condition
        if (articleMainFilter.getCogImpLowMoodAsInclusionCriterion() != null && !articleMainFilter.getCogImpLowMoodAsInclusionCriterion().isEmpty()) {
            queryWrapper.in("CogImpLowMood_as_inclusion_criterion", articleMainFilter.getCogImpLowMoodAsInclusionCriterion());
        }

        // type_of_PA condition
        if (articleMainFilter.getTypeOfPA() != null && !articleMainFilter.getTypeOfPA().isEmpty()) {
            queryWrapper.in("type_of_PA", articleMainFilter.getTypeOfPA());
        }

        // type_of_PA_description condition
        if (articleMainFilter.getTypeOfPADescription() != null && !articleMainFilter.getTypeOfPADescription().isEmpty()) {
            queryWrapper.in("type_of_PA_description", articleMainFilter.getTypeOfPADescription());
        }

        // primary_location condition
        if (articleMainFilter.getPrimaryLocation() != null && !articleMainFilter.getPrimaryLocation().isEmpty()) {
            queryWrapper.in("primary_location", articleMainFilter.getPrimaryLocation());
        }

        // PA_outcomes_reported condition
        if (articleMainFilter.getPaOutcomesReported() != null && !articleMainFilter.getPaOutcomesReported().isEmpty()) {
            queryWrapper.in("PA_outcomes_reported", articleMainFilter.getPaOutcomesReported());
        }

        // falls_outcomes_reported condition
        if (articleMainFilter.getFallsOutcomesReported() != null && !articleMainFilter.getFallsOutcomesReported().isEmpty()) {
            queryWrapper.in("falls_outcomes_reported", articleMainFilter.getFallsOutcomesReported());
        }

        // Intrinsic_capacity_Physical_domain_outcomes_reported condition
        if (articleMainFilter.getIntrinsicCapacityPhysicalDomainOutcomesReported() != null && !articleMainFilter.getIntrinsicCapacityPhysicalDomainOutcomesReported().isEmpty()) {
            queryWrapper.in("Intrinsic_capacity_Physical_domain_outcomes_reported", articleMainFilter.getIntrinsicCapacityPhysicalDomainOutcomesReported());
        }

        // FA_Physical_domain_outcomes_reported condition
        if (articleMainFilter.getFaPhysicalDomainOutcomesReported() != null && !articleMainFilter.getFaPhysicalDomainOutcomesReported().isEmpty()) {
            queryWrapper.in("FA_Physical_domain_outcomes_reported", articleMainFilter.getFaPhysicalDomainOutcomesReported());
        }

        // FA_Social_domain_outcomes_reported condition
        if (articleMainFilter.getFaSocialDomainOutcomesReported() != null && !articleMainFilter.getFaSocialDomainOutcomesReported().isEmpty()) {
            queryWrapper.in("FA_Social_domain_outcomes_reported", articleMainFilter.getFaSocialDomainOutcomesReported());
        }

        // FA_cognitive_emotional_domain_outcomes_reported condition
        if (articleMainFilter.getFaCognitiveEmotionalDomainOutcomesReported() != null && !articleMainFilter.getFaCognitiveEmotionalDomainOutcomesReported().isEmpty()) {
            queryWrapper.in("FA_cognitive_emotional_domain_outcomes_reported", articleMainFilter.getFaCognitiveEmotionalDomainOutcomesReported());
        }

        // wellbeingAndQualityOfLifeOutcomesReported condition
        if (articleMainFilter.getWellbeingAndQualityOfLifeOutcomesReported() != null && !articleMainFilter.getWellbeingAndQualityOfLifeOutcomesReported().isEmpty()) {
            queryWrapper.in("wellbeing_and_quality_of_life_outcomes_reported", articleMainFilter.getWellbeingAndQualityOfLifeOutcomesReported());
        }
        queryWrapper.select("record_id");
        List<Filter> filters = filterMapper.selectList(queryWrapper);
        List<Integer> recordIds = filters.stream()
                .map(Filter::getRecordId)
                .collect(Collectors.toList());
        return recordIds;

    }
}
