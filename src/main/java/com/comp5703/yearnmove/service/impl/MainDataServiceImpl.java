package com.comp5703.yearnmove.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comp5703.yearnmove.DTO.articleMainFilter;
import com.comp5703.yearnmove.common.Result;
import com.comp5703.yearnmove.mapper.MainDataMapper;
import com.comp5703.yearnmove.pojo.MainData;
import com.comp5703.yearnmove.service.MainDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MainDataServiceImpl extends ServiceImpl<MainDataMapper, MainData> implements MainDataService{
    private MainDataMapper mainDataMapper;
    @Autowired
    public MainDataServiceImpl(MainDataMapper mainDataMapper){
        this.mainDataMapper = mainDataMapper;
    }
    @Override
    public List<MainData> returnArticleAll(articleMainFilter articleMainFilter){
        QueryWrapper<MainData> queryWrapper = new QueryWrapper<>();
        if(articleMainFilter.getPhysImpAsInclusionCriterion() != null && !articleMainFilter.getPhysImpAsInclusionCriterion().isEmpty()){
            queryWrapper.in("physImp_as_inclusion_criterion",articleMainFilter.getPhysImpAsInclusionCriterion());
        }
        // CogImpLowMood_as_inclusion_criterion 条件
        if (articleMainFilter.getCogImpLowMoodAsInclusionCriterion() != null && !articleMainFilter.getCogImpLowMoodAsInclusionCriterion().isEmpty()) {
            queryWrapper.in("CogImpLowMood_as_inclusion_criterion", articleMainFilter.getCogImpLowMoodAsInclusionCriterion());
        }

        // type_of_PA 条件
        if (articleMainFilter.getTypeOfPA() != null && !articleMainFilter.getTypeOfPA().isEmpty()) {
            queryWrapper.in("type_of_PA", articleMainFilter.getTypeOfPA());
        }

        // type_of_PA_description 条件
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

        // Intrinsic_capacity_Physical_domain_outcomes_reported 条件
        if (articleMainFilter.getIntrinsicCapacityPhysicalDomainOutcomesReported() != null && !articleMainFilter.getIntrinsicCapacityPhysicalDomainOutcomesReported().isEmpty()) {
            queryWrapper.in("Intrinsic_capacity_Physical_domain_outcomes_reported", articleMainFilter.getIntrinsicCapacityPhysicalDomainOutcomesReported());
        }

        // FA_Physical_domain_outcomes_reported condition
        if (articleMainFilter.getFaPhysicalDomainOutcomesReported() != null && !articleMainFilter.getFaPhysicalDomainOutcomesReported().isEmpty()) {
            queryWrapper.in("FA_Physical_domain_outcomes_reported", articleMainFilter.getFaPhysicalDomainOutcomesReported());
        }

        // FA_Social_domain_outcomes_reported 条件
        if (articleMainFilter.getFaSocialDomainOutcomesReported() != null && !articleMainFilter.getFaSocialDomainOutcomesReported().isEmpty()) {
            queryWrapper.in("FA_Social_domain_outcomes_reported", articleMainFilter.getFaSocialDomainOutcomesReported());
        }

        // FA_cognitive_emotional_domain_outcomes_reported 条件
        if (articleMainFilter.getFaCognitiveEmotionalDomainOutcomesReported() != null && !articleMainFilter.getFaCognitiveEmotionalDomainOutcomesReported().isEmpty()) {
            queryWrapper.in("FA_cognitive_emotional_domain_outcomes_reported", articleMainFilter.getFaCognitiveEmotionalDomainOutcomesReported());
        }

        // wellbeingAndQualityOfLifeOutcomesReported 条件
        if (articleMainFilter.getWellbeingAndQualityOfLifeOutcomesReported() != null && !articleMainFilter.getWellbeingAndQualityOfLifeOutcomesReported().isEmpty()) {
            queryWrapper.in("wellbeing_and_quality_of_life_outcomes_reported", articleMainFilter.getWellbeingAndQualityOfLifeOutcomesReported());
        }

        queryWrapper.select("first_author", "year","author_year","title","doi");
        List<MainData> mainDataList = mainDataMapper.selectList(queryWrapper);
//        queryWrapper.select("")
        System.out.println("Size of mainDataList: " + mainDataList.size());
        return mainDataList;
//        if(mainDataList != null){
//            return Result.success(mainDataList,"success");
//        }
//        return Result.error("can not find any articles");
    }

    @Override
    public List<MainData> returnFirstColumn(articleMainFilter articleMainFilter){
        QueryWrapper<MainData> queryWrapper = new QueryWrapper<>();

        // type_of_PA condition
        if (articleMainFilter.getTypeOfPA() != null && !articleMainFilter.getTypeOfPA().isEmpty()) {
            queryWrapper.in("type_of_PA", articleMainFilter.getTypeOfPA());
        }

        // type_of_PA_description condition
        if (articleMainFilter.getTypeOfPADescription() != null && !articleMainFilter.getTypeOfPADescription().isEmpty()) {
            queryWrapper.in("type_of_PA_description", articleMainFilter.getTypeOfPADescription());
        }

        // Use the apply method to ensure that the recordid equals the first recordid
        queryWrapper.apply("record_id = first_recordid");

        queryWrapper.select("first_author", "year","author_year","title","doi");
        List<MainData> mainDataList = mainDataMapper.selectList(queryWrapper);
        // 打印列表的长度
        System.out.println("Size of mainDataList: " + mainDataList.size());
//        queryWrapper.select("")
        return mainDataList;
//        if(mainDataList != null){
//            return Result.success(mainDataList,"success");
//        }
//        return Result.error("can not find any articles");
    }
}
