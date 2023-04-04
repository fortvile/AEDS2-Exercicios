import java.io.*;

public class teste {
    public static void main(String args[])
    {  
      
    try  
    {  
    //constructor of the File class having file as an argument  
    FileReader fr=new FileReader("tmp/personagens/Ackbar.txt");   
    System.out.println("file content: ");  
    int r=0;


    while((r=fr.read())!=-1)  
    {

    System.out.print((char)r);  //prints the content of the file   
    }  
    }  
    catch(Exception e)  
    {  
    e.printStackTrace();  
    }  
    }  
}
