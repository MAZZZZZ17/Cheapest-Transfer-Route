package com.example.Cheapest_Transfer_Route.service;

import com.example.Cheapest_Transfer_Route.model.Transfer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferServiceTests {

	@Test
	public void testFindOptimalTransfers() {
		TransferService transferService = new TransferService();

		List<Transfer> transfers = List.of(
				new Transfer() {{ setWeight(5); setCost(10); }},
				new Transfer() {{ setWeight(10); setCost(20); }},
				new Transfer() {{ setWeight(3); setCost(5); }},
				new Transfer() {{ setWeight(8); setCost(15); }}
		);

		List<Transfer> result = transferService.findOptimalTransfers(transfers, 15);

		assertEquals(2, result.size());
		assertEquals(15, result.stream().mapToInt(Transfer::getWeight).sum());
		assertEquals(30, result.stream().mapToInt(Transfer::getCost).sum());
	}
}
