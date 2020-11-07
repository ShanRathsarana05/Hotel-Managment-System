import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LoginHandle{

    public static boolean checkUser(String file1,String username,String password){
       
        FileReader fr1=null;
        BufferedReader br1=null;
        boolean flagU = false;

        
        try{
            fr1=new FileReader(file1);
            
            br1=new BufferedReader(fr1);
            
            String cline=null;
            
            while((cline=br1.readLine())!=null){
                
                String[] arr1=cline.split(",");

                if(arr1[0].equals(username) && arr1[1].equals(password)){

                		System.out.println("\n\t\t\tLoging Successful");
                        System.out.println("----------------------------------------------------------------------------------\n\n");
                		flagU = true;
                        
                	}
                //else{
                		//System.out.println("\t\t\tInvalid Password or Username");
                        //System.out.println("----------------------------------------------------------------------------------\n\n");
                	//}

                }

            if(!flagU){

                    System.out.println("\t\t\tInvalid Username or password");
                    System.out.println("----------------------------------------------------------------------------------\n\n");

            }	

            fr1.close();
            br1.close();
            
            
        }
        catch(Exception e)
        {
            System.err.println("Error : "+e.getMessage());
        }
        return flagU;
        
    }	

}