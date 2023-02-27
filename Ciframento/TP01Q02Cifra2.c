#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

bool isFim(char string[]){
        return (string[0] == 'F' && string[1] == 'I' && string[2] == 'M');
}

int tamanhoString (char *string){
    int tamanho = 0;
    while(string[tamanho] != '\0'){
        tamanho++;
    }
    return tamanho;
}

char cifrar (char caractere){
    char cifra;
        cifra = cifra + 'A' + ('A' - caractere + 3)%26;
    return cifra;
}

int main(){
    char string[1000] = "";
        do{
            scanf(" %[^\n]", string);
            for (int i = 0; i < tamanhoString(string); i++){
                printf("%c", cifrar(string[i]));
            }
            printf("\n");
        }while(isFim(string) == false);
}