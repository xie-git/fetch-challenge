Feature: Receipt Processing

  Scenario Outline: Calculating points based on different receipt properties
    Given a receipt with retailer "<retailer>"
    And a total of "<total>"
    And purchase date "<purchaseDate>" and time "<purchaseTime>"
    And items:
      | shortDescription | price        |
      | <item1Desc>      | <item1Price> |
      | <item2Desc>      | <item2Price> |
      | <item3Desc>      | <item3Price> |
      | <item4Desc>      | <item4Price> |
      | <item5Desc>      | <item5Price> |
    When the receipt is processed
    Then the total points should be "<expectedPoints>"

    Examples:
      | retailer  | total | purchaseDate | purchaseTime | item1Desc | item1Price | item2Desc | item2Price | item3Desc | item3Price | item4Desc | item4Price | item5Desc | item5Price | expectedPoints |
      | Walmart   | 25.00 | 2023-09-01   | 12:00:00     | Socks     | 15.25      | Shirt     | 32.75      | Phone     | 200.50     | Tomato    | 2.15       | Water     | 3.00       | 99            |
      | Target    | 10.25 | 2023-09-02   | 13:30:00     | Watch     | 75.00      | Paper     | 5.00       |           |            |           |            |           |            | 36             |
      | Costco    | 1.00  | 2023-09-03   | 14:00:00     | Juice     | 3.00       |           |            |           |            |           |            |           |            | 97             |
      | Amazon    | 11.00 | 2023-09-04   | 15:00:00     | Water     | 5.32       | Dress     | 2.00       | Plant     | 20.00      | Lettuce   | 2.12       |           |            | 101            |
      | Apple     | 25.00 | 2023-09-05   | 16:00:00     | Candle    | 8.00       | Glasses   | 5.25       | Coffee    | 21.50      | Beef      | 2.49       | Water     | 3.00       | 103            |
      | Walgreens | 10.25 | 2023-09-06   | 17:30:00     | Mouse     | 24.47      | Shampoo   | 5.00       |           |            |           |            |           |            | 39             |
      | CVS       | 1.00  | 2023-09-07   | 18:00:00     | Keyboard  | 30.00      |           |            |           |            |           |            |           |            | 84             |
      | Ikea      | 11.00 | 2023-09-08   | 19:30:00     | Laptop    | 1234.56    | Sunscreen | 12.00      | Chips     | 2.00       | Pork      | 2.50       |           |            | 339            |
      | Macys     | 25.00 | 2023-09-09   | 20:00:00     | Camera    | 2345.67    | Lotion    | 5.00       | Salmon    | 2.50       | Chicken   | 3.00       | Water     | 3.00       | 568            |
      | Nordstrom | 10.25 | 2023-09-10   | 21:30:00     | Piano     | 3456.00    | Bag       | 45.67      |           |            |           |            |           |            | 49             |
