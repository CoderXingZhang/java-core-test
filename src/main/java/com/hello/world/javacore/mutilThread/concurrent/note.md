1.为什么使用ConcurrentHashMap
    - 线程不安全的HashMap，在多线程环境下，使用HashMap进行put操作会引起死循环，导致CPU利用率接近100%，所用在并发情况下不能使用HashMap
    - 效率低下的HashTable，HashTable容器使用synchronized来保证线程安全，但在线程竞争激烈的情况下，HashTable的效率非常低。当一个线程访问HashTable的同步方法时，其他线程访问HashTable的同步方法，可能会进入阻塞或者轮询状态，如线程1使用put进行添加元素，线程2不但不能使用put方法添加元素，也不能使用get方法获取元素，所以竞争越激烈效率越低。
    - ConcurrentHashmap使用锁分段技术，首先将数据分成一段一段的存储，然后给每一段数据配一把锁，当一个线程占用锁访问其中一个段数据的时候，其他段的数据时也能被其他线程访问。