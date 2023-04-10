package thanh3.model;

public class PersonModel {
	private String id_user;
	private String hoten;
	private String diachi;
	private String sdt;
	private String ngaysinh;
	private String email;

	public PersonModel() {
		super();
	}

	public PersonModel(String id_user, String hoten, String diachi, String sdt, String ngaysinh, String email) {
		super();
		this.id_user = id_user;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
		this.ngaysinh = ngaysinh;
		this.email = email;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String text) {
		this.sdt = text;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
