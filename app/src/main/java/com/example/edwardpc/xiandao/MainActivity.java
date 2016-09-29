package com.example.edwardpc.xiandao;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends ListActivity {

    /*private String mActivities[] = { "Image Targets", "Cylinder Targets",
            "Multi Targets", "User Defined Targets", "Object Reco", "Cloud Reco", "Text Reco",
            "Frame Markers", "Virtual Buttons","text","huadong","jiushizheyang"};*/
    Spinner mMonthSpinner;
    Spinner mYearSpinner;
    public void onCreate(Bundle savedInstanceState)
    {

         super.onCreate(savedInstanceState);
          /*   ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            R.layout.activities_list_text_view, mActivities);*/

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activities_list);

        // 初始化控件
        mMonthSpinner = (Spinner) findViewById(R.id.choosemonth);
        String[] mMonthItems = getResources().getStringArray(R.array.spinnermonth);
        ArrayAdapter<String> _MonthAdapter=new ArrayAdapter<String>(this,R.layout.select_spinner, mMonthItems);
        //绑定 Adapter到控件
        _MonthAdapter.setDropDownViewResource(R.layout.item_dialogspinselect);
        mMonthSpinner.setAdapter(_MonthAdapter);

        mYearSpinner = (Spinner) findViewById(R.id.chooseyear);
        String[] mYearItems = getResources().getStringArray(R.array.spinneryear);
        ArrayAdapter<String> _Adapter=new ArrayAdapter<String>(this,R.layout.select_spinner, mYearItems);
        //绑定 Adapter到控件
        _Adapter.setDropDownViewResource(R.layout.item_dialogspinselect);
        mYearSpinner.setAdapter(_Adapter);


        DiaryList.myDiray.add("20160521");
        DiaryList.Month="05";
        DiaryList.Year="2016";
        ABAdapter abAdapter = new ABAdapter(this,DiaryList.myDiray);;
        setListAdapter(abAdapter);
    }


    public void onListItemClick(ListView l, View v, int position, long id)
    {

        Intent intent = new Intent(this, EditActivity.class);

        switch (position)
        {
            case 0:
                intent.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.ImageTargets.ImageTargets");
                intent.putExtra("ABOUT_TEXT", "ImageTargets/IT_about.html");
                break;
            case 1:
                intent.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.CylinderTargets.CylinderTargets");
                intent.putExtra("ABOUT_TEXT", "CylinderTargets/CY_about.html");
                break;
            case 2:
                intent.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.MultiTargets.MultiTargets");
                intent.putExtra("ABOUT_TEXT", "MultiTargets/MT_about.html");
                break;
            case 3:
                intent.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.UserDefinedTargets.UserDefinedTargets");
                intent.putExtra("ABOUT_TEXT",
                        "UserDefinedTargets/UD_about.html");
                break;
            case 4:
                intent.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.ObjectRecognition.ObjectTargets");
                intent.putExtra("ABOUT_TEXT", "ObjectRecognition/OR_about.html");
                break;
            case 5:
                intent.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.CloudRecognition.CloudReco");
                intent.putExtra("ABOUT_TEXT", "CloudReco/CR_about.html");
                break;
            case 6:
                intent.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.TextRecognition.TextReco");
                intent.putExtra("ABOUT_TEXT", "TextReco/TR_about.html");
                break;
            case 7:
                intent.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.FrameMarkers.FrameMarkers");
                intent.putExtra("ABOUT_TEXT", "FrameMarkers/FM_about.html");
                break;
            case 8:
                intent.putExtra("ACTIVITY_TO_LAUNCH",
                        "app.VirtualButtons.VirtualButtons");
                intent.putExtra("ABOUT_TEXT", "VirtualButtons/VB_about.html");
                break;
        }

        startActivity(intent);

    }
}
