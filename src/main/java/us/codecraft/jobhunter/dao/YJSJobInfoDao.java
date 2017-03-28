package us.codecraft.jobhunter.dao;

import org.apache.ibatis.annotations.Insert;
import us.codecraft.jobhunter.model.YJSJobInfo;

/**
 * Created by qiboo on 2017/3/21.
 */
public interface YJSJobInfoDao {

//    @Insert("insert into yjsjob (`title`,`publish_Time`,`location`,`type`,`source`,`position`,`content`,`url`," +
//            "`platform`,`create_time`,`email`,`urlmd5`) values (#{title},#{publishTime},#{location},#{type},#{source},#{position}," +
//            "#{content},#{url},#{platform},#{createTime},#{email},#{urlMd5})")
//    public int add(YJSJobInfo jobInfo);


    @Insert("insert into tbl_wx_post (`title`,`publish_time`,`location`,`job_type`,`job_sourse`,`position`,`content`,`content_url`," +
            "`source_type`,`create_time`,`emails`,`url_md5`) values (#{title},#{publishTime},#{location},#{type},#{source},#{position}," +
            "#{content},#{url},#{platform},#{createTime},#{email},#{urlMd5})")
    public int add(YJSJobInfo jobInfo);

}
