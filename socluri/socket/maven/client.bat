set PATH=d:\JavaApp\apache-maven-3.5.0\bin;%PATH%
set JAVA_HOME=c:\Program Files\Java\jdk-9
cd client

mvn -e exec:java -Dexec.mainClass="cmmdc.socket.client.CmmdcClient" 

rem mvn -e exec:java -Dexec.mainClass="cmmdc.socket.client.ClientFXCmmdc" 
rem mvn -e exec:java -Dexec.mainClass="cmmdc.socket.client.VisualCmmdcClient" 
