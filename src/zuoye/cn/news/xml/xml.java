package cn.news.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class xml {
    static Document dom = null;
    static Element el = null;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("请选择; 查改删增");
        getDocument();
        String n = "";
        do {

            switch (input.nextInt()) {
                case 1:
                    sele();
                    break;
                case 2:
                    up();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    add();
                    break;
            }
            System.out.println("是否继续（y/n）");
            n = input.next();
        } while (n != "y");
    }

    //寻找xml
    public static void getDocument() {
        SAXReader reader = new SAXReader();
        try {
            dom = reader.read("src/zuoye/cn/news/xml/xml.xml");
            el = dom.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println(dom);
    }

    //对xml操作的方法
    private static void saveXml() {
        XMLWriter writer = null;
        OutputFormat format = null;
        format = OutputFormat.createPrettyPrint();
        try {

            writer = new XMLWriter(new FileWriter("src/zuoye/cn/news/xml/xml.xml"), format);
            writer.write(dom);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //修改
    private static void up() {
        sele();
        Iterator<Element> brands = el.elementIterator();
        System.out.println("请输入需要修改名称");
        String bname = input.next();
        System.out.println("请输入修改后的名称");
        String newbname = input.next();
        while (brands.hasNext()) {
            Element brand = brands.next();
            if (brand.attributeValue("name").equals(bname)) {
                brand.setAttributeValue("name", newbname);
                System.out.println("修改成功");
                saveXml();
                sele();
            } else {
                System.out.println("修改失败");
            }
        }

    }


    //删除
    private static void delete() {
        sele();
        System.out.println("请问删除什么");
        Iterator<Element> node = el.elementIterator();
        String ip = input.next();
        while (node.hasNext()) {
            Element nodes = node.next();  //获取当节点
            if (nodes.attributeValue("name").equals(ip)) {
                el.remove(nodes);
                System.out.println("删除成功");
                saveXml();
                sele();
            } else {
                System.out.println("删除失败");
            }
        }
    }

    //添加
    private static void add() {
        Element brand = el.addElement("brand");
        System.out.println("请输入名称：");
        String classname = input.next();
        brand.addAttribute("name", classname);

        Element clas = brand.addElement("class");
        System.out.println("请输入名称：");
        String phonename = input.next();
        clas.addAttribute("name", phonename);
        saveXml();
        sele();
    }


    //寻找父节点
    private static void sele() {
        Iterator<Element> node = el.elementIterator();
        while (node.hasNext()) { //查询有没有值
            Element nodes = node.next();  //获取当节点
            System.out.println(nodes.attributeValue("name"));  // 查询节点的Class属性
            if (!nodes.getTextTrim().equals("")) {
                System.out.println(nodes.getTextTrim());// 查询节点内容属性
            }
            GetNode(nodes); //寻找父节点的子节点
        }
    }

    //    递归方法
    private static void GetNode(Element nodes) {
        Iterator<Element> node = nodes.elementIterator();
        while (node.hasNext()) { //查询有没有值
            Element nodess = node.next();  //获取当节点
            System.out.println(nodess.attributeValue("id"));  // 查询节点的Class属性
            if (!nodes.getTextTrim().equals("")) {
                System.out.println(nodess.getTextTrim());// 查询节点内容属性
            }
            GetNode(nodess);//寻找父节点的子节点
        }
    }
}
