package org.openjdk.jcstress.tests.jug;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.IntResult2;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE;
import static org.openjdk.jcstress.annotations.Expect.FORBIDDEN;

/**
 * Created by lukasz.koniecki on 9/9/2016.
 */
@JCStressTest
@Description("Data race")
@Outcome(id = {"0, 1", "2, 0"}, expect = ACCEPTABLE, desc = "Trivial under sequential consistency")
@Outcome(id = {"0, 0", "2, 1"}, expect = FORBIDDEN, desc = "Violates sequential consistency")
@State
public class DataRaceFree {
    int a, b;
    int x, y;

    @Actor
    void thread1(IntResult2 r)  {
        synchronized(this) {
            y = a;
            b = 1;
        }
        r.r1 = y;
    }

    @Actor
    void thread2(IntResult2 r)  {
        synchronized(this) {
            x = b;
            a = 2;
        }
        r.r2 = x;
    }
}
