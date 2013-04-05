#!/bin/sh

BASE_DIR=`dirname $0`

. $BASE_DIR/setenv.sh

mvn clean install -f $BASE_DIR/../pom.xml
