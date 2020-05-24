package com.mono40.types;

import java.util.List;

public class ProductoPlan {

	int idProducto;
	String descplan;
	int idPlan;
	String stsPlan;
	String codmoneda;
	List <FormaPagos>  formaPago;

	public ProductoPlan() {

	}

	/**
	 * @author Birendra Kumar
	 * @param idProducto
	 * @param descplan
	 * @param idPlan
	 * @param stsPlan
	 * @param codmoneda
	 * @param formaPago
	 *
	 */
	public ProductoPlan(int idProducto, String descplan, int idPlan,
                        String stsPlan, String codmoneda, List<FormaPagos> formaPago) {
		super();
		this.idProducto = idProducto;
		this.descplan = descplan;
		this.idPlan = idPlan;
		this.stsPlan = stsPlan;
		this.codmoneda = codmoneda;
		this.formaPago = formaPago;
	}

	/**
	 *
	 * @return  integer value
	 */
	public int getIdProducto() {
		return idProducto;
	}

	/**
	 *
	 * @param idProducto
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 *
	 * @return String value
	 */
	public String getDescplan() {
		return descplan;
	}

	/**
	 *
	 * @param descplan
	 */
	public void setDescplan(String descplan) {
		this.descplan = descplan;
	}

	/**
	 *
	 * @return  int value
	 */
	public int getIdPlan() {
		return idPlan;
	}

	/**
	 *
	 * @param idPlan
	 */
	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	/**
	 *
	 * @return
	 */
	public String getStsPlan() {
		return stsPlan;
	}

	/**
	 *
	 * @param stsPlan
	 */
	public void setStsPlan(String stsPlan) {
		this.stsPlan = stsPlan;
	}

	/**
	 *
	 * @return
	 */
	public String getCodmoneda() {
		return codmoneda;
	}

	/**
	 *
	 * @param codmoneda
	 */
	public void setCodmoneda(String codmoneda) {
		this.codmoneda = codmoneda;
	}

	/**
	 *
	 * @return
	 */
	public List<FormaPagos> getFormaPago() {
		return formaPago;
	}

	/**
	 *
	 * @param formaPago
	 */
	public void setFormaPago(List<FormaPagos> formaPago) {
		this.formaPago = formaPago;
	}


}
