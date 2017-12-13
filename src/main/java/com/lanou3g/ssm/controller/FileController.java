package com.lanou3g.ssm.controller;

import com.lanou3g.ssm.exception.DefaultException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by dllo on 17/12/1.
 */
@Controller
public class FileController {

    @RequestMapping("/upload")
    public String upload(
            String description,
            MultipartFile file,
            HttpServletRequest request
    ) {
        System.out.println(description);
        try {
            String realPath = request.getServletContext().getRealPath("file");
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
//            获取到上传文件的名字
            String filename = file.getOriginalFilename();

            File file1 = new File(dir, filename);



            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            InputStream inputStream = file.getInputStream();



            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
            fileOutputStream.close();
        } catch (IOException e) {
            throw new DefaultException("文件上传失败");
        } finally {

            return "success";
        }
    }

}
