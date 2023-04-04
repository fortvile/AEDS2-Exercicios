//@author RAFAEL PEREIRA VILEFORT
//MATRICULA: 740026

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
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
class Lista{
    
    public Personagem[] personagens;
    public int n;
    public Integer comparacoes = 0;
 
 
    /**
     * Construtor da classe.
     */
    public Lista () {
       this(86);
    }
 
 
    /**
     * Construtor da classe.
     * @param tamanho Tamanho da lista.
     */
    public Lista (int tamanho){
       personagens = new Personagem[tamanho];
       n = 0;
    }
 
 
    /**
     * Insere um elemento na primeira posicao da lista e move os demais
     * elementos para o fim da lista.
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirInicio(Personagem x) throws Exception {
 
       //validar insercao
       if(n >= personagens.length){
          throw new Exception("Erro ao inserir!");
       } 
 
       //levar elementos para o fim do array
       for(int i = n; i > 0; i--){
          personagens[i] = personagens[i-1];
       }
 
       personagens[0] = x;
       n++;
    }
 
 
    /**
     * Insere um elemento na ultima posicao da lista.
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirFim(Personagem x) throws Exception {
 
       //validar insercao
       if(n >= personagens.length){
          throw new Exception("Erro ao inserir!");
       }
 
       personagens[n] = x;
       n++;
    }
 
 
    /**
     * Insere um elemento em uma posicao especifica e move os demais
     * elementos para o fim da lista.
     * @param x int elemento a ser inserido.
     * @param pos Posicao de insercao.
     * @throws Exception Se a lista estiver cheia ou a posicao invalida.
     */
    public void inserir(Personagem x, int pos) throws Exception {
 
       //validar insercao
       if(n >= personagens.length || pos < 0 || pos > n){
          throw new Exception("Erro ao inserir!");
       }
 
       //levar elementos para o fim do array
       for(int i = n; i > pos; i--){
          personagens[i] = personagens[i-1];
       }
 
       personagens[pos] = x;
       n++;
    }
 
 
    /**
     * Remove um elemento da primeira posicao da lista e movimenta 
     * os demais elementos para o inicio da mesma.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public Personagem removerInicio() throws Exception {
 
       //validar remocao
       if (n == 0) {
          throw new Exception("Erro ao remover!");
       }
 
       Personagem resp = personagens[0];
       n--;
 
       for(int i = 0; i < n; i++){
          personagens[i] = personagens[i+1];
       }
 
       return resp;
    }
 
 
    /**
     * Remove um elemento da ultima posicao da lista.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public Personagem removerFim() throws Exception {
 
       //validar remocao
       if (n == 0) {
          throw new Exception("Erro ao remover!");
       }
 
       return personagens[--n];
    }
 
 
    /**
     * Remove um elemento de uma posicao especifica da lista e 
     * movimenta os demais elementos para o inicio da mesma.
     * @param pos Posicao de remocao.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
     */
    public Personagem remover(int pos) throws Exception {
        //System.out.println(n);
       if (n == 0 || pos < 0 || pos >= n) {
          throw new Exception("Erro ao remover!");
       }
 
       Personagem resp = personagens[pos];
       n--;
 
       for(int i = pos; i < n; i++){
          personagens[i] = personagens[i+1];
       }
 
       return resp;
    }
 
 
    /**
     * Mostra os elementos da lista separados por espacos.
     */
    public void mostrar (){
       System.out.print("[ ");
       for(int i = 0; i < n; i++){
          System.out.print(personagens[i] + " ");
       }
       System.out.println("]");
    }
 
 
    /**
     * Procura um elemento e retorna se ele existe.
     * @param x int elemento a ser pesquisado.
     * @return <code>true</code> se o array existir,
     * <code>false</code> em caso contrario.
     */

    public boolean pesquisar(String nome) {
       boolean retorno = false;
       for (int i = 0; i < n && retorno == false; i++) {
          retorno = (personagens[i].getNome().contentEquals(nome));
          comparacoes++;
       }
       return retorno;
    }
 }

class Insercao {
    public static int contador = 0;

    public static void sort(Personagem[] personagens, int size) {
        
        //System.out.println(personagens[0].getNome());
        int n = size;
        for(int i = 0; i < size; i++){
            //System.out.println(personagens[i].getNome());
        }
            //j >= 0 && Integer.parseInt(personagens[j].getAnoNascimento().substring(0,1)) > Integer.parseInt(key.getAnoNascimento().substring(0,1))
            for (int i = 1; i < n; i++) {
                Personagem key = personagens[i];
                int j = i - 1;
                    while ((j >= 0) && personagens[j].getAnoNascimento().compareTo(key.getAnoNascimento()) > 0) {
                        personagens[j + 1] = personagens[j];
                        contador++;
                        j--;
                    }
                    personagens[j + 1] = key; 
                    contador++;              
            }

    }
}

public class TP02Q11{

    public static boolean isFim(String entrada)throws Exception{
        return(entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M');
    }

    public static long now(){
        return new Date().getTime();
     }

    public static void main(String[] args) throws Exception{
        //Para ler aqueles a caracteres inuteis que só servem para travar o programa
        MyIO.setCharset("utf-8");

        //Criando objeto da classe Personagem
        Personagem personagens[] = new Personagem[86];
        int i = 0;
        int k = 0;
        double inicio = 0, fim = 0;


       /*
       //BRINCANDO COM O SEGUNDO CONSTRUTOR QUE EU FIZ, FAZENDO TESTES ETC;  
        Personagem personagem2 = new Personagem();
        personagem2.setNome("Darth Vader");
        //personagem2 = new Personagem("Darth Vader", 180, 70, "", "white", "48BBY", "Male", "Tatooine" );
        MyIO.println("this is " + personagem2.getNome());
        personagem2.imprimir();
        */

        //Lista lista = new Lista();

        //Lendo pela primeira vez antes de mandar para o while
        String entrada = "";
        entrada = MyIO.readLine();
        while(isFim(entrada) == false){
            //Isso tira o '/' iniciar do /tmp/personagens/DarthVader.txt mas só serve no windows
            //entrada = entrada.substring(1, entrada.length());
            personagens[i] = new Personagem();
            personagens[i].ler(entrada);
            //lista.inserirFim(personagens[i]);
            entrada = MyIO.readLine();
            i++;
        }
        /* 
        Personagem personagensAux1[] = new Personagem[86];
        Personagem personagensAux2[] = new Personagem[86];
        int contador = 0;
        */
        /*
        for(k = 0; k < i; k++){
            if (personagens[k].getAnoNascimento().compareTo("unknown") == 0){
                personagensAux2[k] = personagens[k];
                //System.out.println(personagensAux2[k]);
            }
            else{
                personagensAux1[k] = personagens[k];
                contador++;
                //System.out.println(personagensAux1[k]);
            }
        }
        */

        //System.out.println(contador);
        /*for(int j = 0; j < contador; j++){
            System.out.println(personagensAux1[j].toString());
        }*/
        inicio = now();
        Insercao.sort(personagens, i);
        fim = now();

        for(int j = 0; j < i; j++){
            System.out.println(personagens[j].toString());
        }
        
        try{
        BufferedWriter writer = new BufferedWriter(new FileWriter("matricula_insencao.txt"));
        writer.write("740026\t" + (fim - inicio)/1000.0 + " s.\t" + Insercao.contador);
        writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}