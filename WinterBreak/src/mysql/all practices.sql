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
#每次都会把一个employee放到子查询里，去查询一下他的部门ID，并且得到部门的平均工资，再返回来
#查询这个人工资是否大于平均工资，因此是相关性子查询
#方式1
SELECT last_name,salary,department_id
FROM employees e1
WHERE salary > (
								SELECT AVG(salary)
								FROM employees e2
								WHERE e2.department_id = e1.department_id
								);
#方式2

#拆解式写法
#1. 先查询各个部门平均工资
SELECT department_id, AVG(salary)
FROM employees
GROUP BY department_id
#2.把这个结果当成一个表来进行下一步查询
FROM (
			SELECT department_id, AVG(salary)
			FROM employees
			GROUP BY department_id
			) t_avg_salary #别名
#3.加上其他限制条件
SELECT last_name,salary,e1.department_id
FROM employees e1,(
									SELECT department_id, AVG(salary) "avg_salary"#必须要起个别名
									FROM employees
									GROUP BY department_id
									) t_avg_salary #别名
WHERE e1.department_id = t_avg_salary.department_id
AND e1.salary > t_avg_salary.avg_salary

#题目：查询员工的id,salary,按照department_name 排序
SELECT employee_id, salary, department_name
FROM employees JOIN departments
WHERE employees.department_id = departments.department_id
ORDER BY departments.department_name DESC

SELECT employee_id, salary
FROM employees e1
ORDER BY (
					SELECT department_name
					FROM departments dep
					WHERE e1.department_id = dep.department_id
					) DESC
					
#题目：若employees表中employee_id与job_history表中employee_id相同的数目不小于2，
#输出这些相同id的员工的employee_id,last_name和其job_id

SELECT employee_id, last_name,job_id
FROM employees e
WHERE 2<= (
					SELECT COUNT(1)
					FROM job_history j
					WHERE e.employee_id = j.employee_id
					)
#6.2 EXISTS 与 NOT EXISTS关键字
#题目：查询公司管理者的employee_id，last_name，job_id，department_id信息
#方式1，自连接
SELECT DISTINCT e2.employee_id,e2.last_name,e2.job_id,e2.department_id
FROM employees e1, employees e2
WHERE e1.manager_id = e2.employee_id

#方式2，子查询
SELECT employee_id,last_name,job_id,department_id
FROM employees
WHERE employee_id IN (
										SELECT DISTINCT manager_id
										FROM employees
										)
#方式3，EXISTS
SELECT employee_id,last_name,job_id,department_id
FROM employees t1
WHERE EXISTS ( #查到就返回true，查不到就继续，因此不需要去重
							SELECT *
							FROM employees t2
							WHERE t1.employee_id = t2.manager_id
							)

