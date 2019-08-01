package com.uniyaz.note;

import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.xml.AbstractXmlHttpMessageConverter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

/**
 * @author Kübra VARICI
 */
public class GokceKubra extends AbstractXmlHttpMessageConverter<Object> {

    @Override
    protected Object readFromSource(Class<?> aClass, HttpHeaders httpHeaders, Source source) throws Exception {
        System.out.println("TEST1");
        return null;
    }

    @Override
    protected void writeToResult(Object o, HttpHeaders httpHeaders, Result result) throws Exception {
        System.out.println("TEST2");
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        System.out.println("TEST3");
        return false;
    }
}
