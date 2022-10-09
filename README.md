* To include [junit](https://junit.org/junit5/) libraries:

    * Put cursor over a @Test (which is marked in red)
        * Alt-enter
        * Add JUnit 5.* to classpath

* To include [jmh](https://openjdk.java.net/projects/code-tools/jmh/) libraries:

    * Project structure
        * Libraries
            * (+) from maven
                - org.openjdk.jmh:jmh-core:1.35
                - org.openjdk.jmh:jmh-generator-annprocess:1.35
            (each time we say OK, ADD to module)
        
    * Preferences
        * Build, Execution, Deployment
            * Compiler
                * Annotation processor
                    - Enable Annotation Processor 
