package com.uniyaz.note.dto;

import java.util.Date;

/**
 * @author Kübra VARICI
 */
public class NoteDto {
    private Long id;
    private String konu;
    private byte[] icerik;
    private Date kayitTarihi;
    private Long begenilmeSayisi;
    private Long userId;

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

    public byte[] getIcerik() {
        return icerik;
    }

    public void setIcerik(byte[] icerik) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
