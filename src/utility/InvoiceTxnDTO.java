package utility;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoicetransaction")
public class InvoiceTxnDTO implements Serializable {
	
	@Id()
	private Integer billno;
	@Id()
	private String ItemID;
	
	public InvoiceTxnDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public InvoiceTxnDTO(Integer billno, String ItemID) {
		this.billno = billno;
		this.ItemID = ItemID;
	}
	
	public Integer getBillno() {
		return billno;
	}
	
	public void setBillno(Integer billno) {
		this.billno = billno;
	}
	
	public String getItemID() {
		return ItemID;
	}
	
	public void setItemID(String itemID) {
		ItemID = itemID;
	}

	@Override
	public String toString() {
		return "InvoiceTxnDTO [billno=" + billno + ", ItemID=" + ItemID + "]";
	}

}
