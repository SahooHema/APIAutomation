package SQL;

public class JoinsDemo {

	public static void main(String[] args) {
		/*
Joins:- It is a clause , that used to combine rows from two or more tables.joining is based on related column

inner joins:- return record that have matching value in both tables

left joins:- return all records from left table and matched record from  right table

right joins:- return all records from right table and matched record from  left table
		 
full joins:- not supported in MYSQL	  
		 
mysql> select * from Employee1;
+-------+--------+----------------+
| EmpID | DeptID | EmpName        |
+-------+--------+----------------+
|   100 |      2 | Tom Hanks      |
|   101 |      4 | Bradely Cooper |
|   102 |      3 | Jack Sparrow   |
+-------+--------+----------------+
3 rows in set (0.00 sec)

mysql> select * from Department;
+--------+------------+----------+
| DeptID | DeptName   | DeptZone |
+--------+------------+----------+
|      1 | opeartions | North    |
|      2 | finance    | south    |
|      3 | marketing  | east     |
+--------+------------+----------+
3 rows in set (0.00 sec)

1) inner joins:-
mysql>  select Employee1.EmpID,Department.DeptName
    -> From Employee1
    -> inner join Department on Employee1.DeptID=Department.DeptID;
+-------+-----------+
| EmpID | DeptName  |
+-------+-----------+
|   100 | finance   |
|   102 | marketing |
+-------+-----------+
2 rows in set (0.00 sec)		 
		 
2)left joins:-	 
mysql> select Employee1.EmpID,Department.DeptName
    -> from Department
    ->  left join Employee1 on Employee1.DeptID=Department.DeptID;
+-------+------------+
| EmpID | DeptName   |
+-------+------------+
|  NULL | opeartions |
|   100 | finance    |
|   102 | marketing  |
+-------+------------+
3 rows in set (0.00 sec)

3) right joins:-
mysql>  select Employee1.EmpID,Department.DeptName
    -> from Department
    -> right join Employee1 on Employee1.DeptID=Department.DeptID;
+-------+-----------+
| EmpID | DeptName  |
+-------+-----------+
|   100 | finance   |
|   101 | NULL      |
|   102 | marketing |
+-------+-----------+
3 rows in set (0.00 sec)
		 
full outer joins:- return full records if there is a match in either left or right table
		 
		 
Self join:- table is join to itself
find the respective names of manager for each employees?
Note:taken screenshot

Union:- used to join two or more tables 
same number of columns selected and expresions
same data type 		 
have the in the same order
remove duplicate records		 
		 
		 
Union All:- include duplicates
		 
		 
////////////////////interview Questions for SQL////////////////////////////
1)Which command will executed first?
from<where<groupBy<having<select<order by<limit

2)Find monthly sale and sort it by desc order?
select year(order_date) as years, month(order_date) as months, sum(Sales) as totalsales
from products
group by year(order_date),month(order_date)
order by totalsales desc;

3) select candidate_id(candidate_id),count(skills) as skills_count
	from Applications
	where skills in('python','SQL','power Bi')
	group by candidate_id(candidate_id)
	having count(skills)=3
	order by skills_count asc;   
		  
4)		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 */

	}

}
