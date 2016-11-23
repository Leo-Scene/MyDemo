package leo.puwang.com.personalproj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import leo.puwang.com.personalproj.R;
import leo.puwang.com.personalproj.bean.RecommendedBean;

/**
 * Created by Leo on 2016/11/22.
 */

public class TypeRecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<RecommendedBean.DataBean.ListBean> mListBeen = new ArrayList<>();
    private final LayoutInflater mInflater;

    public TypeRecommendAdapter(Context context,
                                List<RecommendedBean.DataBean.ListBean> listBeen) {
        mContext = context;
        mListBeen = listBeen;

        mInflater = LayoutInflater.from(mContext);
    }

    /*
    * threadmusic  音乐
threadgallery 画报
threadarticle 杂粮
acinecism 影评
movielines 电影中的一句话
collection 影单
threadvideo 短片
    * */

    public enum ITEM_TYPE {
        threadmusic,
        threadgallery,
        threadarticle,
        acinecism,
        collection,
        threadvideo
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    //item1 的ViewHolder
    public static class collectionViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImageView;
        private final TextView mTitle;
        private final TextView mContent;

        public collectionViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id._imge);
            mTitle = (TextView) itemView.findViewById(R.id._title);
            mContent = (TextView) itemView.findViewById(R.id._content);
        }
    }

    //item2 的ViewHolder
    public static class acinecismViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImageView;
        private final TextView mTitle;
        private final TextView mContent;

        public acinecismViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id._imge);
            mTitle = (TextView) itemView.findViewById(R.id._title);
            mContent = (TextView) itemView.findViewById(R.id._content);
        }
    }

    public static class movielinesViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImageView;
        private final TextView mTitle;
        private final TextView mContent;

        public movielinesViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id._imge);
            mTitle = (TextView) itemView.findViewById(R.id._title);
            mContent = (TextView) itemView.findViewById(R.id._content);
        }
    }

    public static class threadmusicViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImageView;
        private final TextView mTitle;
        private final TextView mContent;

        public threadmusicViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id._imge);
            mTitle = (TextView) itemView.findViewById(R.id._title);
            mContent = (TextView) itemView.findViewById(R.id._content);
        }
    }
}
