package it.zoologic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import it.zoologic.business.impl.repositories.*;
import it.zoologic.domain.*;

@SpringBootApplication
public class ZoologyApplication {

	 @Autowired
	 private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner loadData(UtenteRepository utenteRepository,
									  SpecieRepository specieRepository,
									  GenereRepository genereRepository,
									  ArticoloRepository articoloRepository,
									  ArgomentoRepository argomentoRepository,
									  AreaGeograficaRepository areageograficaRepository,
									  CitazioneRepository citazioneRepository,
									  TrattazioneRepository trattazioneRepository,
									  AfferimentoRepository afferimentoRepository) {
		return (args) -> {
			Utente luca = new Utente();
			luca.setUsername("patta");
			luca.setPassword(passwordEncoder.encode("luca"));
			luca.setNome("luca");
			luca.setCognome("pattavina");
			luca.setEmail("luca.pattavina@univaq.it");
			luca.setTelefono("+39.3468908444");
			luca = utenteRepository.save(luca);

			Genere canis = new Genere();
			canis.setDenominazione("Canis");
			canis = genereRepository.save(canis);

			Specie canisLupus = new Specie();
			canisLupus.setNome("Canis lupus");
			canisLupus.setGenere(canis);
			canisLupus = specieRepository.save(canisLupus);

			Argomento evoluzione = new Argomento();
			evoluzione.setArgomento("Evoluzione");
			evoluzione = argomentoRepository.save(evoluzione);

			AreaGeografica europa = new AreaGeografica();
			europa.setArea("europa");
			europa = areageograficaRepository.save(europa);

			Articolo articolo1 = new Articolo();
			articolo1.setTitolo("i cani in europa");
			articolo1.setAnno(2003);
			articolo1.setPagine("15-18 + 68-98");
			articolo1.setSede("fotocopiato");
			articolo1 = articoloRepository.save(articolo1);

			

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ZoologyApplication.class, args);
	}

}
