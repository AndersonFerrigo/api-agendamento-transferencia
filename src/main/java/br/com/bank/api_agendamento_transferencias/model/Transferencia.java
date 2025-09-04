package br.com.bank.api_agendamento_transferencias.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@Entity
@Table( name = "transferencia")
@NoArgsConstructor
@AllArgsConstructor
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "conta_origem_id")
	@NotNull(message = "Conta de origem é obrigatória")
	private Conta origem;

	@ManyToOne
	@JoinColumn(name = "conta_destino_id")
	@NotNull(message = "Conta de destino é obrigatória")
	private Conta destino;

	@NotNull(message = "Valor é obrigatório")
	@Positive(message = "Valor deve ser positivo")
	private BigDecimal valor;

	private BigDecimal taxa;

	@NotNull(message = "Data de transferência é obrigatória")
	private LocalDate dataTransferencia;

	private LocalDate dataAgendamento;

}
