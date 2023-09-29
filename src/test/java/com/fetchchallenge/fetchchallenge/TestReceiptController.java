package com.fetchchallenge.fetchchallenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReceiptController.class)
public class TestReceiptController {

    private MockMvc mockMvc;

    @MockBean
    private ReceiptService receiptService;

    @InjectMocks
    private ReceiptController receiptController;

    private String sampleJSON;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(receiptController).build();

        // Read content of morning-receipt.json
        sampleJSON = new String(Files.readAllBytes(Paths.get("src/test/resources/morning-receipt.json")));
    }

    @Test
    public void testProcessReceipt() throws Exception {
        UUID mockUUID = UUID.randomUUID();

        when(receiptService.processReceipt(any(Receipt.class))).thenReturn(mockUUID);

        mockMvc.perform(post("/receipts/process")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(sampleJSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(mockUUID.toString()));
    }

    @Test
    public void testGetPoints() throws Exception {
        UUID mockUUID = UUID.randomUUID();
        when(receiptService.findPointsById(mockUUID)).thenReturn(Optional.of(100));

        mockMvc.perform(get("/receipts/" + mockUUID + "/points")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.points").value(100));
    }

    @Test
    public void testGetPointsNotFound() throws Exception {
        UUID mockUUID = UUID.randomUUID();
        when(receiptService.findPointsById(mockUUID)).thenReturn(Optional.empty());

        mockMvc.perform(get("/receipts/" + mockUUID + "/points")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}