package kr.edcan.shakittext.adapter;

/**
 * Created by MalangDesktop on 2016-02-23.
 */
public class MainData {
    private boolean hasHeader;
    private int listType;
    /*
    * 0 계정
    * 1 터치시 다이얼로그
    * 2 스위치
    */
    private int profileImageAddress;
    private String headerTitle, mainText, subText;

    public boolean isHasHeader() {
        return hasHeader;
    }

    public int getListType() {
        return listType;
    }

    public int getProfileImageAddress() {
        return profileImageAddress;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public String getMainText() {
        return mainText;
    }

    public String getSubText() {
        return subText;
    }
}
