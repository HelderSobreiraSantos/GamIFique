package questoes;

public class Pergunta {
    int id;
    String perguntaTexto;
    Alternativa a;
    Alternativa b;
    Alternativa c;
    Alternativa d;
    Alternativa e;

    public Pergunta(int id, String perguntaTexto, 
            String A_letra, String A_texto, Boolean A_ehCorreta,
            String B_letra, String B_texto, Boolean B_ehCorreta,
            String C_letra, String C_texto, Boolean C_ehCorreta,
            String D_letra, String D_texto, Boolean D_ehCorreta,
            String E_letra, String E_texto, Boolean E_ehCorreta
    ){
        this.id = id;
        this.perguntaTexto = perguntaTexto;
        this.a = new Alternativa(A_letra, A_texto, A_ehCorreta);
        this.b = new Alternativa(B_letra, B_texto, B_ehCorreta);
        this.c = new Alternativa(C_letra, C_texto, C_ehCorreta);
        this.d = new Alternativa(D_letra, D_texto, D_ehCorreta);
        this.e = new Alternativa(E_letra, E_texto, E_ehCorreta);
    }

    // Getters
    public Alternativa getA() {
        return a;
    }

    public Alternativa getB() {
        return b;
    }

    public Alternativa getC() {
        return c;
    }

    public Alternativa getD() {
        return d;
    }

    public Alternativa getE() {
        return e;
    }

    // Setters
    public void setA(Alternativa a) {
        this.a = a;
    }

    public void setB(Alternativa b) {
        this.b = b;
    }

    public void setC(Alternativa c) {
        this.c = c;
    }

    public void setD(Alternativa d) {
        this.d = d;
    }

    public void setE(Alternativa e) {
        this.e = e;
    }
}
