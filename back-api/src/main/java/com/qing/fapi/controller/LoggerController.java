package com.qing.fapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志控制器
 *
 * @author libar
 * @date 2023/08/29
 */
@Slf4j
@RestController
@RequestMapping("/logger")
public class LoggerController {

    /**
     * 测试日志
     * @return String
     */
    @RequestMapping("/list")
    public String logger() {
        // 2. 日志打印
        log.trace("日志级别: trace");
        log.debug("日志级别: debug");
        log.info("日志级别: info");
        log.warn("日志级别: warn");
        log.error("日志级别: error");
        return "logger";
    }
}
