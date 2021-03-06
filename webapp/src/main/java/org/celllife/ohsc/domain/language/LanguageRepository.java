package org.celllife.ohsc.domain.language;

import org.celllife.ohsc.framework.logging.LogLevel;
import org.celllife.ohsc.framework.logging.Loggable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-15
 * Time: 14h15
 */
@Loggable(LogLevel.DEBUG)
@RestResource(path = "languages")
public interface LanguageRepository extends PagingAndSortingRepository<Language, Long> {

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    Language findOneByCode(@Param("code") String code);

    @Query("select distinct l.code from Language l where l.code is not null")
    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    List<String> findAllCodes();

}
