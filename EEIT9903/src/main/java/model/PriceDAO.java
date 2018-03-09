package model;

import java.math.BigDecimal;
import java.util.List;

public interface PriceDAO {

	List<Price> select(String stockId);

	List<Price> select();

	Price insert(Price bean);

	Price update(PriceId id, BigDecimal priceOpen, BigDecimal priceClose, BigDecimal priceHighest,
			BigDecimal priceLowest, Long volume, BigDecimal peRatio, BigDecimal yieldRate);

	int delete(PriceId id);

}