-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2017 at 05:06 PM
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
-- Table structure for table `iris`
--

CREATE TABLE `iris` (
  `sepal_length` float NOT NULL,
  `sepal_width` float NOT NULL,
  `petal_length` float NOT NULL,
  `petal_width` float NOT NULL,
  `class` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `iris`
--

INSERT INTO `iris` (`sepal_length`, `sepal_width`, `petal_length`, `petal_width`, `class`) VALUES
(5.1, 3.5, 1.4, 0.2, 'Iris-setosa'),
(4.9, 3, 1.4, 0.2, 'Iris-setosa'),
(4.7, 3.2, 1.3, 0.2, 'Iris-setosa'),
(4.6, 3.1, 1.5, 0.2, 'Iris-setosa'),
(5, 3.6, 1.4, 0.2, 'Iris-setosa'),
(5.4, 3.9, 1.7, 0.4, 'Iris-setosa'),
(4.6, 3.4, 1.4, 0.3, 'Iris-setosa'),
(5, 3.4, 1.5, 0.2, 'Iris-setosa'),
(4.4, 2.9, 1.4, 0.2, 'Iris-setosa'),
(4.9, 3.1, 1.5, 0.1, 'Iris-setosa'),
(5.4, 3.7, 1.5, 0.2, 'Iris-setosa'),
(4.8, 3.4, 1.6, 0.2, 'Iris-setosa'),
(4.8, 3, 1.4, 0.1, 'Iris-setosa'),
(4.3, 3, 1.1, 0.1, 'Iris-setosa'),
(5.8, 4, 1.2, 0.2, 'Iris-setosa'),
(5.7, 4.4, 1.5, 0.4, 'Iris-setosa'),
(5.4, 3.9, 1.3, 0.4, 'Iris-setosa'),
(5.1, 3.5, 1.4, 0.3, 'Iris-setosa'),
(5.7, 3.8, 1.7, 0.3, 'Iris-setosa'),
(5.1, 3.8, 1.5, 0.3, 'Iris-setosa'),
(5.4, 3.4, 1.7, 0.2, 'Iris-setosa'),
(5.1, 3.7, 1.5, 0.4, 'Iris-setosa'),
(4.6, 3.6, 1, 0.2, 'Iris-setosa'),
(5.1, 3.3, 1.7, 0.5, 'Iris-setosa'),
(4.8, 3.4, 1.9, 0.2, 'Iris-setosa'),
(5, 3, 1.6, 0.2, 'Iris-setosa'),
(5, 3.4, 1.6, 0.4, 'Iris-setosa'),
(5.2, 3.5, 1.5, 0.2, 'Iris-setosa'),
(5.2, 3.4, 1.4, 0.2, 'Iris-setosa'),
(4.7, 3.2, 1.6, 0.2, 'Iris-setosa'),
(4.8, 3.1, 1.6, 0.2, 'Iris-setosa'),
(5.4, 3.4, 1.5, 0.4, 'Iris-setosa'),
(5.2, 4.1, 1.5, 0.1, 'Iris-setosa'),
(5.5, 4.2, 1.4, 0.2, 'Iris-setosa'),
(4.9, 3.1, 1.5, 0.1, 'Iris-setosa'),
(5, 3.2, 1.2, 0.2, 'Iris-setosa'),
(5.5, 3.5, 1.3, 0.2, 'Iris-setosa'),
(4.9, 3.1, 1.5, 0.1, 'Iris-setosa'),
(4.4, 3, 1.3, 0.2, 'Iris-setosa'),
(5.1, 3.4, 1.5, 0.2, 'Iris-setosa'),
(5, 3.5, 1.3, 0.3, 'Iris-setosa'),
(4.5, 2.3, 1.3, 0.3, 'Iris-setosa'),
(4.4, 3.2, 1.3, 0.2, 'Iris-setosa'),
(5, 3.5, 1.6, 0.6, 'Iris-setosa'),
(5.1, 3.8, 1.9, 0.4, 'Iris-setosa'),
(4.8, 3, 1.4, 0.3, 'Iris-setosa'),
(5.1, 3.8, 1.6, 0.2, 'Iris-setosa'),
(4.6, 3.2, 1.4, 0.2, 'Iris-setosa'),
(5.3, 3.7, 1.5, 0.2, 'Iris-setosa'),
(5, 3.3, 1.4, 0.2, 'Iris-setosa'),
(7, 3.2, 4.7, 1.4, 'Iris-versicolor'),
(6.4, 3.2, 4.5, 1.5, 'Iris-versicolor'),
(6.9, 3.1, 4.9, 1.5, 'Iris-versicolor'),
(5.5, 2.3, 4, 1.3, 'Iris-versicolor'),
(6.5, 2.8, 4.6, 1.5, 'Iris-versicolor'),
(5.7, 2.8, 4.5, 1.3, 'Iris-versicolor'),
(6.3, 3.3, 4.7, 1.6, 'Iris-versicolor'),
(4.9, 2.4, 3.3, 1, 'Iris-versicolor'),
(6.6, 2.9, 4.6, 1.3, 'Iris-versicolor'),
(5.2, 2.7, 3.9, 1.4, 'Iris-versicolor'),
(5, 2, 3.5, 1, 'Iris-versicolor'),
(5.9, 3, 4.2, 1.5, 'Iris-versicolor'),
(6, 2.2, 4, 1, 'Iris-versicolor'),
(6.1, 2.9, 4.7, 1.4, 'Iris-versicolor'),
(5.6, 2.9, 3.6, 1.3, 'Iris-versicolor'),
(6.7, 3.1, 4.4, 1.4, 'Iris-versicolor'),
(5.6, 3, 4.5, 1.5, 'Iris-versicolor'),
(5.8, 2.7, 4.1, 1, 'Iris-versicolor'),
(6.2, 2.2, 4.5, 1.5, 'Iris-versicolor'),
(5.6, 2.5, 3.9, 1.1, 'Iris-versicolor'),
(5.9, 3.2, 4.8, 1.8, 'Iris-versicolor'),
(6.1, 2.8, 4, 1.3, 'Iris-versicolor'),
(6.3, 2.5, 4.9, 1.5, 'Iris-versicolor'),
(6.1, 2.8, 4.7, 1.2, 'Iris-versicolor'),
(6.4, 2.9, 4.3, 1.3, 'Iris-versicolor'),
(6.6, 3, 4.4, 1.4, 'Iris-versicolor'),
(6.8, 2.8, 4.8, 1.4, 'Iris-versicolor'),
(6.7, 3, 5, 1.7, 'Iris-versicolor'),
(6, 2.9, 4.5, 1.5, 'Iris-versicolor'),
(5.7, 2.6, 3.5, 1, 'Iris-versicolor'),
(5.5, 2.4, 3.8, 1.1, 'Iris-versicolor'),
(5.5, 2.4, 3.7, 1, 'Iris-versicolor'),
(5.8, 2.7, 3.9, 1.2, 'Iris-versicolor'),
(6, 2.7, 5.1, 1.6, 'Iris-versicolor'),
(5.4, 3, 4.5, 1.5, 'Iris-versicolor'),
(6, 3.4, 4.5, 1.6, 'Iris-versicolor'),
(6.7, 3.1, 4.7, 1.5, 'Iris-versicolor'),
(6.3, 2.3, 4.4, 1.3, 'Iris-versicolor'),
(5.6, 3, 4.1, 1.3, 'Iris-versicolor'),
(5.5, 2.5, 4, 1.3, 'Iris-versicolor'),
(5.5, 2.6, 4.4, 1.2, 'Iris-versicolor'),
(6.1, 3, 4.6, 1.4, 'Iris-versicolor'),
(5.8, 2.6, 4, 1.2, 'Iris-versicolor'),
(5, 2.3, 3.3, 1, 'Iris-versicolor'),
(5.6, 2.7, 4.2, 1.3, 'Iris-versicolor'),
(5.7, 3, 4.2, 1.2, 'Iris-versicolor'),
(5.7, 2.9, 4.2, 1.3, 'Iris-versicolor'),
(6.2, 2.9, 4.3, 1.3, 'Iris-versicolor'),
(5.1, 2.5, 3, 1.1, 'Iris-versicolor'),
(5.7, 2.8, 4.1, 1.3, 'Iris-versicolor'),
(6.3, 3.3, 6, 2.5, 'Iris-virginica'),
(5.8, 2.7, 5.1, 1.9, 'Iris-virginica'),
(7.1, 3, 5.9, 2.1, 'Iris-virginica'),
(6.3, 2.9, 5.6, 1.8, 'Iris-virginica'),
(6.5, 3, 5.8, 2.2, 'Iris-virginica'),
(7.6, 3, 6.6, 2.1, 'Iris-virginica'),
(4.9, 2.5, 4.5, 1.7, 'Iris-virginica'),
(7.3, 2.9, 6.3, 1.8, 'Iris-virginica'),
(6.7, 2.5, 5.8, 1.8, 'Iris-virginica'),
(7.2, 3.6, 6.1, 2.5, 'Iris-virginica'),
(6.5, 3.2, 5.1, 2, 'Iris-virginica'),
(6.4, 2.7, 5.3, 1.9, 'Iris-virginica'),
(6.8, 3, 5.5, 2.1, 'Iris-virginica'),
(5.7, 2.5, 5, 2, 'Iris-virginica'),
(5.8, 2.8, 5.1, 2.4, 'Iris-virginica'),
(6.4, 3.2, 5.3, 2.3, 'Iris-virginica'),
(6.5, 3, 5.5, 1.8, 'Iris-virginica'),
(7.7, 3.8, 6.7, 2.2, 'Iris-virginica'),
(7.7, 2.6, 6.9, 2.3, 'Iris-virginica'),
(6, 2.2, 5, 1.5, 'Iris-virginica'),
(6.9, 3.2, 5.7, 2.3, 'Iris-virginica'),
(5.6, 2.8, 4.9, 2, 'Iris-virginica'),
(7.7, 2.8, 6.7, 2, 'Iris-virginica'),
(6.3, 2.7, 4.9, 1.8, 'Iris-virginica'),
(6.7, 3.3, 5.7, 2.1, 'Iris-virginica'),
(7.2, 3.2, 6, 1.8, 'Iris-virginica'),
(6.2, 2.8, 4.8, 1.8, 'Iris-virginica'),
(6.1, 3, 4.9, 1.8, 'Iris-virginica'),
(6.4, 2.8, 5.6, 2.1, 'Iris-virginica'),
(7.2, 3, 5.8, 1.6, 'Iris-virginica'),
(7.4, 2.8, 6.1, 1.9, 'Iris-virginica'),
(7.9, 3.8, 6.4, 2, 'Iris-virginica'),
(6.4, 2.8, 5.6, 2.2, 'Iris-virginica'),
(6.3, 2.8, 5.1, 1.5, 'Iris-virginica'),
(6.1, 2.6, 5.6, 1.4, 'Iris-virginica'),
(7.7, 3, 6.1, 2.3, 'Iris-virginica'),
(6.3, 3.4, 5.6, 2.4, 'Iris-virginica'),
(6.4, 3.1, 5.5, 1.8, 'Iris-virginica'),
(6, 3, 4.8, 1.8, 'Iris-virginica'),
(6.9, 3.1, 5.4, 2.1, 'Iris-virginica'),
(6.7, 3.1, 5.6, 2.4, 'Iris-virginica'),
(6.9, 3.1, 5.1, 2.3, 'Iris-virginica'),
(5.8, 2.7, 5.1, 1.9, 'Iris-virginica'),
(6.8, 3.2, 5.9, 2.3, 'Iris-virginica'),
(6.7, 3.3, 5.7, 2.5, 'Iris-virginica'),
(6.7, 3, 5.2, 2.3, 'Iris-virginica'),
(6.3, 2.5, 5, 1.9, 'Iris-virginica'),
(6.5, 3, 5.2, 2, 'Iris-virginica'),
(6.2, 3.4, 5.4, 2.3, 'Iris-virginica'),
(5.9, 3, 5.1, 1.8, 'Iris-virginica');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
