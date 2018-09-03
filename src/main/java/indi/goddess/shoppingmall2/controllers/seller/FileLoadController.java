package indi.goddess.shoppingmall2.controllers.seller;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
* 文件上传下载.
*
*/
@Controller
@RequestMapping("/seller/fileload/")
public class FileLoadController{

    @RequestMapping(value = "uploadFile.do", method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam("fileName") MultipartFile file){
        if(file.isEmpty()){
            return "false";
        }
        String fileName = file.getOriginalFilename();//z.png
	    //System.out.println(fileName);
		if(fileName.contains("\\")){
			fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
		}

	    int size = (int) file.getSize();
        //fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
//        System.out.println(fileName + "-->" + size);

        String path = System.getProperty("user.dir");//   /Users/apple/Desktop/IDEAWORKSPACE/day2/shoppingmall2
        File dest = new File(path+"/target/classes/static/img" + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            return "{\"img_path\":\"http://localhost:8080/img/"+fileName+"\"}";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        }
    }


}
