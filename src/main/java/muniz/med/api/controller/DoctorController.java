package muniz.med.api.controller;

import jakarta.validation.Valid;
import muniz.med.api.domain.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid DataDoctorRegister dataDoctorRegister, UriComponentsBuilder uriComponentsBuilder) {
        var doctor = new Doctor(dataDoctorRegister);
        repository.save(doctor);
        var uri = uriComponentsBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DoctorDetails(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DataDoctorList>> listDoctors(@PageableDefault(size=10, sort = {"name"}) Pageable pagination) {
        var page = repository.findAllByActiveTrue(pagination).map(DataDoctorList::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateInformation(@RequestBody @Valid DataDoctorUpdate dataDoctorUpdate) {
        var doctor = repository.getReferenceById(dataDoctorUpdate.id());
        doctor.dataUpdate(dataDoctorUpdate);

        return ResponseEntity.ok(new DoctorDetails(doctor));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deleteDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity detailDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);

        return ResponseEntity.ok(new DoctorDetails(doctor));
    }
}