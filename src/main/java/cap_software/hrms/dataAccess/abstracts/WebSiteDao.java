package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.contacts.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteDao extends JpaRepository<WebSite,Integer> {
}
