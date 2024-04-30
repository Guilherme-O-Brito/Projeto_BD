-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema livraria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema livraria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `livraria` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `livraria` ;

-- -----------------------------------------------------
-- Table `livraria`.`assinatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`assinatura` (
  `id` INT UNSIGNED NOT NULL,
  `tema` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `livraria`.`editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`editora` (
  `nome` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `telefone` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`nome`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `livraria`.`assinatura_has_editora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`assinatura_has_editora` (
  `assinatura_id` INT UNSIGNED NOT NULL,
  `editora_nome` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`assinatura_id`, `editora_nome`),
  INDEX `fk_assinatura_has_editora_editora1_idx` (`editora_nome` ASC) VISIBLE,
  INDEX `fk_assinatura_has_editora_assinatura1_idx` (`assinatura_id` ASC) VISIBLE,
  CONSTRAINT `fk_assinatura_has_editora_assinatura1`
    FOREIGN KEY (`assinatura_id`)
    REFERENCES `livraria`.`assinatura` (`id`),
  CONSTRAINT `fk_assinatura_has_editora_editora1`
    FOREIGN KEY (`editora_nome`)
    REFERENCES `livraria`.`editora` (`nome`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `livraria`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`departamento` (
  `nome` VARCHAR(50) NOT NULL,
  `area` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `telefone` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`nome`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `livraria`.`chefe_de_departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`chefe_de_departamento` (
  `nome` VARCHAR(50) NOT NULL,
  `matricula` INT UNSIGNED NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `telefone` VARCHAR(50) NOT NULL,
  `departamento_nome` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`nome`, `departamento_nome`),
  INDEX `fk_chefe_de_departamento_departamento1_idx` (`departamento_nome` ASC) VISIBLE,
  CONSTRAINT `fk_chefe_de_departamento_departamento1`
    FOREIGN KEY (`departamento_nome`)
    REFERENCES `livraria`.`departamento` (`nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `livraria`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`cliente` (
  `nome` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `telefone` VARCHAR(50) NOT NULL,
  `endereco` VARCHAR(50) NOT NULL,
  `data_de_nascimento` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`nome`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `livraria`.`cliente_has_assinatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`cliente_has_assinatura` (
  `cliente_nome` VARCHAR(50) NOT NULL,
  `assinatura_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`cliente_nome`, `assinatura_id`),
  INDEX `fk_cliente_has_assinatura_assinatura1_idx` (`assinatura_id` ASC) VISIBLE,
  INDEX `fk_cliente_has_assinatura_cliente1_idx` (`cliente_nome` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_has_assinatura_assinatura1`
    FOREIGN KEY (`assinatura_id`)
    REFERENCES `livraria`.`assinatura` (`id`),
  CONSTRAINT `fk_cliente_has_assinatura_cliente1`
    FOREIGN KEY (`cliente_nome`)
    REFERENCES `livraria`.`cliente` (`nome`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `livraria`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`funcionario` (
  `nome` VARCHAR(50) NOT NULL,
  `data_de_nascimento` VARCHAR(50) NOT NULL,
  `cargo` VARCHAR(50) NOT NULL,
  `matricula` INT UNSIGNED NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `telefone` VARCHAR(50) NOT NULL,
  `departamento_nome` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`nome`, `departamento_nome`),
  INDEX `fk_funcionario_departamento1_idx` (`departamento_nome` ASC) VISIBLE,
  CONSTRAINT `fk_funcionario_departamento1`
    FOREIGN KEY (`departamento_nome`)
    REFERENCES `livraria`.`departamento` (`nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `livraria`.`livros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livraria`.`livros` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `autor` VARCHAR(50) NOT NULL,
  `genero` VARCHAR(50) NOT NULL,
  `assunto` VARCHAR(50) NOT NULL,
  `edicao` VARCHAR(50) NOT NULL,
  `estoque` INT UNSIGNED NOT NULL,
  `editora_nome` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`, `editora_nome`),
  INDEX `fk_livros_editora1_idx` (`editora_nome` ASC) VISIBLE,
  CONSTRAINT `fk_livros_editora1`
    FOREIGN KEY (`editora_nome`)
    REFERENCES `livraria`.`editora` (`nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
