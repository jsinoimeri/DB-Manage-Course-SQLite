--Database of that we have been creating since Assignment 1
--Created by Jeton Sinoimeri 100875046
--Version 1.0

--This file is for creating and populating data into tables
--It will delete the tables if there are tables with the same name in the current database




--Begin the transactions
begin transaction;




--Drop the tables if they already exist
drop table if exists Students;
drop table if exists GPA;
drop table if exists Departments;

drop table if exists Programs;
drop table if exists Courses;
drop table if exists Section;

drop table if exists Semester;
drop table if exists Professors;
drop table if exists Research;



--creating the Table called Students
create table Students
(
	StudentID text NOT NULL primary key,
	Name text NOT NULL,
	Email text NOT NULL,
	Address text NOT NULL,
	ProgramID text NOT NULL,
	foreign key (ProgramID) references Programs(ProgramID) on delete cascade
);


--insert values into Students
insert into Students values ('SID100', 'Lea Bit', 'LeaBit@uni.ca', '12 Deer street, FakeTown', 'CE');
insert into Students values ('SID101', 'Bob Ker', 'BobKer@uni.ca', '1134 KMas street, FakeTown', 'EE');
insert into Students values ('SID102', 'Ackameri Gutieka', 'AckameriGutieka@uni.ca', '45 Deer street, FakeTown', 'CS');
insert into Students values ('SID103', 'Rera Bit', 'ReraBit@uni.ca', '12 Deer street, FakeTown', 'CIE');

insert into Students values ('SID107', 'Lindsey McMac', 'LindseyMcMac@uni.ca', '1324 Deed Ave, FakeTown', 'ENVE');
insert into Students values ('SID110', 'James Frey', 'JamesFrey@uni.ca', '121 Main street, FakeTown', 'SC');
insert into Students values ('SID112', 'Bert Hews', 'BertHews@uni.ca', '45 Amble street, FakeTown', 'BI');
insert into Students values ('SID113', 'Sabrina Shae', 'SabrinaShae@uni.ca', '163 Droc Road, FakeTown', 'LW');

insert into Students values ('SID140', 'George Riley', 'GeorgeRiley@uni.ca', '12345 Deer street, FakeTown', 'BUS');
insert into Students values ('SID123', 'Bob Reily', 'BobReily@uni.ca', '356 Loloip street, FakeTown', 'CS');
insert into Students values ('SID152', 'Ackmar Vers', 'Ackmar Vers@uni.ca', '1235 Kebar street, FakeTown', 'ME');
insert into Students values ('SID145', 'Rita Den', 'RitaDen@uni.ca', '102 John street, FakeTown', 'SE');



--creating the Table called GPA
create table GPA
(
	Grade real,
	Status text NOT NULL,
	StudentID text NOT NULL,
	CourseID text NOT NULL,
	SemesterID text NOT NULL,
	SectionID text NOT NULL,
	foreign key (StudentID) references Students(StudentID) on delete cascade,
  foreign key (CourseID) references Courses(CourseID) on delete cascade,
  foreign key (SemesterID) references Semester(SemesterID) on delete cascade,
  foreign key (SectionID) references Section(SectionID) on delete cascade,
  primary key (StudentID, CourseID, SemesterID)
);


--insert values into GPA
insert into GPA values (9.2,	'Passed',	'SID100',	'SYS111',	'F2014',	'A'        );
insert into GPA values (9.8,	'Passed',	'SID100',	'ELEC100',	'F2014',	'B'      );
insert into GPA values (0,	'In Progress',	'SID100',	'SYS211',	'W2015',	'A'    );
insert into GPA values (0,	'In Progress',	'SID100',	'ELEC200',	'W2015',	'B'  );
                        					                                               
insert into GPA values (1.4,	 'Failed',	 'SID101',	 'ELEC100',	 'F2014',	'A'  );
insert into GPA values (1.2,	 'Failed',	 'SID101',	 'MATH100',	 'F2014',	'B'  );
insert into GPA values (0,	 'IN Progress',	 'SID101',	 'SYS111',	 'W2015',	'A');
insert into GPA values (0,	 'In Progress',	 'SID101',	 'BUS100',	 'W2015',	'B');
                        					                                               
