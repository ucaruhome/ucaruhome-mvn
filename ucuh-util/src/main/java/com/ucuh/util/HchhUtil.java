package com.ucuh.util;

import com.ucuh.entity.LabelPhoto;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class HchhUtil {
	/**生成一个固定的字符串作为用户的编码，（页面上的用户id）
	 * 
	 * @param userID
	 * @return
	 */
	public static  String createString(int userID){
		StringBuffer usercode=new StringBuffer();
		String str="cp00000000000";
		char[] str1=str.toCharArray();
		String s=userID+"";
		char[] s1=s.toCharArray();
		int j=0;
		for(int i=0;i<str1.length;i++){
			if(str1.length-i<=s1.length){
				str1[i]=s1[j];
				j++;
			}
		}
		for(int i=0;i<str1.length;i++){
			usercode.append(str1[i]);
		}
		System.out.println(usercode.toString());
		return usercode.toString();
	}
	
	
	
	/**excel中文本的读取
	 * 
	 * @param excelFile
	 * @param rowNum
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public static List<String[]> readExcel(File excelFile,int rowNum)throws BiffException,IOException{
		//创建一个list用来存取读取出来的内容
		List<String[]> list=new ArrayList<String[]>();
		Workbook rwb=null;
		Cell cell=null;
		try{
		
		//创建输入流
		InputStream stream=new FileInputStream(excelFile);
		//获取excel文件对象
		rwb=Workbook.getWorkbook(stream);
		//获取文件的指定工作表，默认的是第一个
		Sheet sheet=rwb.getSheet(0);
		//行数（表头的目录不需要，从1开始）
		for(int i=rowNum-1;i<sheet.getRows();i++){
			//创建一个数组，用来存储每一列的值
			String[] str=new String[sheet.getColumns()];
			//列数
			for(int j=0;j<sheet.getColumns();j++){
				//获取第i行第j列的值
				cell=sheet.getCell(j, i);
				str[j]=cell.getContents();
				//System.out.println(str[j]);
			}
			//把刚获取的列存入list
			list.add(str);
		}
		stream.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			rwb.close();
			
		}
		//返回list的集合
		return list;
	}
	
	
	
	/**
	 * 以年月日十分秒的+4位随机数的格式来创建一个文件名，不带扩展名
	 */
	public static String createFileName(){
		StringBuffer sb=new StringBuffer();
		Date date=new Date();
		//获取年月日时分秒
		sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(date));
		//毫秒
		String milli=String.valueOf(date.getTime()%1000);
		while(milli.length()<3){
			milli="0"+milli;
		}
		sb.append(milli);
		//四位随即数
		String rondom=String.valueOf(new Random().nextInt(10000));
		while(rondom.length()<4){
			rondom="0"+rondom;
		}
		sb.append(rondom);
		return sb.toString();
	}
	/**
	 * 把字符串转换成md5
	 * @param str
	 * @return
	 */
	public static String strToMD5(String str) {
		byte[] input = str.getBytes();
		return bytesToMD5(input);
	}
	/**
	 * 把字节数组转换成md5
	 * @param input
	 * @return
	 */
	public static String bytesToMD5(byte[] input) {
		String md5str = null;
		try {
			//创建一个提供信息摘要算法的对象，初始化为md5算法对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			//计算后获得字节数组
			byte[] buff = md.digest(input);
			//把数组每一字节换成16进制连成md5字符串
			md5str = bytesToHex(buff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5str;
	}
	/**
	 * 把字节数组转成16进位制数
	 * @param bytes
	 * @return
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuffer md5str = new StringBuffer();
		//把数组每一字节换成16进制连成md5字符串
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			 digital = bytes[i];
			if(digital < 0) {
				digital += 256;
			}
			if(digital < 16){
				md5str.append("0");
			}
			md5str.append(Integer.toHexString(digital));
		}
		return md5str.toString().toUpperCase();
	}
	 /** 
	  * 将图片转成base64码 
	  * @return 
	  */  
	public static String getImageBinary(String imagepath) {  
	    File f = new File(imagepath);  
	    BufferedImage bi;  
	    try {  
	        bi = ImageIO.read(f);  
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
	        ImageIO.write(bi, "jpg", baos);  
	        byte[] bytes = baos.toByteArray();  
	  
	        return new sun.misc.BASE64Encoder().encode(bytes);  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	        return null;
	    }  
	      
	} 

	/** 
     * 将存放在sourceFilePath目录下的源文件,打包成fileName名称的ZIP文件,并存放到zipFilePath。 
     * @param sourceFilePath 待压缩的文件路径 
     * @param zipFilePath    压缩后存放路径 
     * @param fileName       压缩后文件的名称 
     * @return flag 
     */  
    public static boolean fileToZip(String sourceFilePath,String zipFilePath,String fileName) {  
        boolean flag = false;  
        File sourceFile = new File(sourceFilePath);  
        FileInputStream fis = null;  
        BufferedInputStream bis = null;  
        FileOutputStream fos = null;  
        ZipOutputStream zos = null;  
          
        if(sourceFile.exists() == false) {  
            System.out.println(">>>>>> 待压缩的文件目录：" + sourceFilePath + " 不存在. <<<<<<");  
        } else {  
            try {  
                File zipFile = new File(zipFilePath + "/" + fileName + ".zip");  
                if(zipFile.exists()) {  
                    System.out.println(">>>>>> " + zipFilePath + " 目录下存在名字为：" + fileName + ".zip" + " 打包文件. <<<<<<");  
                } else {  
                    File[] sourceFiles = sourceFile.listFiles();  
                    if(null == sourceFiles || sourceFiles.length < 1) {  
                        System.out.println(">>>>>> 待压缩的文件目录：" + sourceFilePath + " 里面不存在文件,无需压缩. <<<<<<");  
                    } else {  
                        fos = new FileOutputStream(zipFile);  
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));  
                        byte[] bufs = new byte[1024*10];  
                        for(int i=0;i<sourceFiles.length;i++) {  
                            // 创建ZIP实体,并添加进压缩包  
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());  
                            zos.putNextEntry(zipEntry);  
                            // 读取待压缩的文件并写进压缩包里  
                            fis = new FileInputStream(sourceFiles[i]);  
                            bis = new BufferedInputStream(fis,1024*10);  
                            int read = 0;  
                            while((read=bis.read(bufs, 0, 1024*10)) != -1) {  
                                zos.write(bufs, 0, read);  
                            }  
                        }  
                        flag = true;  
                    }  
                }  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
                throw new RuntimeException(e);  
            } catch (IOException e) {  
                e.printStackTrace();  
                throw new RuntimeException(e);  
            } finally {  
                // 关闭流  
                try {  
                    
                    if(null!=fis)fis.close();
                    if(null!= zos)zos.close(); 
                    if(null!= bis)bis.close(); 
                    if(null!=fos)fos.close();
                } catch (IOException e) {  
                    e.printStackTrace();  
                    throw new RuntimeException(e);  
                }  
            }  
        }  
          
        return flag;  
    }  
    
 //========================文件的复制=============================================================================   
    public static void fileMove(String from, String to) throws Exception {// 移动指定文件夹内的全部文件  
        try {  
            File dir = new File(from);  
            File[] files = dir.listFiles();// 将文件或文件夹放入文件集  
            if (files == null)// 判断文件集是否为空  
                return;  
            File moveDir = new File(to);// 创建目标目录  
            if (!moveDir.exists()) {// 判断目标目录是否存在  
                moveDir.mkdirs();// 不存在则创建  
            }  
            for (int i = 0; i < files.length; i++) {// 遍历文件集  
                if (files[i].isDirectory()) {// 如果是文件夹或目录,则递归调用fileMove方法，直到获得目录下的文件  
                    fileMove(files[i].getPath(), to + "\\" + files[i].getName());// 递归移动文件  
                    files[i].delete();// 删除文件所在原目录  
                }  
                File moveFile = new File(moveDir.getPath() + "\\"// 将文件目录放入移动后的目录  
                        + files[i].getName());  
                if (moveFile.exists()) {// 目标文件夹下存在的话，删除  
                    moveFile.delete();  
                }  
                files[i].renameTo(moveFile);// 移动文件  
                System.out.println(files[i] + " 移动成功");  
            }  
        } catch (Exception e) {  
            throw e;  
        }  
    }  
  
    // 复制目录下的文件（不包括该目录）到指定目录，会连同子目录一起复制过去。  
    public static void copyFileFromDir(String toPath, String fromPath) {  
        File file = new File(fromPath);  
        createFile(toPath, false);// true:创建文件 false创建目录  
        if (file.isDirectory()) {// 如果是目录  
            copyFileToDir(toPath, listFile(file));  
        }  
    }  
  
    // 复制目录到指定目录,将目录以及目录下的文件和子目录全部复制到目标目录  
    public static void copyDir(String toPath, String fromPath) {  
        File targetFile = new File(toPath);// 创建文件  
        createFile(targetFile, false);// 创建目录  
        File file = new File(fromPath);// 创建文件  
        if (targetFile.isDirectory() && file.isDirectory()) {// 如果传入是目录  
            copyFileToDir(targetFile.getAbsolutePath() + "/" + file.getName(),  
                    listFile(file));// 复制文件到指定目录  
        }  
    }  
  
    // 复制一组文件到指定目录。targetDir是目标目录，filePath是需要复制的文件路径  
    public static void copyFileToDir(String toDir, String[] filePath) {  
        if (toDir == null || "".equals(toDir)) {// 目录路径为空  
            System.out.println("参数错误，目标路径不能为空");  
            return;  
        }  
        File targetFile = new File(toDir);  
        if (!targetFile.exists()) {// 如果指定目录不存在  
            targetFile.mkdir();// 新建目录  
        } else {  
            if (!targetFile.isDirectory()) {// 如果不是目录  
                System.out.println("参数错误，目标路径指向的不是一个目录！");  
                return;  
            }  
        }  
        for (int i = 0; i < filePath.length; i++) {// 遍历需要复制的文件路径  
            File file = new File(filePath[i]);// 创建文件  
            if (file.isDirectory()) {// 判断是否是目录  
                copyFileToDir(toDir + "/" + file.getName(), listFile(file));// 递归调用方法获得目录下的文件  
                System.out.println("复制文件 " + file);  
            } else {  
                copyFileToDir(toDir, file, "");// 复制文件到指定目录  
            }  
        }  
    }  
  
    public static void copyFileToDir(String toDir, File file, String newName) {// 复制文件到指定目录  
        String newFile = "";  
        if (newName != null && !"".equals(newName)) {  
            newFile = toDir + "/" + newName;  
        } else {  
            newFile = toDir + "/" + file.getName();  
        }  
        File tFile = new File(newFile);  
        copyFile(tFile, file);// 调用方法复制文件  
    }  
  
    public static void copyFile(File toFile, File fromFile) {// 复制文件  
        if (toFile.exists()) {// 判断目标目录中文件是否存在  
            System.out.println("文件" + toFile.getAbsolutePath() + "已经存在，跳过该文件！");  
            return;  
        } else {  
            createFile(toFile, true);// 创建文件  
        }  
        System.out.println("复制文件" + fromFile.getAbsolutePath() + "到"  
                + toFile.getAbsolutePath());  
        try {  
            InputStream is = new FileInputStream(fromFile);// 创建文件输入流  
            FileOutputStream fos = new FileOutputStream(toFile);// 文件输出流  
            byte[] buffer = new byte[1024];// 字节数组  
            while (is.read(buffer) != -1) {// 将文件内容写到文件中  
                fos.write(buffer);  
            }  
            is.close();// 输入流关闭  
            fos.close();// 输出流关闭  
        } catch (FileNotFoundException e) {// 捕获文件不存在异常  
            e.printStackTrace();  
        } catch (IOException e) {// 捕获异常  
            e.printStackTrace();  
        }  
    }  
  
    public static String[] listFile(File dir) {// 获取文件绝对路径  
        String absolutPath = dir.getAbsolutePath();// 声获字符串赋值为路传入文件的路径  
        String[] paths = dir.list();// 文件名数组  
        String[] files = new String[paths.length];// 声明字符串数组，长度为传入文件的个数  
        for (int i = 0; i < paths.length; i++) {// 遍历显示文件绝对路径  
            files[i] = absolutPath + "/" + paths[i];  
        }  
        return files;  
    }  
  
    public static void createFile(String path, boolean isFile) {// 创建文件或目录  
        createFile(new File(path), isFile);// 调用方法创建新文件或目录  
    }  
  
    public static void createFile(File file, boolean isFile) {// 创建文件  
        if (!file.exists()) {// 如果文件不存在  
            if (!file.getParentFile().exists()) {// 如果文件父目录不存在  
                createFile(file.getParentFile(), false);  
            } else {// 存在文件父目录  
                if (isFile) {// 创建文件  
                    try {  
                        file.createNewFile();// 创建新文件  
                    } catch (IOException e) {  
                        e.printStackTrace();  
                    }  
                } else {  
                    file.mkdir();// 创建目录  
                }  
            }  
        }  
    }  
  
    //随即生成一个6个数字
    public static String createStringCode(int length){
    	  String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";     
    	    Random random = new Random();     
    	    StringBuffer sb = new StringBuffer();     
    	    for (int i = 0; i < length; i++) {     
    	        int number = random.nextInt(base.length());     
    	        sb.append(base.charAt(number));     
    	    }     
    	    return sb.toString(); 
    }
  //对一个map进行排序
    public static Map sortMap(Map oldMap) {  
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(oldMap.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {  
  
            public int compare(Entry<java.lang.String, Integer> arg0,Entry<java.lang.String, Integer> arg1) {  
                return arg0.getValue() - arg1.getValue();  
            }  
        });  
        Map newMap = new LinkedHashMap();  
        for (int i = 0; i < list.size(); i++) {  
            newMap.put(list.get(i).getKey(), list.get(i).getValue());  
        }  
        return newMap;  
    }
    private static void printMap(Map map){  
        System.out.println("===================mapStart==================");  
        Iterator it = map.entrySet().iterator();  
        while(it.hasNext()){  
            Map.Entry entry = (Map.Entry) it.next();  
            System.out.println(entry.getKey() + ":" + entry.getValue());  
        }  
        System.out.println("===================mapEnd==================");  
    } 
    
    
    
 // 将汉字转换为全拼
    public static String getPingYin(String src) {

        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                // 判断是否为汉字字符
                if (java.lang.Character.toString(t1[i]).matches(
                        "[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    t4 += t2[0];
                } else
                    t4 += java.lang.Character.toString(t1[i]);
            }
            // System.out.println(t4);
            return t4;
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return t4;
    }

    // 返回中文的首字母
    public static String getPinYinHeadChar(String str) {
        String temp = "";
        String demo = "";
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        for(int i=0;i<convert.length();i++){//convert目前为小写首字母,下面是将小写首字母转化为大写
            if(convert.charAt(i)>='a' && convert.charAt(i)<='z'){
                temp=convert.substring(i,i+1).toUpperCase();
                demo += temp;
            }
        }
        return demo;
    }

    // 将字符串转移为ASCII码
    public static String getCnASCII(String cnStr) {
        StringBuffer strBuf = new StringBuffer();
        byte[] bGBK = cnStr.getBytes();
        for (int i = 0; i < bGBK.length; i++) {
            // System.out.println(Integer.toHexString(bGBK[i]&0xff));
            strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
        }
        return strBuf.toString();
    }
    
    
    /** 
     * 读取配置文件 
     * LiChaofei 
     * 2013-1-31 上午9:10:07 
     * @return 
     */  
    public static  Properties loadProperty() {  
        Properties prop=new Properties();  
        try {  
           // FileInputStream is1=new FileInputStream("config.properties");  
            InputStream is=HchhUtil.class.getResourceAsStream("/parameter.properties");  
            prop.load(is);  
            is.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return prop;  
    } 

    /**
     * 得到urlHead的值
     * @param prop
     */
    public static String getUrlHead(Properties prop){
    	String urlHead="http://localhost:8080/hchh";
    	Iterator<String> it = prop.stringPropertyNames().iterator();
        while (it.hasNext()) {
        String key = it.next();
        //System.out.println(key + ":" + prop.getProperty(key));
        if("urlHead".equals(key)){
        	urlHead=prop.getProperty(key);
        }
        }
        return urlHead;
    }
    /**
     * 得到projectName的值
     * @param prop
     */
    public static String getProjectName(Properties prop){
    	String projectName="hchh";
    	Iterator<String> it = prop.stringPropertyNames().iterator();
        while (it.hasNext()) {
        String key = it.next();
        //System.out.println(key + ":" + prop.getProperty(key));
        if("projectName".equals(key)){
        	projectName=prop.getProperty(key);
        }
        }
        return projectName;
    }
    /**
     * 得到maxPageCount的值
     * @param prop
     */
    public static String getMaxPageCount(Properties prop){
    	String maxPageCount="30";
    	Iterator<String> it = prop.stringPropertyNames().iterator();
        while (it.hasNext()) {
        String key = it.next();
        //System.out.println(key + ":" + prop.getProperty(key));
        if("maxPageCount".equals(key)){
        	maxPageCount=prop.getProperty(key);
        }
        }
        return maxPageCount;
    }
    /**
     * 得到labelGrade的值
     * @param prop
     */
    public static String getLabelGrade(Properties prop){
    	String labelGrade="3";
    	Iterator<String> it = prop.stringPropertyNames().iterator();
        while (it.hasNext()) {
        String key = it.next();
        //System.out.println(key + ":" + prop.getProperty(key));
        if("labelGrade".equals(key)){
        	labelGrade=prop.getProperty(key);
        }
        }
        return labelGrade;
    }
    
    /**
     * 得到短信发送的帐户的值
     * @param prop
     */
    public static String getUserName(Properties prop){
    	String sn="SDK-CF-0112";
    	Iterator<String> it = prop.stringPropertyNames().iterator();
        while (it.hasNext()) {
        String key = it.next();
        //System.out.println(key + ":" + prop.getProperty(key));
        if("Sn".equals(key)){
        	sn=prop.getProperty(key);
        }
        }
        return sn;
    }
    /**
     * 得到短信发送的帐户的密码
     * @param prop
     */
    public static String getPassWord(Properties prop){
    	String pwd="B46HSF";
    	Iterator<String> it = prop.stringPropertyNames().iterator();
        while (it.hasNext()) {
        String key = it.next();
        //System.out.println(key + ":" + prop.getProperty(key));
        if("Pwd".equals(key)){
        	pwd=prop.getProperty(key);
        }
        }
        return pwd;
    }
    
    /**
     * 得到短信发送接口连接1
     * @param prop
     */
    public static String getSendNews1(Properties prop){
    	String sendnews="http://124.173.70.59:8081/SmsAndMms/mt";
    	Iterator<String> it = prop.stringPropertyNames().iterator();
        while (it.hasNext()) {
        String key = it.next();
        //System.out.println(key + ":" + prop.getProperty(key));
        if("SendNews1".equals(key)){
        	sendnews=prop.getProperty(key);
        }
        }
        return sendnews;
    }
    /**
     * 得到短信发送接口连接
     * @param prop
     */
    public static String getSendNews2(Properties prop){
    	String sendnews="http://114.215.202.188:8081/SmsAndMms/mt";
    	Iterator<String> it = prop.stringPropertyNames().iterator();
        while (it.hasNext()) {
        String key = it.next();
        //System.out.println(key + ":" + prop.getProperty(key));
        if("SendNews2".equals(key)){
        	sendnews=prop.getProperty(key);
        }
        }
        return sendnews;
    }
    /**
     * 得到短信发模板前面内容
     * @param prop
     */
    public static String getNewsContentPre(Properties prop){
    	String newsContent="";
    	Iterator<String> it = prop.stringPropertyNames().iterator();
        while (it.hasNext()) {
        String key = it.next();
        //System.out.println(key + ":" + prop.getProperty(key));
        if("NewsContentPre".equals(key)){
        	newsContent=prop.getProperty(key);
        }
        }
        return newsContent;
    }
    /**
     * 得到短信发模板后面内容
     * @param prop
     */
    public static String getNewsContentNext(Properties prop){
    	String newsContent="";
    	Iterator<String> it = prop.stringPropertyNames().iterator();
        while (it.hasNext()) {
        String key = it.next();
        //System.out.println(key + ":" + prop.getProperty(key));
        if("NewsContentNext".equals(key)){
        	newsContent=prop.getProperty(key);
        }
        }
        return newsContent;
    }

    /**
     *
     * @param lps
     * @return
     */
    public static String getLabelPhotos(List<LabelPhoto> lps){
    	String strs="";
    	for(LabelPhoto lp:lps){
    		strs=strs+lp.getHchhLabel().getTagName()+",";
    	}
    	return strs;
    }
	//测试用的主函数
	public static void main(String[] args) {
		Map<String, Integer> myMap = new LinkedHashMap();  
        myMap.put("1", 1);  
        myMap.put("2", 4);  
        myMap.put("3", 3);  
        myMap.put("4", 9);  
        myMap.put("5", 6);  
        myMap.put("6", 2);  
          
        printMap(myMap);  
          
        myMap = sortMap(myMap);  
          
        printMap(myMap); 
        
        
     // 读取属性文件a.properties
       /* InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream("/parameter.properties"));
			// /加载属性列表
	        Properties prop = new Properties();
	        prop.load(in);
	        Iterator<String> it = prop.stringPropertyNames().iterator();
	        while (it.hasNext()) {
	        String key = it.next();
	        System.out.println(key + ":" + prop.getProperty(key));
	        }
	        in.close();
		} catch (Exception e) {

			e.printStackTrace();
		}*/
        
		//HchhUtil hu=new HchhUtil();
		Properties prop1 =HchhUtil.loadProperty();
		Iterator<String> it = prop1.stringPropertyNames().iterator();
        while (it.hasNext()) {
        String key = it.next();
        System.out.println(key + ":" + prop1.getProperty(key));
        }
		
        
	}
}
