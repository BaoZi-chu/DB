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
					    //����MySql��������   
					 Class.forName("com.mysql.cj.jdbc.Driver") ;   
					   }catch(ClassNotFoundException e){   
						    System.out.println("�Ҳ������������� ����������ʧ�ܣ�");   
						    e.printStackTrace() ;   
					    }   
			     con =    
			             DriverManager.getConnection(url , username , password ) ;  
			     stmt = con.createStatement();
			    
			     }catch(SQLException se){   
			    System.out.println("���ݿ�����ʧ�ܣ�");   
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
			    //select������
			    ResultSet rs= stmt.executeQuery("select * from student");
			    while( rs.next() ){ 
			    	System.out.println( "����"+ "\t" + rs.getString("name") + "\t" + "ID" + "\t"+ rs.getString("ID") );}
			   if(rs!=null) {
			    rs.close();
			    rs=null;
			    }
			}catch(SQLException se) {
			    	System.out.println("���ݲ�ѯʧ��");   
				    se.printStackTrace() ;   
			    }
			   
			  
		}
		public static void insert() {
			 try {
				    //insert ������
				    
				    String sql="   insert into student values (32,'ff','Music',4)   ";
				    int result=stmt.executeUpdate(sql);
				    System.out.println(result);
				    }
				    catch(SQLException se){   
					    System.out.println("���ݲ���ʧ�ܣ�");   
					    se.printStackTrace() ;
					    }
		}
		public static void update() {
			 try {
				    //update ������
				    
				    String sql=" update student set name='fcy' where name='f123';   ";
				    int result=stmt.executeUpdate(sql);
				    System.out.println(result);
				    }
				    catch(SQLException se){   
					    System.out.println("���ݸ���ʧ�ܣ�");   
					    se.printStackTrace() ;
					    }
		}
		public static void delete() {
			 try {
				    //delete ������
				    
				    String sql=" delete from student  where ID='112';   ";
				    int result=stmt.executeUpdate(sql);
				    System.out.println(result);
				    }
				    catch(SQLException se){   
					    System.out.println("����ɾ��ʧ�ܣ�");   
					    se.printStackTrace() ;
					    }
		}
		public static void anything(String sql) {
			 try {
				    //���� ������
				    
				  
				    Boolean result=stmt.execute(sql);
				    System.out.println(result);
				    if(result==true) {
				    	ResultSet rs= stmt.getResultSet();
					    while( rs.next() ){ 
					    	System.out.println( "����"+ "\t" + rs.getString("name") + "\t" + "ID" + "\t"+ rs.getString("ID") );}
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
					    System.out.println("sql���ִ��ʧ�ܣ�");   
					    se.printStackTrace() ;
					    }
		}
		public static void beifen() {
		String str="mysqldump -u root -pFCy8849678.   uni student>d:/student_bk.sql";
		
		try {
			Process child=rr.exec("cmd /c"+str);
		} catch (IOException e) {
			System.out.println("���ݱ���ʧ�ܣ�");  
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
				System.out.println("���ݻ�ԭʧ�ܣ�");  
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
	
	
	
	
	
	

	
	
	
	
	



