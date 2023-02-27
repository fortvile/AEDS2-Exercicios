import java.util.Scanner;


class Ciframento{

    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) =='F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String cifrar(String entrada){
        String cifrado = "";

        for(int i = 0; i < entrada.length(); i++){
            cifrado = cifrado + (char)(entrada.charAt(i) + 3);
        }

        /* [06/01 22:05] Rafael Pereira Vilefort
no Java, somar um caractere a um inteiro e.g.: o caractere 'a' ao numero inteiro 3, irá resultar em uma string com o numero inteiro correspondente na tabela asc2, no caso o 100 (97 + 3)

[06/01 22:06] Rafael Pereira Vilefort
então para aparecer a letra e não o numero tinha que colocar o (char) em frente ao 100, foi só agora que eu entendi 

 */
        //System.out.println(cifrado.getClass().getName());
        /*int x = 0;
        char z = 'A';
        x = (int)z;
        System.out.println("x = " + x);*/
        return cifrado;

    }
    
    public static void main(String[] args){
        String entrada = "";
        do{
        entrada = MyIO.readLine();
        String cifrada = cifrar(entrada);
        MyIO.println(cifrada);
        }while(isFim(entrada) == false);


    }
}