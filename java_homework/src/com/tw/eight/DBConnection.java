package com.tw.eight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class DBConnection {
	public static void main(String [] agv){
		Scanner in=new Scanner(System.in);
		String word=in.next();
		Connection conn;
		try{
			
			
			Class.forName("com.mysql.jdbc.Driver");
			 String url="jdbc:mysql://localhost:3306/test";
			 String user="root";
			 String pwd="abcd0987";
			 conn=DriverManager.getConnection(url,user,pwd);
			 PreparedStatement ps=conn.prepareStatement("select * from words where word=?");
			ps.setString(1, word);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println("单词  "+rs.getString(2)+"　　");
				System.out.println("音标  "+rs.getString(3)+"  ");
				System.out.println("中文   "+rs.getString(4)+"  ");
			}
		}catch(Exception e){
			e.printStackTrace()	;
		}
	}
}
