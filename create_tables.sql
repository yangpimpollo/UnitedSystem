


CREATE TABLE [AllServices](
  service_id varchar(3) NOT NULL PRIMARY KEY,
  service_name varchar(40),
  unit_price money,
)
GO

CREATE TABLE [OrderDetails](
  unit_price money,
  quantity int,
  discount float,
  [Orders_order_id] int NOT NULL,
  [AllServices_service_id] varchar(3) NOT NULL
)
GO

CREATE TABLE [Orders](
  order_id int IDENTITY(10000000,1) NOT NULL PRIMARY KEY,
  [Employee_employee_id] int NOT NULL,
  [Customers_customer_id] varchar(15) NOT NULL,
  [date] date NOT NULL,
)
GO

CREATE TABLE [Employee](
  employee_id int IDENTITY(800,1) NOT NULL PRIMARY KEY,
  employee_name varchar(20) NOT NULL,
  job varchar(20) NOT NULL,
)
GO

CREATE TABLE [Accounts](
  [Employee_employee_id] int NOT NULL, 
  user_name varchar(20) NOT NULL,
  pass varbinary(64) NOT NULL
)
GO

CREATE TABLE [Customers](
  customer_id varchar(15) NOT NULL PRIMARY KEY,
  [DocType_doc_type] varchar(10) NOT NULL,
  business_name varchar(40),
  first_name varchar(20),
  last_name varchar(20),
  address varchar(30),
  email varchar(20),
  phone varchar(9),
)
GO

CREATE TABLE [DocType]
  (doc_type varchar(10) NOT NULL PRIMARY KEY)
GO

CREATE TABLE [Inventory](
  object_id int IDENTITY(40000,1) NOT NULL PRIMARY KEY,
  [Orders_order_id] int,
  category varchar(10),
  [object] varchar(20),
  details varchar(60),
)
GO

ALTER TABLE [OrderDetails]
  ADD CONSTRAINT [OrderDetails_Orders_order_id_fkey]
    FOREIGN KEY ([Orders_order_id]) REFERENCES [Orders] (order_id)
GO

ALTER TABLE [Orders]
  ADD CONSTRAINT [Orders_Employee_employee_id_fkey]
    FOREIGN KEY ([Employee_employee_id]) REFERENCES [Employee] (employee_id)
GO

ALTER TABLE [Accounts]
  ADD CONSTRAINT [Accounts_Employee_employee_id_fkey]
    FOREIGN KEY ([Employee_employee_id]) REFERENCES [Employee] (employee_id)
GO

ALTER TABLE [Orders]
  ADD CONSTRAINT [Orders_Customers_customer_id_fkey]
    FOREIGN KEY ([Customers_customer_id]) REFERENCES [Customers] (customer_id)
GO

ALTER TABLE [Customers]
  ADD CONSTRAINT [Customers_DocType_doc_type_fkey]
    FOREIGN KEY ([DocType_doc_type]) REFERENCES [DocType] (doc_type)
GO

ALTER TABLE [Inventory]
  ADD CONSTRAINT [Inventory_Orders_order_id_fkey]
    FOREIGN KEY ([Orders_order_id]) REFERENCES [Orders] (order_id)
GO

ALTER TABLE [OrderDetails]
  ADD CONSTRAINT [OrderDetails_AllServices_service_id_fkey]
    FOREIGN KEY ([AllServices_service_id]) REFERENCES [AllServices] (service_id)
GO