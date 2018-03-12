package model;

public interface Income_statementDAO {

	Income_statementBean insert(Income_statementBean bean);

	Income_statementBean select(Income_statementPK pk);

}