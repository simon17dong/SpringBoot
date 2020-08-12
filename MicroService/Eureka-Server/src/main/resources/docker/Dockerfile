# https://blog.csdn.net/qq_35976271/article/details/100287663
FROM java:8
VOLUME /tmp
ADD eureka-server.war app.war
RUN bash -c 'touch /app.war'
EXPOSE 8763
# 为了减少Tomcat的启动时间，我们添加了一个指向“/dev/urandom”的系统属性作为熵源
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.war"]
