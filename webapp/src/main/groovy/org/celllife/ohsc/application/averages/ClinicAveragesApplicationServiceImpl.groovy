package org.celllife.ohsc.application.averages
/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 13h21
 */
final class ClinicAveragesApplicationServiceImpl implements ClinicAveragesApplicationService {

    def findClinicAveragesBySubDistrict(String subDistrict) {

//        get.

        def allClinics = clinicService.findClinicsBySubDistrict(subDistrict);

        def clinicsWithAverages = clinicRatingAveragesService.findClinicAveragesBySubDistrict(subDistrict);

        clinicsWithAverages.addAll(allClinics);

        return clinicsWithAverages;
    }

    def findSubDistrictAveragesByDistrict(String district) {

        def allSubDistricts = clinicService.findSubDistrictsByDistrict(district);

        def subDistrictWithAverages = clinicRatingAveragesService.findSubDistrictAveragesByDistrict(district);

        subDistrictWithAverages.addAll(allSubDistricts);

        return subDistrictWithAverages;
    }

    def findDistrictAveragesByProvince(String province) {

        def allDistricts = clinicService.findDistrictsByProvince(province);

        def districtWithAverages = clinicRatingAveragesService.findDistrictAveragesByProvince(province);

        districtWithAverages.addAll(allDistricts);

        return districtWithAverages;
    }

    def findProvincialAverages() {

        def allProvinces = clinicService.findProvinces();

        def provincesWithAverages = clinicRatingAveragesService.findProvincialAverages();

        provincesWithAverages.addAll(allProvinces);

        return provincesWithAverages;
    }

    def findWorstClinics() {
        return clinicRatingAveragesService.findWorstClinics();
    }

    def findBestClinics() {
        return clinicRatingAveragesService.findBestClinics();
    }
}
