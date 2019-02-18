#curl 'https://search-toiltrouble2-mg4ycgvgucahib4lulughlocci.us-east-1.es.amazonaws.com:443'
curl -XPOST -H 'Content-Type: application/x-ndjson' -XPOST $1/movie-query -d '{
    {
        "mappings":{
            "doc":{
                "properties": {
                    "access_date": {"type":"string"},
                    "device":{"type":"string"},
                    "application":{"type":"string"},
                    "started_movie":{"type":"string"}
                }
            }
        }
    }
}'
