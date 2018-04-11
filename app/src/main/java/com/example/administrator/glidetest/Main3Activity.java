package com.example.administrator.glidetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.MediaStoreSignature;
import com.example.administrator.glidetest.util.CircleCrop;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class Main3Activity extends AppCompatActivity {
    private String url2="http://s2.cn.bing.net/th?id=OJ.W0YP0b0HEUZEKQ&pid=MSNJVFeeds";
//    String url = "http://guolin.tech/book.png";
    String url3 = "http://s1.cn.bing.net/th?id=OJ.xbIfScQcnq0ohw&pid=MSNJVFeeds";
//String url = "http://s2.cn.bing.net/th?id=OJ.hNymI93yNx1elA&pid=MSNJVFeeds";
//    String url="http://s1.cn.bing.net/th?id=OJ.0RX0bpUOlOCfTA&pid=MSNJVFeeds";
    String url="http://test.dushuren123.com/bookmov/LectureImage?id=-30756693";
    String url4="https://a.vpimg2.com/upload/merchandise/pdcvis/2017/11/24/10/8043fa07-8725-46c3-8d43-f8704a111add.jpg";

    String vertical="https://a.vpimg2.com/upload/merchandise/pdcvis/2018/01/12/43/588219c8-fddd-45ae-be9a-2568b089e03c_t.jpg";
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
    }

    public void loadImage(View view) {
        Glide.with(this)
                .load(vertical)
                .bitmapTransform(new CropTransformation(this))
                .into(imageView);
//        cricle();
//        iamgeTrans();
//        CircleCrop();
//        blurring();
//        BlackAndWhite();
//        blurringAndBwithW();
//        round();
    }

    public void loadImage2(View view) {
        Glide.with(this)
                .load(url)
                .bitmapTransform(new RoundedCornersTransformation(this,50,0))
                .into(imageView2);
//        round();
//        Glide.with(this)
//                .load(url)
//                .override(666,444)
//                .into(imageView);
    }
    public void loadImage3(View view) {
        Glide.with(this)
                .load(url)
                .bitmapTransform(new RoundedCornersTransformation(this,50,0))
                .into(imageView3);

//        Glide.with(this)
//                .load(url)
//                .override(999,666)
//                .into(imageView);
    }
    private void iamgeTrans(){
//        String url = "https://www.baidu.com/img/bd_logo1.png";
        Glide.with(this)
                .load(url4)
//                .dontTransform()//禁止图片变换
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)//加载原图大小
//                .override(500,500)
//                .centerCrop()
//                .fitCenter()
//                .signature(new ObjectKey())
                .into(imageView);
    }

    private void CircleCrop(){
        Glide.with(this)
                .load(url)
                .transform(new CircleCrop(this))
                .into(imageView);
    }

    private void blurring(){
        Glide.with(this)
                .load(url)
                .bitmapTransform(new BlurTransformation(this))
                .into(imageView);
    }

    private void BlackAndWhite(){
        Glide.with(this)
                .load(url)
                .bitmapTransform(new GrayscaleTransformation(this))
                .into(imageView);
    }

    private void blurringAndBwithW(){
        Glide.with(this)
                .load(url)
                .bitmapTransform(new BlurTransformation(this),new GrayscaleTransformation(this))
                .into(imageView);
    }

    //圆角
    private void round(){
        Glide.with(this)
                .load(url2)
                .bitmapTransform(new RoundedCornersTransformation(this,20,10))
                .into(imageView2);
    }

    private void cricle(){
        Glide.with(this)
                .load(url4)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(imageView3);
//        Glide.with(this)
//                .load(url4)
//                .bitmapTransform(new CircleCrop(this))
//                .into(imageView3);

    }


}
