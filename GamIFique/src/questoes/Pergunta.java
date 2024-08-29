package questoes;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Pergunta {
    private int id;
    private String perguntaTexto;
    private Map<String, Alternativa> alternativas;

    public Pergunta(int id, String perguntaTexto,
                    Alternativa a, Alternativa b, Alternativa c,
                    Alternativa d, Alternativa e) {
        this.id = id;
        this.perguntaTexto = perguntaTexto;
        this.alternativas = new HashMap<>();
        alternativas.put("A", a);
        alternativas.put("B", b);
        alternativas.put("C", c);
        alternativas.put("D", d);
        alternativas.put("E", e);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getPerguntaTexto() {
        return perguntaTexto;
    }

    public Alternativa getAlternativa(String letra) {
        return alternativas.get(letra.toUpperCase());
    }

    // Adiciona ou substitui uma alternativa
    public void setAlternativa(String letra, Alternativa alternativa) {
        alternativas.put(letra.toUpperCase(), alternativa);
    }

    // Verifica se uma alternativa é correta
    public Alternativa getAlternativaCorreta() {
        for (Alternativa alternativa : alternativas.values()) {
            if (alternativa.getEhCorreta()) {
                return alternativa;
            }
        }
        return null; // ou lance uma exceção se preferir
    }

    // Getter para o mapa de alternativas, retorna uma cópia não modificável
    public Map<String, Alternativa> getAlternativas() {
        return Collections.unmodifiableMap(alternativas);
    }

    @Override
    public String toString() {
        return "Pergunta{" +
               "id=" + id +
               ", perguntaTexto='" + perguntaTexto + '\'' +
               ", alternativas=" + alternativas +
               '}';
    }
}
