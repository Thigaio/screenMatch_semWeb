package br.com.thigaio.screenMatch;

import br.com.thigaio.screenMatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	Principal principal = new Principal();
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibirMenu();
//		List<dadosTemporada> temporadas = new ArrayList<>();
//
//		for (int i = 1; i <= dados.totalTemporadas(); i++) {
//			json = consumoAPI.obterDados("https://www.omdbapi.com/?t=Stranger+Things&season=" + i + "&apikey=6585022c");
//			dadosTemporada dadosTemporada = conversor.obterDados(json, dadosTemporada.class);
//			temporadas.add(dadosTemporada);
//		}
//		temporadas.forEach(System.out::println);
//
//		for(int i = 0; i < dados.totalTemporadas(); i++){
//			List<dadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//			for (int j = 0; j < episodiosTemporada.size(); j++){
//				System.out.println(episodiosTemporada.get(j).titulo());
//			}
//		}
	}
}
