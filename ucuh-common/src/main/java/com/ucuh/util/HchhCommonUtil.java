package com.ucuh.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.beans.PropertyDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;

import com.ucuh.entity.User;
import com.ucuh.model.UserDemo;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;



public class HchhCommonUtil {
	/**
	* 发送短信的方法 http://124.173.70.59:8081/SmsAndMms/mt?Sn=xxx&Pwd=xxx&mobile=13010203040&content=123
	*/
	public static String SendNews(String phone,String content,int status) {
	//String info = "";
	String result="302";
	try{
		//HchhUtil hu=new HchhUtil();
		Properties prop=HchhUtil.loadProperty();
		String userName=HchhUtil.getUserName(prop);
		String passWord=HchhUtil.getPassWord(prop);
		String sendNews1=HchhUtil.getSendNews1(prop);
		String sendNews2=HchhUtil.getSendNews2(prop);
		String newsContentPre=HchhUtil.getNewsContentPre(prop);
		String newsContentNext=HchhUtil.getNewsContentNext(prop);
	HttpClient httpclient = new HttpClient();//方法调用
	PostMethod post=null;//接口地址
	if(status==0){
		post = new PostMethod(sendNews1);
	}else{
		post = new PostMethod(sendNews2);
	}
	post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");//格式转换
	//post.addParameter("userid", "12");//企业ID
	post.addParameter("Sn", userName);//用户帐号，由系统管理员
	post.addParameter("Pwd", passWord);//用户账号对应的密码
	post.addParameter("mobile", phone);//发信发送的目的号码.多个号码之间用半角逗号隔开
	post.addParameter("content", newsContentPre+"："+content+","+newsContentNext);//短信的内容，内容需要UTF-8编码
	//post.addParameter("sendTime", "20110801142517000000");//为空表示立即发送，定时发送格式2010-10-24 09:08:10
	//post.addParameter("action", "send");//设置为固定的:send
	//extno
	//post.addParameter("extno", "1");//请先询问配置的通道是否支持扩展子号，如果不支持，请填空。子号只能为数字，且最多5位数。
	int hr = httpclient.executeMethod(post);
	//info = new String(post.getResponseBody(),"utf-8");
	//System.out.println(post.getResponseBody().toString());
	//System.out.println(hr);
	//最后得到结果后，是一个字符长串，截取有用的信息，可判断短信是否发送成功
	result=""+hr;
	}catch (Exception e) {
	e.printStackTrace();
	result="error";
	}
	return result;
	}
	
