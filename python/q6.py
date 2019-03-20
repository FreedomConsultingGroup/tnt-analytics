#TNT Q6 From Appendix A
# Did the customer download/upload/ or attach any files.  If so where were they stored 
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

doc = {
    'author': 'kimchy',
    'text': 'Elasticsearch: cool. bonsai cool.',
    'timestamp': datetime.now(),
}
res = es.index(index="test-index", doc_type='tweet', id=1, body=doc)
print(res['result'])

res = es.get(index="test-index", doc_type='tweet', id=1)
print(res['_source'])

es.indices.refresh(index="test-index")

res = es.search(index="test-index", body={"query": {"match_all": {}}})
print("Got %d Hits:" % res['hits']['total'])
for hit in res['hits']['hits']:
    print("%(timestamp)s %(author)s: %(text)s" % hit["_source"])
