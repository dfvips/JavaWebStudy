package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Order;
import net.sf.json.JSONArray;

import com.google.gson.*;

/**
 * Servlet implementation class Chapter6_3Servlet
 */
@WebServlet("/Chapter6_3Servlet")
public class Chapter6_3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chapter6_3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter();
		PrintWriter out=response.getWriter();
		String Order=request.getParameter("Order");
		JsonParser jp = new JsonParser();
		JsonObject jo=null;
		try{
			jo= jp.parse(Order).getAsJsonObject();
			JsonArray array=jo.get("Order").getAsJsonArray();
			JsonObject object=array.get(0).getAsJsonObject();
			String o_id=object.get("o_id").getAsString();
			String c_name=object.get("c_name").getAsString();
			String c_phone=object.get("c_phone").getAsString();
			String c_address=object.get("c_address").getAsString();
			float o_price=object.get("o_price").getAsFloat();
			String o_bookList=object.get("bookList_string").getAsJsonArray().toString();
			Order od=new Order(o_id,c_name,c_phone,c_address,o_price,o_bookList);
			JSONArray json = JSONArray.fromObject(od);//将java对象转换为json对象  
	        String order = json.toString().replaceAll("\\\\","").replace("\"o_price\":", "\"o_price\":￥");//将json对象转换为字符串
	        out.print(order);
//	        out.print(Order);
		}catch (Exception e) {
			// TODO: handle exception
			out.print("fail");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
