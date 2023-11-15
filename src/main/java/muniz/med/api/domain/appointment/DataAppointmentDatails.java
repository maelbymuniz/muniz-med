package muniz.med.api.domain.appointment;

import java.time.LocalDateTime;

public record DataAppointmentDatails(Long id, Long idDoctor, Long idPatient, LocalDateTime date) {
}
