package br.com.thigaio.tecLib.principal;

import br.com.thigaio.tecLib.model.dadosEpisodio;
import br.com.thigaio.tecLib.model.dadosSerie;
import br.com.thigaio.tecLib.model.dadosTemporada;
import br.com.thigaio.tecLib.services.consumoAPI;
import br.com.thigaio.tecLib.services.converteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scan = new Scanner(System.in);
    private consumoAPI consumoAPI = new consumoAPI();
    private String nomeSerie;
    private String json;
    private converteDados conversor = new converteDados();
    public void exibirMenu() {
        System.out.println("Digite o nome da série para a busca");
        nomeSerie = scan.nextLine();
        json = consumoAPI.obterDados("https://www.omdbapi.com/?t=" + nomeSerie.replace(" ", "+") + "&apikey=6585022c");
        dadosSerie dados = conversor.obterDados(json, dadosSerie.class);
        System.out.println(dados);

        List<dadosTemporada> temporadas = new ArrayList<>();

        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumoAPI.obterDados("https://www.omdbapi.com/?t=" + nomeSerie.replace(" ", "+") + "&season="+ i +"&apikey=6585022c");
            dadosTemporada dadosTemporada = conversor.obterDados(json, dadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

//        for(int i = 0; i < dados.totalTemporadas(); i++){
//            List<dadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size(); j++){
//                System.out.println(episodiosTemporada.get(j).titulo());
//            }
//        }

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

        List<dadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        System.out.println("\nTop 5 Episódios");
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(dadosEpisodio::avaliacao).reversed())
                .limit(5)
                .forEach(System.out::println);
    }
}
