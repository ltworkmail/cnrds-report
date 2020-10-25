package online.ltsoft.common.cxf;

import javax.jws.WebService;
import java.util.Map;

@WebService(targetNamespace="http://cxf.common.ltsoft.online", name="ApiService")
public interface ApiService {
    Map<String,Object> testApi(String code);
}