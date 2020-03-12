-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`driver` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `suspended` TINYINT NOT NULL,
  `revoked` TINYINT NOT NULL,
  `birthday` DATE NOT NULL,
  `license` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `license_UNIQUE` (`license` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vehicle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `license` VARCHAR(10) NOT NULL,
  `make` VARCHAR(30) NOT NULL,
  `stolen` TINYINT NOT NULL,
  `registered` TINYINT NOT NULL,
  `wanted` TINYINT NOT NULL,
  `driver_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vehicle_driver_idx` (`driver_id` ASC),
  CONSTRAINT `fk_vehicle_driver`
    FOREIGN KEY (`driver_id`)
    REFERENCES `mydb`.`driver` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`officer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`officer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`offense`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`offense` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `fine` DECIMAL(15,2) NOT NULL,
  `paid` TINYINT NOT NULL,
  `officer_id` INT NOT NULL,
  `driver_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_offense_officer1_idx` (`officer_id` ASC),
  INDEX `fk_offense_driver1_idx` (`driver_id` ASC),
  CONSTRAINT `fk_offense_officer1`
    FOREIGN KEY (`officer_id`)
    REFERENCES `mydb`.`officer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_offense_driver1`
    FOREIGN KEY (`driver_id`)
    REFERENCES `mydb`.`driver` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`warrant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`warrant` (
  `offense_id` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`offense_id`),
  CONSTRAINT `fk_warrant_offense1`
    FOREIGN KEY (`offense_id`)
    REFERENCES `mydb`.`offense` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`citation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`citation` (
  `offense_id` INT NOT NULL,
  `vehicle_id` INT NOT NULL,
  PRIMARY KEY (`offense_id`),
  INDEX `fk_ citation_vehicle1_idx` (`vehicle_id` ASC),
  CONSTRAINT `fk_ citation_encounter1`
    FOREIGN KEY (`offense_id`)
    REFERENCES `mydb`.`offense` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ citation_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `mydb`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`traffic_codes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`traffic_codes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(100) NOT NULL,
  `violation` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ticket` (
  `offense_id` INT NOT NULL,
  PRIMARY KEY (`offense_id`),
  CONSTRAINT `fk_ticket_encounter1`
    FOREIGN KEY (`offense_id`)
    REFERENCES `mydb`.`offense` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`school`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`school` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `day_one` DATE NOT NULL,
  `day_two` DATE NULL,
  `driver_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_school_driver1_idx` (`driver_id` ASC),
  CONSTRAINT `fk_school_driver1`
    FOREIGN KEY (`driver_id`)
    REFERENCES `mydb`.`driver` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`offense_has_traffic_codes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`offense_has_traffic_codes` (
  `offense_id` INT NOT NULL,
  `traffic_codes_id` INT NOT NULL,
  PRIMARY KEY (`offense_id`, `traffic_codes_id`),
  INDEX `fk_offense_has_traffic_codes_traffic_codes1_idx` (`traffic_codes_id` ASC),
  INDEX `fk_offense_has_traffic_codes_offense1_idx` (`offense_id` ASC),
  CONSTRAINT `fk_offense_has_traffic_codes_offense1`
    FOREIGN KEY (`offense_id`)
    REFERENCES `mydb`.`offense` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_offense_has_traffic_codes_traffic_codes1`
    FOREIGN KEY (`traffic_codes_id`)
    REFERENCES `mydb`.`traffic_codes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
