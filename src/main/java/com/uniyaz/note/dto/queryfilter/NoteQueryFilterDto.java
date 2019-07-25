package com.uniyaz.note.dto.queryfilter;

import com.uniyaz.note.domain.Note;
import com.uniyaz.note.domain.User;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kübra VARICI
 */
public class NoteQueryFilterDto extends QueryFilterDto<Note> {
    private Long id;
    private String konu;
    private String icerik;
    private Date kayitTarihi;
    private Long begenilmeSayisi;
    private Long userId;

    @Override
    public void addWhereClause(CriteriaBuilder criteriaBuilder, CriteriaQuery<Note> query) {
        Root root = (Root) query.getRoots().toArray()[0];

        List<Predicate> predicateList = new ArrayList<Predicate>();
        if (id != null) {
            Predicate titleClause = criteriaBuilder.equal(root.get("id"), id);
            predicateList.add(titleClause);
        }
        if (StringUtils.hasText(konu)) {
            Predicate descriptionClause = criteriaBuilder.like(root.get("konu"), "%" + konu + "%");
            predicateList.add(descriptionClause);
        }
        if (StringUtils.hasText(icerik)) {
            Predicate descriptionClause = criteriaBuilder.like(root.get("icerik"), "%" + icerik + "%");
            predicateList.add(descriptionClause);
        }
        if (kayitTarihi != null) {
            Predicate descriptionClause = criteriaBuilder.equal(root.get("kayitTarihi"), kayitTarihi);
            predicateList.add(descriptionClause);
        }
        if (begenilmeSayisi != null) {
            Predicate descriptionClause = criteriaBuilder.equal(root.get("begenilmeSayisi"), begenilmeSayisi);
            predicateList.add(descriptionClause);
        }
        if (userId != null) {
            Join<Note, User> join = root.join("user", JoinType.LEFT);
            Predicate descriptionClause = criteriaBuilder.equal(join.get("id"), userId);
            predicateList.add(descriptionClause);
        }

        Predicate[] pp = new Predicate[predicateList.size()];
        query.where(predicateList.toArray(pp));
    }

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
