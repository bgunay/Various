package com.github.pnowy.various.codility;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Zadanie polegała na napisaniu funkcji, która przyjmuje za argument tablicę i zwraca:
 * - dowolny indeks najczęstszego elementu, jeżeli ten element występuje w ponad połowie indeksów tablicy
 * - -1 jeżeli nie ma elementu, który występuję z częstością > 0,5
 *
 * Dodatkowo, złożoność obliczeniowa powinna być O(N), a złożoność pamięciowa O(1)
 *
 * Przykładowo dla tablicy [2 2 2 1 5 6 2] funkcja powinna zwrócić 0 lub 1 lub 2 lub 6, a dla [2 2 2 1 5 6] -1.
 */
@Slf4j
public class MostCommonElementTaskTest {

    @Test
    public void shouldCheckArray() throws Exception {
        int max = max(new int[]{2, 2, 2, 1, 5, 6, 2});
        log.info("max: {}", max);

    }

    private int max(int dataArray[]) {
        int dataArrayLength = dataArray.length;
        int maxElementCounter = 0;
        int selectedElementIndex = 0;

        for (int i = 0; i < dataArrayLength; i++) {
            int elementCounter = 0;
            for (int j = 0; j < dataArrayLength; j++) {
                int checkedElement = dataArray[i];
                if (dataArray[j] == checkedElement) {
                    elementCounter++;
                }
            }
            if (elementCounter > maxElementCounter) {
                maxElementCounter = elementCounter;
                selectedElementIndex = i;
            }
        }

        if (maxElementCounter > dataArrayLength / 2)
            return selectedElementIndex;
        else
            return -1;
    }


}
