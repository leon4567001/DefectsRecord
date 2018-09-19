package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.defectsEntity;

public class DefectsDAO {
	//Insert方法 参数是user  返回值为int rs
    public int Insert(defectsEntity defects) throws Exception{
   	 PreparedStatement pst=null;
   	 int rs=0;
//   	 UserCoon coon=new UserCoon();  //实例化UserCoon
   	Connection conn = db.DBUtils.getConnection();
//        Connection coona=coon.getCoon();  //获取getCoon
        String sql_insert="insert into defects (pro_line,def_category,def_detail,pro_class,machine_type,part_num,def_date) values (?,?,?,?,?,?,?);"; //sql语句
       	try {//抛出异常
				pst=conn.prepareStatement(sql_insert);//执行sql语句
				pst.setString(1,defects.getPro_line());//获取值
				pst.setString(2,defects.getDef_category());
				pst.setString(3,defects.getDef_detail());
				pst.setString(4,defects.getPro_class());
				pst.setString(5,defects.getMachine_type());
				pst.setString(6,defects.getPart_num());
				pst.setDate(7, defects.getDef_date());
	    	    rs=pst.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return rs;
    }
}
