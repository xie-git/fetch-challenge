package com.fetchchallenge.fetchchallenge;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ReceiptService {
    // Using ConcurrentHashMap to store receipt ID and its corresponding points.
    // ConcurrentHashMap chosen here under the assumption that this will eventually be a high load production environment API
    private final Map<UUID, Integer> pointsStorage = new ConcurrentHashMap<>();

    public UUID processReceipt(Receipt receipt) {
        int points = 30;
        UUID id = UUID.randomUUID();
        pointsStorage.put(id, points);
        return id;
    }

    public Optional<Integer> findPointsById(UUID receiptId) {
        return Optional.ofNullable(pointsStorage.get(receiptId));
    }


}