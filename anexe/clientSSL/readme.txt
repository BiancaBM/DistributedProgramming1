1. Se configureaza SSL in apache-tomcat.
2. Se instaleaza servlet-ul myservlet in apache-tomcat.
3. Se creaza catalogul lib si se completeaza cu fisierele cerute de cpath.bat
    commons-logging-*.jar  
    httpclienr-*.jar           Denumirea se modifica in httpclient.jar 
    httpcore-*.jar             Denumirea se modifica in httpcore.jar 
    
4. Se copiaza keystore in catalog.
5. Se compileaza si se ruleaza clasele Java.


mkdir mods

javac -d mods --module-path lib *.java

java --module-path mods;lib -m client/http.SimpleCmmdcClientSSL
 
java --module-path mods;lib -m client/https.ClientCmmdcSSL