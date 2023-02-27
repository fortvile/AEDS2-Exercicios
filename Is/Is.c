#include <stdio.h>
#include <string.h>
#include <locale.h>
#include <stdbool.h>

bool onlyConsoante(char *s)
{
    bool onlyCons = true;
    for (int i = 0; i < strlen(s); i++)
    {
        if ((s[i] == 'a' || s[i] == 'e' || s[i] == 'i' ||
             s[i] == 'o' || s[i] == 'u') ||
            (s[i] == 'A' || s[i] == 'E' || s[i] == 'I' ||
             s[i] == 'O' || s[i] == 'U'))
        {
            onlyCons = false;
            break;
        }
    }

    return onlyCons;
}


bool isFim(char s[])
{
    return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

bool onlyVogais(char *s)
{
    if (onlyConsoante(s) == true)
    {
        return true;
    }
    else
    {
        return false;
    }
}

bool isInt(char s[])
{
    for (int i = 0; i < strlen(s); i++)
    {
        if (s[i] < 48 || s[i] > 57)
            return false;
    }
    return true;
}

bool isFloat(char s[]){
		int count = 0, countChars = 0;
		for(int i = 0; i < strlen(s); i++){
			if(s[i] == 44 || s[i] == 46) count++;
			if(s[i] >= 48 && s[i] <= 57) countChars++;
		}

		if((count == 0 || count == 1) && countChars == strlen(s) - count) return true;
		return false;
    }

int main()
{

    //PODE SER USADO PARA LER
    // scanf("%[^\n]", str);
	// getchar();
    char str[1000];
    char X1[4], X2[4], X3[4], X4[4];

    fgets(str, 1000, stdin);
    setbuf(stdin, NULL);
    if (str[strlen(str) - 1] == '\n')
    {
        str[strlen(str) - 1] = '\0';
    }

    while (!(isFim(str)))
    {

        if (onlyVogais(str) == true)
        {
            strcpy(X1, "SIM");
        }
        else
        {
            strcpy(X1, "NAO");
        }

        if (onlyConsoante(str) == true)
        {
            strcpy(X2, "SIM");
        }
        else
        {
            strcpy(X2, "NAO");
        }

        if (isFloat(str) == true)
        {
            strcpy(X3, "SIM");
        }
        else
        {
            strcpy(X3, "NAO");
        }

        if (isInt(str) == true)
        {
            strcpy(X4, "SIM");
        }
        else
        {
            strcpy(X4, "NAO");
        }

        printf("%s %s %s %s\n", X1, X2, X3, X4);

        fgets(str, 1000, stdin);
        setbuf(stdin, NULL);
        if (str[strlen(str) - 1] == '\n')
        {
            str[strlen(str) - 1] = '\0';
        }
    }
}