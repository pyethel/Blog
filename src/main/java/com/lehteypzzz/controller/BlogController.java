package com.lehteypzzz.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lehteypzzz.common.lang.Result;
import com.lehteypzzz.entity.Blog;
import com.lehteypzzz.service.BlogService;
import com.lehteypzzz.util.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lehteypzzz
 * @since 2020-08-14
 */
@RestController
public class BlogController {

    final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage){

        Page<Blog> page = new Page<>(currentPage, 5);
        Page pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("gmt_created"));
        return Result.succ(pageData);
    }


    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable(name = "id") Long id){

        Blog blog = blogService.getById(id);
        Assert.notNull(blog,"该博客已被删除");

        return Result.succ(blog);
    }

    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody Blog blog){

        Blog temp = null;
        if(blog.getId()!=null){
            temp = blogService.getById(blog.getId());
            //只能编辑自己的文章
            Assert.isTrue(temp.getUserId().longValue() == ShiroUtil.getProfile().getId().longValue(),"没有权限编辑");

        }else{
            temp = new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setStatus(0);
        }

        BeanUtil.copyProperties(blog, temp,"id","userId","gmtCreated","status","gmtModified","deleted");
        blogService.saveOrUpdate(temp);

        return Result.succ(null);
    }

    @RequiresAuthentication
    @GetMapping("/blog/delete/{id}")
    public Result delete(@PathVariable(name = "id") Long id){
        blogService.removeById(id);
        return Result.succ(null);
    }
}
