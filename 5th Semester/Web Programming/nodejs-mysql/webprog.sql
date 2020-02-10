-- phpMyAdmin SQL Dump
-- version 5.0.0
-- https://www.phpmyadmin.net/
--
-- Host: mysql
-- Generation Time: Jan 03, 2020 at 07:05 PM
-- Server version: 5.7.28
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `webprog`
--

-- --------------------------------------------------------

--
-- Table structure for table `LECTURER`
--

CREATE TABLE `LECTURER` (
  `username` varchar(60) NOT NULL,
  `pwd` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SESSIONS`
--

CREATE TABLE `SESSIONS` (
  `client_username` varchar(30) NOT NULL,
  `client_secret` varchar(200) NOT NULL,
  `server_secret` varchar(300) NOT NULL,
  `session_id` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `SESSIONS`
--

INSERT INTO `SESSIONS` (`client_username`, `client_secret`, `server_secret`, `session_id`) VALUES
('vm', 'Tw8Sj2UezmO95m6BLD7nQ8pT', 'FjLpRmzWgBDgUMgz1zZ2uXnN', '9a805899-e6dc-44f2-b86c-82177bb1c034');

-- --------------------------------------------------------

--
-- Table structure for table `STAGES`
--

CREATE TABLE `STAGES` (
  `id` int(11) NOT NULL,
  `name` varchar(60) NOT NULL,
  `description` text,
  `company` varchar(60) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `company_email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `STAGES`
--

INSERT INTO `STAGES` (`id`, `name`, `description`, `company`, `start_date`, `end_date`, `company_email`) VALUES
(3, 'Internship1', 'This is a sample description...', 'UNI.lu', '2020-01-01', '2020-02-07', NULL),
(4, 'Internship2', 'This is a sample description', 'UNI.lu', '2020-01-15', '2020-01-25', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `STUDENT`
--

CREATE TABLE `STUDENT` (
  `username` varchar(60) NOT NULL,
  `pwd` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `STUDENT`
--

INSERT INTO `STUDENT` (`username`, `pwd`) VALUES
('peterpan3', 'Pwd123??'),
('peterpan4', 'Pwd123??'),
('student1', 'student1'),
('vm', 'vm');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `LECTURER`
--
ALTER TABLE `LECTURER`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `SESSIONS`
--
ALTER TABLE `SESSIONS`
  ADD PRIMARY KEY (`client_username`);

--
-- Indexes for table `STAGES`
--
ALTER TABLE `STAGES`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `STUDENT`
--
ALTER TABLE `STUDENT`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `STAGES`
--
ALTER TABLE `STAGES`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

