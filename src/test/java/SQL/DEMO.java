package SQL;

public class DEMO {
/*
What is DBMS(databasemanagementsystem):- it is a theoretical concept , we can store data in the form of tables..it has rows and columns..
What is RDBMS(relationaldatabasemanagementsystem):- we can use multiple tables to store data and joins tables and can retrieve data faster..
eg: oracle,mysql,my-sql server,DB2	
eg:Big data, no sql came into the picture to overcome the problems of RDBMS.(eg:fb,google use it)
what is database:-it is storage area.. 
diagram:- user interface, business-logic,database
eg:if user wants to check the account balance, it will get all details from DB..	
what is SQL? in order to delete, update, retrieve data from DB we use query language	
DB components? client and server
client:-
1)send request to the data which is tored in server
2)use SQL 
server:-
1)storage data	
Note: when install DB it has both client and server. but generally, client is light weight can be in local machine but server is always in remote machine	
we can use port number , host to connect with DB with client and write SQL query to perform operations...	
There can be multiple clients ..	
Types of clients:- 1) graphical mode 2)CLI(command line	interface)
eg:- Oracle DB -> sql developer(GUI), sql plus(CLI)
eg:- MySql->MySQLWorkbench(GUI), MySQL CommandLinetool(CLI)
	
	
MYSQL INSTALLATION:-
1) search:- my sql->click downloads-> download mysql windows installer-> custom->add mysql server+add mysql shell+add mysql bench
2)set pasword ->root and set username ->root
***Note: download Microsoft Visual C++ 2015-2022 Redistributable (x64) - 14.34.31938 before install mysql server..
3)set mysql server bin path in environment variable..
4) open cmd ->a) mysql --version   (and enter)
o/p:- mysql  Ver 8.0.32 for Win64 on x86_64 (MySQL Community Server - GPL)
	b) mysql -u root -p	 (and enter)
	c)enter password: root (enter)
	d) show databases;      (and enter)
o/p:-+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
	e) create database hemadb;
	o/p:- Query OK, 1 row affected (0.02 sec)
	
	f)show databases; and enter
	o/p:-+--------------------+
| Database           |
+--------------------+
| hemadb             |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
	
g) use hemadb;
o/p:- database changed
	
h)  CREATE TABLE EMPLOYEE (
    -> EmpID int,
    -> FirstName varchar(255),
    -> Lastname varchar(255),
    -> EmpAGE int,
    -> EmpZone varchar(255)
    -> );	
o/p:-Query OK, 0 rows affected (0.01 sec)	
	
i)  Desc Employee; //to see the structure of table..
o/p:-
	-----+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| EmpID     | int          | YES  |     | NULL    |       |
| FirstName | varchar(255) | YES  |     | NULL    |       |
| Lastname  | varchar(255) | YES  |     | NULL    |       |
| EmpAGE    | int          | YES  |     | NULL    |       |
| EmpZone   | varchar(255) | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
	5 rows in set (0.00 sec)
	
j) insert into Employee(EmpID,FirstName,LastName,EmpAGE,EmpZone)values(1,'hema','sahoo',29,'north');
o/p:- Query OK, 1 row affected (0.01 sec)	
	
 k) select * from Employee;	
 o/p:-+-------+-----------+----------+--------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone |
+-------+-----------+----------+--------+---------+
|     1 | hema      | sahoo    |     29 | north   |
+-------+-----------+----------+--------+---------+
1 row in set (0.00 sec)

l) insert into Employee(EmpID,FirstName,LastName,EmpAGE,EmpZone)values(2,'rani','singh',19,'south');
Query OK, 1 row affected (0.02 sec)

m) insert into Employee(EmpID,FirstName,LastName,EmpAGE,EmpZone)values(3,'preetam','kaur',25,'east');

n)  select * from Employee;
o/p:- +-------+-----------+----------+--------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone |
+-------+-----------+----------+--------+---------+
|     1 | hema      | sahoo    |     29 | north   |
|     2 | rani      | singh    |     19 | south   |
|     2 | rani      | singh    |     19 | south   |
|     3 | preetam   | kaur     |     25 | east    |
+-------+-----------+----------+--------+---------+
4 rows in set (0.00 sec)

	
Methods:-
Select-> allow to retrieve data from all or particular columns	
1) select firstname from Employee;	
2) select * from Employee;
3) select Lastname, EmpID from Employee;	

NotNull:- column cannot be null
eg:-  mysql> create table Details(
    ->  EmpID int not null,
    ->  FirstName varchar(255),
    -> Lastname varchar(255),
    -> EmpAGE int
    -> );	
    
mysql> desc Details;	
o/p:-	
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| EmpID     | int          | NO   |     | NULL    |       |
| FirstName | varchar(255) | YES  |     | NULL    |       |
| Lastname  | varchar(255) | YES  |     | NULL    |       |
| EmpAGE    | int          | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
4 rows in set (0.00 sec)
	
insert into Details(EmpID,FirstName,LastName,EmpAge)values(null,'rahul','sahoo',24);	
o/p:- ERROR 1048 (23000): Column 'EmpID' cannot be null
	
 insert into Details(EmpID,FirstName,LastName,EmpAge)values(1,'rahul','sahoo',24);	
Query OK, 1 row affected (0.02 sec)	
	
 select * from Details;
+-------+-----------+----------+--------+
| EmpID | FirstName | Lastname | EmpAGE |
+-------+-----------+----------+--------+
|     1 | rahul     | sahoo    |     24 |
+-------+-----------+----------+--------+
1 row in set (0.00 sec)	
	
Unique constraint:-	all the columns value should be different .so primary value is unique constraint. 
Table can have multiple unique constraint but only single primary key constraint.

eg:- mysql> create table DataDetails(
    -> EmpId int not null,
    -> FirstName varchar(255),
    -> Lastname varchar(255),
    -> Unique (EmpID)
    -> );
Query OK, 0 rows affected (0.04 sec) 

mysql> desc DataDetails;

o/p:-
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| EmpId     | int          | NO   | PRI | NULL    |       |
| FirstName | varchar(255) | YES  |     | NULL    |       |
| Lastname  | varchar(255) | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
3 rows in set (0.00 sec)


constraints:-specify the rules for the data in table,won't have null value

Primary key:-uniquely identify each row in a table. eg:-EmpId, SSN, License no, student roll no..
eg:- mysql> create table Student(
    -> EmpID int not null,
    ->  FirstName varchar(255),
    ->  LastName varchar(255),
    -> EmpZone varchar(255),
    ->  primary key(EmpID)
    -> );
mysql> desc Student;
o/p:- +-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| EmpID     | int          | NO   | PRI | NULL    |       |
| FirstName | varchar(255) | YES  |     | NULL    |       |
| LastName  | varchar(255) | YES  |     | NULL    |       |
| EmpZone   | varchar(255) | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

check constraint:- set condition to the particular column
create table EmployeeDetails(
 EmpID int not null,
  EmpName varchar(255),
  EmpAge int,
 check(EmpAge>20)
 );
Note:- mysql> insert into EmployeeDetails(EmpID,EmpName,EmpAge)values(1,'sumit',12);
ERROR 3819 (HY000): Check constraint 'employeedetails_chk_1' is violated.

Note:- mysql> insert into EmployeeDetails(EmpID,EmpName,EmpAge)values(1,'sumit',25);
Query OK, 1 row affected (0.02 sec)

mysql> select * from EmployeeDetails;
+-------+---------+--------+
| EmpID | EmpName | EmpAge |
+-------+---------+--------+
|     1 | sumit   |     25 |
+-------+---------+--------+

Default constraint:- if value is not assigned to the column it will by deafult assign it 

mysql> create table defaultconst(
    -> empid int not null,
    -> empname varchar(255),
    -> empdept varchar(255) default 'operations'
    -> );
 o/p:-mysql> desc defaultconst;
+---------+--------------+------+-----+------------+-------+
| Field   | Type         | Null | Key | Default    | Extra |
+---------+--------------+------+-----+------------+-------+
| empid   | int          | NO   |     | NULL       |       |
| empname | varchar(255) | YES  |     | NULL       |       |
| empdept | varchar(255) | YES  |     | operations |       |
+---------+--------------+------+-----+------------+-------+
3 rows in set (0.00 sec)   
    
Note:- 
mysql> insert into defaultconst(empid,empname)values(1,'rubby');
Query OK, 1 row affected (0.02 sec)

mysql> desc defaultconst;
+---------+--------------+------+-----+------------+-------+
| Field   | Type         | Null | Key | Default    | Extra |
+---------+--------------+------+-----+------------+-------+
| empid   | int          | NO   |     | NULL       |       |
| empname | varchar(255) | YES  |     | NULL       |       |
| empdept | varchar(255) | YES  |     | operations |       |
+---------+--------------+------+-----+------------+-------+
3 rows in set (0.00 sec)
		
mysql> select * from defaultconst;
+-------+---------+------------+
| empid | empname | empdept    |
+-------+---------+------------+
|     1 | rubby   | operations |
+-------+---------+------------+
1 row in set (0.00 sec)	
	
	
Index constraint:- it is use to retrieve data from DB , quickly than any other method

mysql> select * from Employee;
+-------+-----------+----------+--------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone |
+-------+-----------+----------+--------+---------+
|     1 | hema      | sahoo    |     29 | north   |
|     2 | rani      | singh    |     19 | south   |
|     2 | rani      | singh    |     19 | south   |
|     3 | preetam   | kaur     |     25 | east    |
|     1 | hema      | sahoo    |     23 | north   |
+-------+-----------+----------+--------+---------+
	
mysql> create index demoindex
    -> on Employee(FirstName);
    
Query OK, 0 rows affected (0.06 sec)
Records: 0  Duplicates: 0  Warnings: 0	
	
mysql> create index demoindex2
    -> on Employee(LastName,EmpAge,FirstName);
    
Query OK, 0 rows affected (0.03 sec)
Records: 0  Duplicates: 0  Warnings: 0	
	
mysql> show indexes from Employee;
+----------+------------+------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+
| Table    | Non_unique | Key_name   | Seq_in_index | Column_name | Collation | Cardinality | Sub_part | Packed | Null | Index_type | Comment | Index_comment | Visible | Expression |
+----------+------------+------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+
| employee |          1 | demoindex  |            1 | FirstName   | A         |           3 |     NULL |   NULL | YES  | BTREE      |         |               | YES     | NULL       |
| employee |          1 | demoindex2 |            1 | Lastname    | A         |           3 |     NULL |   NULL | YES  | BTREE      |         |               | YES     | NULL       |
| employee |          1 | demoindex2 |            2 | EmpAGE      | A         |           4 |     NULL |   NULL | YES  | BTREE      |         |               | YES     | NULL       |
| employee |          1 | demoindex2 |            3 | FirstName   | A         |           4 |     NULL |   NULL | YES  | BTREE      |         |               | YES     | NULL       |
+----------+------------+------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+	
	
Delete index/Drop index:-	mysql> Drop index demoindex on Employee;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0
	
mysql> show indexes from Employee;
+----------+------------+------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+
| Table    | Non_unique | Key_name   | Seq_in_index | Column_name | Collation | Cardinality | Sub_part | Packed | Null | Index_type | Comment | Index_comment | Visible | Expression |
+----------+------------+------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+
| employee |          1 | demoindex2 |            1 | Lastname    | A         |           3 |     NULL |   NULL | YES  | BTREE      |         |               | YES     | NULL       |
| employee |          1 | demoindex2 |            2 | EmpAGE      | A         |           4 |     NULL |   NULL | YES  | BTREE      |         |               | YES     | NULL       |
| employee |          1 | demoindex2 |            3 | FirstName   | A         |           4 |     NULL |   NULL | YES  | BTREE      |         |               | YES     | NULL       |
+----------+------------+------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+
3 rows in set (0.00 sec)	

/////////////////////////////////////////////Alter Table //////////////////////////////
Alert a Table/(Add and Drop a column from existing Table):-
mysql> desc Employee;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| EmpID     | int          | YES  |     | NULL    |       |
| FirstName | varchar(255) | YES  |     | NULL    |       |
| Lastname  | varchar(255) | YES  | MUL | NULL    |       |
| EmpAGE    | int          | YES  |     | NULL    |       |
| EmpZone   | varchar(255) | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+	
	
mysql> alter Table Employee
    -> add EmpDept varchar(255);
    
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0	
	
mysql> desc Employee;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| EmpID     | int          | YES  |     | NULL    |       |
| FirstName | varchar(255) | YES  |     | NULL    |       |
| Lastname  | varchar(255) | YES  | MUL | NULL    |       |
| EmpAGE    | int          | YES  |     | NULL    |       |
| EmpZone   | varchar(255) | YES  |     | NULL    |       |
| EmpDept   | varchar(255) | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
6 rows in set (0.00 sec)	
	
	
mysql> Alter Table Employee
    -> Drop Column EmpDept;
    
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0	
	
	
mysql> desc Employee;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| EmpID     | int          | YES  |     | NULL    |       |
| FirstName | varchar(255) | YES  |     | NULL    |       |
| Lastname  | varchar(255) | YES  | MUL | NULL    |       |
| EmpAGE    | int          | YES  |     | NULL    |       |
| EmpZone   | varchar(255) | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
5 rows in set (0.00 sec)	
	
Alter a Table(Modify a column):-
mysql>  Alter Table Employee
    -> add column EmpDept varchar(255);
    
Query OK, 0 rows affected (0.02 sec)
Records: 0  Duplicates: 0  Warnings: 0	
	
	
mysql> Alter Table Employee
    -> modify column EmpDept int;
    
Query OK, 5 rows affected (0.04 sec)
Records: 5  Duplicates: 0  Warnings: 0
	
mysql> desc Employee;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| EmpID     | int          | YES  |     | NULL    |       |
| FirstName | varchar(255) | YES  |     | NULL    |       |
| Lastname  | varchar(255) | YES  | MUL | NULL    |       |
| EmpAGE    | int          | YES  |     | NULL    |       |
| EmpZone   | varchar(255) | YES  |     | NULL    |       |
| EmpDept   | int          | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
6 rows in set (0.00 sec)	
	*/
}
