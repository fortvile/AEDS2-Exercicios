import java.util.Scanner;

public class sobrenomeNaoEhFacil {
    private String nome;
    private boolean facil;
    
    sobrenomeNaoEhFacil() {
        this.nome = null;
        this.facil = false;
    }
    
    sobrenomeNaoEhFacil(String nome) {
        this.nome = nome;
        this.facil = false;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return(this.nome);
    }
    
    public boolean isConsoante(char c) {
        boolean result = true;
        
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            result = false;
        }
        return(result);
    }
    
    public boolean isFacil() {
        String tmp = getNome(); int count_aux = 0; int count = 0; boolean result = true;
        tmp = tmp.toUpperCase(); // transformando a string em uppercase para facilidade nos testes de isConsoante
        for(int i = 0; i < tmp.length(); i++) {
            if(isConsoante(tmp.charAt(i))) {
                count_aux++; // contando caso consoante
            } else {
                count_aux = 0;
            }
            
            if(count_aux == 3) {
                count = 3;
            }
        }
        // testando condicoes para nome dificil
        if(count >= 3) {
            result = false;
        }
        
        return(result);
    }
    
    public void saida() {
        if(isFacil()) {
            System.out.println(getNome() + " eh facil");
        } else {
            System.out.println(getNome() + " nao eh facil");
        }
    }
    
    public static void main(String[] args) {
        sobrenomeNaoEhFacil warmup = new sobrenomeNaoEhFacil();
        String str;
        Scanner nome = new Scanner(System.in);
        
        while(nome.hasNextLine()) {
            str = nome.nextLine();
            warmup.setNome(str);
            warmup.saida();
        }
        
        nome.close();
    }
}