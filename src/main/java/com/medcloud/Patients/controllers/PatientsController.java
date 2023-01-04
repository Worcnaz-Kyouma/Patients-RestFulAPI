package com.medcloud.Patients.controllers;

import com.medcloud.Patients.dtos.PatientDTO;
import com.medcloud.Patients.models.PatientModel;
import com.medcloud.Patients.service.PatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientsController {

    @Autowired
    PatientService patientService;


    @PostMapping
    @CacheEvict(value = { "findAll", "findByEmail" }, allEntries = true)
    public ResponseEntity<Object> save(@RequestBody @Valid PatientDTO patientDto) {
        if(patientService.findByEmail(patientDto.getEmail())!=null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already exists an patient with that email!");
        }
        var patientModel = new PatientModel();
        BeanUtils.copyProperties(patientDto,patientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.save(patientModel));
    }

    @GetMapping
    @Cacheable("findAll")
    public ResponseEntity<List<PatientModel>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.findAll());
    }

    @GetMapping("{email}")
    @Cacheable("findByEmail")
    public ResponseEntity<Object> findByEmail(@PathVariable(value = "email")String email){
        PatientModel patientModel = patientService.findByEmail(email);
        if(patientModel == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Don't exist an patient with that email");
        }
        return ResponseEntity.status(HttpStatus.OK).body(patientModel);
    }

}
