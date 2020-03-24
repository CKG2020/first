package com.wspring1.demo.controller;

import com.wspring1.demo.model.Apply;
import com.wspring1.demo.model.Organization;
import com.wspring1.demo.service.IApplyService;
import com.wspring1.demo.service.IOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/super", method = RequestMethod.GET)
public class ApplyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplyController.class);

    @Resource
    private IApplyService iApplyService;
    @Resource
    private IOrganizationService iOrganizationService;

    @RequestMapping(value = "/agreeApply", method = RequestMethod.POST)
    @ResponseBody
    public String agree(@RequestBody Apply apply) {
        Integer apid = apply.getApid();
        Apply apply1 = iApplyService.findByapid(apid);
        if (apply1 == null) {
            LOGGER.debug("不同意申请");
            return "f";
        }
        else {
            //添加到Organization表中
            Organization organization = new Organization();
            organization.setOne("0");
            organization.setArea(iApplyService.findByapid(apid).getArea());
            organization.setOrganization(iApplyService.findByapid(apid).getOrganization());
            organization.setUsername(iApplyService.findByapid(apid).getPhone());
            organization.setPassword(iApplyService.findByapid(apid).getPhone());
            iOrganizationService.addoOrganization(organization);
            return "t";
        }
    }
}