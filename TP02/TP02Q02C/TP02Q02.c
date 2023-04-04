//@autor: Rafael Pereira Vilefort
//@Matricula: 740026



#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct Personagem
{
    char* nome;
    int altura;
    double peso;
    char *corDoCabelo;
    char *corDaPele;
    char *corDosOlhos;
    char *anoNascimento;
    char *genero;
    char *homeworld;
}Personagem;

Personagem* new_Personagem(char *nome, int altura, double peso, char *corDoCabelo, char *corDaPele, char *corDosOlhos, char *anoNascimento, char *genero, char *homeworld ){
    
    Personagem* personagem = (Personagem*)(malloc(sizeof(Personagem)));

    personagem->nome = (char*)calloc((strlen(nome)+1), sizeof(char));
    personagem->nome = nome;

    personagem->altura = altura;
    personagem->peso = peso;


    personagem->corDoCabelo = (char*)calloc((strlen(corDoCabelo)+1), sizeof(char));
    personagem->corDoCabelo = corDoCabelo;

    personagem->corDaPele = (char*)calloc(strlen(corDaPele)+1, sizeof(char));
    personagem->corDaPele = corDaPele;

    personagem->corDosOlhos = (char*)calloc((strlen(corDoCabelo)+1), sizeof(char));
    personagem->corDosOlhos = corDosOlhos;

    personagem->anoNascimento = (char*)calloc((strlen(anoNascimento)+1), sizeof(char));
    personagem->anoNascimento = anoNascimento;

    personagem->genero = (char*)calloc((strlen(genero)+1), sizeof(char));
    personagem->genero = genero;

    personagem->homeworld = (char*)calloc((strlen(homeworld)+1), sizeof(char));
    personagem->homeworld = homeworld;



}

//sets - inicio
bool setNome(Personagem* p, char* nome){
    p->nome = nome;
}
bool setAltura(Personagem* p, int altura){
    p->altura = altura;
}
bool setPeso(Personagem* p, double peso){
    p->peso = peso;
}
bool setCorDoCabelo(Personagem* p, char* corDoCabelo){
    p->corDoCabelo = corDoCabelo;
}
bool setCorDaPele(Personagem* p, char* corDaPele){
    p->corDaPele = corDaPele;
}
bool setCorDosOlhos(Personagem* p, char* corDosOlhos){
    p->corDosOlhos = corDosOlhos;
}
bool setAnoNascimento(Personagem* p, char* anoNascimento){
    p->anoNascimento = anoNascimento;
}
bool setGenero(Personagem* p, char* genero){
    p->genero = genero;
}
bool setHomeworld(Personagem* p, char* homeworld){
    p->homeworld = homeworld;
}
//sets - fim

//gets - inicio
char* getNome(Personagem* p){
    return p->nome;
}
int getAltura(Personagem* p){
    return p->nome;
}
double getPeso(Personagem* p){
    return p->peso;
}
char* getCorDoCabelo(Personagem* p){
    return p-> corDoCabelo;
}
char* getCorDaPele(Personagem *p){
    return p-> corDaPele;
}
char* getCorDosOlhos(Personagem*p){
    return p->corDosOlhos;
}
char* getAnoNascimento(Personagem *p){
    return p->anoNascimento;
}
char* getGenero(Personagem* p){
    return p->genero;
}
char* getHomeworld(Personagem* p){
    return p->homeworld;
}
//gets - fim

Personagem* clone(Personagem* p){
    return new_Personagem(getNome(p), getAltura(p), getPeso(p), getCorDoCabelo(p), getCorDaPele(p), getCorDosOlhos(p), getAnoNascimento(p), getGenero(p), getHomeworld(p));
}

bool isFim(char s[])
{
    return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

char* encontrar(char* textoDoTxT, char* chave){

    char* result, *found;
    int indexOfKeyValue = 0;


    found = strstr(textoDoTxT, chave);

    if(found != NULL){
        indexOfKeyValue = (found - textoDoTxT) + strlen(chave) + 4;
        int endOfKeyValue = indexOfKeyValue + 1;
        while(textoDoTxT[endOfKeyValue] != '\''){
            endOfKeyValue++;
        }
        result = mySubString(textoDoTxT, indexOfKeyValue, endOfKeyValue);
        if((chave = "height") && (result[0] == 'u')){
            result = "0";
        }
        else{
            if((chave == "mass") && (result[0] == 'u')){
                result = "0";
            }
        }
    }

    return result;


}

char* mySubString(char* textoDoTxT, int beginIndex, int endOfString){
    char* newStr = (char*)calloc(strlen(textoDoTxT)+1, sizeof(char));
    for(int i = 0; beginIndex + 1 < endOfString; i++){
        newStr[i] = newStr[beginIndex + i];
    }
    return newStr;
}

char* ler(char entrada[]){

    char line[10000];
    char* ptr = line; 
    FILE *fptr;
    int i = 0;

    fptr = fopen(entrada, "r");

    if(fptr == NULL){
       printf("Erro ao abrir o arquivo");
        exit(1);
    }

    while ((line[i] = fgetc(fptr)) != EOF && i < 10000-1) {
        i++;
    }

    line[i] = '\0';

    fclose(fptr);

    //printf("String read from file: %s\n", line);
    
    return ptr;
}

int main(){

    Personagem* p1;

    char entrada[1000];
    char* textoDoTxT;

    scanf(" %1000[^\n]", entrada);

     //printf("\n\n\n");
    while(!isFim(entrada)){

        textoDoTxT = ler(entrada);
        printf("%s", textoDoTxT);
        encontrar(textoDoTxT);
        scanf(" %1000[^\n]", entrada);
    }

    return 0;
}
