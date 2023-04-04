#include <stdio.h>
#include <string.h>


int main () {
   const char haystack[20] = "TutorialsPoint";
   const char needle[10] = "Point";
   char *ret;

   ret = strstr(haystack, needle);

   printf("The substring is: %s\n", ret);
       //tmp/personagens/BenQuadinaros.txt
    //virgulas, aspas simples
    
    /*for(int i = 0; i < 26; i++){
        if(textoDoTxT[i] == ':'){
            aux = i;
            for(int k = aux; k < strlen(textoDoTxT); k++){
                    //printf("%c", textoDoTxT[k]);
                if(textoDoTxT[k] != 39 && textoDoTxT[k+1] != ','){
                    temp[j] = textoDoTxT[k];
                    j++;
                }
            }

        }
    }*/
   return(0);
}