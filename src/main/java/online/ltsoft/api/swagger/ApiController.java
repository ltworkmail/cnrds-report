package online.ltsoft.api.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
@Api(tags="ApiController", value="接口测试入口类")
public class ApiController {
    @RequestMapping(value="/testApi", method=RequestMethod.POST)
    @ApiOperation(value="测试接口", notes="根据主键code获取测试数据")
    @ApiImplicitParam(name="code", value="主键code", required=true, dataType="String", paramType="query")
    public Map<String,Object> testApi(@RequestParam String code) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("name", "美好的回忆");
        resultMap.put("address", "安徽合肥");
        resultMap.put("company", "科大国创软件股份有限公司");
        //Map<String,Object> resultMap = apiService.testApi(code);
        return resultMap;
    }
}