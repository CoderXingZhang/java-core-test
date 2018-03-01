package com.hello.world.javacore.classloaderTest;

import java.util.Date;

/**
 * @author xing
 */
public class ClassLoaderAttachment extends Date{

    private static final long serialVersionUID = -2292019457799075997L;

    @Override
    public String toString() {
        return "Hello ClassLoader! ";
    }
}
