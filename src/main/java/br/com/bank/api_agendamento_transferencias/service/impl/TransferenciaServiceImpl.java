package br.com.bank.api_agendamento_transferencias.service.impl;

import br.com.bank.api_agendamento_transferencias.dto.TransferenciaRequest;
import br.com.bank.api_agendamento_transferencias.dto.TransferenciaResponse;
import br.com.bank.api_agendamento_transferencias.model.Conta;
import br.com.bank.api_agendamento_transferencias.model.Transferencia;
import br.com.bank.api_agendamento_transferencias.repository.ContaRepository;
import br.com.bank.api_agendamento_transferencias.repository.TransferenciaRepository;
import br.com.bank.api_agendamento_transferencias.service.CalculadoraTaxaService;
import br.com.bank.api_agendamento_transferencias.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransferenciaServiceImpl implements TransferenciaService {

	private final ContaRepository contaRepository;
	private final TransferenciaRepository transferenciaRepository;

	private final CalculadoraTaxaService calculadoraTaxaService;

	@Override
	public TransferenciaResponse agendarTransferencia(TransferenciaRequest request) {

		Conta origem = contaRepository.findByNumero(request.getContaOrigem())
				.orElseGet(() -> {
					Conta contaOrigem = Conta.builder()
							.numero(request.getContaOrigem())
							.build();
					return contaRepository.save(contaOrigem);
				});

		Conta destino = contaRepository.findByNumero(request.getContaDestino())
				.orElseGet(() -> {
					Conta contaDestino = Conta.builder()
							.numero(request.getContaDestino())
							.build();
					return contaRepository.save(contaDestino);
				});

		Transferencia transferencia = Transferencia.builder()
				.origem(origem)
				.destino(destino)
				.valor(request.getValor())
				.dataAgendamento(LocalDate.now())
				.dataTransferencia(request.getDataTransferencia())
				.build();

		BigDecimal taxa = calculadoraTaxaService.calcularTaxa(transferencia);
		transferencia.setTaxa(taxa);

		Transferencia saved = transferenciaRepository.save(transferencia);

		return toResponse(saved);

	}


	@Override
	public List<TransferenciaResponse> listarTodas() {

		return transferenciaRepository.findAll().stream()
				.map(this::toResponse)
				.collect(Collectors.toList());

	}

	private TransferenciaResponse toResponse(Transferencia transferencia) {

		return TransferenciaResponse.builder()
				.id(transferencia.getId())
				.contaOrigem(transferencia.getOrigem().toString())
				.contaDestino(transferencia.getDestino().toString())
				.valor(transferencia.getValor())
				.taxa(transferencia.getTaxa())
				.dataTransferencia(transferencia.getDataTransferencia())
				.dataAgendamento(transferencia.getDataAgendamento())
				.build();

	}

}
