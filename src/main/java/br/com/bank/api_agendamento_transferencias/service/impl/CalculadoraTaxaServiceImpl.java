package br.com.bank.api_agendamento_transferencias.service.impl;

import br.com.bank.api_agendamento_transferencias.model.Transferencia;
import br.com.bank.api_agendamento_transferencias.service.CalculadoraTaxaService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

@Service
public class CalculadoraTaxaServiceImpl implements CalculadoraTaxaService {

	@Override
	public BigDecimal calcularTaxa(Transferencia transferencia) {

		long dias = ChronoUnit.DAYS.between(
				transferencia.getDataAgendamento(),
				transferencia.getDataTransferencia()
		);

		BigDecimal valor = transferencia.getValor();

		if (dias == 0) {
			return BigDecimal.valueOf(3).add(valor.multiply(BigDecimal.valueOf(0.03)));
		} else if (dias >= 1 && dias <= 10) {
			return BigDecimal.valueOf(12);
		} else if (dias >= 11 && dias <= 20) {
			return valor.multiply(BigDecimal.valueOf(0.025));
		} else if (dias >= 21 && dias <= 30) {
			return valor.multiply(BigDecimal.valueOf(0.082));
		} else if (dias >= 31 && dias <= 40) {
			return valor.multiply(BigDecimal.valueOf(0.069));
		} else if (dias >= 41 && dias <= 50) {
			return valor.multiply(BigDecimal.valueOf(0.047));
		} else {
			throw new IllegalArgumentException("Não há taxa aplicável para esta data");
		}
	}
}
