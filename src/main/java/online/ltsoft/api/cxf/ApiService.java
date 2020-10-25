package online.ltsoft.api.cxf;

import javax.jws.WebService;
import java.util.Map;

@WebService(targetNamespace="http://cxf.api.ltsoft.online", name="ApiService")
public interface ApiService {
    Map<String,Object> testApi(String code);
}