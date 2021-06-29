package com.aplication.calculadorautilitis.ui.calculadora;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.aplication.calculadorautilitis.R;

public class CalculadoraFragment extends Fragment {
    private Button button_num_1;
    private Button button_num_2;
    private Button button_num_3;
    private Button button_num_4;
    private Button button_num_5;
    private Button button_num_6;
    private Button button_num_7;
    private Button button_num_8;
    private Button button_num_9;
    private Button button_num_0;
    private Button button_num_suma;
    private Button button_num_resta;
    private Button button_num_multiplicacion;
    private Button button_num_division;
    private Button button_num_igual;
    private Button button_num_limpiar;
    private Button button_num_regresaruno;
    private TextView text_view_datos_info;
    private TextView text_view_datos_segundonumero;
    private TextView text_view_datos_result;
    private TextView text_view_datos_signo;
    private final char ADDITTION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;

    int entrada = 0;
    int num1 = 0;
    int num2 = 0;
    int salida = 0;
    int resultado = 0;
    int contador = 0;
    char operation;
    String datos;

    private CalculadoraViewModel calculadoraViewModel;

    public void button_1(){
        text_view_datos_info.setText(text_view_datos_info.getText()+"1");
    }
    public void button_2(){
        text_view_datos_info.setText(text_view_datos_info.getText()+"2");
    }
    public void button_3(){
        text_view_datos_info.setText(text_view_datos_info.getText()+"3");
    }
    public void button_4(){
        text_view_datos_info.setText(text_view_datos_info.getText()+"4");
    }
    public void button_5(){
        text_view_datos_info.setText(text_view_datos_info.getText()+"5");
    }
    public void button_6(){
        text_view_datos_info.setText(text_view_datos_info.getText()+"6");
    }
    public void button_7(){
        text_view_datos_info.setText(text_view_datos_info.getText()+"7");
    }
    public void button_8(){
        text_view_datos_info.setText(text_view_datos_info.getText()+"8");
    }
    public void button_9(){
        text_view_datos_info.setText(text_view_datos_info.getText()+"9");
    }

    public void button_0(){
        text_view_datos_info.setText(text_view_datos_info.getText()+"0");

    }
    public void button_suma(){
        compute();
        ACTION = ADDITTION;
        text_view_datos_result.setText(String.valueOf(val1)+"+");
        text_view_datos_info.setText(null);

    }
    public void button_resta(){
        compute();
        ACTION = SUBTRACTION;
        text_view_datos_result.setText(String.valueOf(val1)+"-");
        text_view_datos_info.setText(null);
    }

    public void button_multiplicacion(){
        compute();
        ACTION = MULTIPLICATION;
        text_view_datos_result.setText(String.valueOf(val1)+"*");
        text_view_datos_info.setText(null);

    }
    public void button_division(){
        compute();
        ACTION = DIVISION;
        text_view_datos_result.setText(String.valueOf(val1)+"/");
        text_view_datos_info.setText(null);

    }
    public void button_igual(){
        compute();
        ACTION = EQU;
        text_view_datos_result.setText(text_view_datos_result.getText().toString()+String.valueOf(val2)+"="+String.valueOf(val1));
        //text_view_datos_result.setText("NO SÉ, ESPERO HABERTE AYUDADO");
        text_view_datos_info.setText(null);
    }
    public void button_limpiar(){
        if(text_view_datos_info.getText().length()>0){
            CharSequence name = text_view_datos_info.getText().toString();
            text_view_datos_info.setText(name.subSequence(0,name.length()-1));

        }else{
            val1= Double.NaN;
            val2=Double.NaN;
            text_view_datos_info.setText(null);
            text_view_datos_result.setText(null);
        }
    }
    public void button_regresaruno(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calculadoraViewModel = new ViewModelProvider(this).get(CalculadoraViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calculadora, container, false);
        text_view_datos_info = (TextView) root.findViewById(R.id.text_dato_control);
        text_view_datos_segundonumero = (TextView) root.findViewById(R.id.text_datos_segundonumero);
        text_view_datos_result = (TextView) root.findViewById(R.id.text_datos_result);
        text_view_datos_signo = (TextView) root.findViewById(R.id.text_datos_signo);

        button_num_1 = (Button) root.findViewById(R.id.button_num_1);
        button_num_2 = (Button) root.findViewById(R.id.button_num_2);
        button_num_3 = (Button) root.findViewById(R.id.button_num_3);
        button_num_4 = (Button) root.findViewById(R.id.button_num_4);
        button_num_5 = (Button) root.findViewById(R.id.button_num_5);
        button_num_6 = (Button) root.findViewById(R.id.button_num_6);
        button_num_7 = (Button) root.findViewById(R.id.button_num_7);
        button_num_8 = (Button) root.findViewById(R.id.button_num_8);
        button_num_9 = (Button) root.findViewById(R.id.button_num_9);
        button_num_0 = (Button) root.findViewById(R.id.button_num_0);
        button_num_suma = (Button) root.findViewById(R.id.button_num_suma);
        button_num_resta = (Button) root.findViewById(R.id.button_num_resta);
        button_num_division = (Button) root.findViewById(R.id.button_num_division);
        button_num_multiplicacion = (Button) root.findViewById(R.id.button_num_multiplicacion);
        button_num_igual = (Button) root.findViewById(R.id.button_num_igual);
        button_num_regresaruno = (Button) root.findViewById(R.id.button_num_regresaruno);
        button_num_limpiar = (Button) root.findViewById(R.id.button_num_limpiar);


        //View view = inflater.inflate(R.layout.fragment_calculadora, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        /*
        calculadoraViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        */


        button_num_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_1();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_2();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_3();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_4();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_5();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_6();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_7();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_8();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_9();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_0();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_suma();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_resta();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_multiplicacion();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_division();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });

        button_num_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_igual();

            }
        });



        button_num_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_limpiar();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        button_num_regresaruno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_regresaruno();
                //System.out.println("BOTON 1 FUNCIONANDO");
            }
        });
        return root;
    }
    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(text_view_datos_info.getText().toString());
            switch (ACTION) {
                case ADDITTION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }
        }else{
            val1= Double.parseDouble(text_view_datos_info.getText().toString());
        }
    }

}