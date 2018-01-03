set GroupID=simple.app.cmmdc
set ArtifactID=cmmdc
set Version=1.0
set ArchetypeArtifactID=maven-archetype-quickstart
mvn archetype:generate -DgroupId=%GroupID% -DartifactId=%ArtifactID% -Dversion=%Version% -DarchetypeArtifactId=%ArchetypeArtifactID% -DarchetypeVersion=1.1 -DinteractiveMode=false
