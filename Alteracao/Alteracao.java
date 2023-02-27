import java.util.Random;



class Alteracao{


    public static boolean isFim(String s){
        return(s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String substituir(String entrada, char escolhido, char substituido){

        String substituida = "";

        for(int i = 0; i < entrada.length(); i++){
            if(entrada.charAt(i) == escolhido){
                substituida = substituida + substituido;
            }
            else{
                substituida = substituida + entrada.charAt(i);
            }
        }
        return substituida;
    }

    public static void main(String[] args){

        String entrada = "";

        Random gerador = new Random( ) ;
        gerador.setSeed (4) ;

        char escolhido = (char)('a' + (Math.abs(gerador.nextInt())%26));
        //System.out.println("O char escolhido é: " + escolhido);

        char substituido = (char)('a' + (Math.abs(gerador.nextInt())%26));
        //System.out.println("O char substituido é: " + substituido);

        //Scanner scan = new Scanner(System.in);
        //String entrada = "";
        //entrada = scan.nextLine();


        do{
            entrada = MyIO.readLine();
            MyIO.println(substituir(entrada, escolhido, substituido));
        }while(isFim(entrada) == false);


        //scan.close();

    }
}
