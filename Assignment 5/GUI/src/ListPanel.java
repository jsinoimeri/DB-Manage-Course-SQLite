
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

// This is the Panel that contains represents the view of the
// Music Store

public class ListPanel extends JPanel {

	// These are the components
	private JButton		searchButton;
	private JTextField  searchText;
	private JList		StudentsList,
                        GPAList,
                        DepartmentList,
                        ProgramsList,
                        CoursesList,
                        SectionList,
                        SemesterList,
                        ProfessorsList,
                        ResearchList;
	
	public JList getStudentList() {
		return StudentsList;
	}
	public JList getGPAList() {
		return GPAList;
	}
	public JList getDepartmentsList() {
		return DepartmentList;
	}
	public JList getProgramsList() {
		return ProgramsList;
	}
	public JList getCoursesList() {
		return CoursesList;
	}
	public JList getSectionList() {
		return SectionList;
	}
	public JList getSemesterList() {
		return SemesterList;
	}
	public JList getProfessorsList() {
		return ProfessorsList;
	}
	public JList getResearchList() {
		return ResearchList;
	}
	public Font getUIFont() {
		return UIFont;
	}





	private Font UIFont = new Font("Courier New", Font.BOLD, 16);


	// These are the get methods that are used to access the components
	public JButton getSearchButton() { return searchButton; }
	public JTextField getSearchText() { return searchText; }
	
	
	


	// This is the default constructor
	public ListPanel(){
		super();

		// Use a GridBagLayout (lotsa fun)
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		setLayout(layout);

		// Add the bookList list
		StudentsList = new JList();
		StudentsList.setFont(UIFont);
		StudentsList.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");


		// Add the Add button
		searchText = new JTextField("");
		searchText.setFont(UIFont);

		layoutConstraints.gridx = 1;
		layoutConstraints.gridy = 0;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.EAST;
		layoutConstraints.weightx = 1.0;
		layoutConstraints.weighty = 0.0;
		layout.setConstraints(searchText, layoutConstraints);
		add(searchText);

		// Add the Remove button
		searchButton = new JButton("Search");
		layoutConstraints.gridx = 2;
		layoutConstraints.gridy = 0;
		layoutConstraints.gridwidth = 1;
		layoutConstraints.gridheight = 1;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10, 10, 10, 10);
		layoutConstraints.anchor = GridBagConstraints.EAST;
		layoutConstraints.weightx = 0.0;
		layoutConstraints.weighty = 0.0;
		layout.setConstraints(searchButton, layoutConstraints);
		add(searchButton);


		GPAList = new JList();
		GPAList.setFont(UIFont);
		GPAList.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		
		
		DepartmentList = new JList();
		DepartmentList.setFont(UIFont);
		DepartmentList.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		
		
		 ProgramsList = new JList();
		 ProgramsList.setFont(UIFont);
		 ProgramsList.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		 
         CoursesList =  new JList();
         CoursesList.setFont(UIFont);
		 CoursesList.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
         
		 SectionList =  new JList();
		 SectionList.setFont(UIFont);
		 SectionList.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
         
		 SemesterList =  new JList();
		 SemesterList.setFont(UIFont);
		 SemesterList.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
         
		 ProfessorsList =  new JList();
		 ProfessorsList.setFont(UIFont);
		 ProfessorsList.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
         
		 ResearchList =  new JList();
		 ResearchList.setFont(UIFont);
		 ResearchList.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");


	}

}