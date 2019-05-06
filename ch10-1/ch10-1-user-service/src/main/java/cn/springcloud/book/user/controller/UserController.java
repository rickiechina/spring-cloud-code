package cn.springcloud.book.user.controller;


import java.util.List;

import cn.springcloud.book.common.context.UserContextHolder;
import cn.springcloud.book.common.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.springcloud.book.user.service.IUserService;

/**
 * 
 */
@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	/**
	 * 获取配置文件中系统默认用户
	 * @return
	 */
    @GetMapping("/getDefaultUser")
    public String getDefaultUser(){
        return userService.getDefaultUser();
    }
    
    /**
     * 获取上下文用户
     * @return
     */
    @GetMapping("/getContextUserId")
    public String getContextUserId(){
        String tmp = userService.getContextUserId();
        System.out.println(tmp);

        return tmp;
    }
    
    /**
     * 获取供应商数据
     * @return
     */
    @GetMapping("/getProviderData")
    public List<String> getProviderData(){
        return userService.getProviderData();
    }

    @GetMapping("/getProviderData2")
    public List<String> getProviderData2() {
        return userService.getProviderData2();
    }

    @GetMapping("/getContextUserId2")
    public String getContextUserId2() {

        System.out.println("==== INPUT: " + UserContextHolder.currentUser().getUserId());

        // result
        String tmp = userService.getContextUserId2(UserContextHolder.currentUser());
        System.out.println(tmp);

        return tmp;
    }
}
