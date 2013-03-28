package org.celllife.ohsc.domain.average;

import org.celllife.ohsc.domain.district.District;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.subdistrict.SubDistrict;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 14h15
 */
@RestResource(path = "clinicAverages")
public interface ClinicAverageRepository extends PagingAndSortingRepository<ClinicAverage, Long> {

    ClinicAverage findByClinicCode(@Param("code") String code);

    @Query("select ca from ClinicAverage ca join ca.clinic c where c.subDistrict = :subDistrict")
    Iterable<ClinicAverage> findBySubDistrict(@Param("subDistrict") SubDistrict subDistrict);

    @Query("select ca from ClinicAverage ca join ca.clinic.subDistrict sd where sd.district = :district")
    Iterable<ClinicAverage> findByDistrict(@Param("district") District district);

    @Query("select ca from ClinicAverage ca join ca.clinic.subDistrict.district d where d.province = :province")
    Iterable<ClinicAverage> findByProvince(@Param("province") Province province);

}