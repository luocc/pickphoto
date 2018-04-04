package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.myapplication.two.PickPhotoActivity;
import com.example.administrator.myapplication.two.MultiplexImage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ImageAdapter adapter;

    List<MultiplexImage> images;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.recyclerView);

        if (images == null) images = new ArrayList<MultiplexImage>();
        images.add(new MultiplexImage("http://img07.tooopen.com/images/20170412/tooopen_sy_205649374814.jpg"));
        images.add(new MultiplexImage("https://i3.wenshen520.com/25257_0.jpg"));
        images.add(new MultiplexImage("https://truth.bahamut.com.tw/s01/201601/88f5d73bb1e77e536bdd3e619bb041aa.JPG"));
        images.add(new MultiplexImage("http://i2.bvimg.com/607307/5d1d51c2d25e5c5cs.jpg","http://i2.bvimg.com/607307/5d1d51c2d25e5c5cs.jpg"));
        images.add(new MultiplexImage("http://i2.bvimg.com/607307/5d1d51c2d25e5c5cs.jpg","http://i2.bvimg.com/607307/5d1d51c2d25e5c5cs.jpg"));
        images.add(new MultiplexImage("http://i2.bvimg.com/607307/5d1d51c2d25e5c5cs.jpg","http://i2.bvimg.com/607307/5d1d51c2d25e5c5cs.jpg"));
        images.add(new MultiplexImage("http://i2.bvimg.com/607307/5d1d51c2d25e5c5cs.jpg","http://i2.bvimg.com/607307/5d1d51c2d25e5c5cs.jpg"));


        rv.setLayoutManager(new GridLayoutManager(this,3));
        rv.setAdapter(adapter = new ImageAdapter(this,images));

        adapter.setItemClickListener(new ImageAdapter.OnRecyclerItemClickListener() {
            @Override
            public void click(View view, int position) {

                PickPhotoActivity.startActivity(MainActivity.this, view, images, position);

//                if (Build.VERSION.SDK_INT < 21) {
////                    Toast.makeText(ActivityTransitionActivity.this, "21+ only, keep out", Toast.LENGTH_SHORT).show();
//                } else {
//                    Intent intent = new Intent(MainActivity.this, PickPhotoActivity.class);
//                    intent.putParcelableArrayListExtra("images", (ArrayList<? extends Parcelable>) images);
//                    intent.putExtra("position",position);
//                    ActivityOptionsCompat options = ActivityOptionsCompat.
//                            makeSceneTransitionAnimation(MainActivity.this, view, "test");
//                    startActivity(intent, options.toBundle());
//                }

            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //touch事件传给onTouchEvent()
        Log.e("22","22");
//        mGesture.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
