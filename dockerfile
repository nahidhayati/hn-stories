FROM sbtscala/scala-sbt:17.0.2_1.6.2_3.1.2

RUN mkdir -p /root/build/project
ADD build.sbt /root/build/
ADD ./project/plugins.sbt /root/build/project

WORKDIR /root/build
