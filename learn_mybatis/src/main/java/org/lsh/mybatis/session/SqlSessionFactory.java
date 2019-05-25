package org.lsh.mybatis.session;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.lsh.mybatis.config.Configuration;
import org.lsh.mybatis.config.MappedStatement;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

/**
 *  java类的类型
 * lsh
 * 2018/8/24 10:48
 */
public class SqlSessionFactory {
    private Configuration conf=new Configuration();
    public SqlSessionFactory(){
        loadDbInfo();
        loadMappersInfo();
    }

    public static final String MAPPER_CONFIG_LOCATION="mappers";
    public static final String DB_CONFIG_FILE = "db.properties";

    private void loadDbInfo(){
        //加载数据库配置文件
        InputStream dbIn = SqlSessionFactory.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILE);
        Properties p = new Properties();
        try {
            p.load(dbIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        conf.setJdbcDriver(p.get("jdbc.driver").toString());
        conf.setJdbcUrl(p.get("jdbc.url").toString());
        conf.setJdbcUserName(p.get("jdbc.username").toString());
        conf.setJdbcPassword(p.get("jdbc.password").toString());
    }

    private void loadMappersInfo(){
        URL resources = null;
        resources = SqlSessionFactory.class.getClassLoader().getResource(MAPPER_CONFIG_LOCATION);
        File mappers = new File(resources.getFile());
        if (mappers.isDirectory()){
            File[] listFiles = mappers.listFiles();
            for (File file:listFiles) {
                loadMapperInfo(file);
            }
        }
    }
    //加载指定的mapper.xml文件
    private void loadMapperInfo(File file){
        //创建saxReader对象
        SAXReader reader= new SAXReader();
        //通过read方法读取一个文件 转换成document对象
        Document document=null;
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        //获取根节点元素对象<Mapper>
        Element node=document.getRootElement();
        //获取命名空间
        String namespace=node.attribute("namespace").getData().toString();
        //获取select子节点列表
        List<Element> selects = node.elements("select");
        //遍历selects节点，将信息记录到MappedStatement对象，并登记到configuration对象中
        for (Element element:selects) {
            MappedStatement mappedStatement=new MappedStatement();
            String id = element.attribute("id").getData().toString();
            String resultTyp = element.attribute("resultType").getData().toString();
            String sql = element.getData().toString();
            String sourceId=namespace+"."+id;

            mappedStatement.setSourceId(sourceId);
            mappedStatement.setResultType(resultTyp);
            mappedStatement.setSql(sql);
            mappedStatement.setNamespace(namespace);

            conf.getMapperStatements().put(sourceId,mappedStatement);

        }
    }

    public SqlSession openSession(){
        return new DefaultSqlSession(conf);
    }
}
