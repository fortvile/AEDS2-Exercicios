#include <stdio.h>

int main(){

  struct Personagem //Tipo de dado
  {
    char nome[50];
    int altura;
    float peso;
    char corDoCabelo[50];
    char corDaPele[50];
    char corDosOlhos[50];
    char anoNasicmento[50];
    char genero[50];
    char homeworld[50];
  };    //Definição da Struct

  struct Personagem personagem;

  printf("\n----------------Cadastro do Personagem----------------\n\n\n");

  printf("Digite o nome do personagem:....");
  fgets(personagem.nome, 50, stdin);

  printf("Digite a altura do personagem:....");
  scanf("%d", &personagem.altura);

  printf("Digite o peso do personagem:....");
  scanf("%f", &personagem.peso);

  printf("\n\n-------------Lendo os Dados da Struct-----------------\n\n");
  printf("Nome do personagem: .......... %s\n", personagem.nome);
  printf("Nome do personagem: .......... %d\n", personagem.altura);
  printf("Nome do personagem: .......... %.2f\n", personagem.peso);


  return 0;
}