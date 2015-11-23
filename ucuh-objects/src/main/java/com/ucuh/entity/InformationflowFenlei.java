package com.ucuh.entity;

/**
 * InformationflowFenlei entity. @author MyEclipse Persistence Tools
 */

public class InformationflowFenlei implements java.io.Serializable {

	// Fields

	private Integer id;
	private Informationflow informationflow;
	private FenLei fenLei;

	// Constructors

	/** default constructor */
	public InformationflowFenlei() {
	}

	/** full constructor */
	public InformationflowFenlei(Informationflow informationflow, FenLei fenLei) {
		this.informationflow = informationflow;
		this.fenLei = fenLei;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Informationflow getInformationflow() {
		return this.informationflow;
	}

	public void setInformationflow(Informationflow informationflow) {
		this.informationflow = informationflow;
	}

	public FenLei getFenLei() {
		return this.fenLei;
	}

	public void setFenLei(FenLei fenLei) {
		this.fenLei = fenLei;
	}

}