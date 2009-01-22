package org.glob;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * @author me
 */
public class Scripting {
    public String runGroovy(String code){
        GroovyShell shell = new GroovyShell();
        Script script = shell.parse(code);
        Object o = script.run();
        return String.valueOf(o);
    }
}
