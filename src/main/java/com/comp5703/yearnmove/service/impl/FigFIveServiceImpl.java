package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.DTO.FigFiveFilter;
import com.comp5703.yearnmove.mapper.FigFiveMapper;
import com.comp5703.yearnmove.pojo.FigFive;
import com.comp5703.yearnmove.pojo.MainData;
import com.comp5703.yearnmove.service.FigFiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FigFIveServiceImpl extends ServiceImpl<FigFiveMapper, FigFive> implements FigFiveService {
    private FigFiveMapper figFiveMapper;
    @Autowired
    public FigFIveServiceImpl(FigFiveMapper figFiveMapper){ this.figFiveMapper = figFiveMapper;}
    @Override
    public List<FigFive> returnArticleAll(FigFiveFilter figFive){
        QueryWrapper<FigFive> queryWrapper = new QueryWrapper<>();
        if(figFive.getBalance() != null && !figFive.getBalance().isEmpty()){
            queryWrapper.in("Balance",figFive.getBalance());
        }
        if(figFive.getStrength() != null && !figFive.getStrength().isEmpty()){
            queryWrapper.in("Strength", figFive.getStrength());
        }
        if(figFive.getWalking() != null && !figFive.getWalking().isEmpty()){
            queryWrapper.in("Walking", figFive.getWalking());
        }
        if(figFive.getEndurance() != null && !figFive.getEndurance().isEmpty()){
            queryWrapper.in("Endurance", figFive.getEndurance());
        }
        // PA_outcomes_reported condition
        if (figFive.getPaOutcomesReported() != null && !figFive.getPaOutcomesReported().isEmpty()) {
            queryWrapper.in("PA_outcomes_reported", figFive.getPaOutcomesReported());
        }

        // falls_outcomes_reported condition
        if (figFive.getFallsOutcomesReported() != null && !figFive.getFallsOutcomesReported().isEmpty()) {
            queryWrapper.in("falls_outcomes_reported", figFive.getFallsOutcomesReported());
        }

        // Intrinsic_capacity_Physical_domain_outcomes_reported 
        if (figFive.getIntrinsicCapacityPhysicalDomainOutcomesReported() != null && !figFive.getIntrinsicCapacityPhysicalDomainOutcomesReported().isEmpty()) {
            queryWrapper.in("Intrinsic_capacity_Physical_domain_outcomes_reported", figFive.getIntrinsicCapacityPhysicalDomainOutcomesReported());
        }

        // FA_Physical_domain_outcomes_reported condition
        if (figFive.getFaPhysicalDomainOutcomesReported() != null && !figFive.getFaPhysicalDomainOutcomesReported().isEmpty()) {
            queryWrapper.in("FA_Physical_domain_outcomes_reported", figFive.getFaPhysicalDomainOutcomesReported());
        }

        // FA_Social_domain_outcomes_reported
        if (figFive.getFaSocialDomainOutcomesReported() != null && !figFive.getFaSocialDomainOutcomesReported().isEmpty()) {
            queryWrapper.in("FA_Social_domain_outcomes_reported", figFive.getFaSocialDomainOutcomesReported());
        }

        // FA_cognitive_emotional_domain_outcomes_reported 
        if (figFive.getFaCognitiveEmotionalDomainOutcomesReported() != null && !figFive.getFaCognitiveEmotionalDomainOutcomesReported().isEmpty()) {
            queryWrapper.in("FA_cognitive_emotional_domain_outcomes_reported", figFive.getFaCognitiveEmotionalDomainOutcomesReported());
        }

        // wellbeingAndQualityOfLifeOutcomesReported 
        if (figFive.getWellbeingAndQualityOfLifeOutcomesReported() != null && !figFive.getWellbeingAndQualityOfLifeOutcomesReported().isEmpty()) {
            queryWrapper.in("wellbeing_and_quality_of_life_outcomes_reported", figFive.getWellbeingAndQualityOfLifeOutcomesReported());
        }
        queryWrapper.select("first_author", "year","author_year","title","doi");
        List<FigFive> figFiveList = figFiveMapper.selectList(queryWrapper);
        System.out.println("Size of figFiveList: " + figFiveList.size());
        return figFiveList;
    }
    @Override
    public List<FigFive> returnFirstColumn(FigFiveFilter figFive){
        QueryWrapper<FigFive> queryWrapper = new QueryWrapper<>();
        if(figFive.getBalance() != null && !figFive.getBalance().isEmpty()){
            queryWrapper.in("Balance",figFive.getBalance());
        }
        if(figFive.getStrength() != null && !figFive.getStrength().isEmpty()){
            queryWrapper.in("Strength", figFive.getStrength());
        }
        if(figFive.getWalking() != null && !figFive.getWalking().isEmpty()){
            queryWrapper.in("Walking", figFive.getWalking());
        }
        if(figFive.getEndurance() != null&& !figFive.getEndurance().isEmpty()){
            queryWrapper.in("Endurance", figFive.getEndurance());
        }
        // Use the apply method to ensure that the recordid equals the first recordid
        queryWrapper.apply("record_id = first_recordid");
        queryWrapper.select("first_author", "year","author_year","title","doi");
        List<FigFive> figFiveList = figFiveMapper.selectList(queryWrapper);
        System.out.println("Size of figFiveList: " + figFiveList.size());
        return figFiveList;
    }
}
