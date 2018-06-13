package jp.co.pixgetter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private int layoutId;
    private LayoutInflater layoutInflater;
    private List<Item> items;

    static class ViewHolder {
        ImageView img;
        TextView downloads;
    }

    public ItemAdapter(Context context, int layoutId, List<Item> items) {
        this.context = context;
        this.layoutId = layoutId;
        this.layoutInflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layoutId, null);
            holder = new ViewHolder();
            holder.img = convertView.findViewById(R.id.item_image);
            holder.downloads = convertView.findViewById(R.id.item_downloads);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Item item = items.get(position);

        Picasso.get().load(item.getPreviewURL()).into(holder.img);
        holder.downloads.setText(item.getDownloads());

        convertView.setOnClickListener(new ItemClickListener(context.getApplicationContext(), item));

        return convertView;
    }

}
