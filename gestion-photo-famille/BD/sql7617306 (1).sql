-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Hôte : sql7.freemysqlhosting.net
-- Généré le :  sam. 13 mai 2023 à 20:26
-- Version du serveur :  5.5.62-0ubuntu0.14.04.1
-- Version de PHP :  7.0.33-0ubuntu0.16.04.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `sql7617306`
--

-- --------------------------------------------------------

--
-- Structure de la table `ALBUM`
--

CREATE TABLE `ALBUM` (
  `IDAlbum` int(11) NOT NULL,
  `NomAlbum` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ALBUM`
--

INSERT INTO `ALBUM` (`IDAlbum`, `NomAlbum`) VALUES
(1, 'Photos mariage Elisée et Marianne.'),
(2, 'Photos naissance des enfants.');

-- --------------------------------------------------------

--
-- Structure de la table `APPARAIT`
--

CREATE TABLE `APPARAIT` (
  `IDPhoto` int(11) NOT NULL,
  `IDInd` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `APPARAIT`
--

INSERT INTO `APPARAIT` (`IDPhoto`, `IDInd`) VALUES
(6, 2),
(1, 3),
(6, 3),
(1, 4),
(6, 4),
(6, 5),
(6, 6),
(3, 7),
(3, 8),
(5, 8),
(5, 9),
(2, 10),
(3, 10),
(5, 10),
(5, 11),
(4, 12),
(5, 12);

-- --------------------------------------------------------

--
-- Structure de la table `EVENEMENT`
--

CREATE TABLE `EVENEMENT` (
  `IDEvenement` int(11) NOT NULL,
  `LibelleEvenement` varchar(50) NOT NULL,
  `DateEvenement` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `EVENEMENT`
--

INSERT INTO `EVENEMENT` (`IDEvenement`, `LibelleEvenement`, `DateEvenement`) VALUES
(1, 'Mariage Elisée et Marianne.', '14 juillet 1920'),
(2, 'Naissance de Colin.', '8 mai 1970'),
(3, 'Naissance de Laura.', '15 décembre 2006');

-- --------------------------------------------------------

--
-- Structure de la table `INDIVIDU`
--

CREATE TABLE `INDIVIDU` (
  `IDInd` int(25) NOT NULL,
  `IDPere` int(11) NOT NULL,
  `IDMere` int(11) NOT NULL,
  `nomInd` varchar(50) NOT NULL,
  `PrenomInd` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `INDIVIDU`
--

INSERT INTO `INDIVIDU` (`IDInd`, `IDPere`, `IDMere`, `nomInd`, `PrenomInd`) VALUES
(1, 0, 0, 'Durand', 'Xavier'),
(2, 0, 0, 'Devilliers', 'Sarah'),
(3, 0, 0, 'Hachette', 'Elisée'),
(4, 1, 2, 'Durand', 'Marianne'),
(5, 3, 4, 'Hachette', 'Vivianne'),
(6, 3, 4, 'Hachette', 'Florence'),
(7, 0, 0, 'Lefrançois', 'Marc-Antoine'),
(8, 0, 0, 'Beauvais', 'Juliette'),
(9, 7, 8, 'Lefrançois', 'Cécilia'),
(10, 7, 8, 'Lefrançois', 'Colin'),
(11, 0, 0, 'Ponce', 'Anaïs'),
(12, 10, 11, 'Lefrançois', 'Laura');

-- --------------------------------------------------------

--
-- Structure de la table `PHOTO`
--

CREATE TABLE `PHOTO` (
  `IDPhoto` int(11) NOT NULL,
  `IDAlbum` int(11) NOT NULL,
  `NumPage` int(11) NOT NULL,
  `IDEvenement` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `PHOTO`
--

INSERT INTO `PHOTO` (`IDPhoto`, `IDAlbum`, `NumPage`, `IDEvenement`) VALUES
(1, 1, 1, 1),
(2, 2, 1, 2),
(3, 2, 2, 2),
(4, 2, 3, 3),
(5, 2, 3, 3),
(6, 1, 1, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `ALBUM`
--
ALTER TABLE `ALBUM`
  ADD PRIMARY KEY (`IDAlbum`),
  ADD KEY `NomAlbum` (`NomAlbum`);

--
-- Index pour la table `APPARAIT`
--
ALTER TABLE `APPARAIT`
  ADD PRIMARY KEY (`IDPhoto`,`IDInd`),
  ADD KEY `IDInd` (`IDInd`);

--
-- Index pour la table `EVENEMENT`
--
ALTER TABLE `EVENEMENT`
  ADD PRIMARY KEY (`IDEvenement`);

--
-- Index pour la table `INDIVIDU`
--
ALTER TABLE `INDIVIDU`
  ADD PRIMARY KEY (`IDInd`);

--
-- Index pour la table `PHOTO`
--
ALTER TABLE `PHOTO`
  ADD PRIMARY KEY (`IDPhoto`),
  ADD KEY `IDEvenement` (`IDEvenement`),
  ADD KEY `IDAlbum` (`IDAlbum`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `APPARAIT`
--
ALTER TABLE `APPARAIT`
  ADD CONSTRAINT `APPARAIT_ibfk_2` FOREIGN KEY (`IDInd`) REFERENCES `INDIVIDU` (`IDInd`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `APPARAIT_ibfk_1` FOREIGN KEY (`IDPhoto`) REFERENCES `PHOTO` (`IDPhoto`);

--
-- Contraintes pour la table `PHOTO`
--
ALTER TABLE `PHOTO`
  ADD CONSTRAINT `PHOTO_ibfk_2` FOREIGN KEY (`IDAlbum`) REFERENCES `ALBUM` (`IDAlbum`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `PHOTO_ibfk_1` FOREIGN KEY (`IDEvenement`) REFERENCES `EVENEMENT` (`IDEvenement`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
