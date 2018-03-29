package ca.bgoodfellow.textswitcher;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {
    private TextSwitcher switcher;
    private int counter = 0;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switcher = findViewById(R.id.switcher);

        // Set the factory used to create TextViews to switch between.
        switcher.setFactory(mFactory);


        // Set the in and out animations.
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        switcher.setInAnimation(in);
        switcher.setOutAnimation(out);

        nextButton = findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter++;
                switcher.setText(String.valueOf(counter));
            }
        });

        // Set the initial text
        switcher.setCurrentText(String.valueOf(counter));

    }


    //The ViewFactory used to create TextViews that the will switch between.
    private ViewFactory mFactory = new ViewFactory() {

        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView(MainActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(MainActivity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };
}
