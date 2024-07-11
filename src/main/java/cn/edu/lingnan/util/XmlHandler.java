package cn.edu.lingnan.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class XmlHandler extends DefaultHandler {
    StringBuffer stringBuffer = new StringBuffer();
    HashMap<String,String> hm= new HashMap<>();

    public HashMap<String, String> getHm() {
        return hm;
    }

    //这里是标签开始的时候执行，初始化操作
    @Override
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
            throws SAXException
    {
        stringBuffer.delete(0,stringBuffer.length());

    }



    //这里是标签结束的时候执行，收尾操作
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        hm.put(qName.toLowerCase(), stringBuffer.toString().trim());
    }


    //读到标签之间的内容执行，处理这些内容
    @Override
    public void characters (char ch[], int start, int length)
            throws SAXException
    {
        stringBuffer.append(ch,start,length);
    }


}
