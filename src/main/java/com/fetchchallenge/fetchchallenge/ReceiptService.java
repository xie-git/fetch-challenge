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
    private final Map<UUID, Integer> pointsStorage = new ConcurrentHashMap<>();

    public UUID processReceipt(Receipt receipt) {
        int points = calculatePoints(receipt);
        UUID id = UUID.randomUUID();
        pointsStorage.put(id, points);
        return id;
    }

    public Optional<Integer> findPointsById(UUID receiptId) {
        return Optional.ofNullable(pointsStorage.get(receiptId));
    }

    private int calculatePoints(Receipt receipt) {
        int points = 0;

        // One point for every alphanumeric character in the retailer name.
        points += receipt.getRetailer().chars().filter(Character::isLetterOrDigit).count();

        // 50 points if the total is a round dollar amount with no cents.
        double total = Double.parseDouble(receipt.getTotal());
        if (total % 1 == 0) {
            points += 50;
        }

        // 25 points if the total is a multiple of 0.25.
        if (total % 0.25 == 0) {
            points += 25;
        }

        // 5 points for every two items on the receipt.
        points += (receipt.getItems().size() / 2) * 5;

        // If the trimmed length of the item description is a multiple of 3, multiply the price by 0.2 and round up to the nearest integer. The result is the number of points earned.
        for (Receipt.Item item : receipt.getItems()) {
            if (item.getShortDescription().trim().length() % 3 == 0) {
                double itemPrice = item.getPrice();
                points += Math.ceil(itemPrice * 0.2);
            }
        }

        // 6 points if the day in the purchase date is odd.
        LocalDate purchaseDate = LocalDate.parse(receipt.getPurchaseDate(), DateTimeFormatter.ISO_DATE);
        if (purchaseDate.getDayOfMonth() % 2 != 0) {
            points += 6;
        }

        // 10 points if the time of purchase is after 2:00pm and before 4:00pm.
        LocalTime purchaseTime = LocalTime.parse(receipt.getPurchaseTime(), DateTimeFormatter.ISO_TIME);
        if (!purchaseTime.isBefore(LocalTime.of(14, 0)) && purchaseTime.isBefore(LocalTime.of(16, 0))) {
            points += 10;
        }

        return points;
    }
}