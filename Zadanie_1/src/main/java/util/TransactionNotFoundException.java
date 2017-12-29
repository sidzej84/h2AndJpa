package util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Transaction with such ID has not been found")  // 404
public class TransactionNotFoundException extends RuntimeException {
}
