package jp.co.pixgetter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class UrlClickListener implements View.OnClickListener {

    private String mUrl;
    private Context mContext;

    public UrlClickListener(Context c, String url){
        this.mContext = c;
        this.mUrl = url;
    }

    @Override
    public void onClick(View v) {

        Activity thisActivity = ((MyApplication)mContext.getApplicationContext()).getCurrentActivity();

        Uri uri = Uri.parse(mUrl);
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        thisActivity.startActivity(i);
    }
}
