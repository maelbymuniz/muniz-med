package muniz.med.api.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public List<Doctor> findAll() {
        return repository.findAll();
    }

    public Doctor findById(Long id) {
        Optional<Doctor> obj = repository.findById(id);
        return obj.get();
    }
}
