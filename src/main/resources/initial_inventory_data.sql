INSERT INTO inventory
(id, name, category, subcategory, manufacturing_date, expiry_date,
 specification, price, stock, model, seller, location)
VALUES

    (1, 'Dell Inspiron Laptop', 'Electronics', 'Laptop',
     '2025-01-10', NULL,
     'Intel i5, 16GB RAM, 512GB SSD',
     65000.00, 25, 'Inspiron 15', 'Dell Store', 'Hyderabad'),

    (2, 'HP Pavilion Laptop', 'Electronics', 'Laptop',
     '2025-02-15', NULL,
     'Intel i7, 16GB RAM, 1TB SSD',
     82000.00, 18, 'Pavilion 14', 'HP World', 'Bangalore'),

    (3, 'Samsung Galaxy S25', 'Electronics', 'Mobile',
     '2025-03-01', NULL,
     '256GB, 12GB RAM',
     95000.00, 40, 'Galaxy S25', 'Samsung Plaza', 'Chennai'),

    (4, 'Apple iPhone 17', 'Electronics', 'Mobile',
     '2025-04-01', NULL,
     '256GB Storage',
     125000.00, 15, 'iPhone 17', 'Apple Store', 'Mumbai'),

    (5, 'Sony Bravia TV', 'Electronics', 'Television',
     '2025-01-05', NULL,
     '55 Inch 4K Smart TV',
     72000.00, 10, 'Bravia X90', 'Sony Center', 'Delhi'),

    (6, 'Amul Milk', 'Food', 'Dairy',
     '2026-05-20', '2026-06-10',
     '500ml Toned Milk',
     30.00, 200, 'MILK500', 'Amul Distributor', 'Hyderabad'),

    (7, 'Britannia Bread', 'Food', 'Bakery',
     '2026-06-01', '2026-06-08',
     'Whole Wheat Bread',
     45.00, 120, 'BREAD-WW', 'Britannia Dealer', 'Hyderabad'),

    (8, 'Parle-G Biscuits', 'Food', 'Snacks',
     '2026-05-15', '2026-11-15',
     '800g Family Pack',
     80.00, 350, 'PG-800', 'Parle Distributor', 'Vijayawada'),

    (9, 'Coca Cola', 'Food', 'Beverages',
     '2026-05-10', '2027-05-10',
     '2L Bottle',
     95.00, 500, 'CC-2L', 'Coca Cola Agency', 'Chennai'),

    (10, 'LG Refrigerator', 'Appliances', 'Refrigerator',
     '2025-01-15', NULL,
     '340L Double Door',
     42000.00, 8, 'LG340D', 'LG Showroom', 'Bangalore'),

    (11, 'Whirlpool Washing Machine', 'Appliances', 'Washing Machine',
     '2025-02-20', NULL,
     '7kg Front Load',
     38000.00, 12, 'WH-7FL', 'Whirlpool Dealer', 'Hyderabad'),

    (12, 'Godrej Air Conditioner', 'Appliances', 'AC',
     '2025-03-12', NULL,
     '1.5 Ton Inverter AC',
     45000.00, 14, 'GDJ-1.5T', 'Godrej Store', 'Delhi'),

    (13, 'Nike Running Shoes', 'Fashion', 'Footwear',
     '2025-04-10', NULL,
     'Men Size 9',
     5500.00, 75, 'Nike Air Zoom', 'Nike Store', 'Mumbai'),

    (14, 'Adidas Sports Shoes', 'Fashion', 'Footwear',
     '2025-03-20', NULL,
     'Men Size 10',
     6200.00, 60, 'Adidas RunX', 'Adidas Outlet', 'Chennai'),

    (15, 'Levis Jeans', 'Fashion', 'Clothing',
     '2025-02-10', NULL,
     'Slim Fit Blue',
     2500.00, 90, 'LV-501', 'Levis Store', 'Bangalore'),

    (16, 'Parker Pen', 'Stationery', 'Pens',
     '2025-01-01', NULL,
     'Premium Ball Pen',
     450.00, 300, 'Parker-Jotter', 'Office Supplies', 'Hyderabad'),

    (17, 'Classmate Notebook', 'Stationery', 'Notebook',
     '2025-01-01', NULL,
     '200 Pages',
     120.00, 500, 'CM-200', 'Stationery Mart', 'Vijayawada'),

    (18, 'Dell Monitor', 'Electronics', 'Monitor',
     '2025-04-18', NULL,
     '27 Inch QHD',
     22000.00, 22, 'Dell S2721', 'Dell Store', 'Hyderabad'),

    (19, 'Logitech Mouse', 'Electronics', 'Accessories',
     '2025-05-01', NULL,
     'Wireless Mouse',
     1200.00, 140, 'M331', 'Logitech Partner', 'Bangalore'),

    (20, 'HP Keyboard', 'Electronics', 'Accessories',
     '2025-05-02', NULL,
     'Mechanical Keyboard',
     3500.00, 80, 'HP MK500', 'HP World', 'Chennai');