package com.example.hardcoredemo.modular.drools;


import org.drools.compiler.kproject.ReleaseIdImpl;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.kie.spring.annotations.KModuleAnnotationPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/*** 规则引擎配置类 */
@Configuration
public class DroolsConfig {
    //指定规则⽂件存放的⽬录
    private static final String RULES_PATH = "rules/";
    private final KieServices kieServices = KieServices.Factory.get();

    @Bean
    @ConditionalOnMissingBean
    public KieFileSystem kieFileSystem() throws IOException {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] files = resourcePatternResolver.getResources("classpath*:" + RULES_PATH + "*.*");
        String path = null;
        for (Resource file : files) {
            path = RULES_PATH + file.getFilename();
            kieFileSystem.write(ResourceFactory.newClassPathResource(path, "UTF-8"));
        }
        kieFileSystem.write("src/main/resources/rules/order-rule2.drl",
                "package rules\n" +
                        "import com.example.hardcoredemo.modular.drools.Order\n" +
                        "\n" +
                        "//规则1：100元以下, 不加分\n" +
                        "rule \"score_10\"\n" +
                        "when\n" +
                        "    $s : Order(amout <= 100)\n" +
                        "then\n" +
                        "    $s.setScore(0);\n" +
                        "    System.out.println(\"成功匹配到规则1：100元以下, 不加分 \");\n" +
                        "end\n" +
                        "\n" +
                        "//规则2：100元-500元 加100分\n" +
                        "rule \"score_20\"\n" +
                        "when\n" +
                        "    $s : Order(amout > 100 && amout <= 500)\n" +
                        "then\n" +
                        "    $s.setScore(1000);\n" +
                        "    System.out.println(\"成功匹配到规则2：100元-500元 加100分 \");\n" +
                        "end\n" +
                        "\n" +
                        "//规则3：500元-1000元 加500分\n" +
                        "rule \"score_30\"\n" +
                        "when\n" +
                        "    $s : Order(amout > 500 && amout <= 1000)\n" +
                        "then\n" +
                        "    $s.setScore(5000);\n" +
                        "    System.out.println(\"成功匹配到规则3：500元-1000元 加500分 \");\n" +
                        "end\n" +
                        "\n" +
                        "//规则4：1000元 以上 加1000分\n" +
                        "rule \"score_40\"\n" +
                        "when\n" +
                        "    $s : Order(amout > 1000)\n" +
                        "then\n" +
                        "    $s.setScore(10000);\n" +
                        "    System.out.println(\"成功匹配到规则4：1000元 以上 加1000分 \");\n" +
                        "end");
        return kieFileSystem;
    }

    @Bean
    @ConditionalOnMissingBean
    public KieContainer kieContainer() throws IOException {
        KieRepository kieRepository = kieServices.getRepository();
        kieRepository.addKieModule(kieRepository::getDefaultReleaseId);
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem());
        kieBuilder.buildAll();
        return kieServices.newKieContainer(kieRepository.getDefaultReleaseId());
    }

    @Bean
    @ConditionalOnMissingBean
    public KieBase kieBase() throws IOException {
        return kieContainer().getKieBase();
    }


//    @Bean
//    @Order(2)
//    public KieContainer kieContainer() {
//        KieRepository kieRepository = kieServices.getRepository();
//        ReleaseIdImpl releaseId = new ReleaseIdImpl("com.example","hard-core-demo","0.0.1-SNAPSHOT","jar");
//        releaseId.setSnapshotVersion("0.0.1-SNAPSHOT");
//        kieRepository.addKieModule(() -> releaseId);
//        return kieServices.getKieClasspathContainer();
//    }
//
//    @Bean
//    @Order(1)
//    public KModuleAnnotationPostProcessor KModuleAnnotationPostProcessor(){
//        return new KModuleAnnotationPostProcessor();
//    }
}
