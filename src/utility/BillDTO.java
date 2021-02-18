package utility;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "invoice")
@Table(name = "invoice")
public class BillDTO {

	@Id()
	private Integer billNo;
	private Integer uid;
	private Date billdate;
	
	public BillDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public BillDTO(Integer billNo, Integer uid, Date date) {
		this.billNo = billNo;
		this.billdate = date;
		this.uid = uid;
	}
	
	public Integer getBillNo() {
		return billNo;
	}
	
	public void setBillNo(Integer billNo) {
		this.billNo = billNo;
	}
	
	public Integer getUid() {
		return uid;
	}
	
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
	public Date getDate() {
		return billdate;
	}
	
	public void setDate(Date date) {
		this.billdate = date;
	}

	@Override
	public String toString() {
		return "InvoiceDTO [billNo=" + billNo + ", uid=" + uid + ", date=" + billdate + "]";
	}
	
}
