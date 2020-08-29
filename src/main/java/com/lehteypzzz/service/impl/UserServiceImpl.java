package com.lehteypzzz.service.impl;

import com.lehteypzzz.entity.User;
import com.lehteypzzz.mapper.UserMapper;
import com.lehteypzzz.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lehteypzzz
 * @since 2020-08-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
