package br.com.matheus.behavioral.chainofresponsibility;

import java.util.HashMap;
import java.util.Map;

import br.com.matheus.util.ExcludeFromCodeCoverageAnalysisGenerated;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Receipt {
	
	private Map<Integer, Long> bills;
	
	public Receipt() {
		this.bills = new HashMap<>();
	}
	
	public void receiveBills(int billValue, long quantityOfBills) {
		this.bills.put(billValue, quantityOfBills);
	}

	@ExcludeFromCodeCoverageAnalysisGenerated(reason = "Method used only for printing values in the System output.")
	public void informReceiptBills() {
		for (Map.Entry<Integer, Long> entry : bills.entrySet()) {
			logger.info(String.format("Quantidade de notas de R$%d,00: %d", entry.getKey(), entry.getValue()));
		}
	}
}