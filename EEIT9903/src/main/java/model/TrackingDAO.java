package model;

import java.util.List;

public interface TrackingDAO {

	List<Tracking> select(String account);

	int delete(TrackingId trackingId);

	Tracking insert(Tracking tracking);

}