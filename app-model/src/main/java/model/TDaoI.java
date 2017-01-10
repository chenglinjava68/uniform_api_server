package model;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDaoI<T> {
    int count(@Param("deepLink")Integer deepLink, @Param("whereParam")String whereParam);
        List<T> select(
            @Param("deepLink")Integer deepLink,
        @Param("whereParam")String   whereParam,
        @Param("orderParam")String   orderParam,
        @Param("limitStart")Integer  limitStart,
        @Param("limitLength")Integer limitLength
        );
        List<T> getByIdList(@Param("deepLink")Integer deepLink,
                        @Param("idList")List<Integer> idList);

        T get(@Param("deepLink")Integer deepLink,
              @Param("whereParam")String whereParam);
        T getById(@Param("deepLink")Integer deepLink,
                        @Param("id")Integer id);
        int isExist(@Param("id")Integer id);

        int insert(T po);
        int update(T po);
        int updateSql(@Param("sql")String sql);
}