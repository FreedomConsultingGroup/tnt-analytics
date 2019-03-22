#!/usr/bin/env python
############################################################################################
#    Name:  ToilAndTrouble Analytic 
#    Author: Scott A. Beall
#    Date: 21-March-2019
#    Org:  Freedom Consulting Group
#    Purpose:
#       This program is part of the ToilAndTrouble Tech Challenge.  Its demonstrates our ability
#       to develop a command line/script based analytic.
#
#    Inputs/Outputs:
#       The program will prompt a user for a userid of a Customer
#       It will return the following results
#         Q4: What questions did the customer answer
#         Q5: What questions did the user have comments on
#         Q6: Did the customer download/upload/ or attach any files. If so where were the file stored?
#
#
#    NOTES:
#      This program requires Python 3!  Use pyenv to set your python version
#      You'll need to install the following Python modules using pip
#      pip install elasticsearch
#      pip install certifi
#
############################################################################################

from datetime import datetime
from elasticsearch import Elasticsearch
from ssl import create_default_context
import certifi
import sys

def setContext():
## Context retrieves the users certs 
   context = create_default_context(cafile=certifi.where())
   return

def getEs():
## Connect to ElasticSearch (Ours is located in AWS)
   es = Elasticsearch(
   ["search-toiltrouble2-mg4ycgvgucahib4lulughlocci.us-east-1.es.amazonaws.com"],
   scheme="https",
   port=443
   )
   return es

def getUser():   
## System user will be prompted to enter a Customers userid/SID
   userid = input("Enter a Userid (SID)?")
   return userid

############################################################################################
## The rest of the program will print out the results for Questions 4-6 in Appendix A
############################################################################################

def question4(es,userid):
############################################################################################
## Q4: What questions did the customer answer
############################################################################################
   q4 = es.search(index="qa", body={"query": {"match": {"userid":userid}}})
   ## Stop program if no results for entered user were given
   if(q4['hits']['total']<1):
      print("No results were found for %s" % userid)
      sys.exit()

   ## If we get this far, then there were results
   print("-----------------------------------------------------------------------")
   print("-- Questions and responses by user %s" % userid)
   print("-----------------------------------------------------------------------")
   for hit in q4['hits']['hits']:
      print("For Question: %(question)s, %(userid)s Responsed: %(response)s" % hit["_source"])
   return q4['hits']['total']

def question5(es,userid):
############################################################################################
### Q5: What questions did the user have comments on
############################################################################################
   ## Query ElasticSearch
   q5 = es.search(index="qa", body={"query":{"bool":{ "must":[{"match":{"userid":userid}}, {"exists":{"field":"comments"}}]}}})

   ## If nothing was found then skip
   if(q5['hits']['total'] < 1):
      print("no Comments by %s were found" % userid)
   else:
      print("-----------------------------------------------------------------------")
      for hit5 in q5['hits']['hits']:
         print("-- Comments left on question: %(question)s" % hit5["_source"])
         print("====>%(comments)s" % hit5["_source"])

def question6(es,userid):
###########################################################################################
## Q6: Did the customer download/upload/ or attach any files. If so where were the file stored?
############################################################################################
   q6 = es.search(index="qa", body={"query":{"bool":{ "must":[{"match":{"userid":userid}}, {"exists":{"field":"document"}}]}}})

   ## If no documents were found then skip
   if(q6['hits']['total'] < 1):
      print("no Documents were downloaded/uploaded or attached by %s" % userid)
   else:
      print("-----------------------------------------------------------------------")
      for hit6 in q6['hits']['hits']:
         print("Documents were attached for question: %(question)s" % hit6["_source"])
         print("==>Documents: %(document)s" % hit6["_source"])

""" setContext()
es=getEs()
userid=getUser()
question4(es,userid)
question5(es,userid)
question6(es,userid) """
print("-----------------------------------------------------------------------")
