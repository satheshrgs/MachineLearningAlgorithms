-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 05, 2017 at 06:54 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `datasets`
--

-- --------------------------------------------------------

--
-- Table structure for table `buys_computer`
--

CREATE TABLE `buys_computer` (
  `age` varchar(15) NOT NULL,
  `income` varchar(15) NOT NULL,
  `student` varchar(15) NOT NULL,
  `credit_rating` varchar(15) NOT NULL,
  `buys_computer` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buys_computer`
--

INSERT INTO `buys_computer` (`age`, `income`, `student`, `credit_rating`, `buys_computer`) VALUES
('youth', 'high', 'no', 'fair', 'no'),
('youth', 'high', 'no', 'excellent', 'no'),
('middle', 'high', 'no', 'fair', 'yes'),
('senior', 'medium', 'no', 'fair', 'yes'),
('senior', 'low', 'yes', 'fair', 'yes'),
('senior', 'low', 'yes', 'excellent', 'no'),
('middle', 'low', 'yes', 'excellent', 'yes'),
('youth', 'medium', 'no', 'fair', 'no'),
('youth', 'low', 'yes', 'fair', 'yes'),
('senior', 'medium', 'yes', 'fair', 'yes'),
('youth', 'medium', 'yes', 'excellent', 'yes'),
('middle', 'medium', 'no', 'excellent', 'yes'),
('middle', 'high', 'yes', 'fair', 'yes'),
('senior', 'medium', 'no', 'excellent', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `kmeans`
--

CREATE TABLE `kmeans` (
  `extra` float NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kmeans`
--

INSERT INTO `kmeans` (`extra`, `id`) VALUES
(0.7, 1),
(3.4, 6),
(3.7, 7),
(0.8, 8),
(0, 9),
(1.9, 1),
(0.8, 2),
(1.1, 3),
(0.1, 4),
(4.4, 6);

-- --------------------------------------------------------

--
-- Table structure for table `linear_regression`
--

CREATE TABLE `linear_regression` (
  `X` float NOT NULL,
  `Y` float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `linear_regression`
--

INSERT INTO `linear_regression` (`X`, `Y`) VALUES
(3, 4.9),
(3.5, 5.1),
(3.2, 4.7),
(3.1, 4.6),
(3.6, 5),
(3.9, 5.4),
(3.4, 4.6),
(3.4, 5),
(2.9, 4.4),
(3.1, 4.9);

-- --------------------------------------------------------

--
-- Table structure for table `weather`
--

CREATE TABLE `weather` (
  `Outlook` varchar(10) NOT NULL,
  `Temperature` varchar(10) NOT NULL,
  `Humidity` varchar(10) NOT NULL,
  `Windy` varchar(10) NOT NULL,
  `Play` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `weather`
--

INSERT INTO `weather` (`Outlook`, `Temperature`, `Humidity`, `Windy`, `Play`) VALUES
('sunny', 'hot', 'high', 'TRUE', 'no'),
('overcast', 'hot', 'high', 'FALSE', 'yes'),
('rainy', 'mild', 'high', 'FALSE', 'yes'),
('rainy', 'cool', 'normal', 'FALSE', 'yes'),
('rainy', 'cool', 'normal', 'TRUE', 'no'),
('overcast', 'cool', 'normal', 'TRUE', 'yes'),
('sunny', 'mild', 'high', 'FALSE', 'no'),
('sunny', 'cool', 'normal', 'FALSE', 'yes'),
('rainy', 'mild', 'normal', 'FALSE', 'yes'),
('sunny', 'mild', 'normal', 'TRUE', 'yes'),
('overcast', 'mild', 'high', 'TRUE', 'yes'),
('overcast', 'hot', 'normal', 'FALSE', 'yes'),
('rainy', 'mild', 'high', 'TRUE', 'no'),
('sunny', 'hot', 'high', 'FALSE', 'no');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
