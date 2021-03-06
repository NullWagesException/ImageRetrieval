package com.zz.interceptor;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * 图片类型拦截器
 */
public class TypeInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        boolean flag= true;
        // 判断是否为文件上传请求
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartRequest =
                    (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> files =
                    multipartRequest.getFileMap();
            Iterator<String> iterator = files.keySet().iterator();
            //对多部件请求资源进行遍历
            while (iterator.hasNext()) {
                String formKey = (String) iterator.next();
                MultipartFile multipartFile =
                        multipartRequest.getFile(formKey);
                String filename=multipartFile.getOriginalFilename();
                //判断是否为限制文件类型
                if (! checkFile(filename)) {
                    //限制文件类型，请求转发到原始请求页面，并携带错误提示信息
                    request.setAttribute("errormessage", "不支持的文件类型！");
                    try {
                        request.getRequestDispatcher("/error.jsp")
                                .forward(request, response);
                    } catch (ServletException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    flag= false;
                }
            }
        }
        return flag;
    }


    /**
     * 判断是否为允许的上传文件类型,true表示允许
     */
    private boolean checkFile(String fileName) {
        //设置允许上传文件类型
        String suffixList = "jpg,gif,png,ico,bmp,jpeg";
        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".")
                + 1, fileName.length());
        if (suffixList.contains(suffix.trim().toLowerCase())) {
            return true;
        }
        return false;
    }

}
