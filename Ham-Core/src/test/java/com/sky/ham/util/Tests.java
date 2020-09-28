package com.sky.ham.util;

import com.sky.ham.entity.MType;
import com.sky.ham.service.MTypeService;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class Tests {
    @Test
    public void reverseGenerationTest() throws Exception {
//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        File configFile = new File("src\\main\\resources\\generatorConfig_idea.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//        myBatisGenerator.generate(null);
//        System.out.println("生成完毕！");
        String localSongsPath = PropUtil.read("localSongsPath");
        System.out.println(localSongsPath);
    }

}
