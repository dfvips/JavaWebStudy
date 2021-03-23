package beans;

public class Book {
	private String b_id;
	private String b_name;
	private String b_author;
	private String b_price;
	private String b_img;
	
	public Book(String b_id, String b_name, String b_author, String b_price, String b_img) {
		// TODO Auto-generated constructor stub
		this.b_id=b_id;
		this.b_name=b_name;
		this.b_author=b_author;
		this.b_price=b_price;
		this.b_img=b_img;
	}
	public Book(){
		
	}
	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_author() {
		return b_author;
	}

	public void setB_author(String b_author) {
		this.b_author = b_author;
	}

	public String getB_price() {
		return b_price;
	}

	public void setB_price(String b_price) {
		this.b_price = b_price;
	}

	public String getB_img() {
		return b_img;
	}

	public void setB_img(String b_img) {
		this.b_img = b_img;
	}
}
