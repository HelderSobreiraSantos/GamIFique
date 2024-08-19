package questoes;

import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        GeraPergunta geraPergunta = new GeraPergunta();
        Scanner scanner = new Scanner(System.in);
        
        int acertos = 0;
        int erros = 0;
        
        // Pergunta 1
        Pergunta pergunta1 = geraPergunta.pergunta1();
        System.out.println("ID da Pergunta: " + pergunta1.id);
        System.out.println("Texto da Pergunta: " + pergunta1.perguntaTexto);
        
        System.out.println("A: " + pergunta1.getA().getPerguntas().get("texto"));
        System.out.println("B: " + pergunta1.getB().getPerguntas().get("texto"));
        System.out.println("C: " + pergunta1.getC().getPerguntas().get("texto"));
        System.out.println("D: " + pergunta1.getD().getPerguntas().get("texto"));
        System.out.println("E: " + pergunta1.getE().getPerguntas().get("texto"));
        
        System.out.print("Digite a letra da sua resposta: ");
        String resposta1 = scanner.nextLine().toUpperCase();
        
        boolean acertou1 = false;
        switch (resposta1) {
            case "A":
                acertou1 = (boolean) pergunta1.getA().getPerguntas().get("correta");
                break;
            case "B":
                acertou1 = (boolean) pergunta1.getB().getPerguntas().get("correta");
                break;
            case "C":
                acertou1 = (boolean) pergunta1.getC().getPerguntas().get("correta");
                break;
            case "D":
                acertou1 = (boolean) pergunta1.getD().getPerguntas().get("correta");
                break;
            case "E":
                acertou1 = (boolean) pergunta1.getE().getPerguntas().get("correta");
                break;
            default:
                System.out.println("Resposta inválida.");
                return;
        }
        
        if (acertou1) {
            acertos++;
        } else {
            erros++;
        }
        
        // Pergunta 2
        Pergunta pergunta2 = geraPergunta.pergunta2();
        System.out.println("\nID da Pergunta: " + pergunta2.id);
        System.out.println("Texto da Pergunta: " + pergunta2.perguntaTexto);
        
        System.out.println("A: " + pergunta2.getA().getPerguntas().get("texto"));
        System.out.println("B: " + pergunta2.getB().getPerguntas().get("texto"));
        System.out.println("C: " + pergunta2.getC().getPerguntas().get("texto"));
        System.out.println("D: " + pergunta2.getD().getPerguntas().get("texto"));
        System.out.println("E: " + pergunta2.getE().getPerguntas().get("texto"));
        
        System.out.print("Digite a letra da sua resposta: ");
        String resposta2 = scanner.nextLine().toUpperCase();
        
        boolean acertou2 = false;
        switch (resposta2) {
            case "A":
                acertou2 = (boolean) pergunta2.getA().getPerguntas().get("correta");
                break;
            case "B":
                acertou2 = (boolean) pergunta2.getB().getPerguntas().get("correta");
                break;
            case "C":
                acertou2 = (boolean) pergunta2.getC().getPerguntas().get("correta");
                break;
            case "D":
                acertou2 = (boolean) pergunta2.getD().getPerguntas().get("correta");
                break;
            case "E":
                acertou2 = (boolean) pergunta2.getE().getPerguntas().get("correta");
                break;
            default:
                System.out.println("Resposta inválida.");
                return;
        }
        
        if (acertou2) {
            acertos++;
        } else {
            erros++;
        }
        
        // Resultados
        System.out.println("\nResultados:");
        System.out.println("Acertos: " + acertos);
        System.out.println("Erros: " + erros);
        
        scanner.close();
    }
}
