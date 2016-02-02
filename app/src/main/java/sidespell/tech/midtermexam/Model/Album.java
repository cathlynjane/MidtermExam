package sidespell.tech.midtermexam.Model;

import android.graphics.Bitmap;

/**
 * Created by AMODIA-PC on 2/2/2016.
 */
public class Album {
    private String mAlbumName;
    private String mArtist;

    public Album(String mAlbumName, String mArtist) {
        this.setmAlbumName(mAlbumName);
        this.setmArtist(mArtist);
    }

    public String getmAlbumName() {
        return mAlbumName;
    }

    public void setmAlbumName(String mAlbumName) {
        this.mAlbumName = mAlbumName;
    }

    public String getmArtist() {
        return mArtist;
    }

    public void setmArtist(String mArtist) {
        this.mArtist = mArtist;
    }
}
