package SQL;

public class Demo2 {

	/*
1) Update:- update the existing record , update multiple records or single record
mysql> update Employee
    -> set EmpAGE=25
    -> where EmpID=2;
Query OK, 2 rows affected (0.02 sec)
Rows matched: 2  Changed: 2  Warnings: 0

mysql> select * from Employee;
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     2 | rani      | singh    |     25 | south   |    NULL |
|     2 | rani      | singh    |     25 | south   |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
4 rows in set (0.00 sec)

2) Drop table:- delete entire records from the table and also the structure of the table
syntax:- Drop table Employee;

3)Drop Database:- Drop Database Databasename;
Note:- show databases; (to check particular DB does not exists)
Note:- use hemadb1;(error coz DB deleted)

4)




























*/
}
