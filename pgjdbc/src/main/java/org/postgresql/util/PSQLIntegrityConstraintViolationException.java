package org.postgresql.util;

import java.sql.SQLIntegrityConstraintViolationException;

public class PSQLIntegrityConstraintViolationException extends SQLIntegrityConstraintViolationException {

  private ServerErrorMessage _serverError;

  public PSQLIntegrityConstraintViolationException(String msg, PSQLState state, Throwable cause) {
    super(msg, state == null ? null : state.getState(), cause);
  }

  public PSQLIntegrityConstraintViolationException(String msg, PSQLState state) {
    super(msg, state == null ? null : state.getState());
  }

  public PSQLIntegrityConstraintViolationException(ServerErrorMessage serverError) {
    super(serverError.toString(), serverError.getSQLState());
    _serverError = serverError;
  }

  public ServerErrorMessage getServerErrorMessage() {
    return _serverError;
  }
}
