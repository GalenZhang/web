���ͷֲ�ʽ��վ�ܹ������ʵ�� �ʼ�
================================

һ��SOA
1. ���л��������л�
������ת��Ϊ���������Ĺ��̳�Ϊ��������л�
�����������ָ�Ϊ����Ĺ��̳�Ϊ����ķ����л�

java ���õ����л���Hessian ���л�
SerializeTest.java

2. TCP
Provider.java

3. Http
Server.java
HttpClientTest.java
Mail163Login.java



����������ʩ
1. memcache
sudo apt-get install libevent-dev
ls -al /usr/lib | grep libevent

wget http://www.memcached.org/files/memcached-1.4.17.tar.gz
tar -xf memcached-1.4.17.tar.gz
cd memcached-1.4.17
./configure
make
sudo make install

����memcache ����
memcached -d -m 10 -u root -l 10.50.90.42 -p 11211 -c 32 -P /tmp/memcached.pid
-- ./memcached -d -m 64 -p 11211 -l 10.50.90.2 -u hadoop -c 32
�����ĺ������£�
-d ��ʾ��������һ���ػ����̣�
-m ָ�������memcache ���ڴ���������λ��MB������ָ������10 MB��
-u ָ������memcache ���û�������ָ������root��
-l ָ�������ķ�������IP ��ַ��
-p ����memcache �����Ķ˿ڣ�����ָ������11211��
-c ָ���������Ĳ�������������������Ϊ32��
-P ָ��memcache ��pid �ļ������λ�á�

ps aux | grep memcache
telnet 10.50.90.2 11211

�ر�memcache ����
kill 'cat /tmp/memcached.pid'



