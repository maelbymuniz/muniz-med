package muniz.med.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String number;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
    private String complement;

    public Address(HomeAddress homeAddress) {
        this.street = homeAddress.street();
        this.number = homeAddress.number();
        this.neighborhood = homeAddress.neighborhood();
        this.zipCode = homeAddress.zipCode();
        this.city = homeAddress.city();
        this.state = homeAddress.state();
        this.complement = homeAddress.complement();
    }
}
