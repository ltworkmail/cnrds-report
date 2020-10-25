package online.ltsoft.config;

import online.ltsoft.common.cxf.ApiService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;
    @Autowired
    private ApiService apiService;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, apiService);
        endpoint.publish("/apiService");
        return endpoint;
    }

}
