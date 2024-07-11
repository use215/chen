package cn.edu.lingnan.util;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    //输入参数为XML和XSD两个文件，只能两个文件名；输出参数为：成功或者失败
    public static boolean validate(String _xmlFileName,String _xsdFileName){
        boolean flag = false;
        try{
            //1  创建模式工厂SchemaFactory
            SchemaFactory schemaFactory = SchemaFactory.newInstance
                    ("http://www.w3.org/2001/XMLSchema");
            //2  通过XSD文件创建Schema
            File file = new File(_xsdFileName);
            Schema schema= schemaFactory.newSchema(file);
            //3 由模式创建验证器Validator
            Validator validator = schema.newValidator();
            //4 使用验证器验证XML文件
            StreamSource streamSource = new StreamSource(_xmlFileName);
            validator.validate (streamSource);
            flag = true;
        } catch (org.xml.sax.SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("[Debug] XML 验证器验证失败......");
            throw new RuntimeException(e);
        }
        //



        return flag;
    }
}

