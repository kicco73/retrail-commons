/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cnr.iit.retrail.commons;

import com.sun.org.apache.xerces.internal.dom.DOMOutputImpl;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author oneadmin
 */
public class DomUtils {
    public static void write(Node n, OutputStream out) throws TransformerException {
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(n);

            // Output to console for testing
            StreamResult result = new StreamResult(out);
            transformer.transform(source, result);
    }
        
    public static String toString(Node n) {
        String xml = null;
        try {
            
            StringWriter writer = new StringWriter();
           Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(new DOMSource(n), new StreamResult(writer));
            xml = writer.toString();
        } catch (TransformerException ex) {
            Logger.getLogger(DomUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xml;
    }
    
    public static Document newDocument() throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	return dBuilder.newDocument();
    }
    
    public static Document read(String data) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc;
        doc = dBuilder.parse(new InputSource(new ByteArrayInputStream(data.getBytes("utf-8"))));
        return doc;
    }
}