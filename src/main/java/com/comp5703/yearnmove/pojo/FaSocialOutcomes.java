package com.comp5703.yearnmove.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "FA_social_outcomes")
public class FaSocialOutcomes {
    @TableId
    private Integer recordId;
    @TableField("Functional_ability_Social_Domain")
    private String functionalAbilitySocialDomain;
    @TableField("Social_Domain_Number_of_Outcomes")
    private Integer socialDomainOutcomes;
    @TableField("SD_Number_of_Positive_Significant_outcomes")
    private Integer socialDomainPostiveOutcomes;
    @TableField("SD_Number_of_Positive_Non_significant_outcomes")
    private Integer socialDomainPostiveNonOutcomes;

}
