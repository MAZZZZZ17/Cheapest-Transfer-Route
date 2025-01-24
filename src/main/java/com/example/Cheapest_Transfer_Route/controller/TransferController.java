package com.example.Cheapest_Transfer_Route.controller;

import com.example.Cheapest_Transfer_Route.model.Transfer;
import com.example.Cheapest_Transfer_Route.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/optimal-route")
    public Map<String, Object> findOptimalRoute(@RequestBody Map<String, Object> request) {
        int maxWeight = (int) request.get("maxWeight");
        List<Map<String, Object>> availableTransfers = (List<Map<String, Object>>) request.get("availableTransfers");

        List<Transfer> transfers = availableTransfers.stream().map(data -> {
            Transfer transfer = new Transfer();
            transfer.setWeight((int) data.get("weight"));
            transfer.setCost((int) data.get("cost"));
            return transfer;
        }).toList();

        List<Transfer> selectedTransfers = transferService.findOptimalTransfers(transfers, maxWeight);
        int totalCost = selectedTransfers.stream().mapToInt(Transfer::getCost).sum();
        int totalWeight = selectedTransfers.stream().mapToInt(Transfer::getWeight).sum();

        Map<String, Object> response = new HashMap<>();
        response.put("selectedTransfers", selectedTransfers);
        response.put("totalCost", totalCost);
        response.put("totalWeight", totalWeight);

        return response;
    }
}
