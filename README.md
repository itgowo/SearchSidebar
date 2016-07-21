# SearchSidebar

## 一：关键词：
~~~~
联系人列表  导航bar  搜索
~~~~

QQ：1264957104



## 二：说明
    导航bar有很多了，我看了别人的有一些不满足需求，于是改了改：
    1.增加了对数字和特殊符号的处理，按#处理了。
    2.针对导航字母数量不同做了处理。当数量少时，间距较大方便点击，数量越多间距越小。
    3.做成了自定义View方式，充分解耦，使用方便。
    
    如果直接导入会出错，把布局文件listviewsortbarfilter.xml里自定义view重新写一下路径和名字就可以了，clean项目，一般没问题了。
    核心代码方法： mSortBarFilter.setMembers(mMembers, new SearchSideBar.onItemClickListener()
    
## 示例
![ image](https://github.com/hnsugar/SearchSidebar/blob/master/SearchSidebar.gif)

 

##  布局

    <com.lujianchao.SearchSideBar.view.SearchSideBar
        android:id="@+id/lv_contact"
        android:layout_width="match_parent"
        android:layout_height="match_parent"></com.lujianchao.SearchSideBar.view.SearchSideBar>
        
##  代码

 
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
