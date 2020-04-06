package com.proxy.easyarch.tools;

/**
 * Created by andilyliao on 16-12-11.
 */
public class Tools {
    public static void start(String classname) throws Exception {
        Class c = Class.forName(classname);
        IRunanble t = (IRunanble) c.newInstance();
        t.run();
    }
}
