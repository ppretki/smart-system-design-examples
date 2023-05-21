FROM openjdk:17-alpine

RUN addgroup -S -g 1000 ssd && adduser -u 1000 -S ssd -G ssd

COPY docker-entrypoint.sh /home/ssd/docker-entrypoint.sh
COPY healthcheck.sh /home/ssd/healthcheck.sh
COPY target/playback-1.0.0.jar /home/ssd/playback.jar

RUN chown -R ssd:ssd /home/ssd

USER ssd

HEALTHCHECK CMD "/home/sima/healthcheck.sh"

EXPOSE 8080

CMD ["/home/sima/docker-entrypoint.sh"]
