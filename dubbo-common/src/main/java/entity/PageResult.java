package entity;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 分页结果集
 * @author baimingxu
 */
@Data
@AllArgsConstructor
public class PageResult<T> {
    private Long total;
    private List<T> rows;
}