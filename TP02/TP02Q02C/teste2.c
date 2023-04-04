//@autor: Rafael Pereira Vilefort
//@Matricula: 740026


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef struct //Tipo de dado
  {
    char nome[100];
    int altura;
    float peso;
    char corDoCabelo[100];
    char corDaPele[100];
    char corDosOlhos[100];
    char anoNasicmento[100];
    char genero[100];
    char homeworld[100];
  }Personagem;    //Definição da Struct

/*char* ler(char entrada[]){
    printf("4: %s\n", entrada);
    char line[1000];
    FILE *fptr;
    int i = 0;

    fptr = fopen(entrada, "r");

    if(fptr == NULL){
       printf("Erro ao abrir o arquivo");
        exit(1);
    }

    while ((line[i] = fgetc(fptr)) != EOF && i < 1000-1) {
        i++;
    }

    line[i] = '\0';

    fclose(fptr);

    printf("String read from file: %s\n", line);

}*/

bool isFim(char entrada[]){
    return(strlen(entrada) == 3 && entrada[0] = 'F' && entrada[1] == 'I' && entrada[2] == 'M');
}

int main(){

    char entrada[1000];
    scanf(" %1000[^\n]", entrada);

    printf("1: %s\n", entrada);
    if(entrada[strlen(entrada) - 1] == '\n'){
	entrada[strlen(entrada) - 1] = '\0';
    printf("2: %s\n", entrada);
	}
    while(isFim(entrada) == false){
        printf("3: %s\n", entrada);
        //ler(entrada);

        scanf(" %1000[^\n]", entrada);
        if(entrada[strlen(entrada) - 1] == '\n'){
	    entrada[strlen(entrada) - 1] = '\0';
	}
    }

  return 0;
}