insert into GPA values (9.2,	 'Passed',	 'SID102',	 'COMP100',	 'F2014',	'A'    );
insert into GPA values (9.2,	 'Passed',	 'SID102',	 'SCI100',	'F2014',	'B'    );
insert into GPA values (0,	 'In Progress',	 'SID102',	 'COMP200',	 'W2015',	'A');
insert into GPA values (0,	 'In Progress',	 'SID102',	 'SCI200',	 'W2015',	'B');
                        					                                                 
insert into GPA values (9.2,	 'Passed',	 'SID103',	'ECR122',	 'F2014',	'A'      );
insert into GPA values (0,	 'In Progress',	 'SID103',	'ECR222',	 'W2015',	'B'  );
insert into GPA values (0,	 'In Progress',	 'SID103',	'ECR101',	 'W2015',	'A'  );
insert into GPA values (9.2,	 'Passed',	 'SID103',	'ECR100',	 'F2014',	'B'      );
                        					                                               
insert into GPA values (0,	'In Progress',	 'SID107',	'ENV100',	 'W2015',	'A'  );
insert into GPA values (0,	 'In Progress',	 'SID107',	'ECR122',	 'W2015',	'B'  );
insert into GPA values (0,	 'In Progress',	 'SID107',	'SCI100',	 'W2015',	'A'  );
insert into GPA values (0,	 'In Progress',	 'SID107',	'ECR100',	 'W2015',	'B'  );
                        					                                                 
insert into GPA values (8.2,	 'Passed',	 'SID110',	'SCI100',	 'F2014',	'A'    );
insert into GPA values (7.2,	 'Passed',	 'SID110',	'BIO100',	'F2014',	'B'    );
insert into GPA values (5.2,	 'Passed',	 'SID110',	'COMP100',	 'F2014',	'A'    );
insert into GPA values (6.2,	 'Passed',	 'SID110',	'MATH100',	 'F2014',	'B'  );
                        					                                               
insert into GPA values (2.2,	 'Failed',	 'SID112',	'BIO100',	 'F2014',	'A'    );
insert into GPA values (8.2,	 'Passed',	 'SID112',	'COMP100',	 'F2014',	'B'    );
insert into GPA values (7.2,	 'Passed',	 'SID112',	'SCI100',	 'F2014',	'A'    );
insert into GPA values (9.8,	 'Passed',	 'SID112',	'MATH100',	 'F2014',	'B'  );
                        					                                                 
insert into GPA values (8.5,	 'Passed',	 'SID113',	'LAW101',	 'F2014',	'A'    );
insert into GPA values (8.6,	 'Passed',	 'SID113',	'BUS100',	 'F2014',	'B'    );
insert into GPA values (8.7,	 'Passed',	 'SID113',	'MATH100',	 'F2014',	'A'  );
insert into GPA values (6.9,	 'Passed',	 'SID113',	'SCI100',	 'F2014',	'B'    );
                        					                                               
insert into GPA values (0,	 'In Progress',	 'SID140',	'LAW101',	 'W2015',	'A'  );
insert into GPA values (0,	 'In Progress',	 'SID140',	'BUS100',	 'W2015',	'B'  );
insert into GPA values (0,	 'In Progress',	 'SID140',	'MATH100',	 'W2015',	'A');
insert into GPA values (0,	 'In Progress',	 'SID140',	'SCI100',	 'W2015',	'B'  );
                        					                                                 
insert into GPA values (0,	 'In Progress',	 'SID123',	'COMP100',	 'W2015',	'A'  );
insert into GPA values (0,	 'In Progress',	 'SID123',	'SOFT100',	 'W2015',	'B');
insert into GPA values (0,	 'In Progress',	 'SID123',	'SCI100',	 'W2015',	'A'  );
insert into GPA values (0,	 'In Progress',	 'SID123',	'MATH100',	 'W2015',	'B');
                        					                                               
insert into GPA values (1.2,	 'Failed',	 'SID152',	'ECR100',	 'F2014',	'A'    );
insert into GPA values (1.9,	 'Failed',	 'SID152',	'ECR122',	 'F2014',	'B'    );
insert into GPA values (1.7,	 'Failed',	 'SID152',	'ENV100',	 'F2014',	'A'    );
insert into GPA values (1.9,	 'Failed',	 'SID152',	'ELEC100',	 'F2014', 'B'  );
                        					                                                 
