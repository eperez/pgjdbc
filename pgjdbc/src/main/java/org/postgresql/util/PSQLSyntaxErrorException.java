package org.postgresql.util;

import java.sql.SQLSyntaxErrorException;

public class PSQLSyntaxErrorException extends SQLSyntaxErrorException {

  private ServerErrorMessage _serverError;

  public PSQLSyntaxErrorException(String msg, PSQLState state, Throwable cause) {
    super(msg, state == null ? null : state.getState(), cause);
  }

  public PSQLSyntaxErrorException(String msg, PSQLState state) {
    super(msg, state == null ? null : state.getState());
  }

  public PSQLSyntaxErrorException(ServerErrorMessage serverError) {
    super(serverError.toString(), serverError.getSQLState());
    _serverError = serverError;
  }

  public ServerErrorMessage getServerErrorMessage() {
    return _serverError;
  }
}
