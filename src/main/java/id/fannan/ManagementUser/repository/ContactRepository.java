package id.fannan.ManagementUser.repository;

import id.fannan.ManagementUser.entity.Contact;
import id.fannan.ManagementUser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
    Optional<Contact> findFirstByUserAndId(User user, String id);
}
