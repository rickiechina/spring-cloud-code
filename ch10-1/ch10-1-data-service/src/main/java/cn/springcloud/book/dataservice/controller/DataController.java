package cn.springcloud.book.dataservice.controller;

import cn.springcloud.book.common.context.UserContextHolder;
import cn.springcloud.book.common.vo.User;
import cn.springcloud.book.dataservice.config.DataConfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhudeming
 */
@RestController
public class DataController {
    
	@Autowired
	private DataConfig dataConfig;
	
    @GetMapping("/getContextUserId")
    public String getContextUserId(){
        if(UserContextHolder.currentUser() == null) {
            System.out.println("current user is null. #####");
            return "==current user is null. ==";
        }
        String userId = UserContextHolder.currentUser().getUserId();
        return userId;
    }

    @RequestMapping(value = "/getContextUserId2", method = RequestMethod.POST)
    public String getContextUserId2(@RequestBody User user) {
        String userId = user == null ? "NULL":user.getUserId();
        System.out.println("getContextUserId2 ======"  + userId + " =========");
        return userId;
    }
    
    @GetMapping("/getDefaultUser")
    public String getDefaultUser(){
        return dataConfig.getDefaultUser();
    }
    
    @GetMapping("/getProviderData")
    public List<String> getProviderData(){
    	List<String> provider = new ArrayList<String>();
    	provider.add("Beijing Company");
    	provider.add("Shanghai Company");
    	provider.add("Shenzhen Company");
        return provider;
    }
    
}
