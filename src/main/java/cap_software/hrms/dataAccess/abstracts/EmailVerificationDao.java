package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.verifications.EmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationDao extends JpaRepository<EmailVerification,Integer> {
}
