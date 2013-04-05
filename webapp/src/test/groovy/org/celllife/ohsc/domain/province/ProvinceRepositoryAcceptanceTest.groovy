package org.celllife.ohsc.domain.province

import org.junit.Test

import static junit.framework.Assert.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 22h12
 */
class ProvinceRepositoryAcceptanceTest {

    @Test
    void shouldFindAll() throws Exception {

        def provinces = Provinces.findAll()

        assertNotNull provinces
        assertNotNull provinces.content.find {it.shortName == "Limpopo"}
        assertNotNull provinces.content.find {it.shortName == "Western Cape"}
        assertNotNull provinces.content.find {it.shortName == "Gauteng"}
        assertNotNull provinces.content.find {it.shortName == "Northern Cape"}
        assertNotNull provinces.content.find {it.shortName == "KwaZulu-Natal"}
        assertNotNull provinces.content.find {it.shortName == "North West"}
        assertNotNull provinces.content.find {it.shortName == "Free State"}
        assertNotNull provinces.content.find {it.shortName == "Mpumalanga"}
        assertNotNull provinces.content.find {it.shortName == "Eastern Cape"}

    }

    @Test
    void shouldFindAllProvinceNames() throws Exception {

        def provinceNames = Provinces.findAllProvinceNames()

        println provinceNames

        assertNotNull provinceNames
        assertNotNull provinceNames.content.find {it == "Limpopo"}
        assertNotNull provinceNames.content.find {it == "Western Cape"}
        assertNotNull provinceNames.content.find {it == "Gauteng"}
        assertNotNull provinceNames.content.find {it == "Northern Cape"}
        assertNotNull provinceNames.content.find {it == "KwaZulu-Natal"}
        assertNotNull provinceNames.content.find {it == "North West"}
        assertNotNull provinceNames.content.find {it == "Free State"}
        assertNotNull provinceNames.content.find {it == "Mpumalanga"}
        assertNotNull provinceNames.content.find {it == "Eastern Cape"}

    }
}
