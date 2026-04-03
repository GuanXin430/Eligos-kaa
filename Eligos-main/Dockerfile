FROM eclipse-temurin:17-jdk-jammy

ENV TZ=GMT
ENV LANG=C.UTF-8

# 复制你本地所有文件（包含已经打好的JAR包，完全不编译！）
COPY . /opt/eligos

# 给启动脚本授权
RUN chmod +x /opt/eligos/eligos-cli/build/scriptsShadow/eligos-cli

# 强制修复JAR路径（解决找不到jar问题）
RUN mkdir -p /opt/eligos/eligos-cli/build/lib && \
    cp /opt/eligos/eligos-cli/build/libs/*.jar /opt/eligos/eligos-cli/build/lib/

# 创建全局命令
RUN ln -s /opt/eligos/eligos-cli/build/scriptsShadow/eligos-cli /usr/bin/eligos-cli

# 固定工作目录
RUN mkdir -p /dist/project /dist/result
WORKDIR /dist
VOLUME /dist/project /dist/result

ENTRYPOINT ["eligos-cli"]