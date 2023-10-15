package org.sipc.tclserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.sipc.tclserver.pojo.domain.Garbage;
import org.apache.ibatis.annotations.Mapper;
import org.sipc.tclserver.pojo.domain.po.TypeNumPo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tzih
 * @since 2023-10-02
 */
@Mapper
public interface GarbageMapper extends BaseMapper<Garbage> {

    List<TypeNumPo> selectStatusNumByDistrictId(Integer districtId);

}
