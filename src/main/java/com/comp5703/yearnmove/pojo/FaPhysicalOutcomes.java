package com.comp5703.yearnmove.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "FA_physical_outcomes")
public class FaPhysicalOutcomes {


    @TableId
    private Integer recordId;
    @TableField("Functional_ability_Physical_domain")
    private String FunctionalAbilityPhysicalDomain;
    @TableField("FA_Mobility_and_balance")
    private String FAMobilityAndBalance;
    @TableField("Mobility_balance")
    private String MobilityBalance;
    @TableField("MB_Number_of_Outcomes")
    private Integer mobilityBalanceOutcomes;
    @TableField("MB_Number_of_Positive_Significant_outcomes")
    private Integer mobilityBalancePostiveOutcomes;
    @TableField("MB_Number_of_Positive_Non_significant_outcomes")
    private Integer mobilityBalancePostiveNonOutcomes;
    @TableField("Self_care")
    private String selfCare;
    @TableField("SC_Number_of_Outcomes")
    private Integer selfCareOutcomes;
    @TableField("SC_Number_of_Positive_Significant_outcomes")
    private Integer selfCarePostiveOutcomes;
    @TableField("SC_Number_of_Positive_Non_significant_outcomes  ")
    private Integer selfCarePostiveNonOutcomes;
    @TableField("Overall_Function")
    private String overallFunction;
    @TableField("OF_Number_of_Overall_Function_outcomes")
    private Integer overallFunctionOutcomes;
    @TableField("OF_Number_of_Positive_Significant_outcomes")
    private Integer overallFunctionPostiveOutcomes;
    @TableField("OF_Number_of_Positive_Non_significant_outcomes")
    private Integer overallFunctionPostiveNonOutcomes;
    @TableField("Other")
    private String other;
    @TableField("O_Number_of_Other_outcome")
    private Integer otherOutcomes;
    @TableField("O_Number_of_Positive_Significant_outcomes")
    private Integer otherPostiveOutcomes;
    @TableField("O_Number_of_Positive_Non_significant_outcomes")
    private Integer otherPostiveNonOutcomes;

}
