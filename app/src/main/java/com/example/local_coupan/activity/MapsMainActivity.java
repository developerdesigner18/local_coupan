package com.example.local_coupan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;
import com.example.local_coupan.databinding.ActivityMapsMainBinding;
import com.example.local_coupan.preferences2;

import java.io.File;


public class MapsMainActivity extends AppCompatActivity {

    ActivityMapsMainBinding binding;
    private static final int REQUEST_PERMISSION_CODE = 101;
    preferences2 preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkPermission(); // for getting usr permission.
        locationEnabled(); // Enable location on your device

//        getAndroidVersion(); //Check devise SDK version

//        binding.cardLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                preferences.save(MapsMainActivity.this, preferences.KEY_ID, String.valueOf(""));
//                Intent get_login = new Intent(MapsMainActivity.this, login_screen.class);
//                get_login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(get_login);
//            }
//        });

        binding.lloutShowcoupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_coupon = new Intent(MapsMainActivity.this, MainActivity.class);
                get_coupon.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_coupon);
            }
        });

        binding.lloutScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_scan = new Intent(MapsMainActivity.this, Scanner_activity.class);
                get_scan.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(get_scan);
            }
        });

//        binding.generatePdf.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                createandDisplayPdf("Demo Pdf Generator Project");
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit?")
                .setMessage("Thank you for using our app. Press the OK button to exit.")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        startActivity(intent);
                    }
                }).create().show();
    }

    @SuppressLint("ObsoleteSdkInt")
    public void checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) ==
                            PackageManager.PERMISSION_GRANTED) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION
                        },
                        1);
            }
        }
    }

    private void locationEnabled() {
        LocationManager lm = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!gps_enabled && !network_enabled) {
            new AlertDialog.Builder(MapsMainActivity.this)
                    .setMessage("GPS Enable")
                    .setPositiveButton("Settings", new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                                }
                            })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            locationEnabled();
                        }
                    })
                    .show();
        }
    }
//    public void getAndroidVersion() {
//        String release = Build.VERSION.RELEASE;
//        int sdkVersion = Build.VERSION.SDK_INT;
//        Log.d("sdk version1111", "getAndroidVersion: " + sdkVersion);
//        Log.d("sdk version1111", "getAndroidVersion: " + release);
//
//    }
//public void createandDisplayPdf(String text) {
//
//    Document doc = new Document();
//
//    try {
//        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Dir";
//
//        File dir = new File(path);
//        if(!dir.exists())
//            dir.mkdirs();
//
//        File file = new File(dir, "newFile.pdf");
//        FileOutputStream fOut = new FileOutputStream(file);
//
//        PdfWriter.getInstance(doc, fOut);
//
//        //open the document
//        doc.open();
//
//        Paragraph p1 = new Paragraph(text);
//        Font paraFont= new Font(Font.COURIER);
//        p1.setAlignment(Paragraph.ALIGN_CENTER);
//        p1.setFont(paraFont);
//
//        //add paragraph to document
//        doc.add(p1);
//
//    } catch (DocumentException de) {
//        Log.e("PDFCreator", "DocumentException:" + de);
//    } catch (IOException e) {
//        Log.e("PDFCreator", "ioException:" + e);
//    }
//    finally {
//        doc.close();
//    }
//
//    viewPdf("newFile.pdf", "Dir");
//}

    // Method for opening a pdf file
    private void viewPdf(String file, String directory) {

        File pdfFile = new File(Environment.getExternalStorageDirectory() + "/" + directory + "/" + file);
        Uri path = Uri.fromFile(pdfFile);

        // Setting the intent for pdf reader
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try {
            startActivity(pdfIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(MapsMainActivity.this, "Can't read pdf file", Toast.LENGTH_SHORT).show();
        }
    }
}