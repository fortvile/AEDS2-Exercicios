import java.util.*;
import java.io.*;
import java.nio.charset.*;

class MyIO {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
    private static String charset = "ISO-8859-1";
 
    public static void setCharset(String charset_){
       charset = charset_;
       in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
    }
 
    public static void print(){
    }
 
    public static void print(int x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(x);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
    
    public static void print(float x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(x);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
    
    public static void print(double x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(x);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
 
    public static void print(String x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(x);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
 
    public static void print(boolean x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(x);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
 
    public static void print(char x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(x);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
 
    public static void println(){
    }
 
    public static void println(int x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.println(x);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
 
    public static void println(float x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.println(x);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
    
    public static void println(double x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.println(x);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
 
    public static void println(String x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.println(x);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
 
    public static void println(boolean x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.println(x);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
 
    public static void println(char x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.println(x);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
 
    public static void printf(String formato, double x){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.printf(formato, x);// "%.2f"
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }
 
    public static double readDouble(){
       double d = -1;
       try{
          d = Double.parseDouble(readString().trim().replace(",","."));
       }catch(Exception e){}
       return d;
    }
 
    public static double readDouble(String str){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(str);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
       return readDouble();
    }
 
    public static float readFloat(){
       return (float) readDouble();
    }
 
    public static float readFloat(String str){
       return (float) readDouble(str);
    }
 
    public static int readInt(){
       int i = -1;
       try{
          i = Integer.parseInt(readString().trim());
       }catch(Exception e){}
       return i;
    }
 
    public static int readInt(String str){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(str);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
       return readInt();
    }
 
    public static String readString(){
       String s = "";
       char tmp;
       try{
          do{
             tmp = (char)in.read();
             if(tmp != '\n' && tmp != ' ' && tmp != 13){
                s += tmp;
             }
          }while(tmp != '\n' && tmp != ' ');
       }catch(IOException ioe){
          System.out.println("lerPalavra: " + ioe.getMessage());
       }
       return s;
    }
 
    public static String readString(String str){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(str);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
       return readString();
    }
 
    public static String readLine(){
       String s = "";
       char tmp;
       try{
          do{
             tmp = (char)in.read();
             if(tmp != '\n' && tmp != 13){
                s += tmp;
             }
          }while(tmp != '\n');
       }catch(IOException ioe){
          System.out.println("lerPalavra: " + ioe.getMessage());
       }
       return s;
    }
 
    public static String readLine(String str){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(str);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
       return readLine();
    }
 
    public static char readChar(){
       char resp = ' ';
       try{
          resp  = (char)in.read();
       }catch(Exception e){}
       return resp;
    }
 
    public static char readChar(String str){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(str);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
       return readChar();
    }
 
    public static boolean readBoolean(){
       boolean resp = false;
       String str = "";
 
       try{
          str = readString();
       }catch(Exception e){}
 
       if(str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") || 
             str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")){
          resp = true;
             }
 
       return resp;
    }
 
    public static boolean readBoolean(String str){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(str);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
       return readBoolean();
    }
 
    public static void pause(){
       try{
          in.read();
       }catch(Exception e){}
    }
 
    public static void pause(String str){
       try {
          PrintStream out = new PrintStream(System.out, true, charset);
          out.print(str);
       }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
       pause();
    }
 }
class Mergesort{

    public static boolean isMenor(Duendes i, Duendes j){
        boolean resultado = false;
        if(i.getIdade() < j.getIdade()){
            resultado = true;
        }
        else if(i.getIdade() == j.getIdade()){
            if(i.getNome().compareTo(j.getNome()) < 0){
                resultado = true;
            }
        }
        return resultado;

    }

    public static void sort(Duendes array[]) {
        mergesort(array, 0, array.length-1);
    }

    public static void mergesort(Duendes array[], int esq, int dir) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergesort(array, esq, meio);
            mergesort(array, meio + 1, dir);
            intercalar(array, esq, meio, dir);
        }
    }

    public static void intercalar(Duendes array[], int esq, int meio, int dir) {
        Duendes novo[] = new Duendes[dir - esq + 1];
        int i = esq;
        int j = meio + 1;
        int pos = 0;
         //ORDENA DE MENOR PARA MAIOR, SE QUISER ORDENAR DE MAIOR PARA MENOR É SÒ TROCAR O SINAL < para >
        while (i <= meio && j <= dir)
            novo[pos++] = (isMenor(array[i], array[j])) ? array[i++] : array[j++];
        while (i <= meio)
            novo[pos++] = array[i++];
        while (j <= dir)
            novo[pos++] = array[j++];
        pos = 0;
        while(esq < dir)
            array[esq++] = novo[pos++];
    }
}
class Selecao {

    public static void sort(Duendes[] duendes, int size) {
        int n = size;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (duendes[j].getIdade() < duendes[minIndex].getIdade()) {
                    minIndex = j;
                }
            }
            Duendes temp = duendes[minIndex];
            duendes[minIndex] = duendes[i];
            duendes[i] = temp;
        }
    }
}

class Times extends Duendes{
    public int N;


}


class Duendes{

    private String nome;
    private int idade;


    //CONSTRUTORES - INICIO
    public Duendes(){
        nome = "";
        idade = 0;
    }

    public Duendes(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    //CONSTRUTORES - FIM

    //SET E GET
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return this.idade;
    }
    //FIM SET E GET


    //PARSING
    public static String parseNome(String DuendesLista){
        String[] atributos = DuendesLista.split(" ");
        return atributos[0];
    }

    public static int parseIdade(String DuendesLista){
        int parsedIdade = 0;
        String[] atributos = DuendesLista.split(" ");
        parsedIdade = Integer.parseInt(atributos[1]);
        return parsedIdade;
    }
    //FIM PARSING

    public static void main(String[] args)throws Exception{

        int N = 0;

        N = MyIO.readInt();

        //System.out.println(N);

        String[] DuendesLista = new String[N];
        for(int i = 0; i < N; i++){
            DuendesLista[i] = MyIO.readLine();
        }


        Duendes duendes[] = new Duendes[N];

        System.out.println("\n");

        //CADASTRANDO DUENDES
        for(int i = 0; i < N; i++){
            duendes[i] = new Duendes();
            duendes[i].setNome(parseNome(DuendesLista[i]));
            System.out.println(duendes[i].getNome());
            duendes[i].setIdade(parseIdade(DuendesLista[i]));
            System.out.println(duendes[i].getIdade());
        }
        
        System.out.println("\n");

        Selecao.sort(duendes, N);

        for(int i = 0; i < N; i++){
            //duende[i] = new Duendes();
            //duende[i].setNome(parseNome(DuendesLista[i]));
            System.out.println(duendes[i].getNome());
            //duende[i].setIdade(parseIdade(DuendesLista[i]));
            System.out.println(duendes[i].getIdade());
        }

        //CRIANDO TIMES
        //ArrayList <String> times = new ArrayList<>();
        //Times time[] = new Times[N/3];

        System.out.println("\n");
        int times = N/3;

        for(int i = 0; i < times; i++){
            System.out.println("Time " + (i + 1));
            for(int k = i; k < N; k+=times){
                System.out.println(duendes[k].getNome() + " " + duendes[k].getIdade());
            }
            System.out.println("");
        }
    }
}