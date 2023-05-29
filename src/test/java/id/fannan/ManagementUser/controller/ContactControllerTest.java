package id.fannan.ManagementUser.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.fannan.ManagementUser.entity.User;
import id.fannan.ManagementUser.model.ContactResponse;
import id.fannan.ManagementUser.model.CreateContactRequest;
import id.fannan.ManagementUser.model.WebResponse;
import id.fannan.ManagementUser.repository.ContactRepository;
import id.fannan.ManagementUser.repository.UserRepository;
import id.fannan.ManagementUser.security.BCrypt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ContactControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        contactRepository.deleteAll();
        userRepository.deleteAll();

        User user = new User();
        user.setUsername("test");
        user.setPassword(BCrypt.hashpw("test", BCrypt.gensalt()));
        user.setName("Test");
        user.setToken("test");
        user.setTokenExpiredAt(System.currentTimeMillis() + 100000000);
        userRepository.save(user);
    }

    @Test
    void createContactBadRequest() throws Exception {
        CreateContactRequest request = new CreateContactRequest();
        request.setFirstName("");
        request.setEmail("salah");
        mockMvc.perform(
                post("/api/contacts")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(
                result -> {
                    WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
                    });
                    assertNotNull(response.getErrors());
                }
        );
    }


    @Test
    void createContactSuccess() throws Exception {
        CreateContactRequest request = new CreateContactRequest();
        request.setFirstName("Fannan");
        request.setLastName("Fauzan");
        request.setEmail("salah@gmail.com");
        request.setPhone("08123456");
        mockMvc.perform(
                post("/api/contacts")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(
                result -> {
                    WebResponse<ContactResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<ContactResponse>>() {
                    });
                    assertNull(response.getErrors());
                    assertEquals("Fannan", response.getData().getFirstName());
                    assertEquals("Fauzan", response.getData().getLastName());
                    assertEquals("salah@gmail.com", response.getData().getEmail());
                    assertEquals("08123456", response.getData().getPhone());


                    assertTrue(contactRepository.existsById(response.getData().getId()));
                }
        );
    }

}