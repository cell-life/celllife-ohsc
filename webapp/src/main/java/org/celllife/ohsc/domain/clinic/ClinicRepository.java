package org.celllife.ohsc.domain.clinic;

import org.milyn.scribe.annotation.Dao;
import org.milyn.scribe.annotation.Lookup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 14h15
 */
@Dao
@RestResource(path = "clinics")
public interface ClinicRepository extends PagingAndSortingRepository<Clinic, Long> {

    @Lookup(name = "code")
    Clinic findOneByCode(@org.milyn.scribe.annotation.Param("code")
                                @org.springframework.data.repository.query.Param("code") String code);

    @Query("select distinct c.code from Clinic c where c.code is not null")
    List<String> findAllCodes();

    Clinic findByExternalId(String externalId);
}
