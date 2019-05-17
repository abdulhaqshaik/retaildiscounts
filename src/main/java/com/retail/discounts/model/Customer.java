package com.retail.discounts.model;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6212513655766244534L;

	public Customer(Integer f_id, String f_name, Boolean f_isEmployee, Boolean f_isAffliate, String f_doj, Boolean f_is2yearsOld) {
		// 1,Abdul,1,1,01-01-2019
		this.id = f_id;
		this.name = f_name;
		this.doj = f_doj;
		this.isAffliate = f_isAffliate;
		this.isEmployee = f_isEmployee;
		this.is2yearsOld=f_is2yearsOld;
	}

	private Integer id;

	private String name;

	private String doj; // date of joining

	private Boolean isEmployee;

	private Boolean isAffliate;

	private Boolean is2yearsOld;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public Boolean getIsAffliate() {
		return isAffliate;
	}

	public void setIsAffliate(Boolean isAffliate) {
		this.isAffliate = isAffliate;
	}

	public Boolean getIs2yearsOld() {
		return is2yearsOld;
	}

	public void setIs2yearsOld(Boolean is2yearsOld) {
		this.is2yearsOld = is2yearsOld;
	}

	public Boolean getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(Boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

}
