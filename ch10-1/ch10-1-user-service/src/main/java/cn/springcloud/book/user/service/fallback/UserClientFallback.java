package cn.springcloud.book.user.service.fallback;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.springcloud.book.common.vo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.springcloud.book.user.service.IUserService;
import cn.springcloud.book.user.service.dataservice.DataService;	

/**
 */
@Component
public class UserClientFallback implements DataService{
	
	@Override
	public String getDefaultUser() {
		return new String("get getDefaultUser failed");
	}
	@Override
	public String getContextUserId() {
		return new String("get getContextUserId failed");
	}

	@Override
	public String getContextUserId2(User user) {
		return new String("No user found.");
	}

	@Override
	public List<String> getProviderData() {
		return Arrays.asList("Error - get provider data.");
	}

}
