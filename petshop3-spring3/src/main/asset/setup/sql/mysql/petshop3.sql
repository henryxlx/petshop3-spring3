-- phpMyAdmin SQL Dump
-- version 3.3.7
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2013 年 03 月 13 日 02:45
-- 服务器版本: 5.0.90
-- PHP 版本: 5.2.14

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `petshop3`
--
DROP DATABASE `petshop3`;
CREATE DATABASE `petshop3` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `petshop3`;

-- --------------------------------------------------------

--
-- 表的结构 `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `UserId` varchar(20) NOT NULL default '',
  `Email` varchar(80) NOT NULL default '',
  `FirstName` varchar(80) NOT NULL default '',
  `LastName` varchar(80) NOT NULL default '',
  `Status` varchar(2) default '',
  `Addr1` varchar(80) NOT NULL default '',
  `Addr2` varchar(80) default '',
  `City` varchar(80) NOT NULL default '',
  `State` varchar(80) NOT NULL default '',
  `Zip` varchar(20) NOT NULL default '',
  `Country` varchar(20) NOT NULL default '',
  `Phone` varchar(20) NOT NULL default '',
  PRIMARY KEY  (`UserId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `account`
--

INSERT INTO `account` (`UserId`, `Email`, `FirstName`, `LastName`, `Status`, `Addr1`, `Addr2`, `City`, `State`, `Zip`, `Country`, `Phone`) VALUES
('ACID', 'test@rollback.com', 'Distributed', 'Transaction', 'OK', 'PO Box 4482', '', 'Carmel', 'CA', '93921', 'USA', '831-625-1861'),
('DotNet', 'yourname@yourdomain.com', 'ABC', 'XYX', 'OK', '901 San Antonio Road', 'MS UCUP02-206', 'Palo Alto', 'CA', '94303', 'USA', '555-555-5555');

-- --------------------------------------------------------

--
-- 表的结构 `bannerdata`
--

