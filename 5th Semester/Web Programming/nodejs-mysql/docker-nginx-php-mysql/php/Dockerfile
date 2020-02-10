FROM php:7.3-fpm

RUN apt-get update && apt-get install -y libzip-dev libpng-dev git zip unzip libgd3 libgd-tools  libxml2 libxml2-dev mariadb-client && docker-php-ext-install pdo_mysql  mysqli gd soap zip
