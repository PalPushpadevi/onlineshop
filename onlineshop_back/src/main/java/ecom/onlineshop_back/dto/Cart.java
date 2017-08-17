package ecom.onlineshop_back.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Cart 
{

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getCartLine() {
		return cartLine;
	}
	public void setCartLine(int cartLine) {
		this.cartLine = cartLine;
	}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)

private int Id;
@Column(name="grand_total")
private double grandTotal;
@Column(name="cart_line")
private int cartLine;

//===============
@OneToOne
private User user;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}


//=============

@Override
public String toString() {
	return "Cart [Id=" + Id + ", grandTotal=" + grandTotal + ", cartLine="
			+ cartLine + ", user=" + user + "]";
}



}
