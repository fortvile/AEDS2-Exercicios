#include <stdio.h>

int main(){
    char *matricula = "740026\t";


    FILE *fp;
    fp = fopen("radix_matricula.txt", "w");
    fprintf(fp, "%s", matricula);
    /*fwrite(&comparacoes, sizeof(int), 1, fp);
    fwrite(&movimentacoes, sizeof(int), 1, fp);*/

    fclose(fp);
}