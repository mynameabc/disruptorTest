package com.disruptor;

import lombok.Data;

/**
* @Description:    在disruptor中，Event代表数据，定义携带数据的事件
* @Author:         ljj
* @CreateDate:     2019/5/10 16:29
* @UpdateUser:     ljj
* @UpdateDate:     2019/5/10 16:29
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Data
public class LongEvent {

    private long value;
}
