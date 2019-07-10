package com.uniyaz.note.domain;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Kübra VARICI
 */

@Entity
@Audited
@Table(name = "NOTE")
public class Note {

    @Id
    @Column
    @SequenceGenerator(name = "generator", sequenceName = "NOTE_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    private Long id;

    @Column
    private Long versiyon;

    @Size(max = 200)
    @Column(length = 200)
    private String adi;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date kayitTarihi;

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

    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Date kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }
}
