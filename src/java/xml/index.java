package xml;


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

public class index {
    static Document dom = null;
    static Element el = null;
    static Scanner input = new Scanner(System.in);
    static int num = 1;

    public static void main(String[] args) {
        System.err.println("请选择查改删增");
        int ip = input.nextInt();
        getDocument();
        switch (ip) {
            case 1:
                seleadd();
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
    }

    //寻找xml
    public static void getDocument() {
        SAXReader reader = new SAXReader();
        try {
            dom = reader.read("src/java/xml/xmll.xml");
            el = dom.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println(dom);
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
    }

    //修改
    private static void up() {
        Iterator<Element> brands = el.elementIterator();
        System.out.println("请输入需要修改名称");
        String bname = input.next();
        System.out.println("请输入修改后的名称");
        String newbname = input.next();
        while (brands.hasNext()) {
            Element brand = brands.next();
            if (brand.attributeValue("name").equals(bname)) {
                brand.setAttributeValue("name", newbname);
            }
        }
        saveXml();
    }


    //删除
    private static void delete() {
        Iterator<Element> node = el.elementIterator();
        String ip = input.next();
        while (node.hasNext()) {
            Element nodes = node.next();  //获取当节点
            if (nodes.attributeValue("name").equals(ip)) {
                el.remove(nodes);
                System.out.println("删除成功");
                saveXml();
            } else {
                System.out.println("删除失败");
            }
        }
    }

    //对xml操作的方法
    private static void saveXml() {
        XMLWriter writer = null;
        OutputFormat format = null;
        format = OutputFormat.createPrettyPrint();
        try {

            writer = new XMLWriter(new FileWriter("src/java/xmll.xml"), format);
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


    //查询一级节点的值
    private static void seleadd() {
        //根据根节点 获取所有的字节点 nodes
        Iterator<Element> node = el.elementIterator();
        while (node.hasNext()) { //查询有没有值
            Element nodes = node.next();  //获取当节点
            System.out.println("技术==》" + num + nodes.attributeValue("name"));  // 查询节点的Class属性
            if (!nodes.getTextTrim().equals("")) {
                System.out.println(nodes.getTextTrim());// 查询节点内容属性
            }
            GetNode(nodes);
        }
    }

    //递归查询所有子节点的值
    private static void GetNode(Element nodes) {
        Iterator<Element> childNode = nodes.elementIterator();   //子节点的子节点
        while (childNode.hasNext()) {
            Element childNodes = childNode.next();  //获取当节点
            System.out.println("课程==》" + num + childNodes.attributeValue("name"));
            System.out.println("内容==》" + childNodes.attributeValue("address"));
            if (!childNodes.getTextTrim().equals("")) {
                System.out.println("课程计划：" + childNodes.getTextTrim());
            }
            GetNode(childNodes);
        }
    }


}
