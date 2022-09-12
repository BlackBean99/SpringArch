package com.example.demo;

import com.example.demo.converter.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class IpPortToStringConverter implements Converter<int, String> {

    @Override
    public String convert(IpPort ipPort) {
        log.info("Converter soutce ={}", ipPort);
        int port1 = ipPort.getPort();
        String ip = ipPort.getIp();
        HashMap<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(port1, ip);
    }
}