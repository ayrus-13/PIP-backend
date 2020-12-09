package capg.pms.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
* @author: SURYA
* description: Product Model
* created date: 04/11/2020
*/

@Entity
@Table(name="Product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
	@Id
	@Column(name="product_id")
	
	private String productId;

	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_desc")
	private String productDesc;

	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="ratings")
	private Integer ratings;
	
	@Column(name = "isActive")
	@Value("true")
	private Boolean isActive;
	
	

	public Boolean getIsActive() {
		return isActive;
	}

	public Product(String productId, String productName, String productDesc, Integer quantity, Integer price,
			Integer ratings, Boolean isActive) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.quantity = quantity;
		this.price = price;
		this.ratings = ratings;
		this.isActive = isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Product(String productId, String productName, String productDesc, Integer quantity, Integer price,
			Integer ratings) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.quantity = quantity;
		this.price = price;
		this.ratings = ratings;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getRatings() {
		return ratings;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", quantity=" + quantity + ", price=" + price + ", ratings=" + ratings + ", isActive=" + isActive
				+ "]";
	}


	
	
	

}
