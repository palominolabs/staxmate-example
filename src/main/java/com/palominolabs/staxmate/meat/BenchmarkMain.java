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

        for (int i = 0; i < ITERATIONS; i++) {
            parser.parse(BenchmarkMain.class.getResourceAsStream("/sample.xml"));
        }

        long staxStart = System.nanoTime();

        for (int i = 0; i < ITERATIONS; i++) {
            parser.parse(BenchmarkMain.class.getResourceAsStream("/sample.xml"));
        }
        long staxEnd = System.nanoTime();

        System.out.println("Stax ns per iteration: " + (staxEnd - staxStart) / ITERATIONS);

        System.out.println("Running dom");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        for (int i = 0; i < ITERATIONS; i++) {
            db.parse(BenchmarkMain.class.getResourceAsStream("/sample.xml"));
        }

        long domStart = System.nanoTime();

        for (int i = 0; i < ITERATIONS; i++) {
            db.parse(BenchmarkMain.class.getResourceAsStream("/sample.xml"));
        }

        long domEnd = System.nanoTime();

        System.out.println("Dom ns per iteration: " + (domEnd - domStart) / ITERATIONS);
    }
}
