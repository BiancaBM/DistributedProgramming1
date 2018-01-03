Se creaza catalogul lib in care se introduce javax.json.jar


javac -d mods -p lib\javax.json.jar -Xlint src\*.java 

java --module-path mods;lib\javax.json.jar -m json/jee.GenerateJSON

java --module-path mods;lib\javax.json.jar -m json/jee.ReadJSON

Linux

javac -d mods -p lib/javax.json.jar -Xlint src/*.java

java --module-path mods:lib/javax.json.jar -m json/jee.GenerateJSON

java --module-path mods:lib/javax.json.jar -m json/jee.ReadJSON
 
