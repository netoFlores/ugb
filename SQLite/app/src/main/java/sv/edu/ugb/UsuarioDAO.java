package sv.edu.ugb;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDAO {
    public static final String TABLENAME = "usuario";
    private DBHELPER helper;
    private SQLiteDatabase db;

    public UsuarioDAO(Context context){
        helper = new DBHELPER(context);
        db = helper.getWritableDatabase();
    }
    /**
     * Metodo me ingresa un registra los datos en la tabla usuario
     * **/
    public long insertar(String nombre, String apellido, String email, String passwd){
        long outcome = -1;
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("apellido", apellido);
        valores.put("email", email);
        valores.put("clave", passwd);
        outcome = db.insert(TABLENAME, null, valores);
        return outcome;
    }

}
