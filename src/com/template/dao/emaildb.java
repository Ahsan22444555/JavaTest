package com.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.template.beans.Person;
import com.template.connection.ConnectDB;

public class emaildb {
	 Connection con;
	 
	 public emaildb() {
		 ConnectDB A = new ConnectDB();
		 con = A.connection();
	 }

     public int addEmail(Person person) {
		int result = 0;
		try {
			String query = "insert into email(emailid) values (?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString( 1, person.getEmail());
			result = preparedStatement.executeUpdate();
			query = "Select id from email where emailid=?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString( 1, person.getEmail());
			ResultSet S = preparedStatement.executeQuery();
			query = "insert into person(id,name, fee) values(?, \"Name\", 0.0)";
			preparedStatement = con.prepareStatement(query);
			S.next();
			preparedStatement.setInt( 1, S.getInt("id"));
			System.out.println("Ooolalaa");
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println("Hello down Server 2!");
			e.printStackTrace();
		}
		return result;
     }

	public List<Person> view() {
		// TODO Auto-generated method stub
		List<Person> P = new ArrayList<>();
		try {
		     String query = "Select email.id, emailid, name, fee from email natural join person"; 
		     Statement statement = con.createStatement();
		     ResultSet r = statement.executeQuery(query);
		     while(r.next()) {
		    	 System.out.println(r.getString("emailid")+ r.getNString("name")+ r.getString("fee"));
		    	 Person p = new Person(r.getString("emailid"), r.getNString("name"), r.getString("fee"));
		    	 P.add(p);
		     }
		}
		catch (SQLException e) {
		    e.printStackTrace();
		}
		return P;
	}

	public int delete(String parameter) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
				String query = "Select id from email where emailid=?";
				PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setString( 1, parameter);
				ResultSet S = preparedStatement.executeQuery();
			
	  			query = "delete from email where emailid=?";
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, parameter);
				result = preparedStatement.executeUpdate();
							
				S.next();				
				query = "delete from person where id=?";
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setInt(1, S.getInt("id"));
				preparedStatement.executeUpdate();
				preparedStatement.close();
			} catch (Exception e) {
				System.out.println("Hello Server2!");
				e.printStackTrace();
			}
		return result;
	}

	public int addName(Person person) {
		int result = 0;
		try {String query = "Select id from email where emailid=?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		System.out.println(person.getEmail() + " AA ");
		preparedStatement.setString( 1, person.getEmail());
		ResultSet S = preparedStatement.executeQuery();
		S.next();
		query = "update person set name=?, fee=? where id=?";
		preparedStatement = con.prepareStatement(query);
		preparedStatement.setString( 1, person.getName());
		preparedStatement.setDouble(2, person.getFee());
		preparedStatement.setInt(3, S.getInt("id"));
		result = preparedStatement.executeUpdate();
		preparedStatement.close();
		}
				catch (Exception e) {
			System.out.println("Hello Server3!");
			e.printStackTrace();
		}
		return result;
	}
}
