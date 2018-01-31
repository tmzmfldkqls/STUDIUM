package com.st.factory;

import com.st.mypage.action.MoveMyroomScheduleAction;
import com.st.mypage.action.MyProfileEditAction;
import com.st.mypage.action.MyReservationAction;
import com.st.mypage.action.MyRoomListAction;
import com.st.mypage.action.ReservationDeleteAction;
import com.st.mypage.action.ReservationDetailAction;
import com.st.mypage.action.RsvDetailAction_host;
import com.st.studyroom.action.StudyRoomListAction;
import com.st.studyroom.action.MoveReservationAction;
import com.st.studyroom.action.MoveReservationDetailAction;
import com.st.studyroom.action.StudyRoomRegisterAction;
import com.st.studyroom.action.StudyRoomReservationAction;
import com.st.studyroom.action.ZipsearchAction;
import com.st.studyroom.schedule.action.StudyRoomScheduleListAction;

public class StudyRoomActionFactory {
	
	private static StudyRoomListAction studyRoomListAction;
	private static  MoveReservationAction  moveReservationAction;
	private static StudyRoomRegisterAction studyRoomRegisterAction;
	private static StudyRoomReservationAction studyRoomReservationAction;
	private static ZipsearchAction	zipsearchAction;
	private static MyProfileEditAction myProfileEditAction;
	private static MoveReservationDetailAction moveReservationDetailAction;
	private static StudyRoomScheduleListAction studyRoomScheduleListAction;
	private static MyReservationAction myReservationAction;
	private static ReservationDetailAction reservationDetailAction;
	private static ReservationDeleteAction reservationDeleteAction;
	private static MyRoomListAction myRoomListAction;
	private static MoveMyroomScheduleAction moveMyroomScheduleAction;
	private static RsvDetailAction_host rsvDetailAction_host;
	
	static{
		studyRoomListAction = new StudyRoomListAction();
		studyRoomRegisterAction = new StudyRoomRegisterAction();
		myProfileEditAction = new MyProfileEditAction();
		studyRoomReservationAction = new StudyRoomReservationAction();
		moveReservationAction = new MoveReservationAction();
		zipsearchAction =  new ZipsearchAction();
		moveReservationDetailAction = new MoveReservationDetailAction();
		studyRoomScheduleListAction = new StudyRoomScheduleListAction();
		myReservationAction = new MyReservationAction();
		reservationDetailAction =new ReservationDetailAction();
		reservationDeleteAction = new ReservationDeleteAction();
		myRoomListAction = new MyRoomListAction();
		moveMyroomScheduleAction = new MoveMyroomScheduleAction();
		rsvDetailAction_host = new RsvDetailAction_host();
	}
	public static RsvDetailAction_host getRsvDetailAction_host() {
		return rsvDetailAction_host;
	}
	public static MoveMyroomScheduleAction getMoveMyroomScheduleAction() {
		return moveMyroomScheduleAction;
	}
	
	public static MyRoomListAction getMyRoomListAction() {
		return myRoomListAction;
	}

	public static ReservationDeleteAction getReservationDeleteAction() {
		return reservationDeleteAction;
	}

	public static ReservationDetailAction getReservationDetailAction() {
		return reservationDetailAction;
	}

	public static MyReservationAction getMyReservationAction() {
		return myReservationAction;
	}

	public static StudyRoomScheduleListAction getStudyRoomScheduleListAction() {
		return studyRoomScheduleListAction;
	}

	public static MoveReservationDetailAction getMoveReservationDetailAction() {
		return moveReservationDetailAction;
	}

	public static ZipsearchAction getZipsearchAction() {
		return zipsearchAction;
	}

	public static StudyRoomListAction getStudyRoomListAction() {
		return studyRoomListAction;
	}
	
	public static MyProfileEditAction getMyProfileEditAction() {
		return myProfileEditAction;
	}
	
	public static StudyRoomRegisterAction getStudyRoomRegisterAction() {
		return studyRoomRegisterAction;
	}

	public static MoveReservationAction getMoveReservationAction() {
		return moveReservationAction;
	}
	//예약 페이지용 액션
	public static StudyRoomReservationAction getStudyRoomReservationAction() {
		return studyRoomReservationAction;
	}





	

}
