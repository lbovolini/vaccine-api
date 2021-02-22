CREATE DATABASE IF NOT EXISTS `vaccine`;

CREATE TABLE IF NOT EXISTS `vaccine`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `birthday` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE
);

CREATE TABLE IF NOT EXISTS `vaccine`.`vaccination` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `vaccine` VARCHAR(100) NOT NULL,
  `date` DATE NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vaccination_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_vaccination_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `vaccine`.`user` (`id`)
);

