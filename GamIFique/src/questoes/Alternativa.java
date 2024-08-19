package questoes;

import java.util.HashMap;
import java.util.Map;

public class Alternativa {
    Map<String, Object> perguntas = new HashMap<>();
    
    public Alternativa(String letra, String texto, Boolean ehCorreta){
        perguntas.put("numero", letra);
        perguntas.put("texto", texto);
        perguntas.put("correta", ehCorreta);
        
    }

    public Map<String, Object> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(Map<String, Object> perguntas) {
        this.perguntas = perguntas;
    }
    
}
