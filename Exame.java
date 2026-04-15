public class Exame {
    String abrev;
    String nome;
    int qtDias;

    public Exame (String abrev, String nome, int qtDias) {
        this.abrev = abrev;
        this.nome = nome;
        this.qtDias = qtDias;
    }

    @Override 
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if(!(obj instanceof Exame) ) return false;

        Exame outro = (Exame) obj;
        return this.abrev.equals(outro.abrev);
    }

    public String toString(){
        return String.format("%s - %s - %d dias", abrev, nome, qtDias);
    }

    
}