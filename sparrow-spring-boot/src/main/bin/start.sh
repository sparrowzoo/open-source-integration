#!/bin/bash
SERVER_NAME=recommend-data
LOG_DIR=/data/logs/recommend-data
#launcher_daemon_out=/tmp/$SERVER_NAME.log
launcher_daemon_out=/dev/null
DEPLOY_DIR=`dirname $0`/..
DEPLOY_DIR=`(cd "$DEPLOY_DIR"; pwd)`
echo "DEPLOY_DIR=$DEPLOY_DIR"
CLASSPATH="$DEPLOY_DIR/conf/"
echo "classpath=$CLASSPATH"
PIDS=`ps -ef | grep java | grep $DEPLOY_DIR |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The beast-member already started!"
    echo "PID: $PIDS"
    exit 1
fi

if [ -z "$JAVACMD" ] ; then
  if [ -n "$JAVA_HOME"  ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
      # IBM's JDK on AIX uses strange locations for the executables
      JAVACMD="$JAVA_HOME/jre/sh/java"
    else
      JAVACMD="$JAVA_HOME/bin/java"
    fi
  else
    JAVACMD=`which java`
  fi
fi
echo "JAVACMD: $JAVACMD"

if [ ! -x "$JAVACMD" ] ; then
  echo "Error: JAVA_HOME is not defined correctly."
  echo "  We cannot execute $JAVACMD"
  exit 1
fi
JAVA_OPTS="-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$LOG_DIR/deploy_service_heap.log -Djava.security.egd=file:/dev/./urandom "
JAVA_OPTS="$JAVA_OPTS -verbose:gc -Xloggc:$LOG_DIR/deploy_service_gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:CompileCommand=exclude,com/mysql/jdbc/ConnectionImpl::execSQL "
if [ -z "$OPTS_MEMORY" ] ; then
    OPTS_MEMORY="-server -Xms4G -Xmx4G -XX:MetaspaceSize=800M -XX:MaxMetaspaceSize=800M -Xss512K"
fi
DEBUG_OPTS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5066"
echo "java_opts:$JAVA_OPTS"
CMD="$JAVA_OPTS $OPTS_MEMORY -Dbasedir="$DEPLOY_DIR" -classpath $CLASSPATH  -jar $SERVER_NAME.jar --spring.config.location=./conf/application.properties "
echo "nohup $JAVACMD $CMD >$launcher_daemon_out 2>error.log &"
nohup $JAVACMD $CMD >$launcher_daemon_out 2>error.log &
if [ -z "$PIDPROC" ];then
 sleep 5
 PIDPROC=`ps -ef | grep java | grep $DEPLOY_DIR |awk '{print $2}'`
 echo "$DEPLOY_DIR run ok pid is:$PIDPROC"
else
 echo "$DEPLOY_DIR(pid:$PIDPROC) is running"
fi