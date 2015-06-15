package com.oba.web.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtil {
    
    private Image img;  
    private int width;  
    private int height; 
    private String impressURL;
 
    /** 
     * 构造函数 
     */  
    public ImageUtil(String fileName) throws IOException {  
        File file = new File(fileName);// 读入文件  
        img = ImageIO.read(file);      // 构造Image对象  
        width = img.getWidth(null);    // 得到源图宽  
        height = img.getHeight(null);  // 得到源图长  
    }  


	public static String uploadFiles(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {      	
        request.setCharacterEncoding("utf-8");  
        //获得磁盘文件条目工厂。  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //获取文件上传需要保存的路径，upload文件夹需存在。  
        String path = InitConfig.AUTO_UPLOAD_PATH;  
        //设置暂时存放文件的存储室，这个存储室可以和最终存储文件的文件夹不同。因为当文件很大的话会占用过多内存所以设置存储室。  
        factory.setRepository(new File(path));  
        //设置缓存的大小，当上传文件的容量超过缓存时，就放到暂时存储室。  
        factory.setSizeThreshold(1024*1024);  
        //上传处理工具类（高水平API上传处理？）  
        ServletFileUpload upload = new ServletFileUpload(factory);            
        try{  
            //调用 parseRequest（request）方法  获得上传文件 FileItem 的集合list 可实现多文件上传。  
            List<FileItem> list = (List<FileItem>)upload.parseRequest(request);  
            for(FileItem item:list){  
                //获取表单属性名字。  
                String name = item.getFieldName();  
                //如果获取的表单信息是普通的文本信息。即通过页面表单形式传递来的字符串。  
                if(item.isFormField()){  
                    //获取用户具体输入的字符串，  
                    String value = item.getString();  
                    request.setAttribute(name, value);  
                }  
                //如果传入的是非简单字符串，而是图片，音频，视频等二进制文件。  
                else{   
                    //获取路径名  
                    String value = item.getName();  
                    //取到最后一个反斜杠。  
                    int start = value.lastIndexOf("\\");  
                    //截取上传文件的 字符串名字。+1是去掉反斜杠。  
                    String filename = value.substring(start+1);  
                    request.setAttribute(name, filename);  
                      
                    /*第三方提供的方法直接写到文件中。 
                     * item.write(new File(path,filename));*/  
                    //收到写到接收的文件中。  
                    OutputStream out = new FileOutputStream(new File(path,filename));  
                    InputStream in = item.getInputStream();  
                      
                    int length = 0;  
                    byte[] buf = new byte[1024];  
                    System.out.println("获取文件总量的容量:"+ item.getSize());  
                      
                    while((length = in.read(buf))!=-1){  
                        out.write(buf,0,length);  
                    }  
                    in.close();  
                    out.close();  
                }  
            }  
           
        }catch(Exception e){  
            e.printStackTrace();  
        }
        return path;       
    }  
 
        
        /** 
         * 构造函数 
         * @return 
         */  
        public void ImgCompress(String fileName) throws IOException {  
            File file = new File(fileName);// 读入文件  
            img = ImageIO.read(file);      // 构造Image对象  
            width = img.getWidth(null);    // 得到源图宽  
            height = img.getHeight(null);  // 得到源图长  
        }  
        /** 
         * 按照宽度还是高度进行压缩 
         * @param w int 最大宽度 
         * @param h int 最大高度 
         */  
        public String resizeFix(int w, int h) throws IOException {  
            if (width / height > w / h) {  
               return resizeByWidth(w);  
            } else {  
            	return resizeByHeight(h);  
            }  
        }  
        /** 
         * 以宽度为基准，等比例放缩图片 
         * @param w int 新宽度 
         */  
        public String resizeByWidth(int w) throws IOException {  
            int h = (int) (height * w / width);  
            return resize(w, h);  
        }  
        /** 
         * 以高度为基准，等比例缩放图片 
         * @param h int 新高度 
         */  
        public String resizeByHeight(int h) throws IOException {  
            int w = (int) (width * h / height);  
            return resize(w, h);  
        }  
        /** 
         * 强制压缩/放大图片到固定的大小 
         * @param w int 新宽度 
         * @param h int 新高度 
         */  
        public String resize(int w, int h) throws IOException {  
            // SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢  
            BufferedImage image = new BufferedImage(w, h,BufferedImage.TYPE_INT_RGB );   
            image.getGraphics().drawImage(img, 0, 0, w, h, null); // 绘制缩小后的图  
            impressURL = InitConfig.AUTO_IMG_URL+"/"+DateUtil.formatDate2ShortStringNoG(new Date())+"/"+Identities.uuid2()+".jpg";
            File destFile = new File(impressURL);  
            FileOutputStream out = new FileOutputStream(destFile); // 输出到文件流  
            //可以正常实现bmp、png、gif转jpg  
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
            encoder.encode(image); // JPEG编码  
            out.close();  
            return impressURL;
        }  
        
        public static void main(String[] args) throws Exception {  
            System.out.println("开始：" + new Date().toLocaleString());  
            ImageUtil imgCom = new ImageUtil("d:\\123.jpg");  
            System.out.println(imgCom.resizeFix(400, 400));  
            System.out.println("结束：" + new Date().toLocaleString());  
        }  
}
