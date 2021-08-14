package unimagdalena.project.com.otrapracticamas.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.widget.ImageView;
import android.widget.Toast;

import unimagdalena.project.com.otrapracticamas.R;


public class MainActivity4 extends AppCompatActivity {
    private android.widget.RelativeLayout.LayoutParams layoutParams;
    String msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main4);
        ImageView imageView = (ImageView) findViewById(R.id.imageMove);
        CardView card = (CardView) findViewById(R.id.cardMove);

        if (card == null) {


            Toast.makeText(this, "Card Null", Toast.LENGTH_SHORT).show();

        } else {


        }

    }

}



