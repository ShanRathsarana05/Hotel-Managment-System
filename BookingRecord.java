import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class BookingRecord{
    
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static void booking(){

                        Scanner sc1=new Scanner(System.in);
                        Random rand = new Random();

                        Date currentDate = new Date();
                        System.out.println("Date and Time:-"+dateFormat.format(currentDate)+"\n\n");

                        System.out.print("Enter room id for booking : ");
                        String rid = sc1.next();
                        boolean x=true;



                        try{

                            FileReader fr = new FileReader("rooms.txt");
                            BufferedReader br = new BufferedReader(fr);
                            FileWriter w2 = new FileWriter("updaterooms.txt",true);
                            String cline=null;
                            int y=0;

                            while((cline=br.readLine())!=null){

                                String[] arr1=cline.split(",");
                                

                                if(arr1[0].equals(rid) && arr1[4].equals("Available")){

                                    System.out.println("\n\nEnter your name : ");
                                    String name = sc1.next();
                                    System.out.print("\nEnter your address : ");
                                    String address = sc1.next();
                                    System.out.println("\nEnter your mobile: ");
                                    String mobile = sc1.next();
                                    System.out.println("\nNIC: ");
                                    String nic = sc1.next();
                                    System.out.println("\nCheck-In day:(dd/mm/yyyy)");
                                    String cid = sc1.next();
                                    System.out.println("\nNumber Of Days : ");
                                    int nod = sc1.nextInt();
                                    System.out.println("\nNumber Of Persons : ");
                                    int nop = sc1.nextInt();
                                    int pin = rand.nextInt((9999 - 100) + 1) + 10;

                                    FileWriter w=new FileWriter("bookings.txt",true);
                                    w.write(rid+","+name+","+address+","+mobile+","+nic+","+cid+","+dateFormat.format(currentDate)+","+nod+","+nop+",Unconfirmed,"+pin+"\n");
                                    w.close();
                                    System.out.println("\nBooking Saved.you will recieve a call after confirmation");
                                    System.out.println("----------------------------------------------------------------------------------\n\n");
                                    y=5;
                                    w2.write(rid+","+arr1[1]+","+arr1[2]+","+arr1[3]+","+"Not Available\n");

                                }
                                else{
                                    
                                    w2.write(arr1[0]+","+arr1[1]+","+arr1[2]+","+arr1[3]+","+arr1[4]+"\n");

                                    x=false;
                                    
        
                                }
                            }
                            if(!x && y != 5){

                                System.out.println("\nBooking not Saved.you type invalid id");
                                System.out.println("----------------------------------------------------------------------------------\n\n");
                            
                            }

                            w2.close();
                            Hotel.replaceFile("updaterooms.txt","rooms.txt");                   

                        }
                        catch(IOException e){
                            System.out.println(e.getMessage());
                        }
    }

public static void cancelBooking(String list){

        String[] arrlist = list.split(",");
        int x=0;
        try{
            
            
            FileReader fr = new FileReader("bookings.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter w2 = new FileWriter("updatebookings.txt",true);
            String cline=null;
          for(String s : arrlist){
            while((cline=br.readLine())!=null){
                String[] arr1=cline.split(",");
                if(arr1[0].equals(s)){
                    
                     System.out.print("You Booking details and Room is Cancel\n");
                     System.out.println("-------------------------------------\n\n");
                }
                else{

                    w2.write(arr1[0]+","+arr1[1]+","+arr1[2]+","+arr1[3]+","+arr1[4]+","+arr1[5]+","+arr1[6]+","+arr1[7]+","+arr1[8]+","+arr1[9]+","+arr1[10]+"\n");
                    x=5;
                }
            }
        }
        if(x==5){
            System.out.print("You type invalid Booking\n");
            System.out.println("-----------------------\n\n");
        }
            w2.close();
            Hotel.replaceFile("updatebookings.txt","bookings.txt");                     
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

}