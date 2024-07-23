package model;

import java.time.LocalDateTime;

public class Order {
	private int id;
	private String customerName;
	private String productName;
	private LocalDateTime orderedon;
	private int quantity;
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public LocalDateTime getOrderedon() {
		return orderedon;
	}

	public void setOrderedon(LocalDateTime orderedon) {
		this.orderedon = orderedon;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}