//@autor: Rafael Pereira Vilefort
//@Matricula: 740026



#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
// Prototipação:
bool isFim(char s[]);
char* encontrar(char* textoDoTxT, char* chave);
char* mySubString(char* entrada, int beginIndex, int endOfString);
int parseInt(char* textoDoTxT);
double parseDouble(char* textoDoTxT);
char* lerArquivo(char* entrada);
//

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
Personagem* new_Personagem(char* nome, int altura, double peso, char* corDoCabelo, char *corDaPele, char* corDosOlhos, char* anoNascimento, char* genero, char* homeworld ){
    
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

    return personagem;
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
    return p->altura;
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
Personagem* ler(char* entrada){

    Personagem* p = NULL;
    char *textoDoTxT = (char*)(calloc(1001,sizeof(char)));
    textoDoTxT = lerArquivo(entrada);
    //puts(entrada);
    //PEGA A entrada e FORMATA TIRANDO o \0 eu acho
    char* EntradaFormatada = mySubString(entrada, 0, strlen(entrada) - 1);
    //puts(entrada);

    p = new_Personagem(encontrar(textoDoTxT,"name"), parseInt(encontrar(textoDoTxT,"height")), parseDouble(encontrar(textoDoTxT,"mass")), encontrar(textoDoTxT,"hair_color"), encontrar(textoDoTxT,"skin_color"),
       encontrar(textoDoTxT,"eye_color"), encontrar(textoDoTxT,"birth_year"), encontrar(textoDoTxT,"gender"), encontrar(textoDoTxT,"homeworld"));
    //printf("altura %d\n", parseInt(encontrar(textoDoTxT,"height")));
    //puts(textoDoTxT);
    //printf("String read from file: %s\n", line);
    //free(textoDoTxT);
    return p;
}
void imprimir(Personagem* p){
    printf(" ## %s ## %d ## %lg ## %s ## %s ## %s ## %s ## %s ## %s ## \n", getNome(p), getAltura(p), getPeso(p), getCorDoCabelo(p), getCorDaPele(p), getCorDosOlhos(p), 
    getAnoNascimento(p), getGenero(p), getHomeworld(p));
}
char* encontrar(char* textoDoTxT, char* chave){

    char* result, *found;
    int indexOfKeyValue = 0;


    found = strstr(textoDoTxT, chave);
    //printf("found %d\n indexOfKeyValue%d\n", found-textoDoTxT, (found - textoDoTxT) + strlen(chave) + 2);
    //puts(mySubString(textoDoTxT, 10, 16));
    //printf("%c\n", textoDoTxT[10]);
    if(found != NULL){
        indexOfKeyValue = (found - textoDoTxT) + strlen(chave) + 4;
        int endOfKeyValue = indexOfKeyValue + 1;
            //printf("indexOfKeyValue %d\n", indexOfKeyValue);
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
    for(int i = 0; beginIndex + i < endOfString; i++){
        newStr[i] = textoDoTxT[beginIndex + i];
    }
    //printf("beginIndex%d\nendOfString%d\n", beginIndex, endOfString);
    //puts(newStr);
    return newStr;
}
int parseInt(char* result){
    long int i = 0;
    /*char parseResult[50];
    
    for(i = 0; i < strlen(result); i++){
        if(result[i] != ',' && result[i] != '.'){
            parseResult[i] = result[i];
        }
    }
    parseResult[i+1] = '\0';
    */
    /*char* cursor = result;
    long int sum = 0;
    long int i = 0;
    while(cursor != result + strlen(result)){
        i =  strtol(cursor, &cursor, 10);
    }
    //printf("%d\n", i);*/
    i = atoi(result);
    return i;
}
double parseDouble(char* result){
    //int i = 0;
    double f = 0;
    /*char parseResult[50];
    for(i = 0; i < strlen(result); i++){
        if(result[i] != ',' && result[i] != '.'){
            parseResult[i] = result[i];
        }
    }
    parseResult[i+1] = '\0';*/
    
    f = atof(result);

    return f;
}

bool isFim(char s[]){
    return (s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

char* lerArquivo(char* entrada){

    //printf("%s\n", entrada);

    char line[10000];
    char* ptr = line; 
    FILE *fptr;
    int i = 0;

    //char* aux = mySubString(entrada, 0, strlen(entrada)-1);
        //fptr = fopen(aux, "r");
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
    //printf("%s\n", ptr);
    return ptr;
}

int main(){

    Personagem* p1;

    /*char* entrada = (char*)calloc(51,sizeof(char));
    fgets(entrada, 50, stdin);*/


    char entrada[1000];
    scanf(" %1000[^\n]", entrada);

     //printf("\n\n\n");
    while(isFim(entrada) == false){

    //printf("%li\n", strlen(entrada));

        p1 = ler(entrada);
        imprimir(p1);

        /*entrada = (char*)calloc(51,sizeof(char));
        fgets(entrada, 50, stdin);*/
        scanf(" %1000[^\n]", entrada);
    }

    return 0;
}