package muniz.med.api.controller;

import jakarta.validation.Valid;
import muniz.med.api.address.Address;
import muniz.med.api.doctor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataDoctorRegister dataDoctorRegister) {
        repository.save(new Doctor(dataDoctorRegister));
    }

    @GetMapping
    public Page<DataDoctorList> listDoctors(@PageableDefault(size=10, sort = {"name"}) Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(DataDoctorList::new);
    }

    @PutMapping
    @Transactional
    public void updateInformation(@RequestBody @Valid DataDoctorUpdate dataDoctorUpdate) {
        var doctor = repository.getReferenceById(dataDoctorUpdate.id());
        doctor.dataUpdate(dataDoctorUpdate);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id) {
        var doctor = repository.getReferenceById(id);
        doctor.delete();
    }

}