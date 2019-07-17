package com.uniyaz.note.service;

import com.uniyaz.note.converter.UserConverter;
import com.uniyaz.note.dao.UserDao;
import com.uniyaz.note.domain.User;
import com.uniyaz.note.dto.UserDto;
import com.uniyaz.note.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gökçe DOĞANAY
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserConverter userConverter;

    @Autowired
    UserRepository userRepository;

    public User saveUser(UserDto userDto){
        User user = userConverter.convertToUser(userDto);
        return userRepository.save(user);
    }

    public UserDto findUserDtoById(Long userId){
        User user = userDao.findById(userId);
        UserDto userDto = userConverter.convertToUserDto(user);
        return userDto;
    }

    public User findById(Long userId){
        User user = userDao.findById(userId);
        return user;
    }
}
