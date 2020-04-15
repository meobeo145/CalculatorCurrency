package com.example.calculatorcurrency;

import android.app.Activity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.graphics.Typeface;


public class MainActivity extends Activity implements View.OnClickListener {

    private TextView tv_changeMoney;
    private TextView tvMoneyIn;
    private TextView tvMoneyOut;
    Spinner spinner1, spinner2;
    float temp;
    private int[] idButton = {
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9, R.id.btnDot, R.id.btnCE,
            R.id.btnBS
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface tvFont = Typeface.createFromAsset(getAssets(), "fonts/DS-DIGIT.TTF");
        tvMoneyIn = findViewById(R.id.tvMoneyIn);
        tvMoneyIn.setTypeface(tvFont);
        tvMoneyOut = findViewById(R.id.tvMoneyOut);
        tvMoneyOut.setTypeface(tvFont);

        tv_changeMoney = findViewById(R.id.tv_changeMoney);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        String[] arrMoney = {"Vietnam - Dong" ,"US - Dollar" ,"Europe - Euro" ,"Japan - Yen" ,"Korea - Won"};

        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                arrMoney
        );
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        for (int i = 0; i < idButton.length; i++) {
            findViewById(idButton[i]).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())  {
            case R.id.btn0:
                if(Integer.parseInt(tvMoneyIn.getText().toString()) == 0)
                    tvMoneyIn.setText("");
                tvMoneyIn.append("0");
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
                break;
            case R.id.btn1:
                addDigits("1");
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
                break;
            case R.id.btn2:
                if(Integer.parseInt(tvMoneyIn.getText().toString()) == 0)
                    tvMoneyIn.setText("");
                tvMoneyIn.append("2");
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
                break;
            case R.id.btn3:
                if(Integer.parseInt(tvMoneyIn.getText().toString()) == 0)
                    tvMoneyIn.setText("");
                tvMoneyIn.append("3");
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
                break;
            case R.id.btn4:
                if(Integer.parseInt(tvMoneyIn.getText().toString()) == 0)
                    tvMoneyIn.setText("");
                tvMoneyIn.append("4");
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
                break;
            case R.id.btn5:
                if(Integer.parseInt(tvMoneyIn.getText().toString()) == 0)
                    tvMoneyIn.setText("");
                tvMoneyIn.append("5");
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
                break;
            case R.id.btn6:
                if(Integer.parseInt(tvMoneyIn.getText().toString()) == 0)
                    tvMoneyIn.setText("");
                tvMoneyIn.append("6");
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
                break;
            case R.id.btn7:
                if(Integer.parseInt(tvMoneyIn.getText().toString()) == 0)
                    tvMoneyIn.setText("");
                tvMoneyIn.append("7");
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
                break;
            case R.id.btn8:
                if(Integer.parseInt(tvMoneyIn.getText().toString()) == 0)
                    tvMoneyIn.setText("");
                tvMoneyIn.append("8");
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
                break;
            case R.id.btn9:
                if(Integer.parseInt(tvMoneyIn.getText().toString()) == 0)
                    tvMoneyIn.setText("");
                tvMoneyIn.append("9");
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
                break;
            case R.id.btnCE:
                if(Integer.parseInt(tvMoneyIn.getText().toString()) == 0)
                    tvMoneyIn.setText("");
                tvMoneyIn.setText("0");
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
                break;
            case R.id.btnBS:
                String numberAfterBS = deleteANumber(tvMoneyIn.getText().toString());
                if (numberAfterBS.length() == 0) tvMoneyIn.setText("0");
                else tvMoneyIn.setText(numberAfterBS);
                changeMoney(spinner1.getSelectedItem().toString(), spinner2.getSelectedItem().toString(), Float.parseFloat(tvMoneyIn.getText().toString()));
                break;
            case R.id.btnDot:
                addDigits(".");
                break;
        }
    }
    public  String deleteANumber(String number)  {
        int length = number.length();
        String tmp = number.substring(0, length - 1);
        return tmp;
    }

    private void addDigits(String digit){
        if(Float.parseFloat(tvMoneyIn.getText().toString())==0)
            tvMoneyIn.setText("");
        tvMoneyIn.append(digit);
    }

    @SuppressLint("SetTextI18n")
    private void changeMoney(String moneyIn, String moneyOut, float source)  {
        if (moneyIn.equals("Vietnam - Dong") && moneyOut.equals("Vietnam - Dong"))  {
            temp = 1.f;
            tv_changeMoney.setText("1 VND = "+ temp+" VND");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Vietnam - Dong") && moneyOut.equals("US - Dollar"))  {
            temp = 0.00004266f;
            tv_changeMoney.setText("1 VND = "+ temp+" USA");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Vietnam - Dong") && moneyOut.equals("Europe - Euro"))  {
            temp = 0.00003902f;
            tv_changeMoney.setText("1 VND = "+ temp+" EUR");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Vietnam - Dong") && moneyOut.equals("Japan - Yen"))  {
            temp = 0.004578f;
            tv_changeMoney.setText("1 VND = "+ temp+" JPY");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Vietnam - Dong") && moneyOut.equals("Korea - Won"))  {
            temp = 0.05209f;
            tv_changeMoney.setText("1 VND = "+ temp+" KRW");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }


        if (moneyIn.equals("US - Dollar") && moneyOut.equals("US - Dollar"))  {
            temp = 1.f;
            tv_changeMoney.setText("1 USA = "+ temp+" USA");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("US - Dollar") && moneyOut.equals("Vietnam - Dong"))  {
            temp = 23440.f;
            tv_changeMoney.setText("1 USA = "+ temp+" VND");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("US - Dollar") && moneyOut.equals("Europe - Euro"))  {
            temp = 0.9147f;
            tv_changeMoney.setText("1 USA = "+ temp+" EUR");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("US - Dollar") && moneyOut.equals("Japan - Yen"))  {
            temp = 107.31f;
            tv_changeMoney.setText("1 USA = "+ temp+" JPY");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("US - Dollar") && moneyOut.equals("Korea - Won"))  {
            temp = 1220.99f;
            tv_changeMoney.setText("1 USA = "+ temp+" KRW");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }


        if (moneyIn.equals("Europe - Euro") && moneyOut.equals("Europe - Euro"))  {
            temp = 1.f;
            tv_changeMoney.setText("1 EUR = "+ temp+" EUR");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Europe - Euro") && moneyOut.equals("Vietnam - Dong"))  {
            temp = 25625.8883f;
            tv_changeMoney.setText("1 EUR = "+ temp+" VND");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Europe - Euro") && moneyOut.equals("US - Dollar"))  {
            temp = 1.0933f;
            tv_changeMoney.setText("1 EUR = "+ temp+" USA");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Europe - Euro") && moneyOut.equals("Japan - Yen"))  {
            temp = 117.3172f;
            tv_changeMoney.setText("1 EUR = "+ temp+" JPY");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Europe - Euro") && moneyOut.equals("Korea - Won"))  {
            temp = 1334.853f;
            tv_changeMoney.setText("1 EUR = "+ temp+" KRW");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }


        if (moneyIn.equals("Japan - Yen") && moneyOut.equals("Japan - Yen"))  {
            temp = 1.f;
            tv_changeMoney.setText("1 JPY = "+ temp+" VND");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Japan - Yen") && moneyOut.equals("Vietnam - Dong"))  {
            temp = 218.4326f;
            tv_changeMoney.setText("1 JPY = "+ temp+" VND");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Japan - Yen") && moneyOut.equals("Europe - Euro"))  {
            temp = 0.008524f;
            tv_changeMoney.setText("1 JPY = "+ temp+" EUR");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Japan - Yen") && moneyOut.equals("US - Dollar"))  {
            temp = 0.009319f;
            tv_changeMoney.setText("1 JPY = "+ temp+" USA");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Japan - Yen") && moneyOut.equals("Korea - Won"))  {
            temp = 11.3782f;
            tv_changeMoney.setText("1 JPY = "+ temp+" KRW");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }


        if (moneyIn.equals("Korea - Won") && moneyOut.equals("Korea - Won"))  {
            temp = 1.f;
            tv_changeMoney.setText("1 KRW = "+ temp+" KRW");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Korea - Won") && moneyOut.equals("Vietnam - Dong"))  {
            temp = 19.1975f;
            tv_changeMoney.setText("1 KRW = "+ temp+" VND");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Korea - Won") && moneyOut.equals("Europe - Euro"))  {
            temp = 0.0007491f;
            tv_changeMoney.setText("1 KRW = "+ temp+" EUR");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Korea - Won") && moneyOut.equals("Japan - Yen"))  {
            temp = 0.08789f;
            tv_changeMoney.setText("1 KRW = "+ temp+" JPY");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }
        if (moneyIn.equals("Korea - Won") && moneyOut.equals("US - Dollar"))  {
            temp = 0.000819f;
            tv_changeMoney.setText("1 KRW = "+ temp+" USA");
            tvMoneyOut.setText(String.valueOf(temp * source));
        }

    }
}

