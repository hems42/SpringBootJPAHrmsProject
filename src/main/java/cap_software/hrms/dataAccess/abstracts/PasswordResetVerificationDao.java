package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.concretes.verifications.PasswordResetVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetVerificationDao extends JpaRepository<PasswordResetVerification,Integer> {
}
