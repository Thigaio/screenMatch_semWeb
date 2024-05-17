package br.com.thigaio.tecLib.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record dadosEpisodio(@JsonAlias("Title") String titulo,
                            @JsonAlias("Episode") Integer numero,
                            @JsonAlias("imdbRating") String avaliacao,
                            @JsonAlias("Released") String dataLancamento) {
    @Override
    public String toString() {
        return "\nEpisódios{" +
                "Título: " + titulo +
                ", Número: " + numero +
                ", Avaliacao: " + avaliacao +
                ", Data de Lancamento: " + dataLancamento +
                '}';
    }
}
