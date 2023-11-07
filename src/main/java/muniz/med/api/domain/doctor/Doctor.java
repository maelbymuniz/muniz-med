package muniz.med.api.domain.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import muniz.med.api.domain.address.Address;

@Entity(name = "Doctor")
@Table(name = "tb_doctors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private MedicalSpecialty medicalSpecialty;
    @Embedded
    private Address address;
    private Boolean active;

    public Doctor(DataDoctorRegister dataDoctorRegister) {
        this.active = true;
        this.name = dataDoctorRegister.name();
        this.email = dataDoctorRegister.email();
        this.phone = dataDoctorRegister.phone();
        this.crm = dataDoctorRegister.crm();
        this.medicalSpecialty = dataDoctorRegister.medicalSpecialty();
        this.address = new Address(dataDoctorRegister.homeAddress());
    }

    public void dataUpdate(DataDoctorUpdate dataDoctorUpdate) {
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
