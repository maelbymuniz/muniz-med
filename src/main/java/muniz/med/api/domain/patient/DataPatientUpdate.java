package muniz.med.api.domain.patient;

import jakarta.validation.constraints.NotNull;
import muniz.med.api.domain.address.HomeAddress;

public record DataPatientUpdate(
        @NotNull
        Long id,
        String name,
        String phone,
        HomeAddress homeAddress) {
}