insert into GPA values (1.0,	 'Failed',	 'SID145',	'SYS111',	 'F2014',	'A'      );
insert into GPA values (1.0,	 'Failed',	 'SID145',	'ELEC100',	 'F2014',	'B'    );
insert into GPA values (1.2,	 'Failed',	 'SID145',	'SOFT100',	 'F2014',	'A'  );
insert into GPA values (1.2,	 'Failed',	 'SID145',	'COMP100',	 'F2014',	'B'    );



--creating the Table called Departments
create table Departments
(
	DepartmentID text NOT NULL primary key,
	Name text NOT NULL,
	MinimumGPA real
);


--insert values into Departments
insert into Departments values ('Eng', 'Engineering Department', 6.0);
insert into Departments values ('Law', 'Law Department', 5.5);
insert into Departments values ('Sci', 'Science Department', 4.5);
insert into Departments values ('Bus', 'Business Department', 5.0);



--creating the Table called Programs
create table Programs
(
	ProgramID text NOT NULL,
	DepartmentID text NOT NULL,
	Name text NOT NULL,
	Length integer,
	foreign key (DepartmentID) references Departments(DepartmentID) on delete cascade,
	primary key (DepartmentID, ProgramID)
);


--insert values into Programs
insert into Programs values ('CE', 'Eng', 'Computer Engineering', 4);   
insert into Programs values ('EE', 'Eng', 'Electrical Engineering', 4);
insert into Programs values ('MA', 'Sci', 'Math',	4);
insert into Programs values ('CIE', 'Eng', 'Civil Engineering', 4);
                             			                                         
insert into Programs values ('ENVE', 'Eng', 'Enviromental Engineering',	4);
insert into Programs values ('SC', 'Sci', 'Science', 4);
insert into Programs values ('BI', 'Sci', 'Biology', 4);
insert into Programs values ('LW', 'Law', 'Law', 4);
                             			                                         
insert into Programs values ('BUS', 'Bus', 'Business', 4);
insert into Programs values ('CS', 'Sci', 'Computer Science', 4);
insert into Programs values ('ME', 'Eng', 'Mechanical Engineering', 4);
insert into Programs values ('SE', 'Eng', 'Software Engineering', 4);



--creating the Table called Courses
create table Courses
(
	CourseID text NOT NULL,
	PrerequisitesID text,
	ProgramID text NOT NULL,
	Name text NOT NULL,
  Description text NOT NULL,
	primary key (CourseID, PrerequisitesID),
	foreign key (ProgramID) references Programs(ProgramID) on delete cascade
);


--insert values into Courses
insert into Courses values ('SYS111',	NULL,	'CE',	'Computer Organization',	'Students will learn about the organization and architechure of the Computer'                                                        );
insert into Courses values ('SYS211',	'SYS111',	'CE',	'Embedded Systems',	'Students will learn about embedded systems'                                                                                           );
insert into Courses values ('SYS322',	'SYS211',	'CE',	'Processors',	'Students will learn about MicroProcessors and how they are built.'                                                                          );
insert into Courses values ('ELEC100',	NULL,	'EE',	'Circuits',	'The Basics needed for any Electrical Engineering Student. Students will learn about how to build and analyze circuits using various techniques.');
                            				                                                                                                                                                                             
insert into Courses values ('ELEC200',	'ELEC100',	'EE',	'Electronics 1',	'Applying the various techniques obtained to ELEC100, students will analyze complex circuits'                                        );
insert into Courses values ('ELEC300',	'ELEC200',	'EE',	'Electronics 2',	'Students will build the complex circuits studied in Elec200.'                                                                       );
insert into Courses values ('ECR100',	NULL,	'ME',	'Mechanics 1',	'Determining forces in static and dynamic structures'                                                                                          );
insert into Courses values ('ECR101',	'ECR100',	'ME',	'Mechanics 2',	'Developing techiques to better understand static and dynamic structures'                                                                  );
                            				                                                                                                                                                                             
