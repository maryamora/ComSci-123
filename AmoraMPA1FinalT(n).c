//Code created by: Mary Danielle C. Amora

#include <stdio.h>

int convert(char end[2]){
	int i = 0;
	int place = 1;
	int converted = 0;
	for (; end[i] != '\0'; i++){
		converted = converted * place + end[i] - 48;
		place *= 10;
	}

return converted;
}



void parsing(){
	FILE* in = fopen("sample-test-cases.txt","r");	
	char line[100];
	int i = 1, x = 0, y = 0, flag = 1, whatLabel = 0, c, constant = 0, var = 0;
	char start, end[10] = {'\0', '\0', '\0', '\0','\0','\0','\0','\0','\0','\0'};
	char iteration[2] = {'\0','\0'};
	char valOfIteration;
	char conditionOp;
	char op[20] = {'\0', '\0', '\0', '\0','\0','\0','\0','\0','\0','\0',
	'\0', '\0', '\0', '\0','\0','\0','\0','\0','\0','\0'};
	int numberOfOp = 0;
	/*
	constant is the numbers not repeated while var is the repeated number
	of processes
	*/
	if (in == NULL){
		//do nothing...
	}
	else{
		
		while(fgets(line, sizeof(line), in) != NULL){
		
			if (line[0] == '}' && whatLabel >= 3){ // every end of a for loop
				if (end[0] != '\0'){
					
					//this is for the loops that have numbers in their initializers
					//and conditions, for constant T(n)
					if (conditionOp != '>' && start >= '0' && start <= '9' && end[0] >= '0' && end[0] <= '9' && ((end[1] >= '0') || end[1] == '\0' ) && numberOfOp < 2){
						if (start == '1'){
							printf("T(n) = %i\n",var*convert(end)+constant);
	
						} 
					//this is for the loops that does not have 1 as their initializer
						else if (start != 1){
							printf("T(n) = %i\n",(var*convert(end)) - (start-49)*var +2);
						}
					
					}
					
					//this is for the loops that have variables as conditions
					
					else if ((start >= '0' && start <= '9') && end[0] >= 'a' && end[0] <= 'z' && numberOfOp < 2 && iteration[0] != '-' && iteration[1] != '-'){
						if (start == '1' && (iteration[1] != '=')){
							printf("T(n) = %i%s+%i\n",var,end,constant);
						}
						else if (start > '1' && (iteration[1] != '=')){
							printf("T(n) = %i%s - %i\n",var,end,var*(start-49)+2);
						}
						//this is for the loops that multiply their iteration so that
						//the loop would end faster
						else if (iteration[0] == '*' && start == '1'){
							printf("T(n) = %ilog(%c)%s + %i\n",var,valOfIteration, end, constant);
						}
						
						//variables as initializers and conditions
						else if (iteration[0] == '*' && start != '1'){
							printf("T(n) = %ilog(%c)%s%i\n",var,valOfIteration,end,((-1)*var*(start-49))+constant);
						}
						
						//for loops that have different iterations
						//using different operations (not * or /)
						else if (iteration[0] == '+' && iteration[1] == '=' && start == '1'){
							printf("T(n) = %i%s/%c+%i\n",var,end,valOfIteration,constant);
						}
						else if (iteration[0] == '+' && iteration[1] == '=' && start != '1'){
							printf("T(n) = %i%s/%c%i\n",var,end,valOfIteration,((-1)*(start-49)*var)+2);
						}					
					}
					
						//if the variable before the condition doubles or triples
						if (numberOfOp == 2){
							printf("T(n) = %i sqrt(n) + %i\n",var,constant);
						}
						else if (numberOfOp == 3){
							printf("T(n) = %i cubert(n) + %i\n",var,constant);
						}
					
						//if it iterates forever 
						else if (conditionOp == '<' && iteration[0] == '-' && iteration[1] == '-' && start-48 < convert(end)){
							printf("T(n) = infinite\n");
						}
						
						// if it doesn't enter the loop
						else if (conditionOp == '>'){
							printf("T(n) = %i\n",constant);
						}
						
						//it doesn't enter the loop
						else if (start == 'n'){
						printf("T(n) = %i\n",constant);
						}				
						
						//does not enter the loop
						else if (line[0] == '}' && conditionOp == '>' && start-48 <= convert(end)){
							printf("T(n) = %i\n",constant);
						}
						
					
					if (var != 0 && constant != 0){
						var = 0;
						constant = 0;	
					}
				}
				whatLabel = 0; //for knowing the initializers and conditions
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
			
					//initializer		
					if (whatLabel == 1){
						constant++;
						start = line[x+2];
						for (; line[x] != ' ' && line[x] != '\0'; x++);	
					}
					
					//condition
					else if (whatLabel == 2){
						numberOfOp = 0;
						
						for (c = x-2, y = 0; line[c] != '\0' && line[c] != ';'; c++, y++){
							op[y] = line[c];
							if (op[y] == 'i'){
								numberOfOp++;
							}
							if (op[y] == '<' || op[y] == '>'){
								conditionOp = line[c];
							}
						}	
						c = x;
						for (; line[c] != ' ' && line[c] != '\0';c++);
						c++;
						end[0] = line[c];
						if (line[c+1] == ' ' || line[c+1] == ';'){
							end[1] = '\0';
						}
						else{
							end[1] = line[c+1];
						}
						var++;
						constant++;
						for (; line[x] != ' ' && line[x] != '\0'; x++);
					}
					//iteration and processes	
					else if (whatLabel >= 3){
						var++;
						if (whatLabel == 3){
							iteration[0] = line[x];
							iteration[1] = line[x+1];
							valOfIteration = line[x+3];
						}
						for (; line[x] != ' ' && line[x] != '\0'; x++);
						
					}
				
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
