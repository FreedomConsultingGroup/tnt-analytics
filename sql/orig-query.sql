select c.userid,cr.response,cr.date_answered,q.question,qt.question_type,cm.comments
from customers c, customerresponse cr, questions q, question_type qt, comments cm
where c.id = cr.customers_id 
and q.id = cr.questions_id 
and qt.id=q.question_type_id
and cm.customers_id = c.id
