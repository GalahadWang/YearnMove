package com.comp5703.yearnmove.DTO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class articleMainFilter {
    private List<String> physImpAsInclusionCriterion;
    private List<String> cogImpLowMoodAsInclusionCriterion;
    private List<String> typeOfPA;
    private List<String> typeOfPADescription;
    private List<String> primaryLocation;
    private List<String> paOutcomesReported;
    private List<String> fallsOutcomesReported;
    private List<String> intrinsicCapacityPhysicalDomainOutcomesReported;
    private List<String> faPhysicalDomainOutcomesReported;
    private List<String> faSocialDomainOutcomesReported;
    private List<String> faCognitiveEmotionalDomainOutcomesReported;
    private List<String> wellbeingAndQualityOfLifeOutcomesReported;
}
