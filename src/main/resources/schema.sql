CREATE TABLE `inventory` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `category` varchar(255) DEFAULT NULL,
                             `expiry_date` date DEFAULT NULL,
                             `location` varchar(255) DEFAULT NULL,
                             `manufacturing_date` date DEFAULT NULL,
                             `model` varchar(255) DEFAULT NULL,
                             `name` varchar(255) DEFAULT NULL,
                             `price` decimal(38,2) DEFAULT NULL,
                             `seller` varchar(255) DEFAULT NULL,
                             `specification` varchar(2000) DEFAULT NULL,
                             `stock` int(11) DEFAULT NULL,
                             `subcategory` varchar(255) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8

/*  indexes..

     Better only on majory used coulmms recomended
    */

CREATE INDEX idx_inventory_name
    ON inventory(name);

CREATE INDEX idx_inventory_category
    ON inventory(category);

CREATE INDEX idx_inventory_seller
    ON inventory(seller);

CREATE INDEX idx_inventory_location
    ON inventory(location);

CREATE INDEX idx_inventory_price
    ON inventory(price);