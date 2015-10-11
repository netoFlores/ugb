package neto.holamundo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    EditText texto1;
    EditText texto2;
    TextView resultado;
    Spinner spinner;
    Integer select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto1 = (EditText) findViewById(R.id.editTxt1);
        texto2 = (EditText) findViewById(R.id.editTxt2);
        resultado = (TextView) findViewById(R.id.txtResultado);
        spinner = (Spinner) findViewById(R.id.spinner);
        resultado.setText("Hola Mundo");

        //Llenar el spinner
        String[] datos = new String[]{"Suma", "Resta", "Multiplicar", "Dividir"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item, datos);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);

        //Capturar el dato selecionado en el spinner
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        select = position;
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );
    }

    public void Operaciones(View view){
        Double valor1 = Double.parseDouble(texto1.getText().toString());
        Double valor2 = Double.parseDouble(texto2.getText().toString());
        Double respuesta = 0.0;

        switch (select){
            case 0:
                respuesta = valor1 + valor2;
                break;
            case 1:
                respuesta = valor1 - valor2;
                break;
            case 2:
                respuesta = valor1 * valor2;
                break;
            case 3:
                respuesta = valor1 / valor2;
                break;
        }

        resultado.setText(respuesta.toString());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
