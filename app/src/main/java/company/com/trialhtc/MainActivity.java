package company.com.trialhtc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String URL = "http://www.mocky.io/v2/56fa31e0110000f920a72134";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            FragmentList fragment = new FragmentList();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment, "FRAGMENT_LIST").commit();
        }

    }

}
