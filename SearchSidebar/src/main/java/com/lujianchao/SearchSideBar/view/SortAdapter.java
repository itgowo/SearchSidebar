package com.lujianchao.SearchSideBar.view;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;


import com.lujianchao.SearchSideBar.R;

import java.util.List;

public class SortAdapter extends BaseAdapter implements SectionIndexer {
    private List<SearchSideBar.ContactSortModel> list = null;
    private Context mContext;

    public SortAdapter(Context mContext, List<SearchSideBar.ContactSortModel> list) {
        this.mContext = mContext;
        this.list = list;
    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     *
     * @param list
     */
    public void updateListView(List<SearchSideBar.ContactSortModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup arg2) {
        ViewHolder viewHolder = null;
        final SearchSideBar.ContactSortModel mContactSortModel = list.get(position);
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.listviewsortbarfilter_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        int section = getSectionForPosition(position);
        if (position == getPositionForSection(section)) {
            viewHolder.tvLetter.setVisibility(View.VISIBLE);
            viewHolder.tvLetter.setText(mContactSortModel.getSortLetters());
        } else {
            viewHolder.tvLetter.setVisibility(View.GONE);
        }

        viewHolder.contactsName.setText(this.list.get(position).getName());
        viewHolder.contactsItemIcon.setImageURI(Uri.parse(list.get(position).getLogo()));
//        Glide.with(mContext).load(list.get(position).getLogo()).into(viewHolder.contactsItemIcon);
        return view;

    }


    class ViewHolder {
        TextView tvLetter;
        private ImageView contactsItemIcon;
        private TextView contactsName;

        ViewHolder(View mView) {
            tvLetter = (TextView) mView.findViewById(R.id.tv_catagory);
            contactsItemIcon = (ImageView) mView.findViewById(R.id.contacts_item_icon);
            contactsName = (TextView) mView.findViewById(R.id.contacts_name);
        }
    }

    public int getSectionForPosition(int position) {
        return list.get(position).getSortLetters().charAt(0);
    }

    public int getPositionForSection(int section) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = list.get(i).getSortLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object[] getSections() {
        return null;
    }
}