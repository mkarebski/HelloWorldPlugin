package pl.mkarebski

import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification
import org.gradle.testkit.runner.TaskOutcome

class HelloWorldPluginSpec extends Specification {

    @Rule
    final TemporaryFolder testProjectDir = new TemporaryFolder()

    private File buildFile
    private static final String BASIC_PLUGIN_IMPORT = '''
        buildscript {
            repositories {  
                mavenLocal()
            }
            dependencies {
                classpath 'pl.mkarebski:hello-world-plugin:1.0-SNAPSHOT'
            }
        }
        apply plugin: 'HelloWorldPlugin'
        '''

    def setup() {
        prepareBuildGradle()
    }

    def "hello task should print hello message"() {
        when:
        def result = GradleRunner.create()
                .withProjectDir(testProjectDir.root)
                .withArguments('hello')
                .build()

        then:
        result.output.contains('Hello world from the plugin!')
        result.task(":hello").outcome == TaskOutcome.SUCCESS
    }

    private def prepareBuildGradle() {
        buildFile = testProjectDir.newFile('build.gradle')
        buildFile << BASIC_PLUGIN_IMPORT
    }

}
