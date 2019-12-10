package util;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Column;
public final class JdbcUtil {
	private static String driver ;
	private static String url ;
	private static String user ;
	private static String password ;
   
	private JdbcUtil() {}
	//设计该工具类的静态初始化器中的代码，该代码在装入类时执行，且只执行一次
	static { 
	 
		  try {
			driver = PropertyUtil.get("driver");
			url = PropertyUtil.get("url");
			user = PropertyUtil.get("username");
			password = PropertyUtil.get("password");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//设计获得连接对象的方法getConnection()
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	//设计释放结果集、语句和连接的方法free()
	public static void free(ResultSet rs, Statement st, Connection conn) {
		try { if (rs != null) rs.close();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			try { if (st != null) st.close();
			} catch (SQLException e) {e.printStackTrace();
			} finally {
				  if (conn != null)
				    try { conn.close();
				    } catch (SQLException e) {e.printStackTrace();
				   }
		             }
		     }
	    }
	public static List<String> getTables() throws Exception{
		List<String> tableList=new ArrayList<String>();
		DatabaseMetaData   dbMetaData   =  JdbcUtil.getConnection().getMetaData();  
		 String[]   types   =   {"TABLE"};    	     
		ResultSet   rs =   dbMetaData.getTables(null,   null,   null,types);  
		while(rs.next()) {
			tableList.add(rs.getString("TABLE_NAME"));
		}
		
		return tableList;
	}
	public static List<Column> getColumns(String tableName) throws Exception{
		List<Column> columnList=new ArrayList<Column>();
		String sql="select * from "+tableName;
		  Connection conn=JdbcUtil.getConnection();
	        PreparedStatement pst =conn.prepareStatement(sql);
	        ResultSetMetaData rsmd = pst.getMetaData();
	        int columnCount=rsmd.getColumnCount();
	        for(int i=1;i<=columnCount;i++) {
	        	Column column=new Column(rsmd.getColumnName(i),rsmd.getColumnTypeName(i));
	        	columnList.add(column);
	        }
	      
	        return columnList;

	}
	
	}
