package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import javax.xml.xpath.XPathExpression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textCalculation, textResult;
    private Button btnC, btnParentheses1, btnParentheses2, btnDelete, btn7, btn8,
            btn9, btn4, btn5, btn6, btn1, btn2, btn3, btn0, btnPoint, btnEqual,
            btnDiv, btnMul, btnSub, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCalculation = findViewById(R.id.text_calculation);
        textResult = findViewById(R.id.text_result);

        assignd_id(btn0, R.id.zero_btn);
        assignd_id(btn1, R.id.one_btn);
        assignd_id(btn2, R.id.two_btn);
        assignd_id(btn3, R.id.three_btn);
        assignd_id(btn4, R.id.four_btn);
        assignd_id(btn5, R.id.five_btn);
        assignd_id(btn6, R.id.six_btn);
        assignd_id(btn7, R.id.seven_btn);
        assignd_id(btn8, R.id.eight_btn);
        assignd_id(btn9, R.id.nine_btn);
        assignd_id(btnPoint, R.id.point_btn);
        assignd_id(btnParentheses1, R.id.parentheses1_btn);
        assignd_id(btnParentheses2, R.id.parentheses2_btn);
        assignd_id(btnEqual, R.id.equal_btn);
        assignd_id(btnDiv, R.id.div_btn);
        assignd_id(btnMul, R.id.mul_btn);
        assignd_id(btnAdd, R.id.add_btn);
        assignd_id(btnSub, R.id.sub_btn);
        assignd_id(btnC, R.id.c_btn);
        assignd_id(btnDelete, R.id.delete_btn);


    }


    private void assignd_id(Button btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;

        String buttonTxt = button.getText().toString();

        String dataToCalculate = textCalculation.getText().toString();



        if(buttonTxt.equals("C")){
            dataToCalculate = "";
            textResult.setText("0");
            textCalculation.setText(dataToCalculate);
            return;

        }
        if(buttonTxt.equals("=")){
            dataToCalculate = getResult(dataToCalculate);
            if (dataToCalculate.equals("Expression error")){
                textCalculation.setText(dataToCalculate);
                textResult.setText("");
            }
            else {
                textResult.setText(dataToCalculate);
                textCalculation.setText(textResult.getText());
            }

            return;
        }
        else { // others buttons
            if(buttonTxt.equals("D")){
                int length = dataToCalculate.length();
                if (length > 0){
                    dataToCalculate = dataToCalculate.substring(0, length - 1);}
                }
                else {
                dataToCalculate = dataToCalculate+buttonTxt;
                }
            textCalculation.setText(dataToCalculate);
        }

    }

    private String getResult(String data){
        String result = Calculator.evaluate(data);
        return result;
    }
}

