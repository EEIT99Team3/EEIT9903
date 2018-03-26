package model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Balance_sheetPK implements Serializable{
	
	private String stock_id;
	private Integer bs_year;
	private Integer bs_season;

	public Balance_sheetPK() {
		
	}
	public String getStock_id() {
		return stock_id;
	}

	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}

	public Integer getBs_year() {
		return bs_year;
	}

	public void setBs_year(Integer bs_year) {
		this.bs_year = bs_year;
	}

	public Integer getBs_season() {
		return bs_season;
	}

	public void setBs_season(Integer bs_season) {
		this.bs_season = bs_season;
	}
	public Balance_sheetPK(String stock_id, Integer bs_year, Integer bs_season) {
		this.stock_id = stock_id;
		this.bs_year = bs_year;
		this.bs_season = bs_season;
	}
	
    @Override
	public String toString() {
		return "Balance_sheetPK [stock_id=" + stock_id + ", bs_year=" + bs_year + ", bs_season=" + bs_season + "]";
	}

	@Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Balance_sheetPK pk = (Balance_sheetPK) o;
        return Objects.equals( stock_id, pk.stock_id ) &&
               Objects.equals( bs_year, pk.bs_year ) &&
               Objects.equals( bs_season, pk.bs_season );
    }

    @Override
    public int hashCode() {
        return Objects.hash( stock_id, bs_year, bs_season);
    }

	
}
