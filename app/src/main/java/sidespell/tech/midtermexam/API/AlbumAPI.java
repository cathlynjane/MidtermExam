package sidespell.tech.midtermexam.API;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sidespell.tech.midtermexam.Model.Album;
import sidespell.tech.midtermexam.utils.HttpUtils;

/**
 * Created by AMODIA-PC on 2/2/2016.
 */
public class AlbumAPI {

    public static final String BASE_URL = "http://ws.audioscrobbler.com/2.0/";

    public static final int SUCCESS_CODE = 200;

    public static final String PARAM_METHOD = "method";
    public static final String PARAM_ALBUM = "album";
    public static final String PARAM_FORMAT = "format";
    public static final String PARAM_API_KEY = "api_key";

    private static final String OWM_CODE = "cod";
    public static final String OWM_RESULTS = "results";
    private static final String OWM_ALBUM_NAME = "name";
    private static final String OWM_ARTIST = "artist";

    public static Album getAlbums(Uri uri, @NonNull String requestMethod, int position) {
        String json = HttpUtils.getResponse(uri, requestMethod);

        if (TextUtils.isEmpty(json)) {
            return null;
        }

        try {
            // 1) Convert the json string response into an actual JSON Object
            JSONObject jsonObject = new JSONObject(json);

            // 2) Get the status code

            // 3) Check if the HTTP Status Code if it's valid or not
            JSONArray album = jsonObject.getJSONArray(OWM_RESULTS);
            JSONObject albumJSONObject = album.getJSONObject(position);

            final String name = albumJSONObject.getString(OWM_ALBUM_NAME);
            final String artist = albumJSONObject.getString(OWM_ARTIST);
            final Bitmap image = albumJSONObject.

            Album alb = new Album()
                    .setmAlbumName(name)
                    .setmArtist(artist);

            return alb;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
