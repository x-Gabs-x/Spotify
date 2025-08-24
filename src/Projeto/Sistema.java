package Projeto;

import java.util.Scanner;

public class Sistema {
    private static Scanner scanner = new Scanner(System.in);
    private static Usuario usuario;
    private static Playlist playlist;
    private static Midia midia;

    public void cadUsuario(Scanner scanner){
        System.out.println("--- Cadastro de Usuário ---");
        System.out.print("Digite o nome: ");
        String nomeUsuario = scanner.nextLine().trim();

        System.out.print("Digite o e-mail: ");
        String emailUsuario = scanner.nextLine().trim();

        usuario = new Usuario(nomeUsuario, emailUsuario);

        System.out.printf("Usuário: %s cadastrado com sucesso!%n", nomeUsuario);

    }

    public void imprimirMenu(Scanner scanner){
        System.out.println("-----------MENU-----------");
        System.out.printf("""
                    1. Criar PlayList
                    2. Remover PlayList
                    3. Adicionar Mídia
                    4. Remover Mídia
                    5. Listar Playlists
                    6. Listar Músicas de uma Playlist 
                    7. sair
                """);
        System.out.println("Escolha uma opção: ");
    }

    public void criarPlaylist(Scanner scanner){
        System.out.print("Informe o nome da nova playlist: ");
        String nomeNovaPlaylist = scanner.nextLine().trim();

        // Verificando se o nome já existe
        if (usuario.existePlaylist(nomeNovaPlaylist)) {
            System.out.printf("Erro: Já existe uma playlist com este nome. Por favor, tente outro.%n");
        } else {
            usuario.criarPlaylist(nomeNovaPlaylist);
            System.out.printf("PlayList %s criada com sucesso!%n", nomeNovaPlaylist);
        }
    }

    public void removerPlaylist(Scanner scanner){
        //Verifica se a playlist existe
        if(usuario.getPlaylists().isEmpty()){
            System.out.println("Não há playlists para remover. Por favor, crie uma playlist!");
        }else{
            System.out.println("Informe o nome da playlist a ser removida: ");
            String nomeParaRemover = scanner.nextLine().trim();

            if (usuario.removerPlaylist(nomeParaRemover)) {
                System.out.printf("Playslit: '%s', removida com sucesso!%n", nomeParaRemover);
            }else{
                System.out.printf("Erro: A playlist '%s' não foi possível remover!%n", nomeParaRemover);
            }
        }
    }

    public void adicionarMidia(Scanner scanner){
        if(usuario.getPlaylists().isEmpty()){
            System.out.println("Não há playlists para adicionar mídias. Por favor, crie uma playlist primeiro!");
            return;
        }

        System.out.print("Informe o nome da playlist: ");
        String nomePlaylist = scanner.nextLine().trim();

        //Verificando se há playlist
        Playlist playListAlvo = null;
        for(Playlist playlist : usuario.getPlaylists()){
            if(playlist.getNome().equalsIgnoreCase(nomePlaylist)){
                playListAlvo = playlist;
                break;
            }
        }

        if(playListAlvo == null){
            System.out.println("Erro: Playlist não encontrada!");
            return;
        }

        System.out.println("Informe o nome da mídia: ");
        String nomeMusica = scanner.nextLine().trim();

        System.out.println("Informe o nome do autor: ");
        String autorNome = scanner.nextLine().trim();

        System.out.println("Informe a duração. (Ex: 3.5)");
        double duracaoMusica = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("------Escolha o tipo de mídia------");
        System.out.println("""
        - Música
        - Podcast
        - AudioBook
        """);
        System.out.println("Opção: ");
        String TipoMidia = scanner.nextLine().trim();

        if (!Projeto.TipoMidia.ValidarTipo(TipoMidia)){
            System.out.println("Tipo Inválido!");
            return;
        }

        String genero = null;
        if (TipoMidia.equalsIgnoreCase(Projeto.TipoMidia.MUSICA)){
            System.out.println("Escolha o gênero da Música: " + String.join(", ",Projeto.TipoMidia.getGenerosMusica()));
            genero = scanner.nextLine().trim();
        }
        
        if(!Projeto.TipoMidia.ValidarGenero(genero)){
            System.out.println("Gênero Inválido");
            return;
        }

        Midia novaMidia = new Midia(nomeMusica, autorNome, duracaoMusica);

        playListAlvo.adicionarMidia(novaMidia);
        System.out.printf("Música '%s' adicionada com sucesso!%n", nomeMusica);
    }

    public void removerMidia(Scanner scanner) {

        if (usuario.getPlaylists().isEmpty()) {
            System.out.println("Não há playlists para remover mídias. Por favor, crie uma playlist primeiro!");
            return;
        }

        System.out.print("Informe o nome da playlist: ");
        String nomePlaylist = scanner.nextLine().trim();

        Playlist playListAlvo = null;
        for (Playlist playlist : usuario.getPlaylists()) {
            if (playlist.getNome().equalsIgnoreCase(nomePlaylist)) {
                playListAlvo = playlist;
                break;
            }
        }

        if (playListAlvo == null) {
            System.out.println("Erro: Playlist não encontrada!");
            return;
        }

        System.out.print("Informe o nome da mídia: ");
        String nomeMidia = scanner.nextLine().trim();

        System.out.print("Informe o nome do Autor: ");
        String nomeAutor = scanner.nextLine().trim();

        boolean midiaRemovida = playListAlvo.removerMidia(nomeMidia, nomeAutor);

        if (midiaRemovida) {
            System.out.printf("Mídia '%s' do autor '%s' removida com sucesso!%n", nomeMidia, nomeAutor);
        } else {
            System.out.printf("Erro: A mídia '%s' do autor '%s' não foi encontrada na playlist.%n", nomeMidia, nomeAutor);
        }
    }

    public void listarPlaylist(Scanner scanner){
        System.out.println("Minhas playlists");
        if(usuario.getPlaylists().isEmpty()){
            System.out.println("Não há playlists para remover");
        }else{
            usuario.visualizarPlaylists();
        }
    }

    public void listarMidiasDaPlaylist(Scanner scanner) {
        System.out.println("--- Listar Músicas de uma Playlist ---");

        if (usuario.getPlaylists().isEmpty()) {
            System.out.println("Não há playlists para listar músicas. Por favor, crie uma playlist primeiro.");
            return;
        }

        System.out.print("Informe o nome da playlist: ");
        String nomePlaylist = scanner.nextLine().trim();

        if (usuario.listarMidiasDaPlaylist(nomePlaylist)) {
        } else {
            System.out.printf("Erro: A playlist '%s' não foi encontrada.", nomePlaylist);
        }
    }
}