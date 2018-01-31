package com.st.factory;

import com.st.bbs.action.BbsDeleteAction;
import com.st.bbs.action.BbsListAction;
import com.st.bbs.action.BbsModifyAction;
import com.st.bbs.action.BbsViewAction;
import com.st.bbs.action.BbsWriteAction;
import com.st.bbs.action.MemberBbsListAction;
import com.st.board.action.BoardDeleteAction;
import com.st.board.action.BoardListAction;
import com.st.board.action.BoardModifyAction;
import com.st.board.action.BoardViewAction;
import com.st.board.action.BoardWriteAction;
import com.st.board.action.MemberBoardListAction;
import com.st.board.action.MemberMvBoardContentAction;
import com.st.groupmember.action.GroupMemberAcceptAction;
import com.st.groupmember.action.GroupMemberApplyAction;
import com.st.groupmember.action.GroupMemberListAction;
import com.st.groupmember.action.GroupMemberRefuseMemberAction;
import com.st.groupmember.action.MemberGroupListAction;
import com.st.groupmember.action.MemberGroupMemberViewAction;
import com.st.groupmember.action.MemberMoveOut;
import com.st.groupmember.action.MemberOutAction;
import com.st.reply.action.ReplyDeleteAction;
import com.st.reply.action.ReplyListAction;
import com.st.reply.action.ReplyWriteAction;
import com.st.studygroup.action.*;
import com.st.studygroup.schedule.action.MemberStudyGroupScheduleListAction;
import com.st.studygroup.schedule.action.MemberStudyGroupScheduleListXml;
import com.st.studygroup.schedule.action.MemberStudyGroupTodayScheduleListXml;
import com.st.studygroup.schedule.action.StudyGroupKingScheduleListXml;
import com.st.studygroup.schedule.action.StudyGroupScheduleDeleteAction;
import com.st.studygroup.schedule.action.StudyGroupScheduleListAction;
import com.st.studygroup.schedule.action.StudyGroupScheduleModifyAction;
import com.st.studygroup.schedule.action.StudyGroupScheduleViewAction;
import com.st.studygroup.schedule.action.StudyGroupScheduleWriteAction;
import com.st.studygroup.schedule.action.StudyGroupTodayScheduleListXml;

public class StudyGroupActionFactory {
	
	private static BoardDeleteAction boardDeleteAction;
	private static BoardListAction boardListAction;
	private static BoardModifyAction boardModifyAction;
	private static BoardViewAction boardViewAction;
	private static BoardWriteAction boardWriteAction;
	private static MemberBoardListAction memberBoardListAction;
	private static MemberMvBoardContentAction memberMvBoardContentAction;
	
	
	private static StudyGroupListAction studyGroupListAction;
	private static StudyGroupCreateAction studyGroupCreateAction;
	private static StudyGroupDeleteAction studyGroupDeleteAction;
	private static StudyGroupModifyAction studyGroupModifyAction;
	private static StudyGroupViewAction studyGroupViewAction;
	private static StudyGroupMyListAction studyGroupMyListAction;
	private static StudyGroupMyGroupContentAction studyGroupMyGroupContentAction;
	private static StudyGroupMoveModifyAction studyGroupMoveModifyAction;
	private static StudyGroupApplyAction studyGroupApplyAction;
	private static StudyGroupIncludeMeAction studyGroupIncludeMeAction;
	private static StudyGroupIncludeMeGroupAction studyGroupIncludeMeGroupAction;
	
	private static GroupMemberRefuseMemberAction groupMemberRefuseMemberAction;
	private static GroupMemberListAction groupMemberListAction;
	private static GroupMemberApplyAction groupMemberApplyAction;
	private static GroupMemberAcceptAction groupMemberAcceptAction;
	private static MemberGroupMemberViewAction memberGroupMemberViewAction;
	private static MemberGroupListAction memberGroupListAction;
	private static MemberMoveOut memberMoveOut;
	private static MemberOutAction memberOutAction;

	private static BbsWriteAction bbsWriteAction;
	private static BbsModifyAction bbsModifyAction;
	private static BbsViewAction bbsViewAction;
	private static BbsDeleteAction bbsDeleteAction;
	private static BbsListAction bbsListAction;
	private static MemberBbsListAction memberBbsListAction; 
	
