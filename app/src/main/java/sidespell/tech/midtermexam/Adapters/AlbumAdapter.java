package sidespell.tech.midtermexam.Adapters;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sidespell.tech.midtermexam.Model.Album;
import sidespell.tech.midtermexam.R;

/**
 * Created by AMODIA-PC on 2/2/2016.
 */
public class AlbumAdapter extends ArrayAdapter<Album> {

        private Context mContext;
        private int mLayoutId;
        private List<Album> mAlbum;

        public AlbumAdapter(Context context, int resource, List<Album> movies) {
            super(context, resource, movies);

            mContext = context;
            mLayoutId = resource;
            mAlbum = movies;
        }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                    ViewHolder viewHolder;

                    if (convertView == null) {
                    // Inflate the layout
                    convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);

                    // create the view holder
                    viewHolder = new ViewHolder();
                    viewHolder.imgMovie = (ImageView) convertView.findViewById(R.id.imgMovie);
                    viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
                    viewHolder.tvArtist = (TextView) convertView.findViewById(R.id.tvArtist);

                    convertView.setTag(viewHolder);
                    } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                    }

                Album album = mAlbum.get(position);

                if (album != null) {
                    if (viewHolder.imgMovie != null) {
                        viewHolder.imgMovie.setImageBitmap(album.getmAlbumImage());
                    }
                    if (viewHolder.tvName != null) {
                        viewHolder.tvName.setText(album.getmAlbumName());
                    }
                    if (viewHolder.tvArtist != null) {
                        viewHolder.tvArtist.setText(album.getmArtist());
                    }
                }

                return convertView;
            }

   static class ViewHolder {
        public ImageView imgMovie;
        public TextView  tvName;
        public TextView  tvArtist;
    }
}
