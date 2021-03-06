package studentView;

import java.util.ArrayList;
import java.util.Scanner;

import controllers.Controllers;
import professorDomain.Lecture;

public class StudentLectureListAndMenuView {

	private Scanner keyboard;

	public StudentLectureListAndMenuView() {

		keyboard = new Scanner(System.in);

	}

	public void LectureList(ArrayList<Lecture> lectureList ) {

		System.out.println("\n[ 개설강의목록 ]");
		System.out.println("강의번호\t강의명\t\t강의요일\t강의정원\t강의실번호");

		if(lectureList.size() == 0) {

			System.out.println("개설된 강의가 없습니다.");	

		} else {

			for(int i = 0 ; i < lectureList.size() ; i++) {

				System.out.print(lectureList.get(i).getLecture_number() + "\t");
				System.out.print(lectureList.get(i).getLecture_name() + "\t\t");
				System.out.print(lectureList.get(i).getLecture_time() + "\t");
				System.out.print(lectureList.get(i).getLecture_capacity() + "\t");
				System.out.println(lectureList.get(i).getLectureRoom_number());
				
			}

		}
		
		System.out.println("\n[1] 강의계획조회 [0] 이전메뉴");
		System.out.print("메뉴를 선택해주세요 : ");
		int selectedMenu = keyboard.nextInt();

		if(selectedMenu == 1) {
			
			Controllers.getStudentCourseController().requestSelectOneLecturePlan();
			
		} else if(selectedMenu == 0) {
			
			System.out.println("이전 메뉴로 이동합니다.");
			Controllers.getStudentMainController().requestStudentMenu();
			
		}else {
			
			System.out.println("메뉴를 다시 선택해 주세요.");
			Controllers.getStudentGradeController().requestStudentGradeMenuView();
			
		}
		
	}

}
