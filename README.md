# tnt-analytics
#to Pull the Pentaho docker container for Pentaho
$(aws ecr get-login --no-include-email --region us-east-1)
docker pull 642192211069.dkr.ecr.us-east-1.amazonaws.com/pentaho:latest
#By default, this will use 8181 for port #

#To connect to 'cloud/RDS instance' do:
#note instance and userid and password is tnt4all!
#Note make sure you use pgadmin4!
psql -h tntdb.cukikjchedgi.us-east-1.rds.amazonaws.com -p 5432 -d tntdb -U tnt
