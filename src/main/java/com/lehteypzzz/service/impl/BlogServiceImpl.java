package com.lehteypzzz.service.impl;

import com.lehteypzzz.entity.Blog;
import com.lehteypzzz.mapper.BlogMapper;
import com.lehteypzzz.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
