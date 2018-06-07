package com.example.utsav.advancerecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.utsav.advancerecycleview.adapter.DesignAdapter;
import com.example.utsav.advancerecycleview.adapter.FabricAdapter;
import com.example.utsav.advancerecycleview.adapter.ImageSelectedAdapter;
import com.example.utsav.advancerecycleview.model.Design;
import com.example.utsav.advancerecycleview.model.Fabric;
import com.example.utsav.advancerecycleview.model.ImageSelected;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DesignAdapter.DesignListener, FabricAdapter.FabricListener {
    private RecyclerView rvData, rvImageSelected;
    private Button fabric, design;
    private ArrayList<Design> designArrayList = new ArrayList<>();
    private ArrayList<Fabric> fabricArrayList = new ArrayList<>();
    private ArrayList<ImageSelected> selectedArrayList = new ArrayList<>();
    private FabricAdapter fabricAdapter;
    private DesignAdapter designAdapter;
    private ImageSelectedAdapter imageSelectedAdapter;
    int image[] = {R.drawable.download1, R.drawable.download2, R.drawable.download3,
            R.drawable.download4, R.drawable.download5, R.drawable.download6};
    int fabricimage[] = {R.drawable.download7, R.drawable.download8, R.drawable.download9, R.drawable.download10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabric = findViewById(R.id.buttonfabric);
        design = findViewById(R.id.buttonDesign);
        rvData = findViewById(R.id.rvshowData);
        rvImageSelected = findViewById(R.id.rvselected);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView.LayoutManager layoutManagerVertical = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rvData.setLayoutManager(layoutManager);
        rvImageSelected.setLayoutManager(layoutManagerVertical);
        createDesignData();
        designAdapter = new DesignAdapter(this, designArrayList, MainActivity.this);
        imageSelectedAdapter = new ImageSelectedAdapter(this, selectedArrayList);
        rvData.setAdapter(designAdapter);
        rvImageSelected.setAdapter(imageSelectedAdapter);
        fabric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabricArrayList.clear();

                createFabricData();
                    for (int j = 0; j <selectedArrayList.size() ; j++) {
                        if (selectedArrayList.get(j).isFabric()){

                        }
                    }

                fabricAdapter = new FabricAdapter(MainActivity.this, fabricArrayList, MainActivity.this);
                rvData.setAdapter(fabricAdapter);
            }
        });
        design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                designArrayList.clear();
                createDesignData();

                designAdapter = new DesignAdapter(MainActivity.this, designArrayList, MainActivity.this);
                rvData.setAdapter(designAdapter);
            }
        });
    }

    private void createDesignData() {
        for (int i = 0; i < 6; i++) {


            Design design = new Design();
            design.setName("utsav shah" + i);
            design.setDesign(false);
            design.setImage(image[i]);
            designArrayList.add(design);

        }
    }

    private void createFabricData() {
        for (int i = 0; i < 4; i++) {


            Fabric fabric = new Fabric();
            fabric.setName("utsav shah" + i);
            fabric.setFabric(false);
            fabric.setImage(fabricimage[i]);
            fabricArrayList.add(fabric);

        }
    }

    @Override
    public void onDesignClicked(Design post, int position) {
        ImageSelected imageSelected = new ImageSelected();
        imageSelected.setImage(post.getImage());
        imageSelected.setDesign(true);
        imageSelected.setPosition(position);
        selectedArrayList.add(imageSelected);
    }

    @Override
    public void onFabricClicked(Fabric post, int position) {
        ImageSelected imageSelected = new ImageSelected();
        imageSelected.setImage(post.getImage());
        imageSelected.setFabric(true);
        imageSelected.setPosition(position);
        selectedArrayList.add(imageSelected);
    }
}
