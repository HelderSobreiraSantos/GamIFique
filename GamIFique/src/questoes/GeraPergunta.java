package questoes;

public class GeraPergunta {
    private int perguntaID;

    public Pergunta DefinePergunta(int perguntaID) {
        this.perguntaID = perguntaID; // Corrige a atribuição

        if (perguntaID == 1) {
            return pergunta1();
        } else if (perguntaID == 2) {
            return pergunta2();
        } else if (perguntaID == 3) {
            return pergunta3();
        } else if (perguntaID == 4) {
            return pergunta4();
        } else if (perguntaID == 5) {
            return pergunta5();
        } else {
            throw new IllegalArgumentException("ID da pergunta inválido: " + perguntaID);
        }
    }

    public Pergunta pergunta1() {
        Alternativa a = new Alternativa("A", "Corte", true);
        Alternativa b = new Alternativa("B", "Planta baixa", false);
        Alternativa c = new Alternativa("C", "Fachada", false);
        Alternativa d = new Alternativa("D", "Planta de situação", false);
        Alternativa e = new Alternativa("E", "Nenhuma das anteriores", false);

        return new Pergunta(
            1,
            "(MSCONCURSOS - 2014 - IF SERTÃO-PE - Técnico em edificações) - Nos projetos arquitetônicos, a seção obtida por um plano vertical que intercepta elementos como paredes, janelas, portas e lajes, com a finalidade de permitir esclarecimentos que venham a facilitar a execução da obra, é representada por meio de um desenho chamado de",
            a, b, c, d, e
        );
    }

    public Pergunta pergunta2() {
        Alternativa a = new Alternativa("A", "33º31", false);
        Alternativa b = new Alternativa("B", "40º10", true);
        Alternativa c = new Alternativa("C", "46º52", false);
        Alternativa d = new Alternativa("D", "53º23", false);
        Alternativa e = new Alternativa("E", "Nenhuma das anteriores", false);

        return new Pergunta(
            2,
            "(FUNCERN - 2015 - IFRN - Técnico em edificações) - O azimute magnético de um alinhamento vale 43º31’. Sabendo-se que a declinação magnética local é igual a 3º21’ W, o valor do azimute verdadeiro desse alinhamento vale",
            a, b, c, d, e
        );
    }

    public Pergunta pergunta3() {
        Alternativa a = new Alternativa("A", "Ensaio de palheta", false);
        Alternativa b = new Alternativa("B", "Ensaio de compressão triaxial", false);
        Alternativa c = new Alternativa("C", "Ensaio de umidade", false);
        Alternativa d = new Alternativa("D", "Ensaio de Proctor", false);
        Alternativa e = new Alternativa("E", "Ensaio de Abatimento (Slump-test)", true);

        return new Pergunta(
            3,
            "(UESPI - 2016 - Prefeitura de Parnaíba/PI - Técnico em edificações) - Qual ensaio realizado no canteiro de obras e que mede a consistência de um concreto fresco?",
            a, b, c, d, e
        );
    }

    public Pergunta pergunta4() {
        Alternativa a = new Alternativa("A", "Remoção de entulho da obra pronta", false);
        Alternativa b = new Alternativa("B", "Limpeza do terreno", false);
        Alternativa c = new Alternativa("C", "Lucro esperado pelo construtor", true);
        Alternativa d = new Alternativa("D", "Encargos sociais", false);
        Alternativa e = new Alternativa("E", "Mão de obra", false);

        return new Pergunta(
            4,
            "(UFMA - 2014 - UFMA - Técnico em edificações) - Assinale a alternativa abaixo que faz parte da composição do BDI (Bonificação de Despesas Indiretas)",
            a, b, c, d, e
        );
    }

    public Pergunta pergunta5() {
        Alternativa a = new Alternativa("A", "A inclinação mínima de uma cobertura com telha cerâmica capa/canal é de 10%", false);
        Alternativa b = new Alternativa("B", "O rincão é a parte mais alta de um telhado", false);
        Alternativa c = new Alternativa("C", "Uma opção para as coberturas são as telhas metálicas, estas são obtidas por um processo de conformação em perfiladeiras de chapas de zinco, alumínio ou aço e conseguem vencer grandes vãos", true);
        Alternativa d = new Alternativa("D", "As calhas e condutores não fazem parte do sistema de cobertura", false);
        Alternativa e = new Alternativa("E", "A telha portuguesa é uma telha cerâmica do tipo apenas canal", false);

        return new Pergunta(
            5,
            "(UESPI - 2016 - Prefeitura de Parnaíba/PI - Técnico em edificações) - Uma das funções do telhado é a proteção da edificação contra as intempéries, principalmente contra chuvas, nesse contexto marque a alternativa CORRETA a respeito das coberturas.",
            a, b, c, d, e
        );
    }
}
