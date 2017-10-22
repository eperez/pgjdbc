package org.postgresql.util;

import java.sql.SQLTransientException;

public class PSQLTransientException extends SQLTransientException {

  private ServerErrorMessage _serverError;

  public PSQLTransientException(String msg, PSQLState state, Throwable cause) {
    super(msg, state == null ? null : state.getState(), cause);
  }

  public PSQLTransientException(String msg, PSQLState state) {
    super(msg, state == null ? null : state.getState());
  }

  public PSQLTransientException(ServerErrorMessage serverError) {
    super(serverError.toString(), serverError.getSQLState());
    _serverError = serverError;
  }

  public ServerErrorMessage getServerErrorMessage() {
    return _serverError;
  }
}
