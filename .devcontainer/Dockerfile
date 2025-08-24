FROM mcr.microsoft.com/devcontainers/java:21

# Install additional development tools including Maven
RUN apt-get update && apt-get install -y \
    curl \
    wget \
    git \
    vim \
    nano \
    tree \
    htop \
    maven \
    && rm -rf /var/lib/apt/lists/*

# Set environment variables - use the correct Java path
ENV JAVA_HOME=/usr/lib/jvm/msopenjdk-current
ENV PATH=$JAVA_HOME/bin:$PATH
ENV MAVEN_HOME=/usr/share/maven
ENV PATH=$MAVEN_HOME/bin:$PATH

# Configure Maven settings for better performance
RUN mkdir -p /home/vscode/.m2 && \
    echo '<?xml version="1.0" encoding="UTF-8"?>' > /home/vscode/.m2/settings.xml && \
    echo '<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"' >> /home/vscode/.m2/settings.xml && \
    echo '          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"' >> /home/vscode/.m2/settings.xml && \
    echo '          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">' >> /home/vscode/.m2/settings.xml && \
    echo '  <localRepository>/home/vscode/.m2/repository</localRepository>' >> /home/vscode/.m2/settings.xml && \
    echo '  <interactiveMode>false</interactiveMode>' >> /home/vscode/.m2/settings.xml && \
    echo '  <offline>false</offline>' >> /home/vscode/.m2/settings.xml && \
    echo '</settings>' >> /home/vscode/.m2/settings.xml

# Set ownership of Maven directory
RUN chown -R vscode:vscode /home/vscode/.m2

# Verify installations as root (before switching to vscode user)
RUN java -version && \
    mvn -version

# Switch to vscode user
USER vscode 