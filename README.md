# QBE Graph Database Core

This repository contains code for executing graph database queries on different databases using graphs in Java as QBE query language.

Supported databases:
- Neo4j
- JanusGraph (planned)

## Development

The prerequisites are
- _Java 17_, you can use any OpenJDK distribution e.g. [GraalVM](https://www.graalvm.org/),
- [_Maven_](https://maven.apache.org/install.html), 
- and [_Docker Compose_](https://docs.docker.com/compose/install/).

### Install

```sh
# Console 1
docker compose up
```

```sh
# Console 2
# You may need to change your Java version for the project.

# PowerShell
$Env:JAVA_HOME = "C:\Users\<name>\.jdks\graalvm-ce-17"

# Bash/Zsh
export JAVA_HOME = "~/programs/java/.jdks/graalvm-ce-17"

mvn install
mvn test
```

## License

TBD