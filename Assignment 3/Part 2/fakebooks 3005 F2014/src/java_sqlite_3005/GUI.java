package java_sqlite_3005;

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


public class GUI extends JFrame implements DialogClient{
		
	public int GUI_DISPLAY_LIMIT = 100;

	// Store the model as a vector of email buddies

	Connection databaseConnection;
	Statement stat;

	ArrayList<FakeBook> bookList = new ArrayList<FakeBook>();
	ArrayList<FakeBookSong> songList = new ArrayList<FakeBookSong>();


	private FakeBookSong    selectedSong; //song currently selected in the GUI list
	private FakeBook		selectedBook; //book currently selected in the GUI list
	
	private FakeBookSong songBeingEdited; //song being edited in a dialog
	
	
	// Store the view that contains the components
	ListPanel 		view; //panel of GUI components for the main window
	GUI thisFrame;

	// Here are the component listeners
	ActionListener			theSearchButtonListener;
	ListSelectionListener	songListSelectionListener;
	ListSelectionListener	bookListSelectionListener;
	MouseListener			doubleClickSongListListener;
	KeyListener             keyListener;

	// Here is the default constructor
	public GUI(String title, Connection aDB, Statement aStatement, ArrayList<FakeBook> initialBooks, ArrayList<FakeBookSong> initialSongs) {
		super(title);
		databaseConnection = aDB;
		stat = aStatement;

        bookList = initialBooks;
        songList = initialSongs;
		selectedBook = null;
		selectedSong = null;
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



		// Add a listener to allow selection of buddies from the list
		songListSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				selectSong();
			}};
		// Add a listener to allow selection of buddies from the list
		bookListSelectionListener = new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent event) {
					selectBook();
				}};

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
					
			}};
			
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
		view.getBookList().addListSelectionListener(bookListSelectionListener);
		view.getSongList().addListSelectionListener(songListSelectionListener);
		view.getSongList().addMouseListener(doubleClickSongListListener);
		view.getSearchText().addKeyListener(keyListener);
	}

	// Disable all listeners
	private void disableListeners() {
		view.getSearchButton().removeActionListener(theSearchButtonListener);
		view.getBookList().removeListSelectionListener(bookListSelectionListener);
		view.getSongList().removeListSelectionListener(songListSelectionListener);
		view.getSongList().removeMouseListener(doubleClickSongListListener);
		view.getSearchText().removeKeyListener(keyListener);
	}


	// This is called when the user clicks the add button
	private void search() {
		
		String searchPrototype = view.getSearchText().getText().trim();
		
		String sqlQueryString = "select * from songs where title = ?";
		
		// from here up to the try statement is part C.
		
		boolean specialCase = false;
		boolean invalidEntry = false;
		
		//check some special cases
        if(searchPrototype.equals("*") || searchPrototype.equals("%") || searchPrototype.equals(""))
        {
        	sqlQueryString = "select * from songs";
        	specialCase = true;
        }
        
        
        // outputs invalid sql command if there is a sql insertion in the gui
        if (searchPrototype.startsWith("Select *") || searchPrototype.startsWith("select *") || searchPrototype.startsWith("SELECT *") )
        {
        	sqlQueryString = "select * from songs";
        	invalidEntry = true;
        	System.out.println("\nInvalid sql command \n");
        }
        
		if (selectedBook != null && !specialCase && !invalidEntry)
			sqlQueryString += " and bookcode = ?";
		
		else if (specialCase && selectedBook != null && !invalidEntry)
			sqlQueryString += " where bookcode = ?";
		
		
		sqlQueryString += " order by title asc;";
        
        
        
        

	    try {
	    	
	    	// part D
	    	PreparedStatement select = this.databaseConnection.prepareStatement(sqlQueryString);
	    	
	    	if (!specialCase && !invalidEntry)
	    		select.setString(1, searchPrototype);
	    	
	    	if (selectedBook != null && specialCase && !invalidEntry)
	    		select.setString(1, selectedBook.getBookCode());
	    	
	    	else if (selectedBook != null && !specialCase && !invalidEntry)
	    		select.setString(2, selectedBook.getBookCode());
	    	
			select.execute();
	    	
			ResultSet rs = select.getResultSet();
			
	    	
			//ResultSet rs = stat.executeQuery(sqlQueryString);
			
            ArrayList<FakeBookSong> songSearchResults = new ArrayList<FakeBookSong>();

	        int count = 0;
	        while (rs.next() && count < GUI_DISPLAY_LIMIT){
	        	FakeBookSong song = new FakeBookSong(
	        			rs.getInt("id"),
	        			rs.getString("bookcode"),
	        			rs.getInt("page"),
	        			rs.getString("title")
	        			);
	        	
	            songSearchResults.add(song);
            count++;
	        }
	        rs.close(); //close the query result table
	        FakeBookSong songArray[] = new FakeBookSong[1]; //just to establish array type
	        songList = songSearchResults;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Search clicked");
		update();
	}


	// This is called when the user clicks the edit button


	// This is called when the user selects a book from the list
	private void selectBook() {
		selectedBook = (FakeBook)(view.getBookList().getSelectedValue());
		System.out.println("Book Selected: " + selectedBook);
	
		update();
	}
	// This is called when the user selects a song from the list
	private void selectSong() {
		selectedSong = (FakeBookSong)(view.getSongList().getSelectedValue());
		System.out.println("Song Selected: " + selectedSong);
	
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

        FakeBook bookArray[] = new FakeBook[1]; //just to establish array type
	    view.getBookList().setListData(((FakeBook []) bookList.toArray(bookArray)));

	    FakeBookSong songArray[] = new FakeBookSong[1]; //just to establish array type
	    view.getSongList().setListData(((FakeBookSong []) songList.toArray(songArray)));

		if (selectedBook != null)
			view.getBookList().setSelectedValue(selectedBook, true);
		if (selectedSong != null)
			view.getSongList().setSelectedValue(selectedSong, true);
	}

	// Update the components
	private void update() {
		disableListeners();
		updateList();
		updateSearchButton();
		enableListeners();
	}

	@Override
	public void dialogFinished(DialogClient.operation requestedOperation) {
		
		int index = this.findSong();
		
		
		// Part A
		
		// TODO 
		if(requestedOperation == DialogClient.operation.UPDATE){
			//TO DO
			if (index == -1)
				System.out.println("Cannot find song. ID has changed");
			
			else
			{
				this.songList.set(index, songBeingEdited);
				
				try {
					PreparedStatement update = this.databaseConnection.prepareStatement("UPDATE songs SET bookcode = ?, page = ?, title = ? WHERE id = ?");
					update.setString(1, this.songBeingEdited.getBookCode());
					update.setInt(2, this.songBeingEdited.getPage());
					update.setString(3, this.songBeingEdited.getTitle());
					update.setInt(4, this.songBeingEdited.getID());
					update.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			//update song data in database
			System.out.println("UPDATE: " + songBeingEdited );
		}
		
		
		// Part B
		
		else if(requestedOperation == DialogClient.operation.DELETE){
			//TO DO
			
			if (index == -1)
				System.out.println("Cannot find song. ID has changed");
			
			else
			{
				this.songList.remove(index);
				
				try {
					PreparedStatement delete = this.databaseConnection.prepareStatement("DELETE from songs WHERE id = ?");
					delete.setInt(1, this.songBeingEdited.getID());
					delete.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//delete song from database
			System.out.println("DELETE: " + songBeingEdited );
			
		}
		songBeingEdited = null;
		update();
	}

	@Override
	public void dialogCancelled() {

		songBeingEdited = null;
		update();
		
	}
	
	private int findSong()
	{
		for (int i = 0; i < this.songList.size(); i++)
			if (this.songList.get(i).getID() == songBeingEdited.getID())
				return i;
		
		return -1;
	}

}