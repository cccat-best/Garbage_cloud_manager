package org.sipc.tclserver.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collections;


/**
 * @author tzih
 * @since 2023.03.20
 */

public class CodeGeneratorTest {


    public static void generatorORM() {

        String url = "jdbc:mysql://114.115.240.135/rmb_tcl?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "mysql57T123";

        FastAutoGenerator
                //连接数据库
                .create(url, username, password)
                //全局配置
                .globalConfig(builder -> builder.author("tzih")
                        .outputDir("src/main/java"))
                //包配置
                .packageConfig(builder -> builder.parent("com.sipc")
                        .moduleName("tclserver")
                        .entity("pojo.domain")
                        .mapper("mapper")
                        .xml("mapper.xml")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, "src/main/resources/mapper")))
                //策略配置,要生成的表的表名
                .strategyConfig(builder -> builder.addInclude(
//                        "district",
                        "garbage"
//                        "garbage_record"
//                        "log_detail",
//                        "log_operate",
//                        "log_set",
//                        "municipality",
//                        "province"
                                )
                                //实体类策略配置，enableFileOverride覆盖原文件
                                .entityBuilder().enableLombok().enableTableFieldAnnotation().idType(IdType.AUTO).logicDeleteColumnName("is_deleted").enableFileOverride()
//                        .entityBuilder().enableLombok().enableTableFieldAnnotation().idType(IdType.AUTO).enableFileOverride()
                                //mapper类策略配置
//                        .mapperBuilder().mapperAnnotation(Mapper.class).enableFileOverride()
                                .mapperBuilder().mapperAnnotation(Mapper.class)
                )
                //模板配置
                .templateEngine(new FreemarkerTemplateEngine())
                .templateConfig(builder -> {
                    //禁用相关的模板
                    builder.disable(TemplateType.CONTROLLER)
                            .disable(TemplateType.SERVICE)
                            .disable(TemplateType.SERVICE_IMPL);
                })
                .execute();
    }

    public static void main(String[] args) {
        generatorORM();
    }

}
