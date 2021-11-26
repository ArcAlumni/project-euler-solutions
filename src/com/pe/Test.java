package com.pe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class Test {

    private static final int MAX_TIME = 500;

    private static Properties properties = new Properties();

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        properties.load(new FileInputStream(System.getProperty("user.dir") + "/src/resources/solutions.txt"));
        for (Class<?> c : findAllClassesUsingClassLoader("com.pe")) {
            try {
                callMain(c);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void callMain(Class<?> clazz) throws Exception {
        String problemNo = getProblemNo(clazz) + "";
        long time = System.currentTimeMillis();
        String result = ((Solution) (clazz.getDeclaredConstructor().newInstance())).solve();
        if (properties.getProperty(problemNo).equals(result)) {
            long diff = (System.currentTimeMillis() - time);
            if (diff > MAX_TIME) {
                System.err.println("P-" + getProblemNo(clazz) + " Execution time : " + diff);
            } else {
                System.out.println("P-" + getProblemNo(clazz) + " Execution time : " + diff);
            }
        } else {
            System.err.println("P-" + problemNo + " Invalid result (Expected : " +
                    properties.getProperty(problemNo) + ", Actual : " + result + ")");
        }
    }

    private static List<Class<?>> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines().filter(line -> line.endsWith(".class")).map(line -> getClass(line, packageName))
                .filter(c -> c.getSimpleName().contains("_") && c.getSimpleName().contains("P"))
                .sorted((c1, c2) -> getProblemNo(c1) - getProblemNo(c2)).collect(Collectors.toList());
    }

    private static Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private static int getProblemNo(Class<?> clazz) {
        return Integer.parseInt(clazz.getSimpleName().substring(1, clazz.getSimpleName().indexOf("_")));
    }

}