CREATE TABLE IF NOT EXISTS `bannerdata` (
  `FavCategory` varchar(80) NOT NULL default '',
  `BannerData` varchar(255) default '',
  PRIMARY KEY  (`FavCategory`(64))
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `bannerdata`
--

INSERT INTO `bannerdata` (`FavCategory`, `BannerData`) VALUES
('Birds', '<img src="Images/bannerBirds.gif">'),
('Cats', '<img src="Images/bannerCats.gif">'),
('Dogs', '<img src="Images/bannerDogs.gif">'),
('Fish', '<img src="Images/bannerFish.gif">'),
('Reptiles', '<img src="Images/bannerReptiles.gif">');

-- --------------------------------------------------------

--
-- 表的结构 `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `CatId` varchar(10) NOT NULL default '',
  `Name` varchar(80) default '',
  `Descn` varchar(255) default '',
  PRIMARY KEY  (`CatId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `category`
--

INSERT INTO `category` (`CatId`, `Name`, `Descn`) VALUES
('BIRDS', 'Birds', NULL),
('CATS', 'Cats', NULL),
('DOGS', 'Dogs', NULL),
('FISH', 'Fish', NULL),
('REPTILES', 'Reptiles', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `inventory`
--

CREATE TABLE IF NOT EXISTS `inventory` (
  `ItemId` varchar(10) NOT NULL default '',
  `Qty` int(11) NOT NULL default '0',
  PRIMARY KEY  (`ItemId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `inventory`
--

INSERT INTO `inventory` (`ItemId`, `Qty`) VALUES
('EST-1', 10000),
('EST-10', 10000),
('EST-11', 10000),
('EST-12', 10000),
('EST-13', 10000),
('EST-14', 10000),
('EST-15', 10000),
('EST-16', 10000),
('EST-17', 10000),
('EST-18', 10000),
('EST-19', 10000),
('EST-2', 10000),
('EST-20', 10000),
('EST-21', 10000),
('EST-22', 10000),
('EST-23', 10000),
('EST-24', 10000),
('EST-25', 10000),
('EST-26', 10000),
('EST-27', 10000),
('EST-28', 10000),
('EST-3', 10000),
('EST-4', 10000),
('EST-5', 10000),
('EST-6', 10000),
('EST-7', 10000),
('EST-8', 10000),
('EST-9', 10000);

-- --------------------------------------------------------

--
-- 表的结构 `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `ItemId` varchar(10) NOT NULL default '',
  `ProductId` varchar(10) NOT NULL default '',
  `ListPrice` decimal(10,2) default '0.00',
  `UnitCost` decimal(10,2) default '0.00',
  `Supplier` int(11) default '0',
  `Status` varchar(2) default '',
  `Attr1` varchar(80) default '',
  `Attr2` varchar(80) default '',
  `Attr3` varchar(80) default '',
  `Attr4` varchar(80) default '',
  `Attr5` varchar(80) default '',
  PRIMARY KEY  (`ItemId`),
  KEY `IxItem` (`ProductId`,`ItemId`,`ListPrice`,`Attr1`(64)),
  KEY `FK__Item__ProductId__07F6335A` (`ProductId`),
  KEY `FK__Item__Supplier__08EA5793` (`Supplier`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `item`
--

INSERT INTO `item` (`ItemId`, `ProductId`, `ListPrice`, `UnitCost`, `Supplier`, `Status`, `Attr1`, `Attr2`, `Attr3`, `Attr4`, `Attr5`) VALUES
('EST-1', 'FI-SW-01', 16.50, 10.00, 1, 'P', 'Large', NULL, NULL, NULL, NULL),
('EST-10', 'K9-DL-01', 18.50, 12.00, 1, 'P', 'Spotted Adult Female', NULL, NULL, NULL, NULL),
('EST-11', 'RP-SN-01', 18.50, 12.00, 1, 'P', 'Venomless', NULL, NULL, NULL, NULL),
('EST-12', 'RP-SN-01', 18.50, 12.00, 1, 'P', 'Rattleless', NULL, NULL, NULL, NULL),
('EST-13', 'RP-LI-02', 18.50, 12.00, 1, 'P', 'Green Adult', NULL, NULL, NULL, NULL),
('EST-14', 'FL-DSH-01', 58.50, 12.00, 1, 'P', 'Tailless', NULL, NULL, NULL, NULL),
('EST-15', 'FL-DSH-01', 23.50, 12.00, 1, 'P', 'Tailed', NULL, NULL, NULL, NULL),
('EST-16', 'FL-DLH-02', 93.50, 12.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL),
('EST-17', 'FL-DLH-02', 93.50, 12.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL),
('EST-18', 'AV-CB-01', 193.50, 92.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL),
('EST-19', 'AV-SB-02', 15.50, 2.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL),
('EST-2', 'FI-SW-01', 16.50, 10.00, 1, 'P', 'Small', NULL, NULL, NULL, NULL),
('EST-20', 'FI-FW-02', 5.50, 2.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL),
('EST-21', 'FI-FW-02', 5.29, 1.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL),
('EST-22', 'K9-RT-02', 135.50, 100.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL),
('EST-23', 'K9-RT-02', 145.49, 100.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL),
('EST-24', 'K9-RT-02', 255.50, 92.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL),
('EST-25', 'K9-RT-02', 325.29, 90.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL),
('EST-26', 'K9-CW-01', 125.50, 92.00, 1, 'P', 'Adult Male', NULL, NULL, NULL, NULL),
('EST-27', 'K9-CW-01', 155.29, 90.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL),
('EST-28', 'K9-RT-01', 155.29, 90.00, 1, 'P', 'Adult Female', NULL, NULL, NULL, NULL),
('EST-3', 'FI-SW-02', 18.50, 12.00, 1, 'P', 'Toothless', NULL, NULL, NULL, NULL),
('EST-4', 'FI-FW-01', 18.50, 12.00, 1, 'P', 'Spotted', NULL, NULL, NULL, NULL),
('EST-5', 'FI-FW-01', 18.50, 12.00, 1, 'P', 'Spotless', NULL, NULL, NULL, NULL),
('EST-6', 'K9-BD-01', 18.50, 12.00, 1, 'P', 'Male Adult', NULL, NULL, NULL, NULL),
('EST-7', 'K9-BD-01', 18.50, 12.00, 1, 'P', 'Female Puppy', NULL, NULL, NULL, NULL),
('EST-8', 'K9-PO-02', 18.50, 12.00, 1, 'P', 'Male Puppy', NULL, NULL, NULL, NULL),
('EST-9', 'K9-DL-01', 18.50, 12.00, 1, 'P', 'Spotless Male Puppy', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `lineitem`
--

CREATE TABLE IF NOT EXISTS `lineitem` (
  `OrderId` int(11) NOT NULL default '0',
  `LineNum` int(11) NOT NULL default '0',
  `ItemId` varchar(10) NOT NULL default '',
  `Quantity` int(11) NOT NULL default '0',
  `UnitPrice` decimal(10,2) NOT NULL default '0.00',
  PRIMARY KEY  (`OrderId`,`LineNum`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `lineitem`
--


-- --------------------------------------------------------

--
-- 表的结构 `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `OrderId` int(11) NOT NULL auto_increment,
  `UserId` varchar(20) NOT NULL default '',
  `OrderDate` datetime NOT NULL,
  `ShipAddr1` varchar(80) NOT NULL default '',
  `ShipAddr2` varchar(80) default '',
  `ShipCity` varchar(80) NOT NULL default '',
  `ShipState` varchar(80) NOT NULL default '',
  `ShipZip` varchar(20) NOT NULL default '',
  `ShipCountry` varchar(20) NOT NULL default '',
  `BillAddr1` varchar(80) NOT NULL default '',
  `BillAddr2` varchar(80) default '',
  `BillCity` varchar(80) NOT NULL default '',
  `BillState` varchar(80) NOT NULL default '',
  `BillZip` varchar(20) NOT NULL default '',
  `BillCountry` varchar(20) NOT NULL default '',
  `Courier` varchar(80) NOT NULL default '',
  `TotalPrice` decimal(10,2) NOT NULL default '0.00',
  `BillToFirstName` varchar(80) NOT NULL default '',
  `BillToLastName` varchar(80) NOT NULL default '',
  `ShipToFirstName` varchar(80) NOT NULL default '',
  `ShipToLastName` varchar(80) NOT NULL default '',
  `CreditCard` varchar(20) NOT NULL default '',
  `ExprDate` varchar(7) NOT NULL default '',
  `CardType` varchar(40) NOT NULL default '',
  `Locale` varchar(20) NOT NULL default '',
  PRIMARY KEY  (`OrderId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- 转存表中的数据 `orders`
--


-- --------------------------------------------------------

--
-- 表的结构 `orderstatus`
--

CREATE TABLE IF NOT EXISTS `orderstatus` (
  `OrderId` int(11) NOT NULL default '0',
  `LineNum` int(11) NOT NULL default '0',
  `Timestamp` datetime NOT NULL,
  `Status` varchar(2) NOT NULL default '',
  PRIMARY KEY  (`OrderId`,`LineNum`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `orderstatus`
--


-- --------------------------------------------------------

--
-- 表的结构 `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `ProductId` varchar(10) NOT NULL default '',
  `Category` varchar(10) NOT NULL default '',
  `Name` varchar(80) default '',
  `Descn` varchar(255) default '',
  PRIMARY KEY  (`ProductId`),
  KEY `IxProduct1` (`Name`(64)),
  KEY `IxProduct2` (`Category`),
  KEY `IxProduct3` (`Category`,`Name`(64)),
  KEY `IxProduct4` (`Category`,`ProductId`,`Name`(64)),
  KEY `FK__Product__Categor__7F60ED59` (`Category`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `product`
--

INSERT INTO `product` (`ProductId`, `Category`, `Name`, `Descn`) VALUES
('AV-CB-01', 'BIRDS', 'Amazon Parrot', '<img align="absmiddle" src="images/Pets/bird1.jpg">Great companion for up to 75 years'),
('AV-SB-02', 'BIRDS', 'Finch', '<img align="absmiddle" src="images/Pets/bird2.jpg">Great stress reliever'),
('FI-FW-01', 'FISH', 'Koi', '<img align="absmiddle" src="images/Pets/fish3.jpg">Freshwater fish from Japan'),
('FI-FW-02', 'FISH', 'Goldfish', '<img align="absmiddle" src="images/Pets/fish4.jpg">Freshwater fish from China'),
('FI-SW-01', 'FISH', 'Angelfish', '<img align="absmiddle" src="images/Pets/fish1.jpg">Saltwater fish from Australia'),
('FI-SW-02', 'FISH', 'Tiger Shark', '<img align="absmiddle" src="images/Pets/fish2.jpg">Saltwater fish from Australia'),
('FL-DLH-02', 'CATS', 'Persian', '<img align="absmiddle" src="images/Pets/cat2.jpg">Friendly house cat, doubles as a princess'),
('FL-DSH-01', 'CATS', 'Manx', '<img align="absmiddle" src="images/Pets/cat1.jpg">Great for reducing mouse populations'),
('K9-BD-01', 'DOGS', 'Bulldog', '<img align="absmiddle" src="images/Pets/dog1.jpg">Friendly dog from England'),
('K9-CW-01', 'DOGS', 'Chihuahua', '<img align="absmiddle" src="images/Pets/dog6.jpg">Great companion dog'),
('K9-DL-01', 'DOGS', 'Dalmation', '<img align="absmiddle" src="images/Pets/dog3.jpg">Great dog for a fire station'),
('K9-PO-02', 'DOGS', 'Poodle', '<img align="absmiddle" src="images/Pets/dog2.jpg">Cute dog from France'),
('K9-RT-01', 'DOGS', 'Golden Retriever', '<img align="absmiddle" src="images/Pets/dog4.jpg">Great family dog'),
('K9-RT-02', 'DOGS', 'Labrador Retriever', '<img align="absmiddle" src="images/Pets/dog5.jpg">Great hunting dog'),
('RP-LI-02', 'REPTILES', 'Iguana', '<img align="absmiddle" src="images/Pets/reptile2.jpg">Friendly green friend'),
('RP-SN-01', 'REPTILES', 'Rattlesnake', '<img align="absmiddle" src="images/Pets/reptile1.jpg">Doubles as a watch dog');

-- --------------------------------------------------------

--
-- 表的结构 `profile`
--

CREATE TABLE IF NOT EXISTS `profile` (
  `UserId` varchar(20) NOT NULL default '',
  `LangPref` varchar(80) NOT NULL default '',
  `FavCategory` varchar(30) default '',
  `MyListOpt` int(11) default '0',
  `BannerOpt` int(11) default '0',
  PRIMARY KEY  (`UserId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `profile`
--

INSERT INTO `profile` (`UserId`, `LangPref`, `FavCategory`, `MyListOpt`, `BannerOpt`) VALUES
('ACID', 'English', 'Birds', 1, 1),
('DotNet', 'English', 'Dogs', 1, 1);

-- --------------------------------------------------------

--
-- 表的结构 `signon`
--

CREATE TABLE IF NOT EXISTS `signon` (
  `UserName` varchar(20) NOT NULL default '',
  `Password` varchar(20) NOT NULL default '',
  PRIMARY KEY  (`UserName`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `signon`
--

INSERT INTO `signon` (`UserName`, `Password`) VALUES
('ACID', 'ACID'),
('DotNet', 'DotNet');

-- --------------------------------------------------------

--
-- 表的结构 `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `SuppId` int(11) NOT NULL default '0',
  `Name` varchar(80) default '',
  `Status` varchar(2) NOT NULL default '',
  `Addr1` varchar(80) default '',
  `Addr2` varchar(80) default '',
  `City` varchar(80) default '',
  `State` varchar(80) default '',
  `Zip` varchar(5) default '',
  `Phone` varchar(40) default '',
  PRIMARY KEY  (`SuppId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `supplier`
--

INSERT INTO `supplier` (`SuppId`, `Name`, `Status`, `Addr1`, `Addr2`, `City`, `State`, `Zip`, `Phone`) VALUES
(1, 'XYZ Pets', 'AC', '600 Avon Way', '', 'Los Angeles', 'CA', '94024', '212-947-0797'),
(2, 'ABC Pets', 'AC', '700 Abalone Way', '', 'San Francisco', 'CA', '94024', '415-947-0797');
