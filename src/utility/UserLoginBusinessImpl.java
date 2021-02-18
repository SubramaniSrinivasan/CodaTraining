package utility;

interface UserLoginBusiness {
	public boolean checkUser(String uname, String upass);
	public boolean checkStatus(String uname);
	public int updateStatus(String uname, int flag);
	public int registerUser(String uname, String upass);
	public int generatePrimaryKey();
}

public class UserLoginBusinessImpl implements UserLoginBusiness {
	
	UserDAO userDAO;
	
	public UserLoginBusinessImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public boolean checkUser(String uname, String upass) {
		return this.userDAO.findByUname(uname) != null;
	}
	
	@Override
	public boolean checkStatus(String uname) {
		UserDTO userDTO = this.userDAO.findByUname(uname);
		return userDTO.getFlag() == 1;
	}
	
	@Override
	public int updateStatus(String uname, int flag) {
		UserDTO userDTO = this.userDAO.findByUname(uname);
		userDTO.setFlag(flag);
		return this.userDAO.updateUser(userDTO);
	}
	
	@Override
	public int registerUser(String uname, String upass) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUid(generatePrimaryKey());
		userDTO.setUname(uname);
		userDTO.setUpass(upass);
		userDTO.setFlag(1);
		return this.userDAO.insertUser(userDTO);
	}
	
	@Override
	public int generatePrimaryKey() {
		return this.userDAO.generatePrimaryKey();
	}
	
}