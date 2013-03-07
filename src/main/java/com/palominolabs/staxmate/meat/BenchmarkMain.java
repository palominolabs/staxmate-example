package com.palominolabs.staxmate.meat;

import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

final class BenchmarkMain {

    private static final int ITERATIONS = 1000000;

    public static void main(String[] args) throws ParserConfigurationException, XMLStreamException, IOException,
        SAXException {
        MeatXmlParser parser = new MeatXmlParser();

        System.out.println("This benchmark is very simple. If you need real benchmarking, use something like Caliper.");

        System.out.println("Running stax");

        runStax(parser);

        long staxStart = System.nanoTime();

        runStax(parser);

        long staxEnd = System.nanoTime();

        System.out.println("Stax ns per iteration: " + (staxEnd - staxStart) / ITERATIONS);

        System.out.println("Running dom");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        runDom(db);

        long domStart = System.nanoTime();

        runDom(db);

        long domEnd = System.nanoTime();

        System.out.println("Dom ns per iteration: " + (domEnd - domStart) / ITERATIONS);
    }

    private static void runDom(DocumentBuilder db) throws SAXException, IOException {
        for (int i = 0; i < ITERATIONS; i++) {
            db.parse(BenchmarkMain.class.getResourceAsStream("/sample.xml"));
        }
    }

    private static void runStax(MeatXmlParser parser) throws XMLStreamException {
        for (int i = 0; i < ITERATIONS; i++) {
            parser.parse(BenchmarkMain.class.getResourceAsStream("/sample.xml"));
        }
    }
}
