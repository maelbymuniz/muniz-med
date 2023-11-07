package muniz.med.api.domain.patient;


public record DataPatientList(Long id, String name, String email, String cpf) {

    public DataPatientList(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }

}
