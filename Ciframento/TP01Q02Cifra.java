class TP01Q02Cifra{

    public static boolean isFim(String str){
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    public static String cifrar (String str){
        String cifrado = "";
        //int tam = str.length();
        for(int i = 0; i < str.length(); i++){
            cifrado = cifrado + (char)(str.charAt(i) + 3);
        }
        return cifrado;
    }
    public static void main (String[] args){
        String str = "";
        do{
        str = MyIO.readLine();
        cifrar(str);
        System.out.println(cifrar(str));
        }while(isFim(str) == false);
    }
}