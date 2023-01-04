package com.medcloud.Patients.service;

import com.medcloud.Patients.models.PatientModel;
import com.medcloud.Patients.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientsRepository patientsRepository;

    public PatientModel save(PatientModel patientModel){
        return patientsRepository.save(patientModel);
    }

    public List<PatientModel> findAll(){
        return patientsRepository.findAll();
    }

    public PatientModel findByEmail(String email){
        return patientsRepository.findByEmail(email);
    }
}
