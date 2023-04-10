package thanh3.model;

public class CategoryModel {
	private int id;
	private String ten;
	private String image;

	public CategoryModel(int id, String ten, String image) {
		super();
		this.id = id;
		this.ten = ten;
		this.image = image;
	}

	public CategoryModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
