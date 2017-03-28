package us.codecraft.jobhunter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.jobhunter.downloader.MyDownloader;
import us.codecraft.jobhunter.model.YJSJobInfo;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.monitor.SpiderMonitor;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.management.JMException;


@Component
public class JobCrawler {


    @Qualifier("YJSJobInfoDaoPipeline")
    @Autowired
    private PageModelPipeline yjsJobInfoDaoPipeline;

    public void yjsCrawl() {
        Spider yjsSpider = OOSpider.create(Site.me().setRetryTimes(3)
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36"),yjsJobInfoDaoPipeline, YJSJobInfo.class)
                .setDownloader(new MyDownloader())
                .addUrl("http://www.yingjiesheng.com/commend-parttime-1.html")
                .thread(25);
        try {
            SpiderMonitor.instance().register(yjsSpider);
            yjsSpider.start();
        } catch (JMException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
        final JobCrawler jobCrawler = applicationContext.getBean(JobCrawler.class);
        jobCrawler.yjsCrawl();
    }
}
