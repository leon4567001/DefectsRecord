package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DefectsDAO;
import db.DBUtils;
import entity.defectsEntity;

public class DefInput extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        doPost(request,response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
    	//接收表单数据
//    	String line_code = request.getParameter("line");
//    	String category_code = request.getParameter("category");
    	String detail_code = request.getParameter("detail");//只要确定缺陷代码这条数据就确定了
    	String banci = request.getParameter("banci");
    	String cx = request.getParameter("cx");
    	String ljh = request.getParameter("ljh");
    	String strDate = request.getParameter("def_time");

    	//直接以字符串形式传到entity再转换,不行
//    	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			Date date = format.parse(strDate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}

    	
//    	System.out.println("产线是:"+line);//这里提交过来的是line_code
//    	System.out.println("缺陷类别:"+category);
//    	System.out.println("缺陷代码:"+detail_code);
//    	System.out.println("班次是:"+banci);
    	System.out.println("时间是:"+strDate);
    	
    	//查询转换一下
    	Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String line = null,category=null,detail=null;
        String sql = "select * from defects_view where detail_code="+detail_code+" limit 1;" ;
    	try{
    		conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
            while (rs.next()) {
            	line=rs.getString("line_name");
            	category = rs.getString("category");
            	detail = rs.getString("detail_name");
            }
            System.out.println(line);
            System.out.println(category);
            System.out.println(detail);
    	}catch(Exception e) {
            System.out.println("----转换异常:" + e);
            e.printStackTrace();
        } finally {        	
        }
    	
    	//传数据到实体类
    	defectsEntity defects = new defectsEntity();
    	defects.setPro_line(line);
    	defects.setDef_category(category);
    	defects.setDef_detail(detail);
    	defects.setPro_class(banci);
    	defects.setMachine_type(cx);
    	defects.setPart_num(ljh);
    	defects.setDef_date(strToDate(strDate));
		
		//写入
		DefectsDAO def = new DefectsDAO();
		try {
			def.Insert(defects);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //字符串转sql.date
    public static java.sql.Date strToDate(String strDate) {  
        String str = strDate;  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
        java.util.Date d = null;  
        try {  
            d = format.parse(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        java.sql.Date date = new java.sql.Date(d.getTime());  
        return date;  
    } 

}
