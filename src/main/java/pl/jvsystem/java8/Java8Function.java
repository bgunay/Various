package pl.jvsystem.java8;

import pl.jvsystem.guava.beans.ViewValue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Przemek Nowak [przemek.nowak.pl@gmail.com]
 */
public class Java8Function {
    public static void main(String[] args) {
        List<ViewValue> list = new ArrayList<>();
        List<Long> result = list.stream().map(ViewValue::getId).collect(Collectors.toList());
        System.out.println(result);


    }
}
