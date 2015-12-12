package com.rrh.mapper.group;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rrh.common.mybatis.bean.FriendItemBean;
import com.rrh.common.mybatis.bean.FriendDetailBean;
import com.rrh.common.mybatis.bean.FriendListBean;
import com.rrh.common.mybatis.bean.FriendSerachBean;
import com.rrh.model.group.TbFriend;

public interface TbFriendMapper {
   
    int deleteByPrimaryKey(Integer id);
    
    int insert(TbFriend record);

    TbFriend selectByPrimaryKey(Integer id);

    List<TbFriend> selectAll();

    int updateByPrimaryKey(TbFriend record);
    
    //获取新的好友列表
    public List<FriendListBean> findNewFriendList(int userId);
    //获取我的好友列表
    public List<FriendListBean> findFriendList(int userId);
    //搜索新的好友
    public List<FriendSerachBean> serachFriend(@Param(value="userId") int userId,@Param(value="keywork") String keywork);
    //根据用户ID和好友ID查询
    public TbFriend getByUserIDAndFriendID(@Param(value="userId") int userId,@Param(value="friendId") int friendId);
    //根据用户ID和好友ID查询
    public FriendItemBean getFriendItemBean(@Param(value="userId") int userId,@Param(value="friendId") int friendId);
    //查询好友资料
    public FriendDetailBean getFriendDetail(@Param(value="friendId") int friendId);
    //根据用户ID和好友ID修改好友状态
    public int updateStatusByUserIDAndFriendID(@Param(value="userId") int userId,@Param(value="friendId") int friendId,@Param(value="status") int status);
}