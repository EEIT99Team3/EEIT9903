package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Cash_flow_statementPK implements Serializable{
	
	private String stock_id;
	private Integer cf_year;
	private Integer cf_season;
	
	public Cash_flow_statementPK() {

	}

	public Cash_flow_statementPK(String stock_id, Integer cf_year, Integer cf_season) {
		this.stock_id = stock_id;
		this.cf_year = cf_year;
		this.cf_season = cf_season;
	}
	
    @Override
	public String toString() {
		return "Cash_flow_statementPK [stock_id=" + stock_id + ", cf_year=" + cf_year + ", cf_season=" + cf_season
				+ "]";
	}

	@Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Cash_flow_statementPK pk = (Cash_flow_statementPK) o;
        return Objects.equals( stock_id, pk.stock_id ) &&
               Objects.equals( cf_year, pk.cf_year ) &&
               Objects.equals( cf_season, pk.cf_season );
    }

    @Override
    public int hashCode() {
        return Objects.hash( stock_id, cf_year, cf_season);
    }	

}
