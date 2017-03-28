package us.codecraft.jobhunter.pipeline;

import org.springframework.stereotype.Component;
import us.codecraft.jobhunter.dao.YJSJobInfoDao;
import us.codecraft.jobhunter.model.YJSJobInfo;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;

/**
 * Created by qiboo on 2017/3/21.
 */


@Component("YJSJobInfoDaoPipeline")
public class YJSJobInfoDaoPipeline implements PageModelPipeline<YJSJobInfo> {

    @Resource
    private YJSJobInfoDao jobInfoDao;

    public void process(YJSJobInfo jobInfo, Task task) {
        jobInfoDao.add(jobInfo);
    }

}
