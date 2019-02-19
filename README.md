# tnt-analytics
#Pull the Pentaho docker container
$(aws ecr get-login --no-include-email --region us-east-1)
docker pull 642192211069.dkr.ecr.us-east-1.amazonaws.com/pentaho:latest
