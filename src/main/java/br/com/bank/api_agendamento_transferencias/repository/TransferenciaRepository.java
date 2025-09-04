package br.com.bank.api_agendamento_transferencias.repository;

import br.com.bank.api_agendamento_transferencias.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
