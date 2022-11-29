package com.example.restws;

import com.example.restws.model.Patient;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.*;


@Service
public class PatientServiceImpl implements PatientService{
    Map<Long,Patient> patients = new HashMap<>();
    long currentId = 123;
    public PatientServiceImpl() {
        init();
    }
    void init() {
        Patient patient = new Patient();
        patient.setId(currentId);
        patient.setName("John");
        patients.put(patient.getId(), patient);
    }

    @Override
    public List<Patient> getPatients() {
        Collection<Patient> result = patients.values();
        List<Patient> response = new ArrayList<>(result);
        return response;
    }

    @Override
    public Patient getPatient(Long id) {
        return patients.get(id);
    }

    @Override
    public Response createPatient(Patient patient) {
        patient.setId(++currentId);
        patients.put(patient.getId(), patient);
        return Response.ok(patient).build();
    }

    @Override
    public Response updatePatient(Patient patient) {
        Patient currentPatient = patients.get(patient.getId());
        Response response;
        if (currentPatient != null) {
            patients.put(patient.getId(), patient);
            response = Response.ok().build();
        } else {
            response = Response.notModified().build();
        }
        return response;

    }

    @Override
    public Response deletePatient(Long id) {

        Patient patient = patients.get(id);
        Response response;
        if (patient != null) {
            patients.remove(id);
            response = Response.ok().build();
        } else {
            response = Response.notModified().build();
        }

        return response;
    }


}
