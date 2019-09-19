package com.uniyaz.note;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sun.org.apache.xerces.internal.util.XMLInputSourceAdaptor;
import com.sun.org.apache.xerces.internal.xni.parser.XMLInputSource;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ContentType;
import com.uniyaz.note.dto.NoteDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.AbstractXmlHttpMessageConverter;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;

import javax.xml.bind.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.attachment.AttachmentMarshaller;
import javax.xml.bind.helpers.AbstractMarshallerImpl;
import javax.xml.bind.util.JAXBSource;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import java.io.*;
import java.util.List;

/**
 * @author Kübra VARICI
 */
public class GokceKubra extends AbstractXmlHttpMessageConverter<Object> {

    @Override
    protected Object readFromSource(Class<?> aClass, HttpHeaders httpHeaders, Source source) throws Exception {
        String json = "{\"konu\":\"asdf\"}";
        return json;
    }

    @Override
    protected void writeToResult(Object o, HttpHeaders httpHeaders, Result result) throws Exception {

    }

    @Override
    protected boolean supports(Class<?> aClass) {
        System.out.println("TEST3");
        return true;
    }
}
