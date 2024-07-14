package com.Dao;

import com.Beans.OriginLocation;
import java.util.List;

public interface OriginLocationDao extends BaseDao{
    List<OriginLocation> getOriginLocationCounts();
}
