package com.ucuh.entity;

import java.util.Date;


/**
 * FenLei entity. @author MyEclipse Persistence Tools
 */

public class FenLei  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String des;
     private String photoPath;
     private Date time;


    // Constructors

    /** default constructor */
    public FenLei() {
    }

    
    /** full constructor */
    public FenLei(String name, String des, String photoPath, Date time) {
        this.name = name;
        this.des = des;
        this.photoPath = photoPath;
        this.time = time;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return this.des;
    }
    
    public void setDes(String des) {
        this.des = des;
    }

    public String getPhotoPath() {
        return this.photoPath;
    }
    
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }

   
   








}