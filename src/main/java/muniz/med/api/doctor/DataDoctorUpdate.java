package muniz.med.api.doctor;

import jakarta.validation.constraints.NotNull;
import muniz.med.api.address.HomeAddress;

public record DataDoctorUpdate(
        @NotNull
        Long id,
        String name,
        String phone,
        HomeAddress homeAddress) {
}
