package id.fannan.ManagementUser.service;

import id.fannan.ManagementUser.entity.Contact;
import id.fannan.ManagementUser.entity.User;
import id.fannan.ManagementUser.model.ContactResponse;
import id.fannan.ManagementUser.model.CreateContactRequest;
import id.fannan.ManagementUser.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public ContactResponse create(User user, CreateContactRequest request) {
        validationService.validate(request);

        Contact contact = new Contact();
        contact.setId(UUID.randomUUID().toString());
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        contact.setUser(user);

        contactRepository.save(contact);
        return ContactResponse.builder().
                id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .phone(request.getPhone())
                .build();
    }
}
