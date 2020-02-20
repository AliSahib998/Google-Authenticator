package az.pashabank.google.authenticator.service.Impl;

import az.pashabank.google.authenticator.dao.entity.User;
import az.pashabank.google.authenticator.dao.repository.UserRepository;
import az.pashabank.google.authenticator.mapper.UserMapper;
import az.pashabank.google.authenticator.model.RegistrationDto;
import az.pashabank.google.authenticator.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final int SECRET_SIZE = 10;


    @Override
    public String registration(RegistrationDto registrationDto) {

        User user = UserMapper.INSTANCE.mapUserEntity(registrationDto);

        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

        String token = generateSecret();

        user.setSecret(token);

        userRepository.save(user);

        return token;
    }

    private String generateSecret() {
        return RandomStringUtils.random(SECRET_SIZE, true, true).toUpperCase();
    }

}
