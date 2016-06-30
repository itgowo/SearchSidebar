package com.lujianchao.SearchSideBar;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;


import com.lujianchao.SearchSideBar.SearchSidebar.SearchSideBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private SearchSideBar mSortBarFilter;

    private List<SearchSideBar.ContactSortModel> mMembers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        mSortBarFilter = (SearchSideBar) findViewById(R.id.lv_contact);
        String[] mStrings = getResources().getStringArray(R.array.contacts);
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + getResources().getResourcePackageName(R.mipmap.ic_launcher) + "/"
                + getResources().getResourceTypeName(R.mipmap.ic_launcher) + "/"
                + getResources().getResourceEntryName(R.mipmap.ic_launcher));
        for (int i = 0; i < mStrings.length; i++) {
            SearchSideBar.ContactSortModel mMember = new SearchSideBar.ContactSortModel();
            mMember.setID("aaaaaaa" + i);
            mMember.setName(mStrings[i]);
            mMember.setLogo(uri.toString());
            mMembers.add(mMember);
        }
        mSortBarFilter.setMembers(mMembers, new SearchSideBar.onItemClickListener() {
            @Override
            public void onItem(int position, SearchSideBar.ContactSortModel mModel) {
                System.out.println("position = [" + position + "], mModel = [" + mModel + "]");
            }
        });
    }


}
