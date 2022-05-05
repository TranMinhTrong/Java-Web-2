package trong.ntu.thigiuaky.reposvice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import trong.ntu.thigiuaky.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

	@Query("SELECT * FROM Contact p  WHERE p.name LIKE %:keyword%")
    public List<Contact> search(@Param("keyword") String keyword);
}
