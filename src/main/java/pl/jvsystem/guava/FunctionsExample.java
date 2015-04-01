package pl.jvsystem.guava;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import pl.jvsystem.guava.beans.ViewValue;

import java.util.List;

/**
 * Author: Przemek Nowak [przemek.nowak.pl@gmail.com]
 */
public class FunctionsExample {
    public static void main(String[] args) {
        Function<ViewValue, Long> transform = new Function<ViewValue, Long>() {
            @Override
            public Long apply(ViewValue from) {
                return from.getId();
            }
        };
        List<ViewValue> list = Lists.newArrayList();
        List<Long> idsList = Lists.transform(list, transform);
    }
}
