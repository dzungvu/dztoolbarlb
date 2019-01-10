package com.vtdung.dztoolbar.dztoolbar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.vtdung.dztoolbar.dztoolbarlb.listener.DztoolbarClickListener;
import com.vtdung.dztoolbar.dztoolbarlb.views.DzToolbar;

public class MainActivity extends AppCompatActivity implements DztoolbarClickListener {

    private DzToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("This is the title");
        toolbar.setLeftImage(ContextCompat.getDrawable(this, R.drawable.ic_back));
        toolbar.addClickListener(this);
    }

    @Override
    public void leftClickListener() {
        Toast.makeText(this, "Back press", Toast.LENGTH_LONG).show();
    }

    @Override
    public void rightClickListener() {

    }
}
