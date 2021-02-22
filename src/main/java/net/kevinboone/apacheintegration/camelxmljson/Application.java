package net.kevinboone.apacheintegration.camelxmljson; 

import net.kevinboone.apacheintegration.camelxmljson.model.*; 
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.component.jackson.JacksonDataFormat;

@SpringBootApplication
public class Application extends RouteBuilder 
  {
  public static void main(String[] args) 
    {
    SpringApplication.run(Application.class, args);
    }

  @Override
  public void configure() throws Exception 
    {
    JAXBContext jaxbContext = JAXBContext.newInstance (Customer.class);
    JaxbDataFormat jaxbDataFormat = new JaxbDataFormat (jaxbContext);
    JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Customer.class);

    from ("file://in")
        .log(">>> ${body}")
        .unmarshal(jaxbDataFormat) 
       	.log("name: ${body.getName}")
       	.log("ID: ${body.getId}")
	.marshal (jsonDataFormat)
        .log(">>> ${body}");
    }
  }



