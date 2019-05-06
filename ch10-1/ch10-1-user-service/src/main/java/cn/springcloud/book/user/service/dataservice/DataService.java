package cn.springcloud.book.user.service.dataservice;


import cn.springcloud.book.common.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.springcloud.book.user.service.fallback.UserClientFallback;

import java.util.List;


/**
 * feign调用数据服务
 * @author zhudeming
 *
 */
@FeignClient(name = "sc-data-service") //, fallback=UserClientFallback.class
public interface DataService {
	
	@RequestMapping(value = "/getDefaultUser", method = RequestMethod.GET)
    public String getDefaultUser();
    
    @RequestMapping(value = "/getContextUserId", method = RequestMethod.GET)
    public String getContextUserId();

    @RequestMapping(value = "/getContextUserId2", method = RequestMethod.GET)
    public String getContextUserId2(@RequestBody User user);

    @RequestMapping(value = "/getProviderData", method = RequestMethod.GET)
    public List<String> getProviderData();
}
