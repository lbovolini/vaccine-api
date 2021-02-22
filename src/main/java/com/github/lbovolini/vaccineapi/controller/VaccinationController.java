package com.github.lbovolini.vaccineapi.controller;

import com.github.lbovolini.vaccineapi.model.Vaccination;
import com.github.lbovolini.vaccineapi.response.VaccinationResource;
import com.github.lbovolini.vaccineapi.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "api/v1/vaccinations",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class VaccinationController {

    private final VaccinationService vaccinationService;

    @Autowired
    public VaccinationController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @PostMapping
    public ResponseEntity<VaccinationResource> save(@Valid @RequestBody Vaccination vaccination) {
        Vaccination savedVaccination = vaccinationService.save(vaccination);
        String savedVaccinationId = String.valueOf(savedVaccination.getId());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(savedVaccinationId)
                .build()
                .toUri();

        VaccinationResource vaccinationResource = new VaccinationResource(savedVaccination);

        return ResponseEntity.created(location).body(vaccinationResource);
    }
}
