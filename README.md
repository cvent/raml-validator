# RAML Validator

This maven plugin will validate a RAML file and fail the build stage if there are errors. In order to use in 
your project, add this to the build section of your pom file:

```xml
<build>
        <plugins>
            <plugin>
                <groupId>com.cvent</groupId>
                <artifactId>raml-validator</artifactId>
                <version>1.0.0</version>
                <configuration>
                    <ramlFile>api.raml</ramlFile>
                </configuration>
                <executions>
                    <execution>
                        <phase>compile</phase>
                        <goals>
                            <goal>validate-raml</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            ...
        </plugins>
        ...
<build>
```
