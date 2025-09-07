-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 07, 2025 at 06:22 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bus_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `buses`
--

CREATE TABLE `buses` (
  `bus_id` int(11) NOT NULL,
  `bus_number` varchar(50) NOT NULL,
  `capacity` int(11) NOT NULL,
  `available_seats` int(11) NOT NULL,
  `route_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `buses`
--

INSERT INTO `buses` (`bus_id`, `bus_number`, `capacity`, `available_seats`, `route_id`) VALUES
(1, 'Bus-01', 60, 60, 1),
(2, 'Bus-02', 60, 60, 2),
(3, 'Bus-03', 60, 60, 3),
(4, 'Bus-04', 60, 60, 4);

-- --------------------------------------------------------

--
-- Table structure for table `drivers`
--

CREATE TABLE `drivers` (
  `driver_id` int(11) NOT NULL,
  `driver_name` varchar(100) NOT NULL,
  `license_number` varchar(50) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `assigned_bus` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `drivers`
--

INSERT INTO `drivers` (`driver_id`, `driver_name`, `license_number`, `phone`, `assigned_bus`) VALUES
(1, 'Abdul Karim', 'LIC12345', '01710000001', 1),
(2, 'Rafiqul Islam', 'LIC12346', '01710000002', 2),
(3, 'Jalal Uddin', 'LIC12347', '01710000003', 3),
(4, 'Shahidul Alam', 'LIC12348', '01710000004', 4);

-- --------------------------------------------------------

--
-- Table structure for table `routes`
--

CREATE TABLE `routes` (
  `route_id` int(11) NOT NULL,
  `route_name` varchar(100) NOT NULL,
  `start_point` varchar(100) DEFAULT NULL,
  `end_point` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `routes`
--

INSERT INTO `routes` (`route_id`, `route_name`, `start_point`, `end_point`) VALUES
(1, 'Route 01', 'Tilagor', 'Ragib Nagar'),
(2, 'Route 02', 'Bondor', 'Ragib Nagar'),
(3, 'Route 03', 'Lakkatura', 'Ragib Nagar'),
(4, 'Route 04', 'Tilagor', 'Ragib Nagar');

-- --------------------------------------------------------

--
-- Table structure for table `stoppages`
--

CREATE TABLE `stoppages` (
  `stop_id` int(11) NOT NULL,
  `route_id` int(11) NOT NULL,
  `stop_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stoppages`
--

INSERT INTO `stoppages` (`stop_id`, `route_id`, `stop_name`) VALUES
(1, 1, 'Tilagor'),
(2, 1, 'Amanullah'),
(3, 1, 'TV Gate'),
(4, 1, 'Raynagar Point'),
(5, 1, 'Eidgah'),
(6, 1, 'Amborkhana (Silsila)'),
(7, 1, 'Jalalabad'),
(8, 1, 'Subidbazar'),
(9, 1, 'London Road'),
(10, 1, 'Pathantula'),
(11, 1, 'Madina Market (Dudwala/Pallobi)'),
(12, 1, 'Madina Market (Hatem Tanj/Kalibari)'),
(13, 1, 'Mount Adora Hospital'),
(14, 1, 'Surma Gate'),
(15, 1, 'Topobon'),
(16, 1, 'SUST Gate'),
(17, 1, 'Temukhi'),
(18, 1, 'Cement Godown'),
(19, 1, 'Ragib Nagar'),
(20, 2, 'Bondor'),
(21, 2, 'Jitumia point'),
(22, 2, 'Lamabazar'),
(23, 2, 'Rikabibazar'),
(24, 2, 'Radio Office'),
(25, 2, 'Subidbazar'),
(26, 2, 'Londoni Road'),
(27, 2, 'Pathantula'),
(28, 2, 'Madina Market (Dudwala/Pallobi)'),
(29, 2, 'Madina Market (Hatem Tai/Kalibari)'),
(30, 2, 'Mount Adora Hospital'),
(31, 2, 'Topobon'),
(32, 2, 'SUST Gate'),
(33, 2, 'Temukhi'),
(34, 2, 'Cement Godown'),
(35, 2, 'Ragib Nagar'),
(36, 3, 'Lakkatura'),
(37, 3, 'Airport Road'),
(38, 3, 'Chowkidikhi'),
(39, 3, 'Amborkhana (Silsila)'),
(40, 3, 'Subidbazar'),
(41, 3, 'Londoni Road'),
(42, 3, 'Pathantula'),
(43, 3, 'Madina Market (Dudwala/Pallobi)'),
(44, 3, 'Madina Market (Hatem Tai/Kalibari)'),
(45, 3, 'Mount Adora Hospital'),
(46, 3, 'Topobon'),
(47, 3, 'SUST Gate'),
(48, 3, 'Temukhi'),
(49, 3, 'Cement Godown'),
(50, 3, 'Ragib Nagar'),
(51, 4, 'Tilagor'),
(52, 4, 'Shibgonj'),
(53, 4, 'Mirabazar'),
(54, 4, 'Rose view point'),
(55, 4, 'Humayun Rashid Chattar'),
(56, 4, 'Chondipul'),
(57, 4, 'Bypass'),
(58, 4, 'Rellcrossing'),
(59, 4, 'Ragib Nagar');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(100) NOT NULL,
  `department` varchar(100) DEFAULT NULL,
  `card_id` varchar(50) NOT NULL,
  `route_id` int(11) DEFAULT NULL,
  `stop_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`student_id`, `student_name`, `department`, `card_id`, `route_id`, `stop_id`) VALUES
