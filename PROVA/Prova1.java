import java.util.Arrays;
import java.util.Scanner;

class Prova1 {

    public static int whoIsAlone(String A, int N){
        
        //A = A.replace(" ", "");
        String[] B = A.split(" ");
        int contador = 0;
        int aux = 0;
        int alone = 0;
        int[] C = new int[N];
        //System.out.println(Arrays.toString(B));
        for(int i = 0; i < B.length; i++){
            //System.out.println(B[i]);
            C[i] = Integer.parseInt(B[i]);
        }
        for(int j = 0; j < C.length; j++){
            contador = 0;
            aux = C[j];
            for(int k = 0; k < C.length; k++){
                if(aux == C[k]){
                    //System.out.println("aux eh " + aux + " k " + k + " j " + j);
                    contador++;
                }
            }
            if(contador % 2 != 0){
                alone = C[j];
                //System.out.println("alone eh " + alone);
            }
        } 
        
        return alone;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int N = 0;
        String A = "";

        N = scan.nextInt();
        //char [] A = new char[N];
        //char aux;
        while(N != 0){

                //aux = scan.next().charAt(0);
                //A = A + aux;
            A = MyIO.readLine();    
            System.out.println(A);
            System.out.println(whoIsAlone(A, N));
            N = scan.nextInt();
        }

        //System.out.println(A);

        scan.close();
    }
}
