package com.mastertheboss.domain;

import javax.persistence.*;

@Entity
@Table(name = "AvgLcmResult")
public class AvgLcmResult {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ResultId")
	private int resultId;

	@Column(name = "Result")
	private long result;
	
	@OneToOne
	@JoinColumn(name = "InputId")
	private AvgLcmInput avgLcmInput;

	public static void main(String[] args) {
	}

	public long getResult() {
		return result;
	}

	public void setResult(long result) {
		this.result = result;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public AvgLcmInput getAvgLcmInput() {
		return avgLcmInput;
	}

	public void setAvgLcmInput(AvgLcmInput avgLcmInput) {
		this.avgLcmInput = avgLcmInput;
	}

}
