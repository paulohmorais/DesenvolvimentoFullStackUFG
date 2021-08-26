package br.ufg.inf.fs;

import br.ufg.inf.fs.entities.Hospedagem;
import br.ufg.inf.fs.entities.Hospede;
import br.ufg.inf.fs.repositories.HospedagemRepository;
import br.ufg.inf.fs.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.ufg.inf.fs.entities.Hotel;
import br.ufg.inf.fs.entities.Quarto;
import br.ufg.inf.fs.enums.CategoriaQuarto;
import br.ufg.inf.fs.repositories.HotelRepository;
import br.ufg.inf.fs.repositories.QuartoRepository;

import java.time.LocalDate;

@Configuration
@Profile("dev")
public class Config  implements CommandLineRunner{

	@Autowired
	private HotelRepository hoteRepository;
	
	@Autowired
	private QuartoRepository quartoRepository;

	@Autowired
	private HospedeRepository hospedeRepository;

	@Autowired
	private HospedagemRepository hospedagemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		/*
		 * INSERIR NO MEU BANCO DE DADOS INFORMAÇÕES INICIAIS...
		 * */
		
		Hotel h1 = new Hotel(null, "teste1", "aracaju", 3);
		Hotel h2 = new Hotel(null, "tes2", "birthday", 2);
		Hotel h3 = new Hotel(null, "tes3", "teste2", 4);
		Hotel h4 = new Hotel(null, "test4", "macenaria", 5);
		
		h1 = hoteRepository.save(h1);
		h2 = hoteRepository.save(h2);
		h3 = hoteRepository.save(h3);
		h4 = hoteRepository.save(h4);
		
		Quarto q1 = quartoRepository.save(new Quarto(null, h1, CategoriaQuarto.APARTAMENTO, 4, 1010, 200.0));
		Quarto q2 = quartoRepository.save(new Quarto(null, h2, CategoriaQuarto.SIMPLES, 1, 7, 100.0));
		Quarto q3 = quartoRepository.save(new Quarto(null, h3, CategoriaQuarto.PADRAO, 2, 306, 150.0));
		Quarto q4 = quartoRepository.save(new Quarto(null, h4, CategoriaQuarto.LUXO, 3, 1313, 500.0));

		Hospede hs1 = hospedeRepository.save(new Hospede(null, "joao",LocalDate.of(1997, 5, 9 ), 123456));
		Hospede hs2 = hospedeRepository.save(new Hospede(null, "carlos",LocalDate.of(1997, 5, 9 ), 123456));
		Hospede hs3 = hospedeRepository.save(new Hospede(null, "fernando",LocalDate.of(1997, 5, 9 ), 123456));
		Hospede hs4 = hospedeRepository.save(new Hospede(null, "paulo",LocalDate.of(1997, 5, 9 ), 123456));

		Hospedagem hp1 = hospedagemRepository.save(new Hospedagem(null, q1, hs1, LocalDate.of(2021, 8, 21), LocalDate.of(2021, 8, 24)));
		Hospedagem hp2 = hospedagemRepository.save(new Hospedagem(null, q2, hs2, LocalDate.of(2021, 8, 21), LocalDate.of(2021, 8, 24)));
		Hospedagem hp3 = hospedagemRepository.save(new Hospedagem(null, q3, hs3, LocalDate.of(2021, 8, 21), LocalDate.of(2021, 8, 24)));
		Hospedagem hp4 = hospedagemRepository.save(new Hospedagem(null, q4, hs4, LocalDate.of(2021, 8, 21), LocalDate.of(2021, 8, 24)));
	}

}
