package Projeto;

import java.util.Arrays;
import java.util.List;

public class TipoMidia {
    public static final String MUSICA = "MUSICA";
    public static final String PODCAST = "PODCAST";
    public static final String AUDIOBOOK = "AUDIOBOOK";

    private static final List<String> GENEROS_MUSICA = Arrays.asList("Rock","POP","MPB","JAZZ","CLASSICA","SERTANEJO","FUNK","ELETRÔNICA");

    public static boolean ValidarGenero(String genero) {
        for (String generoLista : GENEROS_MUSICA) {
            if (generoLista.equalsIgnoreCase(genero)) {
                return true;
            }
        }
        return false;
    }
    public static List<String> getGenerosMusica(){
        return GENEROS_MUSICA;
    }
}