(1, 'Sanjida Akter', 'CSE', 'CARD001', 2, 24),
(2, 'Taieba Aktar', 'EEE', 'CARD002', 4, 54),
(3, 'Safia Begum', 'BBA', 'CARD003', 4, 55),
(4, 'Tanvir Ahmed', 'CIVIL', 'CARD004', 1, 5),
(5, 'Tasfia', 'BBA', 'CARD005', 3, 47),
(6, 'Wafa', 'CSE', 'CARD006', 3, 37);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buses`
--
ALTER TABLE `buses`
  ADD PRIMARY KEY (`bus_id`),
  ADD KEY `route_id` (`route_id`);

--
-- Indexes for table `drivers`
--
ALTER TABLE `drivers`
  ADD PRIMARY KEY (`driver_id`),
  ADD UNIQUE KEY `license_number` (`license_number`),
  ADD KEY `assigned_bus` (`assigned_bus`);

--
-- Indexes for table `routes`
--
ALTER TABLE `routes`
  ADD PRIMARY KEY (`route_id`);

--
-- Indexes for table `stoppages`
--
ALTER TABLE `stoppages`
  ADD PRIMARY KEY (`stop_id`),
  ADD KEY `route_id` (`route_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`),
  ADD UNIQUE KEY `card_id` (`card_id`),
  ADD KEY `route_id` (`route_id`),
  ADD KEY `stop_id` (`stop_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `buses`
--
ALTER TABLE `buses`
  MODIFY `bus_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `drivers`
--
ALTER TABLE `drivers`
  MODIFY `driver_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `routes`
--
ALTER TABLE `routes`
  MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `stoppages`
--
ALTER TABLE `stoppages`
  MODIFY `stop_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `buses`
--
ALTER TABLE `buses`
  ADD CONSTRAINT `buses_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `routes` (`route_id`);

--
-- Constraints for table `drivers`
--
ALTER TABLE `drivers`
  ADD CONSTRAINT `drivers_ibfk_1` FOREIGN KEY (`assigned_bus`) REFERENCES `buses` (`bus_id`);

--
-- Constraints for table `stoppages`
--
ALTER TABLE `stoppages`
  ADD CONSTRAINT `stoppages_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `routes` (`route_id`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `routes` (`route_id`),
  ADD CONSTRAINT `students_ibfk_2` FOREIGN KEY (`stop_id`) REFERENCES `stoppages` (`stop_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
