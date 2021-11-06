package engine.mod.gradle.run;

import engine.mod.gradle.ide.IdeaConfiguration;
import org.gradle.api.Project;

import java.util.List;

public abstract class AbstractRunConfig {

    public abstract String getName();

    public abstract String getMainClass();

    public abstract List<String> getArgs();

    public abstract List<String> getJvmArgs();

    public void apply(Project project) {
        project.getTasks().create(getRunTaskName(), RunTask.class, this);
        IdeaConfiguration.createRunConfig(project, this);
    }

    public String getRunTaskName() {
        return "run" + getName();
    }

    public String getIdeaRunConfigBaseName() {
        return "Engine " + getName();
    }
}
