Se creaza catalogul lib in care se introduce gson-*.jar


javac -d build -cp lib\gson-2.8.2.jar -Xlint src\*.java 

java -cp build;lib\gson-2.8.2.jar gsonapp.TestGSON1

Linux

javac -d build -cp lib/gson-2.8.2.jar -Xlint src/*.java 

java -cp build;lib/gson-2.8.2.jar gsonapp.TestGSON1