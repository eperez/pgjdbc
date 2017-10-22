package org.postgresql.util;

import java.sql.SQLNonTransientConnectionException;

public class PSQLNonTransientConnectionException extends SQLNonTransientConnectionException {

  private ServerErrorMessage _serverError;

  public PSQLNonTransientConnectionException(String msg, PSQLState state, Throwable cause) {
    super(msg, state == null ? null : state.getState(), cause);
  }

  public PSQLNonTransientConnectionException(String msg, PSQLState state) {
    super(msg, state == null ? null : state.getState());
  }

  public PSQLNonTransientConnectionException(ServerErrorMessage serverError) {
    super(serverError.toString(), serverError.getSQLState());
    _serverError = serverError;
  }

  public ServerErrorMessage getServerErrorMessage() {
    return _serverError;
  }
}
