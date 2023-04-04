import java.util.stream.IntStream;

public class Prova2V2 {

    public static int whoIsAlone(String A, int N){
        j>shell string 
        int result = A.chars().filter(i -> i >= 48 && i <= 57).distinct();
        System.out.println(result);
    }

    public static void main(String[] args){
        int N = 0;
        String A = "";

        N = MyIO.readInt();
        //char [] A = new char[N];
        //char aux;
        while(N != 0){

                //aux = scan.next().charAt(0);
                //A = A + aux;
            A = MyIO.readLine();    
            System.out.println(A);
            System.out.println(whoIsAlone(A, N));
            N = MyIO.readInt();
        }
    }
}
