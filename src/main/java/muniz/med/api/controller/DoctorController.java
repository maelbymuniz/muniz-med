package muniz.med.api.controller;

import muniz.med.api.doctor.DataDoctorRegister;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @PostMapping
    public void register(@RequestBody DataDoctorRegister dataDoctorRegister) {
        System.out.println(dataDoctorRegister);
    }
}