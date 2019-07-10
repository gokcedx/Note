package com.uniyaz.note.domain;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Gökçe DOĞANAY
 * @since 0.0.1
 */
@Entity
@Audited
@Table(name = "USER")
public class User {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "USER_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @Column
    private Long id;

    @Version
    private Long versiyon;

    @Size(max = 100)
    @Column(length = 100)
    private String ad;

    @Size(max = 100)
    @Column(length = 100)
    private String soyad;

    @Size(max = 100)
    @Column(length = 100)
    private String kullaniciAdi;

    @Size(max = 100)
    @Column(length = 100)
    private String sifre;

    @Size(max = 100)
    @Column(length = 100)
    private String ePosta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dogumTarihi;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date kayitTarihi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersiyon() {
        return versiyon;
    }

    public void setVersiyon(Long versiyon) {
        this.versiyon = versiyon;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getePosta() {
        return ePosta;
    }

    public void setePosta(String ePosta) {
        this.ePosta = ePosta;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Date kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }
}