#题目：查询departments表中，不存在于employees表中的部门的department_id和department_name
#方式1
SELECT d.department_id,d.department_name
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`
WHERE e.`department_id` IS NULL;

#方式2 NOT EXISTS
SELECT department_id, department_name
FROM departments d
WHERE NOT EXISTS (
									SELECT * FROM employees e
									WHERE d.department_id = e.department_id
									)

#1. 查询和Zlotkey相同部门的员工姓名和工资
SELECT last_name,salary
FROM employees
WHERE department_id = (
											SELECT department_id
											FROM employees
											WHERE last_name = 'Zlotkey'
											)
											
#2. 查询工资比公司平均工资高的员工的员工号，姓名和工资。
SELECT employee_id,last_name,salary
FROM employees
WHERE salary > (
								SELECT AVG(salary)
								FROM employees
								)

#3. 选择工资大于所有JOB_ID = 'SA_MAN' 的员工的工资的员工的last_name, job_id, salary
SELECT last_name,job_id,salary
FROM employees t1
WHERE salary > ALL (
								SELECT salary
								FROM employees t2
								WHERE job_id = 'SA_MAN'
								)

#4. 查询和姓名中包含字母u的员工在相同部门的员工的员工号和姓名
SELECT employee_id,last_name
FROM employees
WHERE department_id IN (
												SELECT DISTINCT department_id
												FROM employees
												WHERE last_name LIKE '%u%'
												)

#5. 查询在部门的location_id为1700的部门工作的员工的员工号
#方式1
SELECT last_name, employee_id,employees.department_id
FROM employees JOIN departments
ON employees.department_id = departments.department_id
WHERE departments.location_id = 1700
#方式2
SELECT employee_id
FROM employees
WHERE department_id IN (
												SELECT department_id
												FROM departments
												WHERE location_id = 1700
												)

#6. 查询管理者是King的员工姓名和工资
SELECT last_name,salary
FROM employees
WHERE manager_id IN (
										SELECT employee_id
										FROM employees
										WHERE last_name = 'King'
										)

#7. 查询工资最低的员工信息 (last_name, salary)
SELECT last_name,salary
FROM employees
WHERE salary = (
								SELECT MIN(salary)
								FROM employees
								)
								
#8. 查询平均工资最低的部门信息
#方式1第一步
SELECT department_id,AVG(salary)
FROM employees
GROUP BY department_id
HAVING AVG(salary) <= ALL(
													SELECT AVG(salary)
													FROM employees
													GROUP BY department_id 
													)
#第二步													
SELECT * 
FROM departments
WHERE department_id = (
											SELECT department_id
											FROM employees
											GROUP BY department_id
											HAVING AVG(salary) <= ALL(
																								SELECT AVG(salary)
																								FROM employees
																								GROUP BY department_id 
																								)
											)
#方式2换个思路,把查询结果当做表来处理
SELECT MIN(avg_salary)
FROM (
			SELECT AVG(salary) "avg_salary"
			FROM employees
			GROUP BY department_id
			) t_avg_salary
#接下来，再查他
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) = (
											SELECT MIN(avg_salary)
											FROM (
														SELECT AVG(salary) "avg_salary"
														FROM employees
														GROUP BY department_id
														) t_avg_salary
											)
#最后再
SELECT * 
FROM departments
WHERE department_id =(
											SELECT department_id
											FROM employees
											GROUP BY department_id
											HAVING AVG(salary) = (
																						SELECT MIN(avg_salary)
																						FROM (
																									SELECT AVG(salary) "avg_salary"
																									FROM employees
																									GROUP BY department_id
																									) t_avg_salary
																						)
											)


#9. 查询平均工资最低的部门信息和该部门的平均工资 (相关子查询)
SELECT employees.department_id, departments. *,AVG(salary) "avg_salary"
FROM employees JOIN departments
ON employees.department_id = departments.department_id
GROUP BY employees.department_id
ORDER BY avg_salary
LIMIT 0,1


#10. 查询平均工资最高的job信息
SELECT job_id,AVG(salary)
FROM employees
GROUP BY job_id
HAVING AVG(salary) >= ALL(
													SELECT AVG(salary)
													FROM employees
													GROUP BY job_id 
													)

#11. 查询平均工资高于公司平均工资的部门有哪些？
SELECT department_id
FROM employees
WHERE department_id is not null #忽略了这个
GROUP BY department_id
HAVING AVG(salary) > (
											SELECT AVG(salary)
											FROM employees
											)
											
#12. 查询出公司中所有manager的详细信息
SELECT * 
FROM employees
WHERE employee_id IN (
											SELECT DISTINCT manager_id
											FROM employees
											)
											
#13. 各个部门中，最高工资中最低的那个部门的最低工资是多少？
SELECT MIN(salary)
FROM employees e
WHERE department_id = (
											SELECT e1.department_id
											FROM employees e1
											GROUP BY e1.department_id
											ORDER BY MAX(salary) 
											LIMIT 0,1
											)

#14. 查询平均工资最高的部门的manager的详细信息：last_name, department_id, email, salary
SELECT last_name,department_id,email,salary
FROM employees
WHERE employee_id = (
										SELECT manager_id
										FROM departments
										WHERE department_id = (
																					SELECT department_id
																					FROM employees
																					GROUP BY department_id
																					ORDER BY MAX(salary) DESC
																					LIMIT 0,1
																					)

										)
										
#15. 查询部门的部门号，其中不包括job_id是"ST_CLERK"的部门号
SELECT DISTINCT department_id
FROM departments
WHERE department_id NOT IN (
								SELECT DISTINCT department_id
								FROM employees
								WHERE job_id = 'ST_CLERK'
								)
								
#16. 选择所有没有管理者的员工的last_name
SELECT last_name
FROM employees
WHERE manager_id is NULL

#17. 查询员工号、姓名、雇用时间、工资，其中员工的管理者为 ‘De Haan'
SELECT employee_id, last_name,hire_date,salary,manager_id
FROM employees
WHERE manager_id IN (
										SELECT employee_id
										FROM employees
										WHERE last_name = 'De Haan'
										)
										
#18. 查询各部门中工资比本部门平均工资高的员工的员工号，姓名和工资（相关子查询）
SELECT employee_id,last_name,salary
FROM employees t1
WHERE salary > (
								SELECT AVG(salary)
								FROM employees t2
								WHERE t1.department_id = t2.department_id
								)
								
#19. 查询每个部门下的部门人数大于5的部门名称（相关子查询）
SELECT department_name
FROM departments
WHERE department_id IN (
												SELECT DISTINCT department_id
												FROM employees t1
												WHERE 5 < (
																	SELECT count(1)
																	FROM employees t2
																	WHERE t1.department_id = t2.department_id
																	)
												)

SELECT department_name
FROM departments t1
WHERE  5 < (
						SELECT count(1)
						FROM employees t2
						WHERE t1.department_id = t2.department_id
						)
												

#20. 查询每个国家下的部门个数大于2的国家编号（相关子查询）
SELECT country_id
FROM locations t1
WHERE  2 < (
						SELECT count(1)
						FROM departments t2
						WHERE t1.location_id = t2.location_id
						)

#CREATE DATABASE if NOT EXISTS my_db_test
use my_db_test
#练习1：创建一个表employees_copy，实现对employees表的复制，包括表数据
CREATE TABLE IF NOT EXISTS employees_copy 
AS
SELECT * FROM employees

#练习2：创建一个表employees_blank，实现对employees表的复制，不包括表数据
CREATE TABLE IF NOT EXISTS employees_blank
AS
SELECT *
FROM employees
WHERE 1=2 #创造一个不存在的条件，就可以

#方式1："白手起家"的方式
CREATE TABLE IF NOT EXISTS myemp1(   #需要用户具备创建表的权限。
id INT,
emp_name VARCHAR(15), #使用VARCHAR来定义字符串，必须在使用VARCHAR时指明其长度。
hire_date DATE
);
#查看表结构
DESC myemp1;
#查看创建表的语句结构
SHOW CREATE TABLE myemp1; #如果创建表时没有指明使用的字符集，则默认使用表所在的数据库的字符集。
#查看表数据
SELECT * FROM myemp1;

#方式2：基于现有的表，同时导入数据
CREATE TABLE myemp2
AS
SELECT employee_id,last_name,salary
FROM employees;

DESC myemp2;
DESC employees;

SELECT *
FROM myemp2;

#说明1：查询语句中字段的别名，可以作为新创建的表的字段的名称。
#说明2：此时的查询语句可以结构比较丰富，使用前面章节讲过的各种SELECT

# 第10章_创建和管理表的课后练习

#练习1：
#1. 创建数据库test01_office,指明字符集为utf8。并在此数据库下执行下述操作
CREATE DATABASE IF NOT EXISTS test01_office CHARACTER SET 'utf8'
USE test01_office
#2.	创建表dept01
/*
字段      类型
id	 INT(7)
NAME	 VARCHAR(25)
*/
CREATE TABLE IF NOT EXISTS dept01
(
id INT(7),
`name` VARCHAR(25)
)
desc dept02
#3.将表departments中的数据插入新表dept02中
CREATE TABLE dept02
AS
SELECT * FROM atguigudb.departments

#4.	创建表emp01
/*
字段            类型
id		INT(7)
first_name	VARCHAR (25)
last_name	VARCHAR(25)
dept_id		INT(7)
*/
CREATE TABLE IF NOT EXISTS emp01
(
id INT(7),
first_name VARCHAR(25),
last_name VARCHAR(25),
dept_id INT(7)
)

#5.将列last_name的长度增加到50
ALTER TABLE emp01
MODIFY last_name VARCHAR(50)

#6.根据表employees创建emp02
CREATE TABLE IF NOT EXISTS emp02
AS
SELECT * FROM atguigudb.employees

#7.删除表emp01
DROP TABLE emp01

#8.将表emp02重命名为emp01

RENAME TABLE emp02 TO emp01

#9.在表dept02和emp01中添加新列test_column，并检查所作的操作
ALTER TABLE dept02
ADD test_column VARCHAR(10)
SELECT * FROM emp01
ALTER TABLE emp01
ADD test_column VARCHAR(10)

#10.直接删除表emp01中的列 department_id
ALTER TABLE emp01
DROP COLUMN department_id;

#练习2：
# 1、创建数据库 test02_market

CREATE DATABASE IF NOT EXISTS test02_market CHARACTER SET 'utf8';

USE test02_market;

SHOW CREATE DATABASE test02_market;

# 2、创建数据表 customers
CREATE TABLE IF NOT EXISTS customers(
c_num INT,
c_name VARCHAR(50),
c_contact VARCHAR(50),
c_city VARCHAR(50),
c_birth DATE
);

SHOW TABLES;

# 3、将 c_contact 字段移动到 c_birth 字段后面
DESC customers;

ALTER TABLE customers
MODIFY c_contact VARCHAR(50) AFTER c_birth;

# 4、将 c_name 字段数据类型改为 varchar(70)
ALTER TABLE customers
MODIFY c_name VARCHAR(70) ;

# 5、将c_contact字段改名为c_phone
ALTER TABLE customers 
CHANGE c_contact c_phone VARCHAR(50);

# 6、增加c_gender字段到c_name后面，数据类型为char(1)
ALTER TABLE customers
ADD c_gender CHAR(1) AFTER c_name;

# 7、将表名改为customers_info
RENAME TABLE customers
TO customers_info;

DESC customers_info;

# 8、删除字段c_city
ALTER TABLE customers_info
DROP COLUMN c_city;

#练习3：
# 1、创建数据库test03_company
CREATE DATABASE IF NOT EXISTS test03_company CHARACTER SET 'utf8';

USE test03_company;

# 2、创建表offices
CREATE TABLE IF NOT EXISTS offices(
officeCode INT,
city VARCHAR(30),
address VARCHAR(50),
country VARCHAR(50),
postalCode VARCHAR(25)
);

DESC offices;

# 3、创建表employees
CREATE TABLE IF NOT EXISTS employees(
empNum INT,
lastName VARCHAR(50),
firstName VARCHAR(50),
mobile VARCHAR(25),
`code` INT,
jobTitle VARCHAR(50),
birth DATE,
note VARCHAR(255),
sex VARCHAR(5)

);

DESC employees;

# 4、将表employees的mobile字段修改到code字段后面
ALTER TABLE employees
MODIFY mobile VARCHAR(20) AFTER `code`;

# 5、将表employees的birth字段改名为birthday
ALTER TABLE employees
CHANGE birth birthday DATE;

# 6、修改sex字段，数据类型为char(1)
ALTER TABLE employees
MODIFY sex CHAR(1);

# 7、删除字段note
ALTER TABLE employees
DROP COLUMN note;

# 8、增加字段名favoriate_activity，数据类型为varchar(100)
ALTER TABLE employees
ADD favoriate_activity VARCHAR(100);

# 9、将表employees的名称修改为 employees_info
RENAME TABLE employees TO employees_info;

DESC employees_info;

#添加数据
/*
INSERT语句可以同时向数据表中插入多条记录，插入时指定多个值列表，每个值列表之间用逗号分隔 开，基本语法格式如下：

```mysql
INSERT INTO table_name
VALUES
(value1 [,value2, …, valuen]),
(value1 [,value2, …, valuen]),
……
(value1 [,value2, …, valuen]);
```

或者

```mysql
INSERT INTO table_name(column1 [, column2, …, columnn])
VALUES
(value1 [,value2, …, valuen]),
(value1 [,value2, …, valuen]),
……
(value1 [,value2, …, valuen]);
```

使用INSERT同时插入多条记录时，MySQL会返回一些在执行单行插入时没有的额外信息，这些信息的含 义如下：

* Records：表明插入的记录条数。 
* Duplicates：表明插入时被忽略的记录，原因可能是这 些记录包含了重复的主键值。 
* Warnings：表明有问题的数据值，例如发生数据类型转换。
*/

#更新数据
/*
UPDATE table_name
SET column1=value1, column2=value2, ..., column=valuen
[WHERE condition]
*/

#题目：将表中姓名中包含字符a的提薪20%
UPDATE emp1
SET salary = salary * 1.2
WHERE NAME LIKE '%a%';
#删除数据
# DELETE FROM table_name [WHERE <condition>];

#练习3：

#1. 创建数据库test04_company
CREATE DATABASE IF NOT EXISTS test04_company

USE test04_company

#2. 按照下表给出的表结构在test04_company数据库中创建两个数据表offices和employees
CREATE TABLE IF NOT EXISTS offices2(
officeCode INT(10) PRIMARY KEY ,
city VARCHAR(50) NOT NULL,
address VARCHAR(50) ,
country VARCHAR(50) NOT NULL
);

DESC offices;

CREATE TABLE employees(
employeeNumber INT PRIMARY KEY AUTO_INCREMENT,
lastName VARCHAR(50) NOT NULL,
firstName VARCHAR(50) NOT NULL,
mobile VARCHAR(25) UNIQUE,
officeCode INT(10) NOT NULL ,
jobTitle VARCHAR(50) NOT NULL,
birth DATETIME NOT NULL,
note VARCHAR(255),
sex VARCHAR(5),
CONSTRAINT FOREIGN KEY (officeCode) REFERENCES offices(officeCode)
)



#3. 将表employees的mobile字段修改到officeCode字段后面
ALTER TABLE employees
MODIFY  mobile VARCHAR(25) AFTER officeCode

#4. 将表employees的birth字段改名为employee_birth
ALTER TABLE employees
CHANGE birth employee_birth DATETIME 

#5. 修改sex字段，数据类型为CHAR(1)，非空约束
ALTER TABLE employees
MODIFY sex VARCHAR(1) NOT NULL

#6. 删除字段note
ALTER TABLE employees
DROP COLUMN note

#7. 增加字段名favoriate_activity，数据类型为VARCHAR(100)
ALTER TABLE employees
ADD favoriate_activity VARCHAR(100)

#8. 将表employees名称修改为employees_info
RENAME TABLE employees TO employees_info

desc employees_info

/*
1. 视图的理解

① 视图，可以看做是一个虚拟表，本身是不存储数据的。
  视图的本质，***就可以看做是存储起来的SELECT语句***
  
② 视图中SELECT语句中涉及到的表，称为基表

③ 针对视图做DML操作，会影响到对应的基表中的数据。反之亦然。

④ 视图本身的删除，不会导致基表中数据的删除。

⑤ 视图的应用场景：针对于小型项目，不推荐使用视图。针对于大型项目，可以考虑使用视图。

⑥ 视图的优点：简化查询; 控制数据的访问


*/

use atguigudb

create VIEW view_employee
AS
SELECT employee_id, last_name,salary
from employees

SELECT * FROM view_employee

#第15章_存储过程与存储函数

#0.准备工作

CREATE DATABASE dbtest15;

USE dbtest15;

CREATE TABLE employees
AS
SELECT * 
FROM atguigudb.`employees`;

CREATE TABLE departments
AS
SELECT * FROM atguigudb.`departments`;

SELECT * FROM employees;

SELECT * FROM departments;
#1. 创建存储过程

#类型1：无参数无返回值

#举例1：创建存储过程select_all_data()，查看 employees 表的所有数据
DELIMITER $
CREATE PROCEDURE select_all_data()
BEGIN
SELECT * from employees;
END
DELIMITER ;
#调用
CALL select_all_data();

#举例3：创建存储过程show_max_salary()，用来查看“emps”表的最高薪资值。

CREATE PROCEDURE show_max_salary()
BEGIN
SELECT MAX(salary) from employees;
END

call show_max_salary()

#类型2：带 OUT
#举例4：创建存储过程show_min_salary()，查看“emps”表的最低薪资值。并将最低薪资
#通过OUT参数“ms”输出
desc employees

CREATE PROCEDURE show_min_salary(OUT ms DOUBLE)
BEGIN
	SELECT MIN(salary) INTO ms
	FROM employees; 
END

call show_min_salary(@ms)#定义变量

#查看变量
SELECT @ms

#类型3：带 IN
#举例5：创建存储过程show_someone_salary()，查看“emps”表的某个员工的薪资，
#并用IN参数empname输入员工姓名。

CREATE PROCEDURE show_someone_salary(IN emp_name VARCHAR(20))
BEGIN
	SELECT salary from employees
	WHERE last_name = emp_name;
END

#调用方式1
CALL show_someone_salary('Abel');
#调用方式2
SET @emp_name := 'Abel';
CALL show_someone_salary(@emp_name);

#类型4：带 IN 和 OUT
#举例6：创建存储过程show_someone_salary2()，查看“emps”表的某个员工的薪资，
#并用IN参数empname输入员工姓名，用OUT参数empsalary输出员工薪资。
desc employees
CREATE PROCEDURE show_someone_salary4(IN empname VARCHAR(20), OUT empsalary DOUBLE(8,2))
BEGIN
	SELECT salary INTO empsalary
	FROM employees
	WHERE last_name = empname;
END

#调用
SET @empname = 'Abel';
CALL show_someone_salary4(@empname,@empsalary);
 
SELECT @empsalary;

#类型5：带 INOUT
#举例7：创建存储过程show_mgr_name()，查询某个员工领导的姓名，并用INOUT参数“empname”输入员工姓名，
#输出领导的姓名。


CREATE PROCEDURE show_mgr_name(INOUT empname VARCHAR(25))
BEGIN
	SELECT last_name
	FROM employees
	WHERE employee_id = (
											SELECT manager_id 
											FROM employees
											WHERE last_name = empname
											);
END

#调用
SET @empname = 'Ernst';
CALL show_mgr_name(@empname);


SELECT * from employees

#2.存储函数

# 举例1：创建存储函数，名称为email_by_name()，参数定义为空，
#该函数查询Abel的email，并返回，数据类型为字符串型。

CREATE FUNCTION email_by_name()
RETURNS VARCHAR(25)
	DETERMINISTIC
	CONTAINS SQL
	READS SQL DATA
BEGIN
	RETURN(
				SELECT email FROM employees
				WHERE last_name = 'Abel'
				);
END

#调用
SELECT email_by_name()

#举例2：创建存储函数，名称为email_by_id()，参数传入emp_id，该函数查询emp_id的email，
#并返回，数据类型为字符串型。
CREATE FUNCTION email_by_id(emp_id INT)
RETURNS VARCHAR(25)
	DETERMINISTIC
	CONTAINS SQL
	READS SQL DATA
BEGIN
	RETURN(
				SELECT email FROM employees
				WHERE employee_id = emp_id
				);
END

#调用
SELECT email_by_id(102)


#举例3：创建存储函数count_by_id()，参数传入dept_id，该函数查询dept_id部门的
#员工人数，并返回，数据类型为整型。
CREATE FUNCTION count_by_id(dept_id INT)
RETURNS INT
	DETERMINISTIC
	CONTAINS SQL
	READS SQL DATA
BEGIN
	RETURN(
				SELECT count(1) FROM employees
				WHERE department_id = dept_id
				);
END

#调用
SET @dept_id = 50
SELECT count_by_id(@dept_id)

#3. 存储过程、存储函数的查看

#方式1. 使用SHOW CREATE语句查看存储过程和函数的创建信息

SHOW CREATE PROCEDURE show_mgr_name;

SHOW CREATE FUNCTION count_by_id;

#方式2. 使用SHOW STATUS语句查看存储过程和函数的状态信息

SHOW PROCEDURE STATUS;

SHOW PROCEDURE STATUS LIKE 'show_max_salary';

SHOW FUNCTION STATUS LIKE 'email_by_id';

#1. 创建存储过程insert_user(),实现传入用户名和密码，插入到admin表中
CREATE TABLE admin(
id INT PRIMARY KEY AUTO_INCREMENT,
user_name VARCHAR(15) NOT NULL,
pwd VARCHAR(25) NOT NULL

);

CREATE PROCEDURE insert_user(IN u_name VARCHAR(15), IN u_pwd VARCHAR(15))
BEGIN
	INSERT INTO admin(user_name,pwd)
	VALUES(u_name,u_pwd);
END

CALL insert_user("abc","123")

#2. 创建存储过程get_phone(),实现传入女神编号，返回女神姓名和女神电话
CREATE TABLE beauty(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(15) NOT NULL,
phone VARCHAR(15) UNIQUE,
birth DATE
);

INSERT INTO beauty(NAME,phone,birth)
VALUES
('朱茵','13201233453','1982-02-12'),
('孙燕姿','13501233653','1980-12-09'),
('田馥甄','13651238755','1983-08-21'),
('邓紫棋','17843283452','1991-11-12'),
('刘若英','18635575464','1989-05-18'),
('杨超越','13761238755','1994-05-11');


SELECT * FROM beauty;

CREATE PROCEDURE get_phone(IN b_id INT, OUT b_name VARCHAR(15), OUT b_phone VARCHAR(15))
BEGIN
	SELECT `name`, phone INTO b_name, b_phone
	FROM beauty
	WHERE id = b_id;
END

CALL get_phone(1,@n,@p);
SELECT @n,@p;

#3. 创建存储过程date_diff()，实现传入两个女神生日，返回日期间隔大小

CREATE PROCEDURE date_diff(IN date1 DATE, IN date2 DATE, OUT diff INT)
BEGIN
	SELECT DATEDIFF(date1, date2) INTO diff;
END

CALL date_diff('2002,11,8','2001,10,9',@d);
SELECT @d;

#4. 创建存储过程format_date(),实现传入一个日期，格式化成xx年xx月xx日并返回

CREATE PROCEDURE format_date(IN d DATE, OUT fd VARCHAR(20))
BEGIN
	SELECT DATE_FORMAT(d,'%y年%m月%d日') INTO fd;
END

CALL format_date(NOW(),@d);
SELECT @d;

#5. 创建存储过程beauty_limit()，根据传入的起始索引和条目数，查询女神表的记录

CREATE PROCEDURE beauty_limit(IN s INT, IN num INT)
BEGIN
	SELECT * FROM beauty LIMIT s, num;
END

CALL beauty_limit(1,3);

#创建带inout模式参数的存储过程
#6. 传入a和b两个值，最终a和b都翻倍并返回
CREATE PROCEDURE dvalue(INOUT a INT, INOUT b INT)
BEGIN
	SET a = a * 2;
	SET b = b * 2;
END

SET @a = 3,@b = 5;
CALL dvalue(@a,@b);

SELECT @a,@b;

#7. 删除题目5的存储过程

DROP PROCEDURE IF EXISTS beauty_limit;

#8. 查看题目6中存储过程的信息

SHOW CREATE PROCEDURE dvalue;

#无参有返回
#1. 创建函数get_count(),返回公司的员工个数

CREATE FUNCTION get_count()
RETURNS INT
BEGIN
	RETURN (SELECT count(1) FROM employees);
END

SELECT get_count();

#有参有返回
#2. 创建函数ename_salary(),根据员工姓名，返回它的工资

CREATE FUNCTION ename_salary_name(e_name VARCHAR(20))
RETURNS DOUBLE
BEGIN
	RETURN (SELECT salary from employees WHERE last_name = e_name);
END

SELECT ename_salary_name('Abel');

#3. 创建函数dept_sal() ,根据部门名，返回该部门的平均工资
CREATE FUNCTION dept_sal(d_name VARCHAR(20))
RETURNS DOUBLE
BEGIN
	RETURN (SELECT avg(salary) from employees
									GROUP BY employees.department_id
									HAVING department_id = (
																				SELECT department_id from departments
																				WHERE department_name = d_name
																				));
# RETURN( SELECT avg(salary) 
					#from employees e join departments d
					#on e.department_id = d.department_id
					#WHERE d.department_name = d_name
															#);
END

SELECT dept_sal('Marketing')

#4. 创建函数add_float()，实现传入两个float，返回二者之和

CREATE FUNCTION add_float(a FLOAT, b FLOAT)
RETURNS FLOAT
BEGIN
	RETURN(SELECT a + b);
END

set @a = 1, @b = 3;
SELECT add_float(2,5);
