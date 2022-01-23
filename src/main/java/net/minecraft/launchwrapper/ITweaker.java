package net.minecraft.launchwrapper;

import java.io.File;
import java.util.List;

public interface ITweaker {

    void acceptOptions(List<String> args);

    void injectIntoClassLoader(LaunchClassLoader classLoader);

    String getLaunchTarget();

    String[] getLaunchArguments();

}
