#!/bin/bash

# 启动微服务的目录列表
services=("example2060" "eureka2072" "zuul2073" "auth2074" "log2076")

# 循环启动每个服务
for service in "${services[@]}"; do
    # 在新终端窗口中运行每个服务
    osascript -e "tell application \"Terminal\" to do script \"cd /Users/ayden/Desktop/WebSim-Twin/elec-twin-cloud/$service && mvn spring-boot:run\""
done
