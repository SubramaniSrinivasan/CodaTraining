package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import utility.InvoiceDAOImpl;
import utility.BillDTO;
import utility.InvoiceTxnDAOImpl;
import utility.InvoiceTxnDTO;
import utility.ItemDTO;
import utility.ShopDAOImpl;
import utility.UserDAOImpl;
import utility.UserDTO;

public class PaymentAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("uname");
		
		UserDAOImpl userDAO = new UserDAOImpl();
		ShopDAOImpl shopDAO = new ShopDAOImpl();
		UserDTO userDTO = userDAO.findByUname(username);
		ArrayList<ItemDTO> items = new ArrayList<>();
		
		Enumeration<String> en = session.getAttributeNames();
		while(en.hasMoreElements()){
			String name = en.nextElement();
			if(!name.equals("formid") && !name.equals("shopid") && !name.equals("uname") && !name.equals("billno")){
				ItemDTO itemDTO = shopDAO.getItemByID(name);
				items.add(itemDTO);
			}
		}
		
		InvoiceTxnDAOImpl inTxnDAO = new InvoiceTxnDAOImpl();
		Integer billNo = inTxnDAO.getNextBillNo();
		
		for(ItemDTO i : items) {
			InvoiceTxnDTO inTxnDTO = new InvoiceTxnDTO(billNo, i.getItemID());
			inTxnDAO.InsertBill(inTxnDTO);
		}
		
		BillDTO invoiceDTO = new BillDTO(billNo, userDTO.getUid(), new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		InvoiceDAOImpl invoiceDAO = new InvoiceDAOImpl();
		
		invoiceDAO.InsertBill(invoiceDTO); 
		
		session.setAttribute("billno", billNo);
		
		return "payment.success";
	}
	
}
