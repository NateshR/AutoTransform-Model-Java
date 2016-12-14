import sun.misc.Unsafe;

import javax.tools.*;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.singletonList;
import static javax.tools.JavaFileObject.Kind.SOURCE;

/**
 * Created by nateshrelhan on 12/12/16.
 */
public class Mapper {
    public static void main(String[] args) {
        try {
            Class cTo = Class.forName("entity.ShareDataContent");
            Class cFrom = Class.forName("entity.ShareDataEntity");
            String cToVariable = Character.toLowerCase(cTo.getSimpleName().charAt(0)) + cTo.getSimpleName().substring(1);
            String cFromVariable = Character.toLowerCase(cFrom.getSimpleName().charAt(0)) + cFrom.getSimpleName().substring(1);
            String methodCode = "";
            Field[] fieldsTo = cTo.getDeclaredFields();
            for (int i = 0; i < fieldsTo.length; i++) {
                PropertyDescriptor pdTo = new PropertyDescriptor(fieldsTo[i].getName(), cTo);
                PropertyDescriptor pdFrom = new PropertyDescriptor(fieldsTo[i].getName(), cFrom);
                Method setter = pdTo.getWriteMethod();
                Method getter = pdFrom.getReadMethod();

                methodCode = cToVariable + "." + setter.getName() + "(" + cFromVariable + "." + getter.getName() + "());\n" + methodCode;
            }
            System.out.println(methodCode);
            String methodCodeToWrite = " public " + cTo.getSimpleName() + " transform(" + cFrom.getSimpleName() + " " + cFromVariable + ") {\n" + cTo.getSimpleName() + " " + cToVariable + " = new " + cTo.getSimpleName() + "();\n" + "if(" + cFromVariable + " != null){\n" + methodCode + "}\n return " + cToVariable + ";";

            dynamicClassCreation(cFrom.getSimpleName() + "Mapper", methodCodeToWrite);
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    public static void dynamicClassCreation(String className, String methodCode) throws ClassNotFoundException, IllegalAccessException, InstantiationException, URISyntaxException, NoSuchFieldException {
        final StringBuilder source = new StringBuilder();
        source.append("public class " + className + " {\n");

        source.append(methodCode);
        source.append(" }\n");
        source.append("}\n");

        try {
            File currentDirectory = new File(new File(".").getAbsolutePath());
            File directory = new File(currentDirectory.getCanonicalPath() + "/src/mapperCreated/");
            File file = new File(directory, className + ".java");
            if (!directory.exists()) {
                directory.mkdirs();
            }
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            fileWriter.write(source.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
