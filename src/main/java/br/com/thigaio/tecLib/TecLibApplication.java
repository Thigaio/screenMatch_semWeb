package br.com.thigaio.tecLib;

import br.com.thigaio.tecLib.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TecLibApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TecLibApplication.class, args);
	}

	Principal principal = new Principal();
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibirMenu();
	}
}
