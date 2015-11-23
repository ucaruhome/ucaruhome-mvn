# ucaruhome-mvn
maven version of ucaruhome

Git repository:
https://github.com/ucaruhome/ucaruhome-mvn.git

TODO 11/13/2015 jzhu
1. Unified exception handling
   异常处理
2. Do not call DAO from Action directly, encapsulate Services
   进行Service封装, Action不应该直接调用DAO
3. Re-design FileHandleUtil
   重新设计FileHandleUtil接口
4. Define Constants instead of using local String var
   使用常量类, 而不是直接使用String串
5. Config Maven to deploy ucuh-web to Tomcat 7
   配置maven, 打包部署到Tomcat 7
6. Setup local MySQL server
   搭建本地的MySQL数据库
