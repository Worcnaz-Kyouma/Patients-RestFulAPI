package com.medcloud.Patients.repository;

import com.medcloud.Patients.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientsRepository extends JpaRepository<PatientModel, Long> {
    @Query("SELECT p FROM PatientModel p where p.email = ?1")
    PatientModel findByEmail(String email);
}
