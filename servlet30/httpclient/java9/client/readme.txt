javac --module-path="/home/mk/java/jdk-9/jmods/jdk.incubator.httpclient" -d mods src/*.java 

java --add-opens=java.base/java.lang=ALL-UNNAMED --module-path mods -m client/client.MyHttpClient


