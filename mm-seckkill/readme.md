### 秒杀优化方案
>* 使用redis预减库存，并做好内存标志
>* 使用乐观锁防止高并发场景
>* 使用消息队列进行异步处理
>* 使用验证码限流
>* 利用redis实现限流注解（每秒最多方位次数）

### 安全
>* 掩藏秒杀接口,请求的时候才获取该接口