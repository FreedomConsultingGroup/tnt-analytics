#!/usr/bin/env python
###############################################################################################
#   TNT Analytic 
#    Author: Scott A. Beall
#    Date: 21-March-2019
#    Org:  Freedom Consulting Group
#    Description:
#   	This program will answer questions 4,5 and 6
#    It will take a ES query as shown below, then print the results
#    ES Query:
#   GET /qa/_search
#   {
#     "query":{"match":{"userid":"drgift"}},
#    "_source":["userid","device","question","response"]
#   }
###############################################################################################

from datetime import datetime
from elasticsearch import Elasticsearch
from ssl import create_default_context
import certifi
#context = create_default_context(cafile="/usr/local/lib/python2.7/site-packages/certifi/cacert.pem")
context = create_default_context(cafile=certifi.where())
es = Elasticsearch(
["search-toiltrouble2-mg4ycgvgucahib4lulughlocci.us-east-1.es.amazonaws.com"],
scheme="https",
port=443
)

name = input("What userid?")
#print("There are %d Answered Questions:" % res['hits']['total'])
###############################################################################################
## Q4: What questions did the customer answer
###############################################################################################
print("Questions asked by %s" % name)
res = es.search(index="qa", body={"query": {"match": {"userid":name}}})
for hit in res['hits']['hits']:
    print("Userid: %(userid)s|Question: %(question)s|Response: %(response)s" % hit["_source"])

###############################################################################################
### Q5: What questions did the user have comments on
###############################################################################################
print("Comments by %s" % name)
res2 = es.search(index="qa", body={"query":{"bool":{ "must":[{"match":{"userid":name}}, {"exists":{"field":"comments"}}]}}})
for hit2 in res2['hits']['hits']:
    print("Userid: %(userid)s|Question: %(question)s|Response: %(comments)s" % hit2["_source"])

###############################################################################################
## Q6: Did the customer download/upload/ or attach any files. If so where were the file stored?
###############################################################################################
#res3 = es.search(index="qa", body=
