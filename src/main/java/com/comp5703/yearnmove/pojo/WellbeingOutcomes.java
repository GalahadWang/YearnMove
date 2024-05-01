package com.comp5703.yearnmove.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "Wellbeing_outcomes")

public class WellbeingOutcomes {

    @TableId
    private Integer recordId;
    @TableField("Wellbeing_and_Quality_of_life_Description")
    private String wellbeingAndQualityOfLifeDescription;
    @TableField("Wellbeing_and_QoL_Overall_finding_effect_indicator")
    private String wellbeingAndQoLOverallFindingEffectIndicator;
    @TableField("Wellbeing_and_QoL_Number_of_Outcomes")
    private Integer wellbeingAndQoLOutcomes;
    @TableField("Wellbeing_and_QoL_Number_of_Positive_Significant_outcomes")
    private Integer wellbeingAndQoLPositiveOutcomes;
    @TableField("Wellbeing_and_QoL_Number_of_Positive_Non_significant_outcomes")
    private Integer wellbeingAndQoLPositiveNonOutcomes;

}



