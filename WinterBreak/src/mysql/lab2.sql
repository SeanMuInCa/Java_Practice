#1. Create a procedure that shows the overall grade of a student that is #passed through to the procedure as a parameter. The graded items are #weighed, meaning that some items are worth more of the final grade than #others. You will need to multiple the grade of an item by the weight
#of the item and then sum all the items to get the student’s final grade.

DELIMITER $
CREATE PROCEDURE get_score(IN student_name VARCHAR(255))
BEGIN
	SELECT student, ROUND(SUM(mark * weight),2) AS "final score"
	FROM student_mark 
	WHERE student = student_name
	GROUP BY student;
END $
DELIMITER ;

CALL get_score('Yarona');

#2. Create a view that shows all the students’ overall grades.

CREATE VIEW overall_scores AS
SELECT student,
			 ROUND(SUM(mark * weight),2) AS "final score"
FROM student_mark 
GROUP BY student

SELECT * FROM overall_scores;

#3. Join the view created above to the student_mark table so the resulting 
#query shows the students name, the assignment, their mark on the #assignment, and their final grade.

SELECT  s.*, o.`final score`
FROM overall_scores AS o
JOIN student_mark AS s
ON o.student = s.student
GROUP BY s.student


#4. The current table is not normalized and the structure limits what we 
#can do. For example, it would be difficult to create a report with all 
#the student information on one line. Begin the process of normalizing 
#this table by creating a student table that assigns ids to the students.
#Then create a procedure that adds the students in the student_mark table 
#to the student table.

#create a table for students
CREATE TABLE students(
		student_id INT AUTO_INCREMENT,
    student_name VARCHAR(255) NOT NULL,
    PRIMARY KEY(student_id)
);

ALTER TABLE student_mark ADD student_id INT;
ALTER TABLE student_mark ADD FOREIGN KEY(student_id) REFERENCES students(student_id);

DROP PROCEDURE IF EXISTS add_student;
DELIMITER $
CREATE PROCEDURE add_student()
BEGIN
 -- variable to hold student
 DECLARE student_name VARCHAR(255); 

 -- variable to track loop is done
 DECLARE done INT DEFAULT FALSE;
 
 -- create cursor
 DECLARE student_cursor CURSOR FOR 
	SELECT DISTINCT student FROM student_mark;
 
 -- handler for cursor. tracks if records finished
 DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
 
 -- open the cursor
 OPEN student_cursor;
 
 -- create loop
 our_loop: LOOP
 
	 -- add the cursor info into A VARIABLE
	 FETCH student_cursor INTO student_name;
     
     -- true condition, records done
     IF done THEN 
		LEAVE our_loop;
	ELSE 
		-- add info to table
		INSERT INTO students(student_name) VALUES (student_name); 
        END IF;
	-- end loop
	END LOOP;
    
    -- close the cursor
    CLOSE student_cursor;
END $
DELIMITER ;

CALL add_student();