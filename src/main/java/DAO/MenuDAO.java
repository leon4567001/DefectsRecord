package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import db.DBUtils;

import static db.DBUtils.getConnection;

public class MenuDAO {
    //获得生产线
    @SuppressWarnings("rawtypes")
    public static  ArrayList<Map> getLine() throws SQLException {
        Map<String, String> map = new HashMap<String, String>();
        ArrayList<Map> rsList = new ArrayList<Map>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from line;" ;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                map = new HashMap<String, String>();
                map.put("code", rs.getString("line_code"));
                map.put("name",rs.getString("line_name"));
                rsList.add(map);
            }
            return rsList;
        } catch (Exception e) {
            System.out.println("----获得产线的方法出现异常:" + e);
            e.printStackTrace();
            return null;
        } finally {
        }
    }


    //根据产线编号获得缺陷类
    @SuppressWarnings("rawtypes")
    public static ArrayList<Map> getCategory(String line_code) throws SQLException {
        Map<String, String> map = new HashMap<String, String>();
        ArrayList<Map> rsList = new ArrayList<Map>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from category where line_code="+line_code+";" ;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                map = new HashMap<String, String>();
                map.put("code", rs.getString("cate_code"));
                map.put("name",rs.getString("category"));
                rsList.add(map);
            }
            return rsList;
        } catch (Exception e) {
            System.out.println("----获得缺陷类的方法出现异常:" + e);
            e.printStackTrace();
            return null;
        } finally {
        }
    }

    //根据市编号获得区
    @SuppressWarnings("rawtypes")
    public static ArrayList<Map> getDetail(String cate_code) throws SQLException {
        Map<String, String> map = new HashMap<String, String>();
        ArrayList<Map> rsList = new ArrayList<Map>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from detail where cate_code="+cate_code+";" ;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                map = new HashMap<String, String>();
                map.put("code", rs.getString("detail_code"));
                map.put("name",rs.getString("detail_name"));
                rsList.add(map);
            }
            return rsList;
        } catch (Exception e) {
            System.out.println("----获得明细的方法出现异常:" + e);
            e.printStackTrace();
            return null;
        } finally {
        }
    }
}
