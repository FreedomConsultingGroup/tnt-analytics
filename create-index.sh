#curl -X PUT https://search-toiltrouble2-mg4ycgvgucahib4lulughlocci.us-east-1.es.amazonaws.com:443/$1
#$1 is the ES cluster, $2 is the name of the index
curl -X PUT $1/$2
