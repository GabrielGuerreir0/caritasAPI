CREATE TABLE IF NOT EXISTS `user`(
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(80) NOT NULL,
  `senha` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);

