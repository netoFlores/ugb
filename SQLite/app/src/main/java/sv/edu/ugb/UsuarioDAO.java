package sv.edu.ugb;


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
}
