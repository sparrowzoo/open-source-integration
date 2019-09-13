#!/bin/sh
server_name="recommend-data"
pid=`ps -ef | grep "$server_name" | grep -v "grep" | awk '{print $2}'`
echo $pid
if [ "$pid" = "" ];then
	echo "$server_name is not running"
else
	kill -9 $pid
	echo "kill pid:$pid"
	echo "$server_name stop success"
fi