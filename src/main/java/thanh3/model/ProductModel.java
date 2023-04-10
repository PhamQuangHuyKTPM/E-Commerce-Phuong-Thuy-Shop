package thanh3.model;

public class ProductModel {
	private String id;
	private String ten;
	private String mota;
	private double dongia;
	private String danhmuc;
	private int soluong;
	private String image;



	public ProductModel(String id, String ten, String mota, double dongia, String danhmuc, int soluong,String image) {
		super();
		this.id = id;
		this.ten = ten;
		this.mota = mota;
		this.dongia = dongia;
		this.danhmuc = danhmuc;
		this.soluong = soluong;
		this.image = image;
	}

	public ProductModel() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getDanhmuc() {
		return danhmuc;
	}

	public void setDanhmuc(String danhmuc) {
		this.danhmuc = danhmuc;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getDongia() {
		return dongia;
	}

	public void setDongia(double dongia) {
		this.dongia = dongia;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

}