insert into Courses values ('ECR220',	'ECR101',	'ME',	'Mechanics 3',	'Determinig materials needed to build static and dynamic structures'                                                                       );
insert into Courses values ('ECR122',	NULL,	'CIE',	'Civil 1',	'Determining forces in static and dynamic structures'                                                                                            );
insert into Courses values ('ECR222',	'ECR122',	'CIE',	'Civil 2',	'Developing techiques to better understand static and dynamic structures'                                                                    );
insert into Courses values ('ECR322',	'ECR222',	'CIE',	'Civil 3',	'Determinig materials needed to build static and dynamic structures'                                                                         );
                            				                                                                                                                                                                             
insert into Courses values ('ENV100',	NULL,	'ENVE',	'Environment 1',	'Introduction to Enviromental Engineering'                                                                                                 );
insert into Courses values ('ENV200',	'ENV100',	'ENVE',	'Environment 2',	'Developing skills to understand Environmental impact'                                                                                 );
insert into Courses values ('ENV300',	'ENV200',	'ENVE',	'Environment 3',	'Analyze Past Data and Predicting Future Enviriomental impact'                                                                         );
insert into Courses values ('SOFT100',	NULL,	'SE',	'C programming',	'Programming in C using pointers and memory allocation and deallocation'                                                                   );
                            				                                                                                                                                                                             
insert into Courses values ('SOFT200',	'SOFT100',	'SE',	'Game Development',	'Game Development using C++'                                                                                                       );
insert into Courses values ('SOFT300',	'SOFT200',	'SE',	'App Development',	'Introduction to Developing iOS and Android Apps'                                                                                  );
insert into Courses values ('BUS100',	NULL,	'BUS',	'Business',	'Students will become familar with the Business terms and practices'                                                                             );
insert into Courses values ('BUS200',	'BUS100',	'BUS',	'International Business',	'Internation Business'                                                                                                         );
                            				                                                                                                                                                                             
insert into Courses values ('BUS300',	'BUS200',	'BUS',	'Marketing',	'Students will learn about how to market their product to achieve high sales'                                                              );
insert into Courses values ('LAW101',	NULL,	'LW',	'Civil Law',	'Introduction to Civil law'                                                                                                                      );
insert into Courses values ('LAW201',	'LAW101',	'LW',	'Corporate Law',	'Students will learn about Corporate Law'                                                                                                );
insert into Courses values ('LAW301',	'LAW201',	'LW',	'International Law',	'Students will learn about International Law'                                                                                        );
                            				                                                                                                                                                                             
insert into Courses values ('COMP100',	NULL,	'CS',	'JAVA Object Oriented',	'Introduction to Object Oriented Programming using Java'                                                                               );
insert into Courses values ('COMP200',	'COMP100',	'CS',	'GUI design with JAVA',	'Designing GUIs using Java'                                                                                                        );
insert into Courses values ('COMP300',	'COMP200',	'CS',	'Client-Server Commuication',	'Client Server communication using Java'                                                                                     );
insert into Courses values ('MATH100',	NULL,	'MA',	'Calculus 1',	'Students will learn about Basic Calculus'                                                                                                     );
                            				                                                                                                                                                                             
insert into Courses values ('MATH200',	'MATH100',	'MA',	'Calculus 2',	'Multivaribale Calculus'                                                                                                                 );
insert into Courses values ('MATH300',	'MATH200',	'MA',	'Linear Algebra',	'Matrix manipulation'                                                                                                                );
insert into Courses values ('SCI100',	NULL,	'SC',	'Intro to Science',	'Students will learn about the basics of Science'                                                                                          );
insert into Courses values ('SCI200',	'SCI100',	'SC',	'Advanced Science',	'Studetns will learn about advanced techniques used in Science'                                                                        );
                            				                                                                                                                                                                             
insert into Courses values ('SCI300',	'SCI200',	'SC',	'Research',	'Students will be able to get involved in Research that their Professors are currently doing'                                                  );
insert into Courses values ('BIO100',	NULL,	'BI',	'Intro to Biology',	'Students will learn about the basics of Biology'                                                                                          );
insert into Courses values ('BIO200',	'BIO100',	'BI',	'Biology 2',	'Students will be able to learn some interesting techniques used in Biology'                                                                 );
insert into Courses values ('BIO300',	'BIO200',	'BI',	'Biology 3',	'Students will be able to use those techniques obtained in BIO200 in simulations'                                                            );
             
