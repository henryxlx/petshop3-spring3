DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS bannerdata;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS lineitem;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS orderstatus;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS profile;
DROP TABLE IF EXISTS signon;
DROP TABLE IF EXISTS supplier;
-- --------------------------------------------------------

--
-- 表的结构 account
--

CREATE TABLE account (
  UserId varchar(20) NOT NULL default '',
  Email varchar(80) NOT NULL default '',
  FirstName varchar(80) NOT NULL default '',
  LastName varchar(80) NOT NULL default '',
  Status varchar(2) default '',
  Addr1 varchar(80) NOT NULL default '',
  Addr2 varchar(80) default '',
  City varchar(80) NOT NULL default '',
  State varchar(80) NOT NULL default '',
  Zip varchar(20) NOT NULL default '',
  Country varchar(20) NOT NULL default '',
  Phone varchar(20) NOT NULL default '',
  PRIMARY KEY  (UserId)
);

-- --------------------------------------------------------

--
-- 表的结构 bannerdata
--

CREATE TABLE bannerdata (
  FavCategory varchar(80) NOT NULL default '',
  BannerData varchar(255) default '',
  PRIMARY KEY  (FavCategory)
);

-- --------------------------------------------------------

--
-- 表的结构 category
--

CREATE TABLE category (
  CatId varchar(10) NOT NULL default '',
  Name varchar(80) default '',
  Descn varchar(255) default '',
  PRIMARY KEY  (CatId)
);

-- --------------------------------------------------------

--
-- 表的结构 inventory
--

CREATE TABLE inventory (
  ItemId varchar(10) NOT NULL default '',
  Qty int NOT NULL default '0',
  PRIMARY KEY  (ItemId)
);

-- --------------------------------------------------------

--
-- 表的结构 item
--

CREATE TABLE item (
  ItemId varchar(10) NOT NULL default '',
  ProductId varchar(10) NOT NULL default '',
  ListPrice decimal(10,2) default '0.00',
  UnitCost decimal(10,2) default '0.00',
  Supplier int default '0',
  Status varchar(2) default '',
  Attr1 varchar(80) default '',
  Attr2 varchar(80) default '',
  Attr3 varchar(80) default '',
  Attr4 varchar(80) default '',
  Attr5 varchar(80) default '',
  PRIMARY KEY  (ItemId)
);

CREATE INDEX IxItem ON item(ProductId,ItemId,ListPrice,Attr1);
CREATE INDEX FK__Item__ProductId__07F6335A ON item(ProductId);
CREATE INDEX FK__Item__Supplier__08EA5793 ON item(Supplier);

-- --------------------------------------------------------

--
-- 表的结构 lineitem
--

CREATE TABLE lineitem (
  OrderId int NOT NULL default '0',
  LineNum int NOT NULL default '0',
  ItemId varchar(10) NOT NULL default '',
  Quantity int NOT NULL default '0',
  UnitPrice decimal(10,2) NOT NULL default '0.00',
  PRIMARY KEY  (OrderId,LineNum)
);

-- --------------------------------------------------------

--
-- 表的结构 orders
--

CREATE TABLE orders (
  OrderId int NOT NULL auto_increment,
  UserId varchar(20) NOT NULL default '',
  OrderDate datetime NOT NULL,
  ShipAddr1 varchar(80) NOT NULL default '',
  ShipAddr2 varchar(80) default '',
  ShipCity varchar(80) NOT NULL default '',
  ShipState varchar(80) NOT NULL default '',
  ShipZip varchar(20) NOT NULL default '',
  ShipCountry varchar(20) NOT NULL default '',
  BillAddr1 varchar(80) NOT NULL default '',
  BillAddr2 varchar(80) default '',
  BillCity varchar(80) NOT NULL default '',
  BillState varchar(80) NOT NULL default '',
  BillZip varchar(20) NOT NULL default '',
  BillCountry varchar(20) NOT NULL default '',
  Courier varchar(80) NOT NULL default '',
  TotalPrice decimal(10,2) NOT NULL default '0.00',
  BillToFirstName varchar(80) NOT NULL default '',
  BillToLastName varchar(80) NOT NULL default '',
  ShipToFirstName varchar(80) NOT NULL default '',
  ShipToLastName varchar(80) NOT NULL default '',
  CreditCard varchar(20) NOT NULL default '',
  ExprDate varchar(7) NOT NULL default '',
  CardType varchar(40) NOT NULL default '',
  Locale varchar(20) NOT NULL default '',
  PRIMARY KEY  (OrderId)
);

--
-- 转存表中的数据 orders
--


-- --------------------------------------------------------

--
-- 表的结构 orderstatus
--

CREATE TABLE orderstatus (
  OrderId int NOT NULL default '0',
  LineNum int NOT NULL default '0',
  Timestamp datetime NOT NULL,
  Status varchar(2) NOT NULL default '',
  PRIMARY KEY  (OrderId,LineNum)
);

--
-- 转存表中的数据 orderstatus
--


-- --------------------------------------------------------

--
-- 表的结构 product
--

CREATE TABLE product (
  ProductId varchar(10) NOT NULL default '',
  Category varchar(10) NOT NULL default '',
  Name varchar(80) default '',
  Descn varchar(255) default '',
  PRIMARY KEY  (ProductId)
);

CREATE INDEX IxProduct1 ON product(NAME);
CREATE INDEX IxProduct2 ON product(Category);
CREATE INDEX IxProduct3 ON product(Category,Name);
CREATE INDEX IxProduct4 ON product(Category,ProductId,Name);

-- --------------------------------------------------------

--
-- 表的结构 profile
--

CREATE TABLE profile (
  UserId varchar(20) NOT NULL default '',
  LangPref varchar(80) NOT NULL default '',
  FavCategory varchar(30) default '',
  MyListOpt int default '0',
  BannerOpt int default '0',
  PRIMARY KEY  (UserId)
);

-- --------------------------------------------------------

--
-- 表的结构 signon
--

CREATE TABLE signon (
  UserName varchar(20) NOT NULL default '',
  Password varchar(20) NOT NULL default '',
  PRIMARY KEY  (UserName)
);

-- --------------------------------------------------------

--
-- 表的结构 supplier
--

CREATE TABLE supplier (
  SuppId int NOT NULL default '0',
  Name varchar(80) default '',
  Status varchar(2) NOT NULL default '',
  Addr1 varchar(80) default '',
  Addr2 varchar(80) default '',
  City varchar(80) default '',
  State varchar(80) default '',
  Zip varchar(5) default '',
  Phone varchar(40) default '',
  PRIMARY KEY  (SuppId)
);
