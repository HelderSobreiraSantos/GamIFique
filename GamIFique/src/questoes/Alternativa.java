package questoes;

public class Alternativa {
    private String letra;
    private String texto;
    private Boolean ehCorreta;

    public Alternativa(String letra, String texto, Boolean ehCorreta) {
        this.letra = letra;
        this.texto = texto;
        this.ehCorreta = ehCorreta;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getEhCorreta() {
        return ehCorreta;
    }

    public void setEhCorreta(Boolean ehCorreta) {
        this.ehCorreta = ehCorreta;
    }
    //billu
    @Override
    public String toString() {
        return "Alternativa{" +
               "letra='" + letra + '\'' +
               ", texto='" + texto + '\'' +
               ", ehCorreta=" + ehCorreta +
               '}';
    }
}
