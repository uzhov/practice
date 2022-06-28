package sample;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public TextField x11Field;
    public TextField x12Field;
    public TextField x13Field;
    public TextField x21Field;
    public TextField x22Field;
    public TextField x23Field;
    public TextField x31Field;
    public TextField x32Field;
    public TextField x33Field;
    public TextField accuracyField;
    public Label resultx1Label;
    public Label resultx2Label;
    public Label resultx3Label;
    public TextField result1Field;
    public TextField result2Field;
    public TextField result3Field;
    public Label wrongData;
    String tempTemp;

    public void solve(){
        try{
            float x1Temp; float x2Temp; float x3Temp;
            float x1 = 0; float x2 = 0; float x3 = 0;
            float x1Old; float x2Old; float x3Old;
            int counter = 0;
            // точность вычислений, десять в отрицательной степени, хранимая в поле, которая и выражает точность
            float accuracy = (float) Math.pow(10, -1 * Double.parseDouble(accuracyField.getText()));
            // Приведение матрицы к диагональному преобладанию
            // Чтобы вот диагональ слева направо (сверху вниз) была так, чтобы х1 был больше х2 и х3 в первой строке, соответсвенно х2 больше х1 и х3 во второй и т.д
            if (Math.abs(Float.parseFloat(x11Field.getText())) >=
                    Math.abs(Float.parseFloat(x12Field.getText())) + Math.abs(Float.parseFloat(x13Field.getText()))){ }
            else if(Math.abs(Float.parseFloat(x21Field.getText())) >=
                    Math.abs(Float.parseFloat(x22Field.getText())) + Math.abs(Float.parseFloat(x23Field.getText()))){ change1_2(); }
            else if(Math.abs(Float.parseFloat(x31Field.getText())) >=
                    Math.abs(Float.parseFloat(x32Field.getText())) + Math.abs(Float.parseFloat(x33Field.getText()))){ change1_3(); }
            if (Math.abs(Float.parseFloat(x22Field.getText())) >=
                    Math.abs(Float.parseFloat(x23Field.getText()) + Math.abs(Float.parseFloat(x21Field.getText())))){ }
            else if (Math.abs(Float.parseFloat(x33Field.getText())) >=
                    Math.abs(Float.parseFloat(x32Field.getText())) + Math.abs(Float.parseFloat(x31Field.getText()))){ }
            else { change2_3(); }
            // Вывод формул для того, чтобы по ним производить цикл итераций, так же это является первой итерацией
            x1Old = (Float.parseFloat(result1Field.getText()) - (Float.parseFloat(x12Field.getText()) * 0)
                    - (Float.parseFloat(x13Field.getText()) * 0)) / Float.parseFloat(x11Field.getText());
            x2Old = (Float.parseFloat(result2Field.getText()) - (Float.parseFloat(x21Field.getText()) * 0)
                    - (Float.parseFloat(x23Field.getText()) * 0)) / Float.parseFloat(x22Field.getText());
            x3Old = (Float.parseFloat(result3Field.getText()) - (Float.parseFloat(x31Field.getText()) * 0)
                    - (Float.parseFloat(x32Field.getText()) * 0)) / Float.parseFloat(x33Field.getText());
            // Собсна расчет
            while (Math.abs(x1 - x1Old) > accuracy && Math.abs(x2 - x2Old) > accuracy
                    && Math.abs(x3 - x3Old) > accuracy){
                x1Temp = (Float.parseFloat(result1Field.getText()) - (Float.parseFloat(x12Field.getText()) * x2)
                        - (Float.parseFloat(x13Field.getText()) * x3)) / Float.parseFloat(x11Field.getText());
                x2Temp = (Float.parseFloat(result2Field.getText()) - (Float.parseFloat(x21Field.getText()) * x1)
                        - (Float.parseFloat(x23Field.getText()) * x3)) / Float.parseFloat(x22Field.getText());
                x3Temp = (Float.parseFloat(result3Field.getText()) - (Float.parseFloat(x31Field.getText()) * x1)
                        - (Float.parseFloat(x32Field.getText()) * x2)) / Float.parseFloat(x33Field.getText());
                x1Old = x1; x2Old = x2; x3Old = x3;
                x1 = x1Temp; x2 = x2Temp; x3=x3Temp;
                // Если прошло более 50 итераций заканчиваем, потому что рискуем попасть в бесконечный цикл
                if (counter++ > 50){break;}
            }
            resultx1Label.setText(String.valueOf(Math.ceil(x1 * Math.pow(10,
                    Double.parseDouble(accuracyField.getText()))) /
                    Math.pow(10, Double.parseDouble(accuracyField.getText()))));
            resultx2Label.setText(String.valueOf(Math.ceil(x2 * Math.pow(10,
                    Double.parseDouble(accuracyField.getText()))) /
                    Math.pow(10, Double.parseDouble(accuracyField.getText()))));
            resultx3Label.setText(String.valueOf(Math.ceil(x3 * Math.pow(10,
                    Double.parseDouble(accuracyField.getText()))) /
                    Math.pow(10, Double.parseDouble(accuracyField.getText()))));
            wrongData.setVisible(false);
            // Пойманная ошибка на введенные строки вместо чисел
        } catch (NumberFormatException e){
            wrongData.setVisible(true);
        }
    }

    // Поменять первую и вторую строку местами
    public void change1_2(){
        tempTemp = x11Field.getText();
        x11Field.setText(x21Field.getText());
        x21Field.setText(tempTemp);
        tempTemp = x12Field.getText();
        x12Field.setText(x22Field.getText());
        x22Field.setText(tempTemp);
        tempTemp = x13Field.getText();
        x13Field.setText(x23Field.getText());
        x23Field.setText(tempTemp);
        tempTemp = result1Field.getText();
        result1Field.setText(result2Field.getText());
        result2Field.setText(tempTemp);
    }

    // Поменять первую и третью строку местами
    public void change1_3(){
        tempTemp = x11Field.getText();
        x11Field.setText(x31Field.getText());
        x31Field.setText(tempTemp);
        tempTemp = x12Field.getText();
        x12Field.setText(x32Field.getText());
        x32Field.setText(tempTemp);
        tempTemp = x13Field.getText();
        x13Field.setText(x33Field.getText());
        x33Field.setText(tempTemp);
        tempTemp = result1Field.getText();
        result1Field.setText(result3Field.getText());
        result3Field.setText(tempTemp);
    }

    // Поменять вторую и третью строку местами
    public void change2_3(){
        tempTemp = x21Field.getText();
        x21Field.setText(x31Field.getText());
        x31Field.setText(tempTemp);
        tempTemp = x22Field.getText();
        x22Field.setText(x32Field.getText());
        x32Field.setText(tempTemp);
        tempTemp = x23Field.getText();
        x23Field.setText(x33Field.getText());
        x33Field.setText(tempTemp);
        tempTemp = result2Field.getText();
        result2Field.setText(result3Field.getText());
        result3Field.setText(tempTemp);
    }
}
