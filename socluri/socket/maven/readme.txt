Configuratia initiala
maven 
  maven.bat
  build.bat
  build-s.bat
  build-c.bat
Se executa 
1. maven
2. build
3. Se copiaza pom.xml in catalogul maven 

Se completeaza aplicatiile server si client cu sursele
si se completeaza fisierul pom.xml dupa <dependencies> cu
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.6.2</version>
        <configuration>
          <source>1.9</source>
          <target>1.9</target>
          <showWarnings>true</showWarnings>
          <showDeprecation>true</showDeprecation>
        </configuration>
      </plugin>
    </plugins>
  </build>  

6. mvn clean compile

7. server.bat
8. maven
   client.bat

Obs.

maven nu accepta in module-info.java comentarii !

Linux
   
  Lansarea in executie: Copiati comanda maven din server.bat/client.bat
  si se lanseaza din catalogul aplicatiei corespunzatoare.

  build.sh ??
