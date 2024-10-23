package pe.edu.cibertec.dswii_ef_soap_pena_geraldine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class HotelWsdlConfig {

    @Bean(name = "hoteles")
    public DefaultWsdl11Definition hotelesWsdl11Definition(XsdSchema hotelEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("HotelPort");
        wsdl11Definition.setLocationUri("/ws/hoteles");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(hotelEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema hotelEsquema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/hotel.xsd"));
    }
}
