package thanh3.model;

public class CartModel extends ProductModel {
	private String maGioHang;
	private String maDH;
	private String maSP;
	private int totalCart;
	private double tongtien;

	public CartModel() {
		super();
	}

	public CartModel(String id, String ten, String mota, double dongia, String danhmuc, int soluong, String image,
			String maGioHang, String maDH, int totalCart, double tongtien) {
		super(id, ten, mota, dongia, danhmuc, soluong, image);
		this.maGioHang = maGioHang;
		this.maDH = maDH;
		this.totalCart = totalCart;
		this.tongtien = tongtien;
	}

	public String getMaGioHang() {
		return maGioHang;
	}

	public void setMaGioHang(String maGioHang) {
		this.maGioHang = maGioHang;
	}

	public String getMaDH() {
		return maDH;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public int getTotalCart() {
		return totalCart;
	}

	public void setTotalCart(int totalCart) {
		this.totalCart = totalCart;
	}

	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}

	@Override
	public String toString() {
		return "CartModel [maGioHang=" + maGioHang + ", maDH=" + maDH + ", maSP=" + maSP + ", totalCart=" + totalCart
				+ ", tongtien=" + tongtien + "]";
	}
	
}
