package muniz.med.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import muniz.med.api.address.Address;

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
    private String crm;

    @Enumerated(EnumType.STRING)
    private MedicalSpecialty medicalSpecialty;
    @Embedded
    private Address address;

    public Doctor(DataDoctorRegister dataDoctorRegister) {
        this.name = dataDoctorRegister.name();
        this.email = dataDoctorRegister.email();
        this.crm = dataDoctorRegister.crm();
        this.medicalSpecialty = dataDoctorRegister.medicalSpecialty();
        this.address = new Address(dataDoctorRegister.homeAddress());
    }
}
