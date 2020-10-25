package online.ltsoft.config;

import online.ltsoft.common.cxf.ApiService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {
    @Autowired
    Bus bus;
    @Autowired
    private ApiService apiService;

    @Bean("cxfServletRegistration")
    public ServletRegistrationBean createServletRegistrationBean() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, apiService);
        endpoint.publish("/apiService");
        return endpoint;
    }

}
