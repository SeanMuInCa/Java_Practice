SELECT * FROM employees

#选择工资不在5000到12000的员工姓名和工资
SELECT first_name, last_name,salary,department_id
FROM employees
WHERE NOT salary BETWEEN 5000 AND 12000;

#选择在20或50部门工作的员工姓名和部门号
SELECT first_name, last_name,salary,department_id
FROM employees
WHERE department_id = 20 || department_id = 50;

#选择没有管理者的员工姓名及job_id
SELECT first_name, last_name, job_id,manager_id
FROM employees
WHERE manager_id IS NULL;

#选择有奖金的员工姓名，工资和奖金级别
SELECT first_name, last_name, salary, commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;

#选择员工姓名第三个字母是a的
SELECT *
FROM employees
WHERE last_name LIKE '__a%';

#选择员工姓名有a和k的
SELECT *
FROM employees
WHERE last_name LIKE '%a%' AND last_name LIKE '%k%';

#选择员工姓名以e结尾的
SELECT *
FROM employees
WHERE last_name REGEXP 'e$'

#显示部门编号在80-100的员工
SELECT *
FROM employees
#WHERE department_id in (80,90,100)
WHERE department_id BETWEEN 80 AND 100;

#manager_id 是100,101,110
SELECT *
FROM employees
WHERE manager_id IN (100,101,110)

#查询员工姓名和部门号和年薪，按年薪降序，按姓名升序
SELECT first_name, last_name,salary,department_id, salary * (1 + IFNULL(commission_pct,0)) * 12 "Annual_salary"
FROM employees
ORDER BY Annual_salary DESC, last_name ASC;

#工资不在8000到17000的员工姓名，工资，按工资降序，显示21到40的数据
SELECT * FROM employees
WHERE NOT salary BETWEEN 8000 AND 17000
ORDER BY salary DESC
LIMIT 20 OFFSET 20;

#邮箱中包含e的员工信息，按邮箱字节数降序，按部门号升序
SELECT * FROM employees
WHERE email LIKE '%e%'
ORDER BY LENGTH(email) DESC, department_id ASC

DESC departments
DESC employees
DESC locations
DESC job_grades
SELECT employee_id,department_name
FROM employees,departments
WHERE employees.department_id = departments.department_id

#练习：查询员工的employee_id,last_name,department_name,city
SELECT employees.employee_id, employees.last_name, departments.department_name,locations.city
FROM employees, departments, locations
WHERE employees.department_id = departments.department_id
AND departments.location_id = locations.location_id

#非等值连接，就是没有等式，而是条件的
SELECT last_name, salary,grade_level
FROM employees,job_grades
WHERE employees.salary BETWEEN job_grades.lowest_sal AND job_grades.highest_sal
ORDER BY job_grades.grade_level DESC, salary DESC

#自连接的例子：
#练习：查询员工id,员工姓名及其管理者的id和姓名
SELECT t1.last_name,t1.first_name,t1.employee_id,t2.last_name "manager_name"
FROM employees t1, employees t2
WHERE t1.manager_id <=> t2.employee_id

#######自连接的例子：99语法
#练习：查询员工id,员工姓名及其管理者的id和姓名
SELECT t1.last_name,t1.first_name,t1.employee_id,t2.last_name "manager_name"
FROM employees t1 LEFT JOIN employees t2
ON t1.manager_id = t2.employee_id


#外连接练习
#练习：查询所有的员工的last_name,department_name信息 这里有个员工没有部门，因此总数107的员工，由部门的106
SELECT last_name, department_name
FROM employees, departments
WHERE employees.department_id = departments.department_id  

#SQL99语法实现外连接：
SELECT last_name,department_name,city
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`
LEFT JOIN locations
ON d.location_id = locations.location_id

#SQL99语法实现外连接：
SELECT last_name,department_name,city
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`
RIGHT JOIN locations
ON d.location_id = locations.location_id

#多表查询
# 1.显示所有员工的姓名，部门号和部门名称。
SELECT first_name, last_name, departments.department_id, departments.department_name
FROM employees LEFT JOIN departments
ON employees.department_id = departments.department_id

