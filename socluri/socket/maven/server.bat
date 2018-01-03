set PATH=d:\JavaApp\apache-maven-3.5.0\bin;%PATH%
set JAVA_HOME=c:\Program Files\Java\jdk-9
cd server

mvn -e exec:java -Dexec.mainClass="cmmdc.socket.server.MyMServer" 
