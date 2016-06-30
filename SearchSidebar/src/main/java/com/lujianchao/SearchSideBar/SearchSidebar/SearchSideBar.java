package com.lujianchao.SearchSideBar.SearchSidebar;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.lujianchao.SearchSideBar.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Lu JianChao on 2016/6/29.
 * https://github.com/hnsugar
 */
public class SearchSideBar extends LinearLayout {
    private ListView sortListView;
    private SideBar sideBar;
    private Context mContext;
    private TextView dialog;
    private SortAdapter adapter;
    private SearchEditText mEtSearchName;
    private List<ContactSortModel> SourceDateList;
    private onItemClickListener mOnItemClickListener;

    public SearchSideBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        addView(View.inflate(context, R.layout.listviewsortbarfilter, null));
    }

    public void setMembers(List<ContactSortModel> mMembers, onItemClickListener mListener) {
        this.SourceDateList = mMembers;
        this.mOnItemClickListener = mListener;
        initViews();
    }

    private void initViews() {
        mEtSearchName = (SearchEditText) findViewById(R.id.et_search);
        sideBar = (SideBar) findViewById(R.id.sidrbar);
        dialog = (TextView) findViewById(R.id.dialog);
        sortListView = (ListView) findViewById(R.id.sortListView);
        initDatas();
        initEvents();
        setAdapter();
    }

    private void setAdapter() {

        filledData(SourceDateList);
        Collections.sort(SourceDateList, new PinyinComparator());
        adapter = new SortAdapter(mContext, SourceDateList);
        sortListView.setAdapter(adapter);
    }

    private void initEvents() {
        //设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListView.setSelection(position);
                }
            }
        });

        //ListView的点击事件
        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItem(position, (ContactSortModel) adapter.getItem(position));
                }
            }
        });

        //根据输入框输入值的改变来过滤搜索
        mEtSearchName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initDatas() {
        sideBar.setTextView(dialog);
    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<ContactSortModel> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)) {
            mSortList = SourceDateList;
        } else {
            mSortList.clear();
            for (ContactSortModel sortModel : SourceDateList) {
                String name = sortModel.getName();
                if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(filterStr.toString().toUpperCase())) {
                    mSortList.add(sortModel);
                }
            }
        }
        // 根据a-z进行排序
        Collections.sort(mSortList, new PinyinComparator());
        adapter.updateListView(mSortList);
    }

    /**
     * 计算出首字母
     * @param mMembers
     * @return
     */
    private List<ContactSortModel> filledData(List<ContactSortModel> mMembers) {
        List<ContactSortModel> mSortList = mMembers;
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i < mSortList.size(); i++) {
            String pinyin = PinyinUtils.getPingYin(mSortList.get(i).getName());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                mSortList.get(i).setSortLetters(sortString.toUpperCase());
                if (!indexString.contains(sortString)) {
                    indexString.add(sortString);
                }
            } else {
                if (!indexString.contains("#")) {
                    indexString.add("#");
                }
            }

        }
        Collections.sort(indexString);
        sideBar.setIndexText(indexString);
        return mSortList;
    }


    /**
     * 用来对ListView中的数据根据A-Z进行排序，前面两个if判断主要是将不是以汉字开头的数据放在后面
     */
    public class PinyinComparator implements Comparator<ContactSortModel> {

        public int compare(ContactSortModel o1, ContactSortModel o2) {
            //这里主要是用来对ListView里面的数据根据ABCDEFG...来排序
            if (o1.getSortLetters().equals("@")
                    || o2.getSortLetters().equals("#")) {
                return 1;
            } else if (o1.getSortLetters().equals("#")
                    || o2.getSortLetters().equals("@")) {
                return -1;
            } else {
                return o1.getSortLetters().compareTo(o2.getSortLetters());
            }
        }
    }


    public static class ContactSortModel {

        private String name;//显示的数据
        private String ID;
        private String Logo;
        private String sortLetters = "#";//显示数据拼音的首字母
        private String tag;

        public String getTag() {
            return tag;
        }

        public void setTag(String mTag) {
            tag = mTag;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSortLetters() {
            return sortLetters;
        }

        public void setSortLetters(String sortLetters) {
            this.sortLetters = sortLetters;
        }

        public String getID() {
            return ID;
        }

        public void setID(String mID) {
            ID = mID;
        }

        public String getLogo() {
            return Logo;
        }

        public void setLogo(String mLogo) {
            Logo = mLogo;
        }

        @Override
        public String toString() {
            return "ContactSortModel{" +
                    "name='" + name + '\'' +
                    ", ID='" + ID + '\'' +
                    ", Logo='" + Logo + '\'' +
                    ", sortLetters='" + sortLetters + '\'' +
                    '}';
        }
    }

    public interface onItemClickListener {
        public void onItem(int position, ContactSortModel mModel);
    }

}

