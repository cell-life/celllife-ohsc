package org.celllife.ohsc.integration.geopc;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvFactory;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.util.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-29
 * Time: 10h06
 */
@Service
public final class PostalCodeServiceImpl implements PostalCodeService, InitializingBean {

    private Map<String, PostalCode> postalCodeMap = new HashMap<>();

    public Set<PostalCode> findAll() {
        return new HashSet<>(postalCodeMap.values());
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        CsvFactory csvFactory = new CsvFactory();

        CsvMapper mapper = new CsvMapper(csvFactory);

        CsvSchema schema = mapper.schemaFor(PostalCode.class)
                .withColumnSeparator(';');

        MappingIterator<PostalCode> objectMappingIterator = mapper
                .reader(PostalCode.class)
                .with(schema)
                .readValues(new InputStreamReader(getClass().getResourceAsStream("/GeoPC_ZA.csv")));

        while (objectMappingIterator.hasNext()) {
            PostalCode postalCode = objectMappingIterator.next();
            postalCodeMap.put(postalCode.getZip(), postalCode);
        }
    }
}
