package tan.stucom.com.practicasetting;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    EditText edName;
    EditText edMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        edName = findViewById(R.id.edName);
        edMail = findViewById(R.id.edMail);
    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        String name = prefs.getString("name", "");
        edName.setText(name);
        String email = prefs.getString("e-mail","");
        edMail.setText(email);
    }

    @Override
    public void onPause(){
        super.onPause();
        String name = edName.getText().toString();
        String email = edMail.getText().toString();
        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putString("name", name);
        ed.putString("e-mail",email);
        ed.apply();

    }
}
