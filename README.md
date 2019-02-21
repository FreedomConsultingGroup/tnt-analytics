# tnt-analytics
#Pull the Pentaho docker container
$(aws ecr get-login --no-include-email --region us-east-1)
docker pull 642192211069.dkr.ecr.us-east-1.amazonaws.com/pentaho:latest
#Get container id
docker images
#To Run pentaho
docker run -d -p 8181:8181 <container id>
#To login to Pentaho do:
docker exec -i -t 3c9d841da61b /bin/bash
#To access carte, go to http://localhost:8181
#use cluster/cluster to login
docker run -d -p 8081:8081 -v /Users/scottbeall/projects/pentaho-ktrs:/data 415df17d73cf
