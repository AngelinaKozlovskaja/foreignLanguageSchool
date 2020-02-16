-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


CREATE SCHEMA IF NOT EXISTS `courses` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `courses` ;

CREATE TABLE IF NOT EXISTS `courses`.`lang` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `languageName` VARCHAR(45) NOT NULL,
  `costCourse` DOUBLE NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `courses`.`class` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `classNumber` INT(11) NOT NULL,
  `lang` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_class_lang_idx` (`lang` ASC) VISIBLE,
  CONSTRAINT `fk_class_lang`
    FOREIGN KEY (`lang`)
    REFERENCES `courses`.`lang` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `courses`.`customer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `secondName` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `numberPhone` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `userRole` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `courses`.`message` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(255) NOT NULL,
  `accept` TINYINT(4) NOT NULL DEFAULT '0',
  `sender` INT(11) NOT NULL,
  `taker` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_message_customer_from_idx` (`sender` ASC) VISIBLE,
  INDEX `fk_message_customer_to_idx` (`taker` ASC) VISIBLE,
  CONSTRAINT `fk_message_customer_from`
    FOREIGN KEY (`sender`)
    REFERENCES `courses`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_message_customer_to`
    FOREIGN KEY (`taker`)
    REFERENCES `courses`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `courses`.`request` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `customer` INT(11) NOT NULL,
  `accept` TINYINT(4) NOT NULL DEFAULT '0',
  `commentary` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_request_customer_idx` (`customer` ASC) VISIBLE,
  CONSTRAINT `fk_request_customer`
    FOREIGN KEY (`customer`)
    REFERENCES `courses`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `courses`.`review` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `commentary` VARCHAR(255) NOT NULL,
  `customer` INT(11) NOT NULL,
  `lang` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_customer_idx` (`customer` ASC) VISIBLE,
  INDEX `fk_review_lang_idx` (`lang` ASC) VISIBLE,
  CONSTRAINT `fk_review_customer`
    FOREIGN KEY (`customer`)
    REFERENCES `courses`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_review_lang`
    FOREIGN KEY (`lang`)
    REFERENCES `courses`.`lang` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `courses`.`studentsclasses` (
  `customer` INT(11) NOT NULL,
  `class` INT(11) NOT NULL,
  PRIMARY KEY (`customer`, `class`),
  INDEX `fk_grps_class_idx` (`class` ASC) VISIBLE,
  CONSTRAINT `fk_grps_class`
    FOREIGN KEY (`class`)
    REFERENCES `courses`.`class` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_grps_customer`
    FOREIGN KEY (`customer`)
    REFERENCES `courses`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
