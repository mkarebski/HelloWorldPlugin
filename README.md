For simplicity local maven repo is used for plugin publishment.

To run ```hello``` task:

1) Open terminal and navigate to project directory
2) Run ```./gradlew publishToMavenLocal```
3) If ```./gradlew: Permission denied``` is returned run ```chmod +x gradlew```
4) Uncomment ```buildscript``` section and ```apply plugin: 'HelloWorldPlugin'``` line to use plugin
5) Run ```./gradlew hello```
6) You should see ```Hello world from the plugin!``` in your terminal

To test application run ```./gradlew test``` in project directory