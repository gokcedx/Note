package com.uniyaz.note.service;

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

    public User saveUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setAd(userDto.getAd());
        user.setSoyad(userDto.getSoyad());
        user.setKullaniciAdi(userDto.getKullaniciAdi());
        user.setSifre(userDto.getSifre());
        user.setePosta(userDto.getePosta());
        user.setDogumTarihi(userDto.getDogumTarihi());
        user.setKayitTarihi(userDto.getKayitTarihi());

        return userRepository.save(user);
    }
}
