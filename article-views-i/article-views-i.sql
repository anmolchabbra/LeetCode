# Write your MySQL query statement below
Select Distinct Views.author_id as id from Views where Views.author_id = Views.viewer_id ORDER BY 
Views.author_id;