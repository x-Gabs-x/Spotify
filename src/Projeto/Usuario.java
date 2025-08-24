package Projeto;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private List<Playlist> playlists;

    public Usuario (String nome, String email){
        this.nome = nome;
        this.email = email;
        this.playlists = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void criarPlaylist(String nomePlaylist) {
        Playlist novaPlaylist = new Playlist(nomePlaylist);
        this.playlists.add(novaPlaylist);
    }

    public boolean existePlaylist(String nome) {
        for (Playlist playlist : this.playlists) {
            if (playlist.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public boolean removerPlaylist(String nome) {
        for (Playlist playlist : this.playlists) {
            if (playlist.getNome().equalsIgnoreCase(nome)) {
                this.playlists.remove(playlist);
                return true;
            }
        }
        return false;
    }

    public void visualizarPlaylists() {
        System.out.println("--- Playlists de " + this.nome + " ---");

        for (Playlist playlist : this.playlists) {
            System.out.println("\nPlaylist: " + playlist.getNome());
            System.out.println("Músicas:");

            for (Projeto.Midia midia : playlist.getMidias()) {
                System.out.println("  - " + midia.getNome() + " por " + midia.getAutor());
            }
        }
    }

    public boolean listarMidiasDaPlaylist(String nomePlaylist) {
        Playlist playlistAlvo = null;
        for (Playlist playlist : this.playlists) {
            if (playlist.getNome().equalsIgnoreCase(nomePlaylist)) {
                playlistAlvo = playlist;
                break;
            }
        }

        if (playlistAlvo != null) {
            System.out.println("--- Músicas da Playlist '" + playlistAlvo.getNome() + "' ---");

            if (playlistAlvo.getMidias().isEmpty()) {
                System.out.println("A playlist está vazia.");
            } else {
                for (Projeto.Midia midia : playlistAlvo.getMidias()) {
                    System.out.println("  - " + midia.getNome() + " por " + midia.getAutor());
                }
            }
            return true;
        }

        return false;
    }
}