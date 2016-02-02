package sidespell.tech.midtermexam.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sidespell.tech.midtermexam.Model.Album;
import sidespell.tech.midtermexam.R;

/**
 * Created by AMODIA-PC on 2/2/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.AlbumViewHolder> {
    private Context mContext;
    private int mLayoutId;
    private List<Album> mAlbum;

    public RecyclerViewAdapter(Context context, int layoutId, List<Album> movies) {
        mContext = context;
        mLayoutId = layoutId;
        mAlbum = movies;
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        Album album = mAlbum.get(position);

        if (album != null) {
            if (holder.tvName != null) {
                holder.tvName.setText(album.getmAlbumName());
            }
            if (holder.tvArtist != null) {
                holder.tvArtist.setText(album.getmArtist());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mAlbum.size();
    }

    static class AlbumViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView imgAlbum;
        public TextView tvName;
        public TextView  tvArtist;

        public AlbumViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.cardView);
            imgAlbum = (ImageView) view.findViewById(R.id.imgMovie);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvArtist = (TextView) view.findViewById(R.id.tvArtist);
        }
    }
}
