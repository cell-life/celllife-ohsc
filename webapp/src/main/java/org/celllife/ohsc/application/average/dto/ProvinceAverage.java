package org.celllife.ohsc.application.average.dto;

import org.celllife.ohsc.domain.average.ClinicAverage;
import org.celllife.ohsc.domain.province.Province;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-19
 * Time: 13h41
 */
public class ProvinceAverage {

    private Province province;

    private List<Double> domainAverages;

    private Integer totalResponses;

    public void addClinicAverage(ClinicAverage clinicAverage) {

        for (int i = 0; i < 6; i++) {
            clinicAverage.getDomainAverages();
        }
    }
}
