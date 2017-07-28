package ecom.onlineshop_back.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	private String brand;
	private String description;
	@Column(name=" UNIT_PRICE")
	private double unitPrice;
	
	@Column(name=" IS_ACTIVE")
	private boolean isActive;
	
	@Column(name=" CATEGORY_ID")
	private int categoryId;
	
	@Column(name="SUPPLIER_ID")
	private int supplierId;
	private int purchases;
	
	@Column(name="PRO_VIEW")
	private int proView;
	
	
	
	
	
	
	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getCode() {
		return code;
	}





	public void setCode(String code) {
		this.code = code;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getBrand() {
		return brand;
	}





	public void setBrand(String brand) {
		this.brand = brand;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public double getUnitPrice() {
		return unitPrice;
	}





	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}





	public boolean isActive() {
		return isActive;
	}





	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}





	public int getCategoryId() {
		return categoryId;
	}





	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}





	public int getSupplierId() {
		return supplierId;
	}





	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}





	public int getPurchases() {
		return purchases;
	}





	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}





	public int getProView() {
		return proView;
	}





	public void setProView(int proView) {
		this.proView = proView;
	}




	//DEFAULT CONSTRUCTOR

	public Product()
	{
		this.code="PRD"+ UUID.randomUUID().toString().substring(26).toUpperCase();
	}

}