# 2.查询90号部门员工的job_id和90号部门的location_id
SELECT first_name, last_name,job_id, departments.department_id, departments.department_name, locations.city, departments.location_id
FROM employees JOIN departments
ON employees.department_id = 90 AND departments.department_id = 90
JOIN locations
ON departments.location_id = locations.location_id

# 3.选择所有有奖金的员工的 last_name , department_name , location_id , city
SELECT last_name , department_name , departments.location_id , locations.city
FROM employees LEFT JOIN departments
ON employees.department_id = departments.department_id
LEFT JOIN locations
ON departments.location_id = locations.location_id
WHERE employees.commission_pct IS NOT NULL

# 4.选择city在Toronto工作的员工的 last_name , job_id , department_id , department_name 
SELECT e.last_name , e.job_id , d.department_id , d.department_name
FROM employees e JOIN departments d
ON e.department_id = d.department_id
JOIN locations l
ON d.location_id = l.location_id
WHERE l.city = 'Toronto'

# 5.查询员工所在的部门名称、部门地址、姓名、工作、工资，其中员工所在部门的部门名称为’Executive’
SELECT e.last_name , e.job_id , e.salary, d.department_id , d.department_name,l.street_address
FROM employees e JOIN departments d
ON e.department_id = d.department_id
JOIN locations l
ON d.location_id = l.location_id
WHERE d.department_name = 'Executive'

# 6.选择指定员工的姓名，员工号，以及他的管理者的姓名和员工号，结果类似于下面的格式
employees	Emp#	manager	Mgr#
kochhar		101	king	100

SELECT t1.last_name "employees", t1.employee_id "Emp#", t2.last_name "manager", t2.employee_id "Mgr#"
FROM employees t1 LEFT JOIN employees t2
ON t2.employee_id = t1.manager_id

# 7.查询哪些部门没有员工
SELECT department_name
FROM employees e RIGHT JOIN departments d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL

# 8. 查询哪个城市没有部门 
SELECT department_name, city,locations.location_id
FROM departments RIGHT JOIN locations
ON departments.location_id = locations.location_id
WHERE departments.location_id IS NULL

# 9. 查询部门名为 Sales 或 IT 的员工信息
SELECT *
FROM employees e JOIN departments d
ON e.department_id = d.department_id
WHERE d.department_name IN('Sales','IT')

#单行函数
#1. 显示系统时间，日期+时间
SELECT NOW(), CURDATE(),CURTIME(),CONCAT(CURDATE(),' + ',CURTIME()) "detail"
FROM DUAL

#2. 查询员工号，姓名，工资，以及工资提高百分之20后的结果
SELECT employee_id,last_name,salary,salary * 1.2 "new salary"
FROM employees

#3. 将员工的姓名按首字母排序，并写出姓名的长度
SELECT last_name, LENGTH(last_name) "len"
FROM employees
ORDER BY ASCII(last_name) DESC, len DESC

#4. 查询员工id,last_name,salary,并作为一个列输出
SELECT CONCAT(employee_id,last_name,salary) "out_put"
FROM employees

#5. 查询公司各员工工作的年数，工作的天数，并按照工作念书降序排序
SELECT last_name,YEAR(NOW()) - YEAR(hire_date) "years", DATEDIFF(NOW(),hire_date) "days"
FROM employees
ORDER BY years DESC

#6. 查询员工姓名，hire_date,department_id,满足一下条件，雇佣时间在1997年之后，80，90，110部门，pct不为空
SELECT last_name,hire_date,department_id,commission_pct
FROM employees
# where year(hire_date) >= 1997 
WHERE hire_date >= '1997-01-01'
AND department_id IN (80,90,110) 
AND commission_pct IS NOT NULL
ORDER BY hire_date DESC

#7. 查询公司中入职超过10000天的员工，入职时间
SELECT last_name, hire_date
FROM employees
WHERE DATEDIFF(NOW(),hire_date) >= 10000
ORDER BY hire_date

#8. 做一个查询产生如下结果
#last_name earns salary monthly but wants salary * 3
SELECT CONCAT(last_name, ' earns ',TRUNCATE(salary,0),' monthly but wants ', TRUNCATE(salary * 3,0)) "dream"
FROM employees

