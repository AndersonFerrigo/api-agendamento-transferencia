package br.com.bank.api_agendamento_transferencias.facade;

import br.com.bank.api_agendamento_transferencias.dto.TransferenciaRequest;
import br.com.bank.api_agendamento_transferencias.dto.TransferenciaResponse;
import br.com.bank.api_agendamento_transferencias.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Facade {

	private final TransferenciaService transferenciaService;

	public TransferenciaResponse agendarTransferencia(TransferenciaRequest request){
		return transferenciaService.agendarTransferencia(request);
	}

	public List<TransferenciaResponse> listarTransferencias(){
		return transferenciaService.listarTodas();
	}

}
