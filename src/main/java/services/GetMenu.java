package services;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import DAO.MenuDAO;
public class GetMenu extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
        String code = request.getParameter("code");
        String grade = request.getParameter("grade");
        System.out.println("grade="+grade);
        System.out.println("code="+code);
        String json = "";
        ArrayList<?> rsList = new ArrayList<Object>();
        Gson gson = new Gson();
        try {
            if(grade.equals("line"))
                rsList=MenuDAO.getLine();
            else if(grade.equals("category"))
                rsList=MenuDAO.getCategory(code);
            else if(grade.equals("detail"))
                rsList=MenuDAO.getDetail(code);
            json = gson.toJson(rsList);
            System.out.println("json="+json);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");//防止出现中文乱码现象
        response.getWriter().print(json);
    }
}
