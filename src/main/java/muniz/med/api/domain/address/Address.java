package muniz.med.api.domain.address;

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

    public void updateAdress(HomeAddress homeAddress) {
        if (homeAddress.street() != null) {
            this.street = homeAddress.street();
        }
        if(homeAddress.number() != null) {
            this.number = homeAddress.number();
        }
        if (homeAddress.neighborhood() != null) {
            this.neighborhood = homeAddress.neighborhood();
        }
        if (homeAddress.zipCode() != null) {
            this.zipCode = homeAddress.zipCode();
        }
        if (homeAddress.city() != null) {
            this.city = homeAddress.city();
        }
        if (homeAddress.state() != null) {
            this.state = homeAddress.state();
        }
        if (homeAddress.complement() != null) {
            this.complement = homeAddress.complement();
        }
    }
}
