package com.niit.model;

import javax.persistence.*;

@Entity
@Table
public class Supplier 
{
	@Id
	int supplierId;
	
	String supplierName,supplierMailId;

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierMailId() {
		return supplierMailId;
	}

	public void setSupplierMailId(String supplierMailId) {
		this.supplierMailId = supplierMailId;
	}
	
}
