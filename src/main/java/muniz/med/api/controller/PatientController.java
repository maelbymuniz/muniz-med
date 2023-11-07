package muniz.med.api.controller;

import jakarta.validation.Valid;
import muniz.med.api.domain.patient.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DataPatientRegister dataPatientRegister, UriComponentsBuilder uriComponentsBuilder) {
        var patient = new Patient(dataPatientRegister);
        repository.save(patient);
        var uri = uriComponentsBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new PatientDetails(patient));
    }

    @GetMapping
    public ResponseEntity<Page<DataPatientList>> listDoctors(@PageableDefault(size=10, sort = {"name"}) Pageable pagination) {
        var page = repository.findAllByActiveTrue(pagination).map(DataPatientList::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateInformation(@RequestBody @Valid DataPatientUpdate dataPatientUpdate) {
        var patient = repository.getReferenceById(dataPatientUpdate.id());
        patient.dataUpdate(dataPatientUpdate);

        return ResponseEntity.ok(new PatientDetails(patient));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deletePatient(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);
        patient.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity detailPatient(@PathVariable Long id) {
        var patient = repository.getReferenceById(id);

        return ResponseEntity.ok(new PatientDetails(patient));
    }
}
