-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 30, 2021 at 01:30 PM
-- Server version: 8.0.21
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `filmouk`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
CREATE TABLE IF NOT EXISTS `admins` (
  `id_admin` int NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `cin` varchar(8) NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id_article` int NOT NULL AUTO_INCREMENT,
  `id_evenement` int NOT NULL,
  `titre` varchar(10) NOT NULL,
  `contenu` varchar(10) NOT NULL,
  PRIMARY KEY (`id_article`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `candidature`
--

DROP TABLE IF EXISTS `candidature`;
CREATE TABLE IF NOT EXISTS `candidature` (
  `id_candidature` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `id_offre` int NOT NULL,
  `date` date NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`id_candidature`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `categorie_event`
--

DROP TABLE IF EXISTS `categorie_event`;
CREATE TABLE IF NOT EXISTS `categorie_event` (
  `id_cat_event` int NOT NULL AUTO_INCREMENT,
  `nom_categorie_ev` varchar(20) NOT NULL,
  `image_catg_evnt` varchar(10) NOT NULL,
  `description` varchar(10) NOT NULL,
  PRIMARY KEY (`id_cat_event`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `categorie_film`
--

DROP TABLE IF EXISTS `categorie_film`;
CREATE TABLE IF NOT EXISTS `categorie_film` (
  `id_categorie` int NOT NULL,
  `nom_categorie` varchar(255) NOT NULL,
  `image` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categorie_film`
--

INSERT INTO `categorie_film` (`id_categorie`, `nom_categorie`, `image`) VALUES
(1, 'KK', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `categorie_produit`
--

DROP TABLE IF EXISTS `categorie_produit`;
CREATE TABLE IF NOT EXISTS `categorie_produit` (
  `nom_categorie` varchar(10) NOT NULL,
  `id_categorie` int NOT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id_client` int NOT NULL,
  `fname` int NOT NULL,
  `lname` int NOT NULL,
  `cin` int NOT NULL,
  `phone` int NOT NULL,
  KEY `id_client` (`id_client`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id_cat_evenement` int NOT NULL,
  `id_user` int NOT NULL,
  `nom_evenement` varchar(100) NOT NULL,
  `date_evenement` date NOT NULL,
  `id_evenement` int NOT NULL AUTO_INCREMENT,
  `duree_evenement` int NOT NULL,
  `image_evnement` varchar(20) NOT NULL,
  `description` varchar(10) NOT NULL,
  `validate` int DEFAULT NULL,
  PRIMARY KEY (`id_evenement`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE IF NOT EXISTS `film` (
  `id_film` int NOT NULL,
  `id_categorie` int NOT NULL,
  `language` varchar(255) NOT NULL,
  `nom_film` varchar(255) NOT NULL,
  `duree_film` int NOT NULL,
  `image` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id_film`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `films`
--

DROP TABLE IF EXISTS `films`;
CREATE TABLE IF NOT EXISTS `films` (
  `id_film` int NOT NULL AUTO_INCREMENT,
  `id_categorie` int NOT NULL,
  `language` varchar(255) NOT NULL,
  `nom_film` varchar(255) NOT NULL,
  `duree_film` int NOT NULL,
  `image` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `utube` varchar(255) NOT NULL,
  `rated` float NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id_film`)
) ENGINE=MyISAM AUTO_INCREMENT=791374 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `films`
--

INSERT INTO `films` (`id_film`, `id_categorie`, `language`, `nom_film`, `duree_film`, `image`, `description`, `utube`, `rated`, `date`) VALUES
(100, 1, 'English', '\"Arrival\"', 120, 'file:///C:\\Users\\elyes\\Desktop\\Movies (1)\\Movies\\src\\img\\arrival-f-poster-gallery.jpg', '\"Fuelled by his restored faith in humanity and inspired by Superman\'s selfless act, Bruce Wayne and Diana Prince assemble a team of metahumans consisting of Barry Allen, Arthur Curry and Victor Stone to face the catastrophic threat of Steppenwolf and the Parademons who are on the hunt for three Mother Boxes on Earth.\"', '', 0, '0000-00-00'),
(141052, 1, '\"en\"', '\"Justice League\"', 120, 'https://image.tmdb.org/t/p/w500/eifGNCSDuxJeS1loAXil5bIGgvC.jpg', '\"Fuelled by his restored faith in humanity and inspired by Superman\'s selfless act, Bruce Wayne and Diana Prince assemble a team of metahumans consisting of Barry Allen, Arthur Curry and Victor Stone to face the catastrophic threat of Steppenwolf and the Parademons who are on the hunt for three Mother Boxes on Earth.\"', '', 0, '0000-00-00'),
(99, 1, 'English', '\"Assasin\'s Creed\"', 120, 'file:///C:\\Users\\elyes\\Desktop\\Movies (1)\\Movies\\src\\img\\assassins-creed-poster2.jpg', '\"Fuelled by his restored faith in humanity and inspired by Superman\'s selfless act, Bruce Wayne and Diana Prince assemble a team of metahumans consisting of Barry Allen, Arthur Curry and Victor Stone to face the catastrophic threat of Steppenwolf and the Parademons who are on the hunt for three Mother Boxes on Earth.\"', '', 0, '0000-00-00'),
(217993, 1, '\"en\"', '\"Justice League: War\"', 120, 'https://image.tmdb.org/t/p/w500/eu6zEhpt9QVgZk8T4FJCwKCbJkq.jpg', '\"The world is under attack by an alien armada led by the powerful Apokoliptian, Darkseid. A group of superheroes consisting of Superman, Batman, Wonder Woman, The Flash, Green Lantern, Cyborg, and Shazam must set aside their differences and gather together to defend Earth.\"', '', 0, '0000-00-00'),
(481848, 1, '\"en\"', '\"The Call of the Wild\"', 120, 'https://image.tmdb.org/t/p/w500/33VdppGbeNxICrFUtW2WpGHvfYc.jpg', '\"Buck is a big-hearted dog whose blissful domestic life is turned upside down when he is suddenly uprooted from his California home and transplanted to the exotic wilds of the Yukon during the Gold Rush of the 1890s. As the newest rookie on a mail delivery dog sled team—and later its leader—Buck experiences the adventure of a lifetime, ultimately finding his true place in the world and becoming his own master.\"', '', 0, '0000-00-00'),
(101, 1, 'English', '\"Bastille Day\"', 120, 'file:///C:\\Users\\elyes\\Desktop\\Movies (1)\\Movies\\src\\img\\bastille_day_the_take.jpg', '\"Fuelled by his restored faith in humanity and inspired by Superman\'s selfless act, Bruce Wayne and Diana Prince assemble a team of metahumans consisting of Barry Allen, Arthur Curry and Victor Stone to face the catastrophic threat of Steppenwolf and the Parademons who are on the hunt for three Mother Boxes on Earth.\"', '', 0, '0000-00-00'),
(102, 1, 'English', '\"Solace\"', 120, 'file:///C:\\Users\\elyes\\Desktop\\Movies (1)\\Movies\\src\\img\\Solace-poster-2-large.jpg', '\"Fuelled by his restored faith in humanity and inspired by Superman\'s selfless act, Bruce Wayne and Diana Prince assemble a team of metahumans consisting of Barry Allen, Arthur Curry and Victor Stone to face the catastrophic threat of Steppenwolf and the Parademons who are on the hunt for three Mother Boxes on Earth.\"', '', 0, '0000-00-00'),
(103, 1, 'English', '\"Rogue one\"', 120, 'file:///C:\\Users\\elyes\\Desktop\\Movies (1)\\Movies\\src\\img\\star.jpg', '\"Fuelled by his restored faith in humanity and inspired by Superman\'s selfless act, Bruce Wayne and Diana Prince assemble a team of metahumans consisting of Barry Allen, Arthur Curry and Victor Stone to face the catastrophic threat of Steppenwolf and the Parademons who are on the hunt for three Mother Boxes on Earth.\"', '', 0, '0000-00-00'),
(557, 1, '\"en\"', '\"Spider-Man\"', 120, 'https://image.tmdb.org/t/p/w500/gh4cZbhZxyTbgxQPxD0dOudNPTn.jpg', '\"After being bitten by a genetically altered spider, nerdy high school student Peter Parker is endowed with amazing powers to become the Amazing superhero known as Spider-Man.\"', '', 0, '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `offre`
--

DROP TABLE IF EXISTS `offre`;
CREATE TABLE IF NOT EXISTS `offre` (
  `id_offre` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `date` date NOT NULL,
  `description` varchar(10) NOT NULL,
  PRIMARY KEY (`id_offre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `planning`
--

DROP TABLE IF EXISTS `planning`;
CREATE TABLE IF NOT EXISTS `planning` (
  `id_planning` int NOT NULL,
  `id_film` int NOT NULL,
  `id_salle` int NOT NULL,
  `date` date NOT NULL,
  `projection_time` varchar(255) NOT NULL,
  `price` int NOT NULL,
  KEY `id_salle` (`id_salle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `id_produit` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prix` int NOT NULL,
  `image` varchar(20) NOT NULL,
  `description` varchar(10) NOT NULL,
  PRIMARY KEY (`id_produit`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
CREATE TABLE IF NOT EXISTS `rate` (
  `id_rate` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `id_film` int NOT NULL,
  `note` int NOT NULL,
  `comment` text CHARACTER SET latin1 COLLATE latin1_swedish_ci,
  PRIMARY KEY (`id_rate`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rate`
--

INSERT INTO `rate` (`id_rate`, `id_user`, `id_film`, `note`, `comment`) VALUES
(1, 1, 1, 6, NULL),
(2, 2, 1, 5, NULL),
(5, 1, 481848, 7, NULL),
(4, 1, 141052, 10, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id_salle` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `governorate` varchar(255) NOT NULL,
  `adress` varchar(255) NOT NULL,
  PRIMARY KEY (`id_salle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `salle_account`
--

DROP TABLE IF EXISTS `salle_account`;
CREATE TABLE IF NOT EXISTS `salle_account` (
  `id_sa` int NOT NULL,
  `id_salle` int NOT NULL,
  PRIMARY KEY (`id_sa`),
  KEY `id_salle` (`id_salle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `username`, `password`, `email`) VALUES
(1, 'ilyes', '123', 'ilyes@esprit.tn');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
