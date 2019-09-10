# HashMap
总体结构：
![avatar](hashmap.png)

即数组+链表构成
在hashmap中数组也称为桶
## 负载因子
loadFactor（默认0.75），为了减缓hash冲突，当桶的个数超过
$$threshold=loadFactor*size$$
则会扩容

## 定位
key->hashcode->h->index
h和数组长度做与运算得到index
```
static int indexFor(int h, int length) {
    return h & (length-1);
}
```
## 扩容
hashmap的数组长度一定是2的次幂。可以保证length-1的二进制全是1，得到到index更加均匀，减少hash冲突。

# ConcurrentHashMap
## jdk1.7
## jdk1.8