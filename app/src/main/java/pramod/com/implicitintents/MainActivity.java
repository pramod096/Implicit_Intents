package pramod.com.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.InetAddresses;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText url;
    private Button btn;
    private EditText maps;
    private Button mapsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = findViewById(R.id.editTextTextPersonName);
        btn = findViewById(R.id.button2);
        maps = findViewById(R.id.editTextTextPersonName2);
        mapsBtn = findViewById(R.id.button3);
        
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openURL();
            }
        });

        mapsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMaps();
            }
        });
    }

    private void openMaps() {
        Intent m = new Intent();
        m.setAction(Intent.ACTION_VIEW);
        String add = maps.getText().toString();
        m.setData(Uri.parse("geo:0,0?q="+add));

        startActivity(m);
    }

    private void openURL() {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        String link = url.getText().toString();
        i.setData(Uri.parse("https://"+link));

        startActivity(i);
    }
}