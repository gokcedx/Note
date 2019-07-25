package com.uniyaz.note.dto.queryfilter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author Kübra VARICI
 */
public abstract class QueryFilterDto <T> {

    public abstract void addWhereClause(CriteriaBuilder criteriaBuilder, CriteriaQuery<T> query);
}
