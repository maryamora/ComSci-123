//Code created by: Mary Danielle C. Amora

#include <stdio.h>

void parsing(){
	FILE* in = fopen("sample-test-cases.txt","r");	
	char line[100];
	int i = 1, x = 0, y = 0, flag = 1, whatLabel;
	

	if (in == NULL){
		
	}
	else{
		
		while(fgets(line, sizeof(line), in) != NULL){
		
			//organizing the different for loops
			if (line[0] == 'f' && line[1] == 'o' && line[2] == 'r' && whatLabel >= 3){
				printf("\n");
				whatLabel = 0;
			}
		
		
			for (x = 0; line[x] != '\0'; x++){ //for the different operators
			
				if (line[x] == '=' ||
					line[x] == '+' ||
					line[x] == '-' ||
					line[x] == '*' ||
					line[x] == '/' ||
					line[x] == '%' ||
					line[x] == '>' ||
					line[x] == '<'){
			
					whatLabel++;
					if (whatLabel == 1){
						printf("Initialization: ");
					}
					else if (whatLabel == 2){
						printf("Condition: ");

					}
					else if (whatLabel == 3){
						printf("Processes: ");

					}
				
					//printing
				
					x = x-2;
					for (;line[x] != ' ' && line[x] != '\0'; x--){
					}
					x++;
				
					for (; line[x] != ';' && line[x] != ')' && line[x] != '\0';x++){
						printf("%c",line[x]);
					}
				printf("\n");
				}
			}
			for (x = 0; line[x] != '\0'; x++){
				line[x] = '\0';
			}
		}
	}
}

int main(){
	parsing();
return 0;
}
