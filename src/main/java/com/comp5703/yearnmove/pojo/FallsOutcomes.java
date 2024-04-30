package com.comp5703.yearnmove.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "Falls_outcomes")
public class FallsOutcomes {
    @TableId
    private Integer recordId;
    @TableField("Falls")
    private String falls;
    @TableField("Falls_Description")
    private String fallsDescription;
    @TableField("ROF_Number_of_Rate_of_Falls_outcomes")
    private Integer rofOutcomes;
    @TableField("ROF_Number_of_Positive_Significant_outcomes")
    private Integer rofPostiveOutcomes;
    @TableField("ROF_Number_of_Positive_Non_significant_outcomes")
    private Integer rofPostiveNonOutcomes;
    @TableField("FRI_Number_of_outcomes")
    private Integer friOutcomes;
    @TableField("FRI_Number_of_Positive_Significant_outcomes")
    private Integer friPostiveOutcomes;
    @TableField("FRI_Number_of_Positive_Non_significant_outcomes")
    private Integer friPostiveNonOutcomes;

}
