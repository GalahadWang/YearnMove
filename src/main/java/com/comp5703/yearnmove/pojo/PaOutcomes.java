package com.comp5703.yearnmove.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "PA_outcomes")
public class PaOutcomes {
    @TableId
    private Integer recordId;
    @TableField("Physical_activity")
    private String physicalActivity;
    @TableField("Steps")
    private String steps;
    @TableField("Steps_Overall_finding_effect_indicator")
    private String stepsOverall;
    @TableField("MVPA")
    private String MVPA;
    @TableField("MVPA_Number_of_MVPA_outcomes")
    private Integer mvpaOutcomes;
    @TableField("MVPA_Number_of_Positive_Significant_outcomes")
    private  Integer mvpaPostiveOutcomes;
    @TableField("MVPA_Number_of_Positive_Non_significant_outcomes")
    private Integer mvpaPostiveNonOutcomes;
    @TableField("Up_time")
    private String upTime;
    @TableField("Up_time_Number_of_Up_time_outcomes")
    private Integer uptimeOutcomes;
    @TableField("Up_time_Number_of_Positive_Significant_outcomes")
    private Integer uptimePostiveOutcomes;
    @TableField("Up_time_Number_of_Positive_Non_significant_outcomes")
    private Integer uptimePostiveNonOutcomes;
    @TableField("Total_PA")
    private String totalPA;
    @TableField("Total_PA_Number_of_total_PA_outcomes")
    private Integer totalPaOutcomes;
    @TableField("Total_PA_Number_of_Positive_Significant_outcomes")
    private Integer totalPaPostiveOutcomes;
    @TableField("Total_PA_Number_of_Positive_Non_significant_outcomes")
    private Integer totalPaPostiveNonOutcomes;
    @TableField("Domains_of_PA")
    private String domainPA;
    @TableField("Domains_of_PA_Number_of_outcomes")
    private Integer domainOutcomes;
    @TableField("Domains_of_PA_Number_of_Positive_Significant_outcomes")
    private Integer domainPositiveOutcomes;
    @TableField("Domains_of_PA_Number_of_Positive_Non_significant_outcomes")
    private Integer domainPositiveNonOutcomes;
}

