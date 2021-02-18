package model;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.ItemDTO;
import utility.ShopDAOImpl;
import utility.ShopDTO;

public class ShopAction extends Action {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String shopID = request.getParameter("shopid");

		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements()) {
			String name = en.nextElement();
			String value = request.getParameter(name);
			session.setAttribute(name, value);
		}
		
		if(!shopID.equals("invoice")) {
			ShopDAOImpl shopDAO = new ShopDAOImpl();
			ShopDTO shopDTO = shopDAO.getShopByShopID(shopID);
			List<ItemDTO> ItemDTOList = shopDAO.getItemsByShopID(shopID);
			request.setAttribute("shopDTO", shopDTO);
			request.setAttribute("ItemDTO", ItemDTOList);
		}
		
		return shopID;
	}
	
}
