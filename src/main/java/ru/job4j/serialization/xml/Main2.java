package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main2 {
    public static void main(String[] args) throws Exception {
        Intercom2 intercom2 = new Intercom2(123, "BewardDKS", true, new HwFw2("5.3.2.1.1", "3.1.5.5.5.46"),
                new String[] {"ул. Программистов", "д. 32"});
        JAXBContext context = JAXBContext.newInstance(Intercom2.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(intercom2, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Intercom2 result = (Intercom2) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}