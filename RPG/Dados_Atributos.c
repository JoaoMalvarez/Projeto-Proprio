#include <stdio.h>

void atributos(int f, int vi, int ve, int inte, int p, int inst) {
    int esc = 0;
    printf("1. Força = %d\n2. Vigor = %d\n3. Velocidade = %d\n4. Intelecto = %d\n5. Presença = %d\n6. Instinto = %d\n");
    printf("Para ver um de seus sub atributos, digite o numero do atributo principal na qual ele pertence: ");
    printf("(se não, digite 0 para voltar ao menu)");
    scanf("%d", &esc);
    if (esc < 0 || esc > 6) {
        printf("Escolha uma das opções");
        return 1;
    }

    switch (esc) {
    case 1:
        /* força */
        break;
    
    case 2:
        /* vigor */
        break;

    case 3:
        /* velocidade */
        break;

    case 4:
        /* intelecto */
        break;
    
    case 5:
        /* presença */
        break;

    case 6:
        /* instinto */
        break;
    
    default:
        break;
    }
}

int main() {
int força = 0;
int vigor = 1;
int velocidade = 0;
int intelecto = 2;
int presença = 1;
int instinto = 2;


}