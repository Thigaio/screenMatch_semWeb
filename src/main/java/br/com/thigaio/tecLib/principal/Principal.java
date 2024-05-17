package br.com.thigaio.screenMatch.principal;

import br.com.thigaio.screenMatch.model.dadosSerie;
import br.com.thigaio.screenMatch.model.dadosTemporada;
import br.com.thigaio.screenMatch.services.consumoAPI;
import br.com.thigaio.screenMatch.services.converteDados;

import java.util.Scanner;

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
    }
}
