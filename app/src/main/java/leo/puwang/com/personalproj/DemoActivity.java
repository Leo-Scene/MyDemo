package leo.puwang.com.personalproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import leo.puwang.com.personalproj.adapter.RecommendAdapter;
import leo.puwang.com.personalproj.bean.RecommendedBean;
import leo.puwang.com.personalproj.call.RecommendSer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DemoActivity extends AppCompatActivity implements Callback<RecommendedBean> {

    private String BASE_URL = "http://morguo.com";
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_demo);

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
        List<RecommendedBean.DataBean.ListBean> list = response.body().getData().getList();
        initRecycler(list);
    }

    private void initRecycler(final List<RecommendedBean.DataBean.ListBean> list) {
        final RecommendAdapter adapter = new RecommendAdapter(this,list);

        adapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onFailure(Call<RecommendedBean> call, Throwable t) {

    }
}
