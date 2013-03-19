package org.celllife.ohsc.domain.mno;

import org.celllife.ohsc.framework.logging.LogLevel;
import org.celllife.ohsc.framework.logging.Loggable;
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
@Loggable(LogLevel.DEBUG)
@RestResource(path = "mobileNetworkOperators")
public interface MobileNetworkOperatorRepository extends PagingAndSortingRepository<MobileNetworkOperator, Long> {

    @Lookup(name = "code")
    MobileNetworkOperator findOneByCode(@org.milyn.scribe.annotation.Param("code")
                                               @org.springframework.data.repository.query.Param("code") String code);

    @Query("select distinct m.code from MobileNetworkOperator m where m.code is not null")
    List<String> findAllCodes();
}
