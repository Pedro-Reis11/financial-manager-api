package com.pedrodev.financialmanager.service;

import com.pedrodev.financialmanager.dto.UserDTO;
import com.pedrodev.financialmanager.entity.User;
import com.pedrodev.financialmanager.mapper.UserMapper;
import com.pedrodev.financialmanager.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,
                       UserMapper userMapper) {
        this .userRepository = userRepository;
        this .userMapper = userMapper;
    }


    public UserDTO createUser(UserDTO dto) {

        User user = userMapper.toEntity(dto);

        User savedUser = userRepository.save(user);

        return userMapper.toDTO(savedUser);
    }

    public Page<UserDTO> getAllUsers(Pageable pageable) {
        return userRepository
                .findAll(pageable)
                .map(userMapper::toDTO);
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toDTO(user);
    }

    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }
}
