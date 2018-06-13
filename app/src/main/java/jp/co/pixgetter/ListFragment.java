package jp.co.pixgetter;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ListFragment extends Fragment{

    private static final String TAG_LOG = ListFragment.class.getName();

    private static final String URL = "https://pixabay.com/api/?key=9048770-30d9e607c8419814b6eb3f12e";

    private Hits mHits;
    private List<Item> mItems;

    private View mView;
    private GridView mGridView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_list, null);
        mGridView = (GridView)mView.findViewById(R.id.gridview);
        jsonToObjectUrl();

        Button reloadButton = (Button)mView.findViewById(R.id.reload_button);
        reloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication.hideSoftKeyboard(getActivity());
                jsonToObjectUrl();
            }
        });

        return mView;
    }

    private void jsonToObjectUrl() {
        final ObjectMapper mapper = new ObjectMapper();
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuffer urlString = new StringBuffer(URL.toString());

                    // order
                    Spinner spinner = (Spinner)mView.findViewById(R.id.order_list_spinner);
                    String orderString = spinner.getSelectedItem().toString();
                    urlString.append("&order=" + orderString);

                    // keyword
                    EditText editText = (EditText)mView.findViewById(R.id.search_keyword);
                    String keywordString = editText.getText().toString();
                    if (keywordString.length() > 0) {
                        urlString.append("&q=" + keywordString);
                    }

                    Log.e(TAG_LOG, "urlString: " + urlString);
                    mHits = mapper.readValue(new URL(urlString.toString()), Hits.class);
                    mItems = mHits.getHits();

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            mGridView.setAdapter(new ItemAdapter(getActivity(), R.layout.item, mItems));
                        }
                    });
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
