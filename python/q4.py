#!/usr/local/bin/python
#TNT Q4 From Appendix A
# What questions did the customer answer
# Author: Scott A. Beall
# Org:  Freedom Consulting Group
# Description:
# ES Query:
#GET /qa/_search
#{
#  "query":{"match":{"userid":"drgift"}},
# "_source":["userid","device","question","response"]
#}

from datetime import datetime
from elasticsearch import Elasticsearch
from ssl import create_default_context
import certifi
context = create_default_context(cafile="/usr/local/lib/python2.7/site-packages/certifi/cacert.pem")
es = Elasticsearch(
["search-toiltrouble2-mg4ycgvgucahib4lulughlocci.us-east-1.es.amazonaws.com"],
scheme="https",
port=443
)

name = raw_input("What userid?")
res = es.search(index="qa", body={"query": {"match": {"userid":name}}})
print("There are %d Answered Questions:" % res['hits']['total'])
for hit in res['hits']['hits']:
    print("Userid: %(userid)s|Question: %(question)s|Response: %(response)s" % hit["_source"])

res2 = es.search(index="qa", body={"query":{"bool":{ "must":[{"match":{"userid":"ysam"}}, {"exists":{"field":"comments"}}]}}})

for hit2 in res2['hits']['hits']:
    print("Userid: %(userid)s|Question: %(question)s|Response: %(comments)s" % hit2["_source"])