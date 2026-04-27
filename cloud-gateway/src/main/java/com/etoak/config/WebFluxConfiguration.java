package com.etoak.config;

import cn.hutool.core.util.StrUtil;
import com.etoak.common.core.properties.UploadProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebFluxConfiguration implements WebFluxConfigurer {

    UploadProperties uploadProperties;

    public WebFluxConfiguration(UploadProperties uploadProperties) {
        this.uploadProperties = uploadProperties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String mapping = uploadProperties.getMapping().endsWith(StrUtil.SLASH) ?
                uploadProperties.getMapping() + "**":
                uploadProperties.getMapping() + "/**";

        String location = uploadProperties.getLocation().endsWith(StrUtil.SLASH) ?
                uploadProperties.getLocation() :
                uploadProperties.getLocation() + StrUtil.SLASH;

        registry.addResourceHandler(mapping)
                .addResourceLocations("file:" + location);
    }
}
