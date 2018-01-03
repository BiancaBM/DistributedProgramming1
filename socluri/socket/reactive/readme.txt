mkdir work
javac -d work src/*.java 

java -cp work cmmdc.socket.server.MyMServer

java -cp work cmmdc.socket.client.CmmdcClient
