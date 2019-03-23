select c.userid,cr.date_answered,q.question,
cr.response,qt.question_type, 
array(select 'comments:'||comments as comments from comments where customers_id = c.id) as  comments,
(select row_to_json(documents) from (select storage_path||'/'||name as name,date_uploaded from documents where customers_id=c.id) documents)
from customers c, customerresponse cr, questions q, question_type qt
where c.id = cr.customers_id 
and q.id = cr.questions_id 
and qt.id=q.question_type_id
