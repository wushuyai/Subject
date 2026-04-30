package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
//import com.sun.org.apache.xml.internal.security.Init;
//import jdk.internal.vm.annotation.Contended;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SubjectTypeHandlerFactory implements InitializingBean {
    @Resource
//    注入所有策略实现类
    private List<SubjectTypeHandler> subjectTypeHandlerList;
//    建立映射关系
//    RADIO   → RADIOTypeHandler
//    MULTIPLE → MultipleTypeHandler
    private Map<SubjectInfoTypeEnum, SubjectTypeHandler> handlerMap=new HashMap<>();

    public SubjectTypeHandler getHandler(int subjectType){
//找到枚举
        System.out.println("subjectType: " + subjectType);
        SubjectInfoTypeEnum subjectInfoTypeEnum = SubjectInfoTypeEnum.getByCode(subjectType);
        System.out.println("subjectInfoTypeEnum: " + subjectInfoTypeEnum);
//    根据枚举找 Handler  RADIO → RadioHandler    返回处理器
        System.out.println("handlerMap: " + handlerMap.get(subjectInfoTypeEnum));
        return handlerMap.get(subjectInfoTypeEnum);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 遍历所有策略实现类
        for (SubjectTypeHandler subjectTypeHandler : subjectTypeHandlerList) {
            // 建立映射关系：题型 -> 处理器
            handlerMap.put(subjectTypeHandler.getHandlerType(), subjectTypeHandler);
        }
    }
}
