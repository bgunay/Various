package pl.jvsystem.generic;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class SuperExtendTest {

    public Number sumList(List<? extends Number> numsList) {
        double sum = 0;

        for (Number num : numsList) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public void copy(List<? super Double> out, List<? extends Number> in) {
        for (Number n : in) {
            out.add(n.doubleValue() * 2);
        }
    }

    public static void main(String[] args) {
        String fileName = "V" + StringUtils.replace("4.0.0", ".", "_") + ".xml";
        System.out.println(fileName);
    }

}