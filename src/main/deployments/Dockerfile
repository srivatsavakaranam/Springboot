FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /
ADD gs-springboot-0.0.1.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-Dspring.profiles.active=prod"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
