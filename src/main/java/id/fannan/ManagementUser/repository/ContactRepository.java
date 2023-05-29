package id.fannan.ManagementUser.repository;

import id.fannan.ManagementUser.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
}
