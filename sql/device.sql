SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `tb_soil`;
CREATE TABLE tb_soil (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 soil1 VARCHAR(255),
                                 soil2 VARCHAR(255),
                                 soil3 VARCHAR(255),
                                 soil4 VARCHAR(255),
                                 soil5 VARCHAR(255),
                                 soil6 VARCHAR(255),
                                 soil7 VARCHAR(255),
                                 soil8 VARCHAR(255),
                                 time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


DROP TABLE IF EXISTS `tb_command`;
CREATE TABLE `tb_command`  (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `data` int NULL DEFAULT NULL,
                               `create_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                               `device_id` int NULL DEFAULT NULL,
                               PRIMARY KEY (`id`) USING BTREE,
                               INDEX `p_cmd`(`device_id` ASC) USING BTREE,
                               CONSTRAINT `p_cmd` FOREIGN KEY (`device_id`) REFERENCES `tb_device` (`deviceID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_data
-- ----------------------------
DROP TABLE IF EXISTS `tb_data`;
CREATE TABLE `tb_data`  (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `device_id` int NOT NULL,
                            `create_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                            `oxygen` decimal(10, 2) NULL DEFAULT NULL,
                            `humidity` decimal(10, 2) NULL DEFAULT NULL,
                            `temperature` decimal(10, 2) NULL DEFAULT NULL,
                            `youji` decimal(10, 2) NULL DEFAULT NULL,
                            `co2` decimal(10, 2) NULL DEFAULT NULL,
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `p_data`(`device_id` ASC) USING BTREE,
                            CONSTRAINT `p_data` FOREIGN KEY (`device_id`) REFERENCES `tb_device` (`deviceID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1222 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for tb_device
-- ----------------------------
DROP TABLE IF EXISTS `tb_device`;
CREATE TABLE `tb_device`  (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                              `deviceID` int NULL DEFAULT NULL,
                              `account_id` int NULL DEFAULT NULL,
                              `type` bigint NULL DEFAULT 1,
                              PRIMARY KEY (`id`) USING BTREE,
                              INDEX `deviceID`(`deviceID` ASC) USING BTREE,
                              INDEX `p_account`(`account_id` ASC) USING BTREE,
                              CONSTRAINT `p_account` FOREIGN KEY (`account_id`) REFERENCES `tb_account` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1266 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;