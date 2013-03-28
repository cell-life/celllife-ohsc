package org.celllife.ohsc.domain.average;

import org.celllife.ohsc.domain.clinic.Clinic;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 18h27
 */
@Entity
public final class ClinicAverage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToOne
    private Clinic clinic;

    @OrderColumn
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Double> domainAverages;

    @Basic
    @Column(columnDefinition = "BIGINT")
    private Integer totalResponses;

    public ClinicAverage() {
        this.totalResponses = 0;

        this.domainAverages = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            domainAverages.add(0.0D);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public List<Double> getDomainAverages() {
        return domainAverages;
    }

    public void setDomainAverages(List<Double> domainAverages) {
        this.domainAverages = domainAverages;
    }

    public void setDomainAverage(String domainCode, Double average) {
        this.domainAverages.set(Integer.parseInt(domainCode) - 1, average);
    }

    public Integer getTotalResponses() {
        return totalResponses;
    }

    public void setTotalResponses(Integer totalResponses) {
        this.totalResponses = totalResponses;
    }

    public Double getDomainAverage(String domainCode) {
        return domainAverages.get(Integer.parseInt(domainCode) - 1);
    }

    public void incrementTotalResponses() {
        totalResponses++;
    }
}
