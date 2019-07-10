package com.uniyaz.dokuman.domain;

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
@Table(name = "KULLANICILAR")
public class Kullanicilar {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "KULLANICILAR_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @Column
    private Long id;

    @Version
    private Long versiyon;

    @Size(max = 100)
    @Column(length = 100)
    private String adi;

    @Size(max = 100)
    @Column(length = 100)
    private String soyadi;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dogumTarihi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }
}
