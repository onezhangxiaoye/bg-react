package com.react.controller;

import com.react.entity.Blogs;
import com.react.service.BlogsService;
import com.react.utils.FileUpload;
import com.react.utils.ResponseData;
import com.react.utils.StaticDataName;
import com.react.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2019/5/22
 */
@Controller
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/BlogsController")
public class BlogsController {

    @Autowired
    private BlogsService blogsService;



    /**添加博客数据
     *
     * @param request
     * @return
     */
    @RequestMapping("/addBlog")
    @ResponseBody
    Map addBlog(HttpServletRequest request) {
        String pass = request.getParameter("pass");
        System.out.print(pass);
        if (pass.equals(StaticDataName.PASS)){
            String markdown = request.getParameter("markdown");

            String fileName = FileUpload.saveMarkdown(markdown);
            if (!fileName.equals("error")){
                String userId = request.getParameter("userId");
                String blogTypeId = request.getParameter("blogTypeId");
                String blogTitle = request.getParameter("blogTitle");
                String _blogTimestamp = request.getParameter("blogTimestamp");
                String blogStatus = request.getParameter("blogStatus");
                LocalDateTime blogTimestamp = TimeUtil.parseDateTime(_blogTimestamp);
                String blogContent = "";
                if (markdown.length() > StaticDataName.CUT_OUT_FONT_NUMBER){
                    blogContent = markdown.substring(StaticDataName.CUT_OUT_FONT_NUMBER);
                }else{
                    blogContent = markdown;
                }

                Blogs blog = new Blogs(Integer.valueOf(userId),Integer.valueOf(blogTypeId),fileName,blogTitle,blogContent,blogTimestamp,Integer.valueOf(blogStatus));

                blogsService.addBlog(blog);

                return ResponseData.creatResponseData(null);
            }
            return ResponseData.creatResponseDataError("发布失败！");
        }else{
            return ResponseData.creatResponseDataError("通行证验证错误！");
        }

    }

    /**根据用户名id 查询其所有博客
     *
     * @param request
     * @return
     */
    @RequestMapping("/selectBlogsByUserId")
    @ResponseBody
    Map selectBlogsByUserId(HttpServletRequest request) {

        String userId = request.getParameter("userId");
        String blogTypeId = request.getParameter("blogTypeId");

        List<Blogs> blogsList = blogsService.selectBlogsByUserId(Integer.valueOf(userId),Integer.valueOf(blogTypeId),0);

        return ResponseData.creatResponseData(blogsList);
    }

    /**通过博客id查询博客详细信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/selectBlogsByBlogId")
    @ResponseBody
    Map selectBlogsByBlogId(HttpServletRequest request) {

        String blogId = request.getParameter("blogId");

        Blogs blog= blogsService.selectBlogsByBlogId(Integer.valueOf(blogId));

        if (blog != null){
            String markdownText = FileUpload.readMarkdown(blog.getBlogFileName());
            if (!markdownText.equals("error")){
                blog.setBlogContent(markdownText);
                return ResponseData.creatResponseData(blog);
            }else{
                return ResponseData.creatResponseDataError("未找到对应文章信息！");
            }
        }else{
            return ResponseData.creatResponseDataError("未找到对应博客信息！");
        }


    }





}

