#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(){
    int days;
    int start;
    printf("Enter number of days in month: ");
    scanf("%d", &days);
    printf("Enter starting day of the week: ");
    scanf("%d", &start);

    char *weekday[] = {"日","一","二","三","四","五","六"};
    int diary[6][7];
    for(int i = 0; i < 6; i++){
        for(int j = 0; j < 7; j++){
            diary[i][j] = 0;
        }
    }
    int count = 0;
    while(count < days){
        int sum = start + count - 1;
        int x = sum%7;
        int y = sum/7;
        diary[y][x] = count + 1;
        count++;
    }

    for(int i = 0; i < 7; i++){
        printf("%s",weekday[i]);
        printf("   ");
    }printf("\n");
    for(int j = 0; j < 6; j++){
        for(int i = 0; i < 7; i++){
            if(diary[j][i] == 0 && i != 6){
                printf("  ");
                printf("   ");
            }if(diary[j][i] == 0 && i == 6){
                printf("\n");
            }
            if(diary[j][i] != 0 && i != 6){
                if(diary[j][i] < 10){
                    printf("%d ", diary[j][i]);
                    printf("   ");
                }else{
                    printf("%d", diary[j][i]);
                    printf("   ");
                }
            }if(diary[j][i] != 0 && i == 6){
                printf("%d", diary[j][i]);
                printf("\n");
            }
        }
    }
    return 0;
}