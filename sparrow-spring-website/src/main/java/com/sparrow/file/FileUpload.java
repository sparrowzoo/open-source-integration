package com.sparrow.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

/**
 * created by harry on 2016/3/14.
 */
@Controller
public class FileUpload {
    @RequestMapping(value = "/upload.do", method = RequestMethod.POST)
    public void upload(HttpServletRequest request, HttpServletResponse response) {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iterator = multipartRequest.getFileNames();
        String webUrl = "";


        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();

        String fileKey = iterator.next();
        MultipartFile file = multipartRequest.getFile(fileKey);

        String fileName = file.getOriginalFilename(); //获得上传的文件名（IE上是文件全路径，火狐等浏览器仅文件名）
        if (fileName.contains("\\")) {
            fileName = fileName.substring(fileName.lastIndexOf('\\') + 1);
        }
        // webUrl = uploadService.uploadFile(pathType, fileName, file.getInputStream());
        // if (BUtils.isBlank(webUrl)) {
        //     return this.result(ERROR_TYPE.UPLOAD_SERVICE_ERROR);
        // }

        //return this.result(new Result<String>(webUrl));
    }
}
