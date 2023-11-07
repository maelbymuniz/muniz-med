package muniz.med.api.domain.doctor;

public record DataDoctorList(Long id, String name, String email, String crm, MedicalSpecialty medicalSpecialty) {

    public DataDoctorList(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getMedicalSpecialty());
    }

}
