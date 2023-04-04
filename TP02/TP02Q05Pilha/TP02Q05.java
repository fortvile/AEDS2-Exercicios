//@author RAFAEL PEREIRA VILEFORT
//MATRICULA: 740026

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Personagem{

    //DECLARAÇÃO DE ATRIBUTOS
    private String nome;
	private int altura;
	private double peso;
	private String corDoCabelo;
	private String codDaPele;
	private String corDosOlhos;
	private String anoNascimento;
	private String genero;
	private String homeworld;
    
    //MÉTODOS GET & SET
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getCorDoCabelo() {
		return corDoCabelo;
	}
	public void setCorDoCabelo(String corDoCabelo) {
		this.corDoCabelo = corDoCabelo;
	}
	public String getCodDaPele() {
		return codDaPele;
	}
	public void setCodDaPele(String codDaPele) {
		this.codDaPele = codDaPele;
	}
	public String getCorDosOlhos() {
		return corDosOlhos;
	}
	public void setCorDosOlhos(String corDosOlhos) {
		this.corDosOlhos = corDosOlhos;
	}
	public String getAnoNascimento() {
		return anoNascimento;
	}
	public void setAnoNascimento(String anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getHomeworld() {
		return homeworld;
	}
	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}

    //CONSTRUTOR PADRÃO
    public Personagem(){
        nome = "";
        altura = 0;
        peso = 0;
        corDoCabelo = "";
        codDaPele = "";
        corDosOlhos = "";
        anoNascimento = "";
        genero = "";
        homeworld = "";
    }

    //CONSTRUTOR COM PARAMETROS
    public Personagem(String nome, int altura, double peso, String corDoCabelo, String codDaPele, String anoNascimento, String genero, String homeworld){
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.corDoCabelo = corDoCabelo;
        this.codDaPele = codDaPele;
        this.anoNascimento = anoNascimento;
        this.genero = genero;
        this.homeworld = homeworld;

    }

    //MÉTODO CLONE
    public Personagem clone() {

        Personagem personagem = new Personagem();

        personagem.nome = this.nome;
        personagem.altura = this.altura;
        personagem.peso = this.peso;
        personagem.corDoCabelo = this.corDoCabelo;
        personagem.corDosOlhos = this.corDosOlhos;
        personagem.anoNascimento = this.anoNascimento;
        personagem.genero = this.genero;
        personagem.homeworld = this.homeworld;

        return personagem;
    }

    //MÉTODO IMPRIMIR
    public void imprimir(){
        if(this.peso - (int)this.peso == 0){
        MyIO.println(" " + "##" + ' ' + this.nome + ' ' + "##" + ' ' + this.altura + ' ' + "##" + ' ' + (int)this.peso + ' ' + "##" + ' ' + this.corDoCabelo
        + ' ' + "##" + ' ' + this.codDaPele + ' ' + "##" + ' ' + this.corDosOlhos + ' ' + "##" + ' ' + this.anoNascimento + ' ' + "##" + ' '
        + this.genero + ' ' + "##" + ' ' + this.homeworld + ' ' + "##" + " ");
        }
        else{
         MyIO.println(" " + "##" + ' ' + this.nome + ' ' + "##" + ' ' + this.altura + ' ' + "##" + ' ' + this.peso + ' ' + "##" + ' ' + this.corDoCabelo
        + ' ' + "##" + ' ' + this.codDaPele + ' ' + "##" + ' ' + this.corDosOlhos + ' ' + "##" + ' ' + this.anoNascimento + ' ' + "##" + ' '
        + this.genero + ' ' + "##" + ' ' + this.homeworld + ' ' + "##" + " ");
        }
    }

    public String toString(){
        if(this.peso - (int)this.peso == 0){
        return(" " + "##" + ' ' + this.nome + ' ' + "##" + ' ' + this.altura + ' ' + "##" + ' ' + (int)this.peso + ' ' + "##" + ' ' + this.corDoCabelo
        + ' ' + "##" + ' ' + this.codDaPele + ' ' + "##" + ' ' + this.corDosOlhos + ' ' + "##" + ' ' + this.anoNascimento + ' ' + "##" + ' '
        + this.genero + ' ' + "##" + ' ' + this.homeworld + ' ' + "##" + " ");
        }
        else{
         return(" " + "##" + ' ' + this.nome + ' ' + "##" + ' ' + this.altura + ' ' + "##" + ' ' + this.peso + ' ' + "##" + ' ' + this.corDoCabelo
        + ' ' + "##" + ' ' + this.codDaPele + ' ' + "##" + ' ' + this.corDosOlhos + ' ' + "##" + ' ' + this.anoNascimento + ' ' + "##" + ' '
        + this.genero + ' ' + "##" + ' ' + this.homeworld + ' ' + "##" + " ");
        }
    }
    
    //MÉTODO PARA OBTER NOME
    public String obterNome(String nome){
        String resultado = "";
        for(int i = 0; i < nome.length(); i++){
            if(nome.charAt(i) != 39 && nome.charAt(i) != 123 && nome.charAt(i) != 125 && nome.charAt(i) != 58 && nome.charAt(0) != 44
            && nome.charAt(0) != 240){
                resultado = resultado + nome.charAt(i);
            }
        }
        //remove a palavra 'name' e espaços em brancos que sobrarem;
        resultado = resultado.replace("name", "");
        resultado = resultado.trim();
        return resultado;
        //System.out.println(resultado);
    }

    //MÉTODO PARA OBTER ALTURA
    public int obterAltura(String altura){
        String resultado = "";
        for(int i = 0; i < altura.length(); i++){
            if(altura.charAt(i) != 39 && altura.charAt(i) != 123 && altura.charAt(i) != 125 && altura.charAt(i) != 58 && altura.charAt(0) != 44
            && altura.charAt(0) != 240){
                resultado = resultado + altura.charAt(i);
            }
        }
        //Remove a palavra 'height' e espaços em brancos que sobrarem
        resultado = resultado.replace("height", "");
        resultado = resultado.trim();
        //Faz o parsing de String para Int
        if(resultado.equals("unknown")){
            return 0;
        }
        int parsedResult = Integer.parseInt(resultado);
        //System.out.println(resultado);
        return parsedResult;
    }

    //MÉTODO PARA OBTER PESO
    public double obterPeso(String peso){
        String resultado = "";

        for(int i = 0; i < peso.length(); i++){
            if(peso.charAt(i) != 39 && peso.charAt(i) != 123 && peso.charAt(i) != 125 && peso.charAt(i) != 58 && peso.charAt(0) != 44
            && peso.charAt(i) != 240){
                resultado = resultado + peso.charAt(i);
            }
        }

        //Remove a palavra mass e espaços em brancos
        resultado = resultado.replace("mass", "");
        resultado = resultado.replace(",", "");
        resultado = resultado.trim();
        if(resultado.equals("unknown")){
            return 0;
        }
        
        double parsedResult = Double.parseDouble(resultado);

        return parsedResult;
        
    }

    //MÉTODO PARA OBTER COR DO CABELO
    public String obterCorDoCabelo(String corDoCabelo){
        String resultado = "";

        for(int i = 0; i < corDoCabelo.length(); i++){
            if(corDoCabelo.charAt(i) != 39 && corDoCabelo.charAt(i) != 123 && corDoCabelo.charAt(i) != 125 && corDoCabelo.charAt(i) != 58 && corDoCabelo.charAt(i) != 240){
                resultado = resultado + corDoCabelo.charAt(i);
            }
        }
        //Remover a palavra hair_color e espaços em brancos
        resultado = resultado.replace("hair_color", "");
        resultado = resultado.trim();
        return resultado;
    }

    //MÉTODO PARA OBTER COR DA PELE
    public String obterCorDaPele(String corDaPele){
        String resultado = "";

        for(int i = 0; i < corDaPele.length(); i++){
            if(corDaPele.charAt(i) != 39 && corDaPele.charAt(i) != 123 && corDaPele.charAt(i) != 125 && corDaPele.charAt(i) != 58 && corDaPele.charAt(0) != 44 && corDaPele.charAt(i) != 240){
                resultado = resultado + corDaPele.charAt(i);
            }
        }
        //Remover a palavra hair_color e espaços em brancos
        resultado = resultado.replace("skin_color", "");
        resultado = resultado.trim();
        return resultado;
    }

    //MÉTODO PARA OBTER COR DA PELE
    public String obterCorDosOlhos(String corDosOlhos){
        String resultado = "";

        for(int i = 0; i < corDosOlhos.length(); i++){
            if(corDosOlhos.charAt(i) != 39 && corDosOlhos.charAt(i) != 123 && corDosOlhos.charAt(i) != 125 && corDosOlhos.charAt(i) != 58 && corDosOlhos.charAt(i) != 240){
                resultado = resultado + corDosOlhos.charAt(i);
            }
        }
        //Remover a palavra eye_color e espaços em brancos
        resultado = resultado.replace("eye_color","");
        resultado = resultado.trim();

        return resultado;
    }

    //MÉTODO PARA OBTER ANO DE NASCIMENTO
    public String obterAnoNascimento(String anoNascimento){
        String resultado = "";

        for(int i = 0; i < anoNascimento.length(); i++){
            if(anoNascimento.charAt(i) != 39 && anoNascimento.charAt(i) != 123 && anoNascimento.charAt(i) != 125 && anoNascimento.charAt(i) != 58 && anoNascimento.charAt(i) != 44 && anoNascimento.charAt(i) != 240){
                resultado = resultado + anoNascimento.charAt(i);
            }
        }
        //Remover a palavra birth_year e espaços em brancos
        resultado = resultado.replace("birth_year","");
        resultado = resultado.trim();

        return resultado;
    }

    //MÉTODO PARA OBTER GENERO
    public String obterGenero(String genero){
        String resultado = "";

        for(int i = 0; i < genero.length(); i++){
            if(genero.charAt(i) != 39 && genero.charAt(i) != 123 && genero.charAt(i) != 125 && genero.charAt(i) != 58 && genero.charAt(0) != 44 && genero.charAt(i) != 240){
                resultado = resultado + genero.charAt(i);
            }
        }
        //Remover a palavra "gender" e espaços em brancos
        resultado = resultado.replace("gender", "");
        resultado = resultado.trim();

        return resultado;
    }

    //MÉTODO PARA OBTER HOMEWORLD
    public String obterHomeworld(String homeworld){
        String resultado = "";

        for(int i = 0; i < homeworld.length(); i++){
            if(homeworld.charAt(i) != 39 && homeworld.charAt(i) != 123 && homeworld.charAt(i) != 125 && homeworld.charAt(i) != 58 && homeworld.charAt(0) != 44 && homeworld.charAt(i) != 240){
                resultado = resultado + homeworld.charAt(i);
            }
        }
        resultado = resultado.replace("homeworld", "");
        resultado = resultado.trim();
        return resultado;
    }

    //MÉTODO TRATAR TEXTO
    public void tratarTexto(String textoDaEntrada){
        String atributos[] = textoDaEntrada.split("',");
        //System.out.println(Arrays.toString(atributos));
        //O vetor de Strings de posições 0 a 8 possuem informações relevantes para a resolução da questão
        this.nome = obterNome(atributos[0]);
        this.altura = obterAltura(atributos[1]);
        this.peso = obterPeso(atributos[2]);
        this.corDoCabelo = obterCorDoCabelo(atributos[3]);
        this.codDaPele = obterCorDaPele(atributos[4]);
        this.corDosOlhos = obterCorDosOlhos(atributos[5]);
        this.anoNascimento = obterAnoNascimento(atributos[6]);
        this.genero = obterGenero(atributos[7]);
        this.homeworld = obterHomeworld(atributos[8]);

    }

    //MÉTODO LER
    public void ler(String entrada) throws FileNotFoundException{
      
        //Atualizar a entrada, de forma a remover o '/' do inicio que estava causando problemas
        //entrada = entrada.substring(1, entrada.length());

        
        BufferedReader input = new BufferedReader(new FileReader(entrada));

        String textoDaEntrada = "";

            try  
            {     
            textoDaEntrada = input.readLine();
            }   //arquivo para ser lido
            catch(Exception e)  
            {  
            e.printStackTrace();  
            }
            //Verificar texto da entrada:
          //System.out.println(textoDaEntrada);
          tratarTexto(textoDaEntrada);
    }

}

