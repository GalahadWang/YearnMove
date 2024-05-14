package com.comp5703.yearnmove.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "first_column")
public class FirstColumn {
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
    @TableField("other_publications_from_the_same_study_If_yes_specify")
    private String otherPublicationsFromTheSameStudyIfYesSpecify;
    private String authorYear;
    private String title;
    private String doi;
    @TableField("first_recordid")
    private Integer firstRecordid;
    @TableField("second_recordid")
    private Integer secondRecordid;
}
