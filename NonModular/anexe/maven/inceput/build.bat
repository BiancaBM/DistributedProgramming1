set GroupID=simple.app.helloworld
set ArtifactID=helloworld
set Version=1.0
set ArchetypeArtifactID=maven-archetype-quickstart
mvn archetype:generate -DgroupId=%GroupID% -DartifactId=%ArtifactID% -Dversion=%Version% -DarchetypeArtifactId=%ArchetypeArtifactID% -DinteractiveMode=false
