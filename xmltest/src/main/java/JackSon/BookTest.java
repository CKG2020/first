package JackSon;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.io.IOException;
import java.io.InputStream;

public class BookTest {
    public static void main(String[] args) {
        InputStream input = BookTest.class.getResourceAsStream("JackSon.xml");
//        InputStream is = BookTest.getClass().getClassLoader().getResourceAsStream("JackSon.xml");
        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper mapper = new XmlMapper(module);
        Book book = null;
        try {
            book = mapper.readValue(input, Book.class);
//            readValue(InputStream, Class)直接读取XML并返回一个JavaBean
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(book.id);
        System.out.println(book.name);
        System.out.println(book.author);
        System.out.println(book.isbn);
        System.out.println(book.tags);
        System.out.println(book.pubDate);

    }
}
