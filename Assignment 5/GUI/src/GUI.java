
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GUI extends JFrame{
		
	public int GUI_DISPLAY_LIMIT = 100;

	// Store the model as a vector of email buddies

	Connection databaseConnection;
	Statement stat;

	ArrayList<Students> students = new ArrayList<>();
	ArrayList<GPA> gpa = new ArrayList<>();
	ArrayList<Departments> departments = new ArrayList<>();
	ArrayList<Programs> programs = new ArrayList<>();
	ArrayList<Courses> courses = new ArrayList<>();
	ArrayList<Section> section = new ArrayList<>();
	ArrayList<Semester> semester = new ArrayList<>();
	ArrayList<Professor> professors = new ArrayList<>();
	ArrayList<Research> research = new ArrayList<>();


	// selected values
	private Students selectedStudent; 
	private GPA selectedGPA; 
	private Departments selectedDepartments;
	private Programs selectedPrograms;
	private Courses selectedCourses;
	private Section selectedSection;
	private Semester selectedSemester;
	private Professor selectedProfessor;
	private Research selectedResearch;
	
	
	
	
	// Store the view that contains the components
	ListPanel 		view; //panel of GUI components for the main window
	GUI thisFrame;

	// Here are the component listeners
	ActionListener			theSearchButtonListener;
	
	ListSelectionListener	studentsListSelectionListener,
                            gpaListSelectionListener,
                            departmentsListSelectionListener,
                            programsListSelectionListener,
                            coursesListSelectionListener,
                            sectionListSelectionListener,
                            semesterListSelectionListener,
                            professorListSelectionListener,
                            researchListSelectionListener;
	
	//MouseListener			doubleClickSongListListener;
	KeyListener             keyListener;

	// Here is the default constructor
	public GUI(String title, Connection aDB, Statement aStatement, ArrayList<Students> students, ArrayList<GPA> gpa, ArrayList<Departments> departments, 
			   ArrayList<Programs> programs, ArrayList<Courses> courses, ArrayList<Section> section, ArrayList<Semester> semester, ArrayList<Professor> professors,
			   ArrayList<Research> research)
	{
		super(title);
		databaseConnection = aDB;
		stat = aStatement;

       
	    this.students = students;
	    this.gpa = gpa;
	    this.departments = departments;
	    this.programs = programs;
	    this.courses = courses;
	    this.section = section;
	    this.semester = semester;
	    this.professors = professors;
	    this.research = research;
	    
        
        
        selectedStudent = null;        
        selectedGPA = null;
        selectedDepartments = null;
        selectedPrograms = null;
        selectedCourses = null;
        selectedSemester = null;
        selectedProfessor = null;
        selectedResearch = null;
        
        
		thisFrame = this;
		
		addWindowListener(
				new WindowAdapter() {
	 				public void windowClosing(WindowEvent e) {
	 					try {
	 						System.out.println("Closing Database Connection");
							databaseConnection.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.exit(0);
					}
				}
			);



		// Make the main window view panel
		add(view = new ListPanel());

		// Add a listener for the add button
		theSearchButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				search();
			}};


			studentsListSelectionListener = new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {
					selectStudent();
				}};
				
            gpaListSelectionListener = new ListSelectionListener() {
    			public void valueChanged(ListSelectionEvent event) {
    				selectGPA();
    			}};
    			
            departmentsListSelectionListener = new ListSelectionListener() {
    			public void valueChanged(ListSelectionEvent event) {
    				selectDepartments();
    			}};
    			
            programsListSelectionListener = new ListSelectionListener() {
    			public void valueChanged(ListSelectionEvent event) {
    				selectPrograms();
    			}};
    			
            coursesListSelectionListener = new ListSelectionListener() {
    			public void valueChanged(ListSelectionEvent event) {
    				selectCourses();
    			}};
            sectionListSelectionListener = new ListSelectionListener() {
    			public void valueChanged(ListSelectionEvent event) {
    				selectSection();
    			}};
            semesterListSelectionListener = new ListSelectionListener() {
    			public void valueChanged(ListSelectionEvent event) {
    				selectSemester();
    			}};
            professorListSelectionListener = new ListSelectionListener() {
    			public void valueChanged(ListSelectionEvent event) {
    				selectProfessors();
    			}};
            researchListSelectionListener = new ListSelectionListener() {
    			public void valueChanged(ListSelectionEvent event) {
    				selectResearch();
    			}};


    			/*
		// Add a listener to allow double click selections from the list for editing
				doubleClickSongListListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() == 2) {
					JList theList = (JList) event.getSource();
					int index = theList.locationToIndex(event.getPoint());
					songBeingEdited = (FakeBookSong) theList.getModel().getElementAt(index);
					System.out.println("Double Click on: " + songBeingEdited);
					
					
					SongDetailsDialog dialog = new SongDetailsDialog(thisFrame, thisFrame, "Song Details Dialog", true, songBeingEdited);         
					dialog.setVisible(true);

				} 
					
			}};*/
			
		keyListener = new KeyListener() {

				@Override
				public void keyPressed(KeyEvent arg0) {
						
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					
				}

				@Override
				public void keyTyped(KeyEvent arg0) {

					int keyChar = arg0.getKeyChar();

			        if (keyChar == KeyEvent.VK_ENTER)  search();
				
				}};


        setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,300);

		// Start off with everything updated properly to reflect the model state
		update();
	}

	// Enable all listeners
	private void enableListeners() {
		view.getSearchButton().addActionListener(theSearchButtonListener);
		view.getStudentList().addListSelectionListener(studentsListSelectionListener);
		view.getGPAList().addListSelectionListener(gpaListSelectionListener);
		view.getDepartmentsList().addListSelectionListener(departmentsListSelectionListener);
		view.getProgramsList().addListSelectionListener(programsListSelectionListener);
		view.getCoursesList().addListSelectionListener(coursesListSelectionListener);
		view.getSectionList().addListSelectionListener(sectionListSelectionListener);
		view.getSemesterList().addListSelectionListener(semesterListSelectionListener);
		view.getProfessorsList().addListSelectionListener(professorListSelectionListener);
		view.getResearchList().addListSelectionListener(researchListSelectionListener);
		//view.getSongList().addMouseListener(doubleClickSongListListener);
		view.getSearchText().addKeyListener(keyListener);
	}

	// Disable all listeners
	private void disableListeners() {
		view.getSearchButton().removeActionListener(theSearchButtonListener);
		
		view.getStudentList().removeListSelectionListener(studentsListSelectionListener);
		view.getGPAList().removeListSelectionListener(gpaListSelectionListener);
		view.getDepartmentsList().removeListSelectionListener(departmentsListSelectionListener);
		view.getProgramsList().removeListSelectionListener(programsListSelectionListener);
		view.getCoursesList().removeListSelectionListener(coursesListSelectionListener);
		view.getSectionList().removeListSelectionListener(sectionListSelectionListener);
		view.getSemesterList().removeListSelectionListener(semesterListSelectionListener);
		view.getProfessorsList().removeListSelectionListener(professorListSelectionListener);
		view.getResearchList().removeListSelectionListener(researchListSelectionListener);
		//view.getSongList().removeMouseListener(doubleClickSongListListener);
		view.getSearchText().removeKeyListener(keyListener);
	}


	// This is called when the user clicks the add button
		private void search() {
			
			String searchPrototype = view.getSearchText().getText().trim();
			
			
            if (searchPrototype.length() > 0)
            {
            	boolean st = false;
            	boolean gp = false;
            	boolean de = false;
            	boolean prog = false;
            	boolean co = false;
            	boolean sec = false;
            	boolean sem = false;
            	boolean prof = false;
            	boolean res = false;
            	
            	ArrayList<Students> stu = new ArrayList<Students>();
            	ArrayList<GPA> g = new ArrayList<>();
            	
            	
            	if (searchPrototype.contains("Students"))
            		st = true;
            	

            	if (searchPrototype.contains("GPA"))
            		gp = true;
            	

            	if (searchPrototype.contains("Departments"))
            		de = true;
            	

            	if (searchPrototype.contains("Programs"))
            		prog = true;
            	
            	if (searchPrototype.contains("Courses"))
            		co = true;
            	

            	if (searchPrototype.contains("Section"))
            		sec = true;
            	

            	if (searchPrototype.contains("Semester"))
            		sem = true;
            	

            	if (searchPrototype.contains("Professors"))
            		prof = true;
            	
            	if (searchPrototype.contains("Research"))
            		res = true;
            	
            	
			    try {
					ResultSet rs = stat.executeQuery(searchPrototype);
					
					while (rs.next() && st) 
					{
						Students student = new Students(rs.getString("StudentID"), rs.getString("Name"), rs.getString("Email"), rs.getString("Address"), rs.getString("ProgramID"));
					    stu.add(student);
					}
				        

					
					
						
					
					students = stu;
					
					for(int i = 0; i < students.size(); i++)
						System.out.println(students.get(i).toString());
					

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				update();
			}
            System.out.println("Search clicked");
		}


	// This is called when the user clicks the edit button


	private void selectStudent()
	{
		selectedStudent = (Students)(view.getStudentList().getSelectedValue());
		System.out.println("Student Selected: " + selectedStudent);
		
		update();
	}
	
	private void selectGPA()
	{
		selectedGPA = (GPA)(view.getGPAList().getSelectedValue());
		System.out.println("GPA Selected: " + selectedGPA);
		
		update();
	}
	
	private void selectDepartments()
	{
		selectedDepartments = (Departments)(view.getDepartmentsList().getSelectedValue());
		System.out.println("Department Selected: " + selectedDepartments);
		
		update();
	}
	
	private void selectPrograms()
	{
		selectedPrograms = (Programs)(view.getProgramsList().getSelectedValue());
		System.out.println("Program Selected: " + selectedPrograms);
		
		update();
	}
	
	private void selectCourses()
	{
		selectedCourses = (Courses)(view.getCoursesList().getSelectedValue());
		System.out.println("Course Selected: " + selectedCourses);
		
		update();
	}
	
	private void selectSection()
	{
		selectedSection = (Section)(view.getSectionList().getSelectedValue());
		System.out.println("Section Selected: " + selectedSection);
		
		update();
	}
	
	private void selectSemester()
	{
		selectedSemester = (Semester)(view.getSemesterList().getSelectedValue());
		System.out.println("Semester Selected: " + selectedSemester);
		
		update();
	}
	
	
	private void selectProfessors()
	{
		selectedProfessor = (Professor)(view.getProfessorsList().getSelectedValue());
		System.out.println("Professor Selected: " + selectedProfessor);
		
		update();
	}
	
	
	private void selectResearch()
	{
		selectedResearch = (Research)(view.getResearchList().getSelectedValue());
		System.out.println("Research Selected: " + selectedResearch );
		
		update();
	}
	
	


	// Update the remove button
	private void updateSearchButton() {
		view.getSearchButton().setEnabled(true);
	}



	// Update the list
	@SuppressWarnings("unchecked")
	private void updateList() {
		boolean		foundSelected = false;
		
		Students st[] = new Students[1];
		view.getStudentList().setListData(((Students []) students.toArray(st)));

		GPA g[] = new GPA[1];
		view.getGPAList().setListData(((GPA []) gpa.toArray(g)));
		
		Departments d[] = new Departments[1];
		view.getDepartmentsList().setListData(((Departments []) departments.toArray(d)));
		/*
		Programs prog[] = new Programs[1];
		view.getProgramsList().setListData(((Programs []) programs.toArray(prog)));
		
		Courses c[] = new Courses[1];
		view.getCoursesList().setListData(((Courses []) courses.toArray(c)));
		
		Section sec[] = new Section[1];
		view.getSectionList().setListData(((Section []) section.toArray(sec)));
		
		Semester sem[] = new Semester[1];
		view.getSemesterList().setListData(((Semester []) semester.toArray(sem)));
		
		Professor prof[] = new Professor[1];
		view.getProfessorsList().setListData(((Professor []) professors.toArray(prof)));
		
		Research r[] = new Research[1];
		view.getResearchList().setListData(((Research []) research.toArray(r)));
		
*/
		if (selectedStudent != null)
			view.getStudentList().setSelectedValue(selectedStudent, true);
		
		if (selectedGPA != null)
			view.getGPAList().setSelectedValue(selectedGPA, true);
		
		if (selectedDepartments != null)
			view.getDepartmentsList().setSelectedValue(selectedDepartments , true);
		
		if (selectedPrograms != null)
			view.getProgramsList().setSelectedValue(selectedPrograms, true);
		
		if (selectedCourses != null)
			view.getCoursesList().setSelectedValue(selectedCourses, true);
		
		if (selectedSection != null)
			view.getSectionList().setSelectedValue(selectedSection , true);
		
		if (selectedSemester != null)
			view.getSemesterList().setSelectedValue(selectedSemester, true);
		
		if (selectedProfessor != null)
			view.getProfessorsList().setSelectedValue(selectedProfessor, true);
		
		if (selectedResearch != null)
			view.getResearchList().setSelectedValue(selectedResearch, true);

	}

	// Update the components
	private void update() {
		disableListeners();
		updateList();
		updateSearchButton();
		enableListeners();
	}

}