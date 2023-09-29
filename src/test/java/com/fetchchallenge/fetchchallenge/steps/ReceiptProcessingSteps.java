package com.fetchchallenge.fetchchallenge.steps;

import com.fetchchallenge.fetchchallenge.Receipt;
import com.fetchchallenge.fetchchallenge.ReceiptService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReceiptProcessingSteps {

    @Autowired
    private ReceiptService receiptService;
    private Receipt receipt;
    private UUID receiptId;

    @Given("a receipt with retailer {string}")
    public void aReceiptWithRetailer(String retailer) {
        receipt = new Receipt();
        receipt.setRetailer(retailer);
    }

    @Given("a total of {string}")
    public void aTotalOf(String total) {
        receipt.setTotal(total);
    }

    @Given("purchase date {string} and time {string}")
    public void purchaseDateAndTime(String purchaseDate, String purchaseTime) {
        receipt.setPurchaseDate(purchaseDate);
        receipt.setPurchaseTime(purchaseTime);
    }

    @Given("items:")
    public void items(List<List<String>> table) {
        // Assuming the first row is a header row, skip it
        for (int i = 1; i < table.size(); i++) {
            List<String> row = table.get(i);
            if (row.size() < 2) {
                continue;
            }
            String description = row.get(0);
            String priceStr = row.get(1);

            // Skip row if trimmed description or price is null or empty
            if (description == null || description.trim().isEmpty() || priceStr == null || priceStr.trim().isEmpty()) {
                continue;
            }
            Receipt.Item item = new Receipt.Item();
            item.setShortDescription(description);

            try {
                double price = Double.parseDouble(priceStr);
                item.setPrice(price);
            } catch (NumberFormatException e) {
                // Skip this item if the price cannot be parsed
                continue;
            }

            receipt.getItems().add(item);
        }
    }

    @When("the receipt is processed")
    public void theReceiptIsProcessed() {
        receiptId = receiptService.processReceipt(receipt);
    }

    @Then("the total points should be {string}")
    public void totalPoints(String expectedPoints) {
        Optional<Integer> pointsOptional = receiptService.findPointsById(receiptId);
        if (pointsOptional.isPresent()) {
            assertEquals(Integer.parseInt(expectedPoints), pointsOptional.get().intValue());
        } else {
            throw new AssertionError("No points found for given receipt ID.");
        }
    }
}