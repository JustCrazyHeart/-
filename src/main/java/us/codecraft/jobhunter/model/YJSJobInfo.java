package us.codecraft.jobhunter.model;

import org.apache.commons.codec.digest.DigestUtils;
import us.codecraft.jobhunter.utils.CheckStringUtil;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qiboo on 2017/3/21.
 */

@TargetUrl("http://www.yingjiesheng.com/job-*.html")
@HelpUrl("http://www.yingjiesheng.com/commend-parttime-*.html")
public class YJSJobInfo implements AfterExtractor {

    @ExtractBy(value = "//h1/text()", notNull = true)
    String title;

    @ExtractBy(value = "//div[@class='info clearfix']/ol/li[1]/u/text()", notNull = true)
    String publishTime;

    @ExtractBy(value = "//div[@class='info clearfix']/ol/li[2]/u/text()")
    String location;

    @ExtractBy(value = "//div[@class='info clearfix']/ol/li[3]/u/text()")
    String type;

    @ExtractBy(value = "//div[@class='info clearfix']/ol/li[4]/a/text()")
    String source;

    @ExtractBy(value = "//div[@class='info clearfix']/ol/li[5]/u/text()")
    String position ;

    @ExtractBy(value = "//div[@class='jobIntro']/tidyText()", notNull = true)
    private String content="";

    @ExtractByUrl
    private String url="";
    private String urlMd5="";

    private int platform = 2;

    private String createTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    private String email = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.email = CheckStringUtil.findEmail(content);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        this.urlMd5 = DigestUtils.md5Hex(url);
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public void afterProcess(Page page) {

    }

}
