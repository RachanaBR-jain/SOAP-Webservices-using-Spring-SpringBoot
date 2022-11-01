jaxb2 help convert xml request to java object and java object back to xml resources

<!-- adding jaxb2 plugin --> in pom.xml 
			<!-- XSD source folder(${project.basedir}/src/main/resources) -->
			<!-- java class source folder (${project.basedir}/src/main/java) -->
			<!--  clear folder if we don't provide this it will delete all the files from java path -->

Steps:
1)copy course-details.xsd in resources path
2)add below plugin under <plugins>
<plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>jaxb2-maven-plugin</artifactId>
            <version>1.6</version>
            <executions>
                <execution>
                    <id>xjc</id>
                    <goals>
                        <goal>xjc</goal>
                    </goals>
                </execution>
            </executions>
            <configuration>
                <schemaDirectory>${project.basedir}/src/main/resources</schemaDirectory>
                <outputDirectory>${project.basedir}/src/main/java</outputDirectory>
                <cleanOutputDir>false</cleanOutputDir>
            </configuration>
        </plugin>
save the file-> do maven update-> after maven update may files will we added in java source path

method: 
first java will go and check for xsd folder in resources path
then create or fetch the objects from java source path

