package Projeto;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private List<Projeto.Midia> midias;

    public Playlist(String nome){
        this.nome = nome;
        this.midias = new ArrayList<>();
    }

    public void adicionarMidia(Projeto.Midia midia){
        this.midias.add(midia);
    }

    public boolean removerMidia(String nome, String autor) {
        for (Projeto.Midia midia : this.midias) {
            if (midia.getNome().equalsIgnoreCase(nome) && midia.getAutor().equalsIgnoreCase(autor)) {
                this.midias.remove(midia);
                return true;
            }
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public List<Projeto.Midia> getMidias() {
        return midias;
    }
}