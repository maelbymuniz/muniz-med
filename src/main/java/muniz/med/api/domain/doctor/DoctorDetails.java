package muniz.med.api.domain.doctor;

import muniz.med.api.domain.address.Address;

public record DoctorDetails(Long id, String name, String email, String phone, String crm, MedicalSpecialty medicalSpecialty, Address address) {

    public DoctorDetails(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getCrm(), doctor.getMedicalSpecialty(), doctor.getAddress());
    }
}
