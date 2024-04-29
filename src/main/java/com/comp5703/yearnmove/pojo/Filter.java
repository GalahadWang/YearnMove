package com.comp5703.yearnmove.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "Filter")
public class Filter {
    private Integer recordId;
    @TableField("physImp_as_inclusion_criterion")
    private String physImpAsInclusionCriterion;
    @TableField("CogImpLowMood_as_inclusion_criterion")
    private String cogImpLowMoodAsInclusionCriterion;
    @TableField("type_of_PA")
    private String typeOfPA;
    @TableField("type_of_PA_description")
    private String typeOfPADescription;
    private String primaryLocation;
    @TableField("PA_outcomes_reported")
    private String paOutcomesReported;
    @TableField("falls_outcomes_reported")
    private String fallsOutcomesReported;
    @TableField("Intrinsic_capacity_Physical_domain_outcomes_reported")
    private String intrinsicCapacityPhysicalDomainOutcomesReported;
    @TableField("FA_Physical_domain_outcomes_reported")
    private String faPhysicalDomainOutcomesReported;
    @TableField("FA_Social_domain_outcomes_reported")
    private String faSocialDomainOutcomesReported;
    @TableField("FA_cognitive_emotional_domain_outcomes_reported")
    private String faCognitiveEmotionalDomainOutcomesReported;
    @TableField("wellbeing_and_quality_of_life_outcomes_reported")
    private String wellbeingAndQualityOfLifeOutcomesReported;
    @TableField("other_publications_from_the_same_study_If_yes_specify")
    private String otherPublicationsFromTheSameStudyIfYesSpecify;
}

