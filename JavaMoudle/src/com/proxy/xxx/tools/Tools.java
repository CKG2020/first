package com.proxy.xxx.tools;

public class Tools {
    public static void start(String classname) throws Exception {
        Class c = Class.forName(classname);
        IRunanble t = (IRunanble) c.newInstance();
        t.run();
    }
}
