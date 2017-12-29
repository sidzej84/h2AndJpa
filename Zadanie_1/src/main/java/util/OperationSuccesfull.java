package util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.OK, reason="Operation has been succesfull.")  // 404
public class OperationSuccesfull extends RuntimeException {
}
