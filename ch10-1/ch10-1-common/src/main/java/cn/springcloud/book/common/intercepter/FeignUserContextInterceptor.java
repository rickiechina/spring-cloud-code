package cn.springcloud.book.common.intercepter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import cn.springcloud.book.common.context.UserContextHolder;
import cn.springcloud.book.common.vo.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 *  Feign传递用户上下文
 *  @author zhudeming
 */
public class FeignUserContextInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		User user = UserContextHolder.currentUser();
        System.out.println(user == null? "### user为空！": "### user不为空！");

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
		if(attributes == null) {
            System.out.println("=== attributes is null. ===");
            return;
        }
		HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                template.header(name, values);
            }
        }
	}
}
