package sg.edu.rp.c346.id20008787.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGpa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGpa = findViewById(R.id.editTextGPA);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putString("name", etName.getText().toString());
        prefEditor.putFloat("gpa", Float.parseFloat(etGpa.getText().toString()));
        prefEditor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString("name", "Unknown");
        float Gpa = prefs.getFloat("gpa", 0f);
        etName.setText(name);
        etGpa.setText(Gpa + "");
    }

}