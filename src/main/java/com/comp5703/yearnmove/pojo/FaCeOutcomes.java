package com.comp5703.yearnmove.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "FA_CE_outcomes")
public class FaCeOutcomes {


    @TableId
    private Integer recordId;
    @TableField("FA_Cognitive_emotional_domain_Description")
    private String fACognitiveEmotionalDomainDescription;
    @TableField("CAED_Overall_finding_effect_indicator")
    private String cAEDOverallFindingEffectIndicator;
    @TableField("C_Number_of_Outcomes")
    private Integer cognitiveOutcomes;
    @TableField("C_Number_of_Positive_Significant_outcomes")
    private Integer cognitivePositiveOutcomes;
    @TableField("C_Number_of_Positive_Non_significant_outcomes")
    private Integer cognitivePositiveNonOutcomes;
    @TableField("Emotional_Number_of_Outcomes")
    private Integer emotionalOutcomes;
    @TableField("E_Number_of_Positive_Significant_outcomes")
    private Integer emotionalPositiveOutcomes;
    @TableField("E_Number_of_Positive_Non_significant_outcomes")
    private Integer emotionalPositiveNonOutcomes;

}
