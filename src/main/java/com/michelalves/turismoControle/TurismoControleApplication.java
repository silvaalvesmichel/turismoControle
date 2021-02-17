package com.michelalves.turismoControle;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.michelalves.turismoControle.domain.Assentos;
import com.michelalves.turismoControle.domain.Cidades;
import com.michelalves.turismoControle.domain.Estados;
import com.michelalves.turismoControle.domain.Financeiro;
import com.michelalves.turismoControle.domain.Onibus;
import com.michelalves.turismoControle.domain.Passageiro;
import com.michelalves.turismoControle.domain.Viagem;
import com.michelalves.turismoControle.repositories.CidadesRepository;
import com.michelalves.turismoControle.repositories.EstadosRepository;
import com.michelalves.turismoControle.repositories.FinanceiroRepository;
import com.michelalves.turismoControle.repositories.AssentosRepository;
import com.michelalves.turismoControle.repositories.OnibusRepository;
import com.michelalves.turismoControle.repositories.PassageiroRepository;
import com.michelalves.turismoControle.repositories.ViagemRepository;

@SpringBootApplication
public class TurismoControleApplication implements CommandLineRunner{
	
	@Autowired
	private EstadosRepository estadosRepository;
	@Autowired
	private CidadesRepository cidadesRepository;
	@Autowired
	private ViagemRepository viagemRepository;
	@Autowired
	private PassageiroRepository passageiroRepository;
	@Autowired
	private FinanceiroRepository financeiroRepository;
	@Autowired
	private OnibusRepository onibusRepository;
	@Autowired
	private AssentosRepository assentosRepository;
	
		public static void main(String[] args) {
			SpringApplication.run(TurismoControleApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			//cidade e estado
			Estados estados = new Estados(Long.valueOf(1), "Acre", "AC");
			Cidades cidades = new Cidades(Long.valueOf(3), "Brasiléia", estados);
			estadosRepository.save(estados);
			cidadesRepository.save(cidades);
			cidadesRepository.flush();
			//onibus
			Onibus onibus = new Onibus(null, 45);
			onibusRepository.save(Arrays.asList(onibus));
			//viagem
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date dataIda = formato.parse("01/01/2018");
			Date dataVolta = formato.parse("01/01/2018");
			Viagem viagem  = new Viagem(null, dataIda, dataVolta, 2000.00, 1500.00, estados, cidades, onibus);
			viagemRepository.save(viagem);
			//passageiro
			Date dataNascimento = formato.parse("11/11/1994");
			Passageiro passageiro = new Passageiro(null, "Michel Alves da Silva", dataNascimento, "Masculino", "2133499", "(61)999999999", "Qi 24 taguatinga norte");
			passageiroRepository.save(passageiro);
			//adicionando passageiro a assento do onibus
			Assentos assentos = new Assentos(null, "1", onibus, passageiro);
			assentosRepository.save(Arrays.asList(assentos));
			onibus.setAssentos(Arrays.asList(assentos));
			onibusRepository.save(onibus);
			//adicionando passageiro a viagem
			viagem.setPassageiros(Arrays.asList(passageiro));
			viagemRepository.save(viagem);
			
			//Financeiro
			Financeiro financeiro = new Financeiro(null, 800.00, 800.00, 0.00, passageiro, viagem);
			financeiroRepository.save(Arrays.asList(financeiro));
		
	}
}
