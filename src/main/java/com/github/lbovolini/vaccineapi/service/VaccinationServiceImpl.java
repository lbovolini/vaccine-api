package com.github.lbovolini.vaccineapi.service;

import com.github.lbovolini.vaccineapi.model.Vaccination;
import com.github.lbovolini.vaccineapi.repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationServiceImpl implements VaccinationService {

    private final VaccinationRepository vaccinationRepository;

    @Autowired
    public VaccinationServiceImpl(VaccinationRepository vaccinationRepository) {
        this.vaccinationRepository = vaccinationRepository;
    }

    public Vaccination save(Vaccination vaccination) {
        return vaccinationRepository.save(vaccination);
    }
}
