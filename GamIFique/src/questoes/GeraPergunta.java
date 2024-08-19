package questoes;

public class GeraPergunta {
    private int perguntaID;
    
    public Pergunta DefinePergunta(int perguntaID){
        perguntaID = this.perguntaID;
        
        if (perguntaID == 1){
            return pergunta1();
        }
        else{
            return pergunta2();
        }
    }
    
    public Pergunta pergunta1(){
        Pergunta pergunta = new Pergunta(
            1, 
            "(CEPERJ - 2015 - Prefeitura de Saquarema/RJ - Técnico em edificações) - Nos termos da Lei Orgânica Municipal, o número de vereadores da Câmara Municipal de Saquarema será fi xado por", 
            "A", "decreto legislativo", false, 
            "B", "resolução", true, 
            "C", "lei complementar", false, 
            "D", "medida provisória", false, 
            "E", "portaria legislativa", false
        );
        return pergunta;
    }
    
    public Pergunta pergunta2(){
        Pergunta pergunta = new Pergunta(
            1, 
            "(FUNCERN - 2015 - IFRN - Técnico em edificações) - O azimute magnético de um alinhamento vale 43º31’. Sabendo-se que a declinação magnética local é igual a 3º21’ W, o valor do azimute verdadeiro desse alinhamento vale", 
            "A", "33º31’", false, 
            "B", "40º10’", true, 
            "C", "46º52’", false, 
            "D", "53º23’.", false, 
            "E", "Nenhuma das anteriores", false
        );
        return pergunta;
    }
    
}
