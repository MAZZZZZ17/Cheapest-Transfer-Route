package com.example.Cheapest_Transfer_Route.service;

import com.example.Cheapest_Transfer_Route.model.Transfer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferService {

    public List<Transfer> findOptimalTransfers(List<Transfer> transfers, int maxWeight) {
        List<Transfer> mutableTransfers = new ArrayList<>(transfers);
        List<Transfer> result = new ArrayList<>();
        int currentWeight = 0;

        mutableTransfers.sort((a, b) -> Double.compare(
                (double) b.getCost() / b.getWeight(),
                (double) a.getCost() / a.getWeight()
        ));

        for (Transfer transfer : mutableTransfers) {
            if (currentWeight + transfer.getWeight() <= maxWeight) {
                result.add(transfer);
                currentWeight += transfer.getWeight();
            }
        }
        return result;
    }
}
