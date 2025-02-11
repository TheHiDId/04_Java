package section01.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* File 클래스
 * 
 * - java.io 패키지
 * 
 * - 파일/디렉토리(폴더)를 관리하는 클래스
 *   (파일/디렉토리 존재 유무 관계 없음)
 *   
 * - 파일 생성, 제거, 이름, 크기, 마지막 수정일, 존재여부 등의 기능 제공 
 *   
 * - File 클래스 메서드
 * 
 * boolean  mkdir()          : 디렉토리 생성
 * boolean  mkdirs()         : 경로상의 모든 디렉토리 생성
 * boolean  createNewFile()  : 파일 생성
 * boolean  delete()         : 파일/디렉토리 삭제
 * String   getName()        : 파일 이름 반환
 * String   getParent()         : 파일이 저장된 디렉토리 반환
 * String   getPath()        : 전체 경로 반환
 * boolean  isFile()         : 현재 File 객체가 관리하는게 파일이면 true
 * boolean  isDirectory()    : 현재 File 객체가 관리하는게 디렉토리 true
 * boolean  exists()         : 파일/디렉토리가 존재하면 true, 아님 false
 * long     length()         : 파일 크기 반환
 * long     lastModified()   : 파일 마지막 수정일 (1970.01.01 09:00 부터 현재까지 지난 시간을 ms 단위로 반환)
 * String[] list()           : 디렉토리 내 파일 목록을 String[] 배열로 반환
 * File[]   listFiles()      : 디렉토리 내 파일 목록을 File[] 배열로 반환 
 */

/* [개발 상식]
 * 
 * OS: 운영 체제
 * 
 * 폴더(Windows) == 디렉토리(Linux/Mac)
 * 
 * 경로 표기 방법 -> 하위 폴더 접근방법
 * Windows: \ (백슬래시)
 * Linux/Mac: / (슬래시)
 * ex) Windows: C:\workspace\04_Java
 * 		 Linux/Mac: /Users/OOO/workspace/04_Java
 * Java는 모든 운영체제에 호환 -> 코드에서 경로 표기 시 /, \를 신경쓰지 않아도 됨
 * 
 * 최상위 경로(최상위 폴더, root)
 * Windows: C:, D:, E: 등 다수 존재
 * Linux/Mac: /
 */

public class FileService {
	/**
	 * File 클래스를 이용한 객체 생성 + 폴더 관리
	 */
	public void test1() {
		File directory = new File("C:\\workspace\\04_Java\\12_io\\io_test\\20250211"); // 실제 파일/폴더의 유무 관계없이 일단 참조
		
		System.out.println("폴더 경로: " + directory.getPath());
		System.out.println("폴더 유무: " + directory.exists());
		
		if(!directory.exists()) { // 폴더가 없다면
			if(directory.mkdirs()) {
				System.out.println("폴더가 생성되었습니다!");
			}
		} else { // 폴더가 존재한다면
			System.out.println("부모 폴더: " + directory.getParent());
			
			File parent = new File(directory.getParent());
			
			File[] files = parent.listFiles();
			
			for(File f : files) {
				f.delete(); // 자식 파일/폴더 삭제
			}
			
			if(parent.delete()) { // 부모 폴더 삭제 시 자식 폴더/파일이 존재하면 삭제 불가
				System.out.println("폴더가 삭제되었습니다!");
			}
		}
	}
	
	/**
	 * 지정된 경로에 파일 생성
	 */
	public void test2() {
		/* [절대 경로]
		 * 최상위 폴더를 기준으로 경로를 표기하는 방법
		 * 
		 * [상대 경로]
		 * 현재 위치/프로젝트를 기준으로 경로 표기하는 방법
		 */
		File folder = new File("io_test\\20250211");
		
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		File file = new File(folder.getPath() + "\\파일생성.txt");
		
		if(!file.exists()) {
			try {
				if(file.createNewFile()) {
					System.out.println("파일이 생성되었습니다!");
				} 
			} catch (IOException e) {
				System.out.println("파일 생성 중 예외 발생!");
				
				e.printStackTrace(); // 예외 발생 메서드 추적
			}
		} else {
			System.out.println(file.getName() + " 파일이 이미 존재합니다!");
		}
	}
	
	/**
	 * 입력받은 폴더에 존재하는 모든 폴더/파일 목록 출력
	 */
	public void test3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("폴더 경로 입력: ");
		String path = sc.nextLine();	
		
		File folder = new File(path); // 입력받은 폴더를 참조할 파일 객체 생성
		
		if(!folder.exists()) { // 폴더가 없을 경우
			System.out.println("잘못된 경로가 입력되었습니다!");
			
			return;
		}
		
		// 폴더 내 모든 폴더와 파일을 File[]로 반환 -> File[] listFiles();
		File[] files = folder.listFiles();
		
		for(File f : files) {
			String fileName = f.getName(); // 
			
			long lastModified = f.lastModified(); // 마지막 수정일
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a h:mm"); // 간단히 날짜 형식을 지정할 수 있는 객체
			
			String date = sdf.format(lastModified); // ms -> 날짜 형식 문자열로 변환 
			
			// 파일 유형
			String type = null;
			
			if(f.isFile()) type = "파일";
			else type = "폴더";
			
			String kb = null;
			
			if(f.isFile()) {
				long fileSize = f.length();
				
				long size = fileSize / 1024;
				
				if(size < 1) size = 1; // 1kb 미만은 1로 표기
				
				kb = size + "KB";
			}
			
			System.out.printf("%-25s %-20s %-5s %-10s\n", fileName, date, type, kb == null ? "" : kb);
		}
	}
}
