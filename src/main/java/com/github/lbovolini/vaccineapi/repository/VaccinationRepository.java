package com.github.lbovolini.vaccineapi.repository;

import com.github.lbovolini.vaccineapi.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Long>, CustomVaccinationRepository {
}
