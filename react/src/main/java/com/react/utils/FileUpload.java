package com.react.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * name
 *
 * @author yuehaiming
 * @version 1.0.0.0
 * @date 2018/12/15 19:41
 */
public class FileUpload {

    /**保存上传的图片文件
     *
     * @param file
     * @return
     */
    public static String fileUpload(MultipartFile file){
        if (file.isEmpty()) {
            return "error";
        }

        String fileName = file.getOriginalFilename();
//        String filePath = "/home/images/";
//        String filePath = "C:/Users/13002/Desktop/test/";

        String postfix = fileName.substring(fileName.lastIndexOf("."),fileName.length());

        //组装新的 文件名称
        String fileName2 = UUIDUtil.getUUID() + postfix;
        System.out.println(fileName2);

        File dest = new File(StaticDataName.IMGPATH + fileName2);
        try {
            file.transferTo(dest);
            System.out.println("上传成功");
            //成功返回文件名称
            return fileName2;
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return "error";
    }

    /**保存上传的markdown文本为 .md 文件
     *
     * @param markdown markdown文本字符串
     * @return 返回保存文件的文件名 失败返回 error
     */
    public static String saveMarkdown(String markdown){
        BufferedWriter out = null;

        try {
            String _fileName = UUIDUtil.getUUID();
            String fileName = _fileName + ".md";
            out = new BufferedWriter(new FileWriter(StaticDataName.MDPATH + fileName));
            out.write(markdown);
            out.close();
            System.out.println(fileName + "--文件创建成功！");
            return _fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
    }

    public static String readMarkdown(String mdName){
        InputStreamReader read = null;
        BufferedReader bufferedReader = null;
        try{
            String encoding = "UTF-8";
            File file = new File(StaticDataName.MDPATH + mdName + ".md");
            if (file.isFile() && file.exists()) { //判断文件是否存在
                read = new InputStreamReader(new FileInputStream(file), encoding);//考虑到编码格式
                bufferedReader = new BufferedReader(read);
                String lineTxt = "";
                String markdownText = "";
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    //读取每一行的文本 在末尾添加换行符
                    markdownText += lineTxt + System.getProperty("line.separator");
                }
                read.close();
                return markdownText;
            } else {
                System.out.println("找不到指定的文件");
                return "error";
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }finally {
            try {
                read.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "error";
    }
}
