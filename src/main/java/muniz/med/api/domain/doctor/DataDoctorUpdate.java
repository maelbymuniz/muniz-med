package muniz.med.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import muniz.med.api.domain.address.HomeAddress;

public record DataDoctorUpdate(
        @NotNull
        Long id,
        String name,
        String phone,
        HomeAddress homeAddress) {
}
