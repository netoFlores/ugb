package sv.edu.ugb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHELPER extends SQLiteOpenHelper {

    public static final String DBNAME = "ugb.sqlite";
    public static final int DBVERSION = 1;

    public static final String USUARIONAME = "CREATE TABLE usuario(_id integer primary key AUTOINCREMENT, " +
            " nombre text not null, apellido text not null, " +
            " email text not null, clave text not null);";

    public DBHELPER(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USUARIONAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
