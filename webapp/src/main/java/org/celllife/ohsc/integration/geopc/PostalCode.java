package org.celllife.ohsc.integration.geopc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "country",
        "language",
        "id",
        "iso2",
        "region1",
        "region2",
        "region3",
        "region4",
        "zip",
        "city",
        "area1",
        "area2",
        "lat",
        "lng",
        "tz",
        "utc",
        "dst"
})
public final class PostalCode {

    @JsonProperty("country")
    private String country;

    @JsonProperty("language")
    private String language;

    @JsonProperty("id")
    private String id;

    @JsonProperty("iso2")
    private String iso2;

    @JsonProperty("region1")
    private String province;

    @JsonProperty("region2")
    private String districtMunicipality;

    @JsonProperty("region3")
    private String localMunicipality;

    @JsonProperty("region4")
    private String region4;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("city")
    private String city;

    @JsonProperty("area1")
    private String suburb;

    @JsonProperty("area2")
    private String area2;

    @JsonProperty("lat")
    private String latitude;

    @JsonProperty("lng")
    private String longitude;

    @JsonProperty("tz")
    private String tz;

    @JsonProperty("utc")
    private String utc;

    @JsonProperty("dst")
    private String dst;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrictMunicipality() {
        return districtMunicipality;
    }

    public void setDistrictMunicipality(String districtMunicipality) {
        this.districtMunicipality = districtMunicipality;
    }

    public String getLocalMunicipality() {
        return localMunicipality;
    }

    public void setLocalMunicipality(String localMunicipality) {
        this.localMunicipality = localMunicipality;
    }

    public String getRegion4() {
        return region4;
    }

    public void setRegion4(String region4) {
        this.region4 = region4;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getArea2() {
        return area2;
    }

    public void setArea2(String area2) {
        this.area2 = area2;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    @Override
    public String toString() {
        return "PostalCode{" +
                "country='" + country + '\'' +
                ", id='" + id + '\'' +
                ", province='" + province + '\'' +
                ", districtMunicipality='" + districtMunicipality + '\'' +
                ", localMunicipality='" + localMunicipality + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", suburb='" + suburb + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}