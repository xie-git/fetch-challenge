package com.fetchchallenge.fetchchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.*;


@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @Autowired
    private ReceiptRepository receiptRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Receipt>> getAllReceipts() {
        Iterable<Receipt> receipts = this.receiptRepository.findAll();
        List<Receipt> receiptList = new ArrayList<>();
        receipts.forEach(receiptList::add);
        return ResponseEntity.ok(receiptList);
    }

    @PostMapping("/addReceipt")
    public ResponseEntity<Receipt> addReceipt(@RequestBody Receipt receipt) {
        for (Item item : receipt.getItems()) {
            item.setReceipt(receipt);
        }
        Receipt savedReceipt = this.receiptRepository.save(receipt);
        return ResponseEntity.ok(savedReceipt);
    }

    @PostMapping("/process")
    public ResponseEntity<?> processReceipt(@RequestBody Receipt receipt) {
        UUID id;
        try {
            id = receiptService.processReceipt(receipt);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(Map.of("id", id.toString()));
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<?> getPoints(@PathVariable UUID id) {
        Optional<Integer> pointsOptional = receiptService.findPointsById(id);

        if (pointsOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(Map.of("points", pointsOptional));

    }
}
