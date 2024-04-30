package com.comp5703.yearnmove.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "Intrinsic_capacity_outcomes")
public class IntrinsicCapacityOutcomes {

    @TableId
    private Integer recordId;
    @TableField("Intrinsic_capacity")
    private String intrinsicCapacity;
    @TableField("Bone_Mineral_Density")
    private String boneMineralDensity;
    @TableField("BMD_Number_of_outcomes")
    private Integer bmdOutcomes;
    @TableField("BMD_Number_of_Positive_Significant_outcomes")
    private Integer bmdPositiveOutcomes;
    @TableField("BMD_Number_of_Positive_Non_significant_outcomes")
    private Integer bmdPositiveNonOutcomes;
    @TableField("Body_composition")
    private String bodyComposition;
    @TableField("BC_Number_of_Body_composition_outcomes")
    private Integer bcOutcomes;
    @TableField("BC_Number_of_Positive_Significant_outcomes")
    private Integer bcPositiveOutcomes;
    @TableField("BC_Number_of_Positive_Non_significant_outcomes")
    private Integer bcPositiveNonOutcomes;
    @TableField("Cardiometabolic_indicator")
    private String cardiometabolicIndicator;
    @TableField("CI_Number_of_Cardiometabolic_indicator_outcomes")
    private Integer ciOutcomes;
    @TableField("CI_Number_of_Positive_Significant_outcomes")
    private Integer ciPositiveOutcomes;
    @TableField("CI_Number_of_Positive_Non_significant_outcomes")
    private Integer ciPositiveNonOutcomes;
    @TableField("Strength")
    private String strength;
    @TableField("S_Number_of_Strength_outcomes")
    private Integer strengthOutcomes;
    @TableField("S_Number_of_Positive_Significant_outcomes")
    private Integer strengthPositiveOutcomes;
    @TableField("S_Number_of_Positive_Non_significant_outcomes")
    private Integer strengthPositiveNonOutcomes;
    @TableField("Fitness")
    private String fitness;
    @TableField("F_Number_of_Fitness_outcomes")
    private Integer fitnessOutcomes;
    @TableField("F_Number_of_Positive_Significant_outcomes")
    private Integer fitnessPositiveOutcomes;
    @TableField("F_Number_of_Positive_Non_significant_outcomes")
    private Integer fitnessPositiveNonOutcomes;
    @TableField("Pain")
    private String pain;
    @TableField("P_Number_of_Pain_outcomes")
    private Integer painOutcomes;
    @TableField("P_Number_of_Positive_Significant_outcomes")
    private Integer painPositiveOutcomes;
    @TableField("P_Number_of_Positive_Non_significant_outcomes")
    private Integer painPositiveNonOutcomes;
    @TableField("Other")
    private String other;
    @TableField("O_specify")
    private String otherspecify;
    @TableField("O_Number_of_Other_outcome")
    private Integer otherOutcomes;
    @TableField("PD_O_Number_of_Positive_Significant_outcomes")
    private Integer otherPositiveOutcomes;
    @TableField("PD_O_Number_of_Positive_Non_significant_outcomes")
    private Integer otherPositiveNonOutcomes;


}