	/** 
	 * 改变图片的大小到宽为size，然后高随着宽等比例变化 
	 * @param is 上传的图片的输入流 
	 * @param os 改变了图片的大小后，把图片的流输出到目标OutputStream 
	 * @param size 新图片的宽 
	 * @param format 新图片的格式 
	 * @throws IOException 
	 */  
	public static void resizeImage(InputStream is, OutputStream os, int size, String format) throws IOException {  
	    BufferedImage prevImage = ImageIO.read(is);  
	    double width = prevImage.getWidth();  
	    double height = prevImage.getHeight();  
	    double percent = size/width;  
	    int newWidth = (int)(width * percent);  
	    int newHeight = (int)(height * percent);  
	    BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);  
	    Graphics graphics = image.createGraphics();  
	    graphics.drawImage(prevImage, 0, 0, newWidth, newHeight, null);  
	    ImageIO.write(image, format, os);  
	    os.flush();  
	    is.close();  
	    os.close();  
	}
	/**
	 * 随机生成一个六位数字的字符串 
	 * @type 0:数字；1：小写字母；2：大写字母；3，4，5：数字加字母（大小写）
	 * @return
	 */
	public static String VerificationCode(int passLength, int type){
		StringBuffer buffer = null;  
        StringBuffer sb = new StringBuffer();  
        Random r = new Random();  
        r.setSeed(new Date().getTime());  
        switch (type)  
        {  
        case 0:  
            buffer = new StringBuffer("0123456789");  
            break;  
        case 1:  
            buffer = new StringBuffer("abcdefghijklmnopqrstuvwxyz");  
            break;  
        case 2:  
            buffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");  
            break;  
        case 3:  
            buffer = new StringBuffer(  
                    "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");  
            break;  
        case 4:  
            buffer = new StringBuffer(  
                    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");  
            sb.append(buffer.charAt(r.nextInt(buffer.length() - 10)));  
            passLength -= 1;  
            break;  
        case 5:  
            String s = UUID.randomUUID().toString();  
            sb.append(s.substring(0, 8) + s.substring(9, 13)  
                    + s.substring(14, 18) + s.substring(19, 23)  
                    + s.substring(24));  
        }  
  
        if (type != 5)  
        {  
            int range = buffer.length();  
            for (int i = 0; i < passLength; ++i)  
            {  
                sb.append(buffer.charAt(r.nextInt(range)));  
            }  
        }  
        return sb.toString();  
	}
	/**
	 * 图片转换成base64编码
	 * 
	 */
	// 图片转化成base64字符串
	public static String GetImageStr(String filePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	String imgFile = filePath;// 待处理的图片
	InputStream in = null;
	byte[] data = null;
	// 读取图片字节数组
	try {
	in = new FileInputStream(imgFile);
	data = new byte[in.available()];
	in.read(data);
	in.close();
	} catch (IOException e) {
	e.printStackTrace();
	}
	// 对字节数组Base64编码
	BASE64Encoder encoder = new BASE64Encoder();
	return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}
	
	/**
	 * 将base64编码转变成图片
	 * @param imgStr
	 * @param path
	 * @return
	 */
	public static boolean GenerateImage(String imgStr,String path) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
		return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
		// Base64解码
		byte[] b = decoder.decodeBuffer(imgStr);
		for (int i = 0; i < b.length; ++i) {
		if (b[i] < 0) {// 调整异常数据
		b[i] += 256;
		}
		}
		// 生成jpeg图片
		String imgFilePath =path;// 新生成的图片
		OutputStream out = new FileOutputStream(imgFilePath);
		out.write(b);
		out.flush();
		out.close();
		return true;
		} catch (Exception e) {
		return false;
		}
		}
	
	//将User实体类转为map类型，然后返回一个map类型的值
    public static Map<String, Object> UserToMap(UserDemo user) {
            Map<String, Object> params = new HashMap<String, Object>(0); 
            try { 
                PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
                PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(user); 
                for (int i = 0; i < descriptors.length; i++) { 
                    String name = descriptors[i].getName(); 
                    //System.out.println(name);
                    if (!"class".equals(name)) {
                    	//System.out.println(propertyUtilsBean.getNestedProperty(user, name).getClass().getName());
                    	if(propertyUtilsBean.getNestedProperty(user, name)!=null&&("java.sql.Timestamp".equals(propertyUtilsBean.getNestedProperty(user, name).getClass().getName())||"java.util.Date".equals(propertyUtilsBean.getNestedProperty(user, name).getClass().getName()))){
                    		params.put(name, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(propertyUtilsBean.getNestedProperty(user, name)));
                    	}else{
                    		params.put(name, propertyUtilsBean.getNestedProperty(user, name)); 
                    	}
                    } 
                } 
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
            return params; 
    }
    /**
     * 通过http路径得到文件的绝对路径
     */
    public static String Path(String httpPath,String path1){
    	//HchhUtil hu=new HchhUtil();
        Properties prop=HchhUtil.loadProperty();
        //String urlHead=hu.getUrlHead(prop);
        String projectName=HchhUtil.getProjectName(prop);
        
        String cpath=path1.replace("\\", "/");
        String[] cpaths=cpath.split("/"+projectName);
        String[] strs=httpPath.split("/"+projectName);
        String path=cpaths[0]+"/"+projectName+strs[1];
    	return path;
    }
    
    
    /**
     * maxPage 最大页数
     * pageCount 显示的个数
     * nowPage  当前页数
     * 分页显示的若干页码
     */
    public static String[] pageShow(int maxPage,int pageCount,int nowPage){
    	String[] pages = new String[6];
    	if(maxPage<=pageCount){
			pages=new String[maxPage];
			for(int i=0;i<maxPage;i++){
				int idx=i+1;
				pages[i]=idx+"";
			}
		}else{
			 int  p=maxPage-nowPage;
			 if(p>pageCount-1){
			 pages=new String[pageCount+1];
			 for(int i=0;i<pageCount;i++){
				int idx=i+nowPage;
				pages[i]=idx+"";
			 }
			 pages[pageCount]="...";
			 }else{
				 pages=new String[maxPage-nowPage+1];
				 for(int i=0;i<maxPage-nowPage+1;i++){
					int idx=i+nowPage;
					pages[i]=idx+"";
				 }
				 //pages[maxPage-nowPage]="..."; 
			 }
		}
    	return pages;
    }
	public static void main(String[] args) {
		//String result=SendNews("18358460590", "787788",0);
		//System.out.println(result);
		//String code=VerificationCode(6, 0);
		//System.out.println(code);
		//String imgPath=GetImageStr("F:/110483.jpg");
		//System.out.println(imgPath);
		//boolean ok=GenerateImage(imgPath, "F:/123456.jpg");
		//System.out.println(ok);
		/*List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> s1 = new HashMap<String, Object>();
        s1.put("name", "jim");
        s1.put("age", "15");
        s1.put("time", new Date());
        list.add(s1);
        Map<String, Object> s2 = new HashMap<String, Object>();
        s2.put("name", "lucy");
        s2.put("age", "12");
        s2.put("time", new Date());
        list.add(s2);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
        JSONArray jo = JSONArray.fromObject(list, jsonConfig);
        System.out.println("json:" + jo.toString());
        System.out.println(new Date().getClass().getName());*/
		//System.out.println(Path("http://localhost:8080/hchh/upload/1446003310291/full6.jpg","D:\\tomcat7.0\\webapps\\hchh\\upload"));
		//String hh="";
		//System.out.println(hh.getClass().getName());
		String[]pages=pageShow(10, 8, 1);
		for(String s:pages){
		System.out.println(s);
		}
		
	}

}
