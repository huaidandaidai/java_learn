# springmvc_learning
springmvc框架学习Demo 前段时间通过腾讯课程享学课堂中Jamse老师，学习了手写基于注解实现的SpringMvc；

# 手写springmvc
## springmvc框架核心是dispatchSevelet，继承自HttpServlet,实现了其init方法,主要做了以下几个功能
1. 扫描指定包名路径下的所有文件，将扫描结果放到list中；
2. 将list中的文件，按类上注解，分别将controller、service文件实例化，并放到map中
3. 将conroller中的@Autowried的私有属性，实例化
4. 将controller中的@RequestMapping对应的路径和相应的实例及方法匹配起来；
## 实现了doGet和doPost方法
1. 将doGet方法跳转到doPost处理
2. doPost拦截请求URL，根据URL获取对应的方法和实例，处理好方法的参数后，调用执行对应的方法；
