package com.comp5703.yearnmove.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "multicomponent")
public class FigFive {
    @TableId
    private Integer recordId;
    @TableField("first_recordid")
    private Integer firstRecordid;
    @TableField("type_of_PA_description")
    private String typeOfPADescription;
//    @TableField("Balance")
    private String Balance;
//    @TableField("Strength")
    private String Strength;
//    @TableField("Walking")
    private String Walking;
    @TableField("P_Endurance")
    private String Endurance;
    @TableField("Other_publications")
    private String OtherPublications;
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
    private String authorYear;
    private String title;
    @TableField("DOI")
    private String doi;
    private String firstAuthor;
    private Integer year;
}
