package br.com.bank.api_agendamento_transferencias.service;

import br.com.bank.api_agendamento_transferencias.model.Transferencia;

import java.math.BigDecimal;

public interface CalculadoraTaxaService {

	BigDecimal calcularTaxa(Transferencia transferencia);

}
