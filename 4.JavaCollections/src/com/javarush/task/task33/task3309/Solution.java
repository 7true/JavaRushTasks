package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);
        String xml = writer.toString();

        xml = xml.replaceAll("<" + tagName + ">", "<!--" + comment + "-->\n" + "<" + tagName + ">");
        xml = xml.replaceAll("<" + tagName + "/>", "<!--" + comment + "-->\n" + "<" + tagName + "/>");

        return xml;
    }

    public static void main(String[] args) {


    }
}
