package com.react.pojo;

import com.react.entity.Url;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UrlMapper {

    /**查询所有系统路径配置数据
     *
     * @return 返回查询结果集
     */
    List<Url> selectAllData();

    /**新增导航栏列表数据
     *
     * @return
     */
    int addUrl(Url url);

    /**新增导航栏列表数据
     *
     * @return
     */
    int updateUrlById(Url url);

}