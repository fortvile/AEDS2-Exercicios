

#include <stdio.h>
#include <string.h>
#include <locale.h>

#define true 1
#define false 0

int palindrome(char s[]){
	int j = strlen(s) - 1;

	for(int i = 0; i < strlen(s); i++, j--){
		if(s[i] != s[j]) return false;
	}
	
	return true;
}

int isFim(char s[]){
	return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

int main(){
	setlocale(LC_ALL,"");

	char str[1000];


	fgets(str, 1000, stdin);
	setbuf(stdin, NULL);
	if(str[strlen(str) - 1] == '\n'){
		str[strlen(str) - 1] = '\0';
	}
	while(!(isFim(str))){
		
		if(palindrome(str)){
			printf("SIM\n");
		}else{
			printf("NAO\n");
		}
	
		fgets(str, 1000, stdin);
		setbuf(stdin, NULL);
		if(str[strlen(str) - 1] == '\n'){
			str[strlen(str) - 1] = '\0';
		}

	} 

	return 0;
}




