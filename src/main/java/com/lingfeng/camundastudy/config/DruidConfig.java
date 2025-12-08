package com.lingfeng.camundastudy.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfig {
    
    @Bean
    public Filter statFilter() {
        WallFilter wallFilter = new WallFilter();
        WallConfig wallConfig = new WallConfig();
        
        // 允许SELECT语句中使用1=1这样的常量条件
        wallConfig.setSelectWhereAlwayTrueCheck(false);
        // 或者更宽松的配置
        wallConfig.setConditionAndAlwayTrueAllow(true);
        wallConfig.setConditionAndAlwayFalseAllow(true);
        
        // 如果是MyBatis自动生成的查询，可以设置
        wallConfig.setConditionOpXorAllow(false);
        wallConfig.setConditionOpBitwseAllow(false);
        
        wallFilter.setConfig(wallConfig);
        return wallFilter;
    }
}