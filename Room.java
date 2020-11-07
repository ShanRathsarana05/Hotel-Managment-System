import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Room {
    private int room_no;
    private String room_type;
    private int no_beds;
    double price;
    String status;
    
    public Room(int rn,String rt, int nb, double p){
        this.room_no = rn;
        this.room_type = rt;
        this.no_beds = nb;
        this.price = p;
        this.status = "Available";
    }
    
    public static void viewRooms(String file2){

        FileReader fr2=null;
        BufferedReader br2=null;

        try{
            fr2=new FileReader(file2);
            
            br2=new BufferedReader(fr2);
            
            String cline=null;
            
            while((cline=br2.readLine())!=null){
                
                String[] arr1=cline.split(",");

                if(arr1[4].equals("Available")){
                    System.out.println("\n| Room id : "+arr1[0]);
                    System.out.println("| Room Type : "+arr1[1]);
                    System.out.println("| No of Beds : "+arr1[2]);
                    System.out.println("| Price for FB : Rs."+arr1[3]+"\n");
                    System.out.println("_________________________________________________________\n");
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
    
    public static void confirmRooms(String list){

        String[] arrlist = list.split(",");
        try{
            
            
            FileReader fr = new FileReader("rooms.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter w2 = new FileWriter("updaterooms.txt",true);
            String cline=null;
          for(String s : arrlist){
            while((cline=br.readLine())!=null){
                String[] arr1=cline.split(",");
                if(arr1[0].equals(s)){
                    
                    w2.write(arr1[0]+","+arr1[1]+","+arr1[2]+","+arr1[3]+","+"Available\n");
                }
                else{

                    w2.write(arr1[0]+","+arr1[1]+","+arr1[2]+","+arr1[3]+","+arr1[4]+",\n");
                }
            }
        }
            w2.close();
            Hotel.replaceFile("updaterooms.txt","rooms.txt");                     
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

}