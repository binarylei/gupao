package com.gupaoedu.vip.pattern.homework.day05.adapter.now;

import java.util.List;

/**
 * 新的代码需要同时支持导出为 excel 和 csv 格式
 *
 * @author leigang
 * @version 2019-03-23
 */
public interface ExportAdaptor {

    void export(List list);
}
