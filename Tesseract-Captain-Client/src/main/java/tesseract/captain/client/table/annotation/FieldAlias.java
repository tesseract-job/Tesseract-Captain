package tesseract.captain.client.table.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 属性名修改后，添加这个注解表示替换对应的属性的名字
 *
 * @author nickle
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAlias {
    /**
     * 需要替换的列名
     *
     * @return
     */
    String value();
}
