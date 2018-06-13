package jp.co.pixgetter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {

    private static final Item item = null;
    private Item mItem;

    public static DetailFragment newInstance(Item item) {
        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("ITEM", item);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mItem = (Item)bundle.getSerializable("ITEM");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        Picasso.get().load(mItem.getPreviewURL()).into(imageView);
        imageView.setOnClickListener(new UrlClickListener(this.getActivity(), mItem.getPageURL()));

        TextView textView;
        textView = (TextView)view.findViewById(R.id.textView_type);
        textView.setText(mItem.getType());
        textView = (TextView)view.findViewById(R.id.textView_tags);
        textView.setText(mItem.getTags());
        textView = (TextView)view.findViewById(R.id.textView_views);
        textView.setText(mItem.getViews());
        textView = (TextView)view.findViewById(R.id.textView_downloads);
        textView.setText(mItem.getDownloads());
        textView = (TextView)view.findViewById(R.id.textView_favorites);
        textView.setText(mItem.getFavorites());
        textView = (TextView)view.findViewById(R.id.textView_likes);
        textView.setText(mItem.getLikes());
        textView = (TextView)view.findViewById(R.id.textView_comments);
        textView.setText(mItem.getComments());

        textView = (TextView)view.findViewById(R.id.textView_previewURL_dimension);
        textView.setText(mItem.getPreviewWidth() + getResources().getString(R.string.x) + mItem.getPreviewHeight());
        textView = (TextView)view.findViewById(R.id.textView_webformatURL_dimension);
        textView.setText(mItem.getWebformatWidth() + getResources().getString(R.string.x) + mItem.getWebformatHeight());
        textView = (TextView)view.findViewById(R.id.textView_imageURL_dimension);
        textView.setText(mItem.getImageWidth() + getResources().getString(R.string.x) + mItem.getImageHeight());

        Button button;
        button = (Button)view.findViewById(R.id.button_previewURL);
        button.setOnClickListener(new UrlClickListener(this.getActivity(), mItem.getPreviewURL()));
        button = (Button)view.findViewById(R.id.button_webformatURL);
        button.setOnClickListener(new UrlClickListener(this.getActivity(), mItem.getWebformatURL()));
        button = (Button)view.findViewById(R.id.button_imageURL);
        button.setOnClickListener(new UrlClickListener(this.getActivity(), mItem.getLargeImageURL()));

        return view;
    }

}
