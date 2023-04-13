package thanh3.model;

public class OrderModel {
	private String maDH;
	private String ngayDatHang;
	private String maKH;
	private double tongtien;

	public OrderModel(String maDH, String ngayDatHang, String maKH, double tongtien) {
		super();
		this.maDH = maDH;
		this.ngayDatHang = ngayDatHang;
		this.maKH = maKH;
		this.tongtien = tongtien;
	}

	public OrderModel() {
		super();
	}

	public String getMaDH() {
		return maDH;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}

	public String getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(String ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}

}
