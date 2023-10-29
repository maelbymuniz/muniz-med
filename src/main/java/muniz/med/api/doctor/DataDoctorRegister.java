package muniz.med.api.doctor;

import muniz.med.api.address.HomeAddress;

public record DataDoctorRegister(String name, String email, String crm, MedicalSpecialty medicalSpecialty, HomeAddress homeAddress) {
}
