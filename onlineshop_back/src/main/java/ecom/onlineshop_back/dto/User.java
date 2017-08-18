package ecom.onlineshop_back.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="user_detail")
public class User
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String role="user";
	private String contact;
	private String address;
	private boolean enabled=true;
	@OneToOne(mappedBy="user" ,cascade=CascadeType.ALL)
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", fname=" + fname + ", lname=" + lname
				+ ", email=" + email + ", password=" + password + ", role="
				+ role + ", contact=" + contact + ", enabled=" + enabled + "]";
	}

}
