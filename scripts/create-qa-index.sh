#this creates the index
curl -X PUT https://search-toiltrouble2-mg4ycgvgucahib4lulughlocci.us-east-1.es.amazonaws.com:443/qa
#This creates the type
curl -H'Content-Type: application/json' -XPUT 'https://search-toiltrouble2-mg4ycgvgucahib4lulughlocci.us-east-1.es.amazonaws.com:443/qa/_mapping/qa' -d '
{
    "qa": {
        "properties": {
            "userid": {
                "type": "keyword"
            },
            "question": {
                "type": "keyword"
            },
            "response": {
                "type": "keyword"
            },
            "date_answered": {
                "type": "date"
            },
            "question_type": {
                "type": "keyword"
            },
            "comments": {
                "type": "keyword"
            },
            "document": {
                "type": "keyword"
            },
            "device":{
                "type":"keyword"
            }
        }
    }
}'