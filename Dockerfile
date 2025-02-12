FROM openjdk:21-jdk-slim
COPY ./build/libs/jachuiplan-*-SNAPSHOT.jar app.jar

# 기본 환경 변수 선언
ENV DB_URL=jdbc:log4jdbc:oracle:thin:@localhost:1521/orcl
ENV DB_USERNAME=admin
ENV DB_PASSWORD=password

EXPOSE 80
ENTRYPOINT ["java","-jar","/app.jar"]