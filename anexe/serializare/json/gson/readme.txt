javac -d mods -p lib\gson.jar -Xlint src/*.java 

java --module-path mods;lib\gson.jar -m json/gsonapp.TestGSON1

