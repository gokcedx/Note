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
    UserRepository userRepository;

    @Autowired
    UserDao userDao;

    public User saveUser(UserDto userDto){
        UserConverter userConverter = new UserConverter();
        User user = userConverter.convertToUser(userDto);
        return userRepository.save(user);
    }

    public UserDto findById(Long userId){
        User user = userDao.findById(userId);
        UserConverter userConverter = new UserConverter();
        UserDto userDto = userConverter.convertToUserDto(user);
        return userDto;
    }
}
