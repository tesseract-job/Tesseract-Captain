package tesseract.captain.generator;

import lombok.extern.slf4j.Slf4j;
import tesseract.captain.server.model.dto.GraphDTO;

import java.lang.reflect.InvocationTargetException;

/**
 * 生成器入口
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/4 17:54
 */
@Slf4j
public class AutoGenerator {


    /**
     * 返回压缩包地址
     * @param graphDTO
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     */
    public String generateCode(GraphDTO graphDTO) throws IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        // TODO 参数配置校验，根据用户传递数据，动态调用生成对应的语言代码

        return "";
    }


    /**
     * 生成SQL,入库建表
     * @param graphDTO
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     */
    public boolean generateSQL(GraphDTO graphDTO) throws IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        // TODO 参数配置校验，根据用户传递数据，动态调用生成对应的建表语句、入库建表

        return false;
    }



}
