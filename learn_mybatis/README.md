# learn_mybatis
mybatis学习

# mybatis_simple
这个工程是根据腾讯享学课堂老师讲解，实现的手写简化版的mybtis

# mybatis_test
这个工程是测试学习到的mybatis特性及用法

# learn_mybatis
最近跟着腾讯课程学习手写简化版的mybatis，仿照老师的思路复盘以下；

# mybatis核心流程的三大阶段
1. 初始化阶段：读取xml配置文件和注解中的配置信息，创建配置对象，并完成各模块的初始化工作
2. 代理阶段：封装ibatis编程模型，使用mapper接口开发的初始化工作
3. 数据读写阶段:通过SqlSession完成sql解析，参数的映射、SQL的执行、结果的解析过程；

# SqlSession 
1. SqlSession是对外提供数据访问的主要API；
2. SeqSession实际上功能都是基于Excutor来实现的！

# 实现思路
1. 创建SqlSessionFactory实例；
2. 实例化过程中加载配置文件创建configuration对象；
3. 通过factory创建sqlSession；
4. 通过sqlSession获取mapper接口动态代理；
5. 动态代理回调sqlsession中的查询方法；
6. sqlsession将查询方法转发给Executor；
7. Excutor基于jdbc访问数据库获取数据
8. Excutor通过反射将数据转换成pojo并返回给Sqlsession；
9. 将数据返回给调用者

