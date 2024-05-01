package com.comp5703.yearnmove.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.w3c.dom.Text;

@Data
@TableName(value = "main_data_final")
public class MainData {
    @TableId
    private Integer recordId;
    private String firstAuthor;
    private Integer year;
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
//    @TableField("other_publications_from_the_same_study_If_yes_specify")
    @TableField("other_publications_from_the_same_study_If_yes_specify")
    private String otherPublicationsFromTheSameStudyIfYesSpecify;
    private String authorYear;
    private String title;
    @TableField("abstract")
    private String articleAbstract;
    private String doi;
    private Integer sampleSize;
    private Integer pedroScore;
    private String country;
    @TableField("country_specify")
    private String countrySpecify;
    private String remoteness;
    private Integer age;
    private String gender;
    @TableField("first_recordid")
    private Integer firstRecordid;
}
