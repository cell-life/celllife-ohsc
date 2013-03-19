package org.celllife.ohsc.integration.cqm;

import org.celllife.ohsc.domain.language.Language;
import org.celllife.ohsc.domain.language.LanguageRepository;
import org.celllife.ohsc.framework.MockPagingAndSortingRepository;

import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-17
 * Time: 11h49
 */
public class MockLanguageRepository extends MockPagingAndSortingRepository<Language, Long> implements LanguageRepository {

    @Override
    public Language findOneByCode(String code) {
        Language clinic = new Language();
        clinic.setName("English");
        clinic.setCode(code);

        return clinic;
    }

    @Override
    public List<String> findAllCodes() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
