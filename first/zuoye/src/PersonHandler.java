import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @备注
 */
public class PersonHandler extends DefaultHandler {

    // 存储正在解析的元素的数据
    private Map<String, String> map = null;
    // 存储所有解析的元素的数据
    private List<Map<String, String>> list = null;
    // 正在解析的元素的/**
    // *
    // * 基于SAX解析XML文件,根据某个节点标签获取该节点下的所有子元素内容(只能拿到一级元素)。
    // *
    // *
    // * @author xuyi3
    // * @2016年7月20日 @下午1:37:48
    // * @PersonHandler
    // * @功能说明:<br>
    // * @春风十里不如你名字
    private String currentTag = null;
    // 正在解析的元素的元素值
    private String currentValue = null;
    // 开始解析的元素
    private String nodeName = null;

    public PersonHandler() {

    }

    public PersonHandler(String nodeName) {
        this.nodeName = nodeName;
    }

    public List<Map<String, String>> getList() {
        return list;
    }

    @Override
    public void startDocument() throws SAXException {

        list = new ArrayList<Map<String, String>>();

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (nodeName.equals(qName)) {
            map = new HashMap<String, String>();
        }
        if (attributes != null && map != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String key = attributes.getQName(i);
                String value = attributes.getValue(i);
                map.put(key, value);
            }
        }
        currentTag = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (currentTag != null && map != null) {
            currentValue = new String(ch, start, length);
            if (currentValue != null && !currentValue.trim().equals("") && !currentValue.trim().equals("\n")) {
                map.put(currentTag, currentValue);
            }
        }

        currentTag = null;
        currentValue = null;

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        // 解析完该元素之后,将map加入到List集合中,然后清空map解析下一个元素。
        if (nodeName.equals(qName)) {
            list.add(map);
            System.out.println("===" + list);
            map = null;
        }

    }

    @Override
    public void endDocument() throws SAXException {

    }

}

