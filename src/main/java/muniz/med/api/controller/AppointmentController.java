package muniz.med.api.controller;

import jakarta.validation.Valid;
import muniz.med.api.domain.appointment.DataAppointmentDatails;
import muniz.med.api.domain.appointment.DataScheduleAppointment;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "appointments")
public class AppointmentController {

    @PostMapping
    @Transactional
    public ResponseEntity schedule(@RequestBody @Valid DataScheduleAppointment data) {
        System.out.println(data);
        return ResponseEntity.ok(new DataAppointmentDatails(null, null, null, null));
    }
}
