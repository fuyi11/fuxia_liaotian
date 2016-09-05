package com.lwk.familycontact.im;

import com.hyphenate.EMContactListener;
import com.lib.base.log.KLog;
import com.lwk.familycontact.storage.db.invite.InviteBean;
import com.lwk.familycontact.storage.db.invite.InviteDao;

/**
 * Created by LWK
 * TODO 环信好友事件监听
 * 2016/8/26
 */
public class HxContactListener implements EMContactListener
{
    @Override
    public void onContactAdded(String phone)
    {
        //增加了联系人时回调此方法
        KLog.d("HxContactListener onContactAdded: phone=" + phone);
    }

    @Override
    public void onContactDeleted(String phone)
    {
        //被删除时回调此方法
        KLog.d("HxContactListener onContactDeleted: phone=" + phone);
    }

    @Override
    public void onContactInvited(String phone, String reason)
    {
        //收到好友邀请
        KLog.d("HxContactListener onContactInvited: phone=" + phone + ",reason=" + reason);
        //存储到数据库中
        InviteBean inviteBean = new InviteBean(phone, System.currentTimeMillis());
        InviteDao.getInstance().saveIfNotHandled(inviteBean);
    }

    @Override
    public void onContactAgreed(String phone)
    {
        //好友请求被同意
        KLog.d("HxContactListener onContactAgreed: phone=" + phone);
    }

    @Override
    public void onContactRefused(String phone)
    {
        //好友请求被拒绝
        KLog.d("HxContactListener onContactRefused: phone=" + phone);
    }
}