package utility;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "users")
@Table(name = "users")
public class UserDTO implements Serializable, Comparable<UserDTO> {
	
	@Id()
	private int uid;
	private String uname;
	private String upass;
	private int flag;
	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getUname() {
		return uname;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getUpass() {
		return upass;
	}
	
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public int getFlag() {
		return flag;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(int uid, String uname, String upass, int flag) {
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.flag = flag;
	}
	
	@Override
	public int compareTo(UserDTO o) {
		return this.uname.compareTo(o.uname);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flag;
		result = prime * result + uid;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		result = prime * result + ((upass == null) ? 0 : upass.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (flag != other.flag)
			return false;
		if (uid != other.uid)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		if (upass == null) {
			if (other.upass != null)
				return false;
		} else if (!upass.equals(other.upass))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UserDTO [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", flag=" + flag + "]";
	}
	
}
