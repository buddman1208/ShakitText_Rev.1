package kr.edcan.shakittext.data;

/**
 * Created by Junseok on 2016. 1. 10..
 */
public class DeveloperData {
    private String title, content, subContent;
    public DeveloperData(String title, String content, String subContent){
        this.title = title;
        this.content=  content;
        this.subContent = subContent;
    }
    public DeveloperData(String title, String content){
        this.title = title;
        this.content=  content;
    }
    public String getTitle(){
        return this.title;
    }

    public String getContent() {
        return content;
    }

    public String getSubContent() {
        return subContent;
    }
}
