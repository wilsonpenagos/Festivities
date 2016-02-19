package com.fest.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fest.formatters.FestivityDateFormatter;

/**
 * Implements XML extraction by direct read using a simple startegy found on the web
 * @author Wilson
 *
 */
public class DirectFestLoader implements XMLFestLoader{

	private static final AtomicLong counter = new AtomicLong();
	
	@Override
	public ArrayList<Festivity> extractTrasnformLoad(String fileName) {
		
		ArrayList<Festivity> result = new ArrayList<Festivity>();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			System.out.println("Error creating the new Document Bulder.");
			e.printStackTrace();
		}
		File file = new File(fileName);
		
        if (file.exists()) {
            Document doc = null;
			try {
				doc = db.parse(file);
			} catch (SAXException | IOException e) {
				System.out.println("Error parsing file from document Bulder.");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("General error parsing file");
				e.printStackTrace();
			}
            Element docEle = doc.getDocumentElement();
            
            NodeList festivityList = docEle.getElementsByTagName("festivity");
            
            for (int i = 0; i < festivityList.getLength(); i++) {
            	
            	Node fest = festivityList.item(i);
            	if (fest.getNodeType() == Node.ELEMENT_NODE) {
            		Element e = (Element) fest;
                    NodeList nameList = e.getElementsByTagName("name");
                    NodeList placeList = e.getElementsByTagName("place");
                    NodeList startList = e.getElementsByTagName("start");
                    NodeList endList = e.getElementsByTagName("end");
                    
                    String name = nameList.item(0).getChildNodes().item(0).getNodeValue();
                    String place = placeList.item(0).getChildNodes().item(0).getNodeValue();
                    Date startDate = FestivityDateFormatter.formatStringWeb(startList.item(0).getChildNodes().item(0).getNodeValue());
            		Date endDate = FestivityDateFormatter.formatStringWeb(endList.item(0).getChildNodes().item(0).getNodeValue());
            		if (startDate != null
            				&& endDate != null
            				&& startDate.before(endDate)
            				&& name != null && !name.isEmpty()
            				&& place != null && !place.isEmpty()) {
            			
            			result.add(new Festivity(counter.incrementAndGet(), name, startDate, endDate, place));
            			
            		}
            	}

            }

        }
        else{
        	System.out.println("The file does not exists.");
        }
        
		return result;
	}

}