#9. 使用case-when
SELECT last_name,job_id, CASE job_id WHEN "AD_PRES" THEN 'A'
				    WHEN "ST_MAN" THEN 'B'
				    WHEN "IT_PROG" THEN 'C'
				    WHEN "SA_REP" THEN 'D'
				    WHEN "ST_CLERK" THEN 'E'
				    END "grade"
FROM employees

#组函数练习

#练习：查询部门id为10,20,30,40这4个部门中最高工资比10000高的部门信息
select department_id,MAX(salary)
from employees
GROUP BY department_id
HAVING MAX(salary) > 10000 and department_id IN (10,20,30,40)
#更好的就是各干各的,普通的就用where，组函数就用having
SELECT department_id,MAX(salary)
FROM employees
WHERE department_id IN (10,20,30,40)
GROUP BY department_id
HAVING MAX(salary) > 10000;
/*
#sql92语法：
SELECT ....,....,....(存在聚合函数)
FROM ...,....,....
WHERE 多表的连接条件 AND 不包含聚合函数的过滤条件
GROUP BY ...,....
HAVING 包含聚合函数的过滤条件
ORDER BY ....,...(ASC / DESC )
LIMIT ...,....


#sql99语法：
SELECT ....,....,....(存在聚合函数)
FROM ... (LEFT / RIGHT)JOIN ....ON 多表的连接条件 
(LEFT / RIGHT)JOIN ... ON ....
WHERE 不包含聚合函数的过滤条件
GROUP BY ...,....
HAVING 包含聚合函数的过滤条件
ORDER BY ....,...(ASC / DESC )
LIMIT ...,....


#4.2 SQL语句的执行过程：
#FROM ...,...-> ON -> (LEFT/RIGNT  JOIN) -> WHERE -> GROUP BY -> HAVING -> SELECT -> DISTINCT -> 
# ORDER BY -> LIMIT
*/

#1. 查询公司员工工资的最大值，最小值，平均值，总和
SELECT MAX(salary), MIN(salary),AVG(salary),SUM(salary)
from employees

#2. 查询各job_id员工的工资最大值，最小值，平均值，总和
SELECT job_id,MAX(salary), MIN(salary),AVG(salary),SUM(salary)
from employees
GROUP BY job_id

#3. 选择具有各个job_id的员工人数
SELECT COUNT(1), job_id
FROM employees
GROUP BY job_id 

#4. 查询员工最高工资和最低工资的差距
SELECT MAX(salary) - MIN(salary) "diff"
FROM employees

#5.查询各个管理者手下员工的最低工资，其中最低工资不能低于6000，没有管理者的员工不算
SELECT manager_id, MAX(salary), MIN(salary) "min"
FROM employees
WHERE manager_id is NOT NULL
GROUP BY manager_id
HAVING min >= 6000

#6. 查询所有部门的名字，location_id,员工数量和平均值，并按平均工资降序
SELECT departments.department_name, departments.location_id, COUNT(1), AVG(IFNULL(salary,0)) "avg salary"
FROM employees RIGHT JOIN departments
ON employees.department_id = departments.department_id
GROUP BY departments.department_name, departments.location_id
ORDER BY "avg salary" desc

#7. 查询每个工种，每个部门的部门名，工种名，最低工资

SELECT employees.job_id,  departments.department_name, MIN(salary)
FROM employees RIGHT JOIN departments
ON employees.department_id = departments.department_id
GROUP BY employees.job_id,  departments.department_name

#！！！子查询
#练习，谁的工资比abel高
#普通方式
SELECT salary 
FROM employees
WHERE last_name = 'Abel' #11000

select last_name,salary
FROM employees
WHERE salary > 11000

#自联结方式
SELECT t2.salary,t2.last_name
FROM employees t1, employees t2
WHERE t1.last_name = 'Abel'
AND t2.salary > t1.salary

#子查询方式,把前置条件单独查询一次，把两个查询合并，减少IO次数
select last_name,salary
FROM employees
WHERE salary > (
								SELECT salary 
								FROM employees
								WHERE last_name = 'Abel'
								)

