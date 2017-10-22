package org.postgresql.util;

import java.sql.SQLInvalidAuthorizationSpecException;

public class PSQLInvalidAuthorizationSpecException extends SQLInvalidAuthorizationSpecException {

  private ServerErrorMessage _serverError;

  public PSQLInvalidAuthorizationSpecException(String msg, PSQLState state, Throwable cause) {
    super(msg, state == null ? null : state.getState(), cause);
  }

  public PSQLInvalidAuthorizationSpecException(String msg, PSQLState state) {
    super(msg, state == null ? null : state.getState());
  }

  public PSQLInvalidAuthorizationSpecException(ServerErrorMessage serverError) {
    super(serverError.toString(), serverError.getSQLState());
    _serverError = serverError;
  }

  public ServerErrorMessage getServerErrorMessage() {
    return _serverError;
  }
}
