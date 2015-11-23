package com.ucuh.entity;

import java.util.List;

public class PhotoAllLabel {
	private Photo photo;
	private List<LabelPhoto> lpsPutong;
    private List<LabelPhoto> lpsDidian;
    private List<LabelPhoto> lpsEwai;
    private List<LabelPhoto> lpsKegou;
    
    public PhotoAllLabel() {
	}
	public PhotoAllLabel(Photo photo, List<LabelPhoto> lpsPutong,
			List<LabelPhoto> lpsDidian, List<LabelPhoto> lpsEwai,
			List<LabelPhoto> lpsKegou) {
		super();
		this.photo = photo;
		this.lpsPutong = lpsPutong;
		this.lpsDidian = lpsDidian;
		this.lpsEwai = lpsEwai;
		this.lpsKegou = lpsKegou;
	}
	
	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public List<LabelPhoto> getLpsPutong() {
		return lpsPutong;
	}
	public void setLpsPutong(List<LabelPhoto> lpsPutong) {
		this.lpsPutong = lpsPutong;
	}
	public List<LabelPhoto> getLpsDidian() {
		return lpsDidian;
	}
	public void setLpsDidian(List<LabelPhoto> lpsDidian) {
		this.lpsDidian = lpsDidian;
	}
	public List<LabelPhoto> getLpsEwai() {
		return lpsEwai;
	}
	public void setLpsEwai(List<LabelPhoto> lpsEwai) {
		this.lpsEwai = lpsEwai;
	}
	public List<LabelPhoto> getLpsKegou() {
		return lpsKegou;
	}
	public void setLpsKegou(List<LabelPhoto> lpsKegou) {
		this.lpsKegou = lpsKegou;
	}
    
    

}
