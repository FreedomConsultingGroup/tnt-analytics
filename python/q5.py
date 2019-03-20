#TNT Q5 From Appendix A
# Did that same customer leave a comment, where was the comment placed?
# Author: Scott A. Beall
# Org:  Freedom Consulting Group
# Description:
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
