

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;



public class javaWithSQliteMain {

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Java With SQLite example");
		GUI frame = null;
		

		//Connect to database
        try {
        	
        	//direct java to the sqlite-jdbc driver jar code
        	// load the sqlite-JDBC driver using the current class loader
			Class.forName("org.sqlite.JDBC");
		
		    
			
			Connection database = DriverManager.getConnection("jdbc:sqlite:myDatabase.db");
		       //create a statement object which will be used to relay a
		       //sql query to the database
		     Statement stat = database.createStatement();
		     			
		   
                //Query database for initial contents for GUI

	            String sqlQueryString = "select * from Students;";
	            System.out.println("");
	            System.out.println(sqlQueryString);

	            ArrayList<Students> students = new ArrayList<Students>();

	            
		        ResultSet rs = stat.executeQuery(sqlQueryString);
		        
		        while (rs.next()) {
		            Students student = new Students(rs.getString("StudentID"), rs.getString("Name"), rs.getString("Email"), rs.getString("Address"), rs.getString("ProgramID"));
		            students.add(student);
		        }
		        rs.close(); //close the query result table
		        

		        

	            sqlQueryString = "select * from GPA;";
	            System.out.println("");
	            System.out.println(sqlQueryString);

	            ArrayList<GPA> gpa = new ArrayList<>();

	            
		        rs = stat.executeQuery(sqlQueryString);
		        
		        while (rs.next()) {
		            GPA g = new GPA(rs.getDouble("Grade"), rs.getString("StudentID"), rs.getString("CourseID"), rs.getString("SemesterID"), rs.getString("SectionID"));
		            gpa.add(g);
		        }
		        rs.close(); //close the query result table
		        

		        sqlQueryString = "select * from Departments;";
	            System.out.println("");
	            System.out.println(sqlQueryString);

	            ArrayList<Departments> departments = new ArrayList<>();

	            
		        rs = stat.executeQuery(sqlQueryString);
		        
		        while (rs.next()) {
		            Departments d = new Departments(rs.getString("DepartmentID"), rs.getString("Name"), rs.getDouble("MinimumGPA"));
		            departments.add(d);
		        }
		        rs.close(); //close the query result table
		        
		        
		        sqlQueryString = "select * from Programs;";
	            System.out.println("");
	            System.out.println(sqlQueryString);

	            ArrayList<Programs> programs = new ArrayList<>();

	            
		        rs = stat.executeQuery(sqlQueryString);
		        
		        while (rs.next()) {
		            Programs p = new Programs(rs.getString("ProgramID"), rs.getString("DepartmentID"), rs.getString("Name"), rs.getInt("Length"));
		            programs.add(p);
		        }
		        rs.close(); //close the query result table
		        
		        
		        
		        
		        sqlQueryString = "select * from Courses;";
	            System.out.println("");
	            System.out.println(sqlQueryString);

	            ArrayList<Courses> courses = new ArrayList<>();

	            
		        rs = stat.executeQuery(sqlQueryString);
		        
		        while (rs.next()) {
		            Courses c = new Courses(rs.getString("CourseID"), rs.getString("PrerequisitesID"), rs.getString("ProgramID"), rs.getString("Name"), rs.getString("Description"));
		            courses.add(c);
		        }
		        rs.close(); //close the query result table
		        
		        
		        
		        sqlQueryString = "select * from Section;";
	            System.out.println("");
	            System.out.println(sqlQueryString);

	            ArrayList<Section> sections = new ArrayList<>();

	            
		        rs = stat.executeQuery(sqlQueryString);
		        
		        while (rs.next()) {
		            Section s = new Section(rs.getString("CourseID"), rs.getString("EmployeeID"), rs.getString("SemesterID"), rs.getString("SectionID"));
		            sections.add(s);
		        }
		        rs.close(); //close the query result table
		        
		        
		        
		        
		        sqlQueryString = "select * from Semester;";
	            System.out.println("");
	            System.out.println(sqlQueryString);

	            ArrayList<Semester> semesters = new ArrayList<>();

	            
		        rs = stat.executeQuery(sqlQueryString);
		        
		        while (rs.next()) {
		            Semester s = new Semester(rs.getString("SemesterID"), rs.getString("Name"));
		            semesters.add(s);
		        }
		        rs.close(); //close the query result table
		        
		        
		        
		        sqlQueryString = "select * from Professors;";
	            System.out.println("");
	            System.out.println(sqlQueryString);

	            ArrayList<Professor> professors = new ArrayList<>();

	            
		        rs = stat.executeQuery(sqlQueryString);
		        
		        while (rs.next()) {
		            Professor p = new Professor(rs.getString("EmployeeID"), rs.getString("DepartmentID"), rs.getString("Title"), rs.getString("Name"), rs.getString("OfficePhoneNum"));
		            professors.add(p);
		        }
		        rs.close(); //close the query result table
		        
		        
		        sqlQueryString = "select * from research;";
	            System.out.println("");
	            System.out.println(sqlQueryString);

	            ArrayList<Research> research = new ArrayList<>();

	            
		        rs = stat.executeQuery(sqlQueryString);
		        
		        while (rs.next()) {
		            Research r = new Research(rs.getString("EmployeeID"), rs.getString("ResearchID"), rs.getString("Name"), rs.getString("Summary"), rs.getDate("StartDate"), rs.getDate("EndDate"));
		            research.add(r);
		        }
		        rs.close(); //close the query result table
		        
		        
		        /*
		        FakeBookSong[] songArray = new FakeBookSong[1]; //just to establish array type
		        songArray =  songSearchResults.toArray(songArray);
				*/
		        //Create GUI with knowledge of database and initial query content
		       frame =  new GUI("Fake Book Index Fall2014", database, stat, students, gpa, departments, programs, courses, sections, semesters,  professors, research); //create GUI frame with knowledge of the database
		        
		        
		        //Leave it to GUI to close database
		        //conn.close(); //close connection to database			
		     //make GUI visible
				frame.setVisible(true);					
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        




	}

}
