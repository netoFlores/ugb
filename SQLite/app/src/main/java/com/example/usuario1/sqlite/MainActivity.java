package com.example.usuario1.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ugb.UsuarioDAO;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private UsuarioDAO dao;
    private EditText nombre, apellido, email, clave;
    private Button btguardar, btlimpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new UsuarioDAO(this);
        nombre = (EditText) findViewById(R.id.txtNombre);
        apellido = (EditText) findViewById(R.id.txtApellido);
        email = (EditText) findViewById(R.id.txtEmail);
        clave = (EditText) findViewById(R.id.txtClave);

        btguardar = (Button) findViewById(R.id.btnGuardar);
        btlimpiar = (Button) findViewById(R.id.btnLimpiar);

        btguardar.setOnClickListener(this);

        btlimpiar.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnGuardar){
            String nombre2, apellido2, email2, clave2;
            nombre2  = nombre.getText().toString();
            apellido2 = apellido.getText().toString();
            email2 = email.getText().toString();
            clave2 = clave.getText().toString();

            long respuesta = dao.insertar(nombre2, apellido2, email2, clave2);

            if(respuesta > 0){
                Toast.makeText(this, "Se ingreso un registro", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "No Se pudo ingreso un registro", Toast.LENGTH_LONG).show();

            }
        }
    }
}
