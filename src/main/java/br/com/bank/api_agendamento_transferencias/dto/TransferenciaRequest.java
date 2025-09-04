package br.com.bank.api_agendamento_transferencias.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransferenciaRequest {

	@Pattern(regexp = "\\d{10}", message = "Conta de origem deve ter exatamente 10 dígitos")
	private String contaOrigem;

	@Pattern(regexp = "\\d{10}", message = "Conta de destino deve ter exatamente 10 dígitos")
	private String contaDestino;

	@NotNull(message = "Valor é obrigatório")
	@Positive(message = "Valor deve ser positivo")
	private BigDecimal valor;

	@NotNull(message = "Data de transferência é obrigatória")
	private LocalDate dataTransferencia;

}
