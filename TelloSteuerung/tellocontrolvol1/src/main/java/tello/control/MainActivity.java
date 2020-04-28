package tello.control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    //TabLayoutStuff
    private PagerAdapter adapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabItem state, control, video;

    //WifiStuff
    private Button bWifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TabLayoutStuff
         viewPager = findViewById(R.id.vp_tabcontent);
         tabLayout = findViewById(R.id.tabLayout);
         state = findViewById(R.id.tabi_state);
         control = findViewById(R.id.tabi_control);
         video = findViewById(R.id.tabi_video);
         adapter = new PagerAdapter(getSupportFragmentManager());
         viewPager.setAdapter(adapter);

         //Listener for TabLayout
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
         viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

         bWifi = findViewById(R.id.bAbout);

         bWifi.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Info about Berechtigungen", Toast.LENGTH_SHORT).show();
             }
         });



    }

    @Override
    protected void onStart() {
        super.onStart();
        //PermissionDialog perDia = new PermissionDialog();
       // perDia.show(getSupportFragmentManager(),"1");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
    }
}
