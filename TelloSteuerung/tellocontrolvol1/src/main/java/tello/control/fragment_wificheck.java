package tello.control;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_wificheck extends Fragment implements View.OnClickListener {

    private Button checkWifi;

    public fragment_wificheck() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wificheck, container, false);
        checkWifi = view.findViewById(R.id.bGetWifi);
        checkWifi.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onClick(View v) {
       Log.d("Tag1", "HIER");
        if(v.getId()==checkWifi.getId()){
            WifiManager wifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService (getActivity().getApplicationContext().WIFI_SERVICE);
            WifiInfo info = wifiManager.getConnectionInfo ();
            String ssid  = info.getSSID();
            Log.d("Tag1", "Pressed");
            Log.d("Tag1", ssid);
            TextView tv = getActivity().findViewById(R.id.tvWifiName);
            tv.setText(ssid);
        }
    }
}