#题目：查询工资大于149号员工工资的员工的信息
select last_name,salary
FROM employees
WHERE salary > (
								SELECT salary 
								FROM employees
								WHERE employee_id = 149
								)
#题目：返回job_id与141号员工相同，salary比143号员工多的员工姓名，job_id和工资
SELECT job_id, last_name, salary
FROM employees
WHERE salary > (
								SELECT salary
								FROM employees
								WHERE employee_id = 143
								)
AND job_id = (
							SELECT job_id
							FROM employees
							WHERE employee_id = 141
							)
#题目：返回公司工资最少的员工的last_name,job_id和salary
SELECT last_name,job_id,salary
FROM employees
WHERE salary = (
								SELECT MIN(salary)
								FROM employees
								)
#题目：查询与141号员工的manager_id和department_id相同的其他员工
#的employee_id，manager_id，department_id。
SELECT employees.employee_id, employees.manager_id, employees.department_id,departments.department_name,last_name
FROM employees JOIN departments
ON employees.department_id = departments.department_id
WHERE employees.manager_id IN (
										SELECT manager_id
										FROM employees
										WHERE employee_id IN (141, 174)
										)
AND employees.department_id IN (
										SELECT department_id
										FROM employees
										WHERE employee_id IN (141, 174)
										)
AND NOT employees.employee_id IN (141, 174)


#题目：查询最低工资大于110号部门最低工资的部门id和其最低工资
SELECT department_id, MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (
									SELECT MIN(salary)
									FROM employees
									WHERE department_id = 110
									)
									

#题目：显式员工的employee_id,last_name和location。
#其中，若员工department_id与location_id为1800的department_id相同，
#则location为’Canada’，其余则为’USA’。
SELECT employee_id,last_name, department_id,case department_id
															WHEN  (
															SELECT department_id
															FROM departments
															WHERE location_id = 1800
															) THEN
																'Canada'
															ELSE
																'USA'
															END "location"
FROM employees

# ANY / ALL:
#题目：返回其它job_id中比job_id为‘IT_PROG’部门**任一**工资低的员工的员工号、
#姓名、job_id 以及salary
SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE salary < ANY (
										SELECT salary
										FROM employees
										WHERE job_id = 'IT_PROG'
										)
AND job_id != 'IT_PROG'
#题目：返回其它job_id中比job_id为‘IT_PROG’部门**所有**工资低的员工的员工号、
#姓名、job_id 以及salary
SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE salary < ALL (
										SELECT salary
										FROM employees
										WHERE job_id = 'IT_PROG'
										)
AND job_id != 'IT_PROG'

#题目：查询平均工资最低的部门id,这个要品一品
#如何查最低平均工资是多少
SELECT MIN(avg_salary)
FROM (#这里把这个结果当成一张新表来看待
			SELECT department_id, AVG(salary) "avg_salary"#这里是列的别名
			FROM employees
			GROUP BY department_id
			) t_avg_salary #这里是给这个表起个别名

#通过最低平均工资查部门ID
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) = (
											SELECT MIN(avg_salary)
											FROM (#这里把这个结果当成一张新表来看待
											SELECT department_id, AVG(salary) "avg_salary"#这里是列的别名
											FROM employees
											GROUP BY department_id
											) t_avg_salary #这里是给这个表起个别名
											)
#方式2：
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) <= ALL(#AVG(salary)本身就属于集合中的一员
			SELECT AVG(salary) avg_sal
			FROM employees
			GROUP BY department_id
			) 

#回顾：查询员工中工资大于公司平均工资的员工的last_name,salary和其department_id
SELECT last_name, salary, department_id
FROM employees
WHERE salary > (
								SELECT AVG(salary)
								FROM employees
								)
ORDER BY salary DESC

#题目：查询员工中工资大于本部门平均工资的员工的last_name,salary和其department_id
SELECT last_name,salary,department_id
FROM employees e1
WHERE salary > (
								SELECT AVG(salary)
								FROM employees e2
								WHERE department_id = e1.department_id
								);
