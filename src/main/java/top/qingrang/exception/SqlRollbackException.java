package top.qingrang.exception;

/**
 * 自定义异常
 */
public class SqlRollbackException extends RuntimeException {

	public SqlRollbackException() {
		super();
	}

	public SqlRollbackException(String message) {
		super(message);
	}
}
