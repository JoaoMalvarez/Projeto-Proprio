#include <stdio.h>

void atributos(int f, int vi, int ve, int inte, int p, int inst) {

}

int main() {
    printf("Bem vindo ao salão do jogador, por favor selecione uma das opções: \n");
    printf("--Menu--\n");
    printf("1. Ver seus atributos\n2. Ver seu poder\n3. Ver sua ficha\n");
    int escolha = 0;
    scanf("%d", &escolha);

    if (escolha < 1 || escolha > 3) {
        /* return erro; */
        printf ("Escolha um número possível.");
        return 0;
    }

    switch (escolha) {
    case 1:
        /* return atributos */
        break;
    
    case 2:
        /* return poder */
        break;

    case 3:
        /* return ficha */
        break;
    
    default:
        break;
    }
}