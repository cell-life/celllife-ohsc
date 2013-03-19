package org.celllife.ohsc.application.dhis;

import org.celllife.ohsc.domain.clinic.Clinic;
import org.celllife.ohsc.domain.clinic.ClinicRepository;
import org.celllife.ohsc.domain.country.Country;
import org.celllife.ohsc.domain.country.CountryRepository;
import org.celllife.ohsc.domain.district.District;
import org.celllife.ohsc.domain.district.DistrictRepository;
import org.celllife.ohsc.domain.province.Province;
import org.celllife.ohsc.domain.province.ProvinceRepository;
import org.celllife.ohsc.domain.subdistrict.SubDistrict;
import org.celllife.ohsc.domain.subdistrict.SubDistrictRepository;
import org.celllife.ohsc.test.TestConfiguration;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 10h34
 */

@Ignore
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DhisApplicationServiceIntegrationTest {

    @Autowired
    private DhisApplicationService dhisApplicationService;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private TaskExecutor dhisTaskExecutor;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private SubDistrictRepository subDistrictRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Test
    public void testSynchroniseAll() throws Exception {

        dhisApplicationService.synchroniseAll();

        while (((ThreadPoolTaskExecutor) dhisTaskExecutor).getActiveCount() != 0) {
            Thread.sleep(1000L);
        }

        for (Clinic clinic : clinicRepository.findAll()) {
            System.out.println(clinic);
        }
    }

    @Test
    public void testSynchroniseCountries() throws Exception {

        dhisApplicationService.synchroniseCountries();

        for (Country country : countryRepository.findAll()) {
            System.out.println(country);
        }
    }

    @Test
    public void testSynchroniseProvinces() throws Exception {

        dhisApplicationService.synchroniseProvinces();

        while (((ThreadPoolTaskExecutor) dhisTaskExecutor).getActiveCount() != 0) {
            Thread.sleep(1000L);
        }

        for (Province province : provinceRepository.findAll()) {
            System.out.println(province);
        }
    }

    @Test
    public void testSynchroniseDistricts() throws Exception {

        dhisApplicationService.synchroniseDistricts();

        for (District district : districtRepository.findAll()) {
            System.out.println(district);
        }
    }

    @Test
    public void testSynchroniseSubDistricts() throws Exception {

        dhisApplicationService.synchroniseSubDistricts();

        for (SubDistrict subDistrict : subDistrictRepository.findAll()) {
            System.out.println(subDistrict);
        }
    }

    @Test
    public void testSynchroniseClinics() throws Exception {

        dhisApplicationService.synchroniseClinics();

        for (Clinic clinic : clinicRepository.findAll()) {
            System.out.println(clinic);
        }
    }
}
