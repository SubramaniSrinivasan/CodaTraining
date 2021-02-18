package utility;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Property;

abstract class ShopDAO {
	
	public abstract ShopDTO getShopByShopID(String shopID);
	public abstract List<ItemDTO> getItemsByShopID(String shopID);
	public abstract ItemDTO getItemByID(String itemID);
	
}

public class ShopDAOImpl extends ShopDAO {
	
	private Connection con;
	
	@Override
	public ShopDTO getShopByShopID(String shopID) {
//		try {
//			this.con = ConnectionUtility.createConnection();
//			PreparedStatement findByPrimaryKey = this.con.prepareStatement("SELECT * FROM shop WHERE shopID = ?");
//			findByPrimaryKey.setString(1, shopID);
//			ResultSet r = findByPrimaryKey.executeQuery();
//			ShopDTO result = setUpDTO(r);
//			ConnectionUtility.closeConnection(null);
//			return result;
//		}
//		catch(Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return null;
		
		Session session = HibernateUtility.getSession();
		
		Criteria criteria = session.createCriteria(ShopDTO.class);
		criteria.add(Property.forName("shopID").eq(shopID));
		ShopDTO shopDTO = (ShopDTO)criteria.uniqueResult();
		HibernateUtility.closeSession(null);
		return shopDTO;
		
	}
	
	@Override
	public List<ItemDTO> getItemsByShopID(String shopID) {
//		try {
//			this.con = ConnectionUtility.createConnection();
//			PreparedStatement findByPrimaryKey = this.con.prepareStatement("SELECT * FROM item WHERE shopID = ?");
//			findByPrimaryKey.setString(1, shopID);
//			ResultSet r = findByPrimaryKey.executeQuery();
//			ArrayList<ItemDTO> result = setUpItemsDTO(r);
//			ConnectionUtility.closeConnection(null);
//			return result;
//		}
//		catch(Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return null;
		
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(ItemDTO.class);
		criteria.add(Property.forName("shopID").eq(shopID));
		List<ItemDTO> items = criteria.list();
		return items;
		
	}
	
//	public List<ItemDTO> setUpItemsDTO(ResultSet r) throws Exception {
//		List<ItemDTO> listDTO = new ArrayList<>();
//		while(r.next()) {
//			ItemDTO itemDTO = new ItemDTO();
//			itemDTO.setItemID(r.getString("itemid"));
//			itemDTO.setShopID(r.getString("shopid"));
//			itemDTO.setItemDescription(r.getString("itemdescription"));
//			itemDTO.setUnit(r.getString("unit"));
//			itemDTO.setPrice(r.getInt("price"));
//			itemDTO.setImageURL(r.getString("imageurl"));
//			listDTO.add(itemDTO);
//		}
//		return listDTO;
//	}
	
//	public ShopDTO setUpDTO(ResultSet r) {
//		
//		ShopDTO shopDTO = new ShopDTO();
//		
//		try {
//			if(r.next()) {     
//				shopDTO.setShopID(r.getString("shopid"));
//				shopDTO.setShopName(r.getString("shopname"));
//			}
//			else {
//				return null;
//			}
//			return shopDTO;
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
//	public ItemDTO setUpItemDTO(ResultSet r) {
//		
//		ItemDTO itemDTO = new ItemDTO();
//		
//		try {
//			if(r.next()) {     
//				itemDTO.setItemID(r.getString("itemID"));
//				itemDTO.setItemDescription(r.getString("itemDescription"));
//				itemDTO.setUnit(r.getString("unit"));
//				itemDTO.setPrice(r.getInt("price"));
//				itemDTO.setImageURL(r.getString("imageURL"));
//				itemDTO.setShopID(r.getString("shopID"));
//			}
//			else {
//				return null;
//			}
//			return itemDTO;
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@Override
	public ItemDTO getItemByID(String itemID) {
//		try {
//			this.con = ConnectionUtility.createConnection();
//			PreparedStatement findByPrimaryKey = this.con.prepareStatement("SELECT * FROM item WHERE itemID = ?");
//			findByPrimaryKey.setString(1, itemID);
//			ResultSet r = findByPrimaryKey.executeQuery();
//			ItemDTO result = setUpItemDTO(r);
//			ConnectionUtility.closeConnection(null);
//			return result;
//		}
//		catch(Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return null;
		
		Session session = HibernateUtility.getSession();
		
		Criteria criteria = session.createCriteria(ItemDTO.class);
		criteria.add(Property.forName("itemID").eq(itemID));
		ItemDTO item = (ItemDTO)criteria.uniqueResult();
		HibernateUtility.closeSession(null);
		return item;
		
	}
	
}

