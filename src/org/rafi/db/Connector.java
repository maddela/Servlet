package org.rafi.db;


//package org.rafi.util;


import java.sql.*;


public class Connector {
	static PreparedStatement pstmt;
	private static Connection con = null;
	public static void main(String[] args) throws Exception {
		System.out.println(validateUser("rafi", "smd"));
	}
	public static boolean validateUser( String uname, String password)throws Exception 
	{
		try 
		{
			con = establishConnection();
			pstmt = con.prepareStatement("SELECT uname,password FROM login WHERE uname = ? ");
			pstmt.setString(1,uname);
			//pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				System.out.println("password is "+rs.getString(2)+" username is "+rs.getString(1));
				if(rs.getString(2).equals(password))
				{
					return true;	
				}
				return false;
			}
			else
				return false;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try 
			{
				if(pstmt!=null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return false;
	
	}
	
	
	
	public static boolean products( String productname)throws Exception 
	{
		try 
		{
			con = establishConnection();
			pstmt = con.prepareStatement("SELECT productname FROM products WHERE uname = ? ");
			pstmt.setString(1,productname);
			//pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				//System.out.println("password is "+rs.getString(2)+" username is "+rs.getString(1));
				if(rs.getString(1).equals(productname))
				{
					return true;	
				}
				return false;
			}
			else
				return false;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try 
			{
				if(pstmt!=null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return false;
	
	}




	
	
	public static boolean insertUser( String uname, String password, String emaiId, String phonenum, String gender)throws Exception 
	{
		try 
		{
			con = establishConnection();
			pstmt = con.prepareStatement("insert into login (uname,password, emaiId, phonenum, gender) values (?,?,?,?,?)");
			pstmt.setString(1,uname);
			pstmt.setString(2, password);
			pstmt.setString(3, emaiId);
			pstmt.setString(4, phonenum);
			pstmt.setString(5, gender);
			System.out.println("username is"+uname);
			System.out.println("password is"+password);
			System.out.println("emailid is "+emaiId);
			System.out.println("phonenum  is"+phonenum);
			System.out.println("gender is" +gender);

			int rs = pstmt.executeUpdate();
			System.out.println("row updated " +rs);
			if(rs==1)

			{

				return true;
			}
			else
				return false;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try 
			{
				if(pstmt!=null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return false;

	}
	
	public static boolean kurBook( String tt, String author, String cost, String phonenum, String type)throws Exception 
	{
		try 
		{
			con = establishConnection();
			pstmt = con.prepareStatement("insert into kur (tt,author, cost, phonenum, type) values (?,?,?,?,?)");
			pstmt.setString(1,tt);
			pstmt.setString(2, author);
			pstmt.setString(3, cost);
			pstmt.setString(4, phonenum);
			pstmt.setString(5, type);
			System.out.println("username is"+tt);
			System.out.println("password is"+author);
			System.out.println("emailid is "+cost);
			System.out.println("phonenum  is"+phonenum);
			System.out.println("gender is" +type);
			
		int rs = pstmt.executeUpdate();
		System.out.println("row updated " +rs);
			if(rs==1)
				
			{
				
				return true;
			}
			else
				return false;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try 
			{
				if(pstmt!=null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return false;
	
	}
	

	

	public static Connection establishConnection() throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dimpy","root","theo");
		}
		catch(ClassNotFoundException ex)
		{
			System.err.print("com.mysql.jdbc.Driver Not Found\n"+ex);
		}
		catch(SQLException ex)
		{
			System.err.print("sql exception\n"+ex);
		}
		return con;
	}
}
