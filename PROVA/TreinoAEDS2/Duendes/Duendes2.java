import java.util.*;

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

    public static String parseNome(ArrayList<String> DuendesLista){
        String[] atributos = DuendesLista.get(0);
        return atributos[0];
    }


    public static void main(String[] args)throws Exception{

        int N = 0;

        N = MyIO.readInt();

        //System.out.println(N);

        ArrayList <String> DuendesLista = new ArrayList<>();
        for(int i = 0; i < N; i++){
            DuendesLista.add(MyIO.readLine());
        }

        Duendes[] duende = new Duendes[N];

        for(int i = 0; i < N; i++){
            duende[i].setNome(parseNome(DuendesLista.get(i)));
            duende[i].setNome(parseNome(DuendesLista.get(i)));
        }


        //System.out.println(duende[0].getNome());

        //System.out.println(duende[0].getNome());
        //System.out.println(duende[1].getIdade());


    
    }
}