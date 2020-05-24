package com.mono40.types;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class ProductoPlanes {
	@JsonProperty("ProductoPlanes")
	private List<ProductoPlan> productoPlan;
	private String outdescresultadoOutField;
	private String outcodresultadoOutField;


	public List<ProductoPlan> getProductoPlan() {
		return productoPlan;
	}

	public void setProductoPlan(List<ProductoPlan> productoPlan) {
		this.productoPlan = productoPlan;
	}

	public String getOutdescresultadoOutField() {
		return outdescresultadoOutField;
	}

	public void setOutdescresultadoOutField(String outdescresultadoOutField) {
		this.outdescresultadoOutField = outdescresultadoOutField;
	}

	public String getOutcodresultadoOutField() {
		return outcodresultadoOutField;
	}

	public void setOutcodresultadoOutField(String outcodresultadoOutField) {
		this.outcodresultadoOutField = outcodresultadoOutField;
	}
}
