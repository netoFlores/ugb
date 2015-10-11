package neto.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CAST
        final EditText txtValor1  = (EditText) findViewById(R.id.txtValor1);
        final EditText txtValor2 = (EditText) findViewById(R.id.txtValor2);
        final TextView txtResultado = (TextView) findViewById(R.id.lbResultado);
        Button btnSumar = (Button) findViewById(R.id.btnSumar);
        Button btnRestar = (Button) findViewById(R.id.btnResta);
        Button btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        Button btnDividir = (Button) findViewById(R.id.btnDividir);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Entrada
                int val = Integer.parseInt(txtValor1.getText().toString());
                int val2 = Integer.parseInt(txtValor2.getText().toString());
                //Proceso
                Integer resul = val + val2;
                //Salida
                txtResultado.setText(resul.toString());





            }
        });

       btnRestar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int valor = Integer.parseInt(txtValor1.getText().toString());
               int valor2 = Integer.parseInt(txtValor2.getText().toString());

               Integer resultado = valor - valor2;

               txtResultado.setText(resultado.toString());

           }
       });
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valor= Integer.parseInt(txtValor1.getText().toString());
                int valor2= Integer.parseInt(txtValor2.getText().toString());

                Integer resultado = valor * valor2;
                txtResultado.setText(resultado.toString());
            }
        });
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valor= Integer.parseInt(txtValor1.getText().toString());
                int valor2= Integer.parseInt(txtValor2.getText().toString());

                Integer resultado = valor / valor2;
                txtResultado.setText(resultado.toString());
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R
                .menu.menu_main, menu);
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
