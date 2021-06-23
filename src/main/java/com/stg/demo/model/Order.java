package com.stg.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "orders")
public class Order {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private Date created = new Date((new java.util.Date()).getTime());
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "id"))
	Customer customer;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItems> order_items;

	@NotNull
	@NotBlank(message = "Địa chỉ nhận hàng không được để trống!")
	private String address;

	@NotNull
	@NotBlank(message = "Số điện thoại không được để trống")
	@Size(max = 10, message = "Số điện thoại không được quá 10 ký tự!")
	private String phoneNumber;

	@NotBlank(message = "Tên khách hàng không được để trống!")
	@Size(max = 50, message = "Tên khách hàng không được nhiều hơn 50 ký tự!")
	private String name;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, @NotNull Date created, Customer customer, List<OrderItems> order_items) {
		super();
		this.id = id;
		this.created = created;
		this.customer = customer;
		this.order_items = order_items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OrderItems> getOrder_items() {
		return order_items;
	}

	public void setOrder_items(List<OrderItems> order_items) {
		this.order_items = order_items;
	}

}
