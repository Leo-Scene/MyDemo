package leo.puwang.com.personalproj.call;

import leo.puwang.com.personalproj.bean.RecommendedBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Leo on 2016/11/22.
 */

public interface RecommendSer {
    //http://morguo.com/forum.php?mod=movieexplorer&v=4&androidflag=1&page=1
    @GET("/forum.php")
    Call<RecommendedBean> getRecommend(@Query("mod") String mod,
                                       @Query("page") int page,
                                       @Query("v") int v,
                                       @Query("androidflag") int androidflag);
}
