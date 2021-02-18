package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Property;

abstract class InvoiceTxnDAO {
	
	public abstract Integer getNextBillNo();
	public abstract int InsertBill(InvoiceTxnDTO inTxnDTO); 
	public abstract List<String> getAllItems(Integer billNo);
	
}

public class InvoiceTxnDAOImpl extends InvoiceTxnDAO {
	
	private Connection con;

	@Override
	public Integer getNextBillNo() {
		try {
			this.con = ConnectionUtility.createConnection();
			Statement st = this.con.createStatement();
			ResultSet rs = st.executeQuery("SELECT billno FROM invoicetransaction ORDER BY billno DESC LIMIT 1");
			int result = 1;
			if(rs.next()) {
				result = rs.getInt("billno") + 1;
			}
			ConnectionUtility.closeConnection(null);
			return result;
		}
		catch(Exception e) {
			ConnectionUtility.closeConnection(e);
		}
		return -1;
	}
	
	@Override
	public int InsertBill(InvoiceTxnDTO inTxnDTO) {
//		try {
//			this.con = ConnectionUtility.createConnection();
//			PreparedStatement insertQuery = this.con.prepareStatement("INSERT INTO invoicetransaction(billno, itemid) VALUES (?, ?)");
//			insertQuery.setInt(1, inTxnDTO.getBillno());
//			insertQuery.setString(2, inTxnDTO.getItemID());
//			int result = insertQuery.executeUpdate();
//			ConnectionUtility.closeConnection(null);
//			return result;
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
		
		Session session = HibernateUtility.getSession();
		try{
			session.save(inTxnDTO);
			HibernateUtility.closeSession(null);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			HibernateUtility.closeSession(e);
			return 0;
		}
		
	}
	
	@Override
	public List<String> getAllItems(Integer billNo) {
//		try {
//			this.con = ConnectionUtility.createConnection();
//			PreparedStatement selectQuery = this.con.prepareStatement("SELECT itemid FROM invoicetransaction WHERE billno = ?");
//			selectQuery.setInt(1, billNo);
//			ResultSet rs = selectQuery.executeQuery();
//			while(rs.next()) {
//				itemList.add(rs.getString("itemid"));
//			}
//			ConnectionUtility.closeConnection(null);
//			return itemList;
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
		
		Session session = HibernateUtility.getSession();
		String hql = "SELECT i.ItemID FROM InvoiceTxnDTO i";
		Query query = session.createQuery(hql);
		List<String> i = query.list();
//		
//		for(BillDTO invoice : invoiceList) {
//			System.out.println("Inside ==> " + invoice);
//			itemList.add(invoice.getItemID());
//			
//		}
		
		for(String x : i) {
			 System.out.println(x);
		}
		return i;
		
	}
	
}
