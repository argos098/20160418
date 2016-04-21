package com.example.a.t17_location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);
        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        List<String> providers = manager.getAllProviders();
        String str = "";
        for (int i = 0; i < providers.size(); i++) {
            str += "provide : " + providers.get(i) + " state : " +
                    manager.isProviderEnabled(providers.get(i)) + "\n";
        }
        textView.setText(str);

        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                String str = "lat : " + location.getLatitude();
                str += " log : " + location.getLongitude();
                str += " alt : " + location.getAltitude() + "\n";

                textView.append(str);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                0, 0, listener);
    }
}
