package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Property;

interface InvoiceDAO {
	
	public int InsertBill(BillDTO invoiceDTO);
	public BillDTO getBillByBillNo(Integer billNo);
	
}

public class InvoiceDAOImpl implements InvoiceDAO {
	
	private Connection con;

	@Override
	public int InsertBill(BillDTO billDTO) {
//		try {
//			this.con = ConnectionUtility.createConnection();
//			PreparedStatement InsertData = this.con.prepareStatement("INSERT INTO invoice(billno, uid, billdate) VALUES (?, ?, ?)");
//			InsertData.setInt(1, invoiceDTO.getBillNo());
//			InsertData.setInt(2, invoiceDTO.getUid());
//			InsertData.setDate(3, invoiceDTO.getDate());
//			int result = InsertData.executeUpdate();
//			ConnectionUtility.closeConnection(null);
//			return result;
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
		
		Session session = HibernateUtility.getSession();
		try{
			session.save(billDTO);
			HibernateUtility.closeSession(null);
			return 1;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			return 0;
		}
		
	}
	
	@Override
	public BillDTO getBillByBillNo(Integer billNo) {
//		try {
//			this.con = ConnectionUtility.createConnection();
//			PreparedStatement findByUname = this.con.prepareStatement("SELECT * FROM invoice WHERE billno = ?");
//			findByUname.setInt(1, billNo);
//			ResultSet r = findByUname.executeQuery();
//			BillDTO result = setUpBillDTO(r);
//			ConnectionUtility.closeConnection(null);
//			return result;
//		}
//		catch(Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return null;
		
		Session session = HibernateUtility.getSession();
		
		Criteria criteria = session.createCriteria(BillDTO.class);
		criteria.add(Property.forName("billNo").eq(billNo));
		BillDTO bill = (BillDTO)criteria.uniqueResult();
		HibernateUtility.closeSession(null);
		return bill;
		
	}
	
//	private BillDTO setUpBillDTO(ResultSet rs) {
//		BillDTO billDTO = new BillDTO();
//		try {
//			if(rs.next()) {     
//				billDTO.setBillNo(rs.getInt("billno"));
//				billDTO.setDate(rs.getDate("billdate"));
//				billDTO.setUid(rs.getInt("uid"));
//			}
//			else {
//				return null;
//			}
//			return billDTO;
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
}
