package tesseract.captain.generator.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 数据源工厂接口
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/5 09:23
 */
public interface DataSourceFactory {
    /**
     * 设置数据源属性
     * @param props
     */
    void setProperties(Properties props);

    /**
     * 获取数据源
     * @return
     */
    DataSource getDataSource();
}
