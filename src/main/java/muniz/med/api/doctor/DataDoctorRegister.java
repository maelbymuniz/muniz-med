package muniz.med.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import muniz.med.api.address.Address;
import muniz.med.api.address.HomeAddress;

public record DataDoctorRegister(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        MedicalSpecialty medicalSpecialty,
        @NotNull
        @Valid
        HomeAddress homeAddress) {
}
