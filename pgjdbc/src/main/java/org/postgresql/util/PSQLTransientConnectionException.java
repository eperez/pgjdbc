package org.postgresql.util;

import java.sql.SQLTransientConnectionException;

public class PSQLTransientConnectionException extends SQLTransientConnectionException {

  private ServerErrorMessage _serverError;

  public PSQLTransientConnectionException(String msg, PSQLState state, Throwable cause) {
    super(msg, state == null ? null : state.getState(), cause);
  }

  public PSQLTransientConnectionException(String msg, PSQLState state) {
    super(msg, state == null ? null : state.getState());
  }

  public PSQLTransientConnectionException(ServerErrorMessage serverError) {
    super(serverError.toString(), serverError.getSQLState());
    _serverError = serverError;
  }

  public ServerErrorMessage getServerErrorMessage() {
    return _serverError;
  }
}
