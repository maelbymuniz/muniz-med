package muniz.med.api.domain.patient;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import muniz.med.api.domain.address.Address;

@Entity(name = "Patient")
@Table(name = "tb_patients")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String cpf;

    @Embedded
    private Address address;
    private Boolean active;

    public Patient(DataPatientRegister dataPatientRegister) {
        this.active = true;
        this.name = dataPatientRegister.name();
        this.email = dataPatientRegister.email();
        this.phone = dataPatientRegister.phone();
        this.cpf = dataPatientRegister.cpf();
        this.address = new Address(dataPatientRegister.homeAddress());
    }

    public void dataUpdate(@Valid DataPatientUpdate dataDoctorUpdate) {
        if (dataDoctorUpdate.name() != null) {
            this.name = dataDoctorUpdate.name();
        }
        if (dataDoctorUpdate.phone() != null) {
            this.phone = dataDoctorUpdate.phone();
        }
        if (dataDoctorUpdate.homeAddress() != null) {
            this.address.updateAdress(dataDoctorUpdate.homeAddress());
        }
    }

    public void delete() {
        this.active = false;
    }
}