insert into Courses values ('COMP101',	NULL,	'CS',	'Python Object Oriented',	'Introduction to Object Oriented Programming using Python'                                                                               );
insert into Courses values ('COMP201',	NULL,	'CS',	'GUI design with Python',	'Designing GUIs using Python'                                                                                                        );
insert into Courses values ('COMP301',	'COMP200',	'CS',	'Client-Server Commuication',	'Client Server communication using Python'                                                                                     );
insert into Courses values ('COMP250',	NULL,	'CS',	'Ruby',	'Students will learn about Ruby Programming Language'                                                                                                     );             
             


--creating the Table called Section
create table Section
(
  CourseID text NOT NULL,
  EmployeeID text NOT NULL,
  SemesterID text NOT NULL,
  SectionID text NOT NULL,
  foreign key (CourseID) references Courses(CourseID) on delete cascade,
  foreign key (EmployeeID) references Professors(EmployeeID) on delete cascade,
  foreign key (SemesterID) references Semester(SemesterID) on delete cascade,
	primary key (CourseID, SectionID)
);


--insert values into Section
insert into Section values ( 'SYS111',	  'EID0123',	'F2014',	'A' );
insert into Section values ( 'SYS211',	  'EID0130',	'W2015',	'A' );
insert into Section values ( 'SYS322',	  'EID0111',	'F2015',	'A' );
insert into Section values ('ELEC100',	  'EID0423',	'F2014',	'A' );
                            			                               
insert into Section values ('ELEC200',	'EID0123',	'W2015',	'A'  );
insert into Section values ('ELEC300',	'EID0130',	'F2015',	'A'  );
insert into Section values ( 'ECR100',	'EID0111',	'F2014',	'A'  );
insert into Section values ( 'ECR101',	'EID0423',	'W2015',	'A'  );
                            			                               
insert into Section values ('ECR220',	'EID0123',	'F2015',	'A'  );
insert into Section values ('ECR122',	'EID0130',	'F2014',	'A'  );
insert into Section values ('ECR222',	'EID0111',	'W2015',	'A'  );
insert into Section values ('ECR322',	'EID0423',	'F2015',	'A'  );
                            			                               
insert into Section values ('ENV100',	'EID0123',	'F2014',	'A'  );
insert into Section values ('ENV200',	'EID0130',	'W2015',	'A'  );
insert into Section values ('ENV300',	'EID0111',	'F2015',	'A'  );
insert into Section values ('SOFT100',	'EID0423',	'F2014',	'A');
                            			                               
insert into Section values ('SOFT200',	'EID0123',	'W2015',	'A');
insert into Section values ('SOFT300',	'EID0130',	'F2015',	'A');
insert into Section values ('BUS100',	'EID0141',	'F2014',	'A'  );
insert into Section values ('BUS200',	'EID0668',	'W2015',	'A'  );
                            			                               
insert into Section values ('BUS300',	'EID2256',	'F2015',	'A'  );
insert into Section values ('LAW101',	'EID0145',	'F2014',	'A'  );
insert into Section values ('LAW201',	'EID0678',	'W2015',	'A'  );
insert into Section values ('LAW301',	'EID0094',	'F2015',	'A'  );
                            			                               
insert into Section values ('COMP100',	'EID1234',	'F2014',	'A'  );
insert into Section values ('COMP200',	'EID0135',	'W2015',	'A'  );
insert into Section values ('COMP300',	'EID0116',	'F2015',	'A'  );
insert into Section values ('MATH100',	'EID0429',	'F2014',	'A');
                            			                               
insert into Section values ('MATH200',	'EID1234',	'W2015',	'A');
insert into Section values ('MATH300',	'EID0135',	'F2015',	'A');
insert into Section values ('SCI100',	'EID0116',	'F2014',	'A'  );
insert into Section values ('SCI200',	'EID0429',	'W2015',	'A'  );
                            			                               
insert into Section values ('SCI300',	'EID1234',	'F2015',	'A'  );
insert into Section values ('BIO100',	'EID0135',	'F2014',	'A'  );
insert into Section values ('BIO200',	'EID0116',	'W2015',	'A'  );
insert into Section values ('BIO300',	'EID0429',	'F2015',	'A'  );

insert into Section values ('COMP101',	'EID1234',	'W2015',	'A'  );
insert into Section values ('COMP201',	'EID0135',	'W2015',	'A'  );
insert into Section values ('COMP301',	'EID0116',	'F2015',	'A'  );
insert into Section values ('COMP250',	'EID0429',	'W2015',	'A');
                            			                               
