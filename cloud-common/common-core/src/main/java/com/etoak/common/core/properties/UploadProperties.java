package com.etoak.common.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("upload")
@Data
public class UploadProperties {

    private String mapping;

    private String location;

    private List<String> types;
}
