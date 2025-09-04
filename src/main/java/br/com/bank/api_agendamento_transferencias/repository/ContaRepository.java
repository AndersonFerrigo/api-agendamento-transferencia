package br.com.bank.api_agendamento_transferencias.repository;

import br.com.bank.api_agendamento_transferencias.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	Optional<Conta> findByNumero(String numero);

}