class Pilha{
    public Personagem[] personagens;
    public int topo;

    public Pilha(){
        this(86);
    }

    public Pilha(int tamanho){
        personagens = new Personagem[86];
        topo = -1;
    }

    public void inserir(Personagem x){
        if(topo == personagens.length - 1){
            throw new RuntimeException("A pilha está cheia!");
        }
        else{
            personagens[++topo] = x;
            //mesma coisa que:
            //topo++;
            //personagens[topo] = x;
        }
    }

    public Personagem remover(){

            Personagem personagemRemovido = personagens[topo];
            topo--;
            //System.out.println("Elemento removido: " + elementoRemovido);

            return personagemRemovido;
    }

    public void mostrar(){
        if(topo == -1){
            System.out.println("A pilha está vazia");
        }
        for (int i = topo; i >= 0; i--) {
            System.out.println(personagens[i]);
        }
    }

}

public class TP02Q05{

    public static boolean isFim(String entrada)throws Exception{
        return(entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
    }
    public static void main(String[] args) throws Exception{
        //Para ler aqueles a caracteres inuteis que só servem para travar o programa
        MyIO.setCharset("utf-8");

        //Criando objeto da classe Personagem
        Personagem personagens[] = new Personagem[86];
        int i = 0;



       /*
       //BRINCANDO COM O SEGUNDO CONSTRUTOR QUE EU FIZ, FAZENDO TESTES ETC;  
        Personagem personagem2 = new Personagem();
        personagem2.setNome("Darth Vader");
        //personagem2 = new Personagem("Darth Vader", 180, 70, "", "white", "48BBY", "Male", "Tatooine" );
        MyIO.println("this is " + personagem2.getNome());
        personagem2.imprimir();
        */

        Pilha pilha = new Pilha();

        //Lendo pela primeira vez antes de mandar para o while
        String entrada = "";
        entrada = MyIO.readLine();
        while(isFim(entrada) == false){
            //Isso tira o '/' iniciar do /tmp/personagens/DarthVader.txt mas só serve no windows
            //entrada = entrada.substring(1, entrada.length());
            personagens[i] = new Personagem();
            personagens[i].ler(entrada);
            pilha.inserir(personagens[i]);
            entrada = MyIO.readLine();
            i++;
        }

        int N = 0;
        N = MyIO.readInt();

        String entrada2 = "";
        try{
        entrada2 = MyIO.readLine();
        }catch(Exception e){
            e.printStackTrace();
        }
        for(int k = 0; k < N; k++){
            String separar[] = entrada2.split(" ");
            Personagem PersonagemAux = new Personagem();
            switch(separar[0]){
                case "I":
                //separar[1] = separar[1].substring(1, separar[1].length());
                PersonagemAux.ler(separar[1]);
                pilha.inserir(PersonagemAux);
                //System.out.println(PersonagemAux.getNome());
                break;     
                case "R":
                System.out.println("(R) " + pilha.remover().getNome());
                break;
            }

            try{
                entrada2 = MyIO.readLine();
                }catch(Exception e){
                    e.printStackTrace();
                }
        }

        /*for (int i = topo; i >= 0; i--) {
            System.out.println(personagens[i]);
        }*/
        //System.out.println(pilha.personagens[pilha.topo-1].toString());

        for(int j = 0; j <= pilha.topo; j++){
            System.out.println("[" + j + "]" + " " + pilha.personagens[j].toString());
        }

    }
}