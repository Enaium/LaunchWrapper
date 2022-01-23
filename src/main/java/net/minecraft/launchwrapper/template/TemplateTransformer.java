package net.minecraft.launchwrapper.template;

import net.minecraft.launchwrapper.IClassTransformer;

/**
 * @author Enaium
 */
public class TemplateTransformer implements IClassTransformer {

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        System.out.println(name);
        return basicClass;
    }
}
