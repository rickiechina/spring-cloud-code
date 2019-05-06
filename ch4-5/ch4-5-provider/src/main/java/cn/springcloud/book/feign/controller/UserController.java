package cn.springcloud.book.feign.controller;

import cn.springcloud.book.feign.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@RequestBody User user , HttpServletRequest request){
		String token=request.getHeader("oauthToken");
		System.out.println("=== token === " + token);
		if(user != null) {
			System.out.println("=== name === " + user.getName());
		} else {
			System.out.println("======= NO NAME ===========");
		}

		return "hello,"+user.getName();
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser( @RequestBody User user){
		return "hello,"+user.getName();
	}


}