insert into Section values ('SYS111',	'EID0123',	'F2014',	'B'  );
insert into Section values ('SYS211',	'EID0130',	'W2015',	'B'  );
insert into Section values ('SYS322',	'EID0111',	'F2015',	'B'  );
insert into Section values ('ELEC100',	'EID0423',	'F2014',	'B');
                            			                               
insert into Section values ('ELEC200',	'EID0123',	'W2015',	'B');
insert into Section values ('ELEC300',	'EID0130',	'F2015',	'B');
insert into Section values ('ECR100',	'EID0111',	'F2014',	'B'  );
insert into Section values ('ECR101',	'EID0423',	'W2015',	'B'  );
                            			                               
insert into Section values ('ECR220',	'EID0123',	'F2015',	'B'  );
insert into Section values ('ECR122',	'EID0130',	'F2014',	'B'  );
insert into Section values ('ECR222',	'EID0111',	'W2015',	'B'  );
insert into Section values ('ECR322',	'EID0423',	'F2015',	'B'  );
                            			                               
insert into Section values ('ENV100',	'EID0123',	'F2014',	'B'  );
insert into Section values ('ENV200',	'EID0130',	'W2015',	'B'  );
insert into Section values ('ENV300',	'EID0111',	'F2015',	'B'  );
insert into Section values ('SOFT100',	'EID0423',	'F2014',	'B');
                            			                               
insert into Section values ('SOFT200',	'EID0123',	'W2015',	'B');
insert into Section values ('SOFT300',	'EID0130',	'F2015',	'B');
insert into Section values ('BUS100',	'EID0994',	'F2014',	'B'  );
insert into Section values ('BUS200',	'EID0668',	'W2015',	'B'  );
                            			                               
insert into Section values ('BUS300',	'EID2256',	'F2015',	'B'  );
insert into Section values ('LAW101',	'EID0145',	'F2014',	'B'  );
insert into Section values ('LAW201',	'EID0678',	'W2015',	'B'  );
insert into Section values ('LAW301',	'EID2234',	'F2015',	'B'  );
                            			                               
insert into Section values ('COMP100',	'EID1234',	'F2014',	'B'  );
insert into Section values ('COMP200',	'EID0135',	'W2015',	'B'  );
insert into Section values ('COMP300',	'EID0116',	'F2015',	'B'  );
insert into Section values ('MATH100',	'EID0429',	'F2014',	'B');
                            			                               
insert into Section values ('MATH200',	'EID1234',	'W2015',	'B');
insert into Section values ('MATH300',	'EID0135',	'F2015',	'B');
insert into Section values ('SCI100',	'EID0116',	'F2014',	'B'  );
insert into Section values ('SCI200',	'EID0429',	'W2015',	'B'  );
                            			                               
insert into Section values ('SCI300',	'EID1234',	'F2015',	'B'  );
insert into Section values ('BIO100',	'EID0135',	'F2014',	'B'  );
insert into Section values ('BIO200',	'EID0116',	'W2015',	'B'  );
insert into Section values ('BIO300',	'EID0429',	'F2015',	'B'  );

insert into Section values ('COMP101',	'EID1234',	'W2015',	'B'  );
insert into Section values ('COMP201',	'EID0135',	'W2015',	'B'  );
insert into Section values ('COMP301',	'EID0116',	'F2015',	'B'  );
insert into Section values ('COMP250',	'EID0429',	'W2014',	'B');



--creating the Table called Semester
create table Semester
(
	SemesterID NOT NULL primary key,
	Name NOT NULL
);


--insert values into Semester
insert into Semester values('F2014', 'Fall 2014');
insert into Semester values('W2015', 'Winter 2015');
insert into Semester values('F2015', 'Fall 2016');
insert into Semester values('W2016', 'Winter 2016');



--creating the Table called Professors
create table Professors
(
	EmployeeID text NOT NULL primary key,
	DepartmentID text NOT NULL,
	Title text NOT NULL,
	Name text NOT NULL,
	OfficePhoneNum text,
	foreign key (DepartmentID) references Departments(DepartmentID) on delete cascade
);


