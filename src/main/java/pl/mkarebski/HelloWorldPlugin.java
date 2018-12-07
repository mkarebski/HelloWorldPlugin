package pl.mkarebski;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class HelloWorldPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.task("hello").doLast(task -> System.out.println("Hello world from the plugin!"));
    }
}
