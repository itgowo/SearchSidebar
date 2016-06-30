package com.lujianchao.SearchSideBar.view;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by kid on 2016/1/20.
 */
public class Member {

    private static Gson mGson = new Gson();
    /**
     * errcode : 0
     * errmsg : 成功
     * data : {"ID":"1433BBB1-7C32-4FB6-978F-637E5CAD08DE","MemberID":"e09e72744e77497584fe923544f839eb","Logo":"http://interfacetest.detaoma.com:7180/Upload/0701/4EE/464/318FD3454788ADDFA316F16AEE.png","NickName":"老卢建","NickNameAbbr":"LLJ","RemarkName":"c","RemarkNameShort":"C","RemarkPhone":"","RemarkPhone2":"","Descript":"兔兔图图具体了","CityID":"5D45214C-AEB4-4F72-BA22-23DA0A86D124","CityIDSTR":"大同市","ProvinceID":"C51314F3-7D56-4781-822F-C1D2502E87B3","ProvinceIDSTR":"山西","Fees":"10881818","SelfComment":"发大财可","IsFriend":"2","Sex":"1","Position":"","WorkingRadius":"","ShopList":[],"WeiboList":[],"TagList":[]}
     */

    private int errcode;
    private String errmsg;

    @Override
    public String toString() {
        return "Member{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * ID : 1433BBB1-7C32-4FB6-978F-637E5CAD08DE
     * MemberID : e09e72744e77497584fe923544f839eb
     * Logo : http://interfacetest.detaoma.com:7180/Upload/0701/4EE/464/318FD3454788ADDFA316F16AEE.png
     * NickName : 老卢建
     * NickNameAbbr : LLJ
     * RemarkName : c
     * RemarkNameShort : C
     * RemarkPhone :
     * RemarkPhone2 :
     * Descript : 兔兔图图具体了
     * CityID : 5D45214C-AEB4-4F72-BA22-23DA0A86D124
     * CityIDSTR : 大同市
     * ProvinceID : C51314F3-7D56-4781-822F-C1D2502E87B3
     * ProvinceIDSTR : 山西
     * Fees : 10881818
     * SelfComment : 发大财可
     * IsFriend : 2
     * Sex : 1
     * Position :
     * WorkingRadius :
     * ShopList : []
     * WeiboList : []
     * TagList : []
     */

    private DataEntity data;

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public int getErrcode() {
        return errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        private String ID;
        private String MemberID;
        private String Logo;
        private String NickName;
        private String NickNameAbbr;
        private String RemarkName;
        private String RemarkNameShort;
        private String RemarkPhone;
        private String RemarkPhone2;
        private String Descript;
        private String CityID;
        private String CityIDSTR = "";
        private String ProvinceID;
        private String ProvinceIDSTR = "";
        private String Fees;
        private String FeesSTR;
        private String SelfComment;
        private String IsFriend;
        private String Sex;
        private String Position;
        private String WorkingRadius;
        private String WorkingRadiusSTR;

        public String getFeesSTR() {
            return FeesSTR;
        }

        public void setFeesSTR(String mFeesSTR) {
            FeesSTR = mFeesSTR;
        }

        public String getWorkingRadiusSTR() {
            return WorkingRadiusSTR;
        }

        public void setWorkingRadiusSTR(String mWorkingRadiusSTR) {
            WorkingRadiusSTR = mWorkingRadiusSTR;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    ", MemberID='" + MemberID + '\'' +
                    ", Logo='" + Logo + '\'' +
                    ", DispName='" + DispName + '\'' +
                    '}';
        }

        /**
         * LogoID :
         * SaveUrl :
         * ThumbnailType :
         * LogoImage : {}
         */


        private String LogoID;
        private String SaveUrl;
        private String ThumbnailType;
        private String GroupID;

        public String getGroupID() {
            return GroupID;
        }

        public void setGroupID(String mGroupID) {
            GroupID = mGroupID;
        }


        /**
         * origon : http://interfacetest.detaoma.com:7180/Upload/0701/A00/952/D91BA2484BA11BF78F8F7553F1.jpg
         * ID : bbf04d4c-5713-43e2-9a19-fcecf7273ccf
         * small : http://interfacetest.detaoma.com:7180/Upload/0701/A00/952/D91BA2484BA11BF78F8F7553F1_132x132.jpg
         * middle : http://interfacetest.detaoma.com:7180/Upload/0701/A00/952/D91BA2484BA11BF78F8F7553F1_400x400.jpg
         * big : http://interfacetest.detaoma.com:7180/Upload/0701/A00/952/D91BA2484BA11BF78F8F7553F1_400x400.jpg
         */

        private LogoImageEntity LogoImage;

        public String getLogoID() {
            return LogoID;
        }

        public void setLogoID(String LogoID) {
            this.LogoID = LogoID;
        }

        public String getSaveUrl() {
            return SaveUrl;
        }

        public void setSaveUrl(String SaveUrl) {
            this.SaveUrl = SaveUrl;
        }

        public String getThumbnailType() {
            return ThumbnailType;
        }

        public void setThumbnailType(String ThumbnailType) {
            this.ThumbnailType = ThumbnailType;
        }

        public LogoImageEntity getLogoImage() {
            return LogoImage;
        }

        public void setLogoImage(LogoImageEntity LogoImage) {
            this.LogoImage = LogoImage;
        }


        /**
         * TagID : 9e694b5a-51a3-4874-b80f-5b46ae594673
         * TagName : 兔兔
         */

        private List<TagListEntity> TagList;
        /**
         * ID : 商品ID
         * Logo : 商品列表图 图片url
         * JumpUrl : 页面跳转链接   html/shop/detail.html
         */

        private List<ShopListEntity> ShopList;
        /**
         * ID : 行业脉搏ID
         * Img01 : 行业脉搏上传图片首图 图片url
         */

        private List<WeiboListEntity> WeiboList;
        /**
         * DispName : 晴空
         */

        private String DispName;

        public void setID(String ID) {
            this.ID = ID;
        }

        public void setMemberID(String MemberID) {
            this.MemberID = MemberID;
        }

        public void setLogo(String Logo) {
            this.Logo = Logo;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public void setNickNameAbbr(String NickNameAbbr) {
            this.NickNameAbbr = NickNameAbbr;
        }

        public void setRemarkName(String RemarkName) {
            this.RemarkName = RemarkName;
        }

        public void setRemarkNameShort(String RemarkNameShort) {
            this.RemarkNameShort = RemarkNameShort;
        }

        public void setRemarkPhone(String RemarkPhone) {
            this.RemarkPhone = RemarkPhone;
        }

        public void setRemarkPhone2(String RemarkPhone2) {
            this.RemarkPhone2 = RemarkPhone2;
        }

        public void setDescript(String Descript) {
            this.Descript = Descript;
        }

        public void setCityID(String CityID) {
            this.CityID = CityID;
        }

        public void setCityIDSTR(String CityIDSTR) {
            this.CityIDSTR = CityIDSTR;
        }

        public void setProvinceID(String ProvinceID) {
            this.ProvinceID = ProvinceID;
        }

        public void setProvinceIDSTR(String ProvinceIDSTR) {
            this.ProvinceIDSTR = ProvinceIDSTR;
        }

        public void setFees(String Fees) {
            this.Fees = Fees;
        }

        public void setSelfComment(String SelfComment) {
            this.SelfComment = SelfComment;
        }

        public void setIsFriend(String IsFriend) {
            this.IsFriend = IsFriend;
        }

        public void setSex(String Sex) {
            this.Sex = Sex;
        }

        public void setPosition(String Position) {
            this.Position = Position;
        }

        public void setWorkingRadius(String WorkingRadius) {
            this.WorkingRadius = WorkingRadius;
        }


        public String getID() {
            return ID;
        }

        public String getMemberID() {
            return MemberID;
        }

        public String getLogo() {
            return Logo;
        }

        public String getNickName() {
            return NickName;
        }

        public String getNickNameAbbr() {
            return NickNameAbbr;
        }

        public String getRemarkName() {
            return RemarkName;
        }

        public String getRemarkNameShort() {
            return RemarkNameShort;
        }

        public String getRemarkPhone() {
            return RemarkPhone;
        }

        public String getRemarkPhone2() {
            return RemarkPhone2;
        }

        public String getDescript() {
            return Descript;
        }

        public String getCityID() {
            return CityID;
        }

        public String getCityIDSTR() {
            return CityIDSTR;
        }

        public String getProvinceID() {
            return ProvinceID;
        }

        public String getProvinceIDSTR() {
            return ProvinceIDSTR;
        }

        public String getFees() {
            return Fees;
        }

        public String getSelfComment() {
            return SelfComment;
        }

        public String getIsFriend() {
            return IsFriend;
        }

        public String getSex() {
            return Sex;
        }

        public String getPosition() {
            return Position;
        }

        public String getWorkingRadius() {
            return WorkingRadius;
        }


        public void setTagList(List<TagListEntity> TagList) {
            this.TagList = TagList;
        }

        public List<TagListEntity> getTagList() {
            return TagList;
        }

        public String getTagListJson() {
            return mGson.toJson(TagList);
        }

        public void setShopList(List<ShopListEntity> ShopList) {
            this.ShopList = ShopList;
        }

        public void setWeiboList(List<WeiboListEntity> WeiboList) {
            this.WeiboList = WeiboList;
        }

        public List<ShopListEntity> getShopList() {
            return ShopList;
        }

        public String getShopListJson() {
            return mGson.toJson(ShopList);
        }

        public List<WeiboListEntity> getWeiboList() {
            return WeiboList;
        }

        public String getWeiboListJson() {
            return mGson.toJson(WeiboList);
        }

        public String getDispName() {
            return DispName;
        }

        public void setDispName(String DispName) {
            this.DispName = DispName;
        }

        public static class TagListEntity {
            private String TagID;
            private String TagName;

            public void setTagID(String TagID) {
                this.TagID = TagID;
            }

            public void setTagName(String TagName) {
                this.TagName = TagName;
            }

            public String getTagID() {
                return TagID;
            }

            public String getTagName() {
                return TagName;
            }
        }

        public static class ShopListEntity {
            private String ID;
            private String Logo;
            private String JumpUrl;

            public void setID(String ID) {
                this.ID = ID;
            }

            public void setLogo(String Logo) {
                this.Logo = Logo;
            }

            public void setJumpUrl(String JumpUrl) {
                this.JumpUrl = JumpUrl;
            }

            public String getID() {
                return ID;
            }

            public String getLogo() {
                return Logo;
            }

            public String getJumpUrl() {
                return JumpUrl;
            }
        }

        public static class WeiboListEntity {
            private String ID;
            private String Img01;

            public void setID(String ID) {
                this.ID = ID;
            }

            public void setImg01(String Img01) {
                this.Img01 = Img01;
            }

            public String getID() {
                return ID;
            }

            public String getImg01() {
                return Img01;
            }
        }

        public static class LogoImageEntity {
            private String origon;
            private String ID;
            private String small;
            private String middle;
            private String big;

            public String getOrigon() {
                return origon;
            }

            public void setOrigon(String origon) {
                this.origon = origon;
            }

            public String getID() {
                return ID;
            }

            public void setID(String ID) {
                this.ID = ID;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getMiddle() {
                return middle;
            }

            public void setMiddle(String middle) {
                this.middle = middle;
            }

            public String getBig() {
                return big;
            }

            public void setBig(String big) {
                this.big = big;
            }
        }
    }
}
