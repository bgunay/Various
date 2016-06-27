package pl.jvsystem.javalang;

import javaslang.Tuple;
import javaslang.Tuple2;
import org.junit.Test;

/**
 * TupleTest
 */
public class TupleTest {

    @Test
    public void shouldCreateTuple() throws Exception {
        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
        System.out.println(java8._1);
        System.out.println(java8._2);

    }
}
