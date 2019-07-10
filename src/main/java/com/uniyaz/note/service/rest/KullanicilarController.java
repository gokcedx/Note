package com.uniyaz.note.service.rest;

import com.uniyaz.note.repository.KullanicilarRepository;
import com.uniyaz.note.domain.Kullanicilar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gökçe DOĞANAY
 * @since 0.0.1
 */
@RestController
public class KullanicilarController {

    @Autowired
    private KullanicilarRepository kullanicilarRepository;

    @PostMapping("/kullanicilar")
    public Kullanicilar saveKullanici(@RequestBody Kullanicilar kullanicilar){
        return kullanicilarRepository.save(kullanicilar);
    }

    @GetMapping("/kullanicilar")
    public List<Kullanicilar> findAllKullanicilar(){
        return kullanicilarRepository.findAll();
    }

    @GetMapping("/kullanicilar/{id}")
    public Kullanicilar findKullaniciById(@PathVariable Long id){
        return kullanicilarRepository.findById(id).orElseThrow(() -> new RuntimeException("Bulunamadı."));
    }

    @GetMapping("/kullanici/{id}")
    public void deleteKullanici(@PathVariable Long id){
        kullanicilarRepository.deleteById(id);
    }

}
