FROM gradle:7.4.2

RUN apt-get -y update && \
    apt-get -y install ncurses-dev gcc-multilib

USER gradle
