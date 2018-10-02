#Overview
Apache ActiveMQ is the most popular and powerful open source messaging and Integration Patterns server.
The ActiveMQ listens on port 61616 and the Web UI on port 8161
This ActiveMQ is use for db-exporter

There are 4 steps to build image:
Step 1:
docker build -t activemq:5.15.4 .
Step 2:
Get image_ID by use following command
docker images
Step 3: 
docker tag image_ID sprl-dev-mng.office-devel:5000/projectg/activemq:5.15.4
Step 4:
docker push sprl-dev-mng.office-devel:5000/projectg/activemq:5.15.4

#Web UI
http://localhost:8161/admin
By default, you can access the web console with admin/admin.

#ENV
Current version: 5.15.4
To change the version which you want, you can visit link https://archive.apache.org/dist/activemq/.
Then get value from apache-activemq-[version]-bin.tar.gz.sha512 file and replace to variable SHA512_VAL's value in Dockerfile. At this time, ACTIVEMQ_VERSION's value in Dockerfile is version which you want to change.
