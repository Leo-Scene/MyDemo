package leo.puwang.com.personalproj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import leo.puwang.com.personalproj.R;
import leo.puwang.com.personalproj.bean.RecommendedBean;

/**
 * Created by Leo on 2016/11/22.
 */

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder>{

   private String threadarticle = "threadarticle";
   private String threadgallery = "threadgallery";
   private String acinecism = "acinecism";
   private String movielines = "movielines";
   private String threadmusic = "threadmusic";
   private String threadvideo = "threadvideo";
   private String collection = "collection";




    private Context mContext ;
    private List<RecommendedBean.DataBean.ListBean> mListBeen = new ArrayList<>();

    private String BASE_URL = "http://morguo.com";
    private LayoutInflater mInflater;

    public RecommendAdapter(Context context, List<RecommendedBean.DataBean.ListBean> listBeen) {
        mContext = context;
        mListBeen = listBeen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(mContext);

        View view = mInflater.inflate(R.layout.recommend_yindan_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso
                .with(mContext)
                .load(BASE_URL+"/"+mListBeen.get(position)
                        .getItemdata()
                        .getImage())
                .into(holder.mImageView);

        holder.mTitle.setText(mListBeen.get(position).getItemdata().getIntro());
        holder.mContent.setText(mListBeen.get(position).getItemdata().getSubject());
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mListBeen.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView mImageView;
        private final TextView mTitle;
        private final TextView mContent;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id._imge);
            mTitle = (TextView) itemView.findViewById(R.id._title);
            mContent = (TextView) itemView.findViewById(R.id._content);
        }
    }



    public void addAll(List<RecommendedBean.DataBean.ListBean> listBean){
        this.mListBeen = listBean;
        notifyDataSetChanged();
    }
}
