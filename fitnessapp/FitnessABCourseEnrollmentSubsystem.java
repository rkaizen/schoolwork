import java.io.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import org.sqlite.SQLiteConfig;

public class FitnessABCourseEnrollmentSubsystem{ //ability to view one member profile also 

   // Sökväg till SQLite-databas. OBS! Ändra sökväg så att den pekar ut din databas
   public static final String DB_URL = "jdbc:sqlite:C:/Users/zeren/SQlite/fitnessabdatabase";  
   // Namnet på den driver som används av java för att prata med SQLite
   public static final String DRIVER = "org.sqlite.JDBC";

   public static void main(String[] args) throws IOException {
     Connection conn = null;
     Statement stmt = null;

      // Kod för att skapa uppkoppling mot SQLite-dabatasen
      try {
         Class.forName(DRIVER);
         SQLiteConfig config = new SQLiteConfig();  
         config.enforceForeignKeys(true); // Denna kodrad ser till att sätta databasen i ett läge där den ger felmeddelande ifall man bryter mot någon främmande-nyckel-regel
         conn = DriverManager.getConnection(DB_URL,config.toProperties());  
      } catch (Exception e) {
         // Om java-progammet inte lyckas koppla upp sig mot databasen (t ex om fel sökväg eller om driver inte hittas) så kommer ett felmeddelande skrivas ut
         System.out.println( e.toString() );
         System.exit(0);
      }
      
      
      // PLATS FÖR DEKLARATIONER OCH KOD //
      
      String s = "";
      String val = "";
      String fName = "";
      String eName = "";
      String date = null;
      String personNummer = null;
      String email = "";
      String phonenumber = null;
      int memberID = 0;
      int antalSiffror = 0;
      int timmar = 0;   
      
      
      
      //mina kai
       int courseID = 0;
       int instructorID = 0;
       String FirstName;
       String LastName;
       String BookingCourse;
       String courseName = "";
       String outOfOrderName;
       String outOfOrderInstructorFirstName;
       String outOfOrderInstructorLastName;
       String newInstructorFirstName = "";
       String newInstructorLastName;
       String instructorFirstName;
       String instructorLastName;
       String FacilityName;
       String CancelAttendence;
       String newFacilityName;
       String RemoveCourse;
             String choice = "";
String choice2;
String choice3;
       
      String continueUpdating = "";
    int outOfOrderCourseScheduleID = 0;
    int newCourseScheduleID = 0;
    int outOfOrderCourseID = 0;
    int outOfOrderRoomID = 0;
    int newRoomID = 0;
    int MemberID = 0;
    int outOfOrderDate = 0;
    int newDate = 0;
    int outOfOrderFacilityID = 0;
    int outOfOrderStartTime = 0;
    int newStartTime = 0;
    int newFacilityID = 0;
      int newCapacity = 0;

      int ConvertContinueUpdating = 0;
      int outOfOrderID = 0; 
       int InstructorID = 0;
       int courseScheduleID = 0;
       int ResToCourseID = 0;
       int RoomID = 0;
        int Date = 0;
         int StartTime = 0; 
         int FacilityID = 0;
          int Capacity = 0;
          
          int ResToMemberID = 0;
          int CourseScheduleID = 0;
           int convertChoice = 0;
          int ResToCourseScheduleID = 0;
          
       char a;
     //  char choice;
//char choice2;
//char choice3;
String newCourseName;
int newCourseID = 0;
//course
int newInstructorID = 0;
int outOfOrderInstructorID = 0;
boolean valid = true;
boolean blankSpaceFound = false;
Scanner console = new Scanner(System.in);
      
         
      while (val != "Q") {
      
      System.out.println("\nChoose One of the Following Options Below:"); // Member Management
      System.out.println();
     
      //MEMBERSHIP SUBSYSTEM
      System.out.println("MEMBERSHIP MANAGEMENT SUBSYSTEM");
      System.out.println();
      System.out.println("1 - Register New Member.");
      System.out.println("2 - Update Existing Member.");
      System.out.println("3 - Remove Existing Member.");
      System.out.println("4 - View Member Profile.");
      
      System.out.println("5 - Create Membership Contract.");
      System.out.println("6 - Cancel Membership Contract.");
      System.out.println("7 - View Membership Contract."); //jag g�r den
   
      System.out.println("8 - Create Membership.");
      System.out.println("9 - Update Membership.");
      System.out.println("10 - Remove Membership.");
      System.out.println("11 - View Membership."); //jag g�r den
      
      
      
      
      //COURSE ENROLMENT SUBSYSTEM
      System.out.println();
      System.out.println("COURSE ENROLLMENT SUSBSYSTEM");
      System.out.println();
      System.out.println("12 - Create New Course.");
      System.out.println("13 - Update Existing Course.");
      System.out.println("14 - Remove Course."); //course
      System.out.println("15 - View Course.");
      
      System.out.println("16 - Register New Instructor.");
      System.out.println("17 - Update Existing Instructor.");
      System.out.println("18 - Remove Instructor.");
      System.out.println("19 - View Instructor.");
      
      System.out.println("20 - Add Course to Course Schedule.");
       System.out.println("21 - Update Course Schedule.");
        System.out.println("22 - Cancel Course Schedule Event.");
         System.out.println("23 - View Course Schedule.");
         
      
      System.out.println("24 - Attend/Enroll Into a Course in the Course Schedule."); //enrolment
      System.out.println("25 - Cancel Attendence/Enrollment to a Course in the Course Schedule."); //enrolment
     System.out.println("26 - View Course Enrollment.");
      
      
      
      System.out.println("27 - Create Room.");
      System.out.println("28 - Update Room."); 
      System.out.println("29 - Remove Room.");
      System.out.println("30 - View Room.");
      
      
      System.out.println("31 - Add Facility."); 
      System.out.println("32 - Update Facility."); 
      System.out.println("33 - Remove Facility."); 
         System.out.println("34 - View Facility."); 
            
               
      System.out.println("35 - Exit."); 
      
     
      
      
      BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
      val = indata.readLine();
      val = val.toUpperCase();
      
      switch (val) {
         case "1": //Register new member
           
           System.out.println("The members first name.");
            fName = indata.readLine();
               
           System.out.println("The members last name.");
            eName = indata.readLine();
           
           System.out.println("The members date of birth 'YYYY-MM-DD'.");
               
             personNummer = indata.readLine();
             personNummer = personNummer.trim();
             antalSiffror = personNummer.length();
               
           if (antalSiffror != 10) {
             System.out.println("Invalid date of birth!");
           break;
           }
               
           String ar = personNummer.substring(0,4);
           String manad = personNummer.substring(5,7);
           String dag = personNummer.substring(8);
               
           int arInt = Integer.parseInt(ar);
           int manadInt = Integer.parseInt(manad);
           int dagInt = Integer.parseInt(dag);
                       
 //Validiera så formatet på år, månad och dag är giltligt.
               
           if (arInt < 1920 || arInt > 2020 || manadInt < 01 || manadInt > 12 || dagInt < 01 || dagInt > 31) {
              System.out.println("Invalid date of birth!.");
           break;
           }  
          
          System.out.println("The members phone number in format 'XXXX-XXXXXX.");
           phonenumber = indata.readLine();
           phonenumber = phonenumber.trim();
           antalSiffror = phonenumber.length();
           
           if (antalSiffror > 11) {
             System.out.println("Invalid phonenumber.");
           break;
           }
            
          System.out.println("The members email address.");
           email = indata.readLine();
            
        try {
         System.out.println("Register new member...");
          stmt = conn.createStatement();
      
         String sql = "INSERT INTO Member(FirstName, LastName, DateOfBirth, PhoneNumber, Email) " +
         "VALUES ('"+ fName +"','"+ eName +"','"+ personNummer +"','"+ phonenumber +"','"+ email +"')";
          stmt.executeUpdate(sql);
         
         System.out.println("New member registered!");
        }
     
        catch(SQLException se) { //Hanterar fel för JDBC
         System.out.println("Member already exists!");
        }
        
        catch(Exception e) { //Hanterar fel för Class.forName
         e.printStackTrace();
        }
      break;
      
      case "2": //Update existing member
           
           System.out.println("Enter your MemberID");
            s = indata.readLine();
            memberID = Integer.parseInt(s);
           
           try {
          stmt = conn.createStatement();
      
         String sql = "SELECT MemberID, FirstName, LastName, DateOfBirth, Phonenumber, Email FROM Member WHERE MemberID= " + memberID +"";
         ResultSet rs = stmt.executeQuery(sql);
          
          while(rs.next()) {
            System.out.println ("MemberID " + rs.getInt("MemberID") + ", namned " +
                               rs.getString("FirstName") + " " + rs.getString("LastName") +
                               ", born the " + rs.getString("DateOfBirth") +
                               ", phone number " + rs.getString("Phonenumber") + ", email " +
                               rs.getString("Email") + ".");                           
          }
          
           }
           catch(SQLException se) { //Hanterar fel för JDBC
         System.out.println("Invalid memberID!");
          }
        
           catch(Exception e) { //Hanterar fel för Class.forName
           e.printStackTrace();
           }
          break;
          
          
          
          
          
       case "3": //Remove existing member
           
           System.out.println("Enter the ID of the member you want to remove.");
            s = indata.readLine();
            memberID = Integer.parseInt(s);
           
           JOptionPane.showConfirmDialog(null, "Are you sure you want to remove Member: " + memberID + "?", "Any changes can not be redone.", JOptionPane.YES_NO_OPTION);
           
           try {
          stmt = conn.createStatement();
      
         String sql = "DELETE FROM Member WHERE MemberID= " + memberID +"";
         ResultSet rs = stmt.executeQuery(sql);
          
          while(rs.next()) {
            System.out.println ("Member " + rs.getInt("MemberID") + ", namned " +
                               rs.getString("FirstName") + " " + rs.getString("LastName") +
                               ", born the " + rs.getString("DateOfBirth") +
                               ", phone number " + rs.getString("Phonenumber") + ", email " +
                               rs.getString("Email") + ", is now removed.");                           
          }
          
           }
           catch(SQLException se) { //Hanterar fel för JDBC
         System.out.println("Invalid memberID!");
          }
        
           catch(Exception e) { //Hanterar fel för Class.forName
           e.printStackTrace();
           }
          break;
          
          
          
          
          
        case "4": //View member profile
           
           System.out.println("Enter the ID for the member you want to view.");
            s = indata.readLine();
            memberID = Integer.parseInt(s);
           
           try {
          stmt = conn.createStatement();
      
         String sql = "SELECT MemberID, FirstName, LastName, DateOfBirth, Phonenumber, Email FROM Member WHERE MemberID= " + memberID +"";
         ResultSet rs = stmt.executeQuery(sql);
         
         //Extract data from result
            System.out.println("MemberID: \t"+ "First Name: \t" + "Last Name: \t" + "Date of Birth: \t" + "Phone Number: \t" + "Email: \t");
          
          while(rs.next()) {
            System.out.print(rs.getInt("MemberID") + "\t" + "\t" + rs.getString("FirstName") + "\t" + "\t" + rs.getString("LastName") + "\t" + "\t" + rs.getString("DateOfBirth") + "\t" + "\t" + rs.getString("Phonenumber") + "\t" + "\t" + rs.getString("Email") +"\n"); 
            
            /*System.out.println ("MemberID " + rs.getInt("MemberID") + ", namned " +
                               rs.getString("FirstName") + " " + rs.getString("LastName") +
                               ", born the " + rs.getString("DateOfBirth") +
                               ", phone number " + rs.getString("Phonenumber") + ", email " +
                               rs.getString("Email") + ".");   */                        
          }
          
           }
           catch(SQLException se) { //Hanterar fel för JDBC
         System.out.println("Invalid memberID!");
          }
        
           catch(Exception e) { //Hanterar fel för Class.forName
           e.printStackTrace();
           }
          break;
          
          case "5": //create membership contract
          break;
          
          case "6": //cancel membership contract
          break;
             
              
        case "7": //view membership contract
        break;
        
        
        case "8"://create membership
        break;
        
        case "9"://update membership
        break;
        
        case "10"://remove membership
        break;
        
        case "11"://view membership
        break;
        
        
         case "12"://create new course
      
         
       do{ 
valid = true;

System.out.println("What's the Name of the Course You'd Like to Add to the Course List?: "); //first we can look at security measures
courseName = indata.readLine();

for (int i = 0; i < courseName.length(); i++){
if (Character.isWhitespace(courseName.charAt(i))){
blankSpaceFound = true;
break;
}else{
blankSpaceFound = false;
}}


if (blankSpaceFound == true){
 System.out.println("Error, You Entered An Input That Contains Blank Space. Please Enter a String (text) Value."); 
  valid = false;
  
 


} else if(courseName.matches("^\\d+(\\.\\d+)?")) { //^\\d+ says that input starts with a digit 0-9, ()? may/or may not occur, \\. allows one period in input. COULD ADD MORE SECURITY LIKE IF WHITESPACE, IF BLANK, IF NEWLINE ETC
  System.out.println("Error, You Entered Integers Only. Please Enter a String (text) Value."); // because user will input new variable name, itll be overwritten (hopefully, if user prompts to fix error
  valid = false;
  
  
 
  
   
 
  //else if value exists in database, false 

  
} else {
  System.out.println("Processing... Complete.");
}} while (!valid);



         
  
  
  
         
         
         
          
			 try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("INSERT INTO Course (Name)" +	"VALUES ('"+courseName+"')");
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }

         break;
         
         
         
         
          
          case "13"://update existing course
          
    
    
    
    
    
    while(true){
 
  
  do{
        
         try{
         valid = true;
         
         
 System.out.println("Update a Course ID? Press (1). Update a Course Name? Press (2). Exit? Press (0). ");
choice = indata.readLine();

  if (choice.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
       
      valid = false;
      }


convertChoice = Integer.parseInt(choice);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
     System.out.println();
      valid = false;
      }
      
      
    


}while(!valid);
 
 if (convertChoice == 1){
 
 do{
 do{
 try{
 valid = true;
 System.out.println("Which Course ID Would You Like to Update?");
 s = indata.readLine();
 

 
 outOfOrderID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);










 do{
 try{
 valid = true;
 System.out.println("Enter the New Course ID Number:");
 s = indata.readLine();
 
  
 newCourseID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);







try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE Course set CourseID = '"+newCourseID+"' where CourseID = '"+outOfOrderID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if 80 isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }





do{
 try{
         valid = true;
System.out.println("Would You Like to Continue Updating Course IDs? Press (1). To Return to the Selection Menu, Press (0).");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);

if (ConvertContinueUpdating == 0){
valid = true;
System.out.println();
System.out.println();
System.out.println();
break;
}






}while (ConvertContinueUpdating == 1); 
}









 
 else if (convertChoice == 2){
 
 
 
 
 
do{
do{
valid = true;


try{
System.out.println("Enter the Course's ID Number of Who's Course Name You'd Like to Update: ");
s = indata.readLine();









courseID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("Error. Enter a Number Please.");
valid = false;

}} while (!valid);








do{
valid = true;
System.out.print("Enter the New Course Name: ");
newCourseName = indata.readLine();

for (int i = 0; i < newCourseName.length(); i++){
if (Character.isWhitespace(newCourseName.charAt(i))){
blankSpaceFound = true;
break;
}else{
blankSpaceFound = false;
}}


if (blankSpaceFound == true){
 System.out.println("Error, You Entered An Input That Contains Blank Space. Please Enter a String (text) Value"); 
  valid = false;


} else if(newCourseName.matches("^\\d+(\\.\\d+)?")) { //^\\d+ says that input starts with a digit 0-9, ()? may/or may not occur, \\. allows one period in input. COULD ADD MORE SECURITY LIKE IF WHITESPACE, IF BLANK, IF NEWLINE ETC
  System.out.println("Error, You Entered Integers Only. Please Enter a String (text) Value"); // because user will input new variable name, itll be overwritten (hopefully, if user prompts to fix error
  valid = false;
  
  
} else {
  System.out.println("Processing... Complete");
}} while (!valid);








 



 try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE Course set Name = '"+newCourseName+"' where CourseID = '"+courseID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if skiing isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }









do{
 try{
         valid = true;
System.out.print("Would You Like to Continue Updating Course Names? Press (1). To Return to the Selection Menu, Press (0). ");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);





}
while (ConvertContinueUpdating == 1); 
}

 
 
 
 
 else if (convertChoice == 0){
break;
} 

 else {
System.out.println("You Entered an Invalid Option Value. Please Try Again.");
}
 
 
 
 
 
 
 
 
 
 
 
 }
    
    


 break; 
 
 
 
 
 
 
 case "14"://remove course
   
 
 

do{
valid = true;


try{
System.out.println("Which Course Would You Like to Remove From the Course List? (Enter Course ID):");
s = indata.readLine();









courseID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("Error. Enter a Number Please.");
valid = false;

}} while (!valid);




       
       
        try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate(" delete from Course where CourseID = '"+courseID+"'");
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }

       

 
 break;
 
 
 case "15"://view course
 
 
  
  
  while(true){
 
  do{
        
         try{
         valid = true;
         
         
 System.out.print("View All Courses? Press (1). View Info About a Particular Course? Press (2). Exit? Press (0). ");
choice = indata.readLine();

  if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }


convertChoice = Integer.parseInt(choice);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);
 
 if (convertChoice == 1){
  try{
						 	  
Statement statement = conn.createStatement(); 
  String	query	= "SELECT * from Course";
  System.out.println("CourseID" + "    " + "Name");  
		  
		ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			     
				System.out.println(rs.getInt(1) + "           " + rs.getString(2)); 

		  }
        
	 }	catch	(SQLException se)	{ 
	 
	 
	 }
    
   do{
   do{
   try{
   valid = true;
    System.out.print("Close View Mode? Press (0).");
  choice = indata.readLine();
  
  if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }
  
convertChoice = Integer.parseInt(choice);
  
 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

  
  
  
  
    if (convertChoice != 0){ //fix:
    
    
    valid = false;
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
   
    
    
    


} else {
valid = true;
break;
}}while (!valid);

 
 }
 
 else if (convertChoice == 2){
 do{
 try{
 valid = true;
 System.out.println("Which Course Would You Like to View? (Enter Course ID):");
 s = indata.readLine();
 
 
 
 courseID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

 
 
 
 
 
  try{
						 	  
Statement statement = conn.createStatement(); 
  String	query	= "SELECT * from Course where CourseID = '"+courseID+"'";
  System.out.println("CourseID" + "   " + "Name");  
		  
		ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			     
				System.out.println(rs.getInt(1) + "          " + rs.getString(2)); 

		  }
        
	 }	catch	(SQLException se)	{ 
	 
	 
	 }
    
   do{
    do{
   try{

   valid = true;
    System.out.print("Close View Mode? Press (0).");
 choice = indata.readLine();
 
 if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }
 
convertChoice = Integer.parseInt(choice);
   
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

   
   
   
     if (convertChoice != 0){ //fix:
    
    
    valid = false;
       System.out.println("You Entered a Non-acceptable Value(s). Try Again.");

    
    
    


} else {
valid = true;
break;
}}while (!valid);

 
 
 
 }



else if (convertChoice == 0){
break;
} 

 else {
System.out.println("You Entered an Invalid Option Value. Please Try Again.");
}

}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 

 break;
 
 
 case "16": //register new instructor
   System.out.println("Enter the New Instructor's First Name: ");
         instructorFirstName = indata.readLine();
         
         
         System.out.println("Enter the New Instructor's Last Name: ");
         instructorLastName = indata.readLine();
         
         
          
			 try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("INSERT INTO Instructor (FirstName, LastName)" +	"VALUES ('"+instructorFirstName+"','"+instructorLastName+"')");
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }


 break;
 
 
 case "17"://update existing instructor
   
   
   
    
    while(true){
 
  
  do{
        
         try{
         valid = true;
         
         
 System.out.println("Update an Instructor's ID Number? Press (1). Update an Instructor's First Name? Press (2). Update an Instructor's Last Name? Press (3). " +
                     " \nExit? Press (0). ");
choice = indata.readLine();

  if (choice.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
       
      valid = false;
      }


convertChoice = Integer.parseInt(choice);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
     System.out.println();
      valid = false;
      }
      
      
    


}while(!valid);




 
 if (convertChoice == 1){
 
 do{
 do{
 try{
 valid = true;
 System.out.println("Which Instructor ID Number Would You Like to Update? (Enter Instructor ID):");
 s = indata.readLine();
 

 
 outOfOrderInstructorID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);










 do{
 try{
 valid = true;
 System.out.println("Enter the New Instructor ID Number:");
 s = indata.readLine();
 
  
 newInstructorID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);







try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE Instructor set InstructorID = '"+newInstructorID+"' where InstructorID = '"+outOfOrderInstructorID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if 80 isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }





do{
 try{
         valid = true;
System.out.println("Would You Like to Continue Updating Instructor IDs? Press (1). To Return to the Selection Menu, Press (0).");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);

if (ConvertContinueUpdating == 0){
valid = true;
System.out.println();
System.out.println();
System.out.println();
break;
}






}while (ConvertContinueUpdating == 1); 
}









 
 else if (convertChoice == 2){
 
 do{
do{
valid = true;


try{
System.out.println("Enter the Instructor ID Number of Who's First Name You'd Like to Update:");
s = indata.readLine();









InstructorID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("Error. Enter a Number Please.");
valid = false;

}} while (!valid);


 
 
 
 
 
 
 do{
valid = true;
System.out.print("Enter the Instructor's New First Name: ");
newInstructorFirstName = indata.readLine();

for (int i = 0; i < newInstructorFirstName.length(); i++){
if (Character.isWhitespace(newInstructorFirstName.charAt(i))){
blankSpaceFound = true;
break;
}else{
blankSpaceFound = false;
}}


if (blankSpaceFound == true){
 System.out.println("Error, You Entered An Input That Contains Blank Space. Please Enter a String (text) Value"); 
  valid = false;

} else if(newInstructorFirstName.matches("^\\d+(\\.\\d+)?")) { //^\\d+ says that input starts with a digit 0-9, ()? may/or may not occur, \\. allows one period in input. COULD ADD MORE SECURITY LIKE IF WHITESPACE, IF BLANK, IF NEWLINE ETC
  System.out.println("Error, You Entered Integers Only. Please Enter a String (text) Value"); // because user will input new variable name, itll be overwritten (hopefully, if user prompts to fix error
  valid = false;
  

  
} else {
  System.out.println("Processing... Complete");
}} while (!valid);

 
 
 
 
 
 
 
 
 
 
  try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE Instructor set FirstName = '"+newInstructorFirstName+"' where InstructorID = '"+InstructorID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if skiing isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }


 
 
 
do{
 try{
         valid = true;
System.out.println("Would You Like to Continue Updating Instructors' First Names? Press (1). To Return to the Selection Menu, Press (0).");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);

if (ConvertContinueUpdating == 0){
valid = true;
System.out.println();
System.out.println();
System.out.println();
break;
}



}while (ConvertContinueUpdating == 1); 
}
 
 
 
 
 
 
 
 
 
 else if (convertChoice == 3){
 
 
 do{
do{
valid = true;


try{
System.out.println("Enter the Instructor ID of Who's Last Name You'd Like to Update:");
s = indata.readLine();









InstructorID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("Error. Enter a Number Please.");
valid = false;

}} while (!valid);


 
 
 
 
 
 
 do{
valid = true;
System.out.print("Enter the Instructor's New Last Name: ");
newInstructorLastName = indata.readLine();

for (int i = 0; i < newInstructorLastName.length(); i++){
if (Character.isWhitespace(newInstructorLastName.charAt(i))){
blankSpaceFound = true;
break;
}else{
blankSpaceFound = false;
}}


if (blankSpaceFound == true){
 System.out.println("Error, You Entered An Input That Contains Blank Space. Please Enter a String (text) Value"); 
  valid = false;

} else if(newInstructorLastName.matches("^\\d+(\\.\\d+)?")) { //^\\d+ says that input starts with a digit 0-9, ()? may/or may not occur, \\. allows one period in input. COULD ADD MORE SECURITY LIKE IF WHITESPACE, IF BLANK, IF NEWLINE ETC
  System.out.println("Error, You Entered Integers Only. Please Enter a String (text) Value"); // because user will input new variable name, itll be overwritten (hopefully, if user prompts to fix error
  valid = false;
  

  
} else {
  System.out.println("Processing... Complete");
}} while (!valid);

 
 
 
 
 
 
 
 
 
 
  try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE Instructor set LastName = '"+newInstructorLastName+"' where InstructorID = '"+InstructorID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if skiing isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }


 
 
 
do{
 try{
         valid = true;
System.out.println("Would You Like to Continue Updating Instructors' Last Names? Press (1). To Return to the Selection Menu, Press (0).");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);

if (ConvertContinueUpdating == 0){
valid = true;
System.out.println();
System.out.println();
System.out.println();
break;
}



}while (ConvertContinueUpdating == 1); 
}

 
 
 
 
 
 
 else if (convertChoice == 0){
break;
} 

 else {
System.out.println("You Entered an Invalid Option Value. Please Try Again.");
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 








 















      
      
    











 
 
 
 
 
 
 
 
 
 }          
  

 break;
 
 
 case "18"://remove instructor
 
  do{
        
         try{
         valid = true;
           System.out.println("Which Instructor Would You Like to Remove from The Instructor List? (Enter Instructor ID): ");          //int courseScheduleID, int InstructorID, int CourseID, int RoomID, int Date, int StartTime 
      s = indata.readLine();
      InstructorID = Integer.parseInt(s); //perfect security measure
      } catch (Exception e){
    
    System.out.println("You entered nonacceptable values. try again");
      valid = false;
      }
      
      }while (!valid);

          
          
              
       
       

       
       
       
        try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate(" delete from Instructor where InstructorID = '"+InstructorID+"'");
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }

       
          
          
          
          
          

 break;
 
 
 case "19"://view instructors
 
  
  while(true){
 
  do{
        
         try{
         valid = true;
         
         
 System.out.print("View All Instructors? Press (1). View Info About a Particular Instructor? Press (2). Exit? Press (0). ");
choice = indata.readLine();

  if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }


convertChoice = Integer.parseInt(choice);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);
 
 if (convertChoice == 1){
  try{
						 	  
Statement statement = conn.createStatement(); 
  String	query	= "SELECT * from Instructor";
  System.out.println("InstructorID" + "    " + "FirstName" + "     " + "LastName");  
		  
		ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			   
				System.out.println(rs.getInt(1) + "               " + rs.getString(2) + "          " + rs.getString(3)); 

		  }
        
	 }	catch	(SQLException se)	{ 
	 
	 
	 }
    
   do{
   do{
   try{
   valid = true;
    System.out.print("Close View Mode? Press (0).");
  choice = indata.readLine();
  
  if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }
  
convertChoice = Integer.parseInt(choice);
  
 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

  
  
  
  
    if (convertChoice != 0){ //fix:
    
    
    valid = false;
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
   
    
    
    


} else {
valid = true;
break;
}}while (!valid);

 
 }
 
 else if (convertChoice == 2){
 do{
 try{
 valid = true;
 System.out.println("Which Particular Instructor Would You Like to View? (Enter Instructor ID):");
 s = indata.readLine();
 
 
 
 InstructorID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

 
 
 
 
 
  try{
						 	  
Statement statement = conn.createStatement(); 
  String	query	= "SELECT * from Instructor where InstructorID = '"+InstructorID+"'";
  System.out.println("InstructorID" + "   " + "FirstName" + "    " + "LastName");  
		  
		ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			      
				System.out.println(rs.getInt(1) + "              " + rs.getString(2) + "         " + rs.getString(3)); 

		  }
        
	 }	catch	(SQLException se)	{ 
	 
	 
	 }
    
   do{
    do{
   try{

   valid = true;
    System.out.print("Close View Mode? Press (0).");
 choice = indata.readLine();
 
 if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }
 
convertChoice = Integer.parseInt(choice);
   
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

   
   
   
     if (convertChoice != 0){ //fix:
    
    
    valid = false;
       System.out.println("You Entered a Non-acceptable Value(s). Try Again.");

    
    
    


} else {
valid = true;
break;
}}while (!valid);

 
 
 
 }



else if (convertChoice == 0){
break;
} 

 else {
System.out.println("You Entered an Invalid Option Value. Please Try Again.");
}

}

 
 
 
 
 break;
 
 
 case "20"://add course to course schedule
 
     
         
         do{
        
         try{
         valid = true;
           System.out.println("Which Instructor Will Be Instructing the Course? (Enter Instructor ID): ");          //int courseScheduleID, int InstructorID, int CourseID, int RoomID, int Date, int StartTime 
      s = indata.readLine();
      instructorID = Integer.parseInt(s); //perfect security measure
      } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);
         
         
         
         
         
         
         
         do{
        
         try{
         valid = true;
           System.out.println("Which Course Will The Instructor Instruct? (Enter Course ID): ");          //int courseScheduleID, int InstructorID, int CourseID, int RoomID, int Date, int StartTime 
      s = indata.readLine();
      courseID = Integer.parseInt(s); //perfect security measure
      } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

         
         
         
         
         
         do{
        
         try{
         valid = true;
           System.out.println("Which Room Will the Course Take Place In? (Enter Room ID): ");          //int courseScheduleID, int InstructorID, int CourseID, int RoomID, int Date, int StartTime 
      s = indata.readLine();
      RoomID = Integer.parseInt(s); //perfect security measure
      } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

         
         
         
         
         
         do{
        
         try{
         valid = true;
           System.out.println("Enter the Date For When The Course Will Take Place (Enter Date Format (YYYYMMDD)): ");          //int courseScheduleID, int InstructorID, int CourseID, int RoomID, int Date, int StartTime 
      s = indata.readLine();
      Date = Integer.parseInt(s); //perfect security measure
      } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

         
         
         
         do{
        
         try{
         valid = true;
           System.out.println("Enter the Time For When The Course Will Begin (Enter Start Time Format (HHMM)): ");          //int courseScheduleID, int InstructorID, int CourseID, int RoomID, int Date, int StartTime 
      s = indata.readLine();
      StartTime = Integer.parseInt(s); //perfect security measure
      } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

         
         
         
          
			 try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("INSERT INTO CourseSchedule (InstructorID, CourseID, RoomID, Date, StartTime)" +	"VALUES ('"+instructorID+"','"+courseID+"','"+RoomID+"','"+Date+"','"+StartTime+"')");
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }

 break;
 
 
 case "21"://update course schedule
 
 
    
    
    while(true){
 
  
  do{
        
         try{
         valid = true;
         
         System.out.println();
         System.out.println();
 System.out.println("Update a Course Schedule ID? Press (1). Update a Course Schedule's Instructor ID? Press (2). Update a Course Schedule's Course ID? Press (3)." +
                  " \nUpdate a Course Schedule's Room ID? Press (4). Update a Course Schedule's Date? Press (5). Update a Course Schedule's Start Time? Press (6)." +
                  " \nExit? Press (0). ");
choice = indata.readLine();

  if (choice.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
       
      valid = false;
      }


convertChoice = Integer.parseInt(choice);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
    System.out.println();
      valid = false;
      }
      
      
    


}while(!valid);
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 if (convertChoice == 1){
 
 do{
 do{
 try{
 valid = true;
 System.out.println("Which Course Schedule ID Would You Like to Update? (Enter Course Shcedule ID):");
 s = indata.readLine();
 

 
 outOfOrderCourseScheduleID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);










 do{
 try{
 valid = true;
 System.out.println("Enter the New Course Schedule ID Number:");
 s = indata.readLine();
 
  
 newCourseScheduleID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);







try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE CourseSchedule set CourseScheduleID = '"+newCourseScheduleID+"' where CourseScheduleID = '"+outOfOrderCourseScheduleID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if 80 isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }





do{
 try{
         valid = true;
System.out.println("Would You Like to Continue Updating Course Schedule IDs? Press (1). To Return to the Selection Menu, Press (0).");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);

if (ConvertContinueUpdating == 0){
valid = true;
System.out.println();
System.out.println();
System.out.println();
break;
}






}while (ConvertContinueUpdating == 1); 
}












 
 else if (convertChoice == 2){
 
 
 
 
 
do{
do{
valid = true;


try{
System.out.println("Enter the Course Schedule ID of Who's Instructor ID You'd Like to Update: ");
 s = indata.readLine();
 

 
 outOfOrderCourseScheduleID = Integer.parseInt(s);













} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);









do{
valid = true;


try{
System.out.println("Enter the New Instructor ID Number: ");
s = indata.readLine();









newInstructorID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);





 



 try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE CourseSchedule set InstructorID = '"+newInstructorID+"' where CourseScheduleID = '"+ outOfOrderCourseScheduleID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if skiing isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }









do{
 try{
         valid = true;
System.out.print("Would You Like to Continue Updating Instructor IDs? Press (1). To Return to the Selection Menu, Press (0). ");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);





}
while (ConvertContinueUpdating == 1); 
}

 
 
 else if (convertChoice == 3){
 
 
  
do{
do{
valid = true;


try{
System.out.println("Enter the Course Schedule ID of Who's Course ID You'd Like to Update: ");
s = indata.readLine();









outOfOrderCourseScheduleID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);









do{
valid = true;


try{
System.out.println("Enter the New Course ID Number: ");
s = indata.readLine();









newCourseID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);





 



 try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE CourseSchedule set CourseID = '"+newCourseID+"' where CourseScheduleID = '"+outOfOrderCourseScheduleID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if skiing isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }









do{
 try{
         valid = true;
System.out.print("Would You Like to Continue Updating Course IDs? Press (1). To Return to the Selection Menu, Press (0).");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);





}
while (ConvertContinueUpdating == 1); 
}
 
 
 
 
 
 
 
 
 else if (convertChoice == 4){
 
 
  
do{
do{
valid = true;


try{
System.out.println("Enter the Course Schedule ID of Who's Room ID You'd Like to Update: ");
s = indata.readLine();









outOfOrderCourseScheduleID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);









do{ 
valid = true;


try{
System.out.println("Enter the New Room ID Number: ");
s = indata.readLine();









newRoomID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);





 



 try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE CourseSchedule set RoomID = '"+newRoomID+"' where CourseScheduleID = '"+outOfOrderCourseScheduleID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if skiing isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }









do{
 try{
         valid = true;
System.out.print("Would You Like to Continue Updating Room IDs? Press (1). To Return to the Selection Menu, Press (0). ");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);





}
while (ConvertContinueUpdating == 1); 
}
 
 
 
 
 
 
 
 
 else if (convertChoice == 5){
 
 
 
   
do{
do{
valid = true;


try{
System.out.println("Enter the Course Schedule ID of Who's Date You'd Like to Update: ");
s = indata.readLine();









outOfOrderCourseScheduleID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);









do{
valid = true;


try{
System.out.println("Enter the New Date (YYYYMMDD): ");
s = indata.readLine();









newDate = Integer.parseInt(s);



} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);





 



 try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE CourseSchedule set Date = '"+newDate+"' where CourseScheduleID = '"+outOfOrderCourseScheduleID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if skiing isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }









do{
 try{
         valid = true;
System.out.print("Would You Like to Continue Updating the Date of Certain Courses in the Course Schedule? Press (1). "
               + "\nTo Return to the Selection Menu, Press (0). ");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);





}
while (ConvertContinueUpdating == 1); 
}
 
 
 
 
 
 
 
 
 
 
else if (convertChoice == 6){

  
do{
do{
valid = true;


try{
System.out.println("Enter the Course Schedule ID of Who's Start Time You'd Like to Update: ");
s = indata.readLine();









outOfOrderCourseScheduleID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);









do{
valid = true;


try{
System.out.println("Enter the New Start Time (HHMM): ");
s = indata.readLine();









newStartTime = Integer.parseInt(s);



} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);





 



 try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE CourseSchedule set StartTime = '"+newStartTime+"' where CourseScheduleID = '"+outOfOrderCourseScheduleID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if skiing isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }









do{
 try{
         valid = true;
System.out.print("Would You Like to Continue Updating Courses Start Times in the Course Schedule? Press (1). "
               +"\nTo Return to the Selection Menu, Press (0). ");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);





}
while (ConvertContinueUpdating == 1); 
} 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 else if (convertChoice == 0){
break;
} 

 else {
System.out.println("You Entered an Invalid Option Value. Please Try Again.");
}
 
 
 
 
 
 }
    
    

 
 
 break;
 
 
 case "22"://cancel course schedule event
   
               do{
        
         try{
         valid = true;
           System.out.println("Which Course in The Course Schedule Would You Like to Cancel (Remove)? (Enter CourseSchedule ID): ");          //int courseScheduleID, int InstructorID, int CourseID, int RoomID, int Date, int StartTime 
      s = indata.readLine();
      CourseScheduleID = Integer.parseInt(s); //perfect security measure
      } catch (Exception e){
    
    System.out.println("You entered nonacceptable values. try again");
      valid = false;
      }
      
      }while (!valid);

       
       
       

       
       
       
        try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate(" delete from CourseSchedule where CourseScheduleID = '"+CourseScheduleID+"'");
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }

          

 break;
 
 
 case "23"://view course schedule
 
   while(true){
 
  do{
        
         try{
         valid = true;
         
         
 System.out.print("View All Courses in the Course Schedule? Press (1). View Info About a Particular Course in the Course Schedule? Press (2). " +
                  " \nExit? Press (0). ");
choice = indata.readLine();

  if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }


convertChoice = Integer.parseInt(choice);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);
 
 if (convertChoice == 1){
  try{
						 	  
Statement statement = conn.createStatement(); 
  String	query	= "SELECT * from CourseSchedule";
  System.out.println("CourseScheduleID" + "       " + "InstructorID" + "     " + "CourseID" + "      " + "RoomID" + "       " + "Date" + "           " + "StartTime");  
		  
		ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			   
				System.out.println(rs.getInt(1) + "                      " + rs.getInt(2) + "                " + rs.getInt(3) + "             " + rs.getInt(4) + "            " + rs.getInt(5) + "       " + rs.getInt(6)); 

		  }
        
	 }	catch	(SQLException se)	{ 
	 
	 
	 }
    
   do{
   do{
   try{
   valid = true;
    System.out.print("Close View Mode? Press (0).");
  choice = indata.readLine();
  
  if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }
  
convertChoice = Integer.parseInt(choice);
  
 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

  
  
  
  
    if (convertChoice != 0){ //fix:
    
    
    valid = false;
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
   
    
    
    


} else {
valid = true;
break;
}}while (!valid);

 
 }
 
 else if (convertChoice == 2){
 do{
 try{
 valid = true;
 System.out.println("Which Particular Course in the Course Schedule Would You Like to View? (Enter Course Schedule ID):");
 s = indata.readLine();
 
 
 
 CourseScheduleID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

 
 
 
 
 
  try{
						 	  
Statement statement = conn.createStatement(); 
  String	query	= "SELECT * from CourseSchedule where CourseScheduleID = '"+CourseScheduleID+"'";
  System.out.println("CourseScheduleID" + "       " + "InstructorID" + "     " + "CourseID" + "      " + "RoomID" + "       " + "Date" + "           " + "StartTime");  
		  
		ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			      
				System.out.println(rs.getInt(1) + "                      " + rs.getInt(2) + "                " + rs.getInt(3) + "             " + rs.getInt(4) + "            " + rs.getInt(5) + "       " + rs.getInt(6)); 

		  }
        
	 }	catch	(SQLException se)	{ 
	 
	 
	 }
    
   do{
    do{
   try{

   valid = true;
    System.out.print("Close View Mode? Press (0).");
 choice = indata.readLine();
 
 if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }
 
convertChoice = Integer.parseInt(choice);
   
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

   
   
   
     if (convertChoice != 0){ //fix:
    
    
    valid = false;
       System.out.println("You Entered a Non-acceptable Value(s). Try Again.");

    
    
    


} else {
valid = true;
break;
}}while (!valid);

 
 
 
 }



else if (convertChoice == 0){
break;
} 

 else {
System.out.println("You Entered an Invalid Option Value. Please Try Again.");
}

}


  
  
  
  
  
 break;
 
 case "24"://attend/enreoll into a course in the course schedule //foreign constraint fel

     
     do{
valid = true;
System.out.print("Enter Your First Name: ");
FirstName = indata.readLine();

for (int i = 0; i < FirstName.length(); i++){
if (Character.isWhitespace(FirstName.charAt(i))){
blankSpaceFound = true;
break;
}else{
blankSpaceFound = false;
}}


if (blankSpaceFound == true){
 System.out.println("Error, You Entered An Input That Contains Blank Space. Please Enter a String (text) Value"); 
  valid = false;

} else if(FirstName.matches("^\\d+(\\.\\d+)?")) { //^\\d+ says that input starts with a digit 0-9, ()? may/or may not occur, \\. allows one period in input. COULD ADD MORE SECURITY LIKE IF WHITESPACE, IF BLANK, IF NEWLINE ETC
  System.out.println("Error, You Entered Integers Only. Please Enter a String (text) Value"); // because user will input new variable name, itll be overwritten (hopefully, if user prompts to fix error
  valid = false;
  
  
  
} else {
  System.out.println("Processing... Complete");
}} while (!valid);



do{
valid = true;
System.out.print("Enter Your Last Name: ");
LastName = indata.readLine();

for (int i = 0; i < LastName.length(); i++){
if (Character.isWhitespace(LastName.charAt(i))){
blankSpaceFound = true;
break;
}else{
blankSpaceFound = false;
}}


if (blankSpaceFound == true){
 System.out.println("Error, You Entered An Input That Contains Blank Space. Please Enter a String (text) Value"); 
  valid = false;

} else if(LastName.matches("^\\d+(\\.\\d+)?")) { //^\\d+ says that input starts with a digit 0-9, ()? may/or may not occur, \\. allows one period in input. COULD ADD MORE SECURITY LIKE IF WHITESPACE, IF BLANK, IF NEWLINE ETC
  System.out.println("Error, You Entered Integers Only. Please Enter a String (text) Value"); // because user will input new variable name, itll be overwritten (hopefully, if user prompts to fix error
  valid = false;
  
   
} else {
  System.out.println("Processing... Complete");
}} while (!valid);
     
     
      
 
 do{ 
valid = true;
System.out.print("Which Course Would You Like to Enroll Into? (Enter Course Name): ");
BookingCourse = indata.readLine();

for (int i = 0; i < BookingCourse.length(); i++){
if (Character.isWhitespace(BookingCourse.charAt(i))){
blankSpaceFound = true;
break;
}else{
blankSpaceFound = false;
}}


if (blankSpaceFound == true){
 System.out.println("Error, You Entered An Input That Contains Blank Space. Please Enter a String (text) Value"); 
  valid = false;

} else if(BookingCourse.matches("^\\d+(\\.\\d+)?")) { //^\\d+ says that input starts with a digit 0-9, ()? may/or may not occur, \\. allows one period in input. COULD ADD MORE SECURITY LIKE IF WHITESPACE, IF BLANK, IF NEWLINE ETC
  System.out.println("Error, You Entered Integers Only. Please Enter a String (text) Value"); // because user will input new variable name, itll be overwritten (hopefully, if user prompts to fix error
  valid = false;
  
  
  
} else {
  System.out.println("Processing... Complete");
}} while (!valid);
         
 
 
 
 
 
 
 
 
 
 	 try{
          
		  
		  
		  Statement statement = conn.createStatement(); 
  String	query	= "select MemberID from Member where FirstName = '"+FirstName+"' and LastName = '"+LastName+"'";
        
        ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			     
				   ResToMemberID = rs.getInt(1); 

		  }
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }
 
 
 
 
 
 
 
 	 try{
          
		  
		  
		  Statement statement = conn.createStatement(); 
  String	query	= "select CourseID from Course where Name = '"+BookingCourse+"'";
        
        ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			     
				   ResToCourseID = rs.getInt(1); 

		  }
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }
 
 
 
 
 
  try{
          
		  
		  
		  Statement statement = conn.createStatement(); 
  String	query	= "select CourseScheduleID from CourseSchedule where CourseID = '"+ResToCourseID+"'";
        
        ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			     
				   ResToCourseScheduleID = rs.getInt(1); 

		  }
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }
 

 
 
 
  try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate(" insert into CourseEnrolment (CourseScheduleID, MemberID) values ('"+ResToCourseScheduleID+"','"+ResToMemberID+"')");
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }

 
 
 
 break;
 
 
 case "25"://cancel attendence/enrollment to a booked course
  do{
valid = true;
System.out.print("Enter Your First Name: ");
FirstName = indata.readLine();

for (int i = 0; i < FirstName.length(); i++){
if (Character.isWhitespace(FirstName.charAt(i))){
blankSpaceFound = true;
break;
}else{
blankSpaceFound = false;
}}


if (blankSpaceFound == true){
 System.out.println("Error, You Entered An Input That Contains Blank Space. Please Enter a String (text) Value"); 
  valid = false;

} else if(FirstName.matches("^\\d+(\\.\\d+)?")) { //^\\d+ says that input starts with a digit 0-9, ()? may/or may not occur, \\. allows one period in input. COULD ADD MORE SECURITY LIKE IF WHITESPACE, IF BLANK, IF NEWLINE ETC
  System.out.println("Error, You Entered Integers Only. Please Enter a String (text) Value"); // because user will input new variable name, itll be overwritten (hopefully, if user prompts to fix error
  valid = false;
  
 
  
} else {
  System.out.println("Processing... Complete");
}} while (!valid);





do{
valid = true;
System.out.print("Enter Your Last Name: ");
LastName = indata.readLine();

for (int i = 0; i < LastName.length(); i++){
if (Character.isWhitespace(LastName.charAt(i))){
blankSpaceFound = true;
break;
}else{
blankSpaceFound = false;
}}


if (blankSpaceFound == true){
 System.out.println("Error, You Entered An Input That Contains Blank Space. Please Enter a String (text) Value"); 
  valid = false;

} else if(LastName.matches("^\\d+(\\.\\d+)?")) { //^\\d+ says that input starts with a digit 0-9, ()? may/or may not occur, \\. allows one period in input. COULD ADD MORE SECURITY LIKE IF WHITESPACE, IF BLANK, IF NEWLINE ETC
  System.out.println("Error, You Entered Integers Only. Please Enter a String (text) Value"); // because user will input new variable name, itll be overwritten (hopefully, if user prompts to fix error
  valid = false;
  
  
  
} else {
  System.out.println("Processing... Complete");
}} while (!valid);
     
  
  
      
 
 do{ 
valid = true;
System.out.print("Which Course Would You Like to Cancel Your Attendence to? (Enter Course Name): ");
CancelAttendence = indata.readLine();

for (int i = 0; i < CancelAttendence.length(); i++){
if (Character.isWhitespace(CancelAttendence.charAt(i))){
blankSpaceFound = true;
break;
}else{
blankSpaceFound = false;
}}


if (blankSpaceFound == true){
 System.out.println("Error, You Entered An Input That Contains Blank Space. Please Enter a String (text) Value"); 
  valid = false;

} else if(CancelAttendence.matches("^\\d+(\\.\\d+)?")) { //^\\d+ says that input starts with a digit 0-9, ()? may/or may not occur, \\. allows one period in input. COULD ADD MORE SECURITY LIKE IF WHITESPACE, IF BLANK, IF NEWLINE ETC
  System.out.println("Error, You Entered Integers Only. Please Enter a String (text) Value"); // because user will input new variable name, itll be overwritten (hopefully, if user prompts to fix error
  valid = false;
  

  
} else {
  System.out.println("Processing... Complete");
}} while (!valid);
         

    
    
    
    
    
    
 	 try{
          
		  
		  
		  Statement statement = conn.createStatement(); 
  String	query	= "select MemberID from Member where FirstName = '"+FirstName+"' and LastName = '"+LastName+"'";
        
        ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			     
				   ResToMemberID = rs.getInt(1); 

		  }
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }
 
 
 
 
 
 
 
 	 try{
          
		  
		  
		  Statement statement = conn.createStatement(); 
  String	query	= "select CourseID from Course where Name = '"+CancelAttendence+"'";
        
        ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			     
				   ResToCourseID = rs.getInt(1); 

		  }
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }
 
 
 
 
 
 
   try{
          
		  
		  
		  Statement statement = conn.createStatement(); 
  String	query	= "select CourseScheduleID from CourseSchedule where CourseID = '"+ResToCourseID+"'";
        
        ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			     
				   ResToCourseScheduleID = rs.getInt(1); 

		  }
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }
 
 
 
 
  try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate(" delete from CourseEnrolment where CourseScheduleID = '"+ResToCourseScheduleID+"' and MemberID = '"+ResToMemberID+"'");
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }

 
 
    
    
    
    
    
    

 break;
 
 case "26"://view course enrollment


 while(true){
 
  do{
        
         try{
         valid = true;
         
         
 System.out.print("View All Course Enrollments? Press (1). View Info About a Particular Course Enrollment? Press (2). " +
                  " \nExit? Press (0). ");
choice = indata.readLine();

  if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }


convertChoice = Integer.parseInt(choice);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);
 
 if (convertChoice == 1){
  try{
						 	  
Statement statement = conn.createStatement(); 
  String	query	= "SELECT * from CourseEnrolment";
  System.out.println("CourseScheduleID" + "       " + "MemberID");  
		  
		ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			   
				System.out.println(rs.getInt(1) + "                      " + rs.getInt(2)); 

		  }
        
	 }	catch	(SQLException se)	{ 
	 
	 
	 }
    
   do{
   do{
   try{
   valid = true;
    System.out.print("Close View Mode? Press (0).");
  choice = indata.readLine();
  
  if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }
  
convertChoice = Integer.parseInt(choice);
  
 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

  
  
  
  
    if (convertChoice != 0){ //fix:
    
    
    valid = false;
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
   
    
    
    


} else {
valid = true;
break;
}}while (!valid);

 
 }
 
 else if (convertChoice == 2){
 do{
 try{
 valid = true;
 System.out.println("Which Particular Member Would You Like to Search For In the Course Enrollment List? (Enter Member ID):");
 s = indata.readLine();
 
 
 
 MemberID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

 
 
 
 
 
  try{
						 	  
Statement statement = conn.createStatement(); 
  String	query	= "SELECT * from CourseEnrolment where MemberID = '"+MemberID+"'";
  System.out.println("CourseScheduleID" + "       " + "MemberID" );  
		  
		ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			      
				System.out.println(rs.getInt(1) + "                      " + rs.getInt(2)); 

		  }
        
	 }	catch	(SQLException se)	{ 
	 
	 
	 }
    
   do{
    do{
   try{

   valid = true;
    System.out.print("Close View Mode? Press (0).");
 choice = indata.readLine();
 
 if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }
 
convertChoice = Integer.parseInt(choice);
   
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

   
   
   
     if (convertChoice != 0){ //fix:
    
    
    valid = false;
       System.out.println("You Entered a Non-acceptable Value(s). Try Again.");

    
    
    


} else {
valid = true;
break;
}}while (!valid);

 
 
 
 }



else if (convertChoice == 0){
break;
} 

 else {
System.out.println("You Entered an Invalid Option Value. Please Try Again.");
}

}








 break;
 
 
 case "27":// create room


      do{
        
         try{
         valid = true;
           System.out.println("Which Facility is the Room Located in? (Enter Facility ID): ");          //int int RoomID, int FacilityID, int Capacity
      s = indata.readLine();
      FacilityID = Integer.parseInt(s); //perfect security measure
      } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);
      
      
      
      
      
      do{
        
         try{
         valid = true;
           System.out.println("Enter the Room's Capacity (People): ");          //int int RoomID, int FacilityID, int Capacity
      s = indata.readLine();
      Capacity = Integer.parseInt(s); //perfect security measure
      } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);
      
      




try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("INSERT INTO Room (FacilityID, Capacity)" +	"VALUES ('"+FacilityID+"','"+Capacity+"')");
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }
 break;
 
 case "28"://update room



  
    while(true){
 
  
  do{
        
         try{
         valid = true;
         
         
 System.out.println("Update a Room ID? Press (1). Update a Room's Facility ID? Press (2). Update the Capacity of a Room? Press (3)." +
                 
                  " \nExit? Press (0). ");
choice = indata.readLine();

  if (choice.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
       
      valid = false;
      }


convertChoice = Integer.parseInt(choice);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
    System.out.println();
      valid = false;
      }
      
      
    


}while(!valid);
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 if (convertChoice == 1){
 
 do{
 do{
 try{
 valid = true;
 System.out.println("Which Room ID Would You Like to Update? (Enter Room ID):");
 s = indata.readLine();
 

 
 outOfOrderRoomID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);










 do{
 try{
 valid = true;
 System.out.println("Enter the New Room ID Number:");
 s = indata.readLine();
 
  
 newRoomID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);







try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE Room set RoomID = '"+newRoomID+"' where RoomID = '"+outOfOrderRoomID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if 80 isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }





do{
 try{
         valid = true;
System.out.println("Would You Like to Continue Updating Room IDs? Press (1). To Return to the Selection Menu, Press (0).");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);

if (ConvertContinueUpdating == 0){
valid = true;
System.out.println();
System.out.println();
System.out.println();
break;
}






}while (ConvertContinueUpdating == 1); 
}












 
 else if (convertChoice == 2){
 
 
 
 
 
do{
do{
valid = true;


try{
System.out.println("Enter the Room ID of Who's Facility ID You'd Like to Update: ");
 s = indata.readLine();
 

 
 outOfOrderRoomID = Integer.parseInt(s);













} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);









do{
valid = true;


try{
System.out.println("Enter the New Facility ID Number: ");
s = indata.readLine();









newFacilityID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);





 



 try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE Room set FacilityID = '"+newFacilityID+"' where RoomID = '"+ outOfOrderRoomID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if skiing isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }









do{
 try{
         valid = true;
System.out.print("Would You Like to Continue Updating Rooms' Facility IDs? Press (1). To Return to the Selection Menu, Press (0). ");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);





}
while (ConvertContinueUpdating == 1); 
}

 
 
 else if (convertChoice == 3){
 
 
  
do{
do{
valid = true;


try{
System.out.println("Enter the Room ID of Who's Room Capacity You'd Like to Update: ");
s = indata.readLine();









outOfOrderRoomID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);









do{
valid = true;


try{
System.out.println("Enter the New Room Capacity: ");
s = indata.readLine();









newCapacity = Integer.parseInt(s);



} catch (Exception e){
System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
valid = false;

}} while (!valid);





 



 try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE Room set Capacity = '"+newCapacity+"' where RoomID = '"+outOfOrderRoomID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if skiing isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }









do{
 try{
         valid = true;
System.out.print("Would You Like to Continue Updating Rooms' Capacities? Press (1). To Return to the Selection Menu, Press (0).");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);





}
while (ConvertContinueUpdating == 1); 
}
 
 
 
 
 
 else if (convertChoice == 0){
break;
} 

 else {
System.out.println("You Entered an Invalid Option Value. Please Try Again.");
}
 
 
 
 
 
 }
    
    


























 break;
 
 case "29"://remove room
 
 
do{
valid = true;


try{
System.out.println("Which Room Would You Like to Remove From the Room List? (Enter Room ID):");
s = indata.readLine();









RoomID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("Error. Enter a Number Please.");
valid = false;

}} while (!valid);




       
       
        try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate(" delete from Room where RoomID = '"+RoomID+"'");
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }

 
 
 
 
 
 
 break;
 
 
 case "30"://view room
 
 
  while(true){
 
  do{
        
         try{
         valid = true;
         
         
 System.out.print("View Info About All Rooms? Press (1). View Info About a Particular Room? Press (2). " +
                  " \nExit? Press (0). ");
choice = indata.readLine();

  if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }


convertChoice = Integer.parseInt(choice);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);
 
 if (convertChoice == 1){
  try{
						 	  
Statement statement = conn.createStatement(); 
  String	query	= "SELECT * from Room";
  System.out.println("RoomID" + "      " + "FacilityID" + "    " + "Capacity");  
		  
		ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			   
				System.out.println(rs.getInt(1) + "           " + rs.getInt(2) + "             " + rs.getInt(3)); 

		  }
        
	 }	catch	(SQLException se)	{ 
	 
	 
	 }
    
   do{
   do{
   try{
   valid = true;
    System.out.print("Close View Mode? Press (0).");
  choice = indata.readLine();
  
  if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }
  
convertChoice = Integer.parseInt(choice);
  
 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

  
  
  
  
    if (convertChoice != 0){ //fix:
    
    
    valid = false;
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
   
    
    
    


} else {
valid = true;
break;
}}while (!valid);

 
 }
 
 else if (convertChoice == 2){
 do{
 try{
 valid = true;
 System.out.println("Which Room Would You Like to View Particular Info About? (Enter Room ID):");
 s = indata.readLine();
 
 
 
 RoomID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

 
 
 
 
 
  try{
						 	  
Statement statement = conn.createStatement(); 
  String	query	= "SELECT * from Room where RoomID = '"+RoomID+"'";
  System.out.println("RoomID" + "      " + "FacilityID" + "    " + "Capacity");  
		  
		ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			      
				System.out.println(rs.getInt(1) + "           " + rs.getInt(2) + "             " + rs.getInt(3)); 

		  }
        
	 }	catch	(SQLException se)	{ 
	 
	 
	 }
    
   do{
    do{
   try{

   valid = true;
    System.out.print("Close View Mode? Press (0).");
 choice = indata.readLine();
 
 if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }
 
convertChoice = Integer.parseInt(choice);
   
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

   
   
   
     if (convertChoice != 0){ //fix:
    
    
    valid = false;
       System.out.println("You Entered a Non-acceptable Value(s). Try Again.");

    
    
    


} else {
valid = true;
break;
}}while (!valid);

 
 
 
 }



else if (convertChoice == 0){
break;
} 

 else {
System.out.println("You Entered an Invalid Option Value. Please Try Again.");
}

}



 
 
 
 
 break;
 
 case "31"://add facility

 do{
valid = true;
System.out.print("What's the Name of the Facility? (Enter Facility Name): "); 
FacilityName = indata.readLine();

for (int i = 0; i < FacilityName.length(); i++){
if (Character.isWhitespace(FacilityName.charAt(i))){
blankSpaceFound = true;
break;
}else{
blankSpaceFound = false;
}}


if (blankSpaceFound == true){
 System.out.println("Error, You Entered An Input That Contains Blank Space. Please Enter a String (text) Value"); 
  valid = false;

} else if(FacilityName.matches("^\\d+(\\.\\d+)?")) { //^\\d+ says that input starts with a digit 0-9, ()? may/or may not occur, \\. allows one period in input. COULD ADD MORE SECURITY LIKE IF WHITESPACE, IF BLANK, IF NEWLINE ETC
  System.out.println("Error, You Entered Integers Only. Please Enter a String (text) Value"); // because user will input new variable name, itll be overwritten (hopefully, if user prompts to fix error
  valid = false;
  
  
  
} else {
  System.out.println("Processing... Complete");
}} while (!valid);
         
         
         
         
         
         
         
         try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("INSERT INTO Facility (Name)" +	"VALUES ('"+FacilityName+"')");
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }

 break;
 
 case "32"://update facility

  
    
    while(true){
 
  
  do{
        
         try{
         valid = true;
         
         
 System.out.println("Update a Facility ID? Press (1). Update a Facility Name? Press (2). Exit? Press (0). ");
choice = indata.readLine();

  if (choice.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
       
      valid = false;
      }


convertChoice = Integer.parseInt(choice);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
     System.out.println();
      valid = false;
      }
      
      
    


}while(!valid);
 
 if (convertChoice == 1){
 
 do{
 do{
 try{
 valid = true;
 System.out.println("Which Facility ID Would You Like to Update? (Enter Facility ID):");
 s = indata.readLine();
 

 
 outOfOrderFacilityID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);










 do{
 try{
 valid = true;
 System.out.println("Enter the New Facility ID Number:");
 s = indata.readLine();
 
  
 newFacilityID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);







try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE Facility set FacilityID = '"+newFacilityID+"' where FacilityID = '"+outOfOrderFacilityID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if 80 isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }





do{
 try{
         valid = true;
System.out.println("Would You Like to Continue Updating Facility IDs? Press (1). To Return to the Selection Menu, Press (0).");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);

if (ConvertContinueUpdating == 0){
valid = true;
System.out.println();
System.out.println();
System.out.println();
break;
}






}while (ConvertContinueUpdating == 1); 
}









 
 else if (convertChoice == 2){
 
 
 
 
 
do{
do{
valid = true;


try{
System.out.println("Enter the Facility ID Number of Who's Facility Name You'd Like to Update: ");
s = indata.readLine();









outOfOrderFacilityID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("Error. Enter a Number Please.");
valid = false;

}} while (!valid);








do{
valid = true;
System.out.print("Enter the New Facility Name: ");
newFacilityName = indata.readLine();

for (int i = 0; i < newFacilityName.length(); i++){
if (Character.isWhitespace(newFacilityName.charAt(i))){
blankSpaceFound = true;
break;
}else{
blankSpaceFound = false;
}}


if (blankSpaceFound == true){
 System.out.println("Error, You Entered An Input That Contains Blank Space. Please Enter a String (text) Value"); 
  valid = false;


} else if(newFacilityName.matches("^\\d+(\\.\\d+)?")) { //^\\d+ says that input starts with a digit 0-9, ()? may/or may not occur, \\. allows one period in input. COULD ADD MORE SECURITY LIKE IF WHITESPACE, IF BLANK, IF NEWLINE ETC
  System.out.println("Error, You Entered Integers Only. Please Enter a String (text) Value"); // because user will input new variable name, itll be overwritten (hopefully, if user prompts to fix error
  valid = false;
  
  
} else {
  System.out.println("Processing... Complete");
}} while (!valid);








 



 try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate("UPDATE Facility set Name = '"+newFacilityName+"' where FacilityID = '"+outOfOrderFacilityID+"'"); 		//sqlite doesnt return error in the case if user wants to change a domain value that doesnt exist. for example if skiing isnt a domain value error still wont come				  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }









do{
 try{
         valid = true;
System.out.print("Would You Like to Continue Updating Facility Names? Press (1). To Return to the Selection Menu, Press (0). ");
continueUpdating = indata.readLine();

if (continueUpdating.length() > 1){ //so its not gonna react to 01 or 001 etc
      System.out.println("Input Too Long.");
      valid = false;
      }


ConvertContinueUpdating = Integer.parseInt(continueUpdating);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);





}
while (ConvertContinueUpdating == 1); 
}

 
 
 
 
 else if (convertChoice == 0){
break;
} 

 else {
System.out.println("You Entered an Invalid Option Value. Please Try Again.");
}
 
 
 
 
 
 
 
 
 
 
 
 }



 break;
 
 case "33"://remove facility



do{
valid = true;


try{
System.out.println("Which Facility Would You Like to Remove From the Facility List? (Enter Facility ID):");
s = indata.readLine();









FacilityID = Integer.parseInt(s);



} catch (Exception e){
System.out.println("Error. Enter a Number Please.");
valid = false;

}} while (!valid);




       
       
        try{
          
		  Statement	statement =	conn.createStatement();
		  
		  statement.executeUpdate(" delete from Facility where FacilityID = '"+FacilityID+"'");
						  
		  }
		  catch (Exception e){
			 System.err.println("Error! "); 
				System.err.println(e.getMessage());
		  }





 break;
 
 case "34"://view facility


  while(true){
 
  do{
        
         try{
         valid = true;
         
         
 System.out.print("View Info About All Facilites? Press (1). View Info About a Particular Facility? Press (2). " +
                  " \nExit? Press (0). ");
choice = indata.readLine();

  if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }


convertChoice = Integer.parseInt(choice);

 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      
    


}while(!valid);
 
 if (convertChoice == 1){
  try{
						 	  
Statement statement = conn.createStatement(); 
  String	query	= "SELECT * from Facility";
  System.out.println("FacilityID" + "     " + "Name");  
		  
		ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			   
				System.out.println(rs.getInt(1) + "              " + rs.getString(2)); 

		  }
        
	 }	catch	(SQLException se)	{ 
	 
	 
	 }
    
   do{
   do{
   try{
   valid = true;
    System.out.print("Close View Mode? Press (0).");
  choice = indata.readLine();
  
  if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }
  
convertChoice = Integer.parseInt(choice);
  
 } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

  
  
  
  
    if (convertChoice != 0){ //fix:
    
    
    valid = false;
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
   
    
    
    


} else {
valid = true;
break;
}}while (!valid);

 
 }
 
 else if (convertChoice == 2){
 do{
 try{
 valid = true;
 System.out.println("Which Facility Would You Like to View Particular Info About? (Enter Facility ID):");
 s = indata.readLine();
 
 
 
 FacilityID = Integer.parseInt(s);
 
 
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

 
 
 
 
 
  try{
						 	  
Statement statement = conn.createStatement(); 
  String	query	= "SELECT * from Facility where FacilityID = '"+FacilityID+"'";
  System.out.println("FacilityID" + "     " + "Name");  
		  
		ResultSet rs =	statement.executeQuery(query); 
		  while (rs.next()) { 
			      
				System.out.println(rs.getInt(1) + "              " + rs.getString(2)); 

		  }
        
	 }	catch	(SQLException se)	{ 
	 
	 
	 }
    
   do{
    do{
   try{

   valid = true;
    System.out.print("Close View Mode? Press (0).");
 choice = indata.readLine();
 
 if (choice.length() > 1){
      System.out.println("Input Too Long.");
      valid = false;
      }
 
convertChoice = Integer.parseInt(choice);
   
    } catch (Exception e){
    
    System.out.println("You Entered a Non-acceptable Value(s). Try Again.");
      valid = false;
      }
      
      }while (!valid);

   
   
   
     if (convertChoice != 0){ //fix:
    
    
    valid = false;
       System.out.println("You Entered a Non-acceptable Value(s). Try Again.");

    
    
    


} else {
valid = true;
break;
}}while (!valid);

 
 
 
 }



else if (convertChoice == 0){
break;
} 

 else {
System.out.println("You Entered an Invalid Option Value. Please Try Again.");
}

}








 break;
 
 case "35"://exit
 System.out.println("Exit program.");
            System.exit(0);
            break;
         default: //Felaktigt val
            System.out.println("Invalid option! Please try again!");
            
                
     }
     }
  }
 } 

 
 
 
 
 
 
 