/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author lokyiec
 */
public class BookDao {
    
    public static int save(String callno,String name,String author,String publisher,int quantity){
	int status=0;
        
	try {
            Connection con=DB.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into books(callno,name,author,publisher,quantity) values(?,?,?,?,?)");
            ps.setString(1,callno);
            ps.setString(2,name);
            ps.setString(3,author);
            ps.setString(4,publisher);
            ps.setInt(5,quantity);
            status=ps.executeUpdate();
            con.close();
	} catch(Exception e){
            System.out.println(e);
        }
        return status;
    }

    public static boolean PublisherValidate(String Publisher) {
        boolean status = false;
        
        try(Connection con = DB.getConnection()) {
            PreparedStatement ps = con.prepareStatement("select * from Publisher where PublisherName = ?"); 
            ps.setString(1, Publisher);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
        return status;
    }
    
    public static int AddPublisher( String Publisher) {
        int status= 0;
        
        try(Connection con = DB.getConnection()) {
            PreparedStatement ps=con.prepareStatement("insert into Publisher(PublisherName) values(?)");
            ps.setString(1,Publisher);
            status=ps.executeUpdate();
            con.close();
	} catch(Exception e){
            System.out.println(e);
        }
	return status;
    }
  
    public static int SaveBook(String BookN, String AuthorN, String PublisherN, String IsbnN) {
        int status= 0;
        
        try(Connection con = DB.getConnection()) {
            PreparedStatement ps=con.prepareStatement("insert into Books(BookName,Author,ISBN,Publisher) values(?,?,?,?)");
            ps.setString(1,BookN);
            ps.setString(2, AuthorN);
            ps.setString(3, IsbnN);
            ps.setString(4, PublisherN);
            status=ps.executeUpdate();
            con.close();
	} catch(Exception e){
            System.out.println(e);
        }
	return status;    }
    
    public static int Delete(int BookID) {
        int status= 0;
        
        try(Connection con = DB.getConnection()) {
            PreparedStatement ps=con.prepareStatement("DELETE FROM Books where BookID=?");
            ps.setInt(1,BookID);
            status=ps.executeUpdate();
            con.close();
	} catch(Exception e) {
            System.out.println(e);
        }
	return status;       
    }
            
    
 

}
