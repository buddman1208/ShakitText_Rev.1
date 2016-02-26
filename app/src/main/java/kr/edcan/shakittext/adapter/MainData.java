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
    * 3 Only 터치
    */
    private int profileImageAddress;
    private String headerTitle, mainText, subText;

    public MainData(String headertitle){
        this.hasHeader = true;
        this.headerTitle = headertitle;
    }
    public MainData(int listType, int profileImageAddress, String mainText, String subText){
        this.hasHeader = false;
        this.listType = listType;
        this.profileImageAddress = profileImageAddress;
        this.mainText = mainText;
        this.subText = subText;
    }
    public MainData(int listType, String mainText, String subText){
        this.hasHeader = false;
        this.listType = listType;
        this.mainText = mainText;
        this.subText = subText;
    }
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
