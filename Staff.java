import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Staff extends User{

	public static void viewUcBookings(String file2){
		FileReader fr2=null;
        BufferedReader br2=null;
        int i=0;

        try{
            fr2=new FileReader(file2);
            
            br2=new BufferedReader(fr2);
            
            String cline=null;
            System.out.println("\n______All Unconfirmed Bookings______\n");
            
            while((cline=br2.readLine())!=null){
                
                String[] arr1=cline.split(",");

                if(arr1[9].equals("Unconfirmed")){

                    System.out.println("\t* Room id : "+arr1[0]);
                    System.out.println("\t* Name : "+arr1[1]);
                    System.out.println("\t* Address : "+arr1[2]);
                    System.out.println("\t* Mobile : "+arr1[3]);
                    System.out.println("\t* NIC : "+arr1[4]);
                    System.out.println("\t* Check-In day : "+arr1[5]);
                    System.out.println("\t* Booking Date : "+arr1[6]);
                    System.out.println("\t* Number of Date : "+arr1[7]);
                    System.out.println("\t* Number of Person : "+arr1[8]);
                    System.out.println("\t* PIN : "+arr1[10]+"\n\n");

                }
                
            }

            fr2=new FileReader(file2); 
            br2=new BufferedReader(fr2);
            cline=null;
            System.out.print("\n\n______All Confirmed Bookings______\n\n");
            while((cline=br2.readLine())!=null){
                
                String[] arr1=cline.split(",");

                if(arr1[9].equals("Confirmed")){

                    System.out.println("\t* Room id : "+arr1[0]);
                    System.out.println("\t* Name : "+arr1[1]);
                    System.out.println("\t* Address : "+arr1[2]);
                    System.out.println("\t* Mobile : "+arr1[3]);
                    System.out.println("\t* NIC : "+arr1[4]);
                    System.out.println("\t* Check-In day : "+arr1[5]);
                    System.out.println("\t* Booking Date : "+arr1[6]);
                    System.out.println("\t* Number of Date : "+arr1[7]);
                     System.out.println("\t* Number of Person : "+arr1[8]);
                    System.out.println("\t* PIN : "+arr1[10]+"\n\n");
                    
                }
                
            }




            fr2.close();
            br2.close();
            
            
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
	}


	public static void confirmBooking(){

		Scanner sc1=new Scanner(System.in);
        System.out.println("\n\nEnter room ids for confirmation: (ex : 1,2,3 etc)");
        String list = sc1.next();
        String[] arrlist = list.split(",");
        try{
            
            
            FileReader fr = new FileReader("bookings.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter w2 = new FileWriter("updatebookings.txt",true);
            String cline=null;
            int x=0;

          for(String s : arrlist){
            while((cline=br.readLine())!=null){
                String[] arr1=cline.split(",");
                if(arr1[0].equals(s) &&arr1[9].equals("Unconfirmed")){
                    
                    w2.write(arr1[0]+","+arr1[1]+","+arr1[2]+","+arr1[3]+","+arr1[4]+","+arr1[5]+","+arr1[6]+","+arr1[7]+","+arr1[8]+","+"Confirmed,"+arr1[10]+"\n");
                     System.out.println("\nBooking Confirmation done");
                    System.out.println("------------------------------\n\n");
                    x=5;
                }
                else{

                    w2.write(arr1[0]+","+arr1[1]+","+arr1[2]+","+arr1[3]+","+arr1[4]+","+arr1[5]+","+arr1[6]+","+arr1[7]+","+arr1[8]+","+arr1[9]+","+arr1[10]+"\n");
                }
            }
        }
            if(x != 5){

            System.out.println("\nBooking Confirmation Not Done It Is Invalid Id");
            System.out.println("-------------------------------------------------\n\n");
                            
                            }

            w2.close();
            Hotel.replaceFile("updatebookings.txt","bookings.txt");                     
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

	}
    public static void addavailableroom(){

                        Scanner sc1=new Scanner(System.in);
                        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println(") ...Add new room main System... (");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

                        try{


                                System.out.print("\nEnter Room id :");
                                String rid = sc1.next();
                                System.out.print("\nEnter Room Type : ");
                                String rtype = sc1.next();
                                System.out.print("\nEnter No of Beds : ");
                                int rnoofbeds = sc1.nextInt();
                                System.out.print("\nEnter Price for FB : Rs.");
                                double rprice = sc1.nextDouble();

                                FileWriter w=new FileWriter("rooms.txt",true);
                                w.write(rid+","+rtype +","+rnoofbeds+","+rprice+","+"Available\n");
                                w.close();
                                System.out.println("New Room Saved.");
                                System.out.println("---------------\n\n");
                        }
                       catch(IOException e){

                            System.out.println(e.getMessage());
                        }


    }

}