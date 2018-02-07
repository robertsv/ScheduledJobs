FROM openjdk:8-jre-alpine
RUN mkdir -p /var/lib/web-jobs
COPY ./target/WebJobs-0.0.1-SNAPSHOT.jar /var/lib/web-jobs
WORKDIR /var/lib/web-jobs
EXPOSE 8888
CMD ["java", "-jar", "WebJobs-0.0.1-SNAPSHOT.jar", "--server.port=8888"]