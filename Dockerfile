##### Build docker image
# FROM amazoncorretto:11
# Fix rate limit error from Docker hub, by utilizing AWS ECR.
FROM 489478819445.dkr.ecr.ap-northeast-2.amazonaws.com/amazoncorretto:11

MAINTAINER starbucks.co.kr

#### Install some utils ####
RUN yum install -y iputils bind-utils unzip jq

# install aws-cli v2
RUN curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip" && \
	unzip awscliv2.zip && \
	./aws/install

ARG JAR_FILE=/target/bootiful-job-0.1.jar
COPY ${JAR_FILE} spring-batch-lab.jar

#Add PG key file and log directory
#ADD ./pg /pgstub
###### ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/payment.jar"]
#ENTRYPOINT ["/bin/sh", "-c" , "echo 10.105.48.54    dev-msr.istarbucks.co.kr >> /etc/hosts  && exec java -Djava.security.egd=file:/dev/.urandom -Duser.timezone=Asia/Seoul -jar /payment.jar " ]
# [2021-07-03] No need to manually add dev-msr.istarbucks.co.kr any more.
#ENTRYPOINT ["/bin/sh", "-c" , "exec java -Djava.security.egd=file:/dev/.urandom -Duser.timezone=Asia/Seoul -Dcom.amazonaws.sdk.disableEc2Metadata=true -jar /spring-batch-lab.jar " ]
ENTRYPOINT ["/bin/sh", "-c" , "exec java -XX:+HeapDumpOnOutOfMemoryError -Djava.security.egd=file:/dev/.urandom -Duser.timezone=Asia/Seoul -jar /spring-batch-lab.jar ${0} ${@}" ]
#ENTRYPOINT ["java", "-XX:+HeapDumpOnOutOfMemoryError", "-Djava.security.egd=file:/dev/.urandom", "-Duser.timezone=Asia/Seoul", "-jar", "/spring-batch-lab.jar"]
