package com.wkcto;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class AutoMapper {


        public static void main(String[] args) {

            //目前2022年2月4日这个可以用 == 第27行必须要加MyBatis-plus这上一级目录才能生成到目录下
            FastAutoGenerator.create("jdbc:mysql://localhost:3306/province?useUnicode=true&useSSL=false&characterEncoding=utf8", "root", "333")
                    .globalConfig(builder -> {
                        builder.author("WordLin") // 设置作者
                                .enableSwagger() // 开启 swagger 模式  可理解为接口文档规范
                                .fileOverride() // 覆盖已生成文件
                                .outputDir(System.getProperty("user.dir") + "/MyBatis-plus/src/main/java"); // 指定输出目录
                    })
                    .packageConfig(builder -> {
                        builder.parent("com.wkcto") // 设置父包名
                                .moduleName("order") // 设置父包模块名
                                .entity("entity")
                                .controller("controller")
                                .service("service")
                                .serviceImpl("impl") //设置包名
                                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + "/MyBatis-plus/src/main/resources/mapper/")); // 设置mapperXml生成路径
                    })
                    .strategyConfig(builder -> {
                        builder.addInclude("stu","dept")// 设置需要生成的表名 不使用该方法默认生成全表
                                .addTablePrefix("t_", "c_") // 设置过滤表前缀
                                .serviceBuilder()//Service配置
                                .formatServiceFileName("%sService")//%s = 表名  表名Service
                                .formatServiceImplFileName("%sServiceImp")//同上
                                .entityBuilder()//实体类配置 一般都是表名
                                .enableLombok()//开启Lombok 开启 swagger 模式 就没必要使用这个
                                .logicDeleteColumnName("deleted")//逻辑删除字段对应数据库那个字段
                                .logicDeletePropertyName("deleteFlag")//逻辑删除字段对应实体类库那个字段
                                .controllerBuilder()//Controller配置
                                .formatFileName("%sController")
                                .enableRestStyle()//开启生成@RestController控制器
                                .mapperBuilder()//mapper配置
                                .formatMapperFileName("%sMapper")
                                .formatXmlFileName("%sMapper")
                                .enableMapperAnnotation()//开启@Mapper
                                .superClass(BaseMapper.class);//继承的父类
                    })
                    // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                    .templateEngine(new FreemarkerTemplateEngine())
                    .execute();//傻逼代码 生成完自己打开目录


        /*FastAutoGenerator.create("jdbc:mysql://192.168.1.4:3306/province", "root", "333")
                .globalConfig(builder -> {
                    builder.author("WordLin") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("System.getProperty(\"user.dir\") +\"/src/main/java\""); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.wkcto") // 设置父包名
                            .moduleName("order") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") +"/src/main/java")); // 设置mapperXml生成路径 前边是取项目路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("stu") // 设置需要生成的表名,不设置生成全表
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();*/
        /*new DataSourceConfig.Builder("jdbc:mysql://192.168.1.4:3306/province","root","333")
                .build();

        new GlobalConfig.Builder()
                .fileOverride()
                .outputDir("/src/main/java")
                .author("WordLin")
                .enableKotlin()
                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")
                .build();


        new PackageConfig.Builder()
                .parent("com.wkcto")
                .moduleName("order")
                .entity("entity")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .xml("mapper.xml")
                .controller("controller")
                .other("other")
                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + "/src/main/java"))
                .build();
        new TemplateConfig.Builder()
                .disable(TemplateType.ENTITY)
                .entity("/templates/entity.java")
                .service("/templates/service.java")
                .serviceImpl("/templates/serviceImpl.java")
                .mapper("/templates/mapper.java")
                .mapperXml("/templates/mapper.xml")
                .controller("/templates/controller.java")
                .build();

        new InjectionConfig.Builder()
                .beforeOutputFile((tableInfo, objectMap) -> {
                    System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
                })
                .customMap(Collections.singletonMap("test", "baomidou"))
                .customFile(Collections.singletonMap("test.txt", "/templates/test.vm"))
                .build();


        new StrategyConfig.Builder()
                .enableCapitalMode()
                .enableSkipView()
                .disableSqlFilter()
                .likeTable(new LikeTable("USER"))
                .addInclude("t_simple")
                .addTablePrefix("t_", "c_")
                .addFieldSuffix("_flag")
                .build();

        new StrategyConfig.Builder()
                .entityBuilder()
                .disableSerialVersionUID()
                .enableChainModel()
                .enableLombok()
                .enableRemoveIsPrefix()
                .enableTableFieldAnnotation()
                .enableActiveRecord()
                .versionColumnName("version")
                .versionPropertyName("version")
                .logicDeleteColumnName("deleted")
                .logicDeletePropertyName("deleteFlag")
                .naming(NamingStrategy.no_change)
                .columnNaming(NamingStrategy.underline_to_camel)
                .addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")
                .addIgnoreColumns("age")
                .idType(IdType.AUTO)
                .formatFileName("%sEntity")
                .build();

        new StrategyConfig.Builder()
                .controllerBuilder()
                .enableHyphenStyle()
                .enableRestStyle()
                .formatFileName("%sAction")
                .build();

        new StrategyConfig.Builder()
                .serviceBuilder()
                .formatServiceFileName("%sService")
                .formatServiceImplFileName("%sServiceImp")
                .build();

        new StrategyConfig.Builder()
                .mapperBuilder()
                .superClass(BaseMapper.class)
                .enableMapperAnnotation()
                .enableBaseResultMap()
                .enableBaseColumnList()
                .formatMapperFileName("%sDao")
                .formatXmlFileName("%sXml")
                .build();
*/
    }

}
