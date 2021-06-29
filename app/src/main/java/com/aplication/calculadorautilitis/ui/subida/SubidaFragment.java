package com.aplication.calculadorautilitis.ui.subida;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.aplication.calculadorautilitis.R;

import java.text.DecimalFormat;

public class SubidaFragment extends Fragment {
    private TextView text_descarga;
    private TextView text_velocidad;
    private TextView text_tiempo;
    private Spinner spinner_tam_descarga;
    private Spinner spinner_velocidad;
    private EditText text_edit_tam_descarga;
    private EditText text_edit_velocidad;
    private Button button_calcular;
    private Button button_limpiar;
    private SubidaViewModel subidaViewModel;
    public void calcular_tiempo(){
        try {
            int tam;
            double velocidad;
            int calcular;
            double tiempo;
            String tipotam = spinner_tam_descarga.getSelectedItem().toString();
            String tipovel = spinner_velocidad.getSelectedItem().toString();
            tam = Integer.parseInt(text_edit_tam_descarga.getText().toString());
            velocidad = Double.parseDouble(text_edit_velocidad.getText().toString());
            System.out.println("Get selecte item: "+tipotam);
            if (tipotam=="GB"){
                tam = tam*1000*1000;
                System.out.println("GB a KB: "+tam);
            }
            if (tipotam=="MB"){
                tam = tam*1000;
                System.out.println("GB a KB: "+tam);
            }
            if (tipotam=="KB"){
                tam = tam;
                System.out.println("GB a KB: "+tam);
            }

            if (tipovel=="GB") {
                velocidad= velocidad*1000*1000;
                tiempo = tam/velocidad;
                text_tiempo.setText(validar_tiempo(tiempo));
            }
            if (tipovel=="MB") {
                velocidad= velocidad*1000;
                tiempo = tam/velocidad;
                text_tiempo.setText(validar_tiempo(tiempo));
            }
            if (tipovel=="KB") {
                tiempo = tam/velocidad;
                text_tiempo.setText(validar_tiempo(tiempo));
            }


        }catch (Error r){
            System.out.println("Error: "+r.getMessage());
        }
    }
    public void limpiar(){
        text_edit_tam_descarga.setText("");
        text_edit_velocidad.setText("");
        text_tiempo.setText("");
    }
    public String validar_tiempo(double t){
        String r;
        DecimalFormat format = new DecimalFormat("#.00");
        if (t>60){
            t=t/60;
            r = format.format(t)+" Minutos";
            if (t>60){
                t= t/60;
                r = format.format(t)+" Horas";
            }
            return r;
        }else{
            r = format.format(t)+" Segundos";
            //r = t+" Segundos";
            return r;
        }
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        subidaViewModel =
                new ViewModelProvider(this).get(SubidaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_subida, container, false);
        text_tiempo = (TextView) root.findViewById(R.id.text_view_tiempo_de_descarga);
        text_edit_tam_descarga = (EditText) root.findViewById(R.id.text_tam_descarga);
        text_edit_velocidad =(EditText) root.findViewById(R.id.text_velocidad);
        spinner_tam_descarga = (Spinner) root.findViewById(R.id.spinner_tam_tipo);
        spinner_velocidad = (Spinner) root.findViewById(R.id.spinner_velocidad_tipo);
        button_calcular = (Button) root.findViewById(R.id.button_num_calcular);
        button_limpiar = (Button) root.findViewById(R.id.button_num_limpiar);
        String[] tipo = {"GB","MB","KB"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, tipo);
        spinner_tam_descarga.setAdapter(adapter);
        spinner_velocidad.setAdapter(adapter);
        button_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
        button_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular_tiempo();
            }
        });

        return root;
    }
}