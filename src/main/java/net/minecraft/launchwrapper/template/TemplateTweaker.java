package net.minecraft.launchwrapper.template;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import net.minecraft.launchwrapper.LogWrapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TemplateTweaker implements ITweaker {
    private final List<String> arguments = new ArrayList<>();

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        this.arguments.addAll(args);
        addArgument("--gameDir", gameDir != null ? gameDir.getAbsolutePath() : null);
        addArgument("--assetsDir", assetsDir != null ? assetsDir.getPath() : null);
        addArgument("--version", profile);
    }

    public void addArgument(String name, String value) {
        if (value != null) {
            arguments.add(name);
            arguments.add(value);
        } else {
            LogWrapper.severe("Argument %s is %s", name, null);
        }
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        classLoader.registerTransformer(TemplateTransformer.class.getName());
    }

    @Override
    public String getLaunchTarget() {
        return TemplateTarget.class.getName();
    }

    @Override
    public String[] getLaunchArguments() {
        return arguments.toArray(new String[0]);
    }
}
