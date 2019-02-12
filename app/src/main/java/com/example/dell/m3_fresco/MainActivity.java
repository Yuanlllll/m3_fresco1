package com.example.dell.m3_fresco;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_yuanjiao;
    private Button btn_yuanxing;
    private Button btn_bili;
    private Button btn_jianjin;
    private Button btn_dong;
    private SimpleDraweeView simple_view;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn_yuanjiao = findViewById(R.id.btn_yuanjiao);
        btn_yuanxing = findViewById(R.id.btn_yuanxing);
        btn_bili = findViewById(R.id.btn_bili);
        btn_jianjin = findViewById(R.id.btn_jianjin);
        simple_view = findViewById(R.id.simple_view);
        btn_dong = findViewById(R.id.btn_dong);

        btn_yuanjiao.setOnClickListener(this);
        btn_yuanxing.setOnClickListener(this);
        btn_bili.setOnClickListener(this);
        btn_jianjin.setOnClickListener(this);
        btn_dong.setOnClickListener(this);



    }

    private void init()
    {
        uri = Uri.parse("http://img4.imgtn.bdimg.com/it/u=2584422743,1020351689&fm=26&gp=0.jpg");
        simple_view = findViewById(R.id.simple_view);
        simple_view.setImageURI(uri);

    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_yuanjiao:
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(15f);
                simple_view.getHierarchy().setRoundingParams(roundingParams);
                break;
            case R.id.btn_yuanxing:
                RoundingParams roundingParams1 = RoundingParams.fromCornersRadius(2f);
                roundingParams1.setRoundAsCircle(true);
                simple_view.getHierarchy().setRoundingParams(roundingParams1);
                break;
            case R.id.btn_bili:
                simple_view.setAspectRatio(1.2f);
                break;
            case R.id.btn_jianjin:

                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setProgressiveRenderingEnabled(true)
                        .build();
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(simple_view.getController())
                        .build();
                simple_view.setController(controller);
                break;
            case R.id.btn_dong:
                DraweeController controller1 = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setAutoPlayAnimations(true)
                        .build();
                simple_view.setController(controller1);
                break;
        }

    }
}
