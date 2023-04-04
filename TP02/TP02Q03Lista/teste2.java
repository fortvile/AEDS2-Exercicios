import java.io.File;   
import java.util.Scanner;   

public class teste2 {
    public static void main(String[] args)   
        {
        //String archive = "tmp/personagens/Ackbar.txt";
        String archive = MyIO.readLine();
        String s = "";
        try  
        {  
        File file=new File(archive);   
        Scanner sc = new Scanner(file);     //file to be scanned  
        while (sc.hasNextLine())        //returns true if and only if scanner has another token  
        //System.out.println(sc.nextLine());    
        s = sc.nextLine();
        }  
        catch(Exception e)  
        {  
        e.printStackTrace();  
        }
          System.out.println(s);

        }
}
