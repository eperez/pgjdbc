package org.postgresql.util;

import java.sql.SQLTimeoutException;

public class PSQLTimeoutException extends SQLTimeoutException {

  private ServerErrorMessage _serverError;

  public PSQLTimeoutException(String msg, PSQLState state, Throwable cause) {
    super(msg, state == null ? null : state.getState(), cause);
  }

  public PSQLTimeoutException(String msg, PSQLState state) {
    super(msg, state == null ? null : state.getState());
  }

  public PSQLTimeoutException(ServerErrorMessage serverError) {
    super(serverError.toString(), serverError.getSQLState());
    _serverError = serverError;
  }

  public ServerErrorMessage getServerErrorMessage() {
    return _serverError;
  }
}
