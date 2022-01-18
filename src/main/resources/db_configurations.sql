
CREATE TABLE `sales_notification` (
  `notification_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `notification_type` VARCHAR(100) DEFAULT NULL,
  `notification_mode` VARCHAR(100) DEFAULT NULL,
  `message` TEXT DEFAULT NULL,
  `is_active` INT(11) DEFAULT '1' COMMENT '0=not active,1=active',
  `added_on` DATETIME DEFAULT NULL,
  `updated_on` DATETIME DEFAULT NULL,
  PRIMARY KEY (`notification_id`),
  UNIQUE KEY `notification_type_mode` (`notification_type`,`notification_mode`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4

CREATE TABLE IF NOT EXISTS sales.sales_package (
  `package_id` BIGINT(20) UNSIGNED NOT NULL,
  `package_Name` VARCHAR(80) NOT NULL,
  `package_Description` VARCHAR(200) NOT NULL,
  `package_type` VARCHAR(80) NOT NULL,
  `amount` DECIMAL(7,2)  NOT NULL,
  `validity` DATETIME NOT NULL,
  `suply_hours` VARCHAR(80) DEFAULT NULL,
  `load_max_per_day` DECIMAL(7,2)  NOT NULL,
  `total_load` DECIMAL(7,2)  NOT NULL,
  `is_active` TINYINT(1) NOT NULL,
  `created_on` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(80) DEFAULT NULL,
  `updated_on` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `updated_by` VARCHAR(80) DEFAULT NULL,
   PRIMARY KEY (`package_id`),
  UNIQUE KEY `omc_id_eventtimestamp` (`package_Name`)
  ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
  
  
  CREATE TABLE `customers_acquisition` (
  `cust_acq_id` bigint unsigned NOT NULL  AUTO_INCREMENT ,
  `customer_name` varchar(200) NOT NULL,
  `plant_id` int NOT NULL,
  `gender` varchar(50) NOT NULL,
  `address` varchar(2000) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  `mobile_no` varchar(13) DEFAULT NULL,
  `adhar_no` varchar(20) DEFAULT NULL,
  `package_type` varchar(80) DEFAULT NULL,
  `subscription_start_date` timestamp NULL DEFAULT NULL,
  `subscription_end_date` timestamp NULL DEFAULT NULL,
  `last_success_subscription_date` timestamp NULL DEFAULT NULL,
  `subscription_type` varchar(80) DEFAULT NULL,
  `customer_pic` varchar(500) DEFAULT NULL,
   `latitude` varchar(200) DEFAULT NULL,
  `longitude` varchar(200) DEFAULT NULL,
  `acquisition_status` varchar(500) DEFAULT NULL,
  `sales_executive_id` varchar(500) DEFAULT NULL,
  `upload_caf_path` varchar(500) DEFAULT NULL,
  `upload_installation_certificate` varchar(500) DEFAULT NULL,
  `no_board_installation_required` int(5) DEFAULT NULL,
  `no_sll_installation_required` int(5) DEFAULT NULL,
  `no_rcbs_installation_required` int(5) DEFAULT NULL,
  `no_polls_installation_required` int(5) DEFAULT NULL,
  `no_wire_in_meter_required` int(5) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `created_on` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(80) DEFAULT NULL,
  `updated_on` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `updated_by` VARCHAR(80) DEFAULT NULL,
  PRIMARY KEY (`cust_acq_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci



CREATE TABLE `customers_acquisition_history` (
`history_cust_acq_id` bigint unsigned NOT NULL  AUTO_INCREMENT ,
 `history_created_on` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `cust_acq_id` bigint unsigned NOT NULL  ,
  `customer_name` varchar(200) NOT NULL,
  `plant_id` int NOT NULL,
  `gender` varchar(50) NOT NULL,
  `address` varchar(2000) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL,
  `mobile_no` varchar(13) DEFAULT NULL,
  `adhar_no` varchar(20) DEFAULT NULL,
  `package_type` varchar(80) DEFAULT NULL,
  `subscription_start_date` timestamp NULL DEFAULT NULL,
  `subscription_end_date` timestamp NULL DEFAULT NULL,
  `last_success_subscription_date` timestamp NULL DEFAULT NULL,
  `subscription_type` varchar(80) DEFAULT NULL,
  `customer_pic` varchar(500) DEFAULT NULL,
   `latitude` varchar(200) DEFAULT NULL,
  `longitude` varchar(200) DEFAULT NULL,
  `acquisition_status` varchar(500) DEFAULT NULL,
  `sales_executive_id` varchar(500) DEFAULT NULL,
  `upload_caf_path` varchar(500) DEFAULT NULL,
  `upload_installation_certificate` varchar(500) DEFAULT NULL,
  `no_board_installation_required` int(5) DEFAULT NULL,
  `no_sll_installation_required` int(5) DEFAULT NULL,
  `no_rcbs_installation_required` int(5) DEFAULT NULL,
  `no_polls_installation_required` int(5) DEFAULT NULL,
  `no_wire_in_meter_required` int(5) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `created_on` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(80) DEFAULT NULL,
  `updated_on` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `updated_by` VARCHAR(80) DEFAULT NULL,
  PRIMARY KEY (`history_cust_acq_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE IF NOT EXISTS `plant_sales_inventory` (
`inventory_id` BIGINT UNSIGNED NOT NULL  AUTO_INCREMENT ,
  `plantid` INT(5) UNSIGNED NOT NULL,
  `total_no_polls` INT(5) NULL,
  `used_no_polls` INT(5) NULL,
  `free_no_polls` INT(5) NULL,
  `total_no_sll` INT(5) NULL,
  `used_no_sll` INT(5) NULL,
  `free_no_sll` INT(5) NULL,
  `total_wire_meter` INT(5) NULL,
  `used_wire_meter` INT(5) NULL,
  `free_wire_meter` INT(5) NULL,
  `total_no_board` INT(5) NULL,
  `free_no_board` INT(5) NULL,
  `used_no_board` INT(5) NULL,
  `total_no_rccs` INT(5) NULL,
  `used_no_rccs` INT(5) NULL,
  `free_no_rccs` INT(5) NULL,
  `total_no_gift` INT(5) NULL,
  `used_no_gift` INT(5) NULL,
  `free_no_gift` INT(5) NULL,
  `is_active` TINYINT(1) NOT NULL,
  `created_on` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `created_by` VARCHAR(80) DEFAULT NULL,
  `updated_on` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `updated_by` VARCHAR(80) DEFAULT NULL,
   PRIMARY KEY (`inventory_id`) 
  ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


  CREATE TABLE `rms_plant_poll_mapping` (
  `ppoll_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plant_id` bigint(20) DEFAULT NULL,
  `poll_number` bigint(20) DEFAULT NULL,
  `added_on` DATETIME DEFAULT NULL,
  `updated_on` DATETIME DEFAULT NULL,
  PRIMARY KEY (`ppoll_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4

CREATE TABLE `rms_poll_sll_mapping` (
  `psll_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `poll_id` bigint(20) DEFAULT NULL,
  `sll_number` bigint(20) DEFAULT NULL,
  `added_on` DATETIME DEFAULT NULL,
  `updated_on` DATETIME DEFAULT NULL,
  PRIMARY KEY (`psll_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4


CREATE TABLE `rms_sll_customer_mapping` (
  `sc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) DEFAULT NULL,
  `sll_id` bigint(20) DEFAULT NULL,
  `added_on` DATETIME DEFAULT NULL,
  `updated_on` DATETIME DEFAULT NULL,
  PRIMARY KEY (`sc_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4
  
  
  
