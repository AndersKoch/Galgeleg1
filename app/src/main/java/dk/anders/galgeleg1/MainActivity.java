package dk.anders.galgeleg1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public ImageView visGalge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visGalge = findViewById(R.id.visGalge);
    }

public void billedeChanger() {


}
}