	private static StudyGroupScheduleDeleteAction studyGroupScheduleDeleteAction;
	private static StudyGroupScheduleListAction studyGroupScheduleListAction;
	private static StudyGroupScheduleModifyAction studyGroupScheduleModifyAction;
	private static StudyGroupScheduleViewAction studyGroupScheduleViewAction;
	private static StudyGroupScheduleWriteAction studyGroupScheduleWriteAction;
	private static MemberStudyGroupScheduleListAction memberStudyGroupScheduleListAction;
	private static MemberStudyGroupScheduleListXml memberStudyGroupScheduleListXml;
	private static MemberStudyGroupTodayScheduleListXml memberStudyGroupTodayScheduleListXml;
	private static StudyGroupKingScheduleListXml studyGroupKingScheduleListXml;
	private static StudyGroupTodayScheduleListXml studyGroupTodayScheduleListXml;
	
	
	private static ReplyDeleteAction replyDeleteAction;
	private static ReplyListAction replyListAction;
	private static ReplyWriteAction replyWriteAction;
	
	static {
		boardDeleteAction = new BoardDeleteAction();
		boardListAction = new BoardListAction();
		boardModifyAction = new BoardModifyAction();
		boardViewAction = new BoardViewAction();
		boardWriteAction = new BoardWriteAction();
		memberBoardListAction = new MemberBoardListAction();
		memberMvBoardContentAction = new MemberMvBoardContentAction();
		
		
		studyGroupListAction = new StudyGroupListAction();
		studyGroupCreateAction = new StudyGroupCreateAction();
		studyGroupDeleteAction = new StudyGroupDeleteAction();
		studyGroupModifyAction = new StudyGroupModifyAction();
		studyGroupViewAction = new StudyGroupViewAction();
		studyGroupMyListAction = new StudyGroupMyListAction();
		studyGroupMyGroupContentAction = new StudyGroupMyGroupContentAction();
		studyGroupMoveModifyAction = new StudyGroupMoveModifyAction();
		studyGroupApplyAction = new StudyGroupApplyAction();
		studyGroupIncludeMeAction = new StudyGroupIncludeMeAction();
		studyGroupIncludeMeGroupAction = new StudyGroupIncludeMeGroupAction();
		
		bbsWriteAction = new BbsWriteAction();
		bbsModifyAction = new BbsModifyAction();
		bbsViewAction = new BbsViewAction();
		bbsDeleteAction = new BbsDeleteAction();
		bbsListAction = new BbsListAction();
		memberBbsListAction = new MemberBbsListAction();
		
		studyGroupScheduleDeleteAction = new StudyGroupScheduleDeleteAction();
		studyGroupScheduleListAction = new StudyGroupScheduleListAction();
		studyGroupScheduleModifyAction = new StudyGroupScheduleModifyAction();
		studyGroupScheduleViewAction = new StudyGroupScheduleViewAction();
		studyGroupScheduleWriteAction = new StudyGroupScheduleWriteAction();
		memberStudyGroupScheduleListAction = new MemberStudyGroupScheduleListAction();
		memberStudyGroupScheduleListXml = new MemberStudyGroupScheduleListXml();
		memberStudyGroupTodayScheduleListXml = new MemberStudyGroupTodayScheduleListXml();
		studyGroupKingScheduleListXml = new StudyGroupKingScheduleListXml();
		studyGroupTodayScheduleListXml = new StudyGroupTodayScheduleListXml();
		
		groupMemberRefuseMemberAction = new GroupMemberRefuseMemberAction();
		groupMemberListAction = new GroupMemberListAction();
		groupMemberApplyAction = new GroupMemberApplyAction();
		groupMemberAcceptAction = new GroupMemberAcceptAction();
		memberGroupMemberViewAction = new MemberGroupMemberViewAction();
		memberGroupListAction = new MemberGroupListAction();
		memberMoveOut = new MemberMoveOut();
		memberOutAction = new MemberOutAction();
		
		
		replyDeleteAction = new ReplyDeleteAction();
		replyListAction = new ReplyListAction();
		replyWriteAction = new ReplyWriteAction();
	}
	
	
	
	public static GroupMemberRefuseMemberAction getGroupMemberRefuseMemberAction() {
		return groupMemberRefuseMemberAction;
	}

	public static MemberStudyGroupTodayScheduleListXml getMemberStudyGroupTodayScheduleListXml() {
		return memberStudyGroupTodayScheduleListXml;
	}

	public static MemberStudyGroupScheduleListXml getMemberStudyGroupScheduleListXml() {
		return memberStudyGroupScheduleListXml;
	}

	public static StudyGroupTodayScheduleListXml getStudyGroupTodayScheduleListXml() {
		return studyGroupTodayScheduleListXml;
	}

	public static MemberOutAction getMemberOutAction() {
		return memberOutAction;
	}

