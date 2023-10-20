CREATE TABLE IF NOT EXISTS receipts (
    id UUID PRIMARY KEY,
    retailer VARCHAR(255),
    purchaseDate VARCHAR(255),
    purchaseTime VARCHAR(255),
    total VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS items (
    itemId INT PRIMARY KEY AUTO_INCREMENT,
    receipt_id UUID,
    shortDescription VARCHAR(255),
    price DECIMAL(10, 2),
    FOREIGN KEY (receipt_id) REFERENCES receipts(id)
);

INSERT INTO receipts (id, retailer, purchaseDate, purchaseTime, total) VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Target', '10-10-2023', '14:33', '9.00');
INSERT INTO items(itemId, receipt_id, shortDescription, price) VALUES (1, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Gatorade', 2.25);