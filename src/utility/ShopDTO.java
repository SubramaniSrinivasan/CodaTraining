package utility;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "shop")
@Table(name = "shop")
public class ShopDTO {
	
	@Id()
	private String shopID;
	private String shopName;
	
	public String getShopID() {
		return shopID;
	}
	
	public void setShopID(String shopID) {
		this.shopID = shopID;
	}
	
	public String getShopName() {
		return shopName;
	}
	
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public ShopDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ShopDTO(String shopID, String shopName) {
		this.shopID = shopID;
		this.shopName = shopName;
	}

	@Override
	public String toString() {
		return "ShopDTO [shopID=" + shopID + ", shopName=" + shopName + "]";
	}
	
}