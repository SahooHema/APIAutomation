package SQL;

public class Demo1 {
	
/*
 A) select distinct :- to retrieve distinct value(remove duplicate value if present in particular column) from the table
 
 mysql> select * from Employee;
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     3 | preetam   | kaur     |     25 | east    |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
5 rows in set (0.00 sec)
 
 
 mysql> select EmpAGE from Employee;
+--------+
| EmpAGE |
+--------+
|     25 |
|     23 |
|     29 |
|     19 |
|     19 |
+--------+
5 rows in set (0.00 sec)
 
 
 mysql> select distinct EmpAGE from Employee;
+--------+
| EmpAGE |
+--------+
|     25 |
|     23 |
|     29 |
|     19 |
+--------+
4 rows in set (0.02 sec)
 
B) Display records from particular column:-
 mysql> select  FirstName from Employee;
+-----------+
| FirstName |
+-----------+
| preetam   |
| hema      |
| hema      |
| rani      |
| rani      |
+-----------+
5 rows in set (0.00 sec)
 
///////////////////////////Operator in Where clause/////////////////////////
C)Where clause
mysql> select * from Employee
    -> where EmpID=2;
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     2 | rani      | singh    |     19 | south   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
+-------+-----------+----------+--------+---------+---------+
2 rows in set (0.00 sec)
 
 mysql> select * from Employee
    -> where EmpAGE<=25;
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     2 | rani      | singh    |     19 | south   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     3 | preetam   | kaur     |     25 | east    |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
4 rows in set (0.02 sec)
 
D)AND operator:- displays records only if when all the condition separated by AND is equal
 
mysql> select * from Employee
    -> where EmpID=3 AND EmpZone='east';
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     3 | preetam   | kaur     |     25 | east    |    NULL |
+-------+-----------+----------+--------+---------+---------+
1 row in set (0.00 sec) 
 
 
 mysql> select * from Employee
    ->  where EmpID=3 AND EmpZone='east' AND Lastname='kaur';
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     3 | preetam   | kaur     |     25 | east    |    NULL |
+-------+-----------+----------+--------+---------+---------+
1 row in set (0.00 sec)
 
 E)OR operator:- displays records only if when all the condition separated by OR is equal
 mysql> select * from Employee
    -> where EmpZone='east' OR EmpZone='north';
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     3 | preetam   | kaur     |     25 | east    |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
3 rows in set (0.00 sec)

mysql>  select * from Employee
    -> where EmpZone='east' or FirstName='hema';
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     3 | preetam   | kaur     |     25 | east    |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
3 rows in set (0.00 sec) 
 
F) NOT operator:- 
 
 mysql>  select * from Employee
    -> where NOT EmpAGE=19;
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     3 | preetam   | kaur     |     25 | east    |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
3 rows in set (0.00 sec)
 
G)Comments(SingleLine/MultipleLine):- statement which does not get executed
select * from Employee;  #fetch all records from the table      (for single line comments)
select * from Employee;  -- fetch all records from the table 
 
// mysql> select *
//    -> /*
//   /*> reterive all records from
//   /*> table employee.we are using slect               (for multiple line comments)
//   /*> statement
//   /*> */
////    -> From Employee;
 /*
H)Count():- to count no.of rows and matching criteria 
mysql> select count(EmpAGE)
    -> from Employee
    -> where EmpAGE=19;
+---------------+
| count(EmpAGE) |
+---------------+
|             2 |
+---------------+
1 row in set (0.02 sec) 
  
 mysql> select count(*)
    -> from Employee;
+----------+
| count(*) |
+----------+
|        5 |
+----------+
1 row in set (0.01 sec) 
//////////////////////////////////ALIAS/////////////////////////////  
I)Alias:- it is a temporary name given to the column.makes column more readable..work only during the duration of the query. 
  mysql> select EmpAGE as Age_Of_Employees
    -> from Employee;
+------------------+
| Age_Of_Employees |
+------------------+
|               25 |
|               23 |
|               29 |
|               19 |
|               19 |
+------------------+
5 rows in set (0.00 sec)
  
 mysql> select FirstName AS Name1, LastName AS Name2
    -> from Employee;
+---------+-------+
| Name1   | Name2 |
+---------+-------+
| preetam | kaur  |
| hema    | sahoo |
| hema    | sahoo |
| rani    | singh |
| rani    | singh |
+---------+-------+
5 rows in set (0.00 sec) 
  
After query duration completed then check the table:-  
  
 mysql> select * from Employee;
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     3 | preetam   | kaur     |     25 | east    |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
5 rows in set (0.00 sec) 
  
J)In  and NOT IN operator:-   
 mysql> select * from Employee
    -> where EmpZone IN('east','south');
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     2 | rani      | singh    |     19 | south   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     3 | preetam   | kaur     |     25 | east    |    NULL |
+-------+-----------+----------+--------+---------+---------+
3 rows in set (0.00 sec) 
  
 mysql> select * from Employee
    -> where EmpZone NOT IN ('east','south');
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
2 rows in set (0.00 sec) 
  
K)LIKE OPERATOR:- To Search for specific  pattern in the column
  % -> zero, one or more characters
  _ -> a single character
  
  mysql>  select * from Employee
  
  +-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     3 | preetam   | kaur     |     25 | east    |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
5 rows in set (0.00 sec)
  
  mysql> select * from Employee
    -> where FirstName like 'h%';
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
2 rows in set (0.00 sec)
  
 mysql> select * from Employee
    -> where EmpZone like '%h';
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
4 rows in set (0.00 sec) 
  
mysql> select * from Employee
    -> where EmpZone like '___t';
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     3 | preetam   | kaur     |     25 | east    |    NULL |
+-------+-----------+----------+--------+---------+---------+
1 row in set (0.00 sec)  
  
 mysql> select * from Employee
    -> where Empzone like 'n____';
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
2 rows in set (0.00 sec) 
  
mysql> select * from Employee
    -> where LastName like '__h__';
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
2 rows in set (0.00 sec)  
  
  
L)Between Operator:- select value between the range 

  mysql> select * from Employee
    -> where EmpAGE between 19 and 29;
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     3 | preetam   | kaur     |     25 | east    |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
5 rows in set (0.00 sec)
  
mysql>  select * from Employee
    -> where EmpAGE not between 19 and 23;
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     3 | preetam   | kaur     |     25 | east    |    NULL |
+-------+-----------+----------+--------+---------+---------+
2 rows in set (0.00 sec)  

////////////////////////////////////////////////////////////////////////////////////////
M)Case statement :- if-else condition, if condition not met then else condition will met
mysql> select FirstName, Lastname, EmpAGE,
    -> case
    -> when EmpAGE > 29 then 'employee with experience.eligible for sr profile'
    -> when EmpAGE = 29 then 'employee with mid-experinec.eligible!'
    -> else 'fresher'
    -> end as eligibility
    -> from Employee;
+-----------+----------+--------+---------------------------------------+
| FirstName | Lastname | EmpAGE | eligibility                           |
+-----------+----------+--------+---------------------------------------+
| preetam   | kaur     |     25 | fresher                               |
| hema      | sahoo    |     23 | fresher                               |
| hema      | sahoo    |     29 | employee with mid-experinec.eligible! |
| rani      | singh    |     19 | fresher                               |
| rani      | singh    |     19 | fresher                               |
+-----------+----------+--------+---------------------------------------+
5 rows in set (0.00 sec)
  
 N)Delete/Truncate statement:- delete particular record or all records from the column. only remain structure of the table..
 mysql> delete from employee
    -> where Lastname='kaur';
Query OK, 1 row affected (0.02 sec)

mysql> select * from Employee;
+-------+-----------+----------+--------+---------+---------+
| EmpID | FirstName | Lastname | EmpAGE | EmpZone | EmpDept |
+-------+-----------+----------+--------+---------+---------+
|     1 | hema      | sahoo    |     29 | north   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     2 | rani      | singh    |     19 | south   |    NULL |
|     1 | hema      | sahoo    |     23 | north   |    NULL |
+-------+-----------+----------+--------+---------+---------+
4 rows in set (0.00 sec)  
  
Note: delete from Employee; (to delete all records)  
Note:- desc Employee; (to check the table, if any records there or not)  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
*/
}
