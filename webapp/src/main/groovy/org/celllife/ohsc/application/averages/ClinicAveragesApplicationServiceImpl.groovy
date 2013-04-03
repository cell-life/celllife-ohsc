package org.celllife.ohsc.application.averages

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 13h21
 */
@Service 
final class ClinicAveragesApplicationServiceImpl implements ClinicAveragesApplicationService {

    @Value('${datamartratings.url}')
    def String datamartratingsUrl

    @Value('${provinces.url}')
    def String provincesUrl

    @Value('${districts.url}')
    def String districtsUrl

    @Value('${subdistricts.url}')
    def String subdistrictsUrl

    @Value('${clinics.url}')
    def String clinicsUrl
    
    def findClinicAveragesBySubDistrict(String subDistrictName) {

        def clinics = get("${clinicsUrl}/search/findBySubDistrict?subDistrict=${subDistrictName}")

        for ( clinic in clinics.content) {

        }

        def allClinics = clinicService.findClinicsBySubDistrict(subDistrict)

        def clinicsWithAverages = clinicRatingAveragesService.findClinicAveragesBySubDistrict(subDistrict)

        clinicsWithAverages.addAll(allClinics)

        return clinicsWithAverages
    }

    def findSubDistrictAveragesByDistrict(String district) {

        def allSubDistricts = clinicService.findSubDistrictsByDistrict(district)

        def subDistrictWithAverages = clinicRatingAveragesService.findSubDistrictAveragesByDistrict(district)

        subDistrictWithAverages.addAll(allSubDistricts)

        return subDistrictWithAverages
    }

    def findDistrictAveragesByProvince(String province) {

        def allDistricts = clinicService.findDistrictsByProvince(province)

        def districtWithAverages = clinicRatingAveragesService.findDistrictAveragesByProvince(province)

        districtWithAverages.addAll(allDistricts)

        return districtWithAverages
    }

    def findProvincialAverages() {

        def allProvinces = clinicService.findProvinces()

        def provincesWithAverages = clinicRatingAveragesService.findProvincialAverages()

        provincesWithAverages.addAll(allProvinces)

        return provincesWithAverages
    }

    def findWorstClinics() {
        return clinicRatingAveragesService.findWorstClinics()
    }

    def findBestClinics() {
        return clinicRatingAveragesService.findBestClinics()
    }

    def get(String url) {
        return new groovyx.net.http.RESTClient(url).get().data;
    }
}
