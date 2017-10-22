package org.postgresql.util;

import java.sql.SQLDataException;

public class PSQLDataException extends SQLDataException {

  private ServerErrorMessage _serverError;

  public PSQLDataException(String msg, PSQLState state, Throwable cause) {
    super(msg, state == null ? null : state.getState(), cause);
  }

  public PSQLDataException(String msg, PSQLState state) {
    super(msg, state == null ? null : state.getState());
  }

  public PSQLDataException(ServerErrorMessage serverError) {
    super(serverError.toString(), serverError.getSQLState());
    _serverError = serverError;
  }

  public ServerErrorMessage getServerErrorMessage() {
    return _serverError;
  }
}
