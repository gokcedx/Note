package com.uniyaz.note.converter;

import com.uniyaz.note.domain.User;
import com.uniyaz.note.dto.UserDto;
import com.uniyaz.note.service.DateService;
import org.springframework.stereotype.Component;

/**
 * @author Gökçe DOĞANAY
 * @since 0.0.1
 */
@Component
public class UserConverter {

    public User convertToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setAd(userDto.getAd());
        user.setSoyad(userDto.getSoyad());
        user.setKullaniciAdi(userDto.getKullaniciAdi());
        user.setSifre(userDto.getSifre());
        user.setePosta(userDto.getePosta());
        user.setDogumTarihi(userDto.getDogumTarihi());
        user.setKayitTarihi(DateService.getTodayDate());
        return user;
    }

    public UserDto convertToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setAd(user.getAd());
        userDto.setSoyad(user.getSoyad());
        userDto.setKullaniciAdi(user.getKullaniciAdi());
        userDto.setSifre(user.getSifre());
        userDto.setePosta(user.getePosta());
        userDto.setDogumTarihi(user.getDogumTarihi());
        userDto.setKayitTarihi(user.getKayitTarihi());
        return userDto;
    }
}
