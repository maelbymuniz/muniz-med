package muniz.med.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record HomeAddress(
        @NotBlank
        String street,
        String number,

        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zipCode,
        @NotBlank
        String city,
        @NotBlank
        String state,
        String complement) {
}
