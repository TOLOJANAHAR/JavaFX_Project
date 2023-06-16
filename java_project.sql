-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 16 juin 2023 à 19:07
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `java_project`
--

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

DROP TABLE IF EXISTS `achat`;
CREATE TABLE IF NOT EXISTS `achat` (
  `numAchat` int NOT NULL AUTO_INCREMENT,
  `numProd` varchar(5) DEFAULT NULL,
  `nomClient` varchar(50) DEFAULT NULL,
  `nbrLitre` int DEFAULT NULL,
  `dateAchat` int DEFAULT NULL,
  PRIMARY KEY (`numAchat`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `achat`
--

INSERT INTO `achat` (`numAchat`, `numProd`, `nomClient`, `nbrLitre`, `dateAchat`) VALUES
(1, '05', 'nata', 15, 0);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `numClient` int NOT NULL AUTO_INCREMENT,
  `nomClient` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numClient`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`numClient`, `nomClient`) VALUES
(1, 'vania'),
(3, 'tata'),
(4, 'verooo'),
(5, 'verooo'),
(6, 'verooo');

-- --------------------------------------------------------

--
-- Structure de la table `entree`
--

DROP TABLE IF EXISTS `entree`;
CREATE TABLE IF NOT EXISTS `entree` (
  `numEntree` int NOT NULL AUTO_INCREMENT,
  `numProd` varchar(5) DEFAULT NULL,
  `stockEntree` int DEFAULT NULL,
  `dateEntree` date DEFAULT NULL,
  PRIMARY KEY (`numEntree`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `entree`
--

INSERT INTO `entree` (`numEntree`, `numProd`, `stockEntree`, `dateEntree`) VALUES
(2, '33', 22000, '0000-00-00');

-- --------------------------------------------------------

--
-- Structure de la table `entretien`
--

DROP TABLE IF EXISTS `entretien`;
CREATE TABLE IF NOT EXISTS `entretien` (
  `numEntr` int NOT NULL AUTO_INCREMENT,
  `numServ` varchar(3) DEFAULT NULL,
  `immatriculation_voiture` int DEFAULT NULL,
  `nomClient` varchar(50) DEFAULT NULL,
  `dateEntr` int DEFAULT NULL,
  PRIMARY KEY (`numEntr`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `entretien`
--

INSERT INTO `entretien` (`numEntr`, `numServ`, `immatriculation_voiture`, `nomClient`, `dateEntr`) VALUES
(1, '01', 1122, 'nata', 0),
(7, '01', 1122, 'lala', 0),
(4, '02', 1551, 'ny', 0),
(5, '01', 1122, 'lala', 0),
(6, '02', 1551, 'sara', 0),
(8, '02', 1551, 'sara', 0),
(9, '02', 1551, 'vania', 0),
(10, '02', 1551, 'vania', 0),
(11, '56', 1551, 'tata', 0),
(12, '1', 1551, 'verooo', 0),
(13, '1', 1551, 'verooo', 0),
(14, '1', 1551, 'verooo', 0);

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `numProd` int NOT NULL AUTO_INCREMENT,
  `design` varchar(30) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  PRIMARY KEY (`numProd`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`numProd`, `design`, `stock`) VALUES
(3, 'sandratra', 22),
(5, 'vero', 9),
(4, 'dada', 2),
(6, 'sitraka', 655);

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `numServ` int NOT NULL AUTO_INCREMENT,
  `service` varchar(5) DEFAULT NULL,
  `prix` int DEFAULT NULL,
  PRIMARY KEY (`numServ`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `service`
--

INSERT INTO `service` (`numServ`, `service`, `prix`) VALUES
(2, '55', 22000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
