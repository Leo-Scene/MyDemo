package leo.puwang.com.personalproj;

import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import leo.puwang.com.personalproj.adapter.RecommendAdapter;
import leo.puwang.com.personalproj.bean.RecommendedBean;
import leo.puwang.com.personalproj.call.RecommendSer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<RecommendedBean> {

    private String BASE_URL = "http://morguo.com";
    private ImageView mImageView;
    private SliderLayout mSliderShow;
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();

    }



    private void initView() {
        mSliderShow = (SliderLayout) findViewById(R.id.slider);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_recommend);
    }

    private void initData() {
        App
                .initRetrofit()
                .create(RecommendSer.class)
                .getRecommend("movieexplorer",1,4,1)
                .enqueue(this);
    }


    @Override
    public void onResponse(Call<RecommendedBean> call, Response<RecommendedBean> response) {
        List<RecommendedBean.DataBean.BannerlistBean> bannerlist =
                response.body().getData().getBannerlist();

        List<RecommendedBean.DataBean.HotkeywordlistBean> hotkeywordlist =
                response.body().getData().getHotkeywordlist();

        List<RecommendedBean.DataBean.ListBean> list =
                response.body().getData().getList();

        initBannerList(bannerlist);
        initRecycler(list);

    }

    private void initRecycler(final List<RecommendedBean.DataBean.ListBean> list) {
        final RecommendAdapter adapter = new RecommendAdapter(this,list);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    /**
    * 轮播图
    *
    *@author 乐文
    *created at 2016/11/22 下午2:59
     * @param bannerlist
    */
    private void initBannerList(List<RecommendedBean.DataBean.BannerlistBean> bannerlist) {
        for (int i = 0; i < bannerlist.size(); i++) {
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(bannerlist.get(i).getSubject())
                    .image(BASE_URL+"/"+bannerlist.get(i).getImage());
            mSliderShow.addSlider(textSliderView);

        }

        mSliderShow.setDuration(3000);



    }

    @Override
    public void onFailure(Call<RecommendedBean> call, Throwable t) {

    }


    @Override
    protected void onStop() {
        mSliderShow.stopAutoCycle();
        super.onStop();
    }




}
