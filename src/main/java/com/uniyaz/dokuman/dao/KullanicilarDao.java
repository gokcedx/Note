package com.uniyaz.dokuman.dao;

import com.uniyaz.dokuman.domain.Kullanicilar;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Gökçe DOĞANAY
 * @since 0.0.1
 */
public class KullanicilarDao {
    @Autowired
    private KullanicilarRepository kullanicilarRepository;

    public Kullanicilar saveKullanicilar(Kullanicilar kullanicilar){
        return kullanicilarRepository.save(kullanicilar);
    }
}
