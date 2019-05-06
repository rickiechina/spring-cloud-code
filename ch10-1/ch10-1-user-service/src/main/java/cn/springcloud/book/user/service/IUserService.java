package cn.springcloud.book.user.service;


import cn.springcloud.book.common.vo.User;

import java.util.List;

/**
 */
public interface IUserService {
    public String getDefaultUser();
    public String getContextUserId();
    public String getContextUserId2(User user);
    public List<String> getProviderData();
    public List<String> getProviderData2();
}
