package thanh3.model;

public class ManagerModel extends PersonModel{
	private String username;
	private String password;
	private int isAdmin;
	
	
	public ManagerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerModel(String id_user, String hoten, String diachi, String sdt, String ngaysinh, String email,String username, String password, int isAdmin) {
		super(id_user, hoten, diachi, sdt, ngaysinh, email);
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	public ManagerModel(String id_user, String hoten, String diachi, String sdt, String ngaysinh, String email,String username, String password) {
		super(id_user, hoten, diachi, sdt, ngaysinh, email);
		this.username = username;
		this.password = password;
	}
	
	public ManagerModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
