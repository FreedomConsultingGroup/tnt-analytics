# tnt-analytics
#to Pull the Pentaho docker container for Pentaho
$(aws ecr get-login --no-include-email --region us-east-1)
docker pull 642192211069.dkr.ecr.us-east-1.amazonaws.com/pentaho:latest
<<<<<<< HEAD
#Get container id
docker images
#To Run pentaho
docker run -d -p 8181:8181 <container id>
#To login to Pentaho do:
docker exec -i -t 3c9d841da61b /bin/bash
#To access carte, go to http://localhost:8181
#use cluster/cluster to login
docker run -d -p 8081:8081 -v /Users/scottbeall/projects/pentaho-ktrs:/data 415df17d73cf
=======
#By default, this will use 8181 for port #

#To connect to 'cloud/RDS instance' do:
#note instance and userid and password is tnt4all!
#Note make sure you use pgadmin4!
psql -h tntdb.cukikjchedgi.us-east-1.rds.amazonaws.com -p 5432 -d tntdb -U tnt
