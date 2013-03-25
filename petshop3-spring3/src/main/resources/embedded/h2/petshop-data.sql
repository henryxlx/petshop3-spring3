--
-- 转存表中的数据 account
--

INSERT INTO account (UserId, Email, FirstName, LastName, Status, Addr1, Addr2, City, State, Zip, Country, Phone) VALUES
('ACID', 'test@rollback.com', 'Distributed', 'Transaction', 'OK', 'PO Box 4482', '', 'Carmel', 'CA', '93921', 'USA', '831-625-1861'),
('DotNet', 'yourname@yourdomain.com', 'ABC', 'XYX', 'OK', '901 San Antonio Road', 'MS UCUP02-206', 'Palo Alto', 'CA', '94303', 'USA', '555-555-5555');

-- --------------------------------------------------------

--
-- 转存表中的数据 bannerdata
--

INSERT INTO bannerdata (FavCategory, BannerData) VALUES
('Birds', '<img src="Images/bannerBirds.gif">'),
('Cats', '<img src="Images/bannerCats.gif">'),
('Dogs', '<img src="Images/bannerDogs.gif">'),
('Fish', '<img src="Images/bannerFish.gif">'),
('Reptiles', '<img src="Images/bannerReptiles.gif">');

-- --------------------------------------------------------

--
-- 转存表中的数据 category
--

INSERT INTO category (CatId, Name, Descn) VALUES
('BIRDS', 'Birds', NULL),
('CATS', 'Cats', NULL),
('DOGS', 'Dogs', NULL),
('FISH', 'Fish', NULL),
('REPTILES', 'Reptiles', NULL);

-- --------------------------------------------------------

--
-- 转存表中的数据 inventory
--

INSERT INTO inventory (ItemId, Qty) VALUES
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
-- 转存表中的数据 item
--

INSERT INTO item (ItemId, ProductId, ListPrice, UnitCost, Supplier, Status, Attr1, Attr2, Attr3, Attr4, Attr5) VALUES
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
-- 转存表中的数据 product
--

INSERT INTO product (ProductId, Category, Name, Descn) VALUES
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
-- 转存表中的数据 profile
--

INSERT INTO profile (UserId, LangPref, FavCategory, MyListOpt, BannerOpt) VALUES
('ACID', 'English', 'Birds', 1, 1),
('DotNet', 'English', 'Dogs', 1, 1);

-- --------------------------------------------------------

--
-- 转存表中的数据 signon
--

INSERT INTO signon (UserName, Password) VALUES
('ACID', 'ACID'),
('DotNet', 'DotNet');

-- --------------------------------------------------------

--
-- 转存表中的数据 supplier
--

INSERT INTO supplier (SuppId, Name, Status, Addr1, Addr2, City, State, Zip, Phone) VALUES
(1, 'XYZ Pets', 'AC', '600 Avon Way', '', 'Los Angeles', 'CA', '94024', '212-947-0797'),
(2, 'ABC Pets', 'AC', '700 Abalone Way', '', 'San Francisco', 'CA', '94024', '415-947-0797');
