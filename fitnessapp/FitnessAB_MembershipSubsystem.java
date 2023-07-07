import java.io.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import java.time.format.*;
import java.time.*;
import org.sqlite.SQLiteConfig;

public class FitnessAB_MembershipSubsystem {

   // Sökväg till SQLite-databas. OBS! Ändra sökväg så att den pekar ut din databas
   public static final String DB_URL = "jdbc:sqlite:C:/Users/Bella/Documents/Systemvetenskap/sqlite/Tidsrapporteringssystem/FitnessAB.db";   

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
      String name = "";
      String fName = "";
      String eName = "";
      String date = null;
      String startDate = "";
      String endDate = "";
      String personNummer = null;
      String email = "";
      String phonenumber = null;
      String membershipTier = "";
      String newMembershipTier = "";
      String paymentMethod = "";
      int update = 0;
      int remove = 0;
      int create = 0;
      int view = 0;
      int curingPeriod = 0;
      int memberID = 0;
      int facilityId = 0;
      int roomId = 0;
      int antalSiffror = 0;
      int timmar = 0;
      int fee = 0;
      int newFee = 0;   

      while (val != "Q") {
      
      System.out.println("\nChoose one of the following options below."); // Member Management
      System.out.println();
      System.out.println("1 - Register New Member.");
      System.out.println("2 - Update Existing Member.");
      System.out.println("3 - Remove Existing Member.");
      System.out.println("4 - View Member Profile.");
      System.out.println("5 - Create Membership Contract.");
      System.out.println("6 - Cancel Membership Contract.");
      System.out.println("7 - View Membership Contract.");
      System.out.println("8 - Create Membership.");
      System.out.println("9 - Update Membership.");
      System.out.println("10 - Remove Membership.");
      System.out.println("11 - View Membership.");
      System.out.println("12 - Exit."); 
      
      BufferedReader indata = new BufferedReader(new InputStreamReader(System.in));
      val = indata.readLine();
      val = val.toUpperCase();
      
      switch (val) {
         case "1": //Register new member
           
           System.out.println("Enter the members first name.");
            fName = indata.readLine();
               
           System.out.println("Enter the members last name.");
            eName = indata.readLine();
           
           System.out.println("Enter the members date of birth 'YYYY-MM-DD'.");
               
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
          
          System.out.println("Enter the members phone number in format 'XXXX-XXXXXX.");
           phonenumber = indata.readLine();
           phonenumber = phonenumber.trim();
           antalSiffror = phonenumber.length();
           
           if (antalSiffror > 11) {
             System.out.println("Invalid phonenumber.");
           break;
           }
            
          System.out.println("Enter the members email address.");
           email = indata.readLine();
            
        try {
         System.out.println("Register new member...");
          stmt = conn.createStatement();
      
         String sql = "INSERT INTO Member(FirstName, LastName, DateOfBirth, PhoneNumber, Email) " +
         "VALUES ('"+ fName +"','"+ eName +"','"+ personNummer +"','"+ phonenumber +"','"+ email +"')";
          stmt.executeUpdate(sql);
         
         System.out.println("New member registered!");
        }
     
        catch(Exception e) { //Hanterar fel för Class.forName
          System.err.println("Error!");
          System.err.println(e.getMessage());
        }
        
      break;
      
      case "2": //Update existing member
           
           System.out.println("Enter the ID of the member you want to update.");
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
           
       catch(Exception e) { //Hanterar fel för Class.forName
          System.err.println("Error!");
          System.err.println(e.getMessage());
       }
       
        
       System.out.println("\nWhich of the folloriwng information do you want to update?");
        System.out.println();
        System.out.println("1 - First name.");
        System.out.println("2 - Last name.");
        System.out.println("3 - Date of Birth.");
        System.out.println("4 - Phone number.");
        System.out.println("5 - Email.");
        System.out.println("6 - Exit.");  
                
         s = indata.readLine();
         update  = Integer.parseInt(s);  
       
       if (update == 1) { //First name
        System.out.println("Enter the new first name.");
            fName = indata.readLine();
        
        try {
          stmt = conn.createStatement();
          stmt.executeUpdate("UPDATE Member SET FirstName= '" + fName + "' WHERE MemberID =" + memberID + ";");
          
           System.out.println ("First name updated for member: " + memberID + "."); 
        }
         
        catch(Exception e) { //Hanterar fel för Class.forName
          System.err.println("Error!");
          System.err.println(e.getMessage());
        }
         
       break;
       }
       
       else if (update == 2) { //Last name
         System.out.println("Enter the new last name.");
            eName = indata.readLine();
            
        try {
          stmt = conn.createStatement();
          stmt.executeUpdate("UPDATE Member SET LastName= '" + eName + "' WHERE MemberID =" + memberID + ";");
          
           System.out.println ("Last name updated for member: " + memberID + ".");  
        }
          
         catch(Exception e) { //Hanterar fel för Class.forName
          System.err.println("Error!");
          System.err.println(e.getMessage());
         } 
         
       break;
       }
       
       else if (update == 3) { // Date of Birth
         System.out.println("Enter the new date of birth 'YYYY-MM-DD'.");
               
             personNummer = indata.readLine();
             personNummer = personNummer.trim();
             antalSiffror = personNummer.length();
               
           if (antalSiffror != 10) {
             System.out.println("Invalid date of birth!");
           break;
           }
               
           String ar1 = personNummer.substring(0,4);
           String manad1 = personNummer.substring(5,7);
           String dag1 = personNummer.substring(8);
               
           int arInt1 = Integer.parseInt(ar1);
           int manadInt1 = Integer.parseInt(manad1);
           int dagInt1 = Integer.parseInt(dag1);
                       
            //Validiera så formatet på år, månad och dag är giltligt.              
           if (arInt1 < 1920 || arInt1 > 2020 || manadInt1 < 01 || manadInt1 > 12 || dagInt1 < 01 || dagInt1 > 31) {
              System.out.println("Invalid date of birth!.");
           break;
           }
           
         try {
          stmt = conn.createStatement();
          stmt.executeUpdate("UPDATE Member SET DateOfBirth= '" + personNummer + "' WHERE MemberID =" + memberID + ";");
          
           System.out.println ("Date of Birth updated for member: " + memberID + "."); 
         }
         
         catch(Exception e) { //Hanterar fel för Class.forName
          System.err.println("Error!");
          System.err.println(e.getMessage());
         } 
         
       break;     
       }   
       
       else if (update == 4) { //Phonenumber
        System.out.println("Enter the new phonenumber in format 'XXXX-XXXXXX.");
           phonenumber = indata.readLine();
           phonenumber = phonenumber.trim();
           antalSiffror = phonenumber.length();
           
           if (antalSiffror > 11) {
             System.out.println("Invalid phonenumber.");
           break;
           }
           
        try {
          stmt = conn.createStatement();
          stmt.executeUpdate("UPDATE Member SET Phonenumber= '" + phonenumber + "' WHERE MemberID =" + memberID + ";");
          
           System.out.println ("Phonenumber updated for member: " + memberID + "."); 
         }
         
         catch(Exception e) { //Hanterar fel för Class.forName
          System.err.println("Error!");
          System.err.println(e.getMessage());
         }
         
       break;
       }
       
       else if (update == 5) { //Email
        System.out.println("Enter the new email address.");
         email = indata.readLine(); 
         
         try {
          stmt = conn.createStatement();
          stmt.executeUpdate("UPDATE Member SET Email= '" + email + "' WHERE MemberID =" + memberID + ";");
          
           System.out.println ("Email updated for member: " + memberID + ".");  
         }
         
         catch(Exception e) { //Hanterar fel för Class.forName
          System.err.println("Error!");
          System.err.println(e.getMessage());
         }
         
        break;    
        }
       
        else if (update == 6) { //Exit
        break;
        }
       
        else {
         System.out.println("Invalid option! Choose between 1-6.");
        }
       break;
          
       case "3": //Remove existing member
           
           System.out.println("Enter the ID of the member you want to delete.");
            s = indata.readLine();
            memberID = Integer.parseInt(s);
            
         try {
          stmt = conn.createStatement();
      
          String sql = "SELECT MemberID, FirstName, LastName FROM Member WHERE MemberID= " + memberID +"";
          ResultSet rs = stmt.executeQuery(sql);
          
           while(rs.next()) {
            System.out.println ("MemberID " + rs.getInt("MemberID") + ": " +
                               rs.getString("FirstName") + " " + rs.getString("LastName") + ".");                           
           } 
         }
            
          catch(Exception e) { //Hanterar fel för Class.forName
           System.err.println("Error!");
           System.err.println(e.getMessage());
          }
           
           System.out.println("Are you sure you want to delete Member: " + memberID + "? Any changes can not be redone.");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            
           s = indata.readLine();
           remove  = Integer.parseInt(s);
           
           if (remove == 1) {
            try {
             stmt = conn.createStatement();
             stmt.executeUpdate("DELETE FROM Member WHERE MemberID= " + memberID + "");
             
              System.out.println ("Member: " + memberID + " is now deleted.");
            }
            
            catch(Exception e) { //Hanterar fel för Class.forName
             System.err.println("Error!");
             System.err.println(e.getMessage());
            }
           }
           
           else if (remove == 2) {
            break;
           }
           
           else {
            System.out.println("Invalid option! Choose between 1 - Yes and 2 - No.");
           }
          
          break;
          
        case "4": //View member profile
          System.out.println("Choose one of the following options:");
            System.out.println("1 - View a specific member.");
            System.out.println("2 - View all members.");
            System.out.println("3 - Exit.");
           
            s = indata.readLine();
            view = Integer.parseInt(s);
           
           if (view == 1) {
            System.out.println("Enter the ID for the member you want to view.");
            s = indata.readLine();
            memberID = Integer.parseInt(s);
           
           try {
            stmt = conn.createStatement();
      
            String sql = "SELECT MemberID, FirstName, LastName, DateOfBirth, Phonenumber, Email FROM Member WHERE MemberID= " + memberID +"";
            ResultSet rs = stmt.executeQuery(sql);
          
            while(rs.next()) {
            System.out.print("MemberID: " + rs.getInt("MemberID") + "\nFirst Name: " + rs.getString("FirstName") + "\nLast Name: " + rs.getString("LastName") + "\nDate of Birth: " + "\t" + rs.getString("DateOfBirth") + "\nPhonenumber: " + rs.getString("Phonenumber") + "\nEmail: " + rs.getString("Email") +"\n");                         
            }
           }
           
           catch(Exception e) { //Hanterar fel för Class.forName
             System.err.println("Error!");
             System.err.println(e.getMessage());
            }
          break;
           }
           
           else if (view == 2) {
            try {
            stmt = conn.createStatement();
      
             String sql = "SELECT MemberID, FirstName, LastName, DateOfBirth, Phonenumber, Email FROM Member ORDER BY MemberID;";
             ResultSet rs = stmt.executeQuery(sql);
          
            System.out.println("MemberID: \t"+ "First Name: \t" + "Last Name: \t" + "Date of Birth: \t" + "Phone Number: \t" + "Email: \t");
          
            while(rs.next()) {
             System.out.print(rs.getInt("MemberID") + "\t" + "\t" + rs.getString("FirstName") + "\t" + "\t" + rs.getString("LastName") + "\t" + "\t" + rs.getString("DateOfBirth") + "\t" + "\t" + rs.getString("Phonenumber") + "\t" + "\t" + rs.getString("Email") +"\n"); 
            }
           }
           
           catch(Exception e) { //Hanterar fel för Class.forName
             System.err.println("Error!");
             System.err.println(e.getMessage());
            }
            
          break;
           }
           
           else if (view == 3) {
            break;
           }
           
           else {
            System.out.println("Invalid option!");
           }
          break;
          
          case "5": // Create Membership Contract
           try {
            System.out.println("Enter the ID for the member you want to create a contract for.");
            s = indata.readLine();
            memberID = Integer.parseInt(s);
           }

           catch(Exception e) { //Hanterar fel för Class.forName
             System.err.println("Error!");
             System.err.println(e.getMessage());
            }
           
            System.out.println("Choose desired membership tier:");
             System.out.println("1 - Silver.");
             System.out.println("2 - Gold.");
             System.out.println("3 - Platinum.");
             System.out.println("4 - Exit.");
            
             s = indata.readLine();
             create = Integer.parseInt(s);
             
             if (create == 1) { //Silver Tier
               membershipTier = "Silver";
             }  
             
             else if (create == 2) { //Gold Tier
               membershipTier = "Gold";
             } 
             
             else if (create == 3) { //Platinum Tier
               membershipTier = "Platinum";
             } 
             
             else if (create == 4) { //Exit
               break;
             } 
             
             else { //Silver Tier
               System.out.println("Non-existing membership tier!");
             }               
         
         System.out.println("Choose desired payment method:");
            System.out.println("1 - Cash.");
             System.out.println("2 - Card.");
             System.out.println("3 - Direct debit.");
             System.out.println("4 - Exit.");
            
             s = indata.readLine();
             create = Integer.parseInt(s);
             
             if (create == 1) { //Cash
               paymentMethod = "Cash";
             }  
             
             else if (create == 2) { //Card
               paymentMethod = "Card";
             } 
             
             else if (create == 3) { //Direct Debit
               paymentMethod = "Direct debit";
             } 
             
             else if (create == 4) { //Exit
               break;
             } 
             
             else {
               System.out.print("Non-existing payment method!");
             }
         
         System.out.println("Choose desired curing period:");
          System.out.println("1 - 3 months.");
             System.out.println("2 - 6 months.");
             System.out.println("3 - 12 months.");
             System.out.println("4 - Exit.");
            
             s = indata.readLine();
             curingPeriod = Integer.parseInt(s);
             
             if (curingPeriod == 1) {
              DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
              LocalDate localDate = LocalDate.now();
              startDate = dft.format(localDate);
             
              LocalDate threeMonths = localDate.plusMonths(3);
              endDate = dft.format(threeMonths);
             }  
             
             else if (curingPeriod == 2) {             
              DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
              LocalDate localDate = LocalDate.now();
              startDate = dft.format(localDate);
               
              LocalDate sixMonths = localDate.plusMonths(6);
              endDate = dft.format(sixMonths);
             }
             
             else if (curingPeriod == 3) {
              DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
              LocalDate localDate = LocalDate.now();
              startDate = dft.format(localDate);
               
              LocalDate twelveMonths = localDate.plusMonths(12);
              endDate = dft.format(twelveMonths);
             }
             
             else if (create == 4) { //Exit
               break;
             }
             
             else {
               System.out.print("Non-existing curing period!");
             }
            
        try {
         System.out.println("Creating contract for member...");
          stmt = conn.createStatement();
      
         String sql = "INSERT INTO Contract(MemberID, Tier, PaymentMethod, CuringPeriod, StartDate, EndDate) " +
         "VALUES ('"+ memberID +"','"+ membershipTier +"','"+ paymentMethod +"','"+ curingPeriod +"','"+ startDate +"','" + endDate + "')";
          stmt.executeUpdate(sql);
         
         System.out.println("New contract created!");
        }
     
        catch(Exception e) { //Hanterar fel för Class.forName
             System.err.println("Error!");
             System.err.println(e.getMessage());
            }
          
          break;
          
          case "6": //Cancel Membership Contract
          System.out.println("Enter the ID of the member who's contract you want to delete.");
            s = indata.readLine();
            memberID = Integer.parseInt(s);
           
           System.out.println("Are you sure you want to delete Member: " + memberID + "'s contract? Any changes can not be redone.");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            
           s = indata.readLine();
           remove  = Integer.parseInt(s);
           
           if (remove == 1) {
            try {
             stmt = conn.createStatement();
             stmt.executeUpdate("DELETE FROM Contract WHERE MemberID= " + memberID + "");
             
              System.out.println ("Member: " + memberID + "'s contract is now deleted.");
            }
            
            catch(Exception e) { //Hanterar fel för Class.forName
          System.err.println("Error!");
          System.err.println(e.getMessage());
           }
           }
           else if (remove == 2) {
            break;
           }
           
           else {
            System.out.println("Invalid option! Choose between 1 - Yes and 2 - No.");
           }
          
          break;

          case "7": // View Membership Contract
           System.out.println("Choose one of the following options:");
            System.out.println("1 - View a specific membership contract.");
            System.out.println("2 - View all membership contracts.");
            System.out.println("3 - Exit.");
           
            s = indata.readLine();
            view = Integer.parseInt(s);
           
           if (view == 1) {
            System.out.println("Enter the ID for the member you want to view.");
            s = indata.readLine();
            memberID = Integer.parseInt(s);
           
            try {
             stmt = conn.createStatement();
      
             String sql = "SELECT MemberID, Tier, PaymentMethod, CuringPeriod, StartDate, EndDate FROM Contract WHERE MemberID= " + memberID +"";
             ResultSet rs = stmt.executeQuery(sql);
          
              while(rs.next()) {
               System.out.print("MemberID: " + rs.getInt("MemberID") + "\nTier: " + rs.getString("Tier") + "\nPayment Method: " + rs.getString("PaymentMethod") + "\nCuring Period: " + rs.getString("CuringPeriod") + "\nStart Date: " + rs.getString("StartDate") + "\nEnd Date: " + rs.getString("EndDate") +"\n");                         
              }
            }
           
           catch(Exception e) { //Hanterar fel för Class.forName
             System.err.println("Error!");
             System.err.println(e.getMessage());
            }
           break;
           }
           
           else if (view == 2) {
            try {
             stmt = conn.createStatement();
      
             String sql = "SELECT MemberID, Tier, PaymentMethod, CuringPeriod, StartDate, EndDate FROM Contract ORDER BY MemberID;";
             ResultSet rs = stmt.executeQuery(sql);
          
            System.out.println("MemberID: \t"+ "Tier: \t" + "Payment Method: \t" + "Curing Period: \t" + "Start Date: \t" + "End Date: \t");
          
            while(rs.next()) {
             System.out.print(rs.getInt("MemberID") + "\t" + "\t" + rs.getString("Tier") + "\t" + "\t" + rs.getString("PaymentMethod") + "\t" + "\t" + rs.getString("CuringPeriod") + "\t" + "\t" + rs.getString("StartDate") + "\t" + "\t" + rs.getString("EndDate") +"\n"); 
            }
           }
           
           catch(Exception e) { //Hanterar fel för Class.forName
             System.err.println("Error!");
             System.err.println(e.getMessage());
            }
 
           break;
           }
           
           else if (view == 3) {
            break;
           }
           
           else {
            System.out.println("Invalid option!");
           }
          break;
            
          case "8": // Create Membership
           System.out.println("Enter the name of the memebership tier.");
            membershipTier = indata.readLine();
               
           System.out.println("Enter the fee of the membership tier: " + membershipTier + ".");
            s = indata.readLine();
            fee = Integer.parseInt(s);
           
           try {
            System.out.println("Creating new membership tier...");
            stmt = conn.createStatement();
      
            String sql = "INSERT INTO Membership(Tier, Fee) " +
            "VALUES ('"+ membershipTier +"','"+ fee +"')";
            stmt.executeUpdate(sql);
         
            System.out.println("New membership tier created!");
           }
     
          catch(Exception e) { //Hanterar fel för Class.forName
           System.err.println("Error!");
           System.err.println(e.getMessage());
          }

         break;
          
         case "9": // Update Membership
          System.out.println("Enter the name of the tier you want to update.");
          membershipTier = indata.readLine();
            membershipTier.equalsIgnoreCase(membershipTier);
            
         try {
          stmt = conn.createStatement();
      
          String sql = "SELECT Tier, Fee FROM Membership WHERE Tier= '" + membershipTier +"';";
          ResultSet rs = stmt.executeQuery(sql);
          
           while(rs.next()) {
            System.out.println (rs.getString("Tier") + ": " + rs.getInt("Fee") + " SEK.");                           
           } 
          }
            
          catch(Exception e) { //Hanterar fel för Class.forName
           System.err.println("Error!");
           System.err.println(e.getMessage());
          }

       System.out.println("\nWhich of the folloriwng information do you want to update?");
        System.out.println();
        System.out.println("1 - Name of the tier.");
        System.out.println("2 - Fee of the tier.");
        System.out.println("3 - Exit.");  
                
         s = indata.readLine();
         update  = Integer.parseInt(s);  
       
       if (update == 1) { //Tier name
        System.out.println("Enter the new tier name.");
            newMembershipTier = indata.readLine();
        
        try {
          stmt = conn.createStatement();
          stmt.executeUpdate("UPDATE Membership SET Tier= '" + newMembershipTier + "' WHERE Tier ='" + membershipTier + "';");
          
           System.out.println ("Name updated for tier: " + newMembershipTier + "."); 
        }
         
        catch(Exception e) { //Hanterar fel för Class.forName
          System.err.println("Error!");
          System.err.println(e.getMessage());
        }
         
       break;
       }
       
       else if (update == 2) { //Tier fee
         System.out.println("Enter the new tier fee.");
            s = indata.readLine();
            newFee = Integer.parseInt(s);
            
            
        try {
          stmt = conn.createStatement();
          stmt.executeUpdate("UPDATE Membership SET Fee= '" + newFee + "' WHERE Tier ='" + membershipTier + "';");
          
           System.out.println ("Fee updated for tier: " + membershipTier + ", to " + newFee + " SEK.");  
        }
          
         catch(Exception e) { //Hanterar fel för Class.forName
          System.err.println("Error!");
          System.err.println(e.getMessage());
         } 
         
       break;
       }
         break;
          
         case "10": // Remove Membership
          System.out.println("Enter the name of the membership you want to delete.");
            membershipTier = indata.readLine();
            membershipTier.equalsIgnoreCase(membershipTier);
            
         try {
          stmt = conn.createStatement();
      
          String sql = "SELECT Tier, Fee FROM Membership WHERE Tier= '" + membershipTier +"';";
          ResultSet rs = stmt.executeQuery(sql);
          
           while(rs.next()) {
            System.out.println (rs.getString("Tier") + ": " + rs.getInt("Fee") + ".");                           
           } 
         }
            
          catch(Exception e) { //Hanterar fel för Class.forName
           System.err.println("Error!");
           System.err.println(e.getMessage());
          }
           
           System.out.println("Are you sure you want to delete Tier: " + membershipTier + "? Any changes can not be redone.");
            System.out.println("1 - Yes");
            System.out.println("2 - No");
            
           s = indata.readLine();
           remove  = Integer.parseInt(s);
           
           if (remove == 1) {
            try {
             stmt = conn.createStatement();
             stmt.executeUpdate("DELETE FROM Membership WHERE Tier= '" + membershipTier + "';");
             
              System.out.println ("Member: " + membershipTier + " is now deleted.");
            }
            
            catch(Exception e) { //Hanterar fel för Class.forName
             System.err.println("Error!");
             System.err.println(e.getMessage());
            }
           }
           
           else if (remove == 2) {
            break;
           }
           
           else {
            System.out.println("Invalid option! Choose between 1 - Yes and 2 - No.");
           }
         break;
          
         case "11": // View Membership
          try {
           stmt = conn.createStatement();
      
           String sql = "SELECT Tier, Fee FROM Membership ORDER BY Fee;";
           ResultSet rs = stmt.executeQuery(sql);
          
           System.out.println("Tier: \t" + "Fee: \t");
          
            while(rs.next()) {
             System.out.print(rs.getString("Tier") + "\t" + "\t" + rs.getInt("Fee") + "\n"); 
            }
           }
           
           catch(Exception e) { //Hanterar fel för Class.forName
             System.err.println("Error!");
             System.err.println(e.getMessage());
            }
            
          break;
          
          case "12": //Exit
            System.out.println("Exit program.");
            System.exit(0);
            break;
         default: //Felaktigt val
            System.out.println("Invalid option! Please try again!");           
     }
     }
  }
 } 