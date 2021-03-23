package beans;

public class Order {
	private String o_id;
	private String c_name;
	private String c_phone;
	private String c_address;
	private float o_price;
	private String bookList_string;
	
	public Order(String o_id, String c_name, String c_phone,
			String c_address, float o_price, String bookList_string) {
		// TODO Auto-generated constructor stub
		this.o_id=o_id;
		this.c_name=c_name;
		this.c_phone=c_phone;
		this.c_address=c_address;
		this.o_price=o_price;
		this.bookList_string=bookList_string;
	}
	public String getO_id() {
		return o_id;
	}
	public void setO_id(String o_id) {
		this.o_id = o_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_phone() {
		return c_phone;
	}
	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public String getBookList_string() {
		return bookList_string;
	}
	public void setBookList_string(String bookList_string) {
		this.bookList_string = bookList_string;
	}
	public float getO_price() {
		return o_price;
	}
	public void setO_price(float o_price) {
		this.o_price = o_price;
	}
}
