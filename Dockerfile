FROM openjdk:21-jdk-slim
COPY ./build/libs/jachuiplan-*-SNAPSHOT.jar app.jar

# 필요한 환경 변수 목록
# DB_URL
# DB_USERNAME
# DB_PASSWORD
# GOOGLE_CLIENT_ID
# GOOGLE_CLIENT_SECRET

EXPOSE 80
ENTRYPOINT ["java","-jar","/app.jar"]
