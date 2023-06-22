

USE unitedvanlines_SampleDB


SELECT employee_name FROM Employee WHERE employee_id = 800;

SELECT * FROM Employee;

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
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SD8', 'Standard D montacargas', 25);
INSERT INTO Services (service_id, service_name, unit_price) VALUES ('SX', 'Special Service S', 1);


SELECT * FROM Accounts;
DELETE FROM Accounts

ALTER TABLE Accounts ALTER COLUMN pass BINARY(64) NOT NULL

ALTER TABLE Accounts
ALTER COLUMN pass VARBINARY(64) NOT NULL

INSERT INTO Accounts (Employee_employee_id, user_name) VALUES (800, 'fulano');

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
go;


EXEC addAccount
          @_id = 800,
          @_user_name = '0',
          @_pass = '0'