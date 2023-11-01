package muniz.med.api.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "doctors")
public class DoctorResourses {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<Doctor> orders = doctorService.findAll();

        return ResponseEntity.ok().body(orders);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable Long id) {
        Doctor obj = doctorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
