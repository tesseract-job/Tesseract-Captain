package tesseract.captain.generator.exception;

import lombok.Data;
import lombok.Setter;

/**
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/5 14:05
 */
@Data
public class GeneratorException extends Exception{

    public int errorCode;

    public GeneratorException(int errorCode,String message){
        super(message);
        this.errorCode = errorCode;
    }
}
