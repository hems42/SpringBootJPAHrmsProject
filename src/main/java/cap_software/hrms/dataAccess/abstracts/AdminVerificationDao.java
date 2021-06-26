package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.verifications.AdminVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminVerificationDao extends JpaRepository<AdminVerification,Integer> {
}
