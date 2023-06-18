package id.fannan.ManagementUser.service;

import id.fannan.ManagementUser.entity.Address;
import id.fannan.ManagementUser.entity.Contact;
import id.fannan.ManagementUser.entity.User;
import id.fannan.ManagementUser.model.AddressResponse;
import id.fannan.ManagementUser.model.CreateAddressRequest;
import id.fannan.ManagementUser.repository.AddressRepository;
import id.fannan.ManagementUser.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ValidationService validationService;


    @Transactional
    public AddressResponse create(User user, CreateAddressRequest request) {
        validationService.validate(request);
        Contact contact = contactRepository.findFirstByUserAndId(user, request.getContactId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact is not found"));
        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setContact(contact);
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setProvince(request.getProvince());
        address.setCountry(request.getCountry());
        address.setPostalCode(request.getPostalCode());
        addressRepository.save(address);
        return toAddressResponse(address);

    }

    private AddressResponse toAddressResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .province(address.getProvince())
                .country(address.getCountry())
                .postalCode(address.getPostalCode())
                .build();

    }
}
