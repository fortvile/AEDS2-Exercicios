#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int isFim(char s[])
{
    return (tamanho(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

int tamanho(char *palindromo)
{
    int tam = 0;
    do
    {
        tam++;
    } while (palindromo[tam] != '\0');
    // printf("%d\n", tam);
    return tam;
}

bool isPalindrome(char *palindromo)
{
    int aux = tamanho(palindromo) - 1;
    bool isPal = true;
    for (int i = 0; i < tamanho(palindromo) / 2; i++, aux--)
    {
        if (palindromo[i] != palindromo[aux])
        {
            isPal = false;
            break;
        }
    }
    return isPal;
}

int main(void)
{
    char palindromo[100];
    fgets(palindromo, 1000, stdin);
	setbuf(stdin, NULL);
	if(palindromo[tamanho(palindromo) - 1] == '\n'){
		palindromo[tamanho(palindromo) - 1] = '\0';
	}
    
    // printf("Entre com o palindromo: ");
    while (!(isFim(palindromo)))
    {
        scanf("%s", palindromo);

        bool isPal = isPalindrome(palindromo);
        if (isPal == true)
        {
            printf("SIM");
        }
        else
        {
            printf("NAO");
        }
    }
    // printf("%s\n", palindromo);
}