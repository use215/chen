package cn.edu.lingnan.util;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class XmlParser {
    public static HashMap<String,String> parser(String  _xmlFileName){
        HashMap<String,String> hm = new HashMap<>();
        try{
            //1 实例化一个SAXParserFactory对象：
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //2 通过factory获得一个SAXParser对象，即SAX解析器：
            SAXParser saxParser = factory.newSAXParser();
            //3 saxParser对象调用prase方法解析XML文件
            File file = new File(_xmlFileName);
            XmlHandler xmlHandler = new XmlHandler();
            saxParser.parse( file,  xmlHandler);
            hm = xmlHandler.getHm();

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return hm;
    }

}
