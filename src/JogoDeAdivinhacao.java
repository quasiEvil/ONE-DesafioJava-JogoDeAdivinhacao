/*
Crie um programa que simula um jogo de adivinhação que deve gerar um número aleatório entre 0 e 100
e pedir para que o usuário tente adivinhar o número, em até 5 tentativas.
A cada tentativa, o programa deve informar se o número digitado pelo usuário
é maior ou menor do que o número gerado.
 */

import java.util.Random;
import java.util.Scanner;

public class JogoDeAdivinhacao {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        // O método nextInt gera um número entre 0 (inclusive) e o valor especificado (exclusivo)
        // por isso estou usando 101 para gerar números de 0 a 100

        Scanner scanner = new Scanner(System.in);
        int tries = 1;

        while (tries <= 5) {
            System.out.println("Digite um número entre 0 e 100: ");
            int guess = scanner.nextInt();

            if (guess < 0 || guess > 100) {
                System.out.println("\nPor favor, digite um número entre 0 e 100.");
                continue; // // Pula o restante da iteração do loop e solicita outra entrada ao usuário
            }

            if (randomNumber > guess && tries < 5) {
                System.out.println("\nO número secreto é MAIOR.\n");
            } else if (randomNumber < guess && tries < 5) {
                System.out.println("\nO número secreto é MENOR.\n");
            } else if (guess == randomNumber) {
                System.out.println("\nParabéns! Você adivinhou o número secreto: " + randomNumber);
                return; // Sai do programa (já que o jogo acabou)
            }

            tries++;
        }

        if (tries == 6) {
            System.out.println("\nGameover! Suas tentativas se esgotaram.");
        }
    }
}
