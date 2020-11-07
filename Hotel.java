import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Hotel{
     public static  int i = 0; 
     public static int ch = 0; // User's menu choice
     public static Scanner sc=new Scanner(System.in); //to read keyboard input
     private static String username;
     private static String password;
	
	public static void main (String args[]){

        home();

		while(true){

            if (ch==1) {

                System.out.println("\n\t\t\t~~~~~~~~~~~~~~~~~~~~~~~"); 
                System.out.println("\t\t\t)..User Registration..(");
                System.out.println("\t\t\t~~~~~~~~~~~~~~~~~~~~~~~\n\n"); 
                Scanner sc3 = new Scanner(System.in);
                System.out.print("\n\tEnter username : ");
                String uname = sc3.next();
                java.io.Console console1 = System.console();
                String pwd = new String(console1.readPassword("\tPassword(Password will not be appear.Keep typing): "));
                String cpwd = new String(console1.readPassword("\tRetype Password(Password will not be appear.Keep typing): "));
                
                if(pwd.equals(cpwd)){
                    User.createUser(uname,pwd);
                }
                else{
                    System.out.println("\n\t\tPassword Doesn't match, try again");
                }
                home();
            }

			else if(ch==2){

				java.io.Console console = System.console();
        		username = console.readLine("\nUsername: ");
        		password = new String(console.readPassword("Password(Password will not be appear.Keep typing): "));

        		boolean validuser = LoginHandle.checkUser("users.txt",username,password);
        		if(validuser){
                    
        			if(username.equals("admin")){
        				admin();
        			}
        			else{
                        System.out.print("\t\t\tLogin UserName Is: "+username+"\n\n");
        				user();
        			}
        			
        		}
                home();
        		
			}

            else if(ch==3){
                quit();

            }
            else{

                System.out.println("\n\t\t\tWrong you type wrong choice Please try again\n");
                System.out.println("----------------------------------------------------------------------------------\n\n");
                home();
            }
		}

	}



    public static void replaceFile(String file1,String file2){

    	FileInputStream instream = null;
    	FileOutputStream outstream = null;
    	try{
    		
    	    File infile =new File(file1);
    	    File outfile =new File(file2);
    	    FileWriter w1=new FileWriter(file2,false);
    	    w1.write("");
    	    w1.close();

 
    	    instream = new FileInputStream(infile);
    	    outstream = new FileOutputStream(outfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    /*copying the contents from input stream to
    	     * output stream using read and write methods
    	     */
    	    while ((length = instream.read(buffer)) > 0){
    	    	outstream.write(buffer, 0, length);
    	    }

    	    //Closing the input/output file streams
    	    instream.close();
    	    outstream.close();
    	    FileWriter w=new FileWriter(file1,false);
    	   w.write("");
    	   w.close();

    	}
    	catch(IOException ioe){
    		ioe.printStackTrace();
    	}
    }
     public static void home(){// golobal display function

        System.out.println("\n\n\t\t    *                                 ");
        System.out.println("\t\t  *   *                               ");
        System.out.println("\t\t *      ************************      ");
        System.out.println("\t\t *                               *    ");
        System.out.println("\t\t  *     ~~~~~~~~~SRKCY~~~~~~~~~    *  ");
        System.out.println("\t\t    *                               * ");
        System.out.println("\t\t      ************************      * ");
        System.out.println("\t\t                              *    *  ");
        System.out.println("\t\t                               *  *   ");
        System.out.println("\t\t                                 *    ");


        System.out.println("\n\t\t  !.....Welcome to Hotel SRKCY.....!");
        System.out.println("\nPlease select an option");
        System.out.println("\n1.Register User.");
        System.out.println("2.Log In To System.");
        System.out.println("3.Quit.");

        System.out.print("\n\nYour choice: ");
        ch=sc.nextInt();


     }
      public static void admin(){// golobal display function

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~"); 
        System.out.println(") ...Admin Panel... (");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~\n");

        System.out.println("\nPlease select an option");
        System.out.println("\n1.View Coustumers Bookings.");
        System.out.println("2.Confirm Booking.");
        System.out.println("3.Add available room.");
        System.out.println("4.Status Change.");
        System.out.println("5.Logout.");

        System.out.print("\n\nYour choice: ");
        ch=sc.nextInt();

        Staff staff = new Staff();

        while(true){

        if(ch==1){

            staff.viewUcBookings("bookings.txt");

            System.out.println("\nPlease select an option");
            System.out.println("\n1.View Coustumers Bookings.");
            System.out.println("2.Confirm Booking.");
            System.out.println("3.Add available room.");
            System.out.println("4.Status Change.");
            System.out.println("5.Logout.");

            System.out.print("\n\nYour choice: ");
            ch=sc.nextInt();

        }
        else if(ch==2){
            staff.confirmBooking();

            System.out.println("\nPlease select an option");
            System.out.println("\n1.View Coustumers Bookings.");
            System.out.println("2.Confirm Booking.");
            System.out.println("3.Add available room.");
            System.out.println("4.Status Change.");
            System.out.println("5.Logout.");

            System.out.print("\n\nYour choice: ");
            ch=sc.nextInt();

        }
        else if(ch==3){
            staff.addavailableroom();

            System.out.println("\nPlease select an option");
            System.out.println("\n1.View Coustumers Bookings.");
            System.out.println("2.Confirm Booking.");
            System.out.println("3.Add available room.");
            System.out.println("4.Status Change.");
            System.out.println("5.Logout.");

            System.out.print("\n\nYour choice: ");
            ch=sc.nextInt();

        }
        else if(ch==4){

            Scanner sc1=new Scanner(System.in);
            System.out.println("\n\nEnter room ids for confirmation: (ex : 1,2,3 etc)");
            String list = sc1.next();
            Room.confirmRooms(list);


            System.out.println("\nPlease select an option");
            System.out.println("\n1.View Coustumers Bookings.");
            System.out.println("2.Confirm Booking.");
            System.out.println("3.Add available room.");
            System.out.println("4.Status Change.");
            System.out.println("5.Logout.");

            System.out.print("\n\nYour choice: ");
            ch=sc.nextInt();
        }
        else if(ch==5){
             System.out.println("\n\n\t\t\t^^^^^Log Out Admin Panel Bye!^^^^^");
             System.out.println("----------------------------------------------------------------------------------\n\n");

             break;
        }
        else{
            System.out.println("\n\t\t\tWrong you type wrong choice Please try again\n");
            System.out.println("----------------------------------------------------------------------------------\n\n");

            System.out.println("\nPlease select an option");
            System.out.println("\n1.View Coustumers Bookings.");
            System.out.println("2.Confirm Booking.");
            System.out.println("3.Add available room.");
            System.out.println("4.Status Change.");
            System.out.println("5.Logout.");

            System.out.print("\n\nYour choice: ");
            ch=sc.nextInt();
        }
        
       
        

        }
       


     }

    public static void user(){// golobal display function

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(")...Coustumer Panel...(");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");

        System.out.println("\nPlease select an option");
        System.out.println("\n1.View Avalibale Rooms.");
        System.out.println("2.Booking Room.");
        System.out.println("3.Booking Cancelation.");
        System.out.println("4.Logout.");

        System.out.print("\n\nYour choice: ");
        ch=sc.nextInt();

        Staff staff = new Staff();

        while(true){

        if(ch==1){

            Room.viewRooms("rooms.txt");
                        

            System.out.println("\nPlease select an option");
            System.out.println("\n1.View Avalibale Rooms.");
            System.out.println("2.Booking Room.");
            System.out.println("3.Booking Cancelation.");
            System.out.println("4.Logout.");

            System.out.print("\n\nYour choice: ");
            ch=sc.nextInt();

        }
        else if(ch==2){

            BookingRecord.booking();

            System.out.println("\nPlease select an option");
            System.out.println("\n1.View Avalibale Rooms.");
            System.out.println("2.Booking Room.");
            System.out.println("3.Booking Cancelation.");
            System.out.println("4.Logout.");

            System.out.print("\n\nYour choice: ");
            ch=sc.nextInt();

        }
        else if(ch==3){
            
            Scanner sc1=new Scanner(System.in);
            System.out.println("\n\nEnter room ids for confirmation: (ex : 1,2,3 etc)");
            String list = sc1.next();
            Room.confirmRooms(list);
            BookingRecord.cancelBooking(list);

            System.out.println("\nPlease select an option");
            System.out.println("\n1.View Avalibale Rooms.");
            System.out.println("2.Booking Room.");
            System.out.println("3.Booking Cancelation.");
            System.out.println("4.Logout.");

            System.out.print("\n\nYour choice: ");
            ch=sc.nextInt();

        }
        else if(ch==4){
             System.out.println("\n\n\t\t\t^^^^^Log Out User Panel Bye!^^^^^");
             System.out.println("----------------------------------------------------------------------------------\n\n");
             break;
        }
        else{
            System.out.println("\n\t\t\tWrong you type wrong choice Please try again\n");
            System.out.println("----------------------------------------------------------------------------------\n\n");

            System.out.println("\nPlease select an option");
            System.out.println("\n1.View Coustumers Bookings.");
            System.out.println("2.Confirm Booking.");
            System.out.println("3.Add available room.");
            System.out.println("4.Status Change.");
            System.out.println("5.Logout.");

            System.out.print("\n\nYour choice: ");
            ch=sc.nextInt();

        }
        
       
        

        }
       


     }
        public static void quit(){ // golobal quit function
          
          System.out.print("\n\n\t\t!.....Thank you for using Welcome back our Hotel SRKCY.....!\n\n");
          System.out.println("\t\t-----------------------------------------------------------\n\n");
          System.out.print("\n\n! Dear sir plase help me sir win this codemaina project \ni'm very hard cording sir this one win \nwe only can sir text databse my data save but \nwe canot checking avalible in date \nit cant only done in mysql date base my loop same error came sir!\n\n");
          System.out.print("! I'm very poor student sir plase help me sir win this codemaina :):):):(:( !\n\n");
          System.out.println("I'm Progammer SR");
          System.exit(0);
          
          
      }

}