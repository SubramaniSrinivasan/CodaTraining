package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Property;

interface UserDAO {
	public UserDTO findByPrimaryKey(Integer uid);
	public UserDTO findByUname(String uname);
	public int insertUser(UserDTO userDto);
	public int updateUser(UserDTO userDto);
//	public boolean deleteUser(Integer uid);
	public int generatePrimaryKey();
}

public class UserDAOImpl implements UserDAO {
	
	private Connection con;
	
	@Override
	public UserDTO findByPrimaryKey(Integer uid) {
//		try {
//			this.con = ConnectionUtility.createConnection();
//			PreparedStatement findByPrimaryKey = this.con.prepareStatement("SELECT * FROM users WHERE uid = ?");
//			findByPrimaryKey.setInt(1, uid);
//			ResultSet r = findByPrimaryKey.executeQuery();
//			ConnectionUtility.closeConnection(null);
//			return setUpDTO(r);
//		}
//		catch(Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return null;
		
		Session session = HibernateUtility.getSession();
		
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Property.forName("uid").eq(uid));
		UserDTO user = (UserDTO)criteria.uniqueResult();
		HibernateUtility.closeSession(null);
		return user;
		
	}
	
	@Override
	public UserDTO findByUname(String uname) {
//		try {
//			this.con = ConnectionUtility.createConnection();
//			PreparedStatement findByUname = this.con.prepareStatement("SELECT * FROM users WHERE uname = ?");
//			findByUname.setString(1, uname);
//			ResultSet r = findByUname.executeQuery();
//			UserDTO result = setUpDTO(r);
//			ConnectionUtility.closeConnection(null);
//			return result;
//		}
//		catch(Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return null;
		
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Property.forName("uname").eq(uname));
		UserDTO user = (UserDTO)criteria.uniqueResult();
		HibernateUtility.closeSession(null);
		return user;
		
	}

	@Override
	public int insertUser(UserDTO userDTO) {
//		try {
//			this.con = ConnectionUtility.createConnection();
//			PreparedStatement InsertUser = this.con.prepareStatement("INSERT INTO users(uid, uname, upass, flag) VALUES (?, ?, ?, ?)");
//			InsertUser.setInt(1, userDTO.getUid());
//			InsertUser.setString(2, userDTO.getUname());
//			InsertUser.setString(3, userDTO.getUpass());
//			InsertUser.setInt(4, userDTO.getFlag());
//			int result = InsertUser.executeUpdate();
//			ConnectionUtility.closeConnection(null);
//			return result;
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
		
		Session session = HibernateUtility.getSession();
		try{
			session.save(userDTO);
			HibernateUtility.closeSession(null);
			return 1;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			return 0;
		}
		
	}
	@Override
	public int updateUser(UserDTO newUserDTO) {
//		try {
//			this.con = ConnectionUtility.createConnection();
//			PreparedStatement UpdateUser = this.con.prepareStatement("UPDATE users SET uname = ?, upass = ?, flag = ? WHERE uid = ?");
//			UpdateUser.setString(1, userDTO.getUname());
//			UpdateUser.setString(2, userDTO.getUpass());
//			UpdateUser.setInt(3, userDTO.getFlag());
//			UpdateUser.setInt(4, userDTO.getUid());
//			int result = UpdateUser.executeUpdate();
//			ConnectionUtility.closeConnection(null);
//			return result;
//		}
//		catch(Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return 0;
		
		Session session = HibernateUtility.getSession();
		
		UserDTO oldUserDTO = findByPrimaryKey(newUserDTO.getUid());
		oldUserDTO.setUname(newUserDTO.getUname());
		oldUserDTO.setUpass(newUserDTO.getUpass());
		oldUserDTO.setFlag(newUserDTO.getFlag());
		try{
			session.save(oldUserDTO);
			HibernateUtility.closeSession(null);
			return 1;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			return 0;
		}
	}
	
//	@Override
//	public boolean deleteUser(Integer uid) {
//		try {
//			this.con = ConnectionUtility.createConnection();
//			PreparedStatement DeleteUser = this.con.prepareStatement("DELETE users WHERE uid = ?");
//			DeleteUser.setInt(1, uid);
//			boolean result = DeleteUser.execute();
//			ConnectionUtility.closeConnection(null);
//			return result;
//		}
//		catch(Exception e) {
//			ConnectionUtility.closeConnection(e);
//		}
//		return false;
//	}
	
//	public UserDTO setUpDTO(ResultSet r) {
//		UserDTO userDTO = new UserDTO();
//		try {
//			if(r.next()) {     
//				userDTO.setUid(r.getInt("uid"));
//				userDTO.setUname(r.getString("uname"));
//				userDTO.setUpass(r.getString("upass"));
//				userDTO.setFlag(r.getInt("flag"));
//			}
//			else {
//				return null;
//			}
//			return userDTO;
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@Override
	public int generatePrimaryKey() {
		try {
			this.con = ConnectionUtility.createConnection();
			Statement st = this.con.createStatement();
			ResultSet rs = st.executeQuery("SELECT uid FROM users ORDER BY uid DESC LIMIT 1");
			int result = 1;
			if(rs.next()) {
				result = rs.getInt("uid") + 1;
			}
			ConnectionUtility.closeConnection(null);
			return result;
		}
		catch(Exception e) {
			ConnectionUtility.closeConnection(e);
		}
		return -1;
	}
	
}