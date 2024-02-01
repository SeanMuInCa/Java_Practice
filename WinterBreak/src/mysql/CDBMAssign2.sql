# 1. Select the names of all customers who are located in Montréal. Use a   #wildcard for the‘é’.
SELECT customer_name, contact_name 
FROM customer
WHERE city LIKE "Montr_al" 
	AND country = 'Canada';


#2. Select the product names and unit prices of all products that have a unit price greater than $20.

SELECT product_name, price
FROM product
WHERE price > 20;


#3. Create a query to determine the number of orders each year. Note: the function YEAR() will return the year of a date.

SELECT YEAR(order_date), COUNT(*) FROM customer_order
GROUP BY YEAR(order_date);

#4. Create an alphabetical list of all the products and their categories. List the categories alphabetically and then products in each category alphabetically.

SELECT c.category_name,p.product_name
FROM product p
JOIN category c ON p.category_id = c.category_id
ORDER BY c.category_name ASC, p.product_name ASC;


#5. Determine which products that have been ordered by more than 10 unique customers.

SELECT o.product_id,c.customer_id  FROM customer_order c
JOIN order_detail o on c.order_id = o.order_id
GROUP BY o.product_id




#6. For each order, calculate the subtotal. Include the order_id, date_ordered, and subtotal (calculated field). Order the list by the subtotal highest to lowest and only show the top 20 results.


SELECT c.order_id,c.order_date,(quantity * price) subtotal
FROM order_detail o JOIN product p ON o.product_id = p.product_id
										JOIN customer_order c ON c.order_id = o.order_id



#7. Select the names of all employees and their total dollar amount of sales (customer orders) they have placed. Order by the highest sales.

#8. Select the names of all products that have been ordered at least once. You must use a subquery for this question.

#9. Select all the customer information and create a calculated a field called loyalty_program that categorizes customer with 10 or more orders as "gold", those with 5 to 9 as "silver", and everyone else with at least one order as "bronze". Customers with zero orders should have a NULL value.

# 10. Select the names of all customers who have placed orders that include a product with product_id 42. Use a correlated query.