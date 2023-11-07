package muniz.med.api.domain.patient;

import muniz.med.api.domain.address.Address;

public record PatientDetails(Long id, String name, String email, String phone, Address address) {

    public PatientDetails(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getAddress());
    }
}
