大型分布式网站架构设计与实践 笔记
================================

一、SOA
1. 序列化、反序列化
将对象转换为二进制流的过程称为对象的序列化
将二进制流恢复为对象的过程称为对象的反序列化

java 内置的序列化、Hessian 序列化
SerializeTest.java

2. TCP
Provider.java

3. Http
Server.java
HttpClientTest.java
Mail163Login.java



二、基础设施
1. memcache
sudo apt-get install libevent-dev
ls -al /usr/lib | grep libevent

wget http://www.memcached.org/files/memcached-1.4.17.tar.gz
tar -xf memcached-1.4.17.tar.gz
cd memcached-1.4.17
./configure
make
sudo make install

启动memcache 服务：
memcached -d -m 10 -u root -l 10.50.90.42 -p 11211 -c 32 -P /tmp/memcached.pid
-- ./memcached -d -m 64 -p 11211 -l 10.50.90.2 -u hadoop -c 32
参数的含义如下：
-d 表示启动的是一个守护进程；
-m 指定分配给memcache 的内存数量，单位是MB，这里指定的是10 MB。
-u 指定运行memcache 的用户，这里指定的是root；
-l 指定监听的服务器的IP 地址；
-p 设置memcache 监听的端口，这里指定的是11211；
-c 指定最大允许的并发连接数，这里设置为32；
-P 指定memcache 的pid 文件保存的位置。

ps aux | grep memcache
telnet 10.50.90.2 11211

关闭memcache 服务：
kill 'cat /tmp/memcached.pid'



