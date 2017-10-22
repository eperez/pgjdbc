package org.postgresql.util;

import java.sql.SQLTransactionRollbackException;

public class PSQLTransactionRollbackException extends SQLTransactionRollbackException {

  private ServerErrorMessage _serverError;

  public PSQLTransactionRollbackException(String msg, PSQLState state, Throwable cause) {
    super(msg, state == null ? null : state.getState(), cause);
  }

  public PSQLTransactionRollbackException(String msg, PSQLState state) {
    super(msg, state == null ? null : state.getState());
  }

  public PSQLTransactionRollbackException(ServerErrorMessage serverError) {
    super(serverError.toString(), serverError.getSQLState());
    _serverError = serverError;
  }

  public ServerErrorMessage getServerErrorMessage() {
    return _serverError;
  }
}
