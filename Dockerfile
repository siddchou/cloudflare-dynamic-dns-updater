FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY target/cloudflare-0.0.1-SNAPSHOT.jar /opt/app/cloudflare.jar
ENTRYPOINT ["java","-jar","/opt/app/cloudflare.jar"]

