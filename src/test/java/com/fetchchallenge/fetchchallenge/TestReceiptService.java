//package com.fetchchallenge.fetchchallenge;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//class TestReceiptService {
//
//    private ReceiptService receiptService;
//
//    @BeforeEach
//    public void setUp() {
//        receiptService = new ReceiptService();
//    }
//
//    @Test
//    public void testProcessReceiptForPointsCalculation() {
//        // Construct a Receipt that covers most of the point calculation scenarios
//        Receipt receipt = new Receipt();
//        receipt.setRetailer("Walmart");  // 7 points
//        receipt.setTotal("25.00");         // 50 points + 25 points
//        receipt.setPurchaseDate("2023-09-25"); // 6 points (odd day)
//        receipt.setPurchaseTime("15:00:00");   // 10 points (between 2pm and 4pm)
//
//        List<Receipt.Item> items = Arrays.asList(
//                new Receipt.Item("socks", 10.00),  // 0 points)
//                new Receipt.Item("hat", 15.00) // 3 points
//        ); // 5 points for items count
//
//        receipt.setItems(items);
//
//        UUID receiptId = receiptService.processReceipt(receipt);
//        assertNotNull(receiptId);
//
//        Optional<Integer> points = receiptService.findPointsById(receiptId);
//        assertTrue(points.isPresent());
//        assertEquals(7 + 50 + 25 + 6 + 10 + 3 + 5, points.get());
//    }
//
//    @Test
//    public void testFindPointsByIdNotFound() {
//        UUID randomUUID = UUID.randomUUID();
//        Optional<Integer> points = receiptService.findPointsById(randomUUID);
//        assertFalse(points.isPresent());
//    }
//
//    @Test
//    public void testReceiptWithNoExtraPoints() {
//        Receipt receipt = new Receipt();
//        receipt.setRetailer("Test");
//        receipt.setTotal("5.12");
//        receipt.setPurchaseDate("2023-09-24"); // even day
//        receipt.setPurchaseTime("11:00:00"); // not between 2pm and 4pm
//
//        List<Receipt.Item> items = Arrays.asList(
//                new Receipt.Item("sock", 10.00)
//        ); // no extra points for items
//
//        receipt.setItems(items);
//
//        UUID receiptId = receiptService.processReceipt(receipt);
//        assertNotNull(receiptId);
//
//        Optional<Integer> points = receiptService.findPointsById(receiptId);
//        assertTrue(points.isPresent());
//        assertEquals(4, points.get());  // Only points for the retailer name
//    }
//
//}