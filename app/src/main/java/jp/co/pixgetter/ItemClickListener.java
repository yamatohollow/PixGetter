package jp.co.pixgetter;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.view.View;

public class ItemClickListener implements View.OnClickListener {

    private Item mItem;
    private Context mContext;

    public ItemClickListener(Context c, Item i) {
        this.mContext = c;
        this.mItem = i;
    }

    @Override
    public void onClick(View v) {

        Activity thisActivity = ((MyApplication)mContext.getApplicationContext()).getCurrentActivity();

        //set DetailFragment
        DetailFragment detailFragment = DetailFragment.newInstance(mItem);
        FragmentTransaction transactionList = thisActivity.getFragmentManager().beginTransaction();
        transactionList.replace(R.id.fragment_container, detailFragment);
        transactionList.addToBackStack(null);
        transactionList.commit();
    }
}
