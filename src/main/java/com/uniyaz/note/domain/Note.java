package com.uniyaz.note.domain;

import org.hibernate.annotations.ForeignKey;
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
    @SequenceGenerator(name = "generator", sequenceName = "NOTE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    private Long id;

    @Column
    private Long versiyon;

    @Size(max = 200)
    @Column(length = 200)
    private String konu;

    @Lob
    @Column
    private String icerik;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date kayitTarihi;

    @Column
    private Long begenilmeSayisi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    @ForeignKey(name = "FK_NOTE_USER")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKonu() {
        return konu;
    }

    public void setKonu(String konu) {
        this.konu = konu;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Date kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public Long getBegenilmeSayisi() {
        return begenilmeSayisi;
    }

    public void setBegenilmeSayisi(Long begenilmeSayisi) {
        this.begenilmeSayisi = begenilmeSayisi;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
