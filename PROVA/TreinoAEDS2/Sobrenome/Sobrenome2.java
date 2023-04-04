import java.util.*;

public class Sobrenome2 {
    private static boolean isVogal(char letra) {
        letra = Character.toLowerCase(letra);
        return letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u';
    }
    public static boolean isDificil(String s){
        //System.out.println("s is "+ s);
        s = s.toLowerCase();
        boolean result = false;
        char aux = '_';
        int contador = 0;
        for(int i = 0; i < s.length(); i++){
            aux = s.charAt(i);
            //System.out.println(aux);
            if(!isVogal(aux)){
                contador++;
                //System.out.println(contador);
                if(contador == 3){
                    result = true;
                    break;
                }
            }
            else{
                contador = 0;
            }
        }
        //System.out.println(contador);
        return result;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        ArrayList <String> lista = new ArrayList<>();

        int iterator = 0;
        String aux = "";
        while(scan.hasNextLine()){
            aux = scan.nextLine();
            if(aux.equals("break")){
                break;
            }
            lista.add(aux);
            
            //System.out.println(lista);

            iterator++;
        }

        
        for(int i = 0; i < iterator; i++){
            if(isDificil(lista.get(i)) == false){
                System.out.println(lista.get(i) + " eh facil");
            }
            else{
                System.out.println(lista.get(i) + " nao eh facil");
            }
        }


    }
}