--insert values into Professors
insert into Professors values('EID0123', 'Eng', 'Prof', 'Michele Gitek', '(920)-234-4222');
insert into Professors values('EID0130', 'Eng', 'Prof', 'Michael Rester', '(920)-234-4242');
insert into Professors values('EID0111', 'Eng', 'Prof', 'Tiffany Kerbej', '(920)-234-6522');
insert into Professors values('EID0423', 'Eng', 'Prof', 'Sam Isic', '(920)-234-4123');
                              				                                                          
insert into Professors values('EID0145', 'Law', 'Prof', 'Robert Sanders', '(920)-234-4234');
insert into Professors values('EID0678', 'Law', 'Prof', 'Bob Michaels', '(920)-234-2344');
insert into Professors values('EID0094', 'Law', 'Prof', 'Jason Richards', '(920)-234-6777');
insert into Professors values('EID2234', 'Law', 'Prof', 'Jennifer McLoving', '(920)-234-9999');
                              				                                                          
insert into Professors values('EID1234', 'Sci', 'Prof', 'Billy Jenikson', '(920)-234-2222');
insert into Professors values('EID0135', 'Sci', 'Prof', 'Sarah Bradly', '(920)-234-2334');
insert into Professors values('EID0116', 'Sci', 'Prof', 'Kim Righterson', '(920)-234-1111');
insert into Professors values('EID0429', 'Sci', 'Prof', 'Bianca Gradeson', '(920)-234-0100');
                              				                                                          
insert into Professors values('EID0141', 'Bus', 'Prof', 'Lorida Simpson', '(920)-234-1221');
insert into Professors values('EID0668', 'Bus', 'Prof', 'Nick Sampson', '(920)-234-3434');
insert into Professors values('EID0994', 'Bus', 'Prof', 'Karen Heidi', '(920)-234-1908');
insert into Professors values('EID2256', 'Bus', 'Prof', 'Jessica McCaren', '(920)-234-0887');



--creating the Table called Research
create table Research
(
  EmployeeID text NOT NULL,
	ResearchID text NOT NULL,
	Name text NOT NULL,
	Summary text,
	StartDate date,
  EndDate date,
  foreign key (EmployeeID) references Professors(EmployeeID) on delete cascade,
  primary key (EmployeeID, ResearchID)
);


--insert values into Research
insert into Research values ('EID0123',	'RID1003',	'Advanced Engineering Topics',	NULL,	date('now', '-3 years'), 	date('now', '-6 months')                        );
insert into Research values ('EID0130',	'RID1003',	'Advanced Engineering Topics',	NULL,	date('now', '-3 years'), 	date('now', '-6 months')                         );
insert into Research values ('EID0111',	'RID1003',	'Advanced Engineering Topics',	NULL,	date('now', '-3 years'), 	date('now', '-6 months')                         );
insert into Research values ('EID0423',	'RID1003',	'Advanced Engineering Topics',	NULL,	date('now', '-3 years'), 	date('now', '-6 months')                           );
                             					                                                                                                                
insert into Research values ('EID0123',	'RID1010',	'BioMedical',	NULL,	NULL,	NULL                                                                    );
insert into Research values ('EID0130',	'RID2010',	'Electical Inductors',	'Researching Inductors',	NULL,	NULL                                        );
insert into Research values ('EID0111',	'RID1323',	'Capacitors',	'Researching ways to create bigger Capacitors',	NULL,	NULL                          );
insert into Research values ('EID0423',	'RID2333',	'Materials',	'Researching Materials used in Civil, and Mechanical Engineering',	date('now'), 	NULL);
                             					                                                                                                                
insert into Research values ('EID1234',	'RID1003',	'Advanced Engineering Topics',	NULL,	date('now', '-3 years'), 	date('now', '-6 months')                      );
insert into Research values ('EID0135',	'RID1003',	'Advanced Engineering Topics',	NULL,	date('now', '-3 years'), 	date('now', '-6 months')                      );
insert into Research values ('EID0116',	'RID1003',	'Advanced Engineering Topics',	NULL,	date('now', '-3 years'), 	date('now', '-6 months')                      );
insert into Research values ('EID0429',	'RID1003',	'Advanced Engineering Topics',	NULL,	date('now', '-3 years'), 	date('now', '-6 months')                      );


--Commit the changes to the database
commit;