import java.util.*;


class selection{
    public static void sort(int[] array, int tamanho){
        int n = tamanho;
        
        for(int i = 0; i < n-1; i++){
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

    }
}

class Prova2V3{

    /*public static int qtd(int[] vetor, int N, int x){
        int contador = 0;
        for(int i = 0; i < N; i++){
            if(vetor[i] == x){
                contador++;
            }
        }
        return contador;
    }*/

    public static int solitario(int[] vetor, int N){
        int resultado = 0;
        int contador = 0;
        int aux = 0;
        selection.sort(vetor, N);
        for(int i = 0; i < N; i++){
            //System.out.print(vetor[i] + "\t");
            contador = 0;
            aux = vetor[i];
            for(int j = 0 ; j < N; j++){
                if(vetor[j] == aux){
                    contador++;
                }
            }
            if(contador % 2 != 0){
                resultado = vetor[i];
            }


        }
        return resultado;
    }

    public static void main(String[] args){
        int N = 0;
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        while(N != 0){
            int[] vetor = new int[N];
            for(int i = 0; i < N; i++){
                vetor[i] = scan.nextInt();
            }
            solitario(vetor, N);
            System.out.println(solitario(vetor, N));

            N = scan.nextInt();
        }
    }
}