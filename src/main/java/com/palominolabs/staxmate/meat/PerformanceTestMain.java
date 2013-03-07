package com.palominolabs.staxmate.meat;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

final class PerformanceTestMain {
    public static void main(String[] args) throws ParserConfigurationException, XMLStreamException, IOException,
        SAXException {
        MeatXmlParser parser = new MeatXmlParser();

        System.out.println("Running stax");

        for (int i = 0; i < 100000; i++) {
            parser.parse(PerformanceTestMain.class.getResourceAsStream("/sample.xml"));
        }

        long staxStart = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            parser.parse(PerformanceTestMain.class.getResourceAsStream("/sample.xml"));
        }
        long staxEnd = System.nanoTime();

        System.out.println("Stax millis: " + (staxEnd - staxStart) / 1000000);

        System.out.println("Running dom");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        for (int i = 0; i < 100000; i++) {
            db.parse(PerformanceTestMain.class.getResourceAsStream("/sample.xml"));
        }

        long domStart = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            db.parse(PerformanceTestMain.class.getResourceAsStream("/sample.xml"));
        }

        long domEnd = System.nanoTime();

        System.out.println("Dom millis: " + (domEnd - domStart) / 1000000);
    }
}
