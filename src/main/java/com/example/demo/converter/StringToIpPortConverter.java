package com.example.demo.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.Convert;

@Slf4j
public class StringToIpPortConverter implements Converter<String,IpPort> {

    @Override
    public IpPort convert(String source) {
        log.info("Converter soutce ={}", source);
        String[] split = source.split(",");
        String ip = split[0];
        int port = Integer.parseInt(split[1]);
        return new IpPort(ip, port);
    }
}
