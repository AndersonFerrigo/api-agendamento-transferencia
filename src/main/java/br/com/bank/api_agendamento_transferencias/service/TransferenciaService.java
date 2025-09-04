package br.com.bank.api_agendamento_transferencias.service;

import br.com.bank.api_agendamento_transferencias.dto.TransferenciaRequest;
import br.com.bank.api_agendamento_transferencias.dto.TransferenciaResponse;

import java.util.List;

public interface TransferenciaService {

	TransferenciaResponse agendarTransferencia(TransferenciaRequest request);
	List<TransferenciaResponse> listarTodas();

}
