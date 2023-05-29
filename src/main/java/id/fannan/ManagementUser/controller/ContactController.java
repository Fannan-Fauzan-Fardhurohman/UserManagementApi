package id.fannan.ManagementUser.controller;

import id.fannan.ManagementUser.entity.User;
import id.fannan.ManagementUser.model.ContactResponse;
import id.fannan.ManagementUser.model.CreateContactRequest;
import id.fannan.ManagementUser.model.WebResponse;
import id.fannan.ManagementUser.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(
            path = "/api/contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> create(User user, @RequestBody CreateContactRequest request) {
        ContactResponse contactResponse = contactService.create(user, request);
        return WebResponse.<ContactResponse>builder().data(contactResponse).build();
    }
}
