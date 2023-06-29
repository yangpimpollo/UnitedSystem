

USE unitedvanlines_SampleDB


SELECT employee_name FROM Employee WHERE employee_id = 800;

SELECT * FROM Employee;
UPDATE Employee SET employee_name='fulano de tal' WHERE employee_id='800'

INSERT INTO Employee (employee_name, job) VALUES ('fulano', 'boss');
INSERT INTO Employee (employee_name, job) VALUES ('fulano1', 'ceo');
INSERT INTO Employee (employee_name, job) VALUES ('fulano2', 'manager');
INSERT INTO Employee (employee_name, job) VALUES ('fulano3', 'rrhh');
INSERT INTO Employee (employee_name, job) VALUES ('sales_minion', 'sales Manager');
INSERT INTO Employee (employee_name, job) VALUES ('logistics_minion', 'logistics');
INSERT INTO Employee (employee_name, job) VALUES ('logistics_minion', 'logistics');
INSERT INTO Employee (employee_name, job) VALUES ('minion001', 'minion');
INSERT INTO Employee (employee_name, job) VALUES ('minion002', 'minion');
INSERT INTO Employee (employee_name, job) VALUES ('Astucuri', 'student');
INSERT INTO Employee (employee_name, job) VALUES ('Tapia', 'student');

SELECT * FROM DocType;

INSERT INTO DocType (doc_type) VALUES ('passport');
INSERT INTO DocType (doc_type) VALUES ('CE');
INSERT INTO DocType (doc_type) VALUES ('DNI');

SELECT * FROM Services;
DELETE FROM Services;
UPDATE Services SET service_name='Standard D montacargas x h' WHERE service_id='SD8'

INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SA', 'Standard A Residential', 1800);
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SB', 'Standard B Commercial', 5000);
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SC', 'Standard C Corporate', 20000);
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SD1', 'Standard D packaging small', 2);
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SD2', 'Standard D packaging medium', 4);
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SD3', 'Standard D packaging big', 8);
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SD4', 'Standard D camion small x h', 40);
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SD5', 'Standard D camion medium x h', 60);
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SD6', 'Standard D camion big x h', 100);
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SD7', 'Standard D minion x h', 20);
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SD8', 'Standard D montacargas x h', 25);
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SX', 'Special Service S', 1);


SELECT * FROM Accounts;
DELETE FROM Accounts

ALTER TABLE Accounts ALTER COLUMN pass BINARY(64) NOT NULL

ALTER TABLE Accounts
ALTER COLUMN pass VARBINARY(64) NOT NULL

INSERT INTO Accounts (Employee_employee_id, user_name) VALUES (800, 'fulano');

go;

------------------------------------------------------
go;

CREATE PROCEDURE addAccount
    @_id int, 
    @_user_name VARCHAR(20), 
	@_pass VARCHAR(20)
AS
	INSERT INTO Accounts (Employee_employee_id, user_name, pass) VALUES (@_id, @_user_name, HASHBYTES('SHA2_512', @_pass) );
GO;

EXEC addAccount
          @_id = 800,
          @_user_name = 'fulano',
          @_pass = '1234'
go;

------------------------------------------------------

CREATE PROCEDURE singinAccount
    @_user_name VARCHAR(20), 
	@_pass VARCHAR(20)
AS
	SELECT * FROM Accounts WHERE user_name = @_user_name AND pass = HASHBYTES('SHA2_512', @_pass)
GO;

EXEC singinAccount
          @_user_name = 'fulano',
          @_pass = '12234'
go;

EXEC singinAccount @_user_name = 'fulano', @_pass = '1234'
EXEC singinAccount @_user_name = '', @_pass = ''
go;

SELECT A.* , E.employee_name
FROM Accounts As A, Employee as E
WHERE user_name = @_user_name AND pass = HASHBYTES('SHA2_512', @_pass) AND A.Employee_employee_id = E.employee_id

SELECT A.* , E.employee_name
FROM Accounts As A, Employee as E
WHERE user_name = 'fulano' AND pass = HASHBYTES('SHA2_512', '1234') AND A.Employee_employee_id = E.employee_id
GO;

ALTER PROCEDURE singinAccount
    @_user_name VARCHAR(20), 
	@_pass VARCHAR(20)
AS
	SELECT A.* , E.employee_name
	FROM Accounts As A, Employee as E
	WHERE user_name = @_user_name AND pass = HASHBYTES('SHA2_512', @_pass) AND A.Employee_employee_id = E.employee_id
GO;


EXEC addAccount
          @_id = 800,
          @_user_name = '0',
          @_pass = '0'

go;


------------------------------------------------------

CREATE PROCEDURE addCustomer
    @_dat1 VARCHAR(20), 
    @_dat2 VARCHAR(20), 
	@_dat3 VARCHAR(20),
	@_dat4 VARCHAR(20), 
    @_dat5 VARCHAR(20), 
	@_dat6 VARCHAR(20),
	@_dat7 VARCHAR(20), 
	@_dat8 VARCHAR(20)
AS
	INSERT INTO Customers(customer_id,DocType_doc_type, business_name, first_name, last_name, address, email, phone) 
	VALUES (CAST(@_dat1 AS INT),@_dat2, @_dat3,@_dat4,@_dat5, @_dat6,@_dat7, @_dat8);
GO;
-----------------------------------
EXEC addCustomer
          @_dat1 = '00425689',
          @_dat2 = 'DNI',
          @_dat3 = 'fulano ++',
		  @_dat4 = '',
		  @_dat5 = '',
		  @_dat6 = '',
		  @_dat7 = '',
		  @_dat8 = '900123456'

------------------------------------------------------

SELECT * FROM Customers;
DELETE FROM Customers;
INSERT INTO Customers(customer_id,DocType_doc_type, business_name, first_name, last_name, address, email, phone) 
VALUES (12345678,'DNI', 'fulano de la torre', 'de la torre', 'fulano', 'Tierra', 'fulano@fulano.com', '987654321');

ALTER TABLE Customers DROP CONSTRAINT PK__Customer__CD65CB858606C682;
ALTER TABLE Customers ALTER COLUMN customer_id int NOT NULL, ADD PRIMARY KEY (customer_id);

SELECT CONSTRAINT_NAME
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'Customers' AND COLUMN_NAME = 'customer_id' AND CONSTRAINT_NAME LIKE 'PK%'

    private String doctype;
    private String docid;
    private String bussname;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phone;


EXEC sp_MSforeachtable 'DROP TABLE ?'

SELECT * FROM Accounts;
SELECT * FROM Customers;
SELECT * FROM DocType;
SELECT * FROM Employee;
SELECT * FROM Inventory;
SELECT * FROM OrderDetails;
SELECT * FROM Orders;
SELECT * FROM Services;

DROP TABLE Accounts;
DROP TABLE Customers;
DROP TABLE DocType;
DROP TABLE Employee;
DROP TABLE Inventory;
DROP TABLE OrdeDetails;

DROP TABLE Orders;
DROP TABLE Services;