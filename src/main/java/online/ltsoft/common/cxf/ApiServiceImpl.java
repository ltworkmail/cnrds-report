package online.ltsoft.api.cxf;

import online.ltsoft.common.cxf.ApiService;
import org.springframework.stereotype.Component;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@Component
@WebService(targetNamespace="http://cxf.common.ltsoft.online", endpointInterface= "online.ltsoft.common.cxf.ApiService", name="ApiService")
public class ApiServiceImpl implements ApiService {
    @Override
    public Map<String,Object> testApi(String code) {
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("name", "美好的回忆");
        resultMap.put("address", "安徽合肥");
        resultMap.put("company", "科大国创软件股份有限公司");
        return resultMap;
    }

}
