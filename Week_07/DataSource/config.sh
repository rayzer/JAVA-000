#!/bin/bash
BASE_PATH=$(dirname $0)

echo "Waiting for mysql to get up"
# Give 60 seconds for master and replica to come up
sleep 60

echo "Create MySQL Servers (master / repl)"
echo "-----------------"

echo "env"
echo "$MYSQL_REPLICA_PASSWORD"
echo "$MYSQL_MASTER_PASSWORD"
echo "$MYSQL_ROOT_PASSWORD"
echo "$MYSQL_REPLICATION_USER"
echo "$MYSQL_REPLICATION_PASSWORD"

echo "* Create replication user"

mysql --host master -uroot -p$MYSQL_REPLICA_PASSWORD -AN -e 'STOP SLAVE;';
mysql --host master -uroot -p$MYSQL_MASTER_PASSWORD -AN -e 'RESET SLAVE ALL;';

mysql --host master -uroot -p$MYSQL_MASTER_PASSWORD -AN -e "CREATE USER '$MYSQL_REPLICATION_USER'@'%' IDENTIFIED WITH mysql_native_password BY '$MYSQL_REPLICATION_PASSWORD';"
mysql --host master -uroot -p$MYSQL_MASTER_PASSWORD -AN -e "GRANT REPLICATION SLAVE, REPLICATION CLIENT ON *.* TO '$MYSQL_REPLICATION_USER'@'%';"
mysql --host master -uroot -p$MYSQL_MASTER_PASSWORD -AN -e 'flush privileges;'


echo "* Set MySQL01 as master on MySQL02"

MYSQL01_Position=$(eval "mysql --host master -uroot -p$MYSQL_MASTER_PASSWORD -e 'show master status \G' | grep Position | sed -n -e 's/^.*: //p'")
MYSQL01_File=$(eval "mysql --host master -uroot -p$MYSQL_MASTER_PASSWORD -e 'show master status \G'     | grep File     | sed -n -e 's/^.*: //p'")
MASTER_IP=$(eval "getent hosts master|awk '{print \$1}'")
echo $MASTER_IP
mysql --host slave -uroot -p$MYSQL_REPLICA_PASSWORD -AN -e "CHANGE MASTER TO master_host='master', master_port=3306, \
        master_user='$MYSQL_REPLICATION_USER', master_password='$MYSQL_REPLICATION_PASSWORD', master_log_file='$MYSQL01_File', \
        master_log_pos=$MYSQL01_Position;"

echo "* Set MySQL02 as master on MySQL01"

MYSQL02_Position=$(eval "mysql --host slave -uroot -p$MYSQL_REPLICA_PASSWORD -e 'show master status \G' | grep Position | sed -n -e 's/^.*: //p'")
MYSQL02_File=$(eval "mysql --host slave -uroot -p$MYSQL_REPLICA_PASSWORD -e 'show master status \G'     | grep File     | sed -n -e 's/^.*: //p'")

REPLICA_IP=$(eval "getent hosts slave|awk '{print \$1}'")
echo $REPLICA_IP
mysql --host master -uroot -p$MYSQL_MASTER_PASSWORD -AN -e "CHANGE MASTER TO master_host='slave', master_port=3306, \
        master_user='$MYSQL_REPLICATION_USER', master_password='$MYSQL_REPLICATION_PASSWORD', master_log_file='$MYSQL02_File', \
        master_log_pos=$MYSQL02_Position;"

echo "* Start Replica on both Servers"
mysql --host slave -uroot -p$MYSQL_REPLICA_PASSWORD -AN -e "start slave;"

echo "Increase the max_connections to 2000"
mysql --host master -uroot -p$MYSQL_MASTER_PASSWORD -AN -e 'set GLOBAL max_connections=2000';
mysql --host slave -uroot -p$MYSQL_REPLICA_PASSWORD -AN -e 'set GLOBAL max_connections=2000';

mysql --host slave -uroot -p$MYSQL_REPLICA_PASSWORD -e "show slave status \G"
mysql --host master -uroot -p$MYSQL_MASTER_PASSWORD -AN -e 'source /tmp/schema.sql;'

echo "MySQL servers created!"
echo "--------------------"
echo
echo Variables available fo you :-
echo
echo MYSQL01_IP       : master
echo MYSQL02_IP       : slave