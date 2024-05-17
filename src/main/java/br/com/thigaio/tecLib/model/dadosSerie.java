package br.com.thigaio.screenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record dadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao) {
    @Override
    public String toString() {
        return "Dados Série{" +
                "Título: " + titulo +
                ", Total de temporadas: " + totalTemporadas +
                ", Avaliação: " + avaliacao +
                '}';
    }
}
