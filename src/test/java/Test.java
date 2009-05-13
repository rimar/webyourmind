import junit.framework.TestCase;

import java.util.*;

/**
 * @author me
 */
public class Test extends TestCase {

    public void testSomething() throws Exception{
        System.out.println("==========================TEST=============================");
        System.out.println("Date:" + new Date());
        Map<Thread,StackTraceElement[]> all = Thread.getAllStackTraces();
        Set<Thread> trs = all.keySet();
        for (Thread tr : trs) {
          System.out.println("\nThread: " + tr.getName());
          for (StackTraceElement element : all.get(tr)) {
            System.out.println("  " + element);
          }
        }
        /*synchronized(this) {
          wait();
        }*/
    }
}