	public static MemberMoveOut getMemberMoveOut() {
		return memberMoveOut;
	}

	public static MemberMvBoardContentAction getMemberMvBoardContentAction() {
		return memberMvBoardContentAction;
	}

	public static StudyGroupKingScheduleListXml getStudyGroupKingScheduleListXml() {
		return studyGroupKingScheduleListXml;
	}

	public static MemberGroupListAction getMemberGroupListAction() {
		return memberGroupListAction;
	}

	public static MemberGroupMemberViewAction getMemberGroupMemberViewAction() {
		return memberGroupMemberViewAction;
	}

	public static MemberStudyGroupScheduleListAction getMemberStudyGroupScheduleListAction() {
		return memberStudyGroupScheduleListAction;
	}

	public static MemberBbsListAction getMemberBbsListAction() {
		return memberBbsListAction;
	}

	public static MemberBoardListAction getMemberBoardListAction() {
		return memberBoardListAction;
	}

	public static StudyGroupIncludeMeGroupAction getStudyGroupIncludeMeGroupAction() {
		return studyGroupIncludeMeGroupAction;
	}

	public static ReplyDeleteAction getReplyDeleteAction() {
		return replyDeleteAction;
	}

	public static ReplyListAction getReplyListAction() {
		return replyListAction;
	}

	public static ReplyWriteAction getReplyWriteAction() {
		return replyWriteAction;
	}

	public static StudyGroupIncludeMeAction getStudyGroupIncludeMeAction() {
		return studyGroupIncludeMeAction;
	}

	public static GroupMemberAcceptAction getGroupMemberAcceptAction() {
		return groupMemberAcceptAction;
	}

	public static GroupMemberApplyAction getGroupMemberApplyAction() {
		return groupMemberApplyAction;
	}

	public static StudyGroupApplyAction getStudyGroupApplyAction() {
		return studyGroupApplyAction;
	}

	public static GroupMemberListAction getGroupMemberListAction() {
		return groupMemberListAction;
	}

	public static StudyGroupScheduleDeleteAction getStudyGroupScheduleDeleteAction() {
		return studyGroupScheduleDeleteAction;
	}

	public static StudyGroupScheduleListAction getStudyGroupScheduleListAction() {
		return studyGroupScheduleListAction;
	}

	public static StudyGroupScheduleModifyAction getStudyGroupScheduleModifyAction() {
		return studyGroupScheduleModifyAction;
	}

	public static StudyGroupScheduleViewAction getStudyGroupScheduleViewAction() {
		return studyGroupScheduleViewAction;
	}

	public static StudyGroupScheduleWriteAction getStudyGroupScheduleWriteAction() {
		return studyGroupScheduleWriteAction;
	}

	public static BbsWriteAction getBbsWriteAction() {
		return bbsWriteAction;
	}

	public static BbsModifyAction getBbsModifyAction() {
		return bbsModifyAction;
	}

	public static BbsViewAction getBbsViewAction() {
		return bbsViewAction;
	}

	public static BbsDeleteAction getBbsDeleteAction() {
		return bbsDeleteAction;
	}

	public static BbsListAction getBbsListAction() {
		return bbsListAction;
	}

	public static StudyGroupMyGroupContentAction getStudyGroupMyGroupContentAction() {
		return studyGroupMyGroupContentAction;
	}

	public static StudyGroupMyListAction getStudyGroupMyListAction() {
		return studyGroupMyListAction;
	}

	public static StudyGroupListAction getStudyGroupListAction() {
		return studyGroupListAction;
	}

	public static StudyGroupCreateAction getStudyGroupCreateAction() {
		return studyGroupCreateAction;
	}

	public static StudyGroupDeleteAction getStudyGroupDeleteAction() {
		return studyGroupDeleteAction;
	}

	public static StudyGroupModifyAction getStudyGroupModifyAction() {
		return studyGroupModifyAction;
	}

	public static StudyGroupViewAction getStudyGroupViewAction() {
		return studyGroupViewAction;
	}

	public static BoardDeleteAction getBoardDeleteAction() {
		return boardDeleteAction;
	}

	public static BoardListAction getBoardListAction() {
		return boardListAction;
	}

	public static BoardModifyAction getBoardModifyAction() {
		return boardModifyAction;
	}

	public static BoardViewAction getBoardViewAction() {
		return boardViewAction;
	}

	public static BoardWriteAction getBoardWriteAction() {
		return boardWriteAction;
	}

	public static StudyGroupMoveModifyAction getStudyGroupMoveModifyAction() {
		return studyGroupMoveModifyAction;
	}
	
	
	
	
}
