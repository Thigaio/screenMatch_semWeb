package br.com.thigaio.screenMatch;

import br.com.thigaio.screenMatch.model.dadosSerie;
import br.com.thigaio.screenMatch.services.consumoAPI;
import br.com.thigaio.screenMatch.services.converteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new consumoAPI();
		var json = consumoAPI.obterDados("https://www.omdbapi.com/?t=Stranger+Things&apikey=d8e3a7a5");
		System.out.println(json);
		//json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");
		//System.out.println(json);
		converteDados conversor = new converteDados();
		dadosSerie dados = conversor.obterDados(json, dadosSerie.class);
		System.out.println(dados);
	}
}
