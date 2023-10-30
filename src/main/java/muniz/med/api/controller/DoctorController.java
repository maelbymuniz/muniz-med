package muniz.med.api.controller;

import muniz.med.api.address.Address;
import muniz.med.api.doctor.DataDoctorRegister;
import muniz.med.api.doctor.Doctor;
import muniz.med.api.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody DataDoctorRegister dataDoctorRegister) {
        repository.save(new Doctor(dataDoctorRegister));
    }
}