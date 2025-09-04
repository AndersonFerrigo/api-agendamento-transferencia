package br.com.bank.api_agendamento_transferencias.controller;

import br.com.bank.api_agendamento_transferencias.dto.TransferenciaRequest;
import br.com.bank.api_agendamento_transferencias.dto.TransferenciaResponse;
import br.com.bank.api_agendamento_transferencias.facade.Facade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transferencia")
public class TransferenciaController {

	private final Facade facade;

	@PostMapping
	public ResponseEntity<?> agendarTransferencia(@Valid @RequestBody TransferenciaRequest request) {
		try {
			TransferenciaResponse response = facade.agendarTransferencia(request);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping
	public List<TransferenciaResponse> extrato() {
		return facade.listarTransferencias();
	}

}
