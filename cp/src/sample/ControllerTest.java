package sample;

import org.junit.Assert;

import static org.junit.Assert.*;

public class ControllerTest {

    @org.junit.Test
    public void solve() {
            float x1Temp; float x2Temp; float x3Temp;
            float x1 = 0; float x2 = 0; float x3 = 0;
            float x1Old; float x2Old; float x3Old;
            int counter = 0;
            // точность вычислений, десять в отрицательной степени, хранимая в поле, которая и выражает точность
            float accuracy = (float) Math.pow(10, -1 * 3);
            // Вывод формул для того, чтобы по ним производить цикл итераций, так же это является первой итерацией
            x1Old = (5) /(8);
            x2Old = (2) /(7);
            x3Old = (3) /(-12);
            // Собсна расчет
            while (Math.abs(x1 - x1Old) > accuracy && Math.abs(x2 - x2Old) > accuracy
                    && Math.abs(x3 - x3Old) > accuracy){
                x1Temp = (5) - (4) * x2
                        - (2 * x3) /(8);
                x2Temp = (2) - (5) * x1
                        - (1 * x3) /(7);
                x3Temp = (3) - (1) * x1
                        - (3 * x2) /(-12);
                x1Old = x1; x2Old = x2; x3Old = x3;
                x1 = x1Temp; x2 = x2Temp; x3=x3Temp;
                // Если прошло более 50 итераций заканчиваем, потому что рискуем попасть в бесконечный цикл
                if (counter++ > 50){break;}
            }
            Assert.assertEquals(0.807,Math.ceil(x1 * Math.pow(10,3)),1);
            Assert.assertEquals(-0.251,Math.ceil(x2 * Math.pow(10,3)),1);
            Assert.assertEquals(-0.243,Math.ceil(x3 * Math.pow(10,3)),1);

    }
}