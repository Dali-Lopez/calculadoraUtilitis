package com.aplication.calculadorautilitis.ui;

import android.os.Bundle;

import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.aplication.calculadorautilitis.R;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link datos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class datos extends Fragment {
    private Spinner tipo_de_dato;
    private EditText entrada;
    private Button button_calcular;
    private TextView text_kilobits;
    private TextView text_kilobytes;
    private TextView text_megabits;
    private TextView text_megabytes;
    private TextView text_gigabits;
    private TextView text_gigabytes;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public datos() {
        // Required empty public constructor
    }
    public void convertir_dato(double dato,String valortipo){
        double r = 0;
        DecimalFormat format = new DecimalFormat("#.00000000");
        String valorConvertido=null;
        String valor= "EQ";
        valor = valortipo;
        double Kb;
        double KB;
        double Mb;
        double MB;
        double Gb;
        double GB;
        switch (valor)
        {
            case "Kb":
                GB=(dato/1000000)*8;
                Gb=dato/1000000;
                MB=(dato/1000)/8;
                Mb=dato/1000;
                KB=dato/8;
                Kb=dato;
                text_kilobits.setText(Kb+" Kb");
                text_kilobytes.setText(KB+" KB");
                text_megabits.setText(format.format(Mb)+" Mb");
                text_megabytes.setText(format.format(MB)+" MB");
                text_gigabits.setText(format.format(Gb)+" Gb");
                text_gigabytes.setText(format.format(GB)+" GB");
                System.out.println("Kilobits: "+r);
                break;
            case "KB":
                GB=dato/1000000;
                Gb=GB*8;
                MB=dato/1000;
                Mb=MB*8;
                KB=MB*1000;
                Kb=KB*8;
                text_kilobits.setText(Kb+" Kb");
                text_kilobytes.setText(KB+" KB");
                text_megabits.setText(Mb+" Mb");
                text_megabytes.setText(MB+" MB");
                text_gigabits.setText(format.format(Gb)+" Gb");
                text_gigabytes.setText(format.format(GB)+" GB");
                System.out.println("Kilobytes: "+r);
                break;
            case "Mb":
                GB=(dato/1000)/8;
                Gb=GB*8;
                MB=dato/8;
                Mb=dato;
                KB=MB*1000;
                Kb=KB*8;
                text_kilobits.setText(Kb+" Kb");
                text_kilobytes.setText(KB+" KB");
                text_megabits.setText(Mb+" Mb");
                text_megabytes.setText(MB+" MB");
                text_gigabits.setText(Gb+" Gb");
                text_gigabytes.setText(format.format(GB)+" GB");
                System.out.println("Megabits: "+r);
                //r = (dato*1000)/
                break;
            case "MB":
                GB=dato/1000;
                Gb=GB*8;
                MB=dato;
                Mb=MB*8;
                KB=MB*1000;
                Kb=KB*8;
                text_kilobits.setText(Kb+" Kb");
                text_kilobytes.setText(KB+" KB");
                text_megabits.setText(Mb+" Mb");
                text_megabytes.setText(MB+" MB");
                text_gigabits.setText(Gb+" Gb");
                text_gigabytes.setText(GB+" GB");
                System.out.println("Megabytes: "+r);
                break;
            case "Gb":
                GB=dato/8;
                Gb=dato;
                MB=GB*1000;
                Mb=MB*8;
                KB=MB*1000000;
                Kb=KB*8;
                text_kilobits.setText(Kb+" Kb");
                text_kilobytes.setText(KB+" KB");
                text_megabits.setText(Mb+" Mb");
                text_megabytes.setText(MB+" MB");
                text_gigabits.setText(Gb+" Gb");
                text_gigabytes.setText(GB+" GB");
                System.out.println("Gigabits: "+r);
                break;
            case "GB":
                GB=dato;
                Gb=GB*8;
                MB=GB*1000;
                Mb=MB*8;
                KB=GB*1000000;
                Kb=KB*8;
                text_kilobits.setText(Kb+" Kb");
                text_kilobytes.setText(KB+" KB");
                text_megabits.setText(Mb+" Mb");
                text_megabytes.setText(MB+" MB");
                text_gigabits.setText(Gb+" Gb");
                text_gigabytes.setText(GB+" GB");
                System.out.println("Gigabytes: "+r);
                break;
        }
        dato = r;
        format.format(dato);
        //return dato;
    }
    public void calcular_todo(){
        Double datoObtenido = Double.parseDouble(entrada.getText().toString());
        DecimalFormat format = new DecimalFormat("#.0000000000");
        Double kilobits;
        Double kilobyts;
        Double megabits;
        Double megabyts;
        Double gigabits;
        Double gigabytes;
        convertir_dato(datoObtenido,tipo_de_dato.getSelectedItem().toString());
        /*
        text_kilobits.setText(format.format( convertir_dato(val,"Kb"))+" Kb");
        text_kilobytes.setText(format.format(convertir_dato(val,"KB"))+" KB");
        text_megabits.setText(format.format(convertir_dato(val,"Mb"))+" Mb");
        text_megabytes.setText(format.format(convertir_dato(val,"MB"))+" MB");
        text_gigabits.setText(format.format(convertir_dato(val,"Gb"))+" Gb");
        text_gigabytes.setText(format.format(convertir_dato(val,"GB"))+" GB");
         */
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment datos.
     */
    // TODO: Rename and change types and number of parameters
    public static datos newInstance(String param1, String param2) {
        datos fragment = new datos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_datos, container, false);
        tipo_de_dato = (Spinner) root.findViewById(R.id.spinner_tipo_a_convertir);
        entrada = (EditText) root.findViewById(R.id.text_edit_valor);
        button_calcular = (Button) root.findViewById(R.id.button_calcular);
        text_kilobits = (TextView) root.findViewById(R.id.text_view_kilobits);
        text_kilobytes = (TextView) root.findViewById(R.id.text_view_kilobyes);
        text_megabits = (TextView) root.findViewById(R.id.text_view_megabits);
        text_megabytes = (TextView) root.findViewById(R.id.text_view_megabytes);
        text_gigabits = (TextView) root.findViewById(R.id.text_view_gigabits);
        text_gigabytes = (TextView) root.findViewById(R.id.text_view_gigabytes);
        String[] tipo = {"Kb","KB","Mb","MB","Gb","GB"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, tipo);
        tipo_de_dato.setAdapter(adapter);
        button_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular_todo();
            }
        });
        //return inflater.inflate(R.layout.fragment_datos, container, false);
        return root;
    }
}