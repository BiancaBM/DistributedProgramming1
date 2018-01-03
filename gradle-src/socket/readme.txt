1. In catalogul aplicatiei se creaza cataloagele 
      server clientswing clientfx
2. In fiecare catalog se genereaza proiectul Gradle
      gradle init --type java-library
3. Se completeaza cu fisierele necesare
4. Se actualizeaza build.gradle
5. Se copiaza in catalogul aplica\c{tiei fisierele
      settings.gradle build.xml build.gradle
6. Se executa 
      gradle clean assemble 
7. Din server se poate executa 
      gradle test

