set GroupID=simple.app.helloworld
set ArtifactID=helloworld
set Version=1.0
mvn -B archetype:generate -DgroupId=%GroupID% -DartifactId=%ArtifactID% -DarchetypeArtifactId=maven-archetype-quickstart -Dversion=%Version%
