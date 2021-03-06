package com.leelit.stuer.dao;

import android.util.Log;

import com.leelit.stuer.bean.TreeholeInfo;
import com.leelit.stuer.utils.AppInfoUtils;
import com.leelit.stuer.utils.TimeUtils;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leelit on 2016/3/25.
 */
public class TreeholeDaoTest extends TestCase {

    public void testSave() throws Exception {
        List<TreeholeInfo> treeholeInfos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            TreeholeInfo info = new TreeholeInfo();
            info.setState("hehe" + i);
            info.setDatetime(TimeUtils.getCurrentTime());
            info.setUniquecode(AppInfoUtils.getUniqueCode());
            info.setPicAddress("empty");
            treeholeInfos.add(info);
        }
        TreeholeDao.save(treeholeInfos);
    }

    public void testGetAll() throws Exception {
        Log.e("tag", TreeholeDao.getAll().toString());
    }

    public void testGetComment() throws Exception {
        Log.e("tag", TreeholeDao.getComment("1319861953").toString());
    }

    public void testUpdateComment() throws Exception {
        TreeholeDao.updateUnlikeOfComment("1319861953", 0);
    }
}