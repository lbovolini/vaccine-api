package com.github.lbovolini.vaccineapi.response;

import com.github.lbovolini.vaccineapi.model.Vaccination;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;

public class VaccinationResource extends RepresentationModel<EntityModel<Vaccination>> {

    private final Vaccination vaccination;

    public VaccinationResource(Vaccination vaccination) {
        this.vaccination = vaccination;
    }

    public Vaccination getVaccination() {
        return vaccination;
    }
}
