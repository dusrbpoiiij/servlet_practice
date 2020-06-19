package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program {

	public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement st = null;
        ResultSet rs = null;
        

        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://192.168.0.33/practice";
            conn = DriverManager.getConnection(url, "mysqladmin", "pantal90");
            
            
            String sql = "SELECT * FROM NOTICE WHERE HIT >= 10";
            
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()) {
            	int id = rs.getInt("ID");
            	String title = rs.getString("TITLE");
            	String writeId = rs.getString("WRITER_ID");
            	Date regDate = rs.getDate("REGDATE");
            	String content = rs.getString("CONTENT");
            	int hit = rs.getInt("HIT");
            	
            	System.out.printf("id : %d , title : %s, writeId : %s, regDate : %s, content : %s , hit : %d\n"
            			,id,title,writeId,regDate,content,hit);
            }

        }
        catch(ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch(SQLException e){
            System.out.println("에러: " + e);
        }
        finally{
            try{
            	rs.close();
            	st.close();
                conn.close();
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
	}

}
