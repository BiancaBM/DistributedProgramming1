set GroupID=cmmdc.socket.server
set ArtifactID=server
set Version=1.0
mvn archetype:generate -DgroupId=%GroupID% -DartifactId=%ArtifactID% -Dversion=%Version% -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
