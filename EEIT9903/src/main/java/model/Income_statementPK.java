package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Income_statementPK implements Serializable{
	
	private String stock_id;
	private Integer is_year;
	private Integer is_season;
	
	public Income_statementPK(String stock_id, Integer is_year, Integer is_season) {
		this.stock_id = stock_id;
		this.is_year = is_year;
		this.is_season = is_season;
	}

	public Income_statementPK() {

	}
	
	@Override
	public String toString() {
		return "Income_statementPK [stock_id=" + stock_id + ", is_year=" + is_year + ", is_season=" + is_season + "]";
	}
	
    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Income_statementPK pk = (Income_statementPK) o;
        return Objects.equals( stock_id, pk.stock_id ) &&
               Objects.equals( is_year, pk.is_year ) &&
               Objects.equals( is_season, pk.is_season );
    }

    @Override
    public int hashCode() {
        return Objects.hash( stock_id, is_year, is_season);
    }	

}
