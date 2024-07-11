package cn.edu.lingnan.test;
import cn.edu.lingnan.util.XmlParser;
import cn.edu.lingnan.util.XmlValidator;
//import com.sun.deploy.xml.XMLParser;

import java.util.HashMap;
import java.util.HashSet;

public class XMLTest {
    public static void main(String[] args) {


//        String xmlFileName="src\\main\\resources\\database. conf. xml";
//        String xsdFileName="src\\main\\resources\\database. conf. xsd";
//        String xmlFileName="target\\classes\\database.conf.xml";
//        String xsdFileName="target\\classes\\database.conf.xsd";
        String xmlFileName="database.conf.xml";
        String xsdFileName="database.conf.xsd";
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(basePath);
        xmlFileName = basePath + xmlFileName;
        xsdFileName = basePath + xsdFileName;
        HashMap<String,String>hm = new HashMap<>();

        if(XmlValidator.validate(xmlFileName, xsdFileName)){
            hm = XmlParser.parser(xmlFileName);
            System.out.println(hm.get("driver"));
            System.out.println(hm.get("url"));
            System.out.println(hm.get("user"));
            System.out.println(hm.get("password"));
        }

//        String xmlFileName="database.conf.xml";
//        String xsdFileName="database.conf.xsd";
//        System.out.println(XmlValidator.validate(xmlFileName, xsdFileName));
    }
}
