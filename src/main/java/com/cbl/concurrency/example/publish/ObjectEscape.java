package com.cbl.concurrency.example.publish;

import com.cbl.concurrency.annatations.NotRecommend;
import com.cbl.concurrency.annatations.NotThreadSafe;
import com.sun.org.apache.bcel.internal.classfile.InnerClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.security.Escape;

@Slf4j
@NotThreadSafe
@NotRecommend
public class ObjectEscape {
    private int thisCanBeEscape = 0;
    public ObjectEscape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", ObjectEscape.this.thisCanBeEscape);
        }
    }

    public static void main(String args[]) {
        new ObjectEscape();
    }
}
