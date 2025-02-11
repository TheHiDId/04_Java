package section02.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteService {
	/* Stream(스트림)
	 * 데이터가 이동하는 통로 역할의 객체
	 * 데이터의 흐름은 기본적으로 단방향으로 흐름
	 * 
	 * [Byte 기반 Stream]
	 * 1byte 단위로 데이터를 입출력하는 스트림
	 * 최상위 클래스: InputStream, OutputStream
	 * 입출력 가능 데이터: 문자열, 파일(이미지, 영상, 오디오 등 모든 파일)
	 * 단, 2byte 범위 문자열이 깨질 수 있고 좁은 통로(1byte)를 이용하다 보니 속도가 상대적으로 느림
	 * 
	 * Stream 객체는 Java 프로그램이 종료되어도 외부 장치/파일/프로그램과의 연결이 유지되기 때문에 자동으로 사라지지 않음
	 * 따라서 프로그램 종료 전 Stream 객체의 메모리를 반환하는 close() 구문이 필수!
	 */
	
	/**
	 * 지정된 경로에 파일을 생성하고 내용을 출력 (파일 기반의 바이트 스트림 이용)
	 */
	public void fileByteOutput() {
		FileOutputStream fos = null; // fos 참조변수를 finally에서 모두 사용할 수 있게 선언
		
		try {
			// 폴더 경로, 파일명 지정
			String folderPath = "io_test\\byte";
			String fileName = "바이트기반테스트.txt";
			
			// 폴더가 없으면 생성
			File folder = new File(folderPath);
			
			if(folder.exists() == false) {
				folder.mkdirs();
			}
			
			// 출력할 파일과 연결된 출력용 스트림 객체를 생성 -> 이 때, 해당파일이 없으면 자동으로 생성
			fos = new FileOutputStream(folderPath + "\\" + fileName, true); // true: 이어쓰기 옵션
			
			// txt 파일에 출력할 내용 작성
			// StringBuilder: String의 불변성 문제를 해결하기 위한 객체
			StringBuilder builder = new StringBuilder();
			
			builder.append("Hello, World!\n");
			builder.append("1234567890\n");
			builder.append("!@#$%^&*()\n");
			builder.append("가나다라마바사\n");
			
			String content = builder.toString();
			
			// 연결된 외부 txt 파일로 content 내용을 출력
			// 방법 1. 1byte 씩 끊어서 출력
//			for(int i = 0; i < content.length(); i++) {
//				char ch = content.charAt(i); // i번째 문자 하나 반환
//				
//				// 바이트 기반 스트림 -> 1바이트 범위만 출력 가능
//				// 따라서 0 ~ 255(바이트 범위) 사이 글자는 정상 출력되고
//				// 이후 글자(한글 등)은 모두 깨져서 출력
//				fos.write(ch);
//			}
			// 방법2. String을 byte로 먼저 변환한 후 손실되는 데이터없이 출력
			byte[] bytes = content.getBytes(); // String -> byte[] 형태로 얻어오기
			
			fos.write(bytes); // 손실되는 데이터 없이 모든 문자열 출력
			
			System.out.println("출력 완료!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(fos != null) {
					fos.close(); // IOException 발생 가능성 있음
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 보조 스트림 중 BufferedOutputStream을 이용해서 출력 속도 향상
	 */
	public void bufferedFileByteOutput() {
		/* [Buffer(버퍼)]
		 * 데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 메모리의 영역
		 * 한번에 많은 양의 데이터를 이동시켜서 시간 효율을 향상
		 */
		
		// 스트림 객체 참조 변수 선언
		FileOutputStream fos = null; // 기반 스트림 (단독 사용 가능)
		BufferedOutputStream bos = null; // 보조 스트림 (단독 사용 불가능) -> 기반 스트림에 붙여서 사용
		
		try {
			// 기반 스트림 생성
			fos = new FileOutputStream("io_test\\byte\\버퍼_바이트.txt"); // 파일이 없으면 생성
			
			// 보조 스트림 생성, 생성 시 기반 스트림과 연결
			bos = new BufferedOutputStream(fos);
			
			// """ """: 내부에 작성된 모양 그대로의 문자열 생성 (Like pre태그)
			String content = """
Give me a second I,
잠깐만 시간 좀 줘,
I need to get my story straight
내 얘길 좀 정리해야겠어
My friends are in the bathroom
내 친구들은 지금 화장실에서
Getting higher than the Empire State
엠파이어스테이트 빌딩보다 높게 취했고
My lover, she’s waiting for me
내 사랑, 그녀가 날 기다리고 있어
Just across the bar
바 맞은편 쪽에서
My seat’s been taken
내가 앉을 자리엔
By some sunglasses
선글라스 낀 사람이 앉아
Asking 'bout her scar, and
흉터는 웬 거냐고 묻고 있지
I know I gave it to you months ago
알아, 그건 몇 달 전 내가 남겼단 걸
I know you’re trying to forget
알아, 너도 잊으려 노력하고 있단 걸
But between the drinks
하지만 술과 미묘한
And subtle things
일들 사이에서
The holes in my apologies, you know
사과의 말에는 허점이 생기고
I’m trying hard to take it back
나는 되돌리려 노력하고 있어
So if by the time the bar closes
그러니 바가 문 닫을 시간이 되어
And you feel like falling down
네가 쓰러질 것 같은 기분이 들면
I’ll carry you home
내가 집에 데려다 줄게

Tonight
오늘 밤
We are young
우리는 젊으니
So let’s set the world on fire
이 세상에 불을 질러 버리자
We can burn brighter than the sun
우린 태양보다 밝게 빛날 테니
Tonight
오늘 밤
We are young
우리는 젊으니
So let’s set the world on fire
이 세상에 불을 질러 버리자
We can burn brighter than the sun
우린 태양보다 밝게 빛날 테니

Now I know that I’m not
이제 나도 알아, 네겐
All that you got
나뿐이 아니란 걸
I guess that I, I just thought
아마 난, 그렇게 생각했나봐
Maybe we could find
어쩌면 갈라서는 방법을
New ways to fall apart
또 하나 찾게 될지도 모른다고
But our friends are back
하지만 친구들이 돌아왔으니
So let’s raise a toast
이제 축배를 들자
‘Cause I found someone
날 집에 데려다 줄
To carry me home
사람을 찾았으니까

Tonight
오늘 밤
We are young
우리는 젊으니
So let’s set the world on fire
이 세상에 불을 질러 버리자
We can burn brighter than the sun
우린 태양보다 밝게 빛날 테니
Tonight
오늘 밤
We are young
우리는 젊으니
So let’s set the world on fire
이 세상에 불을 질러 버리자
We can burn brighter than the sun
우린 태양보다 밝게 빛날 테니

Carry me home tonight
나를 집에 데려다 줘
Just carry me home tonight
그냥 나를 집에 데려다 줘
Carry me home tonight
나를 집에 데려다 줘
Just carry me home tonight
그냥 나를 집에 데려다 줘

The moon is on my side
저 달은 나의 편에
I have no reason to run
난 도망칠 이유 없지
So will someone come
오늘 밤 누군가 다가와
And carry me home tonight
부디 나를 집에 데려다 줘
The angels never arrived
천사는 오지 않았지만
But I can hear the choir
성가의 합창이 들려
So will someone come
누군가 다가와
And carry me home
부디 나를 집에 데려다 줘

Tonight
오늘 밤
We are young
우리는 젊으니
So let’s set the world on fire
이 세상에 불을 질러 버리자
We can burn brighter than the sun
우린 태양보다 밝게 빛날 테니
Tonight
오늘 밤
We are young
우리는 젊으니
So let’s set the world on fire
이 세상에 불을 질러 버리자
We can burn brighter than the sun
우린 태양보다 밝게 빛날 테니

So if by the time the bar closes
그러니 바가 문 닫을 시간이 되어
And you feel like falling down
네가 쓰러질 것 같은 기분이 들면
I’ll carry you home tonight
오늘 밤, 내가 집에 데려다 줄게
""";
			
			// 보조 스트림 이용해서 출력
			// 내용 출력 시 버퍼를 이용해서 한번에 출력
			bos.write(content.getBytes());;
			
			System.out.println("출력 완료!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// 사용 완료된 스트림 객체 메모리 반환
			try {
				if(bos != null) bos.close(); // 보조 스트림만 close하면 연결된 기반 스트림도 같이 close
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 파이트 기반 파일 입력 (읽어오기) 1
	 */
	public void fileByteInput() {
		FileInputStream fis = null;
		
		try {
			// 파일 입력용 바이트 기반 스트림 생성
			fis = new FileInputStream("io_test\\byte\\노래가사.txt");
			
			int value = 0;
			
			StringBuilder sb = new StringBuilder(); // 읽어온 내용 누적용 객체
			
			while(true) {
				value = fis.read(); // 파일로부터 1바이트 읽어서 반환, 호출 시 마다 다음 내용을 읽어옴, 읽어올 내용이 없으면 -1 반환
				
				if(value == -1) break;
				
				sb.append((char)value);
			}
			
			System.out.println(sb.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용 완료된 스트림 객체 메모리 반환(close())
			try {
				if(fis != null) fis.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 바이트 기반 파일 입력2 (한글 안 깨지게)
	 */
	public void fileByteInput2() {
		FileInputStream fis = null;
		
		try {
			// 파일 입력용 바이트 기반 스트림 생성
			fis = new FileInputStream("io_test\\byte\\노래가사.txt");
			
			// byte[] readAllBytes(): 연결된 파일의 내용을 모두 byte로 변환하여 읽어옴
			byte[] bytes = fis.readAllBytes();
			
			String content = new String(bytes); // byte[]을 String에 그대로 저장
			
			System.out.println(content);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// 사용 완료된 스트림 객체 메모리 반환(close())
			try {
				if(fis != null) fis.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 보조 스트림(BufferedInputStream)을 이용해서 효율적으로 파일 읽어오기
	 */
	public void bufferdFileByteInput() {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			// 파일 입력용 바이트 기반 스트림 생성
			fis = new FileInputStream("io_test\\byte\\노래가사.txt");
			
			// 보조 스트림 생성과 기반 스트림과의 연결
			bis = new BufferedInputStream(fis);
			
			// 보조 스트림을 이용해서 파일 내용을 byte로 변환해 버퍼를 이용해 한번에 읽어온 후 byte[]로 반환
			byte[] bytes = bis.readAllBytes();
			
			String content = new String(bytes);
			
			System.out.println(content);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// 사용 완료된 스트림 객체 메모리 반환(close())
			try {
				if(bis != null) bis.close(); // 보조 스트림만 close 해도 연결된 기반 스트림까지 close 됨
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * [파일 복사]
	 * <pre>
	 * 복사할 파일의 경로를 입력받아
	 * 같은 경로에 복사된 파일을 생성
	 * 
	 * 입력받은 경로에 파일이 존재하지 않으면
	 * "파일이 존재하지 않습니다!" 출력
	 * 존재하면 같은 경로에
	 * "파일명_copy.확장자" 이름으로 출력
	 * 
	 * [실행 화면]
	 * 파일 경로 입력: io_test\\byte\\노래가사.txt
	 * 복사 완료: io_test\\byte\\노래가사_copy.txt
	 * </pre>
	 */
	public void fileCopy() {
		// 스캐너, 파일 입출력 스트림, 보조 스트림 참조 변수 선언
		Scanner sc = null; // 경로 입력용
		
		FileInputStream fis = null; // 입력 기반
		FileOutputStream fos = null; // 출력 기반
		
		BufferedInputStream bis = null; // 입력 보조
		BufferedOutputStream bos = null; // 출력 보조
		
		try {
			sc = new Scanner(System.in);
			
			// 1. 파일 경로 입력
			System.out.print("파일 경로 입력: ");
			String path = sc.nextLine();
			
			// 2. 입력받은 경로의 파일과 FileInputStream 연결
			fis = new FileInputStream(path); // FileNotFoundException 발생하면 catch에서 처리
			
			// 3. 보조 입력용 스트림 생성
			bis = new BufferedInputStream(fis);
			
			// 4. 연결된 파일을 byte[]로 읽어오기
			byte[] bytes = bis.readAllBytes(); // == 읽어온 파일
			
			// 5. 입력받은 경로 파일명에 _copy 붙이기
			StringBuilder sb = new StringBuilder();
			
			sb.append(path); // 기존 경로 추가
			
			int insertPoint = sb.lastIndexOf("."); // 뒤에서 부터 검색하여 처음찾은 .의 위치(index)를 반환
			
			sb.insert(insertPoint, "_copy"); // 찾은 "." 앞에 "_copy" 삽입
			
			String copyPath = sb.toString(); // 완성된 복사본 경로
			
			// 6. 출력용 기반 스트림 객체 생성
			fos = new FileOutputStream(copyPath);
			
			// 7. 출력용 보조 스트림 객체 생성
			bos = new BufferedOutputStream(fos);
			
			// 8. 보조 스트림을 이용해서 출력
			bos.write(bytes); // 읽어온 파일(bytes) 출력
			
			System.out.println("복사 완료: " + copyPath);
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(bis != null) bis.close();
				if(bos != null) bos.close();
				if(sc != null) sc.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
