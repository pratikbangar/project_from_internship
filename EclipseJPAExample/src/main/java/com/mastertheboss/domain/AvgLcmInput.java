package com.mastertheboss.domain;

import javax.persistence.*;

@Entity
@Table(name = "AvgLcmInput")
public class AvgLcmInput {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "InputId")
	private int inputId;

	@Column(name = "Number")
	private int number;
	
	@Column(name = "Status")
	private String status;

	@OneToOne(mappedBy = "avgLcmInput")
	private AvgLcmResult avgLcmResult;

	public AvgLcmInput(AvgLcmInput another) {
		this.inputId = another.inputId;
		this.number = another.number;

	}

	public AvgLcmInput() {

	}

	public static void main(String[] args) {

	}

	public int getInputId() {
		return inputId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setInputId(int id) {
		this.inputId = id;
		
	}

}
