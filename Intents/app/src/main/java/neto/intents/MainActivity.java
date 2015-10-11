package neto.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {
    public static final String USUARIO = "neto";
    public static final String PASSWD = "miclave";

    private Button btnLLamar;
    private EditText txtUsuario, txtPasswd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtPasswd = (EditText) findViewById(R.id.txtPass);
        btnLLamar = (Button) findViewById(R.id.btnParametros);
        btnLLamar.setOnClickListener(this);
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
        if(v.getId() == R.id.btnParametros){
            if(txtUsuario.getText().toString().equals(USUARIO) &&
                    txtPasswd.getText().toString().equals(PASSWD)) {
                Intent intent = new Intent(this, mensajes.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Usuario o clave invalida", Toast.LENGTH_LONG).show();
            }
        }
    }
}
