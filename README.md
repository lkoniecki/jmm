# Java Memory Model tests

Tests are using [http://openjdk.java.net/projects/code-tools/jcstress/](jcstress) harness tool.

## How to run tests?

* Install JDK9 (current version of jcstress requires JDK9),
* Clone jcstress from the repository

```
hg clone http://hg.openjdk.java.net/code-tools/jcstress/ jcstress
```

* Copy tests to 

```
jcstress\tests-custom\src
```

* Compile jcstress and tests

```
 cd jcstress
 mvn clean install -pl tests-custom -am
```

* Launch tests

```
java -jar tests-custom/target/jcstress.jar -t "*.DataRace*.*"
```

* You will find tests results in the `jcstress\results` directory