package com.owntaks.mahbub.androidjason.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.owntaks.mahbub.androidjason.R;


public class DetailActivity extends AppCompatActivity {


    TextView name,age,blgroup,mnum,loc,ibdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = findViewById(R.id.namedet);
        age = findViewById(R.id.agedet);
        blgroup = findViewById(R.id.blooddet);
        mnum = findViewById(R.id.mobiledet);
        loc = findViewById(R.id.locdet);
        ibdd = findViewById(R.id.lastdonadet);



        String _name = getIntent().getStringExtra("NAME_KEY");
        String _age = getIntent().getStringExtra("AGE");
        String _blgroup = getIntent().getStringExtra("BLGROUP");
        String _mnum = getIntent().getStringExtra("MNUM");
        String _loc = getIntent().getStringExtra("LOC");
        String _ibdd = getIntent().getStringExtra("IBDD");



        name.setText(_name);
        age.setText(_age);
        blgroup.setText(_blgroup);
        mnum.setText(_mnum);
        loc.setText(_loc);
        ibdd.setText(_ibdd);


    }
}
