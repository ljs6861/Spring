package kr.bit.frontcontroller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import kr.bit.controller.Controller;

public class HandlerMapping {

		//mList.do --> MemoListController
	private Map<String, Controller> mappings;
	
	public HandlerMapping(){
		mappings = new HashMap<String, Controller>();
		init();
	}
	private void init(){
		String configXML = "kr/bit/frontcontroller/mappings.xml";
		ClassLoader loader=this.getClass().getClassLoader();
		URL pathURL = loader.getResource(configXML);
		
	
		DocumentBuilderFactory builder= DocumentBuilderFactory.newInstance(); 
		//xml 데이터를 로딩해서 집어넣으려고 만듬. 객체생성하지않고.. 싱글톤? 패턴.
		
		try{
			DocumentBuilder docb = builder.newDocumentBuilder();
			Document document= docb.parse(pathURL.openStream());
			NodeList list = document.getElementsByTagName("command");
			for(int i=0; i<list.getLength(); i++){
				Element element =(Element) list.item(i);	//<command>~
				String key= element.getAttribute("key");		//mList.mo
				String value=element.getAttribute("value");	//kr.bit.contorller.MemoListController
				mappings.put(key, (Controller)Class.forName(value).newInstance());
						
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public Controller getController(String reqCmd){
		return mappings.get(reqCmd);
	}
}
