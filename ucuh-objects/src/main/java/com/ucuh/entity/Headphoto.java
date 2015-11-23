package com.ucuh.entity;

import java.util.Date;



/**
 * 头像上传审核表
 */

public class Headphoto  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String headPhotoPath;
     private Integer headPhotoState;
     private Integer userId;
     private Date time;
     
     //2015-11-19  cck
     private String remark1;
     private String remark2;


    // Constructors

    /** default constructor */
    public Headphoto() {
    }

    
    /** full constructor */
    public Headphoto(String headPhotoPath, Integer headPhotoState,Integer userId,Date time,String remark1,String remark2) {
        this.headPhotoPath = headPhotoPath;
        this.headPhotoState = headPhotoState;
        this.userId=userId;
        this.time=time;
        this.remark1=remark1;
        this.remark2=remark2;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadPhotoPath() {
        return this.headPhotoPath;
    }
    
    public void setHeadPhotoPath(String headPhotoPath) {
        this.headPhotoPath = headPhotoPath;
    }

    public Integer getHeadPhotoState() {
        return this.headPhotoState;
    }
    
    public void setHeadPhotoState(Integer headPhotoState) {
        this.headPhotoState = headPhotoState;
    }


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public String getRemark1() {
		return remark1;
	}


	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}


	public String getRemark2() {
		return remark2;
	}


	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	
}