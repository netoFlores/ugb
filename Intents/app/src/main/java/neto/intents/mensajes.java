package neto.intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class mensajes extends Activity implements View.OnClickListener {
    private Button btnLlamar;
    private EditText numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajes);
        numero = (EditText) findViewById(R.id.txtNumero);
        btnLlamar = (Button) findViewById(R.id.btnLlamar);
        btnLlamar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mensajes, menu);
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
        if(v.getId() == R.id.btnLlamar){
            llamar(numero.getText().toString());
        }
    }

    private void llamar(String numero){
        Uri uri = Uri.parse("tel:"+numero);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        startActivity(intent);
    }
}
