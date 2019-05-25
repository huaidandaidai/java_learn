# rpc_learning
RPC框架学习Demo
`前段时间通过腾讯课程享学课堂中mark老师，学习了一下RPC框架，现复盘总结一下`

## RPC
RPC（Remote Procedure Call）--远程过程调用

## 实现RPC 框架需要解决的问题
1. 服务的注册和发现
2. 通讯问题
3. 序列化问题
4. 注册服务的实例化

## Demo中的解决方法
1. 针对通信问题，采用BIO
2. 针对序列化问题，采用serializable
3. 针对服务的实例化问题，采用反射机制
