-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 04 Φεβ 2013 στις 07:04:05
-- Έκδοση διακομιστή: 5.5.27
-- Έκδοση PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Βάση: `landregistrydb`
--
DROP DATABASE IF EXISTS `landregistrydb`;
CREATE DATABASE `landregistrydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `landregistrydb`;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `lands`
--

DROP TABLE IF EXISTS `lands`;
CREATE TABLE IF NOT EXISTS `lands` (
  `landID` int(11) NOT NULL AUTO_INCREMENT,
  `landName` varchar(48) NOT NULL,
  `landPlace` varchar(64) NOT NULL,
  `landKAEK` int(11) NOT NULL,
  `landType` varchar(32) NOT NULL,
  `landPlan` varchar(32) NOT NULL,
  `landSize` double NOT NULL,
  `landOccupy` varchar(32) NOT NULL,
  `landPerson` int(11) NOT NULL,
  PRIMARY KEY (`landID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Άδειασμα δεδομένων του πίνακα `lands`
--

INSERT INTO `lands` (`landID`, `landName`, `landPlace`, `landKAEK`, `landType`, `landPlan`, `landSize`, `landOccupy`, `landPerson`) VALUES
(2, 'Αμυγδαλιές', 'Χαλκίδα Κέντρο', 1, 'Οικόπεδο', 'Εντός Σχεδίου', 1200, 'Ιδιόκτητο', 8),
(3, 'Νερατζιές', 'Χαλκίδα Προάστια', 4, 'Κατοικία', 'Εκτός Σχεδίου', 5000, 'Αντιπαροχή', 4),
(4, ' Γκούμα', 'Βουνό', 14, 'Κτήμα', 'Εκτός Σχεδίου', 23500, 'Ιδιόκτητο', 6),
(5, 'Αμπέλια', 'Βουνό', 2, 'Κτήμα', 'Εκτός Σχεδίου', 12000, 'Παροχή', 7),
(6, 'Κονάκι', 'Προφήτης Ηλίας', 5, 'Οικόπεδο', 'Εντός Σχεδίου', 10000, 'Ιδιόκτητο', 5),
(7, 'Καλέτζι', 'Χαλκίδα', 14, 'Οικόπεδο', 'Εντός Σχεδίου', 1500, 'Αντιπαροχή', 6);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `persons`
--

DROP TABLE IF EXISTS `persons`;
CREATE TABLE IF NOT EXISTS `persons` (
  `personID` int(11) NOT NULL AUTO_INCREMENT,
  `personName` varchar(25) NOT NULL,
  `personSurname` varchar(25) NOT NULL,
  `personAddress` varchar(64) NOT NULL,
  `personTelephone` varchar(12) NOT NULL,
  `personIdentity` varchar(12) NOT NULL,
  `personAFM` varchar(12) NOT NULL,
  `personEmail` varchar(32) NOT NULL,
  PRIMARY KEY (`personID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Άδειασμα δεδομένων του πίνακα `persons`
--

INSERT INTO `persons` (`personID`, `personName`, `personSurname`, `personAddress`, `personTelephone`, `personIdentity`, `personAFM`, `personEmail`) VALUES
(4, 'Αστέριος', 'Λάφτσης', 'Αλεξάνδρας 23', '2104537289', 'Κ895312', '231167156', 'a.laftsis@gmail.com'),
(5, 'Νικόλαος', 'Γκίκας', 'Αμαλιάδας 27', '2221076543', 'Φ789532', '117745123', 'n.gkikas@hotmail.com'),
(6, 'Ηλίας', 'Αλεξίου', 'Μνημονείου 87', '2221053890', 'Η672897', '567822345', 'anarxikos@msn.com'),
(7, 'Διονύσιος', 'Παπαιωάννου', 'Φιλοξέρους 78', '2314567832', 'Δ567892', '389996543', 'd.papaioannou@yahoo.gr'),
(8, 'Αλέξανδρος', 'Παπαδιαμάντης', 'Καλυμνώνας 49', '2221067832', 'Σ892345', '1118853267', 'al.pap@hotbird.com');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `userID` int(11) NOT NULL,
  `username` varchar(30) CHARACTER SET latin1 NOT NULL,
  `password` varchar(12) CHARACTER SET latin1 NOT NULL,
  `realname` varchar(64) CHARACTER SET latin1 NOT NULL,
  `UserLocked` tinyint(1) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `users`
--

INSERT INTO `users` (`userID`, `username`, `password`, `realname`, `UserLocked`) VALUES
(0, 'user', '1234', 'Simple User', 0),
(1, 'admin', 'admin', 'administrator', 0),
(2, 'sysadmin', 'sysadmin', 'System Administrator', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
