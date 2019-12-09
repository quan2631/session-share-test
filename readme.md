# 1. 背景
```
  本工程集成了springboot2和session，第一验证有效期，第二验证session共享。仅供学习交流。
```
# 2. 需知
```
需redis数据库。
```
# 3. 如何验证session有效性
```
第一步：模拟登陆，认证通过后返回session
http://localhost:10041/setSession?value=quanxin
返回：
a6c3102b-3054-4f97-8682-4a2dd46d8357

第二部：获取session（有效期内）
http://localhost:10041/getSession

{"sessionId":"a6c3102b-3054-4f97-8682-4a2dd46d8357","value":"quanxin"}

第三部：获取session（有效期外）
http://localhost:10041/getSession

{"sessionId":"51451e34-0319-40e8-b2bf-e8d64b593cc0","value":null}

```
结论：可以调用获取session的接口，如果有效期内，则返回的session与登陆一致；如果返回不一致，则超出有效期。
# 4. 超时时间设置
```
server.servlet.session.timeout=PT30S
控制台打印：
setSession maxInactiveInterval: 30
getSession maxInactiveInterval: 30
```
# 5. session共享验证
```
http://localhost:10041/setSession?value=quanxin

e3fd4883-8736-4e6d-b62b-becc1d9a805d

http://localhost:10041/getSession

{"sessionId":"e3fd4883-8736-4e6d-b62b-becc1d9a805d","value":"quanxin"}

http://localhost:10042/getSession

{"sessionId":"e3fd4883-8736-4e6d-b62b-becc1d9a805d","value":"quanxin"}
```
# 6. 参考资料
```
https://blog.csdn.net/bowei026/article/details/86531614
```
