package id.fannan.ManagementUser.service;

import id.fannan.ManagementUser.entity.User;
import id.fannan.ManagementUser.model.LoginUserRequest;
import id.fannan.ManagementUser.model.TokenResponse;
import id.fannan.ManagementUser.repository.UserRepository;
import id.fannan.ManagementUser.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    public TokenResponse login(LoginUserRequest request) {
        validationService.validate(request);

        User user = userRepository.findById(request.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong"));

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
//            Success
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30Days());
            userRepository.save(user);
            return TokenResponse.builder()
                    .token(user.getToken())
                    .expireAt(user.getTokenExpiredAt())
                    .build();

        } else {
//            Failed
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong");
        }
    }

    private Long next30Days() {
        return System.currentTimeMillis() + (1000 * 16 * 24 * 30);
    }
}
