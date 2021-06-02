package connect;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
public class ConnectTest {
	private static  String url ;
	public static String username  ; 
	private static String password  ;  
	private  static Connection con;
	private  static Statement stmt;
	private static Runtime rr=Runtime.getRuntime();
	ConnectTest(){
		  
		   
	}
		public static void connect() {
			 try{   
				 url = "jdbc:mysql://localhost:3308/uni" ;    
			      username = "root" ;   
			      password = "FCy8849678." ;
			      try{   
					    //加载MySql的驱动类   
					 Class.forName("com.mysql.cj.jdbc.Driver") ;   
					   }catch(ClassNotFoundException e){   
						    System.out.println("找不到驱动程序类 ，加载驱动失败！");   
						    e.printStackTrace() ;   
					    }   
			     con =    
			             DriverManager.getConnection(url , username , password ) ;  
			     stmt = con.createStatement();
			    
			     }catch(SQLException se){   
			    System.out.println("数据库连接失败！");   
			    se.printStackTrace() ;
		}
		} 
		public static void close() {
			try {
				 if(stmt!=null) {
					    stmt.close();
					    stmt=null;
					    }
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				 if(con!=null) {
					    con.close();
					    con=null;
					    }
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		public static void select() {
			try {
			    //select语句测试
			    ResultSet rs= stmt.executeQuery("select * from student");
			    while( rs.next() ){ 
			    	System.out.println( "姓名"+ "\t" + rs.getString("name") + "\t" + "ID" + "\t"+ rs.getString("ID") );}
			   if(rs!=null) {
			    rs.close();
			    rs=null;
			    }
			}catch(SQLException se) {
			    	System.out.println("数据查询失败");   
				    se.printStackTrace() ;   
			    }
			   
			  
		}
		public static void insert() {
			 try {
				    //insert 语句测试
				    
				    String sql="   insert into student values (32,'ff','Music',4)   ";
				    int result=stmt.executeUpdate(sql);
				    System.out.println(result);
				    }
				    catch(SQLException se){   
					    System.out.println("数据插入失败！");   
					    se.printStackTrace() ;
					    }
		}
		public static void update() {
			 try {
				    //update 语句测试
				    
				    String sql=" update student set name='fcy' where name='f123';   ";
				    int result=stmt.executeUpdate(sql);
				    System.out.println(result);
				    }
				    catch(SQLException se){   
					    System.out.println("数据更新失败！");   
					    se.printStackTrace() ;
					    }
		}
		public static void delete() {
			 try {
				    //delete 语句测试
				    
				    String sql=" delete from student  where ID='112';   ";
				    int result=stmt.executeUpdate(sql);
				    System.out.println(result);
				    }
				    catch(SQLException se){   
					    System.out.println("数据删除失败！");   
					    se.printStackTrace() ;
					    }
		}
		public static void anything(String sql) {
			 try {
				    //任意 语句测试
				    
				  
				    Boolean result=stmt.execute(sql);
				    System.out.println(result);
				    if(result==true) {
				    	ResultSet rs= stmt.getResultSet();
					    while( rs.next() ){ 
					    	System.out.println( "姓名"+ "\t" + rs.getString("name") + "\t" + "ID" + "\t"+ rs.getString("ID") );}
					   if(rs!=null) {
					    rs.close();
					    rs=null;
					    }
					 }
					 else {
						 int ss=stmt.getUpdateCount();
						 System.out.println(ss);
					 }
				    }
			
				    catch(SQLException se){   
					    System.out.println("sql语句执行失败！");   
					    se.printStackTrace() ;
					    }
		}
		public static void beifen() {
		String str="mysqldump -u root -pFCy8849678.   uni student>d:/student_bk.sql";
		
		try {
			Process child=rr.exec("cmd /c"+str);
		} catch (IOException e) {
			System.out.println("数据备份失败！");  
			e.printStackTrace();
		}
		
		}
		
		public static void huanyuan() {
			String str="mysql -u root -pFCy8849678.   uni<d:/student_bk.sql";
			
			try {
			    String sql="delete from student";
			    anything(sql);
			    Process proc=rr.exec("cmd /c"+str);
			    InputStream stderr = proc.getErrorStream();
			                 InputStreamReader isr = new InputStreamReader(stderr);
			                 BufferedReader br = new BufferedReader(isr);
			                 String line = null;
			                 System.out.println("<ERROR>");
			                 while ( (line = br.readLine()) != null)
			                     System.out.println(line);
			                 System.out.println("</ERROR>");
			                 int exitVal = proc.waitFor();
			                 System.out.println("Process exitValue: " + exitVal);
				
				} catch (IOException e) {
				System.out.println("数据还原失败！");  
				e.printStackTrace();
				
			}
			catch (Throwable t)
	          {
	             t.printStackTrace();
	           }
			

			}
		
		
		public static void main(String args[]) {
		    connect();
		    select();
	//    insert();

//		    update();
//		    delete();
//		    String sql=" update student set name='fcy' where name='ff';   ";
//	   		anything(sql);
//		    select();
//		   beifen();

		   huanyuan();
//		   insert();
		    select();
		   close();
	 }
	
		
	}
	
	
	
	
	
	

	
	
	
	
	



